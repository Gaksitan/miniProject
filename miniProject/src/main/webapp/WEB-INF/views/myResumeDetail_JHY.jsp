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
		<div id="rskillContainer">
			<c:forEach var="rskill" items="${resume.rskill }">
				스킬명 : <input type="text" name="rskill" value="${resume.rskill }"><br>
			</c:forEach>
		</div>
		<button type="button" onclick="addRskill()">추가</button>
		<h3>경력</h3>
		<div id="rexpContainer">
			<c:forEach var="rskill" items="${resume.rexp }">
				스킬명 : <input type="text" name="rexp" value="${resume.rexp }"><br>
			</c:forEach>
		</div>
		<button type="button" onclick="addRexp()">추가</button>
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
		
		<h3>공개여부
			<label><input type="radio" name="rpublic" value="1">공개</label>
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
	// 추가 버튼 클릭시 작동 (인풋박스, 저장 및 취소 버튼 생성)
	function addRskill() {
		var container = document.getElementById("rskillContainer");
	    var input = document.createElement("input");
	    var cancelBtn = document.createElement("button");
	    var saveBtn = document.createElement("button");
	    var br = document.createElement("br");
		input.type = "text";
        input.name = "rskill";
        input.placeholder = "스킬명";
        
        cancelBtn.type = "button";
        cancelBtn.innerText = "취소";
        cancelBtn.onclick = function(){
        	cancel(input, saveBtn, cancelBtn, br);
        };
        saveBtn.type = "button";
        saveBtn.innerText = "저장";
        saveBtn.onclick = function(){
        	save(input, input.value, saveBtn, cancelBtn, br);
        }
        container.appendChild(input);
        container.appendChild(saveBtn);
        container.appendChild(cancelBtn);
        container.appendChild(br);
    }
	// 생성된 취소 버튼 클릭시 작동
	function cancel(input, saveBtn, cancelBtn, br){
		input.remove();
		saveBtn.remove();
		cancelBtn.remove();
		br.remove();
	}
    // 생성된 저장 버튼 클릭시 작동
	function save(input, value, saveBtn, cancelBtn, br){
		var p = document.createElement("p");
		p.innerText = value;
		var del = document.createElement("button");
		del.type = "button";
		del.innerText = "삭제";
		del.onclick = function(){
			elision(p);
		}
		input.remove();
		saveBtn.remove();
		cancelBtn.remove();
		br.remove();
		var container = document.getElementById("rskillContainer");
	    container.appendChild(p);
	    p.appendChild(del);
	}
	// 저장 버튼 클릭시 추가로 삭제버튼 생성 (잘못 입력한 데이터 사용자가 삭제)
	function elision(p){
		p.remove();
	}
	
	
	function addRexp() {
		var container = document.getElementById("rexpContainer");
        var input = document.createElement("input");
        var cancelBtn = document.createElement("button");
        var saveBtn = document.createElement("button");
        var br = document.createElement("br");
        input.type = "text";
        input.name = "rexp";
        input.placeholder = "스킬명";
        cancelBtn.type = "button";
        cancelBtn.innerText = "취소";
        cancelBtn.onclick = function(){
        	cancel(input, saveBtn, cancelBtn, br);
        };
        saveBtn.type = "button";
        saveBtn.innerText = "저장";
        saveBtn.onclick = function(){
        	save(input, input.value, saveBtn, cancelBtn, br);
        }
        container.appendChild(input);
        container.appendChild(saveBtn);
        container.appendChild(cancelBtn);
        container.appendChild(br);
    }
</script>

</body>
</html>