<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
	$(function(){
		$("#btnWrite").click(function() {
			location.href="${path}/board/write.do";
		});
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
	<h2>게시판</h2>
	<button type="button" id="btnWrite"  style="align-items: center;">글쓰기</button>
	<input value="'${map.count}'개의 게시물이 있습니다." style="align-items: center;">
	<table border="1" width="600px">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>이름</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="row" items="${map.list}">
			<tr>
				<td>${row.bno}</td>
				<td>${row.title}</td>
				<td>${row.name}</td>
				<td> <fmt:formatDate value="${row.regdate}" 
									pattern="yyyy-MM-dd HH:mm:ss "/>
					
				</td>
				<td>${row.viewcnt }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>