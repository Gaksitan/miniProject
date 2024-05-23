<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../../script/script.js"></script>
</head>
<style>
	form {
		display: flex;
		
        flex-direction: column;
        align-items: center; /* 모든 자식 요소를 가로로 중앙 정렬 */
        /*justify-content: center; /* 모든 자식 요소를 세로로 중앙 정렬 (필요에 따라 사용) */
        width: 50%; /* 필요에 따라 조정 */
        margin: auto;
        padding: 20px;
        border: 1px solid #ccc;
	}
</style>
<body>
<%@ include file="./header_JYC.jsp"%>
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
		<h3>스킬 (skill)</h3>
		<div id="rskillContainer">
			<c:forEach var="rskill" items="${skillList }">
				스킬명 : <input type="text" name="rskill" value="${rskill.skname }"><br>
			</c:forEach>
		</div>
		<button type="button" onclick="addRskill()">추가</button>
		<h3>경력</h3>
		<div id="rexpContainer">
			<c:forEach var="rexp" items="${experienceList }">
				경력 : <input type="text" name="rexp" value="${rexp.exname }"><br>
			</c:forEach>
		</div>
		<button type="button" onclick="addRexp()">추가</button>
		<h3>학력</h3>
		<div id="rdegreeContainer">
			<c:forEach var="rdegree" items="${degreeList }">
				학력 : <input type="text" name="rdegree" value="${rdegree.dename }"><br>
			</c:forEach>
		</div>
		<button type="button" onclick="addRdegree()">추가</button>
		<h3>자격증</h3>
		<div id="rcertificateContainer">
			<c:forEach var="rcertificate" items="${certificateList }">
				스킬명 : <input type="text" name="rcertificate" value="${rcertificate.cename }"><br>
			</c:forEach>
		</div>
		<button type="button" onclick="addRcertificate()">추가</button>
		<h3>링크 (link)</h3>
		<div id="rlinkContainer">
			<c:forEach var="rlink" items="${linkList }">
				스킬명 : <input type="text" name="rlink" value="${rlink.lname }"><br>
			</c:forEach>
		</div>
		<button type="button" onclick="addRlink()">추가</button>
		
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
		<h2><input type="text" name="rtitle" value="${resume.rtitle }"><input type="image" name="rimgPath" src="" alt="증명사진"></h2>
		<ul>
			<li>${member.mname }</li>
			<li>${member.memail }</li>
			<li>(${member.mtel1 }) ${member.mtel2 }</li>
		</ul><br>
		<h3>자기소개</h3>
		<input type="text" name="rintro" value="${resume.rintro }"><br>
		<h3>스킬 (skill)</h3>
		<div id="rskillContainer">
			<c:forEach var="rskill" items="${skillList }">
				<h5>스킬명 : ${rskill.skname }<input type="hidden" name="rskill"><button type="button" onclick="deleteData(event)">삭제</button></h5>
			</c:forEach>
		</div>
		<button type="button" onclick="addRskill()">추가</button>
		<h3>경력</h3>
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
						<td>${rexp.exname }</td>
						<td>${rexp.exjoindate }</td>
						<td>${rexp.leavedate }</td>
						<td>${rexp.exposition }</td>
						<td>${rexp.exrank }</td>
						<td><button type="button" onclick="deleteDataTable(event)">삭제</button></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<button type="button" onclick="addRexp()">추가</button>
		<h3>학력</h3>
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
		<button type="button" onclick="addRdegree()">추가</button>
		<h3>자격증</h3>
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
		<button type="button" onclick="addRcertificate()">추가</button>
		<h3>링크 (link)</h3>
		<div id="rlinkContainer">
			<c:forEach var="rlink" items="${linkList }">
				<h4>링크 : ${rlink.lname }<button type="button" onclick="deleteData(event)">삭제</button></h4>
			</c:forEach>
		</div>
		<button type="button" onclick="addRlink()">추가</button>
		
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
		<input type="submit" value="수정"><input type="button" value="취소" onclick="location.href='/mem/myResumeList'">
	</form>
</c:if>
<%@ include file="./footer_JYC.jsp"%>
</body>
</html>