<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>

</style>
</head>
<body>
	<%@ include file="./header_JYC.jsp" %>
	<h1>내 게시글 페이지</h1>
	<hr>
	<h2>내가 쓴 게시글 목록</h2>
	<table border="1">
		<thead>
			<tr>
				<th>게시글 번호</th><th>제목</th><th>좋아요</th><th>작성일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${myList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="/commu/communityDetail_KHJ?bno=${list.bno}">${list.btitle }</td>
				<td>${list.blike }</td>
				<td>${list.bregdate }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h2>내가 쓴 댓글 목록</h2>
	<table board="1">
		<thead>
			<tr>
				<th>번호</th><th>댓글 내용</th><th>작성일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="replyList" items="${replyList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${replyList.recontent }</td>
				<td>${replyList.reregdate }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>나에게 쓴 글</h2>
	<table board="1">
		<thead>
			<tr>
				<th>게시글 번호</th><th>게시글 제목</th><th>작성일자</th><th>작성자</th><th>좋아요</th>
			</tr>			
		</thead>
		<tbody>
			<c:forEach var="toMeList" items="${toMeList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${toMeList.btitle }</td>
				<td>${toMeList.bregdate }</td>
				<td>${toMeList.mid }</td>
				<td>${toMeList.blike }</td>
			</tr>
			</c:forEach>
		</tbody>
	
	</table>
		<%@ include file="./footer_JYC.jsp" %>
</body>
</html>