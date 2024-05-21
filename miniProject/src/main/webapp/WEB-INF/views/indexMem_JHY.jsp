<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="./header_JYC.jsp"%>
<c:if test="${sessionScope.mid != null }">
<p>이런 회사에서 ${mem.mname }(${mid })님을 필요로 하고 있어요 (스킬 매칭)</p>
<div>
	<table border="1">
		<c:forEach var="total" items="${total }">
			<tr>
				<th><a href="/employnotice/detailMem?enno=${total.enno }">${total.entitle }</a></th>
			</tr>
		</c:forEach>
	</table>
</div>
</c:if>
<c:if test="${sessionScope.mid == null }">
<p>로그인 후 이용할 수 있는 기능입니다.</p>
</c:if>
<div>
	
</div>
<%@ include file="./footer_JYC.jsp"%>
</body>
</html>