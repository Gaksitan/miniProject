<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employNoticeSave</title>
<script>
    var skillIndex = ${employNotice.skills.size()};
    var welfareIndex = ${employNotice.welfares.size()};

    function addSkillField() {
        var container = document.getElementById("skillContainer");
        var input = document.createElement("input");
        input.type = "text";
        input.name = "newSknames";
        input.placeholder = "스킬명";
        container.appendChild(input);
        container.appendChild(document.createElement("br"));
        skillIndex++;
    }
    
    function addWelfareField() {
        var container = document.getElementById("welfareContainer");
        var input = document.createElement("input");
        input.type = "text";
        input.name = "newWnames";
        input.placeholder = "복지명";
        container.appendChild(input);
        container.appendChild(document.createElement("br"));
        welfareIndex++;
    }
    
    function deleteEmployNotice(enno) {
        if (confirm("정말로 삭제하시겠습니까?")) {
            var form = document.createElement("form");
            form.setAttribute("method", "post");
            form.setAttribute("action", "deleteEmployNotice");
            
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", "enno");
            hiddenField.setAttribute("value", enno);
            
            form.appendChild(hiddenField);
            document.body.appendChild(form);
            form.submit();
        }
    }
</script>
</head>
<link rel="stylesheet" href="../css/main.css" />
<body>
<main>
<h1>채용공고 상세페이지 관리</h1>
<hr>
<div>
    <form action="updateEmployNotice" method="post">
        <input type="hidden" name="enno" value="${employNotice.enno}">
        <p>제목</p>
        <input type="text" name="entitle" value="${employNotice.entitle}"><br>
        <p>소개</p>
        <input type="text" name="enintro" value="${employNotice.enintro}"><br>
        <p>경력</p>
        <input type="text" name="enexp" value="${employNotice.enexp}"><br>
        <p>스킬</p>
        <div id="skillContainer">
            <c:forEach items="${employNotice.skills}" var="skill" varStatus="status">
                스킬명 : <input type="text" name="sknames" value="${skill.skname}"><br>
            </c:forEach>
        </div>
        <button type="button" onclick="addSkillField()">추가</button>
        <p>학력</p>
        최종학력 : <input type="text" name="endegree" value="${employNotice.endegree}"><br>
        <p>복지</p>
        <div id="welfareContainer">
            <c:forEach items="${employNotice.welfares}" var="welfare" varStatus="status">
                복지명 : <input type="text" name="wnames" value="${welfare.wname}"><br>
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
        
            <input type="submit" value="수정">&nbsp;&nbsp;
            <input type="button" value="삭제" onclick="deleteEmployNotice(${employNotice.enno})">
    </form>
</div>
</main>
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>
