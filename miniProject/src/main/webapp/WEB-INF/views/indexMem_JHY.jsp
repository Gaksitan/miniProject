<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../css/main.css" />
<style>
.companyList {
        display: flex;
        flex-wrap: wrap;
        gap: 20px; /* 각 아이템 사이의 간격 조정 */

    }

    .companyItem {
        display: flex;
        flex-direction: column;
        align-items: center;
        width: 150px; /* 아이템의 너비 조정 */
        text-align: center; /* 텍스트 가운데 정렬 */
        margin : 0 auto;
    }

    .companyImage {
        width: 130px;
        height: 130px;
        margin-bottom: 10px; /* 이미지와 텍스트 간의 간격 조정 */
    }

    .companyName {
        font-size: 1rem; /* 회사 이름의 폰트 크기 조정 */
    }
</style>
<body>
<%@ include file="./header_JYC.jsp"%>
<main>

<c:if test="${sessionScope.mid != null }">
<c:if test="${listMR.get(0).rno != null  }"> 
<h4>이런 회사에서 ${mem.mname }(${mid })님을 필요로 하고 있어요 (스킬 매칭)</h4>
</c:if>
<c:if test="${listMR.get(0).rno == null }">
<h4>등록된 이력서가 없습니다. 이력서를 등록해 주세요. 이력서가 등록되면 스킬매칭이 시작됩니다.</h4>
</c:if> 
<div class="skillMatching">
	<table border="1">
		<c:forEach var="total" items="${total }">
			<tr>
				<td><a href="/employnotice/detailMem?enno=${total.enno }">${total.entitle }</a></td>
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
<%-- <h2>채용 공고를 올린 기업 리스트</h2>
<div class="companyList">
	<c:forEach var="company" items="${companyList }">
		<ul id="companyImageList">
			<li><img src="../resources_JYC/images_JYC/company.jpg" alt="회사 로고 또는 대표 이미지" style="width:130px; height:130px; "></li>
			<li id="companyImageList_li">
				<c:if test="${sessionScope.mid == null }">
					<a href="/company/detailNoneMem?cno=${company.cno }">${company.cname }</a></c:if>
				<c:if test="${sessionScope.mid != null }">
					<a href="/company/detailMem?cno=${company.cno }">${company.cname }</a>
				</c:if>
			</li>
		</ul>
	</c:forEach>
</div> --%>

<h2>채용 공고를 올린 기업 리스트</h2>
<div class="companyList">
    <c:forEach var="company" items="${companyList}">
        <div class="companyItem">
            <img src="../resources_JYC/images_JYC/company.jpg" alt="회사 로고 또는 대표 이미지" class="companyImage">
            <div class="companyName">
                <c:if test="${sessionScope.mid == null}">
                    <a href="/company/detailNoneMem?cno=${company.cno}">${company.cname}</a>
                </c:if>
                <c:if test="${sessionScope.mid != null}">
                    <a href="/company/detailMem?cno=${company.cno}">${company.cname}</a>
                </c:if>
            </div>
        </div>
    </c:forEach>
</div>

</main>
<%@ include file="./footer_JYC.jsp"%>
</body>
</html>