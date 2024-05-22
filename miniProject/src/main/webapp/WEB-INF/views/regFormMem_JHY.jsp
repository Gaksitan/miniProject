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
<%@ include file="./header_JYC.jsp"%>
<form action="regist" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="mid" id="mid" placeholder="아이디를 입력하세요."></td>
			<td><input type="button" name="midCheck" value="아이디 중복체크" onclick="checkMid()"></td>
		</tr>
		<tr>
			<td></td>
			<td id="demo">.</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="mpw" id="password" placeholder="비밀번호를 입력하세요."></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="mpw2" id="confirmPassword" placeholder="한번 더 비밀번호를 입력하세요."></td>
		</tr>
		<tr>
			<td></td>
			<td id="demo2" class="demo2"></td>
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
			<td><input type="text" name="mtel2" placeholder="전화번호를 입력하세요">
				<input type="button" name="checkTel" value="인증번호받기" onclick="certificate()"></td>
		</tr>
		<tr>
			<th>인증번호</th>
			<td><input type="text" id="certificateNum" name="certificationNum"></td>
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
<%@ include file="./footer_JYC.jsp"%>
<script type="text/javascript">
	// 아이디 중복 체크 메서드
	
	function checkMid() {
		const mid = document.querySelector("#mid");
		console.log("아이디 중복체크");
		
		const xhttp = new XMLHttpRequest();
		xhttp.onload = function() {
			document.getElementById("demo").innerHTML = this.responseText;
	  }
	  xhttp.open("GET", "/mem/regMidCheck?mid=" + mid.value, true);
	  xhttp.send();
	}
	
	function certificate(){
		let randomNum = Math.floor(Math.random()*1000000) + 1;
		const certificateNum = document.querySelector("#certificateNum");
		console.log(randomNum);
		certificateNum.value = randomNum;
	}
	const password = document.querySelector("#password");
	const confirmPassword = document.querySelector("#confirmPassword");
	const msg = document.querySelector("#demo2");
	password.addEventListener("input", function(){
		if(password.value.trim() == confirmPassword.value.trim()){
			msg.textContent = "비밀번호가 일치합니다.";
			msg.classList.remove("invalid");
		}else{
			msg.textContent = "비밀번호가 일치하지 않습니다.";
			msg.classList.add("invalid");
		}
	});
	confirmPassword.addEventListener("input", function(){
		if(password.value.trim() == confirmPassword.value.trim()){
			msg.textContent = "비밀번호가 일치합니다.";
			msg.classList.remove("invalid");
		}else{
			msg.textContent = "비밀번호가 일치하지 않습니다.";
			msg.classList.add("invalid");
		}
	});
	/* function confirm(){
		if(password.value == confirmPassword.value){
			msg.textContent = "비밀번호가 일치합니다.";
			msg.classList.remove("invalid");
		}else{
			msg.textContent = "비밀번호가 일치하지 않습니다.";
			msg.classList.add("invalid");
		}
	} */
</script>
</body>
</html>