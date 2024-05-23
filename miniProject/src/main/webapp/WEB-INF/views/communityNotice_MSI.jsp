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

table {
  border-collapse: collapse;
  width: 600px;
  margin: 3rem auto;
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
  background-color: #5B85AC;
  color: white;
}


/* 테이블 비율 */
th:nth-child(1),
td:nth-child(1) {
  width: 15%;
}

th:nth-child(2),
td:nth-child(2) {
  width: 55%;
}

th:nth-child(3),
td:nth-child(3) {
  width: 30%;
}

#div1{
	display : flex;
	justify-content : center;

}

#alink{
	display: inline-block;
	width : 170px;
	text-align : center;
	background-color : #FCEFA9;
	padding : 10px;
	font-weight: bold;
}

</style>

<body>
<%@ include file="./header_JYC.jsp"%>

<section>
<h3>공지사항 상세페이지</h3>
<hr>

<div>
    <table border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
		<colgroup>
			<col width="250px" />
			<col />
		</colgroup>

		<tbody>
			<tr>
				<th>공지제목</th>
				<td>${notice.ntitle }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>관리자</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${notice.nregdate }</td>
			</tr>
			<tr>
				<th>공지내용</th>
				<td>${notice.ncontent }</td>
			</tr>
					
		</tbody>
	</table>
</div>

    <div id="div1">
		<c:if test="${sessionScope.ano == 'ano1' or sessionScope.ano == 'ano2' or sessionScope.ano == 'ano3'}">
		    <a id="alink" href="/admin/infoAdmin?nno=${notice.nno}">수정하기</a>
		</c:if>
	</div>
	
</section>

<%@ include file="./footer_JYC.jsp"%>
</body>
</html>