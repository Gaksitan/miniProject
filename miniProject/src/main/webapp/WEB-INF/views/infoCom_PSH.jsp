<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>infoCom</title>
</head>
<body>
<h1>기업정보 수정페이지</h1>
<hr>

<div>
	<form action="updatecominfo" method="post">
		<p>사업자번호</p>
		<input type="text" name="cno" readonly><br>
		<p>회사명</p>
		<input type="text" name="cname"><br>
		<p>회사주소</p>
		<input type="text" name="caddr"><br>
		<p>회사 전화번호</p>
		<input type="text" name="ctel"><br>
		<p>설립연도</p>
		<input type="text" name="cfoundation"><br>
		<p>직원수</p>
		<input type="text" name="camount"><br>
		<p>회사소개</p>
		<input type="text" name="cintro"><br>
		<p>테마</p>
		<input type="text" name="ctype"><br>
		<input type="submit" value="저장">
	</form>
</div>
</body>
</html>