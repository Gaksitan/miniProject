<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<body>
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
            <td><a href="applicantDetail">${item.member.mname}</a></td>
            <td><a href="applyResumeDetail">${item.resume.rtitle}</a></td>
            <td><input type="button" value="관심" onclick="removeInterest(${item.imno})"></td>
            <td>${item.member.mstate}</td>
        </tr>
    </c:forEach>
  </tbody>
  </table>
</body>
</html>
