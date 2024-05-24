<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employNoticeSave</title>
<script>
	function addSkillField() {
	    var container = document.getElementById("skillContainer");
	    var div = document.createElement("div");
	    var input = document.createElement("input");
	    input.type = "text";
	    input.name = "skname";
	    input.placeholder = "스킬명";
	    
	    var removeButton = document.createElement("button");
	    removeButton.type = "button";
	    removeButton.innerText = "삭제";
	    removeButton.onclick = function() {
	        container.removeChild(div);
	    };
	    
	    div.appendChild(input);
	    div.appendChild(removeButton);
	    container.appendChild(div);
	}
	
	function addWelfareField() {
	    var container = document.getElementById("welfareContainer");
	    var div = document.createElement("div");
	    var input = document.createElement("input");
	    input.type = "text";
	    input.name = "wname";
	    input.placeholder = "복지명";
	    
	    var removeButton = document.createElement("button");
	    removeButton.type = "button";
	    removeButton.innerText = "삭제";
	    removeButton.onclick = function() {
	        container.removeChild(div);
	    };
	    
	    div.appendChild(input);
	    div.appendChild(removeButton);
	    container.appendChild(div);
	}
</script>
</head>
<link rel="stylesheet" href="../css/main.css" />
<body>
<main>
<h1>채용공고 상세페이지 관리 작성</h1>
<hr>
<div>
    <form action="enwrite" method="post">
        <input type="hidden" name="enno" value="${employNotice.enno}">
        <p>제목</p>
        <input type="text" name="entitle" value="${employNotice.entitle}"><br>
        <p>소개</p>
        <input type="text" name="enintro" value="${employNotice.enintro}"><br>
        <p>경력</p>
        <input type="text" name="enexp" value="${employNotice.enexp}"><br>
        <p>스킬</p>
        <div id="skillContainer">
            <c:forEach items="${employNotice.skills}" var="skill">
                스킬명 : <input type="text" name="skname" value="${skill.skname}">
                <button type="button" onclick="this.parentElement.remove()">삭제</button>
            </c:forEach>
        </div>
        <button type="button" onclick="addSkillField()">추가</button>
        <p>학력</p>
        최종학력 : <input type="text" name="endegree" value="${employNotice.endegree}"><br>
        <p>복지</p>
        <div id="welfareContainer">
            <c:forEach items="${employNotice.welfares}" var="welfare">
                복지명 : <input type="text" name="wname" value="${welfare.wname}"><br>
                <button type="button" onclick="this.parentElement.remove()">삭제</button>
            </c:forEach>
        </div>
        <button type="button" onclick="addWelfareField()">추가</button>
        <p>연봉</p>
        <input type="text" name="ensalary" value="${employNotice.ensalary}"><br>
        <p>주소</p>
        <input type="text" name="enaddr" value="${employNotice.enaddr}"><br>
        <p>마감일</p>
        <input type="date" name="enenddate" value="${employNotice.enenddate}"><br>
        <p>직무</p>
        <input type="text" name="enposition" value="${employNotice.enposition}"><br>
        <input type="submit" value="저장">
        <input type="button" value="취소" onclick="window.location.href = 'employNoticeList'">
    </form>
</div>
</main>
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>