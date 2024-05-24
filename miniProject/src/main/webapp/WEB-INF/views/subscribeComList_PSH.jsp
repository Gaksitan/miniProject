<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>subscribeComList</title>
<script>
    function removeInterest(imno) {
        if (confirm("관심 구직자를 해제하시겠습니까?")) {
            window.location.href = "/removeInterest?imno=" + imno;
        }
    }
</script>

</head>
<link rel="stylesheet" href="../css/main.css" />
<body>
<main>
<h1>관심 구직자(이력서) 목록</h1>

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
            <td><a href="applicantDetail?mid=${item.mid}">${item.member.mname}</a></td>
            <td><a href="applyResumeDetail?rno=${item.resume.rno}&mid=${item.mid}">${item.resume.rtitle}</a></td>
            <td><input type="button" value="관심" onclick="removeInterest(${item.imno})"></td>
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