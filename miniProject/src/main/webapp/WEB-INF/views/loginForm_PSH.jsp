<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginFormCom</title>
</head>
<link rel="stylesheet" href="../css/main.css" />
<body>
<main>
<h1>기업 로그인</h1>

<div>
	<form action="loginCom" method="post">
		아이디 : <input type="text" name="cmid" placeholder="담당자 아이디"><br>
		비밀번호 : <input type="password" name="cmpw" placeholder="비밀번호"><br>
		<input type="submit" value="로그인">&nbsp;&nbsp;
		<a href="regFormCom">회원가입</a>
	</form>
</div>
</main>
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>