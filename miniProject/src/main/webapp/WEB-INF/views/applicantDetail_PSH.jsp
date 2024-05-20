<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>applicantDeatil</title>
</head>
<body>
<h1>지원자 및 관심 구직자 정보 상세보기 페이지</h1>
<hr>
<button>관심</button>
<button>평점</button>
<br>
이름 : <br>
나이 : <br>
전화번호 : <br>
이메일 : <br>
거주지 : <br>

이력서 목록
<table border="1">
  <thead>
	  <tr>
		  <td>이력서 제목</td>
		  <td>작성일자</td>
	  </tr>
  </thead>
  <tbody>
	<c:forEach items="${allList}" var="item">
	    <tr>
	        <td><a href="applyResumeDetail">${item.title}</a></td>
	        <td>${item.date}</td>
	    </tr>
	</c:forEach>

  </tbody>
  </table>
  
  평점 :
  
</body>
</html>