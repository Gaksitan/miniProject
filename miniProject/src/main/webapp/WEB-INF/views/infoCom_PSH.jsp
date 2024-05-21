<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>infoCom</title>
</head>
<body>
<h1>기업정보 수정페이지</h1>
<hr>

<div>
    <form action="${pageContext.request.contextPath}/updateComInfo" method="post">
        <p>사업자번호</p>
        <input type="text" name="cno" value="${sessionScope.company.cno}" readonly><br>
        <p>회사명</p>
        <input type="text" name="cname" value="${sessionScope.company.cname}"><br>
        <p>회사주소</p>
        <input type="text" name="caddr1" value="${sessionScope.company.caddr1}"><br>
        <p>회사 전화번호</p>
        <input type="text" name="ctel" value="${sessionScope.company.ctel}"><br>
        <p>설립연도</p>
        <input type="date" name="cfoundation" value="${sessionScope.company.cfoundation}"><br>
        <p>직원수</p>
        <input type="text" name="camount" value="${sessionScope.company.camount}"><br>
        <p>회사소개</p>
        <input type="text" name="cintro" value="${sessionScope.company.cintro}"><br>
        <p>테마</p>
        <input type="text" name="ctype" value="${sessionScope.company.ctype}"><br>
        <input type="submit" value="저장">
    </form>
</div>
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>