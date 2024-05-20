<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	*{
		margin: auto;
		padding: auto;
	}
</style>
<body>
<h1>개인회원용 헤더 위치</h1>
<form action="regist" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="mid" placeholder="아이디를 입력하세요."><input type="button" name="midCheck" value="아이디 중복체크"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="mpw" placeholder="비밀번호를 입력하세요."></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="mpw2" placeholder="한번 더 비밀번호를 입력하세요."></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="mname" placeholder="이름을 입력하세요."></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="maddr1" placeholder="주소를 입력하세요."></td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td><input type="text" name="maddr2" placeholder="상세주소를 입력하세요."></td>
		</tr>
		<tr>
			<th><select name="mtel1">
				<option value="82">대한민국 (+82)</option>
				<option value="81">일본 (+81)</option>
				<option value="86">중국 (+86)</option>
				<option value="1">미국 (+1)</option>
				<option value="55">브라질 (+55)</option>
			</select></th>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="mtel2" placeholder="전화번호를 입력하세요"><input type="button" name="checkTel" value="인증번호받기"></td>
		</tr>
		<tr>
			<th>인증번호</th>
			<td><input type="text" name="certificationNum"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="memail" placeholder="이메일을 입력하세요."></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="text" name="mbirthDate" placeholder="생년월일을 입력하세요."></td>
		</tr>
		<tr>
			<th>구직여부</th>
			<td><select name="mstate">
				<option value="0">재직중</option>
				<option value="1" selected="1">구직중</option>
				<option value="2">관심없음</option>
			</select></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><label><input type="radio" name="mgender" value="M">남자</label>
				<label><input type="radio" name="mgender" value="F">여자</label></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="회원가입"></td>
		</tr>
	</table>
</form>
</body>
</html>