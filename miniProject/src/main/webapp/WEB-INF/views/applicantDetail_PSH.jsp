<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>applicantDetail</title>
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
<body>
<h1>지원자 및 관심 구직자 정보 상세보기 페이지</h1>
<hr>
<c:set var="item" value="${item}" />
<button onclick="toggleInterest('${item.mid}')">관심</button>
<button>평점</button>
<br>
이름 : ${item.mname} <br>
나이 : <br>
전화번호 : ${item.mtel} <br>
이메일 : ${item.memail} <br>
거주지 : ${item.maddr1} <br>

이력서 목록
<table border="1">
  <thead>
      <tr>
          <td>이력서 제목</td>
          <td>작성일자</td>
      </tr>
  </thead>
  <tbody>
    <c:forEach items="${resumeList}" var="resume">
	    <tr>
	        <td><a href="applyResumeDetail">${resume.rtitle}</a></td>
	        <td>${resume.rregdate}</td>
	    </tr>
	</c:forEach>


  </tbody>
</table>

평점 :

</body>
</html>
<%@ include file="./footer_JYC.jsp" %>
