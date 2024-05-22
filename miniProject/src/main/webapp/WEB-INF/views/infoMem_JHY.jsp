<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./header_JYC.jsp"%>
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
			<td><input type="password" id="password" name="mpw"></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" id="confirmPassword" name="mpw2"></td>
		</tr>
		<tr>
			<td></td>
			<td id="msg"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="mname"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="maddr1"></td>
		</tr>
		<tr>
			<th>상세주소</th>
			<td><input type="text" name="maddr2"></td>
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
			<td><input type="text" name="mtel2"><input type="button" value="인증번호 받기" onclick="certificate()"></td>
		</tr>
		<tr>
			<th>인증번호</th>
			<td><input type="text" id="certificateNum" name="checkCertificate"></td>
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
			<td>성별
				<c:if test='${member.mgender == "M" }'>
				<label><input type="radio" name="mgender" value="M" checked>남</label>
				<label><input type="radio" name="mgender" value="F">여</label></c:if>
				<c:if test='${member.mgender == "F" }'>
				<label><input type="radio" name="mgender" value="M">남</label>
				<label><input type="radio" name="mgender" value="F" checked>여</label></c:if>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="수정">
			<input type="button" value="취소" onclick="Back()">
			<input type="button" value="회원탈퇴" onclick="invalid()">
			</td>
		</tr>
	</table>
</form>
<%@ include file="./footer_JYC.jsp"%>
<script>
	function certificate(){
		let randomNum = Math.floor(Math.random()*1000000);
		const certificateNum = document.querySelector("#certificateNum");
		certificateNum.value = randomNum;
	}
	const password = document.querySelector("#password");
	const confirmPassword = document.querySelector("#confirmPassword");
	const msg = document.querySelector("#msg");
	password.addEventListener("input", function(){
		if(password.value.trim() == confirmPassword.value.trim()){
			msg.textContent = "비밀번호가 일치합니다.";
		}else{
			msg.textContent = "비밀번호가 일치하지 않습니다.";
		}
	})
	confirmPassword.addEventListener("input", function(){
		if(password.value.trim() == confirmPassword.value.trim()){
			msg.textContent = "비밀번호가 일치합니다.";
			msg.classList.remove("invalid");
		}else{
			msg.textContent = "비밀번호가 일치하지 않습니다.";
			msg.classList.add("invalid");
		}
	})
	function Back(){
		window.location.href = "indexMem";
	}
	function invalid(){
		location.href = "deleteMemInfo";
	}
</script>
</body>
</html>