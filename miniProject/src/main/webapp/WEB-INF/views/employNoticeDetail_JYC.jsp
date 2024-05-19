<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="./header_JYC.jsp" %>
	
	<main>
	<h1><a href="/company/detail?cno=${company.cno }">${company.cname }</a></h1>
	<form action="#" method="post">
		<input type="button" value="스크랩">
	</form>
	<h2>${employNoticeDto.entitle }</h2>
	<p>${employNoticeDto.enintro }</p>
	<table>
		<caption>경력</caption>
		<tbody>
			<c:forEach var="experience" items="${experienceEmployNoticeList }" varStatus="status">
				<tr>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<caption>스킬스텟</caption>
		<tbody>
			<c:forEach var="skill" items="${skillEmployNoticeList }" varStatus="status">
				<tr>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<caption>학력</caption>
		<tbody>
			<c:forEach var="degree" items="${degreeEmployNoticeList }" varStatus="status">
				<tr>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<caption>복지</caption>
		<tbody>
			<c:forEach var="welfare" items="${welfareEmployNoticeList }" varStatus="status">
				<tr>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>연봉</h2>
	<span>${employNoticeDto.ensalary }</span>
	<h2>상세주소</h2>
	<span>${employNoticeDto.enaddr }</span>
	
	</main>
	
	<%@ include file="./footer_JYC.jsp" %>
</body>
</html>