<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#faqtable{
	margin: 0 auto;
	border-collapse: collapse;
}
#faqtable th{
	background: rgb(252, 239, 169);
}
#faqtable th, #faqtable td{
	padding: 5px 20px;
}
#faqtable a{
	text-decoration: none;
	color: black;
}

form{
	width: fit-content;
	margin: 20px auto;
	
}
form input[type="search"]{
	padding: 5px 10px;
}
form input[type="submit"]{
	padding: 0px 5px;
}


</style>
<link rel="stylesheet" href="../css/main.css" />


</head>
<body>
	<%@ include file="./header_JYC.jsp"%>
	<main>
		<c:if test="${companyManager == null }">
			<form action="/service/searchMem">
				<input type="search" placeholder="FAQ 검색" name="keyword"> <input
					type="submit" value="검색">
			</form>
		</c:if>
		<c:if test="${companyManager != null }">
			<form action="/service/searchCom">
				<input type="search" placeholder="FAQ 검색" name="keyword"> <input
					type="submit" value="검색">
			</form>
		</c:if>

		<table id="faqtable" border="1">
		 	<thead>
		 		<tr>
		 			<th>카테고리</th>
		 			<th>질문</th>
		 		</tr>
		 	</thead>
			<tbody>
				<c:forEach var="faq" items="${faqlist }">
					<tr>
						<td>${faq.qcname}</td>
						<td><a href="/service/faqDetail?faqno=${faq.faqno }">${faq.faqquestion }</a></td>							
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>

	<%@ include file="./footer_JYC.jsp"%>
</body>
</html>