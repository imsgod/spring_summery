<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>

<script >
	$(function() {
		
		$("#btnList").click(function() {
			location.href = "${path}/shop/product/list.do";
		});
		
		$("#btnDelete").click(function(){
			if (confirm("장바구니를 비우시겠습니까?")) {
				location.href ="${path}/shop/cart/deleteAll.do";
			}
		});
	});
</script>

</head>
<body>
<%@ include file="../include/menu.jsp" %>
	<h2> 장바구니 </h2>
		<c:choose>
			<c:when test="${map.count == 0}">
				장바구니가 비었습니다.
			</c:when>
				
			<c:otherwise>
				<form name="form1" method="post" 
					  action="${path}/shop/cart/update.do">	
					<table border="1" width="500px">
						<tr>	
							<td>상품명</td>
							<td>단가</td>
							<td>수량</td>
							<td>금액</td>
							<td>&nbsp;</td>
						</tr>
						<c:forEach var="row" items="${map.list}">
							<tr>    
								<td>${row.product_name}</td>
								<td><fmt:formatNumber value="${row.price}" pattern="#,###"/> 원</td>
								<td>
									<input type="number" name="amount" value="${row.amount}">
									<input type="hidden" name="cart_id" value="${row.cart_id}">
								</td>
								<td><fmt:formatNumber value="${row.money}" pattern="#,###"/> 원</td>
								<td>
									<c:if test="${sessionScope.userid != null}">
										<a href="${path}/shop/cart/delete.do?cart_id=${row.cart_id}">
						   				삭제</a>
					   				</c:if>
								</td>
							</tr>   
						</c:forEach>
						
						<tr>
							<td colspan="5" align="right">
								장바구니 급액 합계 : <fmt:formatNumber value="${map.sumMoney}" pattern="#,###"/> 원<br> 
								배송료 : <fmt:formatNumber value="${map.fee}" pattern="#,###"/> 원 <br>
								총 합계 : <fmt:formatNumber value="${map.sum}" pattern="#,###"/> 원
							</td> 
						</tr>
					</table>
					<button id="btnUpdate"> 수정 </button> <br>
					<button type="button" id="btnDelete"> 장바구니 비우기</button>
				</form>
			</c:otherwise>
		</c:choose>
		
		<button type="button" id="btnList"> 상품 목록</button>
</body>
</html>