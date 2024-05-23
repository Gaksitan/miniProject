<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	main form{
		margin: 0;
	}
</style>
<link rel="stylesheet" href="../css/main.css" />

</head>
<body>

	<%@ include file="./header_JYC.jsp" %>
	<main>
		<h1>고객센터 질문 작성 페이지</h1>
		
		<c:if test="${companyManager != null }">
		<form action="/service/registQuestionCom" method="post">
		<select name="qcno">
			<c:forEach var="category" items="${categoryList }">
			<option value="${category.qcno }">${category.qcname }</option>
			</c:forEach>
		</select>
		<h2>제목</h2>
		<input type="text" name="sqtitle" id="sqtitle" placeholder="제목을 입력하세요">
		<h2>내용</h2>
		<textarea rows="5" cols="200" name="sqcontent" id="sqcontent" placeholder="내용을 입력하세요"></textarea>		
		<input type="submit" value="저장" onclick="return checkNull()">
		<input type="button" value="취소" onclick="location.href='/service/mainCom'">
		</form>
		</c:if>
			<c:if test="${mid != null }">
		<form action="/service/registQuestionMem" method="post">
		<select name="qcno">
			<c:forEach var="category" items="${categoryList }">
			<option value="${category.qcno }">${category.qcname }</option>
			</c:forEach>
		</select>
		<h2>제목</h2>
		<input type="text" name="sqtitle" id="sqtitle" placeholder="제목을 입력하세요">
		<h2>내용</h2>
		<textarea rows="5" cols="200" name="sqcontent" id="sqcontent" placeholder="내용을 입력하세요"></textarea>		
		<input type="submit" value="저장" onclick="return checkNull()">
		<input type="button" value="취소" onclick="location.href='/service/mainMem'">
		</form>
		</c:if>
	</main>
	<%@ include file="./footer_JYC.jsp" %>
	
<script type="text/javascript">
	function checkNull(){
		const sqtitle = document.querySelector("#sqtitle");
		
		if(sqtitle.value == ""){
			alert("제목을 입력해주세요!");
			return false;
		}
		
		const sqcontent = document.querySelector("#sqcontent");
		if(sqcontent.value == ""){
			alert("내용을 입력해주세요!");
			return false;
		}
		return true;
	}
	
</script>
</body>
</html>