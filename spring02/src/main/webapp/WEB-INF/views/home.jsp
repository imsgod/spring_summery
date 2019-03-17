<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>Home</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
<%@ include file="include/menu.jsp" %>

<c:if test="${sessionScope.userid != null}">
	<h2>${sessionScope.name}  <br>
	(ID : ${sessionScope.userid}님의 방문을 환영합니다.).
	</h2>
</c:if>

<h1>
	환영 환영 환영
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<%-- 실제로 서비스되는 디렉토리(배포 디렉토리)--%>
	<%= application.getRealPath("WEB-IF/views/images/") %>
</body>
</html>
