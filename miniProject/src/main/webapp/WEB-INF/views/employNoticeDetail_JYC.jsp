<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="./header_JYC.jsp"%>

	<main>
		<c:if test="${mid == null && companyManager == null}">
			<h1>
				<a href="/company/detailNoneMem?cno=${employNoticeDto.cno }">${employNoticeDto.cname }</a>
			</h1>
		</c:if>
		<c:if test="${mid != null}">
			<h1>
				<a href="/company/detailMem?cno=${employNoticeDto.cno }">${employNoticeDto.cname }</a>
			</h1>
		</c:if>
		<c:if test="${companyManager != null}">
			<h1>
				<a href="/company/detailCom?cno=${employNoticeDto.cno }">${employNoticeDto.cname }</a>
			</h1>
		</c:if>
		<c:if test="${mid != null }">
			<c:if test="${scraptf == true }">
				<input style="background: grey; color: black;" type="button"
					id="scrap" value="스크랩"
					onclick="location.href='/employnotice/deleteScrap?enno=${employNoticeDto.enno}'">
			</c:if>
			<c:if test="${scraptf == false }">
				<input style="background: yellow; color: black;" type="button"
					id="scrap" value="스크랩"
					onclick="location.href='/employnotice/scrap?enno=${employNoticeDto.enno}'">
			</c:if>
		</c:if>
		<h2>${employNoticeDto.entitle }</h2>
		<p>${employNoticeDto.enintro }</p>
			<c:if test="${experienceEmployNoticeList != null }">
		<table>
				<caption>경력</caption>
				<tbody>
					<c:forEach var="experience" items="${experienceEmployNoticeList }"
						varStatus="status">
						<tr>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
			</c:if>
		<c:if test="${skillEmployNoticeList != null }">
		<table>
			<caption>스킬스텟</caption>
			<tbody>
				<c:forEach var="skill" items="${skillEmployNoticeList }"
					varStatus="status">
					<tr>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<c:if test="${degreeEmployNoticeList != null }">
		<table>
			<caption>학력</caption>
			<tbody>
				<c:forEach var="degree" items="${degreeEmployNoticeList }"
					varStatus="status">
					<tr>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<c:if test="${welfareEmployNoticeList != null }">
		<table>
			<caption>복지</caption>
			<tbody>
				<c:forEach var="welfare" items="${welfareEmployNoticeList }"
					varStatus="status">
					<tr>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<h2>연봉</h2>
		<span>${employNoticeDto.ensalary }</span>
		<h2>상세주소</h2>
		<span>${employNoticeDto.enaddr }</span>
		<c:if test="${resume == null }">
		<input type="button" value="지원하기" onclick="alert('지원하실 대표 이력서가 없습니다!');">
		</c:if>
		<c:if test="${resume != null }">
		<input type="button" value="지원하기" onclick="applyResume()">
		</c:if>
		<c:if test="${recommendList != null }">
		<c:forEach var="" items="${recommendList }" varStatus="status">
		<ul>
			<li></li>
		</ul>
		</c:forEach>
		</c:if>
	</main>

	<%@ include file="./footer_JYC.jsp"%>

	<script type="text/javascript">
		
	</script>
	
<script type="text/javascript">
	function applyResume(){
		const xhr = new XMLHttpRequest();
		xhr.open('POST', '/employnotice/applyResume', true);
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.onload = function(){
			alert(this.responseText);
		}
		const data = JSON.stringify({
		 	enno: '${employNoticeDto.enno }',
		 	rno:'${resume.rno}'
		});
		xhr.send(data);
	}
	
</script>
</body>
</html>