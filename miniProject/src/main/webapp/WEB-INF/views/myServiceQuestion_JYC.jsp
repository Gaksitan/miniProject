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
		<tbody>
			<c:forEach var="sq" items="${serviceQuestionList }" varStatus="status">
				<tr>
					<td>${ }</td>
				
				</tr>			
			</c:forEach>		
		</tbody>
	</table>
	
	</main>
	
	<%@ include file="./footer_JYC.jsp" %>
</body>
</html>