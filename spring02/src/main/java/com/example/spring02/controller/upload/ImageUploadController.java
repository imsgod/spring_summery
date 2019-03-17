package com.example.spring02.controller.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUploadController {
	
	@RequestMapping("imageUpload.do")
	public void imageUpload(HttpServletRequest req, 
							HttpServletResponse res,
							MultipartFile upload) throws Exception {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		String fileName = upload.getOriginalFilename();
		byte[] bytes = upload.getBytes();
		//String uplodPath = "파일 업로드 디렉토리(배포경로)";
		String uplodPath = 
"D:\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images\\";
		OutputStream out = new FileOutputStream(new File(uplodPath + fileName));
		//서버 업로드
		out.write(bytes);
		// 클라이언트에 결과 표시
		String callBack = req.getParameter("CKEditorFuncNum");
		// 서버 -> 클라이언트로 텍스트 전송(자바스크립트 실행)
		PrintWriter printWriter = res.getWriter();
		String fileUrl = req.getContextPath() + "/images/" +
						fileName;
		
		printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction("
							+ callBack +",'" + fileUrl + "',' 이미지가 업로드 되었습니다.')"
							+ "</script>");
		
		printWriter.flush();
			 
	}
}
