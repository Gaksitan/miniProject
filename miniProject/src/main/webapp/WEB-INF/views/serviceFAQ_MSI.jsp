<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>FAQ 관리페이지</h1>

<table  border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
	<caption>질문(개인)</caption>
	<thead>
		<tr>
			<th>질문</th>
			<th>답변</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="faq" items="${faqList}" >
			<c:if test="${faq.faqtarget == 'member'}">
				<tr>
					<td>${faq.faqquestion}</td>
					<td>${faq.faqanswer}</td>
				</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>


<table border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
	<caption>질문(기업)</caption>
	<thead>
		<tr>
			<th>질문</th>
			<th>답변</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="faq" items="${faqList}" >
			<c:if test="${faq.faqtarget == 'company'}">
				<tr>
					<td>${faq.faqquestion}</td>
					<td>${faq.faqanswer}</td>
				</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>

<div>
	<a href="/admin/serviceFAQWrite">FAQ 작성하기</a>
	<a href="/admin/serviceQuestionNoAnswer">미답변 질문 확인하기</a>
</div>


</body>
</html>