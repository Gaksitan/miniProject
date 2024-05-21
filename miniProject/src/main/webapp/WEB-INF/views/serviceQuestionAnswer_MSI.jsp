<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
textarea {
    border: 1.5px rgb(68, 136, 244) solid;
    width: 500px;
    height: 200px;
    border-radius: 5px;
    padding-left: 10px;
    padding-top: 10px;
    resize: none;
    font-size: 15px;
}


input[type="submit"]{
    width: 100px;
    height: 40px;
    font-size: 15px;
    border: 0;
    outline: 1.5px rgb(68, 136, 244) solid;
    border-radius: 5px;
    padding-left: 10px;
    background-color: rgb(164, 199, 255);
}

input[type="submit"]:hover {
    width: 100px;
    height: 40px;
    font-size: 15px;
    border: 0;
    border-radius: 5px;
    outline: 1.5px rgb(27, 76, 155) solid;
    padding-left: 10px;
    background-color: rgb(68, 136, 244);
}


</style>
<body>
<%@ include file="./header_JYC.jsp"%>

<h1>고객센터 질문 답변 작성 페이지</h1>

<table width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
	<tbody>
		<tr>
			<td>카테고리</td>
			<td>${qcno}</td>
		</tr>
		<tr>
			<td>문의사항 제목</td>
			<td>${sqtitle}</td>
		</tr>
		<tr>
			<td>문의사항 내용</td>
			<td>${sqcontent}</td>
		</tr>
				
	</tbody>
</table>


<form action="/admin/serviceAnswer" method="post">
	<input type="hidden" name="sqno" value=${sqno}><br>
	<span>문의사항 답변 내용</span><br>
	<textarea name="sacontent"></textarea><br>
	<input type="submit" value="답변 등록">
</form>

<%@ include file="./footer_JYC.jsp"%>

</body>
</html>




