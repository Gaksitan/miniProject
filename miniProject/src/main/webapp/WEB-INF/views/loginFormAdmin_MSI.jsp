<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자용 로그인화면</title>
<style>

html, body {
    height: 100%;
    margin: 0;
    font-family: Arial, sans-serif;
    display: flex;
    flex-direction: column;
}

header, footer {
    background-color: #C4D2E9; /* Adjust to match your header/footer */
    padding: 20px;
    text-align: center;
    font-size: 1em;
    color: #2E2E2E;
}

section {
    flex: 1;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 50px 0;
}

.container {
    width: 100%;
    max-width: 600px;
    margin: auto;
    padding: 50px;
    background-color: #f2f2f2;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    font-size: 1em;
}

#loginBtn {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 1em;
    font-weight: bold;
}

#loginBtn:hover {
    background-color: #45a049;
}

h3 {
    text-align: center;
}

hr {
    margin-bottom: 30px;
}
</style>
</head>
<body>
<%@ include file="./header_JYC.jsp"%>

<section>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null && !errorMessage.trim().isEmpty()) {
%>
<script>
    alert("<%= errorMessage %>");
</script>
<%
    }
%>

    <div class="container">
        <h3>관리자 로그인 화면</h3>
        <hr>
        <form method="get" action="/admin/login">
            <label for="ano">관리자 사원번호</label>
            <input type="text" name="ano" id="ano"><br>

            <label for="aid">관리자ID</label>
            <input type="text" name="aid" id="aid"><br>

            <label for="apw">관리자 비밀번호</label>
            <input type="password" name="apw" id="apw"><br>

            <input type="submit" value="로그인" id="loginBtn">
        </form>
    </div>
</section>

<%@ include file="./footer_JYC.jsp"%>
</body>
</html>