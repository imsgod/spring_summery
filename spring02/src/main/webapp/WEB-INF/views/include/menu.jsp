<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<script src="${path}/include/jquery-3.2.1.min.js"></script>
<link href="${path}/summernote/bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="${path}/summernote/bootstrap/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="${path}/summernote/summernote.css" rel="stylesheet">
<script src="${path}/summernote/summernote.js"></script> 

 <a href="${path}"> home </a> |
 <a href="${path}/memo/list.do"> MEMO </a> |
 <a href="${path}/board/list.do">게시판</a> |
 <a href="${path}/upload/uploadForm">업로드 테스트</a> |
 <a href="${path}/upload/uploadAjax">업로드(Ajax)</a> |
 <a href="${path}/shop/product/list.do">상품 목록</a> |

 <c:if test="${sessionScope.admin_userid != null }">
 	<a href="${path}/shop/product/write.do"> 상품등록 </a> |
 </c:if>
 <c:if test="${sessionScope.userid != null }">
 	<a href="${path}/shop/cart/list.do"> 장바구니 </a> |
 </c:if>
 

 
 <div style="text-align: right;">
 	<c:choose> 
 		<c:when test="${sessionScope.userid == null }">
 			<a href="${path}/member/login.do"> 로그인 </a> |
 			<a href="${path}/admin/login.do"> 관리자 로그인</a>
 		</c:when>
 		
 		<c:otherwise>
 			${sessionScope.name}님! 로그인 하셨습니다. <br>
 			<a href="${path}/member/logout.do">로그 아웃</a>
 		</c:otherwise>
 	</c:choose>
 	
 </div>
 <hr>
 
