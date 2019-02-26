package com.example.spring02.controller.upload;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	private static final Logger LOGGERS  = LoggerFactory.getLogger(UploadController.class);
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	@RequestMapping(value="/upload/uploadForm", method = RequestMethod.GET)
	public String uploadForm() {
		return "upload/uploadForm";
	}
	
	@RequestMapping(value="upload/uploadForm", method = RequestMethod.POST)
	public ModelAndView uploadForm(MultipartFile file, ModelAndView mav) throws Exception {
		String savedName = file.getOriginalFilename();
		savedName = uploadFile(savedName, file.getBytes());
		mav.setViewName("upload/uploadResult");
		mav.addObject("savedName", savedName);
		return mav;
	}

	private String uploadFile(String originalName, byte[] fileDate) throws Exception  {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + " _ " + originalName;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileDate, target);
		return savedName;
	}
}
