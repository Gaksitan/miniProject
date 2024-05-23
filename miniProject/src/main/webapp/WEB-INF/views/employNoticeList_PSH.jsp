<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>employNoticeList</title>
    <script>
        function calculateDDay(enddate) {
            var endDate = new Date(enddate);
            var today = new Date();
            var timeDiff = endDate.getTime() - today.getTime();
            var daysDiff = Math.ceil(timeDiff / (1000 * 3600 * 24));

            if (daysDiff > 0) {
                return "D-" + daysDiff;
            } else if (daysDiff === 0) {
                return "D-Day";
            } else {
                return "마감";
            }
        }
    </script>
</head>
<body>
<h1>채용공고관리 페이지</h1>
<hr>
<button onclick="location.href='employNoticeCreate'">채용공고 작성</button>
<table border="1">
  <thead>
	  <tr>
		  <td>제목</td>
		  <td>기간</td>
		  <td>D-Day</td>
		  <td>지원자수</td>
	  </tr>
  </thead>
  <tbody>
    <c:forEach items="${employNoticeList}" var="notice">
        <tr>
			<td><a href="employNotice?enno=${notice.enno}">${notice.entitle}</a></td>
            <td>${notice.enregdate}~${notice.enenddate }</td>
            <td><script>document.write(calculateDDay('${notice.enenddate}'))</script></td>
            <td>${applicantCounts[notice.enno]}</td>
            <td>${notice.enno}</td>
        </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>