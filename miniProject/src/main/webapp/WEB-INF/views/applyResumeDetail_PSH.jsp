<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>applyResumeDetail</title>
</head>
<body>
<h1>지원자 및 관심 구직자 이력서 상세보기 페이지</h1>
<hr>
<c:set var="item" value="${item}" />


<h2>${item.mname}</h2>

<ul>
	<li>이름 : ${item.mname}</li>
	<li>메일 : ${item.memail}</li>
	<li>전화번호 : ${item.mtel}</li>
</ul>

<h3>${item.mintro}</h3>

<h3>스킬스텟</h3>
	<c:forEach items="${skillList}" var="skill">
            <td>${skil.skname}</td>
    </c:forEach>

<h3>경력</h3>
	<c:forEach items="${expList}" var="exp">
        <tr>
            <td>${exp.exname}</td>
            <td>${exp.exjoindate}</td>
            <td>${exp.exleavedate}</td>
            <td>${exp.exposition}</td>
            <td>${exp.exrank}</td>
        </tr>
    </c:forEach>


<h3>학력</h3>
	<c:forEach items="${degreeList}" var="degree">
        <tr>
            <td>${degree.dename}</td>
            <td>${degree.degraddate}</td>
            <td>${degree.demajor}</td>
            <td>${degree.dehighestlevel}</td>
        </tr>
    </c:forEach>

<h3>링크</h3>
	<c:forEach items="${linkList}" var="link">
        <tr>
            <td>${link.lname}</td>
        </tr>
    </c:forEach>
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>