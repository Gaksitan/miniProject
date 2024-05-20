<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>개인회원용 헤더 위치</h1>
<c:if test="${sessionScope.mid != null }">
<h2>${sessionScope.mid }님 환영합니다.</h2>
</c:if>
<hr>
<c:if test="${sessionScope.mid == null }">
<a href="regFormMem">회원가입</a><br>
<a href="loginForm">로그인</a>
</c:if>
<c:if test="${sessionScope.mid != null }">
<a href="logout">로그아웃</a>
</c:if>
</body>
</html>