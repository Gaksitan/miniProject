<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업회원가입 Page</title>
</head>
<link rel="stylesheet" href="../css/main.css" />
<body>
<main>
<h1>기업회원가입 Page</h1>
<hr>
<a href="mem/regFormMem">개인회원</a>
<div>
    <table>
    <form action="signUpCom" method="post">
        <tr>
        <tr>
            <td>사업자번호</td>
            <td><input type="text" name="cno" id="cno" size="50" placeholder="사업자번호를 입력하세요."></td>
        	<td><input type="button" name="cnoCheck" value="사업자번호 중복체크" onclick="checkCno()"></td>
        </tr>
        <tr>
			<td></td>
			<td id="demo">.</td>
		</tr>
            <td>기업형태</td>
	            <td>
				<select name="ctype">
					<option value="대기업">대기업</option>
					<option value="중견기업">중견기업</option>
					<option value="중소기업">중소기업</option>
				</select>
			</td>
        </tr>
        <tr>
            <td>회사명</td>
            <td><input type="text" name="cname" size="50" placeholder="회사명을 입력하세요."></td>
        </tr>
        <tr>
            <td>회사주소</td>
            <td><input type="text" name="caddr1" size="50" placeholder="회사 주소를 입력하세요."></td>
        </tr>
        <tr>
        	<td></td>
            <td><input type="text" name="caddr2" size="50" placeholder="상세 주소를 입력하세요."></td>
        </tr>
        <tr>
            <td>사업자등록증명원발급번호</td>
            <td><input type="text" name="cdocnum" size="50" placeholder="사업자등록증명원발급번호를 입력하세요."></td>
            <td><input type="button" value="사업자등록증명원 발급하기" onClick="window.open('https://www.gov.kr/mw/AA020InfoCappView.do?HighCtgCD=A09002&CappBizCD=12100000016&tp_seq=01')"></td>
        </tr>
        <tr>
            <td>인사 담당자</td>
            <td>---------</td>
        </tr>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="cmid" id="cmid" size="50" placeholder="인사담당자 아이디를 입력하세요."></td>
        	<td><input type="button" name="cmidCheck" value="아이디 중복체크" onclick="checkCmid()"></td>
        </tr>
        <tr>
			<td></td>
			<td id="demo3">.</td>
		</tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="cmpw" size="50" id="password" placeholder="비밀번호를 입력하세요."></td>
        </tr>
        <tr>
            <td>비밀번호확인</td>
            <td><input type="password" name="cmpw2" size="50" id="confirmPassword" placeholder="한 번 더 비밀번호를 입력하세요."></td>
        </tr>
        <tr>
			<td></td>
			<td id="demo2" class="demo2"></td>
		</tr>
        <tr>
            <td>이메일</td>
            <td><input type="text" name="cmemail" size="20" placeholder="이메일을 입력하세요."></td>
            <td>@</td>
            <td><input type="text" name="cmemail2" size="20"></td>
        </tr>
        <tr>
			<th><select name="cmtel1">
				<option value="82">대한민국 (+82)</option>
				<option value="81">일본 (+81)</option>
				<option value="86">중국 (+86)</option>
				<option value="1">미국 (+1)</option>
				<option value="55">브라질 (+55)</option>
			</select></th>
		</tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="cmtel2" size="50" placeholder="전화번호를 입력하세요."></td>
            <td><input type="button" name="checkTel" value="인증번호받기" onclick="certificate()"></td>
        </tr>
        <tr>
            <td>인증번호</td>
            <td><input type="text" name="ctelverify" id="certificateNum" size="50" placeholder="인증번호를 입력하세요."></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="회원가입"></td>
        </tr>
    </form>
    </table>
</div>
</main>
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>

<%@ include file="./footer_JYC.jsp"%>
<script type="text/javascript">
	
	function checkCno() {
	    const cnoElement = document.querySelector("#cno");
	    const cno = cnoElement.value.trim();
	    
	    if (cno === "") {
	        document.getElementById("demo").innerHTML = "사업자번호를 입력해주세요.";
	        return;
	    }
	    
	    const xhttp = new XMLHttpRequest();
	    xhttp.onload = function() {
	        document.getElementById("demo").innerHTML = this.responseText;
	    }
	    xhttp.open("GET", "/regCnoCheck?cno=" + encodeURIComponent(cno), true);
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
	
	function checkCmid() {
	    const cmidElement = document.querySelector("#cmid");
	    const cmid = cmidElement.value.trim();
	    
	    if (cmid === "") {
	        document.getElementById("demo3").innerHTML = "ID를 입력해주세요.";
	        return;
	    }
	    
	    console.log("아이디 중복체크");
	    
	    const xhttp = new XMLHttpRequest();
	    xhttp.onload = function() {
	        document.getElementById("demo3").innerHTML = this.responseText;
	    }
	    xhttp.open("GET", "/regCmidCheck?cmid=" + encodeURIComponent(cmid), true);
	    xhttp.send();
	}

</script>