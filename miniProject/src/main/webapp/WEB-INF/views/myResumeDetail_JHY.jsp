<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	form {
		display: flex;
		
        flex-direction: column;
        align-items: center; /* 모든 자식 요소를 가로로 중앙 정렬 */
        /*justify-content: center; /* 모든 자식 요소를 세로로 중앙 정렬 (필요에 따라 사용) */
        width: 50%; /* 필요에 따라 조정 */
        margin: auto;
        padding: 20px;
        border: 1px solid #ccc;
	}
</style>
<body>
<%@ include file="./header_JYC.jsp"%>
<hr>
<h3>이력서 상세페이지 관리</h3>
<c:if test="${resume.rno == null }">
	<form id="writeResume" action="writeResume" method="post" enctype="multipart/form-data">
	<input type="hidden" name="rno" value="${rno }">
		<h2>이력서 제목</h2>
		<input type="text" name="rtitle"> <input type="image" src=""><br>
		<ul>
			<li>${member.mname }</li>
			<li>${member.memail }</li>
			<li>(${member.mtel1 }) ${member.mtel2 }</li>
		</ul><br>
		<h3>자기소개</h3>
		<input type="text" name="rintro"><br>
		<h3>스킬 (skill)</h3>
		<div id="rskill"></div>
		<button type="button" onclick="add()">추가</button><br>
		<h3>경력</h3>
		<div id="rexp"></div>
		<input type="button" value="추가" onclick="addExp()"><br>
		<h3>학력</h3>
		<input type="text" name="rdegree"><br>
		<h3>자격증</h3>
		<input type="text" name="rcertificate"><br>
		<h3>링크 (link)</h3>
		<input type="text" name="rlink"><br>
		
		<h3>공개여부<label><input type="radio" name="rpublic" value="1">공개</label>
			<label><input type="radio" name="rpublic" value="0">비공개</label></h3>
		<label><input type="checkbox" name="rmain" value="1">대표 이력서로 설정</label><br>
		<input type="submit" value="저장"><input type="button" value="취소" onclick="location.href='/mem/myResumeList'">
	</form>
</c:if>
<c:if test="${resume.rno != null }">
	<form id="updateResume" action="updateResume" method="post">
		<input type="hidden" name="rno" value="${rno }">
		<h2><input type="text" name="rtitle" value="${resume.rtitle }"></h2>
		<ul>
			<li>${member.mname }</li>
			<li>${member.memail }</li>
			<li>(${member.mtel1 }) ${member.mtel2 }</li>
		</ul><br>
		<h3>자기소개</h3>
		<input type="text" name="rintro" value=""><br>
		<h3>스킬 (skill)</h3>
		<input type="text" name="rskill" value=""><br>
		<h3>경력</h3>
		<input type="text" name="rexp" value=""><br>
		<h3>학력</h3>
		<input type="text" name="rdegree" value=""><br>
		<h3>자격증</h3>
		<input type="text" name="rcertificate" value=""><br>
		<h3>링크 (link)</h3>
		<input type="text" name="rlink" value=""><br>
		
		<h3>공개여부<label><input type="radio" name="rpublic" value="1">공개</label>
			<label><input type="radio" name="rpublic" value="0">비공개</label></h3>
		<label><input type="checkbox" name="rmain" value="1">대표 이력서로 설정</label><br>
		<input type="submit" value="수정"><input type="button" value="취소" onclick="location.href='/mem/myResumeList'">
	</form>
</c:if>
<%@ include file="./footer_JYC.jsp"%>
<script>
	function goBack(){
		location.href = "/mem/myResumeList";
	}
	
	function loadDoc() {
		  const xhttp = new XMLHttpRequest();
		  xhttp.onload = function() {
		    document.getElementById("demo").innerHTML = this.responseText;
		    }
		  xhttp.open("GET", "ajax_info.txt", true);
		  xhttp.send();
		}
	
	let num = 0;
	
	function addExp(){
		const rexp = document.querySelector("#rexp");
		const uniqueId2 = new Date().getTime();
		
		const newField = document.createElement("div");
		newField.className = "rexps";
		newField.id = `rexp-${uniqueId}`;
		
		newField.innerHTML = `
			<input type="text" id="rexp-${uniqueId}" placeholder="경력을 입력하세요.">
			<button type="button" onclick="saverexp(${uniqueId2})">저장</button>
		`;
		
		rexp.appendChild(newField);
	}
	
	function add() {
        const rskill = document.getElementById('rskill');
        const uniqueId = new Date().getTime(); // Create a unique ID for each field

        const newField = document.createElement('div');
        newField.className = 'rskill-container';
        newField.id = `rskill-${uniqueId}`;
		
		newField.innerHTML = `
			<input type="text" id="rskill-${uniqueId}" placeholder="보유 스킬을 입력하세요.">
			<button type="button" onclick="saverskill(${uniqueId})">저장</button>
		`;

		rskill.appendChild(newField);
    }

    function saverskill(uniqueId) {
        const inputField = document.getElementById(`rskill-${uniqueId}`);
        const value = inputField.value;
        const experienceText = document.createElement('div');
        experienceText.textContent = value;

        // Remove input field and button, then append the saved text
        const container = document.getElementById(`rskill-${uniqueId}`);
        container.innerHTML = '';
        container.appendChild(experienceText);

        // Optionally, store the value in a hidden input for form submission
        const hiddenInput = document.createElement('input');
        hiddenInput.type = 'hidden';
        hiddenInput.name = 'rskill';
        hiddenInput.value = value;
        document.getElementById('writeResume').appendChild(hiddenInput);
    }
	
</script>

</body>
</html>