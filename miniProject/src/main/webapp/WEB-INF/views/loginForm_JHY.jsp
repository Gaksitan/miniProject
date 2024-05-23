<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// boolean tf = (boolean)session.getAttribute("tf");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	
</script>
<style>
	
</style>
<link rel="stylesheet" href="../css/main.css" />
<body>
<%@ include file="./header_JYC.jsp"%>
<main>
<hr>
<h1>개인회원 로그인</h1>
<form action="login" method="post">
	<table>
		<tr>
			<td><a href="/mem/loginForm">개인회원</a></td>
			<td><a href="/loginFormCom">기업회원</a></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="mid" placeholder="아이디를 입력하세요." id="shortbox"></td>
			<td></td>
			<td><input type="submit" value="로그인"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="mpw" placeholder="비밀번호를 입력하세요." id="shortbox"></td>
			<td></td>
			<td><a href="regFormMem">회원가입</a></td>
		</tr>
	</table>
</form>
</main>
<%@ include file="./footer_JYC.jsp"%>
</body>
</html>