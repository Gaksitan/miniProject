<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
section{
	margin : 20px;
	height : 800px;
}

.container{
	display : flex;
	flex-direction : row;
	margin : 50px auto;
	justify-content: center;
	width : 1200px;
	height : 350px;
}


table {
  border-collapse: collapse;
  width: 800px;
  margin: 30px auto;
  
  border: 1px solid #ddd;
  background-color: white;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  border-collapse: collapse;
  border-radius: 5px;
}

/* 테이블 행 */
th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
  text-align: center;
}

th {
  background-color:#5B85AC;
  color: white;
}

/* 테이블 올렸을 때 */
tbody tr:hover {
  background-color: #d3d3d3;
  opacity: 0.9;
  cursor: pointer;
}

/* 테이블 비율 */
th:nth-child(1),
td:nth-child(1) {
  width: 50%;
}

.alink{
	display : flex;
	justify-content : center;
	align-items : center;
}

#ex1, #ex2{
	display: inline-block;
	width : 170px;
	text-align : center;
	background-color : #FCEFA9;
	padding : 10px;
	font-weight: bold;
	border : 1.5px solid darkgrey;
	margin-right : 20px;
}

#tbl1{
	margin-right : 30px;
}

</style>
<body>

<%@ include file="./header_JYC.jsp"%>



<section>

<h3>FAQ 관리페이지</h3>
<hr>


<div class="container">
	<div class="tbl" id="tbl1">
		<h3>질문(개인)</h3>
		<table border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
			
			<thead>
				<tr>
					<th>질문</th>
					<th>답변</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="faq" items="${faqList}" >
					<c:if test="${faq.faqtarget == 'member'}">
						<tr>
							<td>${faq.faqquestion}</td>
							<td>${faq.faqanswer}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="tbl">
		<h3>질문(기업)</h3>
		<table border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
			<thead>
				<tr>
					<th>질문</th>
					<th>답변</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="faq" items="${faqList}" >
					<c:if test="${faq.faqtarget == 'company'}">
						<tr>
							<td>${faq.faqquestion}</td>
							<td>${faq.faqanswer}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>	
	<div class="alink">
		<a id="ex1" href="/admin/serviceFAQWrite">FAQ 작성하기</a>
		<a id="ex2" href="/admin/serviceQuestionNoAnswer">미답변 질문 확인하기</a>
	</div>

</section>


<%@ include file="./footer_JYC.jsp"%>
</body>
</html>