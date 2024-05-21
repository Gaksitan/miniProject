<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employNoticeSave</title>
</head>
<body>
<h1>채용공고 상세페이지 관리(작성 or 수정)</h1>
<hr>
<div>
	<form action="enwrite" method="post">
		<p>제목</p>
		<input type="text" name="entitle"><br>
		<p>소개</p>
		<input type="text" name="enintro"><br>
		<p>경력</p>
		<input type="text" name="enexp"><br>
		<p>스킬</p>
		<input type="text" name="enskill"><br>
		<p>학력</p>
		<input type="text" name="endegree"><br>
		<p>복지</p>
		<input type="text" name="enwelfare"><br>
		<p>연봉</p>
		<input type="text" name="ensalary"><br>
		<p>주소</p>
		<input type="text" name="enaddr"><br>
		<p>마감일</p>
		<input type="date" name="enenddate"><br>
		<p>직무</p>
		<input type="text" name="enposition"><br>
		<input type="submit" value="저장">
	</form>
</div>
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>