<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <link rel="stylesheet" href="../css/footer_css.css" />
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