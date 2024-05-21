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
<%@ include file="./header_JYC.jsp"%>
<hr>
<table border="1">
	<thead>
		<tr>
			<th>회사명</th><th>테마/소개글</th><th>구독</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="subscribe" items="${subscribeList }" varStatus="status">
			<tr>
				<td>${subscribe.cname }</td>
				<td>${subscribe.csname }/${subscribe.cintro }</td>
				<td><input type="button" value="구독" id="subscribeButton"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<table border="1">
	<thead>
		<tr>
			<th>회사명</th><th>채용공고</th><th>테마/소개글</th><th>스크랩</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="scrap" items="${scrapList }" varStatus="status">
			<tr>
				<td>${scrap.cname }</td>
				<td>${scrap.entitle }</td>
				<td>${scrap.enposition }/${scrap.enintro }</td>
				<td><input type="button" value="스크랩" id="scrapButton"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="./footer_JYC.jsp"%>
</body>
</html>