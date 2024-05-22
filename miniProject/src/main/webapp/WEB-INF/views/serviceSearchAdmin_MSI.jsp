<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<body>

<%@ include file="./header_JYC.jsp"%>
<h1>아이디 조회 결과</h1>

<h3>개인회원</h3>

<table  id="blockTable" border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
	<tr>
		<th>멤버아이디</th><th>차단</th>
	</tr>
	<c:forEach var="member" items="${memberList}">
		<c:if test="${member.bregdate == null}">
			<tr>
				<td>${member.mid}</td>
				<td><a href="/admin/block?mid=${member.mid}&keyword=${keyword}">차단하기</a></td>
			</tr>
		</c:if>
	</c:forEach>	
</table>


<table id="unblockTable" border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
	<tr>
		<th>멤버아이디</th><th>차단날짜</th><th>어드민아이디</th><th>차단해제</th>
	</tr>
	<c:forEach var="member" items="${memberList}">
		<c:if test="${member.bregdate != null}">
			<tr>
				<td>${member.mid}</td>
				<td>${member.bregdate}</td>
				<td>${member.ano}</td>
				<td><a href="/admin/unblock2?bano=${member.bano}&keyword=${keyword}">차단해제</a></td>
			</tr>
		</c:if>
	</c:forEach>	
</table>


<h3>기업회원</h3>

<table id="blockTable.company" border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
	<tr>
		<th>사업자번호</th><th>차단</th>
	</tr>
	<c:forEach var="company" items="${companyList}">
		<c:if test="${company.bregdate == null}">
			<tr>
				<td>${company.cno}</td>
				<td><a href="/admin/block?cno=${company.cno}&keyword=${keyword}">차단하기</a></td>
			</tr>
		</c:if>
	</c:forEach>	
</table>


<table id="unblockTable.company" border="1" width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
	<tr>
		<th>사업자번호</th><th>차단날짜</th><th>어드민아이디</th><th>차단해제</th>
	</tr>
	<c:forEach var="company" items="${companyList}">
		<c:if test="${company.bregdate != null}">
			<tr>
				<td>${company.cno}</td>
				<td>${company.bregdate}</td>
				<td>${company.ano}</td>
				<td><a href="/admin/unblock2?bano=${company.bano}&keyword=${keyword}">차단해제</a></td>
			</tr>
		</c:if>
	</c:forEach>	
</table>


<%@ include file="./footer_JYC.jsp"%>


<!-- <script>

// 차단하기 링크 클릭 시 실행되는 함수
$(".blockLink").click(function(e) {
    e.preventDefault(); // 기본 이벤트(링크 이동) 방지

    // 해당 링크의 data-mid 속성을 가져와서 사용자 아이디로 설정
    var mid = $(this).data("mid");

    // AJAX 요청 설정
    $.ajax({
        type: "POST",
        url: "/admin/block",
        data: { mid: mid }, // 사용자 아이디를 전달
        success: function(response) {
        	console.log("Server Response:", response);
            alert("차단에 성공했습니다"); 
            
            // 차단하기 테이블에서 해당 행 삭제
            $(e.target).closest("tr").remove();
            
            // 차단해제 테이블에 새로운 행 추가
            var newRow = "<tr>" +
            "<td>" + member.mid + "</td>" +
            "<td>" + member.bregdate + "</td>" +
            "<td>" + member.ano + "</td>" +
            "<td><a href='/admin/unblock?bano=" + member.bano + "'>차단해제</a></td>" +
            "</tr>";
        	$("#unblockTable").append(newRow);
        },
        error: function(xhr, status, error) {
            // 서버 요청이 실패한 경우 실행됩니다.
            // 오류 처리 코드를 작성할 수 있습니다.
            console.error("Error:", error); // 콘솔에 오류 메시지를 출력합니다.
        }
    });
});



$(".blockLink.company").click(function(e) {
    e.preventDefault();
    var cno = $(this).data("cno"); // data-cno -> data-company-cno로 수정
    console.log("Clicked cno:", cno); // 여기로 옮깁니다.
    $.ajax({
        type: "POST",
        url: "/admin/block",
        data: { cno: cno },
        success: function(response) {
            console.log("Server Response:", response);
            alert("차단에 성공했습니다");
            $(e.target).closest("tr").remove();
            // 차단해제 테이블에 새로운 행 추가
            var newRow = "<tr>" +
                "<td>" + response.cno + "</td>" + // 서버에서 올바른 응답을 보낼 경우에 대한 처리가 필요합니다.
                "<td>" + response.bregdate + "</td>" + // 서버에서 올바른 응답을 보낼 경우에 대한 처리가 필요합니다.
                "<td>" + response.ano + "</td>" + // 서버에서 올바른 응답을 보낼 경우에 대한 처리가 필요합니다.
                "<td><a href='/admin/unblock?bano=" + response.bano + "'>차단해제</a></td>" +
                "</tr>";
            $("#unblockTable.company").append(newRow);
        },
        error: function(xhr, status, error) {
            console.error("Error:", error);
        }
    });
});

</script> -->

</body>
</html>