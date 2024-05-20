<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>infoCM</title>
</head>
<body>
<h1>인사담당자 정보관리</h1>
<hr>
<div>
	<form action="updateCMinfo" method="post">
		아이디 : <input type="text" name="cmid" readonly><br>
		비밀번호 : <input type="text" name="cmpw"><br>
		비밀번호확인 : <input type="text" name="checkcmpw"><br>
		이름 : <input type="text" name="cmname"><br>
		이메일 : <input type="text" name="cmemail"><br>
		국제번호 : <input type="text" name=""><br>
		전화번호 : <input type="text" name="cmtel">
		<input type="button" value="인증번호받기"> <br>
		인증번호 : <input type="text" name="cmteldocnum"><br> <!-- ?? -->
		<input type="submit" value="저장">
	</form>
</div>
</body>
</html>