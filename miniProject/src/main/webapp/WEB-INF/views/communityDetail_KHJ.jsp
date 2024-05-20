<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>커뮤니티 상세페이지</title>
<style>

</style>
</head>
<body>
	<%@ include file="./header_JYC.jsp" %>
	<h1>커뮤니티 상세페이지</h1>
	<hr>
    <h3>${boardDetail[0].btitle}</h3>
    <img src="/resources_KHJ/img_KHJ/like.png" width="15" height="15"/> <!-- 클릭시 좋아요 +1 -->
    <img src="/resources_KHJ/img_KHJ/dislike.png" width="15" height="15"/><!-- (클릭시 좋아요 -1)  -->
    <span>작성자</span><span>${boardDetail[0].mid}</span><!--작성자 아이디가 아닌 이름이 와야할 것 같기도-->
    <p>${boardDetail[0].bcontent}</p>
    <c:forEach var="tags" items="${tagList }">
    <span>${tags.value }</span>
    </c:forEach>
    <label for="comment">댓글 작성하기</label>
    <input id="comment" name="comment" placeholder="댓글 입력하기">
    </input>
    <table>
        <thead>
            <tr>
                <th>작성자</th>
                <th>댓글 내용</th>
                <th>작성일자</th>
                <th>수정버튼(클릭 시 댓글내용이 인풋으로 바뀐다)</th>
                <th>삭제버튼</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td> <!--해당 mid의 name을 넣어야 할 것 같은데...-->
                <td></td>
                <td></td>
                <td><button>수정</button></td>
                <td><button>삭제</button></td>
            </tr>
        </tbody>
    </table>
</body>
</html>