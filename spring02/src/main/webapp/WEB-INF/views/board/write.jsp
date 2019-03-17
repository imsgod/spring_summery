<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<style>
	.fileDrop {
		width: 600px;
		height: 100px;
		border: 1px dotted gray;
		background-color: gray;
	}
</style>

<script src="${path}/include/js/comon.js"></script>
<script src="${path}/ckeditor/ckeditor.js"></script>

<script>
	$(function(){
		$("#btnSave").click(function(){
			var str = "";
			$("#uploadedList .file").each(function(i){
				str +="<input type='hidden' name='files[" + i + "]' value ='" +
						$(this).val() + "'>";
			});
			$("#form1").append(str);
			document.form1.submit();
		}); //end btnSave
		
		$(".fileDrop").on("dragenter dragover", function(e){
			e.preventDefault();
		});
		
		$(".fileDrop").on("drop", function(e){
			e.preventDefault();
			
			var files = e.originalEvent.dataTransfer.files;
			var file = files[0];
			var formData = new FormData();
			
			formData.append("file", file);
			
			$.ajax({
				url : "${path}/upload/uploadAjax",
				data : formData,
				dataType : "text",
				processData : false,
				contentType : false,
				type : "post",
				success : function(data) {
					console.log(data);
					var fileInfo = getFileInfo(data);
					console.log(fileInfo);
					var html = "<a href='" + fileInfo.getLink + "'>" +
							 	fileInfo.fileName + "</a><br>";
						html += "<input type='hidden' class='file' value='" + 
								fileInfo.fullName + "'>";
					
					$("#uploadedList").append(html);
				}
			}); // end ajax
		}); // end $(".fileDrop").on("drop", function(e)
		
	}); //end
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
	<h2>글쓰기</h2>
	<form id="form1" name="form1" method="post"
		action="${path}/board/insert.do">
		<div>
			제목 : <input name="title" id="title" size="80"
							placeholder="제목을 입력 하세요.">
		</div>
		<div style="width: 800px;">
			내용 :  <textarea rows="3" cols="80" id="content" 
						name="content" placeholder="내용을 입력해 주세요."></textarea>
						<script>
							CKEDITOR.replace("content",{
								filebrowserUploadUrl : "${path}/imageUpload.do"
							});
						</script>
		</div>
		<br>
		<div>
			첨부 파일을 등록 하세요. <br>
			<div class="fileDrop"></div>
			<div id="uploadedList"></div>
		</div>
		<br>
		<div style="width: 700px; text-align: center;">
			<button type="button" id="btnSave">확인</button>
		</div>
	</form>
</body>
</html>