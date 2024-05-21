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
	<%@ include file="./header_JYC" %>
	
	<main>
	<h1>내 문의사항 상세 페이지(회원용)</h1>
	
	<h2>${sq.sqtitle }</h2>
	<span>${sq.qcno }</span>
	<p>${sq.sqcontent}</p>
	
	<c:if test="${sq.sqanswer == null }">
	<p>답변 미등록</p>
	</c:if>
	<c:if test="${sq.sqanser != null }">
	<p>${sq.sqanswer }</p> 
	</c:if>
	
	<c:if test="${mid != null }">
	<input type="button" value="뒤로가기" style="color:blue" onclick="location.href='/service/myQuestionMem'">
	<input type="button" value="삭제" style="color:red" onclick="/service/deleteServiceQuestionMem?sqno=${sq.sqno }">
	</c:if>
	<c:if test="${cno != null }">
	<input type="button" value="뒤로가기" style="color:blue" onclick="location.href='/service/myQuestionCom'">
	<input type="button" value="삭제" style="color:red" onclick="/service/deleteServiceQuestionCom?sqno=${sq.sqno }">
	</c:if>
	</main>
	
	<%@ include file="./footer_JYC" %>
</body>
</html>