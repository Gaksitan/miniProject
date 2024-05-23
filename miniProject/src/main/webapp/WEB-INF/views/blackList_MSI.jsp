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
	margin : 0 auto;
	justify-content: center;
	width : 1200px;
	height : 350px;
}

input[type="search"] {
    height: 30px;
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 200px; /* 테두리와 패딩을 제외한 실제 너비 */
}

/* 폼 그리드 스타일 */
#searchForm {
    max-width: 400px;
    margin: 0 auto; /* 가운데 정렬 */
    padding: 20px; /* 폼 주위의 간격 */
    text-align :left;
}


input[type="submit"] {
    width: 60px;
    height: 30px;
    font-size: 15px;
    border: 0;
    outline: 1.5px rgb(68, 136, 244) solid;
    border-radius: 5px;
    padding-left: 10px;
    background-color: rgb(164, 199, 255);
}

input[type="submit"]:hover {
    width: 60px;
    height: 30px;
    font-size: 15px;
    border: 0;
    border-radius: 5px;
    outline: 1.5px rgb(27, 76, 155) solid;
    padding-left: 10px;
    background-color: rgb(68, 136, 244);
}


.tbl{
	padding : 30px;
	text-align: center;
}

thead {
  font-weight: bold;
  color: #fff;
  background: #5B85AC;
  padding : 8px;
}

table {
  border: 1px #a39485 solid;
  font-size: 1em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th,td{
	padding : 8px;
}

a {
  color: #FE2E64;
  text-decoration: none;
  font-weight : bold;
}

a:hover,
a:focus {
  text-decoration: underline;
}

</style>
<body>

<%@ include file="./header_JYC.jsp"%>



<section>

<h3>블랙리스트 목록 페이지</h3>
<hr>

<div id="search">
	<form method="get" action="/admin/accountSearch" id="searchForm">
		<img src="../resources_KHJ/img_KHJ/돋보기.png" style="width:30px; height:30px">
		계정 검색  <input type="search" name="search" size="30"> 
		<input type="submit" value="검색">
	</form>
</div>

<div class="container">
	
	<div class="tbl">
		<h3>개인회원 차단목록</h3><br>
		<table border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
			<thead>
			<tr>
				<th>멤버아이디</th><th>차단날짜</th><th>관리자아이디</th><th>차단해제</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="black" items="${blackList }">
					<c:if test="${black.mid != null}">
						<tr>
							<td>${black.mid}</td>
							<td>${black.bregdate }</td>
							<td>${black.ano }</td>
							<td><a href="/admin/unblock?bano=${black.bano}">차단해제</a></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>

	
	<div class="tbl">
		<h3>기업회원 차단목록</h3><br>
		<table  border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
			<thead>
			<tr>
				<th>사업자번호</th><th>차단날짜</th><th>관리자아이디</th><th>차단해제</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="black" items="${blackList }">
					<c:if test="${black.cno != null}">
						<tr>
							<td>${black.cno }</td>
							<td>${black.bregdate }</td>
							<td>${black.ano }</td>
							<td><a href="/admin/unblock?bano=${black.bano}">차단해제</a></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

</section>

<%@ include file="./footer_JYC.jsp"%>
</body>
</html>