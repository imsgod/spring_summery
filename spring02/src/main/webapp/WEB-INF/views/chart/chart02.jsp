<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
 
<%-- <%@ include file="../include/session_check.jsp" %> --%> 
<script type="text/javascript" src="https://www.google.com/jsapi"></script>

<script>
	google.load("visualization", "1", {
		"packages" : ["corechart"]
	});
	google.setOnLoadCallback(drawChart);
	function drawChart() {
		var jsonData=$.ajax({
			url : "${path}/chart/cart_money_list.do",
			dataType : "json",
			async : false
		}).responseText;
		console.log(jsonData);
		
		var data = new google.visualization.DataTable(jsonData);
 
		var chart = new google.visualization.ColumnChart(
				document.getElementById("chart_div")); 
			chart.draw(data,{
				title : "차트 예제",
				width : 600,
				height : 400
			});
	}
</script>

</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
	<div id="chart_div"></div>
	<button id="btn" type="button" onclick="drawChart">refresh2</button>
</body>
</html>