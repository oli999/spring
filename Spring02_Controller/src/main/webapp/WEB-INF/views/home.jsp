<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>home.jsp</title>
</head>
<body>
<h3>인덱스 페이지 입니다.</h3>
<ul>
	<li><a href="fortune.do">오늘의 운세</a></li>
	<li><a href="person.do">오늘의 인물</a></li>
	<li><a href="json/test01.do">JSON 문자열 응답</a></li>
	<li><a href="json/test02.do">JSON 문자열 응답2</a></li>
	<li><a href="json/test03.do">JSON 3</a></li>
	<li><a href="json/test04.do">JSON 4</a></li>
	<li><a href="json/test05.do">JSON 5</a></li>
	<li><a href="json/test06.do">JSON 6</a></li>
</ul>
<button id="myBtn">눌러보셈</button>
<script src="resources/js/jquery-3.3.1.js"></script>
<script>
	$("#myBtn").click(function(){
		$.ajax({
			url:"json/test02.do",
			method:"GET",
			success:function(data){
				console.log(data);
			}
		});
	});
</script>
</body>
</html>









