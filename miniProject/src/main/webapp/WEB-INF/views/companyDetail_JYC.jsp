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
		<h1>${company.cname }</h1>
		<c:if test="${subscribetf == true }">
			<input type="button" value="구독"
				style="color: black; background: red;"
				onclick="location.href='/company/unsubcribe?cno=${company.cno}'">
		</c:if>
		<c:if test="${subscribetf == false }">
			<input type="button" value="구독"
				style="color: black; background: gray;"
				onclick="location.href='/company/subscribe?cno=${company.cno}'">
		</c:if>
		<p>${company.cintro }</p>
		<input type="button" value="더보기">
		<c:if test="${enlist != null }">
			<table>
				<tbody>
					<c:forEach var="en" items="${enlist }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>${en.entitle }</td>
							<td>${status.count }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<table>
			<tbody>
				<tr>
					<td>기업명</td>
					<td>${company.cname }</td>
				</tr>
				<tr>
					<td>설립연도</td>
					<td>${company.cfoundation }</td>
				</tr>
				<tr>
					<td>직원수</td>
					<td>${company.camount }</td>
				</tr>
				<tr>
					<td>기업형태</td>
					<td>${company.ctype }</td>
				</tr>
			</tbody>

		</table>

		<c:if test="${smclist != null }">
			<table>
				<caption>평점</caption>
				<thead>
					<tr>
						<th>작성자</th>
						<th>평점 점수</th>
						<th>리뷰</th>
						<th>작성날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="smc" items="${smclist }" varStatus="status">
						<tr>
							<td>${smc.mid }</td>
							<td>${smc.smcscore }</td>
							<td>${smc.smcreview }</td>
							<td>${smc.smcregdate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${mid != null }">
		<form action="#" method="post">
			<c:if test="${resumeList == null }">
			<input type="button" onclick="alert('지원할 이력서가 존재하지 않습니다!');" value="지원하기">
			</c:if>
			<c:if test="${resumeList != null }">
			<input type="button" onclick="apply()" value="지원하기">
			</c:if>
		</form>
		</c:if>
		<div id="application" style="background: black; display: none;">
			<table>
				<tbody>
					<c:forEach var="resume" items="${resumeList }" varStatus="status">
					<c:if test="${resume.rpublic == 1 }">
					<tr>
						<td>${resume.rtitle }</td>
						<td><input type="radio" name="checkReume"></td>
					</tr>
					</c:if>
					</c:forEach>
				</tbody>			
			</table>
			<form action="">
				<input type="button" value="지원하기" onclick="">
			</form>
		</div>
		<c:if test="${recommendList != null }">
		<table>
			<caption>기업 추천</caption>
			<tbody>
				<c:forEach var="recommend" items="${recommendList }"
					varStatus="status">
					<tr>
						<td>${recommend.cname }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
	</main>
	<%@ include file="./footer_JYC.jsp"%>
	<script type="text/javascript">
		function apply() {
			const application = document.querySelector("#application");
			application.style.display = 'block';
		}
	</script>

</body>
</html>