<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    height: 200px;
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
<body>
<h1>FAQ작성페이지</h1>

<form action="/admin/writeFAQ" method="post" style="width: 400px;">
    <fieldset>
        <legend>FAQ 작성 폼</legend>
        카테고리<select name="qcno">
        	<option value="1">계정 관련</option>
        	<option value="2">구직서비스 관련</option>
        	<option value="3">커뮤니티 관련</option>
        	<option value="4">기업서비스 관련</option>
        	<option value="5">기타</option>
        </select><br>
        
        질문 제목<input type="text" name="faqtitle" maxlength=100 placeholder="제목 입력"><br>
        질문 내용<textarea name="faqquestion" placeholder="내용 입력"></textarea><br>
        답변<textarea name="faqanswer" placeholder="답변 입력"></textarea><br>

        
       	<input type="radio" id="option1" name="faqtarget" value="member" checked>
	  	<label for="option1">개인회원</label>
	  	<input type="radio" id="option2" name="faqtarget" value="company">
	    <label for="option2">기업회원</label></br>

        <div class="btns">
            <input type="submit" value="저장" onclick="alert('저장이 완료되었습니다.')">
            <input type="button" value="취소" onclick="history.back()">
        </div>
    </fieldset>
</form>




</body>
</html>