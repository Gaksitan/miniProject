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
.container {
	width: 800px;
	margin: auto;
}

.container a:link {
	color: black; /*메인 css에서 color 가 blueblack으로 설정되어 있어서 black적용이 안됨*/
	text-decoration: none;
}

article {
	float: center;
}

.box {
	display: flex;
	justify-content: center;
	align-items: center;
}

a:active {
	color: green;
}
</style>
<link rel="stylesheet" href="../css/main.css" />
</head>
<body>
	<%@ include file="./header_JYC.jsp"%>
	<main>

		<h1>내 게시글 페이지</h1>
		<hr>
		<div class="container">
			<article>
				<div class="box">
					<h2>내가 쓴 게시글 목록</h2>
				</div>
				<c:choose>
					<c:when test="${not empty myList }">
						<c:if test="${myList != null }">
							<div class="box">
								<table border="1">
									<thead>
										<tr>
											<th>게시글 번호</th>
											<th>제목</th>
											<th>좋아요</th>
											<th>작성일자</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${myList }" varStatus="status">
											<tr>
												<td>${status.count }</td>
												<td><a
													href="/commu/communityDetail_KHJ?bno=${list.bno}">${list.btitle }</a></td>
												<td>${list.blike }</td>
												<td>${list.bregdate }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</c:if>
					</c:when>
					<c:otherwise>
						<div class="box">
							<p>내가 쓴 게시글 목록이 없습니다.</p>
						</div>
					</c:otherwise>
				</c:choose>
				<div class="box">
					<h2>내가 쓴 댓글 목록</h2>
				</div>
				<c:choose>
					<c:when test="${not empty replyList }">
						<c:if test="${replyList != null }">
							<div class="box">
								<table border="1">
									<thead>
										<tr>
											<th>게시글</th>
											<th>댓글 내용</th>
											<th>작성일자</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="replyList" items="${replyList }"
											varStatus="status">
											<tr>
												<td>${replyList.btitle}</td>
												<td><a
													href="/commu/communityDetail_KHJ?bno=${replyList.bno}">${replyList.recontent }</a></td>
												<td>${replyList.reregdate }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</c:if>
					</c:when>
					<c:otherwise>
						<div class="box">
							<p>내가 쓴 댓글 목록이 없습니다.</p>
						</div>
					</c:otherwise>
				</c:choose>
				<div class="box">
					<h2>내가 좋아요 한 게시글 목록</h2>
				</div>
				<c:choose>
					<c:when test="${not empty likeList }">
						<c:if test="${likeList != null }">
							<div class="box">
								<table border="1">
									<thead>
										<tr>
											<th>게시글 번호</th>
											<th>게시글 제목</th>
											<th>작성일자</th>
											<th>작성자</th>
											<th>좋아요</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="likeList" items="${likeList }"
											varStatus="status">
											<tr>
												<td>${status.count }</td>
												<td><a
													href="/commu/communityDetail_KHJ?bno=${likeList.bno}">${likeList.btitle }</a></td>
												<td>${likeList.bregdate }</td>
												<c:if test="${likeList.mid != null}">
													<td>${likeList.mid }</td>
												</c:if>
												<c:if test="${likeList.cmid != null}">
													<td>${likeList.cmid }</td>
												</c:if>
												<td>${likeList.blike }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</c:if>
					</c:when>
					<c:otherwise>
						<div class="box">
							<p>내가 좋아요한 게시글 목록이 없습니다.</p>
						</div>
					</c:otherwise>
				</c:choose>
				<div class="box">
					<h2>나에게 쓴 글</h2>
				</div>
				<c:choose>
					<c:when test="${not empty taggedList }">
						<c:if test="${taggedList != null }">
							<div class="box">
								<table border="1">
									<thead>
										<tr>
											<th>게시글 번호</th>
											<th>게시글 제목</th>
											<th>작성일자</th>
											<th>작성자</th>
											<th>좋아요</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="toMeList" items="${taggedList }"
											varStatus="status">
											<tr>
												<td>${status.count }</td>
												<td>${toMeList.btitle }</td>
												<td>${toMeList.bregdate }</td>
												<c:if test="${toMeList.mid != null}">
													<td>${toMeList.mid }</td>
												</c:if>
												<c:if test="${toMeList.cmid != null}">
													<td>${toMeList.cmid }</td>
												</c:if>
												<td>${toMeList.blike }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</c:if>
					</c:when>
					<c:otherwise>
						<div class="box">
							<p>나를 태그한 게시글이 없습니다.</p>
						</div>
					</c:otherwise>
				</c:choose>
			</article>
		</div>
	</main>
	<%@ include file="./footer_JYC.jsp"%>
</body>
</html>