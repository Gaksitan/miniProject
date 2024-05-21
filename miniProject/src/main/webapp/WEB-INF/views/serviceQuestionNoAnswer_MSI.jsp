<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./header_JYC.jsp"%>

<h1>질문 미답변 리스트</h1>

	<table border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
		<thead>
			<tr>
				<th>질문제목</th>
				<th>질문내용</th>
				<th>작성자</th>
				<th>작성날짜</th>
				<th>회원분류</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list}" varStatus="status">
				<tr>
					<td><a href="/admin/serviceQuestionAnswer?sqno=${dto.sqno}">${dto.sqtitle}</a></td>
					<td>${dto.sqcontent}</td>
					<c:if test="${dto.mid != null}">
							<td>${dto.mid}</td>
					</c:if>
					<c:if test="${dto.cno != null}">
						<td>${dto.cno}</td>
					</c:if>		
					<td>${dto.sqregdate}</td>
					<c:if test="${dto.mid != null}">
							<td>개인회원</td>
					</c:if>
					<c:if test="${dto.cno != null}">
						<td>기업회원</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
<%@ include file="./footer_JYC.jsp"%>	
</body>
</html>