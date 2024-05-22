<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./header_JYC.jsp"%>
<c:if test="${sessionScope.mid != null }">
<c:if test="${listMR.get(0).rno != null  }"> 
<p>이런 회사에서 ${mem.mname }(${mid })님을 필요로 하고 있어요 (스킬 매칭)</p>
</c:if>
<c:if test="${listMR.get(0).rno == null }">
<p>등록된 이력서가 없습니다. 이력서를 등록해 주세요. 이력서가 등록되면 스킬매칭이 시작됩니다.</p>
</c:if> 
<div class="skillMatching">
	<table border="1">
		<c:forEach var="total" items="${total }">
			<tr>
				<th><a href="/employnotice/detailMem?enno=${total.enno }">${total.entitle }</a></th>
			</tr>
		</c:forEach>
	</table>
</div>
</c:if>
<c:if test="${sessionScope.mid == null }">
<p>로그인 후 이용할 수 있는 기능입니다.</p>
</c:if>
<h2>채용공고</h2>
<div class="employNoticeList">
	<table border="1">
		<thead>
			<tr>
				<th>마감까지 남은 기한</th><th>채용공고 제목</th><th>회사명</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="en" items="${employNoticeList }" varStatus="status">
				<tr>
					<td>D-${en.enenddate }</td>
					<td><a href="/employnotice/detailNoneMem?enno=${en.enno }">${en.entitle }</td>
					<td>${en.cname }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<h2>채용 공고를 올린 기업 리스트</h2>
<div class="companyList">
	<c:forEach var="company" items="${companyList }">
		<ul>
			<li><img scr="" alt="회사 로고 또는 대표 이미지"></li>
			<li><c:if test="${sessionScope.mid == null }"><a href="/company/detailNoneMem?cno=${company.cno }">${company.cname }</a></c:if>
				<c:if test="${sessionScope.mid != null }"><a href="/company/detailMem?cno=${company.cno }">${company.cname }</a></c:if></li>
		</ul>
	</c:forEach>
</div>
<%@ include file="./footer_JYC.jsp"%>
</body>
</html>