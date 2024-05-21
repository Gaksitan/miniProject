<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>내 이력서 상세 페이지 개인회원용 헤더 위치</h1>
<hr>
<h3>이력서 상세페이지 관리</h2>
<c:if test="${rno == null }">
	<form action="writeResume" method="post" enctype="multipart/form-data">
	<input type="hidden" name="rno" value="${rno }">
		<h2>이력서 제목</h2>
		<input type="text" name="rtitle"> <input type="image" src=""><br>
		<ul>
			<li>${member.mname }</li>
			<li>${member.memail }</li>
			<li>(${member.mtel1 }) ${member.mtel2 }</li>
		</ul><br>
		<h3>자기소개</h3>
		<input type="text" name="rintro"><br>
		<h3>스킬 (skill)</h3>
		<div id="skillForm" style="display: none;">
			
		</div>
		<input type="text" name="rskill"><br>
		<h3>경력</h3>
		<input type="text" name="rexp"><br>
		<h3>학력</h3>
		<input type="text" name="rdegree"><br>
		<h3>자격증</h3>
		<input type="text" name="rcertificate"><br>
		<h3>링크 (link)</h3>
		<input type="text" name="rlink"><br>
		<h3>병력 특혜(임시)</h3>
		<label><input type="radio" name="militery" value="0">해당없음</label>
		<label><input type="radio" name="militery" value="1">군필자</label>
		<label><input type="radio" name="militery" value="2">미필자</label><br>
		<h3>공개여부<label><input type="radio" name="rpublic" value="1">공개</label>
			<label><input type="radio" name="rpublic" value="0">비공개</label></h3>
		<label><input type="checkbox" name="rmain" value="1">대표 이력서로 설정</label><br>
		<input type="submit" value="저장"><input type="button" value="취소">
	</form>
</c:if>
<c:if test="${rno != null }">
	<form action="updateResume" method="post">
		<input type="hidden" name="rno" value="${rno }">
		<h2><input type="text" name="rtitle" value="${resume.rtitle }"></h2>
		<ul>
			<li>${member.mname }</li>
			<li>${member.memail }</li>
			<li>(${member.mtel1 }) ${member.mtel2 }</li>
		</ul><br>
		<h3>자기소개</h3>
		<input type="text" name="rintro" value="${resume.rintro }"><br>
		<h3>스킬 (skill)</h3>
		<input type="text" name="rskill" value="${resume.rskill }"><br>
		<h3>경력</h3>
		<input type="text" name="rexp" value="${resume.rexp }"><br>
		<h3>학력</h3>
		<input type="text" name="rdegree" value="${resume.rdegree }"><br>
		<h3>자격증</h3>
		<input type="text" name="rcertificate" value="${resume.rcertificate }"><br>
		<h3>링크 (link)</h3>
		<input type="text" name="rlink" value="${resume.rlink }"><br>
		<h3>병력 특혜(임시)</h3>
		<label><input type="radio" name="militery" value="0">해당없음</label>
		<label><input type="radio" name="militery" value="1">군필자</label>
		<label><input type="radio" name="militery" value="2">미필자</label><br>
		<h3>공개여부<label><input type="radio" name="rpublic" value="1">공개</label>
			<label><input type="radio" name="rpublic" value="0">비공개</label></h3>
		<label><input type="checkbox" name="rmain" value="1">대표 이력서로 설정</label><br>
		<input type="submit" value="수정"><input type="button" value="취소" onclick="goBack()">
	</form>
</c:if>
<script>
	function goBack(){
		window.location.href = "myResumeList";
	}
</script>
</body>
</html>