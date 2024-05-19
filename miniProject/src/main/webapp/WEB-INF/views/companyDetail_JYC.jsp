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
		<h1>${company.cname }</h1>
		<form action="#" method="post">
			<input type="button" value="구독">
		</form>
		<p>${company.cintro }</p>
		<input type="button" value="더보기">
		
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
		
		<table>
			<thead>
				<tr>
					<th>작성자</th>
					<th>평점 점수</th>
					<th>리뷰</th>
					<th>작성날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="smc" items="${${smclist }" varStatus="status">
					<tr>
						<td>${smc.mid }</td>
						<td>${smc.smcscore }</td>
						<td>${smc.smcreview }</td>
						<td>${smc.smcregdate }</td>
					</tr>
				</c:forEach>			
			</tbody>
		</table>
	</main>
	<%@ include file="./footer_JYC.jsp" %>
</body>
</html>