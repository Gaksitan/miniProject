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
<c:if test="${subscribeList != null }">
<table border="1">
	<caption>구독</caption>
	<thead>
		<tr>
			<th>회사명</th><th>기업형태</th><th>업종</th><th>소개글</th><th>구독</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="subscribe" items="${subscribeList }" varStatus="status">
			<tr>
				<td>${subscribe.cname }</td>
				<td>${subscribe.ctype }</td>
				<td>
					<c:forEach var="scnames" items="${scnameList.get(status.index) }" varStatus="i">
					<c:if test="${!i.last }">
					<span>${scnames }</span>, 
					</c:if>
					<c:if test="${i.last }">
					<span>${scnames }</span>
					</c:if>
					</c:forEach>
				</td>
				<td>${subscribe.cintro }</td>
				<td><input type="button" value="구독" id="subscribeButton"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
<c:if test="${scrapList != null }">
<table border="1">
	<caption>스크랩</caption>
	<thead>
		<tr>
			<th>회사명</th><th>채용공고 제목</th><th>포지션</th><th>스크랩</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="scrap" items="${scrapList }">
		<tr>
			<td>${scrap.cname }</td>
			<td>${scrap.entitle }</td>
			<td>${scrap.enposition }</td>
			<td><input type="button" value="스크랩" onclick=""></td>
		</tr>
		</c:forEach>
	</tbody>
	<tbody>
	</tbody>
</table>
</c:if>
<%@ include file="./footer_JYC.jsp"%>
</body>
</html>