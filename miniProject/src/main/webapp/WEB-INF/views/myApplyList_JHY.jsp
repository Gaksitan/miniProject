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
<body>
<%@ include file="./header_JYC.jsp"%>
<main>
<hr>
<h2>지원 현황 목록</h2>
<table border="1">
	<c:forEach var="applyResume" items="${myApplyList }" varStatus="status">
		<tr>
			<td>${applyResume.cname }</td>
			<td>${applyResume.entitle }</td>
			<td>${applyResume.applydate }</td>
			

			
			
			
			 <c:set var="isScrap" value="false"/>
	        <c:forEach var="scrap" items="${scrapList}">
	            <c:if test="${scrap.enno == applyResume.enno}">
	                <c:set var="isScrap" value="true"/>
	            </c:if>
	        </c:forEach>

	        <td id="scrap-link-${applyResume.enno}">
	            <c:choose>
	                <c:when test="${isScrap}">
	                    <a href="javascript:void(0);" onclick="deleteScrap(${applyResume.enno})">스크랩취소</a>
	                </c:when>
	                <c:otherwise>
	                    <a href="javascript:void(0);" onclick="scrap(${applyResume.enno})">스크랩</a>
	                </c:otherwise>
	            </c:choose>
	        </td>
			
			
	
			<td><c:if test="${applyResume.arpass == 0}">불합격</c:if>
				<c:if test="${applyResume.arpass == 1}">합격</c:if>
				<c:if test="${applyResume.arpass == 2}">심사중</c:if></td>
			<td>${applyResume.ipass }</td>
			<td><input type="button" name="score" value="평점쓰기"></td>
		</tr>
	</c:forEach>
</table>
</main>


<%@ include file="./footer_JYC.jsp"%>



<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function scrap(enno) {
    $.ajax({
        url: '/mem/scrap',
        type: 'POST',
        data: { enno: enno },
        success: function(response) {
            if (response.scrapResult) {
                // 스크랩 성공 시 스크랩취소로 표시
                document.getElementById('scrap-link-' + enno).innerHTML = '<a href="javascript:void(0);" onclick="deleteScrap(' + enno + ')">스크랩취소</a>';
            }
        },
        error: function() {
            alert('스크랩에 실패했습니다. 다시 시도해주세요.');
        }
    });
}

function deleteScrap(enno) {
    $.ajax({
        url: '/mem/deleteScrap',
        type: 'POST',
        data: { enno: enno },
        success: function(response) {
            if (response.deleteScrapResult) {
                // 스크랩 취소 성공 시 스크랩으로 표시
                document.getElementById('scrap-link-' + enno).innerHTML = '<a href="javascript:void(0);" onclick="scrap(' + enno + ')">스크랩</a>';
            }
        },
        error: function() {
            alert('스크랩 취소에 실패했습니다. 다시 시도해주세요.');
        }
    });
}
</script>




</body>
</html>