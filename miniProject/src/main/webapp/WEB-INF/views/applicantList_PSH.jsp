<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>applicantList</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function toggleInterest(mid) {
            $.post("/toggleInterest", { mid: mid }, function(response) {
                if (response === "added") {
                    alert("관심 목록에 추가되었습니다.");
                } else if (response === "removed") {
                    alert("관심 목록에서 제거되었습니다.");
                } else {
                    alert("처리 중 오류가 발생했습니다.");
                }
            });
        }
    </script>
</head>
<link rel="stylesheet" href="../css/main.css" />
<body>
<main>
    <h1>지원받은 이력서 목록 페이지</h1>
    <hr>
    <table border="1">
        <thead>
            <tr>
                <td>구직자 이름</td>
                <td>대표 이력서 제목</td>
                <td>관심</td>
                <td>상태</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allList}" var="item">
                <tr>
                    <td><a href="applicantDetail?mid=${item.member.mid}">${item.member.mname}</a></td>
                    <td><a href="applyResumeDetail?rno=${item.rno }&mid=${item.member.mid}">${item.resume.rtitle}</a></td>
                    <td><input type="button" value="관심" onclick="toggleInterest('${item.member.mid}')"></td>
                    <td>
                    	<c:choose>
                    		<c:when test="${item.member.mstate eq 1}">구직중</c:when>
                    		<c:when test="${item.member.mstate eq 2}">재직중</c:when>
                    		<c:when test="${item.member.mstate eq 3}">관심없음</c:when>
                    		<c:otherwise>-</c:otherwise>
                    	</c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>