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
					<td><a href="serviceQuestionDetail?sqno=${dto.sqno}">${dto.sqtitle}</a></td>
					<td>${dto.sqcontent}</td>
					<c:choose>
						<c:when test="${dto.mid != null}">
							<td>${dto.mid}</td>
						</c:when>
						<c:when test="${dto.cno != null}">
							<td>${dto.cno}</td>
						</c:when>
					</c:choose>
					<td>${dto.sqregdate}</td>
					<c:choose>
						<c:when test="${dto.mid != null}">
							<td>개인회원</td>
						</c:when>
						<c:when test="${dto.cno != null}">
							<td>기업회원</td>
						</c:when>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>