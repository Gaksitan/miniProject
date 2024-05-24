<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../css/main.css" />
<style>
	#main {
		color: white;
		background-color: yellow;
	}
</style>
<body>
<%@ include file="./header_JYC.jsp"%>
<main>
<hr>
<h2>내 이력서 관리<span><input type="button" value="이력서 작성" onclick="writeResumePage()"></span></h2>
<table border="1">
	<tbody>
	<c:forEach var="resume" items="${myResumeList }" varStatus="status">
		<tr>
			<td>${resume.rregdate }</td>
			<td><a href="myResumeDetail?rno=${resume.rno }">${resume.rtitle }
			<c:if test="${resume.rpublic == true }" >🔒</c:if>
			</a></td>
			<td><c:if test="${resume.rmain == true }" >
			 	<input type="button" value="대표" id="main" onclick="main(event, ${resume.rno})">
			 	</c:if>
				<c:if test="${resume.rmain == false }"> 
				<input type="button" value="대표" id="sub" onclick="main(event, ${resume.rno})">
				
				</c:if></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</main>
<%@ include file="./footer_JYC.jsp"%>
<script>
	function writeResumePage(){
		window.location.href = "myResumeListWrite";
	}
	function main(event, rno){
		const xhr = new XMLHttpRequest();
		xhr.open("POST", "/mem/main" , true);		
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.onload = function(){
		}
		const data = JSON.stringify({
			rno : rno,
		})
		xhr.send(data);
	}
</script>
</body>
</html>