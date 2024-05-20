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
<h1>지원 현황 목록 페이지 개인회원용 헤더 위치</h1>
<hr>
<h2>지원 현황 목록</h2>
<table border="1">
	<c:forEach var="applyResume" items="${myApplyList }" varStatus="status">
		<tr>
			<td>${applyResume.cname }</td>
			<td>${applyResume.entitle }</td>
			<td>${applyResume.applydate }</td>
			<td><input type="button" name="scrap" value="스크랩"></td>
			<td>${applyResume.arpass }</td>
			<td>${applyResume.ipass }</td>
			<td><input type="button" name="score" value="평점쓰기"></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>