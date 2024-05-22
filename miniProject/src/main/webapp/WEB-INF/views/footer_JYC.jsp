<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
    html, body {
        height: 100%;
        margin: 0;
        display: flex;
        flex-direction: column;
    }

    body {
        display: flex;
        flex-direction: column;
        font-family: 'Arial', sans-serif;
    }

    footer {
        background: #C4D2E9;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 20px;
        margin-top: auto;
        flex-shrink: 0;
        color: #2E2E2E;
        height: 150px;
    }

    footer img {
        width: 100px;
        height: 90px;
    }

    footer .menu {
        list-style-type: none;
        padding: 0;
        margin: 0;
        margin-bottom :70px;
        display: flex;
        flex-direction: row;

    }

    footer .menu li {
        margin: 0 10px; /* Horizontal margin for spacing between items */
        text-shadow: 2px 2px 2px lightgray;
    }

    footer .menu li a, footer .menu li span {
        color: #0174DF;
        text-decoration: none;
        font-weight: bold;
        font-size: 1.2em;
    }

    footer .menu li a:hover {
        text-decoration: underline;
        color : #FA8258;
    }

    footer .info {
        list-style-type: none;
        padding: 0;
        margin: 0;
        display: flex;
        flex-direction: column;
        color: #2E2E2E;
        align-items: start; 
    }

    footer .info li {
        margin: 5px 0;
        font-weight: bold;
        font-size: 1em;
        text-shadow: 1px 1px 1px lightgray;
    }

    .copyright-container {
        display: flex;
        justify-content: center;
        margin-top: 10px;
        width: 100%; /* Full width to center the content */
    }

    footer .copyright {
    	font-family: "Arial Black", sans-serif;
        margin-top: 10px;
        font-weight: bold;
        font-size: 1em;
        color: grey;
        text-align: center;
        width: 100%; /* Make sure it takes full width */
    }

    @media (min-width: 600px) {
        footer {
            flex-direction: row;
            align-items: center;
        }

        footer .menu {
            flex-direction: row;
            align-items: center; /* Align menu items vertically centered */
        }

        footer .menu li {
            margin: 0 15px;
        }

        footer .info {
            flex-direction: column;
            align-items: start; /* Center align the info items */
        }

        footer .info li {
            margin: 5px 0;
        }

        .copyright-container {
            flex: 1 0 auto;
            justify-content: center;
            margin-top: 0;
        }
    }
</style>


</head>
<body>
	<footer>
		<img src="../resources_JYC/images_JYC/logo.png" alt="로고" style="width:110px; height:90px;">
		<div>
			<ul class="menu">
				<li><span>서비스소개</span></li>
				<li><span>광고문의</span></li>
				<li><a href="https://github.com/Gaksitan/miniProject.git">GitHub</a></li>
				
				<c:if test="${companyManager == null }">
					<li><a href="/service/mainMem">고객센터</a></li>
				</c:if>
				<c:if test="${companyManager != null }">
					<li><a href="/service/mainCom">고객센터</a></li>
				</c:if>
	
			</ul>
			
			<div>
				<p class="copyright">
					<span>Copyright 2024. DEVJOB Co. All rights reserved.</span>
				</p>
			</div>
		</div>
		
		<div>
			<ul class="info">
				<li>만든이 : 4조</li>
				<li>이메일 : aaa@gmail.com</li>
				<li>전화번호 : XX-XXX-XXXX</li>
			</ul>
			
			
		</div>

	</footer>
</body>
</html>