<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
	<h2>상품 목록</h2>
	<table border="1" width="500px">
		<tr>	
			<td>상품 코드</td>
			<td> &nbsp; </td>
			<td>상품명</td>
			<td>가격</td>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.product_id}</td>
				<td> <img src="${path}/images/${row.picture_url}" width="100px" height="100px"> 
				</td>
				<td> <a href="${path}/shop/product/detail/${row.product_id}">
					 ${row.product_name} </a>
					 <c:if test="${sessionScope.admin_userid != null}">
					 	<br>
					 	<a href="${path}/shop/product/edit/${row.product_id}">
					 	[편 집]</a>
					 </c:if>
				</td>
				<td> <fmt:formatNumber value="${row.price}" pattern="#,###"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>