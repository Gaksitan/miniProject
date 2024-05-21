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

#faqtable{
	margin: 0;
}
</style>

</head>
<body>
	<%@ include file="./header_JYC.jsp"%>
	<!-- 헤더부분 포함 -->
	<main>
		<c:if test="${companyManager == null }"> <!-- cno가 널이면 기업회원이 아니기 때문에 이 단락을 보여준다 -->
		<h1>고객센터 메인</h1>
		<form action="/service/searchMem">
		<input type="search" placeholder="FAQ 검색" name="keyword"> 
		<input type="submit" value="검색">
		</form>
			<c:if test="${mid != null }"> <!-- mid가 널이 아니명 개인회원이기 때문에 문의하기 기능을 선택할 수 있다. -->	
				<button onclick="location.href='/both/registQuestionForm'">문의하기</button>
			</c:if>
		<table border="1" id="faqtable">
			<caption>개인.비회원용</caption>
			<thead>
				<tr>
					<th>카테고리</th>
					<th>답변</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="faq" items="${faqlist }" varStatus="status">
					<tr>
						<td>${faq.qcname }</td>
						<td><a href="#">${faq.faqanswer }</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		
		<c:if test="${companyManager != null }"> <!-- cno가 널이 아니면 기업회원이기 때문에 이 단락을 보여준다 -->
		<h1>고객센터 메인</h1>
		<form action="/service/searchCom">
		<input type="search" placeholder="FAQ 검색" name="keyword"> 
		<input type="submit" value="검색">
		</form>
		<button onclick="location.href='/both/registQuestionForm'">문의하기</button>
		<table>
			<caption>기업용</caption>
			<thead>
				<tr>
					<th>카테고리</th>
					<th>질문</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="faq" items="${faqlist }" varStatus="status">
					<tr>
						<td>${faq.qcname }</td>
						<td><a href="#">${faq.question }</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		

	</main>
	<%@ include file="./footer_JYC.jsp"%>
	<!-- 푸터부분 포함 -->
</body>
</html>