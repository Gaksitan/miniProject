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
	
	<button type="button" onclick="location.href='communityMemInsert_KHJ'">게시글 작성하기</button>
	<input placeholder="작성자, 게시물 제목"></input><button type="submit" class="s1"><img src="/resources/img_KHJ/돋보기.png"/></button>
	<select>
		<!--<option value="">추천순</option> 클릭 많은 순 -->
		<option value="">댓글순</option>
		<option value="">인기순</option> <!-- 좋아요 많은 순 -->
		<option value="">최신순</option>
	</select>
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
					<td>${board.btitle}</td>
					<td>${board.mid}</td>
					<td>${board.bregdate }</td>
					<td>${board.blike }</td>
				</tr> <!--<a href="view?btitle=${board.btitle}"></a>-->
			</c:forEach>
		</tbody>
	</table>
</body>
</html>