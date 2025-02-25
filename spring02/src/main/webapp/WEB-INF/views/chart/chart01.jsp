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
			url : "${path}/json/sampleData.json",
			dataType : "json",
			async : false
		}).responseText;
		console.log(jsonData);
		
		var data = new google.visualization.DataTable(jsonData);
		/* 파이차트
			var chart = new google.visualization.PieChart(
								document.getElementById("chart_div")); 
		*/
		/* 라인차트
		var chart = new google.visualization.LineChart(
				document.getElementById("chart_div")); 
		*/
		var chart = new google.visualization.ColumnChart(
				document.getElementById("chart_div")); 
			chart.draw(data,{
				title : "차트 예제",
				/*curveType : "function", pie chart 옵션이 아닌 line chart 옵션만 */
				width : 600,
				height : 400
			});
	}
</script>

</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
	<div id="chart_div"></div>
	<button id="btn" type="button" onclick="drawChart()">refresh</button>
</body>
</html>