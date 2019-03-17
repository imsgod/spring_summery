 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<!-- include libraries(jQuery, bootstrap) -->
<%-- --%><link href="${path}/summernote/bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="${path}/summernote/bootstrap/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="${path}/summernote/summernote.css" rel="stylesheet">
<script src="${path}/summernote/summernote.js"></script> 

 

<script>
$(function() {
	$("#memo").summernote({
		height : 150,
		width : 600
	});
});
	
	function memo_view(idx) {
		location.href = "${path}/memo/view/" + idx;
	}
</script>
</head>
<body>


<%@ include file="../include/menu.jsp" %>
<h2>메모장</h2>
	<form method="post" action="${path}/memo/insert.do">
	이름 : <input name="writer" size = "10"> <br> 
	메모 :<!--  <input id= "memo" name="memo" size="40"> -->
	<textarea rows="3" cols="50" name="memo" id="memo"></textarea>
	<input type="submit" value="확인">
	<input type="submit" value="확인">
	</form>
	<table border="1" width="500px">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>메모</td>
			<td>날짜</td>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.idx}</td>
				<td>${row.writer}</td>
				<td> <a href="#" onclick="memo_view('${row.idx}')">
					${row.memo}</a>
				</td>
				<td> <fmt:formatDate value="${row.post_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			</tr>
		</c:forEach>  
	</table>	
</body>
</html>