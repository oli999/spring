<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/login.jsp</title>
</head>
<body>
<c:choose>
	<c:when test="${isLoginSuccess }">
		<p> <strong>${id }</strong> 님 로그인 되었습니다.</p>
		<a href="${url }">확인</a>
	</c:when>
	<c:otherwise>
		<p> 아이디 혹은 비밀번호가 틀려요.</p>
		<a href="loginform.do?url=${url }">확인</a>
	</c:otherwise>
</c:choose>
</body>
</html>





