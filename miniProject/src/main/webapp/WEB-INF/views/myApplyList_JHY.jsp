<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../css/main.css" />
<body>
<%@ include file="./header_JYC.jsp"%>
<main>
<hr>
<h2>지원 현황 목록</h2>
<table border="1">
	<c:forEach var="applyResume" items="${myApplyList }" varStatus="status">
		<tr>
			<td>${applyResume.cname }</td>
			<td>${applyResume.entitle }</td>
			<td>${applyResume.applydate }</td>
			<td><input type="button" name="scrap" value="스크랩"></td>
			<td><c:if test="${applyResume.arpass == 0}">불합격</c:if>
				<c:if test="${applyResume.arpass == 1}">합격</c:if>
				<c:if test="${applyResume.arpass == 2}">심사중</c:if></td>
			<td>${applyResume.ipass }</td>
			<td><input type="button" name="score" value="평점쓰기"></td>
		</tr>
	</c:forEach>
</table>
</main>
<%@ include file="./footer_JYC.jsp"%>
</body>
</html>