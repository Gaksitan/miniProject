<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../script/script.js">console.log(${rno})</script>
</head>
<link rel="stylesheet" href="../css/main.css" />

<style>
	
</style>

<body>
<%@ include file="./header_JYC.jsp"%>
<main>
<hr>
<h3>이력서 상세페이지 관리</h3>
<c:if test="${resume.rno == null }">
	<form id="writeResume" action="writeResume" method="post" enctype="multipart/form-data">
	<input type="hidden" name="rno" value="${rno }">
		<h2>이력서 제목</h2>
		<input type="text" name="rtitle"> <input type="image" name="rimgPath" src="" alt="증명사진"><br>
		<ul>
			<li>${member.mname }</li>
			<li>${member.memail }</li>
			<li>(${member.mtel1 }) ${member.mtel2 }</li>
		</ul><br>
		<h3>자기소개</h3>
		<input type="text" name="rintro"><br>
		<h3>스킬 (skill) 	<button type="button" onclick="addRskill()">추가</button>
		</h3>
		<div id="rskillContainer">
			
		</div>
		<h3>경력 <button type="button" onclick="addRexp()">추가</button></h3>
		<div>
			<table id="rexpContainer">
				<thead>
					<tr>
						<th>회사명</th><th>재직날짜</th><th>퇴직날짜</th><th>직무</th><th>직급</th>
					</tr>
				</thead>
				
			</table>
		</div>
		
		<h3>학력 <button type="button" onclick="addRdegree()">추가</button></h3>
		<div>
			<table id="rdegreeContainer">
				<thead>
				<tr>
					<th>학교명</th><th>졸업날짜</th><th>전공</th><th>최종학력</th>
				</tr>
				</thead>
			</table>
		</div>
		<h3>자격증 <button type="button" onclick="addRcertificate()">추가</button></h3>
		<div>
			<table id="rcertificateContainer">
				<thead>
				<tr>
					<th>자격증 이름</th><th>취득날짜</th><th>발급처</th>
				</tr>
				</thead>
			</table>
		</div>
		<h3>링크 (link) <button type="button" onclick="addRlink()">추가</button></h3>
		<div id="rlinkContainer">
		</div>
		
		<h3>공개여부
			<label><input type="radio" name="rpublic" value="1">공개</label>
			<label><input type="radio" name="rpublic" value="0">비공개</label></h3>
		<label><input type="checkbox" name="rmain" value="1">대표 이력서로 설정</label><br>
		<input type="submit" value="저장"><input type="button" value="취소" onclick="location.href='/mem/myResumeList'">
	</form>
</c:if>
<c:if test="${resume.rno != null }">
	<form id="updateResume" action="updateResume" method="post">
		<input type="hidden" name="rno" value="${rno }">
		<h2>제목 : <input type="text" name="rtitle" value="${resume.rtitle }"><input type="image" name="rimgPath" src="" alt="증명사진"></h2>
		<ul>
			<li>${member.mname }</li>
			<li>${member.memail }</li>
			<li>(${member.mtel1 }) ${member.mtel2 }</li>
		</ul><br>
		<h3>자기소개</h3>
		<input type="text" name="rintro" value="${resume.rintro }"><br>
		<h3>스킬 (skill) <button type="button" onclick="addRskill()">추가</button></h3>
		<div id="rskillContainer">
			<c:forEach var="rskill" items="${skillList }">
				<h5 id="shortbox">스킬명 : ${rskill.skname }<input type="hidden" name="rskill" value="${rskill.skname }"><button type="button" onclick="deleteData(event)">삭제</button></h5>
			</c:forEach>
		</div>
		<h3>경력 <button type="button" onclick="addRexp()">추가</button></h3>
		<div>
			<table id="rexpContainer">
				<thead>
					<tr>
						<th>회사명</th><th>재직날짜</th><th>퇴직날짜</th><th>직무</th><th>직급</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="rexp" items="${experienceList }">
					<tr>
						<td>${rexp.exname }<input type="hidden" name="exname" value="${rexp.exname }"></td>
						<td>${rexp.exjoindate }<input type="hidden" name="exjoindate" value="${rexp.exjoindate }"></td>
						<td>${rexp.exleavedate }<input type="hidden" name="exleavedate" value="${rexp.exleavedate }"></td>
						<td>${rexp.exposition }<input type="hidden" name="exposition" value="${rexp.exposition }"></td>
						<td>${rexp.exrank }<input type="hidden" name="exrank" value="${rexp.exrank }"></td>
						<td><button type="button" onclick="deleteDataTable(event)">삭제</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<h3>학력 <button type="button" onclick="addRdegree()">추가</button></h3>
		<div>
			<table id="rdegreeContainer">
				<thead>
				<tr>
					<th>학교명</th><th>졸업날짜</th><th>전공</th><th>최종학력</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="rdegree" items="${degreeList }">
					<tr>
						<td>${rdegree.dename }</td>
						<td>${rdegree.degraddate }</td>
						<td>${rdegree.demajor }</td>
						<td>${rdegree.dehighestlevel }</td>
						<td><button type="button" onclick="deleteDataTable(event)">삭제</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<h3>자격증 <button type="button" onclick="addRcertificate()">추가</button></h3>
		<div>
			<table id="rcertificateContainer">
				<thead>
				<tr>
					<th>자격증 이름</th><th>취득날짜</th><th>발급처</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="rcertificate" items="${certificateList }">
					<tr>
						<td>${rcertificate.cename }</td>
						<td>${rcertificate.cedate }</td>
						<td>${rcertificate.celocation }</td>
						<td><button type="button" onclick="deleteDataTable(event)">삭제</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<h3>링크 (link) <button type="button" onclick="addRlink()">추가</button></h3>
		<div id="rlinkContainer">
			<c:forEach var="rlink" items="${linkList }">
				<h4>링크 : ${rlink.lname }<button type="button" onclick="deleteData(event)">삭제</button></h4>
			</c:forEach>
		</div>
		
		<h3>공개여부
		<c:if test="${resume.rpublic == true }">
			<label><input type="radio" name="rpublic" value="1" checked>공개</label>
			<label><input type="radio" name="rpublic" value="0">비공개</label>
		</c:if>
		<c:if test="${resume.rpublic == false }">
			<label><input type="radio" name="rpublic" value="1">공개</label>
			<label><input type="radio" name="rpublic" value="0" checked>비공개</label>
		</c:if>
		</h3>
		<c:if test="${resume.rmain == false }">
			<label><input type="checkbox" name="rmain" value="1" checked="0">대표 이력서로 설정</label>
		</c:if>
		<c:if test="${resume.rmain == true }">
			<label><input type="checkbox" name="rmain" value="1" checked="1">대표 이력서로 설정</label>
		</c:if>
		<br>
		<input type="submit" value="수정"><input type="button" value="취소" onclick="location.href='/mem/myResumeList'"><input type="button" value="삭제" onclick="location.href='/mem/deleteMyResume?rno=${rno}'">
	</form>
</c:if>
</main>
<%@ include file="./footer_JYC.jsp"%>
</body>
</html>