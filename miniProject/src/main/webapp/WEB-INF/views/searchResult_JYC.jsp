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
							<td>${en.entitle }</td>
							<td>${en.cno }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
							<td>${com.cname }</td>
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
							<td>${mem.mid }</td>
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