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

.inline-block {

	display: inline-block;
	vertical-align: middle;

}

.inline-block img {

	margin-right: 10px;

}
</style>
<link rel="stylesheet" href="../css/main.css" />
</head>
<body>
	<%@ include file="./header_JYC.jsp"%>
	<main>
		<h1>커뮤니티 상세페이지</h1>
		<hr>
		<fieldset>
			<p>
			<h3 class="inline-block">${boardDetail[0].btitle}</h3>

			<c:if test="${likeyesno == true }">
				<img class="inline-block" src="/resources_KHJ/img_KHJ/heart.png" id="like" width="15"
					height="15" />
			</c:if>
			<c:if test="${likeyesno == false }">
				<img class="inline-block" src="/resources_KHJ/img_KHJ/emptyheart.png" id="like"
					width="15" height="15" />
			</c:if>

			<span class="inline-block">작성자</span>
			<c:if test="${mid != null }">
				<span class="inline-block">${boardDetail[0].mid}</span>
				<!--작성자 아이디가 아닌 이름이 와야할 것 같기도-->
			</c:if>
			<c:if test="${cmid != null }">
				<span class="inline-block">${boardDetail[0].cmid}</span>
				<!--작성자 아이디가 아닌 이름이 와야할 것 같기도-->
			</c:if>
			</p>
		</fieldset>
		<p>${boardDetail[0].bcontent}</p>
		<span>태그 : </span>
		<c:forEach var="tags" items="${tagList }">
			<span>${tags.value }</span>
		</c:forEach>
		<br> <br>
		<form action="replyInsert.do" method="get">
			<input type="hidden" name="bno" value="${boardDetail[0].bno}">
			<label for="reply">댓글 작성하기</label> <input id="reply" name="reply"
				placeholder="댓글 입력" required="required" width=30 height=20 maxlength=30> <input
				type="submit" value="작성">
		</form>
		<c:choose>
			<c:when test="${not empty replyList }">
				<c:set var="hasContent" value="false" />
				<c:forEach var="reply" items="${replyList}">
					<c:if test="${not empty reply.recontent }">
						<c:set var="hasContent" value="true" />
					</c:if>
				</c:forEach>
				<c:if test="${hasContent }">
					<table border="1">
						<thead>
							<tr>
								<th>작성자</th>
								<th>댓글내용</th>
								<th>작성일자</th>
								<!-- <th>수정버튼</th> -->
								<th>삭제버튼</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="reply" items="${replyList }" varStatus="status">
								<c:if test="${not empty reply.recontent}">
									<tr>
										<c:if test="${reply.mid != null }">
											<td>${reply.mid }</td>
										</c:if>
										<c:if test="${reply.cmid != null }">
											<td>${reply.cmid }</td>
										</c:if>
										<!--해당 mid의 name을 넣어야 할 것 같은데...-->
										<td>${reply.recontent }</td>
										<td>${reply.reregdate }</td>
										<!-- <td><button>수정</button></td>  -->
										<td><a
											href="/commu/deleteReply?reno=${reply.reno }&bno=${reply.bno}"><button>삭제</button></a></td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<c:if test="${not hasContent }">
					<p>댓글이 없습니다.</p>
				</c:if>
			</c:when>
			<c:otherwise>
				<p>댓글이 없습니다.</p>
			</c:otherwise>
		</c:choose>

	</main>
	<%@ include file="./footer_JYC.jsp"%>
	<script>
		$(document)
				.ready(
						function() {
							// 서버에서 전달된 값들을 JavaScript 변수에 할당
							var bno = "${boardDetail[0].bno}";
							var mid = "${sessionScope.mid}";
							var cmid = "${sessionScope.companyManager != null ? sessionScope.companyManager.getCmid() : null}";

							// 콘솔에 출력하여 값이 제대로 할당되었는지 확인
							console.log("bno: " + bno);
							console.log("mid: " + mid);
							console.log("cmid: " + cmid);

							let like = $("#like");
							like.on("click", f1);

							function f1() {
								let like1 = like.attr("src");

								if (like1 === "/resources_KHJ/img_KHJ/emptyheart.png") {
									like.attr("src",
											"/resources_KHJ/img_KHJ/heart.png");
									if (bno != "" && mid != "") {
										$.ajax({
											url : "/commu/likeInsertMem",
											type : "post",
											data : {
												no : bno,
												id : mid
											}
										});
									} else if (bno != "" && cmid != "") {
										//console.log("기업회원 조건문 안으로 들어옴");
										$.ajax({
											url : "/commu/likeInsertCom",
											type : "post",
											data : {
												no : bno,
												id : cmid
											}
										});

									}

								} else {
									like
											.attr("src",
													"/resources_KHJ/img_KHJ/emptyheart.png");
									if (bno != "" && mid != "") {

										$.ajax({
											url : "/commu/likeDeleteMem",
											type : "post",
											data : {
												no : bno,
												id : mid
											}
										});
									} else if (bno != "" && cmid != "") {

										$.ajax({
											url : "/commu/likeDeleteCom",
											type : "post",
											data : {
												no : bno,
												id : cmid
											}
										});

									}
								}
							}

						});
	</script>

</body>
</html>