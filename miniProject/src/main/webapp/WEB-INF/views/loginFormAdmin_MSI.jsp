<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자용 로그인화면</title>
</head>
<style>
section{
	margin : 50px auto;
	height : 500px;
}

.container{
	margin : 50px auto;
}

input[type=text],input[type=password]{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  font-size : 1em;
}

#loginBtn{
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size : 1em;
  font-weight : bold;
}

#loginBtn:hover {
  background-color: #45a049;
  font-size : 1em;
  font-weight : bold;
}

div {
  margin : auto;
  width : 600px;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 50px;
}

</style>
<body>
<%@ include file="./header_JYC.jsp"%>

<section>

<h3>관리자 로그인 화면</h3>
<hr>

	<div class="container">
		<form method="get" action="/admin/login">
			<label for="ano">관리자 사원번호</label>
			<input type="text" name="ano" id="ano"><br>
			
			<label for="aid">관리자ID</label>
			<input type="text" name="aid" id="aid"><br>
			
			<label for="apw">관리자 비밀번호</label>
			<input type="password" name="apw" id="apw"><br>
			
			<input type="submit" value="로그인" id="loginBtn">
		</form>
	</div>

</section>


<%
    // errorMessage가 존재하고 빈 문자열이 아닌 경우에만 alert 창을 띄움
    String errorMessage = (String)request.getAttribute("errorMessage");
    if (errorMessage != null && !errorMessage.trim().isEmpty()) {
%>
<script>
    alert("<%= errorMessage %>");
</script>
<%
    }
%>

<%@ include file="./footer_JYC.jsp"%>
</body>
</html>