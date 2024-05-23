<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employNoticeSave</title>
<script src="../../script/script.js"></script>

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
        <div id="rskillContainer">
            <c:forEach items="${employNotice.skills}" var="skill">
                스킬명 : <input type="text" name="rskill" value="${skill.skname}"><br>
            </c:forEach>
        </div>
        <button type="button" onclick="addRskill()">추가</button>
        <p>학력</p>
        최종학력 : <input type="text" name="endegree" value="${employNotice.endegree}"><br>
        <p>복지</p>
        <div id="welfareContainer">
            <c:forEach items="${employNotice.welfares}" var="welfare">
                복지명 : <input type="text" name="wname" value="${welfare.wname}"><br>
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