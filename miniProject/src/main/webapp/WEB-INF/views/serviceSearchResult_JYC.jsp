<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="./header_JYC.jsp"%>
	<main>
		<c:if test="${companyManager == null }">
			<form action="/service/searchMem">
				<input type="search" placeholder="FAQ 검색" name="keyword"> <input
					type="submit" value="검색">
			</form>
		</c:if>
		<c:if test="${companyManager != null }">
			<form action="/service/searchCom">
				<input type="search" placeholder="FAQ 검색" name="keyword"> <input
					type="submit" value="검색">
			</form>
		</c:if>

		<table>
			<tbody>
				<c:forEach var="faq" items="${faqlist }">
					<tr>
						<td>${faq.qcname}</td>
						<td><a href="/service/faqDetail?">${faq.faqquestion }</a></td>							
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>

	<%@ include file="./footer_JYC.jsp"%>
</body>
</html>