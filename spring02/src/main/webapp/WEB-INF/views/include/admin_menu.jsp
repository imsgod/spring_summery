<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<script src="${path}/include/jquery-3.2.1.min.js"></script>

 
<a href="${path}/shop/product/list.do">상품 목록</a> |
<a href="${path}/shop/product/write.do">상품 등록</a> |
<a href="${path}/pdf/list.do">PDF</a> |

<a href="${path}/chart/chart1.do">Google Chart(json)</a> |
<a href="${path}/chart/chart2.do">Google Chart(db)</a> |

<a href="${path}/jchart/chart1.do">JFree Chart(png)</a> |
<a href="${path}/jchart/chart2.do">JFree Chart(pdf)</a> |
 
 <div style="text-align: right;">
 	<c:choose> 
 		<c:when test="${sessionScope.admin_userid == null }">
 			<a href="${path}/admin/login.do"> 관리자 로그인</a>
 		</c:when>
 		 
 		<c:otherwise>
 			${sessionScope.admin_name}님! 로그인 하셨습니다. <br>
 			<a href="${path}/admin/logout.do">로그 아웃</a>
 		</c:otherwise>
 	</c:choose>
 	
 </div>
 <hr>
 
