<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업회원가입 Page</title>
</head>
<body>
<h1>기업회원가입 Page</h1>
<hr>
<a href="regFormMem_JHY">개인회원</a>
<div>
    <table width="500" cellpadding="0" cellspacing="0" border="1">
    <form action="signUpCom" method="post">
        <tr>
        <tr>
            <td>사업자번호</td>
            <td><input type="text" name="cno" size="50" placeholder="사업자번호를 입력하세요."></td>
        </tr>
            <td>기업형태</td>
	            <td>
				<select name="ctype">
					<option value="대기업">대기업</option>
					<option value="중견기업">중견기업</option>
					<option value="중소기업">중소기업</option>
				</select>
			</td>
        </tr>
        <tr>
            <td>회사명</td>
            <td><input type="text" name="cname" size="50" placeholder="회사명을 입력하세요."></td>
        </tr>
        <tr>
            <td>회사주소</td>
            <td><input type="text" name="caddr1" size="50" placeholder="회사 주소를 입력하세요."></td>
        </tr>
        <tr>
        	<td></td>
            <td><input type="text" name="caddr2" size="50" placeholder="상세 주소를 입력하세요."></td>
        </tr>
        <tr>
            <td>사업자등록증명원발급번호</td>
            <td><input type="text" name="cdocnum" size="50" placeholder="사업자등록증명원발급번호를 입력하세요."></td>
            <td><input type="button" value="사업자등록증명원 발급하기" onClick="window.open('https://www.gov.kr/mw/AA020InfoCappView.do?HighCtgCD=A09002&CappBizCD=12100000016&tp_seq=01')"></td>
        </tr>
        <tr>
            <td>인사 담당자</td>
            <td>---------</td>
        </tr>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="cmid" size="50" placeholder="인사담당자 아이디를 입력하세요."></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="cmpw" size="50" placeholder="비밀번호를 입력하세요."></td>
        </tr>
        <tr>
            <td>비밀번호확인</td>
            <td><input type="password" name="cmpw2" size="50" placeholder="비밀번호를 한 번 더 입력하세요."></td>
        </tr>
        <tr>
            <td>이메일</td>
            <td><input type="text" name="cmemail" size="20" placeholder="이메일을 입력하세요."></td>
            <td>@</td>
            <td><input type="text" name="cmemail2" size="20"></td>
        </tr>
        <tr>
            <td>국제번호</td>
            <td>대한민국 (+82)</td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="cmtel" size="50" placeholder="전화번호를 입력하세요."></td>
            <td><input type="button" name="ctelgetnum" value="인증번호받기"></td>
        </tr>
        <tr>
            <td>인증번호</td>
            <td><input type="text" name="ctelverify" size="50" placeholder="인증번호를 입력하세요."></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="회원가입"></td>
        </tr>
    </form>
    </table>
</div>
</body>
</html>
<%@ include file="./footer_JYC.jsp" %>