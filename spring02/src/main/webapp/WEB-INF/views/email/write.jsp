<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<link href="${path}/summernote/bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="${path}/summernote/bootstrap/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="${path}/summernote/summernote.css" rel="stylesheet">
<script src="${path}/summernote/summernote.js"></script> 
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
	<h2>이메일 보내기</h2>
	<form action="${path}/email/send.do"
		  method="post">
		  발신자 이름 : <input name="senderName"> <br>
		  발신자 이메일 : <input name="senderMail"> <br>
		  수신자 이메일 : <input name="receiveMail"> <br>
		  제목 : <input name="subject"><br>
		  내용 : <textarea rows="5" cols="80" name="message"></textarea>
		  <br>
		  <input type="submit" value="전송">
	</form>
	<span style="color: red;">${message}</span>
</body>
</html>