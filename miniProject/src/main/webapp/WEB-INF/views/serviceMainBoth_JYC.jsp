<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
main {
	text-align: center;
}
</style>

</head>
<body>
	<%@ include file="./header_JYC.jsp"%>
	<!-- 헤더부분 포함 -->
	<main>
		<h1>고객센터 메인</h1>
		<input type="search" placeholder="FAQ 검색"> <input
			type="submit" value="검색">
		<button onclick="location.href='#'">문의하기</button>
		<table>
			<thead>
				<tr>
					<th>질문</th>
					<th>답변</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="service" items="${list }" varStatus="status">
					<tr>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<%@ include file="./footer_JYC.jsp"%>
	<!-- 푸터부분 포함 -->
</body>
</html>