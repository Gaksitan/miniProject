<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	

</style>
<link rel="stylesheet" href="../css/main.css" />

</head>
<body>

	<%@ include file="./header_JYC.jsp" %>
	
	<main>
	<h1>내 문의사항 상세 페이지(회원용)</h1>
	
	<h2>${sq.sqtitle }</h2>
	<span>카테고리 - ${category }</span>
	<h2>질문 내용</h2>
	<p>${sq.sqcontent }</p>
	
	<h2>답변</h2>
	<c:if test="${sq.sqanswertf == false }">
		<p style="color: red;">답변 미완성</p>
	</c:if>
	<c:if test="${sq.sqanswertf == true }">
		<p>${answer }</p>
	</c:if>
	
	<c:if test="${mid != null }">
	<input type="button" value="뒤로가기" style="color:blue" onclick="location.href='/service/myQuestionMem'">
	<c:if test="${sq.sqanswertf == false }">
	<input type="button" value="삭제" style="color:red" onclick="location.href='/service/deleteServiceQuestionMem?sqno=${sq.sqno }'">
	</c:if>
	</c:if>
	<c:if test="${companyManager != null }">
	<input type="button" value="뒤로가기" style="color:blue" onclick="location.href='/service/myQuestionCom'">
	<c:if test="${sq.sqanswertf == false }">
	<input type="button" value="삭제" style="color:red" onclick="location.href='/service/deleteServiceQuestionCom?sqno=${sq.sqno }'">
	</c:if>
	</c:if>
	</main>
	
	<%@ include file="./footer_JYC.jsp" %>
</body>
</html>