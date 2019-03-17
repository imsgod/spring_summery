<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script src="${path}/ckeditor/ckeditor.js"></script>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>

<script>
	function product_write() {
		// 태그를 name으로 조회할 경우
		// var product_name = document.form1.product_name.value;
		//태그 id로 조회할 경우
		var product_name = $("product_name").val();
		var price = $("price").val();
		var decription = $("description").val();
		if (product_name == "") {
			alert("상품 이름을 입력하세요.");
			$("#product_name").focus();
			return;
		}
		if (price == "") {
			alert("가격을 입력 하세요.")
			$("#price").focus();
			return;
		}
		/* if (description == "") {
			alert("상품 성명을 입력하세요.")
			$("#description").focus();
			return;
		} */
		
		document.form1.action = "${path}/shop/product/insert.do";
		document.form1.submit();
		
	}
</script>

<h2>상품 등록</h2><br>

<form name="form1" method="post" 
	  enctype="multipart/form-data">
	  <table>
	  	<tr>
	  		<td>상품명</td>
	  		<td>
	  			<input name="product_name" id="product_name">
	  		</td>
	  	</tr>
	  	<tr>
			<td>가격</td>
			<td>
				<input name="price" id="price">
			</td>
	  	</tr>
	  	<tr>
	  		<td>상품 설명</td>
	  		<td>
	  			<textarea rows="5" cols="60" name="description" id="description"></textarea>
	  			<script>
	  				//CKEDITOR.replace("description")
	  				CKEDITOR.replace("description",{
	  					filebrowserUploadUrl : "${path}/imageUpload.do"
	  				});
	  			</script>
	  		</td>
	  	</tr>
	  	<tr>
	  		<td>상품 이미지</td>
	  		<td>
	  		 	<input type="file" name="file1" id="file1">
	  		</td>
	  	</tr>
	  	<tr>
	  		<td colspan="2" align="center">
	  			<input type="button" value="등록" onclick="product_write()">
	  			<input type="button"  value="목록" onclick="location.href='${path}/shop/product/list.do'">
	  		</td>
	  	</tr>
	  </table>
</form>

</body>
</html>