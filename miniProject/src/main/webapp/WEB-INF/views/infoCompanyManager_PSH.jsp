<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>infoCM</title>
</head>
<body>
<h1>인사담당자 정보관리</h1>
<hr>
<div>
    <form action="${pageContext.request.contextPath}/updateCMinfo" method="post">
        아이디 : <input type="text" name="cmid" value="${sessionScope.companyManager.cmid}" readonly><br>
        비밀번호 : <input type="password" name="cmpw" value="${sessionScope.companyManager.cmpw}"><br>
        비밀번호확인 : <input type="password" name="checkcmpw" value="${sessionScope.companyManager.cmpw}"><br>
        이름 : <input type="text" name="cmname" value="${sessionScope.companyManager.cmname}"><br>
        이메일 : <input type="email" name="cmemail" value="${sessionScope.companyManager.cmemail}"><br>
        국제번호 : <input type="text" name="countryCode"><br>
        전화번호 : <input type="text" name="cmtel" value="${sessionScope.companyManager.cmtel}">
        <input type="button" value="인증번호받기"><br>
        인증번호 : <input type="text" name="cmteldocnum"><br>
        <input type="submit" value="저장">
    </form>
</div>
</body>
</html>
