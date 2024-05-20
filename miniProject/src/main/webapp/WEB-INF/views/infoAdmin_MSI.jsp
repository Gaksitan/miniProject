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

form{
	display : flex;
	flex-direction : column;
	justify-content:center;

}


input[type="text"] {
    border: 1.5px rgb(68, 136, 244) solid;
    width: 500px;
    height: 30px;
    border-radius: 5px;
    padding-left: 10px;
	font-size: 15px;
}

textarea {
    border: 1.5px rgb(68, 136, 244) solid;
    width: 500px;
    height: 400px;
    border-radius: 5px;
    padding-left: 10px;
    padding-top: 10px;
    resize: none;
    font-size: 15px;
}

input[type="submit"],input[type="button"] {
    width: 100px;
    height: 40px;
    font-size: 15px;
    border: 0;
    outline: 1.5px rgb(68, 136, 244) solid;
    border-radius: 5px;
    padding-left: 10px;
    background-color: rgb(164, 199, 255);
}

input[type="submit"]:hover , input[type="button"]:hover {
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


<script>
    function submitForm(actionUrl) {
        var form = document.getElementById("noticeForm");
        form.action = actionUrl;
        form.submit();
    }
</script>


<body>
<h1>공지사항 작성,수정 폼</h1>

<!-- <form action="/admin/writeNotice" method="get" style="width: 400px;">
    <fieldset>
        <legend>공지사항 작성 관리</legend>
        공지 제목<input type="text" name="ntitle" maxlength=100 placeholder="제목 입력"><br>
        공지 내용<textarea name="ncontent" placeholder="내용 입력"></textarea><br>
        <div class="btns">
        	<input type="submit" value="등록" onclick="alert('등록이 완료되었습니다.')">
        	<input type="button" value="취소" onclick="history.back()">
        </div>
    </fieldset>
</form> -->


<c:choose>
    <c:when test="${not empty notice}">
        <form id="noticeForm" method="post" style="width: 400px;">
            <fieldset>
                <legend>공지사항 수정 관리</legend>
                <input type="hidden" name="nno" value="${notice.nno}"><!-- 공지사항 번호를 hidden으로 전달 -->
                <input type="hidden" name="ano" value="${notice.ano}"><!-- 공지사항 작성자를 hidden으로 전달 -->
                공지 제목<input type="text" name="ntitle" maxlength=100 value="${notice.ntitle}"><br>
                공지 내용<textarea name="ncontent">${notice.ncontent}</textarea><br>
                <div class="btns">
                    <input type="button" value="수정" onclick="submitForm('/admin/updateNotice')">
                    <input type="button" value="삭제" onclick="submitForm('/admin/deleteNotice')">
                </div>
            </fieldset>
        </form>
    </c:when>
    <c:otherwise>
        <form action="/admin/writeNotice" method="post" style="width: 400px;">
            <fieldset>
                <legend>공지사항 작성 관리</legend>
                공지 제목<input type="text" name="ntitle" maxlength=100 placeholder="제목 입력"><br>
                공지 내용<textarea name="ncontent" placeholder="내용 입력"></textarea><br>
                <div class="btns">
                    <input type="submit" value="등록" onclick="alert('등록이 완료되었습니다.')">
                    <input type="button" value="취소" onclick="history.back()">
                </div>
            </fieldset>
        </form>
    </c:otherwise>
</c:choose>

</body>
</html>