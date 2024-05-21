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
<body>
<%@ include file="./header_JYC.jsp"%>
<hr>
<form action="login" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="mid" placeholder="아이디를 입력하세요."></td>
			<td></td>
			<td><input type="submit" value="로그인"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="mpw" placeholder="비밀번호를 입력하세요."></td>
			<td></td>
			<td><a href="regFormMem">회원가입</a></td>
		</tr>
	</table>
</form>
<%@ include file="./footer_JYC.jsp"%>
</body>
</html>