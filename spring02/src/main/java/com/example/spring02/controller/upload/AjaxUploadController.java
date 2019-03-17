package com.example.spring02.controller.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring02.util.MediaUtils;
import com.example.spring02.util.UploadFileUtils;

@Controller
public class AjaxUploadController {
	private static final Logger LOGGERS = LoggerFactory.getLogger(AjaxUploadController.class);
	
	//servlet-context 설정되어있음.
	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value="/upload/uploadAjax",
					method=RequestMethod.GET)
	public String uploadAjax() {
		return "/upload/uploadAjax";
	}
	
	@ResponseBody
	@RequestMapping(value="/upload/uploadAjax",
					method=RequestMethod.POST, 
					produces = "text/plain;charset=utf-8") //한글이 깨지 않도록
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
	
		return new ResponseEntity<String>(
				UploadFileUtils.uploadFile(uploadPath, 
											file.getOriginalFilename().replaceAll(" ", ""), 
											file.getBytes()), HttpStatus.OK);
				
	}
	 //이미지 표시 기능
	@ResponseBody // view가 아닌 data
	@RequestMapping("/upload/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		try {
			//확장자 검사
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			// 헤더 구성 객체, http header flag
			HttpHeaders headers = new HttpHeaders();
			// InputStream 생성
			in = new FileInputStream(uploadPath + fileName); 
			
			if (mType != null) { //이미지 파일
				headers.setContentType(mType); //헤더에 이미지파일 이라고 플레그 해줌
			} else { //이미지 파일이 아니면
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				// 이미지 외에 어떤파일이 올지 모르니 범용적으로 애플리케이션으로 인식
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
				// 한글이 깨질수 있기때문에
				headers.add("Content-Disposition", "attachment; filename=\"" + 
									new String(fileName.getBytes("utf-8"),"iso-8859-1") + "\"");
			}
			
			entity = new ResponseEntity<byte[]>(
					IOUtils.toByteArray(in), headers, HttpStatus.OK);
					
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(
						HttpStatus.BAD_REQUEST);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return entity;
	} 
	
 	@ResponseBody
	@RequestMapping(value = "/upload/deleteFile", 
						method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) {
		LOGGERS.info("fileName : " + fileName);
		//확장자 검사
		String formantName = fileName.substring(fileName.lastIndexOf(".")+ 1);
		
		MediaType mType = MediaUtils.getMediaType(formantName);
		
		if (mType != null) { //이미지 파일이면, 원본이미지 삭제
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			
		 new File(uploadPath + (front + end).
								replace('/', File.separatorChar)).delete(); 
			 
		}
		// 원본 파일 삭제.(이미지면 썸네일 삭제)
		 new File(uploadPath + fileName.
								replace('/', File.separatorChar)).delete(); 
		 
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	} 
	 
	
 
		
}
