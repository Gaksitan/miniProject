<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employNoticeList</title>
</head>
<body>
<h1>채용공고관리 페이지</h1>
<hr>
<button>채용공고 작성</button>
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
	<c:forEach items="${allList}" var="item">
	    <tr>
	        <td><a href="employNoticeList">${item.entitle}</a></td>
	        <td>${item.enregdate}~${item.enenddate }</td>
	        <td>D-30 구현할것</td>
	        <td>지원자수</td>
	    </tr>
	</c:forEach>

  </tbody>
  </table>
</body>
</html>