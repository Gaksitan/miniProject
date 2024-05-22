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

section{
	margin : 50px;
	height : 800px;
}

.container{
	display : flex;
	flex-direction : column;
	margin : 50px auto;
	justify-content: center;
	width : 600px;
	height : 600px;
	border : 2px solid darkgrey;
	align-items : center;
	font-weight : bold;
	
}


table {
  margin: 30px auto;
  border-radius: 5px;
  font-weight : bold;
}

/* 테이블 행 */
th, td {
  padding: 8px;
  border-bottom: 1px solid #ddd;
  text-align: center;
}


/* 테이블 올렸을 때 */
tbody tr:hover {
  background-color: #d3d3d3;
  opacity: 0.9;

}

/* 테이블 비율 */
th:nth-child(1),
td:nth-child(1) {
  width: 30%;
}

form{
	display : flex;
	flex-direction : column;
	justify-content:center;
	margin : 40px auto;
	align-items : center;
	font-weight : bold;
}

textarea {
    border: 1.5px rgb(68, 136, 244) solid;
    width: 500px;
    height: 130px;
    border-radius: 5px;
    padding-left: 10px;
    padding-top: 10px;
    resize: none;
    font-size: 15px;
    font-weight: bold; 
}

input[type="submit"]{
    width: 100px;
    height: 40px;
    font-size: 15px;
    border: 0px;
    outline: 1.5px rgb(68, 136, 244) solid;
    border-radius: 5px;
    padding-left: 10px;
    background-color: rgb(164, 199, 255);
}

input[type="submit"]:hover  {
    width: 100px;
    height: 40px;
    font-size: 15px;
    border: 1.5px;
    border-radius: 5px;
    outline: 1.5px rgb(27, 76, 155) solid;
    padding-left: 10px;
    background-color: rgb(68, 136, 244);
    font-weight: bold; 
}


</style>
<body>
<%@ include file="./header_JYC.jsp"%>

<section>
<h3>고객센터 질문 답변 작성 페이지</h3>
<hr>
	<div class="container">
	<span>고객이 질문한 내용</span>
		<table width="500" cellpadding="0" cellspacing="0" style="text-align: center;">
			<tbody>
				<tr>
					<td>카테고리</td>
					<td>${question.qcname}</td>
				</tr>
				<tr>
					<td>문의사항 제목</td>
					<td>${question.sqtitle}</td>
				</tr>
				<tr>
					<td>문의사항 내용</td>
					<td>${question.sqcontent}</td>
				</tr>
						
			</tbody>
		</table>


		<form action="/admin/serviceAnswer" method="post">
			<input type="hidden" name="sqno" value="${question.sqno}"><br>
			<span>문의사항 답변 내용</span><br>
			<textarea name="sacontent"></textarea><br>
			<input type="submit" value="답변 등록">
		</form>
	</div>
</section>






<%@ include file="./footer_JYC.jsp"%>

</body>
</html>




