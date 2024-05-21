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

		<c:forEach var="employNotice" items="${employNoticeList }" varStatus="status">
			<div class="items">
				<ul>
					<c:if test="${mid == null && companyManager == null }">
					<li><a href="/employnotice/detailNoneMem?enno=${employNotice.enno }">${employNotice.entitle }</a></li>
					</c:if>
					<c:if test="${mid != null }">
					<li><a href="/employnotice/detailMem?enno=${employNotice.enno }">${employNotice.entitle }</a></li>
					</c:if>
					<c:if test="${companyManager != null }">
					<li><a href="/employnotice/detailCom?enno=${employNotice.enno }">${employNotice.entitle }</a></li>
					</c:if>
					<li>${employNotice.enposition }</li>
					<li>${employNotice.enenddate }</li>
				</ul>
			</div>
		</c:forEach>


	</main>

	<%@ include file="./footer_JYC.jsp"%>
</body>
</html>