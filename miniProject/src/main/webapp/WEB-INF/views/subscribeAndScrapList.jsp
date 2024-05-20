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
<h1>구독 & 스크랩 목록 페이지 개인회원용 헤더 위치</h1>
<hr>
<table border="1">
	<thead>
		<tr>
			<th>순번</th><th>회사명</th><th>테마/소개글</th><th>구독</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="${subscribe }" items="" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<table border="1">

</table>
</body>
</html>