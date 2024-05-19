<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자용 로그인화면</title>
</head>
<style>
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

input[type=submit] {
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

input[type=submit]:hover {
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
<h2>관리자 로그인 화면</h2>
<div>
	<form method="get" action="/admin/login">
		<label for="ano">관리자 사원번호</label>
		<input type="text" name="ano" id="ano"><br>
		
		<label for="aid">관리자ID</label>
		<input type="text" name="aid" id="aid"><br>
		
		<label for="apw">관리자 비밀번호</label>
		<input type="password" name="apw" id="apw"><br>
		
		<input type="submit" value="로그인">
	</form>
</div>



</body>
</html>