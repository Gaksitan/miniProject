<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시;판 글 작성/수정</title>

</head>
<body>
    <div class="container">
	    <h1>게시글 작성 페이지</h1>
	    <hr>
        <form action="" method="get">
        <div class="form-group">
        <label for="title">게시글 제목</label>
        <input type="text" id="title" class="form-control" placeholder="제목을 입력하세요." name="title" maxlength="100" required="required">
        </div>
        <div class="form-group">
            <label for="content">게시글 내용</label>
            <textarea class="form-control" rows="5" id="content" name="content" placeholder="내용을 작성하세요.">
            </textarea>
        </div>
        <div class="form-group">
            <label for="tag">태그할 사람</label>
            <input type="text" class="form-control" name="tag" placeholder="태그할 아이디" name="tag">
        </div>
        <button type="submit" class="searchBtn">추가</button>
        <button type="submit" class="regist">등록</button>
        <button onclick="history.back()">취소</button>
    </form>
    </div>
	
</body>
</html>