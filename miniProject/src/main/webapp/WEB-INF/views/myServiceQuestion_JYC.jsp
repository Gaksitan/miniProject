<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		border-collapse: collapse;
		margin: 0 auto;
		
	}
	th{
		background: #fcefa9;
	}
	th, td{
		padding: 10px 20px;
	}
	p{
		text-align: center;
		color: red;
	}
</style>
<link rel="stylesheet" href="../css/main.css" />

</head>
<body>
	<%@ include file="./header_JYC.jsp" %>
	
	<main>
	<c:if test="${serviceQuestionList != null }">
	<c:if test="${mid != null }"> <!-- mid가 널이 아니명 개인회원이기 때문에 문의하기 기능을 선택할 수 있다. -->	
		<input type="button" value="문의하기" id="regQBtn" onclick="location.href='/both/registQuestionForm'">
	</c:if> 
	<table border="1">
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
					<c:if test="${sq.sqanswertf == false }">
					<td>X</td>
					</c:if>
					<c:if test="${sq.sqanswertf == true }">
					<td>O</td>
					</c:if>
				</tr>			
			</c:forEach>		
		</tbody>
	</table>
	</c:if>
	<c:if test="${serviceQuestionList == null }">
	<p>작성한 문의사항이 없습니다.</p>
	<c:if test="${mid != null }"> <!-- mid가 널이 아니명 개인회원이기 때문에 문의하기 기능을 선택할 수 있다. -->	
		<input type="button" value="문의하기" id="regQBtn" onclick="location.href='/both/registQuestionForm'">
	</c:if> 
	</c:if>	
	</main>
	
	<%@ include file="./footer_JYC.jsp" %>
</body>
</html>