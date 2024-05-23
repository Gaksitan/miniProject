<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>infoCM</title>
</head>
<link rel="stylesheet" href="../css/main.css" />
<body>
<main>
<h1>인사담당자 정보관리</h1>
<hr>
<div>
    <form action="${pageContext.request.contextPath}/updateCMinfo" method="post">
        아이디 :
        <input type="text" name="cmid" value="${sessionScope.companyManager.cmid}" readonly><br>
        비밀번호 :
        <input type="password" name="cmpw" id="password" value="${sessionScope.companyManager.cmpw}"><br>
        비밀번호확인 :
        <input type="password" name="checkcmpw" id="confirmPassword" value="${sessionScope.companyManager.cmpw}"><br>
		<div id="demo2" class="demo2"></div>
        이름 :
        <input type="text" name="cmname" value="${sessionScope.companyManager.cmname}"><br>
        이메일 :
        <input type="text" name="cmemail" value="${sessionScope.companyManager.cmemail}"><br>
        <select name="cmtel1">
		        <c:choose>
		            <c:when test="${sessionScope.companyManager.cmtel1 == '82'}">
		                <option value="82" selected>대한민국 (+82)</option>
						<option value="81">일본 (+81)</option>
						<option value="86">중국 (+86)</option>
						<option value="1">미국 (+1)</option>
						<option value="55">브라질 (+55)</option>
		            </c:when>
		            <c:when test="${sessionScope.companyManager.cmtel1 == '81'}">
		                <option value="82">대한민국 (+82)</option>
						<option value="81" selected>일본 (+81)</option>
						<option value="86">중국 (+86)</option>
						<option value="1">미국 (+1)</option>
						<option value="55">브라질 (+55)</option>
		            </c:when>
		            <c:when test="${sessionScope.companyManager.cmtel1 == '86'}">
		                <option value="82">대한민국 (+82)</option>
						<option value="81">일본 (+81)</option>
						<option value="86" selected>중국 (+86)</option>
						<option value="1">미국 (+1)</option>
						<option value="55">브라질 (+55)</option>
		            </c:when>
		            <c:when test="${sessionScope.companyManager.cmtel1 == '1'}">
		                <option value="82">대한민국 (+82)</option>
						<option value="81">일본 (+81)</option>
						<option value="86">중국 (+86)</option>
						<option value="1" selected>미국 (+1)</option>
						<option value="55">브라질 (+55)</option>
		            </c:when>
		            <c:when test="${sessionScope.companyManager.cmtel1 == '55'}">
		                <option value="82">대한민국 (+82)</option>
						<option value="81">일본 (+81)</option>
						<option value="86">중국 (+86)</option>
						<option value="1">미국 (+1)</option>
						<option value="55" selected>브라질 (+55)</option>
		            </c:when>
		            <c:otherwise>
		                <option value="82">대한민국 (+82)</option>
						<option value="81">일본 (+81)</option>
						<option value="86">중국 (+86)</option>
						<option value="1">미국 (+1)</option>
						<option value="55">브라질 (+55)</option>
		            </c:otherwise>
		        </c:choose>
		    </select>
        전화번호 :
        <input type="text" name="cmtel2" value="${sessionScope.companyManager.cmtel2}">
        <input type="button" value="인증번호받기" onclick="certificate()"><br>
        인증번호 :
        <input type="text" name="cmteldocnum" id="certificateNum"><br>
        <input type="submit" value="저장">
    </form>
</div>
</main>	
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>

<script>
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
</script>