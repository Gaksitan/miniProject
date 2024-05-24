<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginFormCom</title>
</head>
<link rel="stylesheet" href="../css/main.css" />
<script type="text/javascript">
    function validateForm() {
        var cmid = document.forms["loginForm"]["cmid"].value;
        var cmpw = document.forms["loginForm"]["cmpw"].value;
        if (cmid == "" || cmpw == "") {
            alert("아이디와 비밀번호를 모두 입력해주세요.");
            return false;
        }
    }
</script>
<body>
<main>
<h1>기업 로그인</h1>

<div>
    <form name="loginForm" action="loginCom" method="post" onsubmit="return validateForm()">
       <table>
		<tr>
			<td><a href="/mem/loginForm">개인회원</a></td>
			<td><a href="/loginFormCom">기업회원</a></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="cmid" placeholder="담당자 아이디" id="shortbox"></td>
			<td></td>
			<td><input type="submit" value="로그인"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="cmpw" placeholder="비밀번호" id="shortbox"></td>
			<td></td>
			<td><a href="regFormCom">회원가입</a></td>
		</tr>
	</table>
    </form>
</div>
</main>
<script type="text/javascript">
    <% 
        String msg = (String) request.getAttribute("msg");
        if (msg != null) {
    %>	
        alert("<%= msg %>");
    <% 
        } 
    %>
</script>
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>
