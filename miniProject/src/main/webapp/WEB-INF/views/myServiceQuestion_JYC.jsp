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
	
	
	<table>
		<thead>
			<tr>
				<th>문의사항 제목</th>
				<th>문의사항 내용</th>
				<th>작성날짜</th>
				<th>답변여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sq" items="${serviceQuestionList }" varStatus="status">
				<tr>
					<td><a href="/service/serviceQuestionDetail?sqno=${sq.sqno }">${sq.sqtitle }</a></td>
					<td>${sq.sqcontent }</td>
					<td>${sq.sqregdate }</td>
					<td>${sq.sqanswertf }</td>
				</tr>			
			</c:forEach>		
		</tbody>
	</table>
	
	</main>
	
	<%@ include file="./footer_JYC.jsp" %>
</body>
</html>