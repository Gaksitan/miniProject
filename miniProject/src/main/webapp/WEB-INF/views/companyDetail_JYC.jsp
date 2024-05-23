<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/main.css" />
<style type="text/css">
	.pages{
		display : flex;
		flex-direction : row;
	}
	
	.enlists{
		display : flex;
		flex-direction : column;
		align-items : center;
		justify-content : center;
	}
	
	ul li{
		list-style: none;
	}
	ul li a{
		margin: 5px;
	}
</style>

</head>
<body>
	<%@ include file="./header_JYC.jsp"%>
	<main>
		<h1>${company.cname }</h1>
		<div id="unsubsDiv">
			<c:if test="${subscribetf == true }">
				<input type="button" value="구독"
					style="color: black; background: red;" onclick="unsubscribe(event)"
					id="unsbscribeBtn">
				<!-- location.href='/company/unsubscribe?cno=${company.cno}' -->
			</c:if>
		</div>
		<div id="subsDiv">
			<c:if test="${subscribetf == false }">
				<input type="button" value="구독"
					style="color: black; background: gray;" onclick="subscribe(event)"
					id="subscribeBtn">
				<!-- location.href='/company/subscribe?cno=${company.cno}' -->
			</c:if>
		</div>
		<p>${company.cintro }</p>
		<input type="button" value="더보기">
		
		<div class="enlists">
		<c:if test="${enlist != null }">
			<table>
				<tbody>
					<c:forEach var="en" items="${enlist }" varStatus="status">
						<tr>
							<c:if test="${mid == null && companyManager == null }">
								<td><a href="/employnotice/detailNoneMem?enno=${en.enno }">${en.entitle }</a></td>
							</c:if>
							<c:if test="${mid != null }">
								<td><a href="/employnotice/detailMem?enno=${en.enno }">${en.entitle }</a></td>
							</c:if>
							<c:if test="${companyManager != null }">
								<td><a href="/employnotice/detailNoneCom?enno=${en.enno }">${en.entitle }</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<c:if test="${!paging.isEmpty() }">
				<ul class="pages">
				<c:if test="${hasPrevious == true }">
	           		<li class="page-item"> 
	           			<a class="page-link"
							href="/page/companyEmployNotice?page=${currentPage-1}&cno=${company.cno}"><span>이전</span> 
						</a>
					</li>
					</c:if>
					<c:forEach begin="1" end="${totalPages }" varStatus="status">
						<li><a href="/page/companyEmployNotice?page=${status.count }&cno=${company.cno}">${status.count }</a></li>
					</c:forEach>
					<c:if test="${hasNext == true }">
		            	<li class="page-item">
			            	<a class="page-link"
									href="/page/companyEmployNotice?page=${currentPage+1}&cno=${company.cno}"> <span>다음</span> 
							</a>
						</li>
					</c:if>
				</ul>		
			</c:if>
		</c:if>
		</div>
		
		
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
		<c:if test="${recommendList != null }">
			<table>
				<caption>기업 추천</caption>
				<tbody>
					<c:forEach var="recommend" items="${recommendList }"
						varStatus="status">
						<tr>
							<c:if test="${mid == null && companyManager == null }">
								<td><a href="/company/detailNoneMem?cno=${recommend.cno }">${recommend.cname }</a></td>
							</c:if>
							<c:if test="${mid != null}">
								<td><a href="/company/Mem?cno=${recommend.cno }">${recommend.cname }</a></td>
							</c:if>
							<c:if test="${companyManager != null }">
								<td><a href="/company/detailCom?cno=${recommend.cno }">${recommend.cname }</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</main>
	<%@ include file="./footer_JYC.jsp"%>
	<script type="text/javascript">
		function unsubscribe(event) {
			const xhr = new XMLHttpRequest();
			xhr.open('POST', '/company/unsubscribe', true);
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onreadystatechange = function() {
				location.href = "/company/detailMem?cno=" + "${company.cno}";
			};
			const body = JSON.stringify({
				cno : "${company.cno}"
			});

			xhr.send(body);
		}

		function subscribe(event) {
			const xhr = new XMLHttpRequest();
			xhr.open('POST', '/company/subscribe', true);
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onreadystatechange = function() {
				location.href = "/company/detailMem?cno=" + "${company.cno}";
			};

			const body = JSON.stringify({
				cno : "${company.cno}"
			});
			xhr.send(body);
		}
	</script>

</body>
</html>