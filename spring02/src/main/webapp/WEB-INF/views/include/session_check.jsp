<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--  <c:set var="path" value="${pageContext.request.contextPath}"></c:set> --%>
 <c:if test="${sessionScope.admin_userid == null }">
 	<script>
 		alert("Please Login ");
 		location.href="${path}/admin/login.do";
 	</script>
 </c:if>