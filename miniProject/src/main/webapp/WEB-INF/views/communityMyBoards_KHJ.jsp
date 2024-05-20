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
				<td>${list.btitle }</td>
				<td>${list.blike }</td>
				<td>${list.bregdate }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
</body>
</html>