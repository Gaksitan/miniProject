<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	
	#container {
	width: 80%;
	margin: 0 auto;
	display: grid;
	grid-template-columns: repeat(4, 1fr);
	gap: 20px;
	}

	.items{
		border: 1px solid black;
	}
	ul li{
		list-style: none;
	}
	.items{
		width: 200px;
		height: 200px;
		background: gray;
	}
</style>
<link rel="stylesheet" href="../css/main.css" />

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
				<thead>
					<tr>
						<th>경력명</th>
						<th>재직날짜</th>
						<th>퇴사날짜</th>
						<th>직무</th>
						<th>직급</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="experience" items="${experienceEmployNoticeList }"
						varStatus="status">
						<tr>
							<td>${experience.exname }</td>
							<td>${experience.exjoindate }</td>
							<td>${experience.exleavedate }</td>
							<td>${experience.exposition }</td>
							<td>${experience.exrank }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${skillEmployNoticeList != null }">
			<table>
				<caption>스킬스텟</caption>
				<thead>
					<tr>
						<th>스킬명</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="skill" items="${skillEmployNoticeList }"
						varStatus="status">
						<tr>
							<td>${skill.skname }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${degreeEmployNoticeList != null }">
			<table>
				<caption>학력</caption>
				<thead>
					<tr>
						<th>학교명</th>
						<th>졸업날짜</th>
						<th>전공</th>
						<th>최종학력</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="degree" items="${degreeEmployNoticeList }"
						varStatus="status">
						<tr>
							<td>${degree.dename }</td>
							<td>${degree.degraddate }</td>
							<td>${degree.demajor }</td>
							<td>${degree.dehighestlevel }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${welfareEmployNoticeList != null }">
			<table>
				<caption>복지</caption>
				<thead>
					<tr>
						<th>복지명</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="welfare" items="${welfareEmployNoticeList }"
						varStatus="status">
						<tr>
							<td>${welfare.wname }</td>
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
			<input type="button" value="지원하기"
				onclick="alert('지원하실 대표 이력서가 없습니다!');">
		</c:if>
		<c:if test="${resume != null }">
			<input type="button" value="지원하기" onclick="applyResume()">
		</c:if>
		<h2>채용공고 추천</h2>
		<c:if test="${recommendList != null }">
				<div id="container">
			<c:forEach var="recommend" items="${recommendList }"
				varStatus="status">
				<ul class="items">
					<c:if test="${mid == null && companyManager == null }">
						<li><a href="/employnotice/detailNoneMem?enno=${recommend.enno }">${recommend.entitle }</a></li>
					</c:if>
					<c:if test="${mid != null }">
						<li><a href="/employnotice/detailMem?enno=${recommend.enno }">${recommend.entitle }</a></li>
					</c:if>
					<c:if test="${companyManager != null }">
						<li><a href="/employnotice/detailNoneCom?enno=${recommend.enno }">${recommend.entitle }</a></li>
					</c:if>
						<li>${recommend.enposition }</li>
						<li>${recommend.cname }</li>
				</ul>
			</c:forEach>
				</div>
		</c:if>
	</main>

	<%@ include file="./footer_JYC.jsp"%>

	<script type="text/javascript">
		
	</script>

	<script type="text/javascript">
		function applyResume() {
			const xhr = new XMLHttpRequest();
			xhr.open('POST', '/employnotice/applyResume', true);
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onload = function() {
				alert(this.responseText);
			}
			const data = JSON.stringify({
				enno : '${employNoticeDto.enno }',
				rno : '${resume.rno}'
			});
			xhr.send(data);
		}
	</script>
</body>
</html>