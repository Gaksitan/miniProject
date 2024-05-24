<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/main.css" />
<style type="text/css">
table {
	border-collapse: collapse;
	width: 1000px;
	margin: 0 auto;
}

th, td {
	padding: 5px 20px;
}

</style>
</head>
<body>
	<%@ include file="./header_JYC.jsp"%>
	<main>
		<hr>
		<c:if test="${subscribeList != null }">
			<table border="1">
				<caption>구독</caption>
				<thead>
					<tr>
						<th>회사명</th>
						<th>기업형태</th>
						<th>업종</th>
						<th>소개글</th>
						<th>구독</th>
					</tr>
				</thead>
				<tbody id="subtable">

					<c:forEach var="subscribe" items="${subscribeList }"
						varStatus="status">
						<tr id="subsTr${subscribe.sno }">
							<td><a href="/company/detailMem?cno=${subscribe.cno }">${subscribe.cname }</a></td>
							<td>${subscribe.ctype }</td>
							<td><c:forEach var="scnames"
									items="${scnameList.get(status.index) }" varStatus="i">
									<c:if test="${!i.last }">
										<span>${scnames }</span>, 
					</c:if>
									<c:if test="${i.last }">
										<span>${scnames }</span>
									</c:if>
								</c:forEach></td>
							<td>${subscribe.cintro }</td>
							<td><input type="button" value="구독" id="${subscribe.cno }"
								class="subs${subscribe.sno }"
								onclick="unsubscribe(${subscribe.sno}, event)"
								style="background: #fcefa9;"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${!paging.isEmpty() }">
				<ul class="pagination justify-content-center"></ul>
				<c:if test="${hasPrevious == true }">
					<li class="page-item"><a class="page-link"
						href="/page/companyEmployNotice?page=${currentPage-1}&cno=${company.cno}"><span>이전</span>
					</a></li>
				</c:if>
				<c:forEach begin="1" end="${totalPages }" varStatus="status">
					<a
						href="/page/companyEmployNotice?page=${status.count }&cno=${company.cno}">${status.count }</a>
				</c:forEach>
				<c:if test="${hasNext == true }">
					<li class="page-item"><a class="page-link"
						href="/page/companyEmployNotice?page=${currentPage+1}&cno=${company.cno}">
							<span>다음</span>
					</a></li>
				</c:if>
			</c:if>
		</c:if>
		<c:if test="${scrapList != null }">
			<table border="1">
				<caption>스크랩</caption>
				<thead>
					<tr>
						<th>회사명</th>
						<th>채용공고 제목</th>
						<th>포지션</th>
						<th>스크랩</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="scrap" items="${scrapList }">
						<tr>
							<td><a href="/company/detailMem?cno=${scrap.cno }">${scrap.cname }</a></td>
							<td><a href="/employnotice/detailMem?enno=${scrap.enno }">${scrap.entitle }</a></td>
							<td>${scrap.enposition }</td>
							<td><input type="button" value="스크랩"
								id="scrap${scrap.senno }"
								onclick="unscrap(event, ${scrap.senno}, ${scrap.enno })"
								style="background: rgb(252, 239, 169)"></td>
						</tr>
					</c:forEach>
				</tbody>
				<tbody>
				</tbody>
			</table>
			<c:if test="${!paging.isEmpty() }">
				<ul class="pagination justify-content-center"></ul>
				<c:if test="${hasPrevious == true }">
					<li class="page-item"><a class="page-link"
						href="/page/companyEmployNotice?page=${currentPage-1}&cno=${company.cno}"><span>이전</span>
					</a></li>
				</c:if>
				<c:forEach begin="1" end="${totalPages }" varStatus="status">
					<a
						href="/page/companyEmployNotice?page=${status.count }&cno=${company.cno}">${status.count }</a>
				</c:forEach>
				<c:if test="${hasNext == true }">
					<li class="page-item"><a class="page-link"
						href="/page/companyEmployNotice?page=${currentPage+1}&cno=${company.cno}">
							<span>다음</span>
					</a></li>
				</c:if>
			</c:if>
		</c:if>
	</main>
	<%@ include file="./footer_JYC.jsp"%>
	<script type="text/javascript">
	function unsubscribe(sno, event){
		const xhr = new XMLHttpRequest();
		xhr.open("POST", "/company/unsubscribe2" , true);		
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.onload = function(){
			const subsClass = document.querySelector(".subs" + sno);
			console.log(subsClass.style.background);
			if(subsClass.style.background == "rgb(252, 239, 169)"){
				subsClass.style.background = "gray";
			}else {
				subsClass.style.background = "#fcefa9";
			}
		}
		const data = JSON.stringify({
			sno : sno,
			cno : event.target.id
		})
		console.log(data);
		xhr.send(data);
	}
	
	function unscrap(event, senno, enno){
		const xhr = new XMLHttpRequest();
		xhr.open("POST", "/employnotice/unscrap2" , true);		
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.onload = function(){
			const scrap = document.querySelector("#scrap" + senno);
			if(scrap.style.background == "rgb(252, 239, 169)"){
				scrap.style.background = "gray";
			}else {
				scrap.style.background = "#fcefa9";
			}
		}
		const data = JSON.stringify({
			senno : senno,
			enno : enno
		})
		xhr.send(data);
	}
</script>
</body>
</html>