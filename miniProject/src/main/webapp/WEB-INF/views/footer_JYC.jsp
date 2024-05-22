<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

	footer{
		display: flex;
		justify-content: space-between;
		background: #C4D2E9;
	}
	div {
		margin: 20px;
	}
	a{
		margin: 20px;
		color: 
	}
</style>

</head>
<body>
	<footer>
		<div>
			<p>
				<span>DEVJOB</span><span>|</span><span>홍길동</span>
			</p>
			<p>
				<span>부산광역시 해운대구</span><span>|</span><span>XX-XXX-XXXX</span>
			</p>
			<p>
				<span>사업자등록번호:XXX-XX-XXXX</span>
			</p>
		</div>
		
		
		<c:if test="${companyManager == null }">
		<a href="/service/mainMem">고객센터</a>
		</c:if>
		<c:if test="${companyManager != null }">
		<a href="/service/mainCom">고객센터</a>
		</c:if>

	</footer>
</body>
</html>