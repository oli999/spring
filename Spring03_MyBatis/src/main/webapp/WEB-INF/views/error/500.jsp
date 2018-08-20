<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error/500.jsp</title>
</head>
<body>
<p>요청 처리중에 알수 없는 오류가 발생했습니다.</p>
<p>조속히 복구 하겠습니다.</p>
<p>${exception.message }</p>
<a href="${pageContext.request.contextPath }/">인덱스로 가기</a>
</body>
</html>