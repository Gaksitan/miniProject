<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#main {
		color: white;
		background-color: yellow;
	}
</style>
<body>
<%@ include file="./header_JYC.jsp"%>
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
			 	<input type="button" value="대표" id="main">
			 	</c:if>
				<c:if test="${resume.rmain == false }"> 
				<input type="button" value="대표" id="sub">
				</c:if></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<%@ include file="./footer_JYC.jsp"%>
<script>
	function writeResumePage(){
		window.location.href = "myResumeDetailWrite";
	}
</script>
</body>
</html>