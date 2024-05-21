<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>applicantList</title>
</head>
<body>
    <h1>지원받은 이력서 목록 페이지</h1>
    <hr>
    <table border="1">
        <thead>
            <tr>
                <td>구직자 이름</td>
                <td>대표 이력서 제목</td>
                <td>관심</td>
                <td>상태</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${allList}" var="item">
                <tr>
                    <td><a href="applicantDetail">${item.mname}</a></td>
                    <td><a href="applyResumeDetail">${item.title}</a></td>
                    <td><input type="button" value="관심"></td>
                    <td>${item.mstate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
