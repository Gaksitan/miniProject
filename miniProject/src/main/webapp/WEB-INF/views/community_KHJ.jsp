<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>

img {

width : 15px;
height : 15px;

}
</style>
</head>
<body>
	<h1>community</h1>
	<hr>
	
	
	<!-- 세션ID가 블랙리스트에 있는 ID라면 게시글 작성하기 버튼을 누르면 알림창이 뜨면서 작성페이지로 이동못하게 함 -->
	<c:if test="${not empty errorMessage}">
        <script>
            alert('${errorMessage}');
        </script>
    </c:if>
    
    
	
	<button type="button" onclick="location.href='/commu/communityMemInsert_KHJ'">게시글 작성하기</button>
	<input placeholder="작성자, 게시물 제목"></input><button type="submit" class="s1"><img src="/resources/img_KHJ/돋보기.png"/></button>
	<select>
		<!--<option value="">추천순</option> 클릭 많은 순 -->
		<option value="">댓글순</option>
		<option value="">인기순</option> <!-- 좋아요 많은 순 -->
		<option value="">최신순</option>
	</select>
	
	
	
	
	<!-- 공지사항 테이블 추가 -->
	
	<table border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
		<thead>
			<tr>
				<th>공지번호</th>
				<th>공지제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="notice" items="${noticeList }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td><a href="/commu/communityNotice_MSI?nno=${notice.nno}">${notice.ntitle}</a></td>
					<td>${notice.ano}</td>
					<td>${notice.nregdate}</td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	

	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>게시물 제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${list }" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td><a href="/commu/communityDetail_KHJ?bno=${board.bno}">${board.btitle}</a></td>
					<c:choose>
					    <c:when test="${board.mid != null}">
					        <td>${board.mid}</td>
					    </c:when>
					    <c:when test="${board.cmid != null}">
					        <td>${board.cmid}</td>
					    </c:when>
					    <c:otherwise>
					        <td>No ID available</td>
					    </c:otherwise>
					</c:choose>
					<td>${board.bregdate }</td>
					<td>${board.blike }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>