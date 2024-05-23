<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IndexCom</title>
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
<link rel="stylesheet" href="../css/main.css" />
<body>
<main>
<a href="regFormCom">회원가입</a><br>

<h2>Company에서 올린 채용공고</h2>
<table border="1">
  <thead>
	  <tr>
		  <td>제목</td>
		  <td>기간</td>
		  <td>D-Day</td>
	  </tr>
  </thead>
  <tbody>
    <c:forEach items="${employNoticeList}" var="notice">
        <tr>
			<td><a href="employNotice?enno=${notice.enno}">${notice.entitle}</a></td>
            <td>${notice.enregdate}~${notice.enenddate }</td>
            <td><script>document.write(calculateDDay('${notice.enenddate}'))</script></td>
        </tr>
    </c:forEach>
  </tbody>
</table>

<h2>스킬 매칭</h2>
<table border="1">
  <thead>
	  <tr>
		  <td>이력서 제목</td>
		  <td>작성자</td>
	  </tr>
  </thead>
  <tbody>
  		<c:set var="previousTitle" value=""/>
        <c:forEach items="${skNameList}" var="skname">
            <c:if test="${skname.resume.rtitle != previousTitle && skname.resume.rpublic == true}">
                <tr>
                    <td><a href="applyResumeDetail?rno=${skname.resume.rno}&mid=${skname.member.mid}">${skname.resume.rtitle}</a></td>
                    <td><a href="applicantDetail?mid=${skname.member.mid}">${skname.member.mname}</a></td>
                </tr>
                <c:set var="previousTitle" value="${skname.resume.rtitle}"/>
            </c:if>
        </c:forEach>
  </tbody>
</table>
</main>
</body>
</html>

<%@ include file="./footer_JYC.jsp" %>