<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>커뮤니티 상세페이지</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
</style>
</head>
<body>
	<%@ include file="./header_JYC.jsp"%>
	<h1>커뮤니티 상세페이지</h1>
	<hr>
	<h3>${boardDetail[0].btitle}</h3>
	<img src="/resources_KHJ/img_KHJ/emptyheart.png" id="like" width="15"
		height="15" />
	<span>작성자</span>
	<span>${boardDetail[0].mid}</span>
	<!--작성자 아이디가 아닌 이름이 와야할 것 같기도-->
	<p>${boardDetail[0].bcontent}</p>
	<span>태그</span>
	<c:forEach var="tags" items="${tagList }">
		<span>${tags.value }</span>
	</c:forEach>
	<br>
	<br>
	<form action="replyInsert.do" method="get">
		<input type="hidden" name="bno" value="${boardDetail[0].bno}">
		<input type="hidden" name="mid" value="${sessionScope.mid}"> <label
			for="reply">댓글 작성하기</label> <input id="reply" name="reply"
			placeholder="댓글 입력하기"> <input type="submit" value="작성">
	</form>
	<table border="1">
		<thead>
			<tr>
				<th>작성자</th>
				<th>댓글내용</th>
				<th>작성일자</th>
				<th>수정버튼(클릭 시 댓글내용이 인풋으로 바뀐다)</th>
				<th>삭제버튼</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="reply" items="${replyList }" varStatus="status">
				<tr>
					<td>${reply.mid }</td>
					<!--해당 mid의 name을 넣어야 할 것 같은데...-->
					<td>${reply.recontent }</td>
					<td>${reply.reregdate }</td>
					<td><button>수정</button></td>
					<td><button>삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		$(document).ready(function() {
			// 서버에서 전달된 값들을 JavaScript 변수에 할당
			var bno = "${boardDetail[0].bno}";
			var mid = "${sessionScope.mid}";
			//var mid = "happy01";

			// 콘솔에 출력하여 값이 제대로 할당되었는지 확인
			console.log("bno: " + bno);
			console.log("mid: " + mid);

			let like = $("#like");
			like.on("click", f1);

			function f1() {
				let like1 = like.attr("src");

				if (like1 === "/resources_KHJ/img_KHJ/emptyheart.png") {
					like.attr("src", "/resources_KHJ/img_KHJ/heart.png");

					$.ajax({
						url : "/commu/likeInsert.do",
						type : "post",
						data : {
							no : bno,
							id : mid
						}
					});

				} else {
					like.attr("src", "/resources_KHJ/img_KHJ/emptyheart.png");

					$.ajax({
						url : "/commu/likeDelete.do",
						type : "post",
						data : {
							no : bno,
							id : mid
						}
					});
				}
			}

		});
	</script>
	<%@ include file="./footer_JYC.jsp"%>
</body>
</html>