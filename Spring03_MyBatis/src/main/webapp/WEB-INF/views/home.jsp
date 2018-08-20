<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
<h3>인덱스 페이지 입니다.</h3>
<!-- session 영역에 id 가 비어 있지않으면 (로그인 된 상태라면) -->
<c:if test="${ not empty id }">
	<p> 
		<strong><a href="users/info.do">${id }</a></strong> 
		님 로그인중...
	</p>
	<a href="users/logout.do">로그아웃</a>
</c:if>
<ul>
	<li><a href="member/list.do">회원 목록 보기</a></li>
	<li><a href="users/signup_form.do">회원가입</a></li>
	<li><a href="users/loginform.do">로그인하기</a></li>
	<li><a href="file/list.do">자료실 목록 보기</a></li>
	<li><a href="cafe/list.do">카페 글 목록 보기</a></li>
	<li><a href="shop/list.do">상품 목록 보기</a></li>
</ul>
</body>
</html>













