<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	.top{
		display: flex;
		justify-content: center;
	}
	table{
		margin: auto;
	}
</style>

</head>
<body>

	<%@ include file="./header_JYC.jsp"%>

	<main>
		<div id="lists">
			<div class="top">
				<h2>채용공고(${encount })</h2>
				<select name="employNotice">
					<option>추천순</option>
					<option>최신순</option>
					<option>인기순</option>
					<option>좋아요순</option>
				</select>
			</div>
			<table>
				<tbody>
					<c:forEach var="en" items="${enlist }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<c:if test="${mid == null && cno == null }">
							<td><a href="/employnotice/detailNoneMem?enno=${en.enno }">${en.entitle }</a></td>
							</c:if>
							<c:if test="${mid != null }">
							<td><a href="/employnotice/detailMem?enno=${en.enno }">${en.entitle }</a></td>
							</c:if>
							<c:if test="${cno != null }">
							<td><a href="/employnotice/detailCom?enno=${eno.enno }">${en.entitle }</a></td>
							</c:if>
							<td>${en.cno }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form action="">
				<c:forEach begin="1" end="${encount }" varStatus="status">
				<input type="button" value="${status.count }">
				</c:forEach>
			</form>
		</div>
		<div>
			<div class="top">
				<h2>회사(${comcount })</h2>
				<select name="employNotice">
					<option>추천순</option>
					<option>최신순</option>
					<option>인기순</option>
					<option>좋아요순</option>
				</select>
			</div>
			<table>
				<tbody>
					<c:forEach var="com" items="${comlist }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<c:if test="${mid == null && cno == null }">
							<td><a href="/company/detailNoneMem?cno=${com.cno }">${com.cname }</a></td>
							</c:if>
							<c:if test="${mid != null }">
							<td><a href="/company/detailMem?cno=${com.cno }">${com.cname }</a></td>
							</c:if>
							<c:if test="${cno != null }">
							<td><a href="/company/detailCom?cno=${com.cno }">${com.cname }</a></td>
							</c:if>
							<td>${com.ctel }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<c:if test="${cno == null }">
		<div>
			<div class="top">
				<h2>사용자(${memcount })</h2>
				<select name="employNotice">
					<option>추천순</option>
					<option>최신순</option>
					<option>인기순</option>
					<option>좋아요순</option>
				</select>
			</div>
			<table>
				<tbody>
					<c:forEach var="mem" items="${memlist }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<c:if test="${mid == null && cno == null }">
							<td><a href="#">${mem.mid }</a></td>
							</c:if>
							<c:if test="${mid != null }">
							<td><a href="#">${mem.mid }</a></td>
							</c:if>
							<c:if test="${cno != null }">
							<td><a href="#">${mem.mid }</a></td>
							</c:if>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</c:if>

	</main>

	<%@ include file="./footer_JYC.jsp"%>

</body>
</html>