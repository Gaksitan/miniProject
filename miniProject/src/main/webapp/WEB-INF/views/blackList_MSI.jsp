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
input[type="text"] {
    height: 15px;
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 200px; /* 테두리와 패딩을 제외한 실제 너비 */
}


/* 폼 그리드 스타일 */
form {
    max-width: 400px;
    margin: 0 auto; /* 가운데 정렬 */
    padding: 20px; /* 폼 주위의 간격 */
    text-align :left;

}

</style>
<body>
<%@ include file="./header_JYC.jsp"%>


<h1>블랙리스트 목록</h1>

<form method="get" action="/admin/accountSearch">
	계정 검색 : <input type="search" name="search" size="30"> 
	<input type="submit" value="검색">
</form>


<h4>개인회원</h4>
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


<h4>기업회원</h4>
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


<%@ include file="./footer_JYC.jsp"%>
</body>
</html>