<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>공지사항 상세페이지</h1>

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
    
<c:if test="${sessionScope.ano == 'ano1' or sessionScope.ano == 'ano2' or sessionScope.ano == 'ano3'}">
    <div id="div1">
        <a href="/admin/infoAdmin?nno=${notice.nno}">수정하기</a>
    </div>
</c:if>


</body>
</html>