<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>내 정보 관리 페이지 개인회원용 헤더 위치</h1>
<hr>
<h2>내 정보 관리</h2>
<form action="updateMemberInfo" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="mid" value="${member.mid }" readonly></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="mpw"></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="mpw2"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="mname"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="maddr"></td>
		</tr>
		<tr>
			<td><select name="mtel1">
				<option value="82">대한민국 (+82)</option>
				<option value="81">일본 (+81)</option>
				<option value="86">중국 (+86)</option>
				<option value="1">미국 (+1)</option>
				<option value="55">브라질 (+55)</option>
			</select></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="mtel1"><input type="button" value="인증번호 받기" onclick="certificate()"></td>
		</tr>
		<tr>
			<th>인증번호</th>
			<td><input type="text" name="checkCertificate"></td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><input type="text" name="mbirthDate" value="${member.mbirthDate }" readonly></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="memail" value="${member.memail }" readonly></td>
		</tr>
		<tr>
			<td colspan="2"><select name="mstate">
				<option value="0">재직중</option>
				<option value="1" selected="1">구직중</option>
				<option value="2">관심없음</option>
			</select><td>
		</tr>
		<tr>
			<td>성별 <label><input type="radio" name="mgender">남</label>
					<label><input type="radio" name="mgender">여</label></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="수정">
			<input type="button" value="회원탈퇴">
			</td>
		</tr>
	</table>
</form>

</body>
</html>