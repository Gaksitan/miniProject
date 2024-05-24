<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#container {
	display: grid;
	width: 80%;
	margin: 0 auto;
	grid-template-columns: repeat(4, 1fr);
	gap: 20px;
}

.items ul li {
	list-style: none;
}

.items ul {
	padding: 0;
}
.items a{
	text-decoration: none;
	color: black;
}
.items {
	border-radius: 5px;
	border: 1px solid black;
	width: 200px;
	height: 230px;
	box-shadow: 1px 1px 1px black;
}
.items .imgs{
	 height: 120px;
	 border-bottom: 1px solid black;
	 background: gray;
}

.enpositions{
	margin: 5px 0;
	border-top: 1px solid black;
}
</style>

<link rel="stylesheet" href="../css/main.css" />
</head>
<body>

	<%@ include file="./header_JYC.jsp"%>

	<main>
		<c:if test="${cno == null }">
		<select onchange="chageSelect" id="selectbox" name="selectbox">
			<option value="enddate">마감일순</option>
			<option value="regdate">작성일순</option>
		</select>
		</c:if>
		<c:if test="${cno != null }">
		<select onchange="chageSelectCno" id="selectboxCno" name="selectboxCno">
			<option value="enddate">마감일순</option>
			<option value="regdate">최신순</option>
		</select>
		</c:if>
		<div id="container">
			<c:forEach var="employNotice" items="${employNoticeList }"
				varStatus="status">
				<div class="items">
					<ul>
						<li class="imgs"></li>
						<c:if test="${mid == null && companyManager == null }">
							<li><a
								href="/employnotice/detailNoneMem?enno=${employNotice.enno }">${employNotice.entitle }
								<c:if test="${fn:length(employNotice.entitle) == 20 }">
								...
								</c:if>
								</a></li>
						</c:if>
						<c:if test="${mid != null }">
							<li><a
								href="/employnotice/detailMem?enno=${employNotice.enno }">${employNotice.entitle }
								<c:if test="${fn:length(employNotice.entitle) == 20 }">
								...
								</c:if>
								</a></li>
						</c:if>
						<c:if test="${companyManager != null }">
							<li><a
								href="/employnotice/detailCom?enno=${employNotice.enno }">${employNotice.entitle }
								<c:if test="${employNotice.entitle.length == 20 }">
								...
								</c:if>
								</a></li>
						</c:if>
						<li class="enpositions">${employNotice.enposition }</li>
						<li>${employNotice.enenddate }</li>
					</ul>
				</div>
			</c:forEach>
		</div>


	</main>

	<%@ include file="./footer_JYC.jsp"%>
	<script type="text/javascript">
		function chageSelect() {
			const selectbox = document.getElementById("selectbox");

			const selectValue = selectbox.options[selectbox.selectedIndex].value;
			
			location.href="/employnotice/changeOrder?ordername=" + selectValue;
		}
		
		function chageSelectCno() {
			const selectbox = document.getElementById("selectboxCno");

			const selectValue = selectbox.options[selectbox.selectedIndex].value;
			
			location.href="/employnotice/changeOrderCompany?ordername=" + selectValue + "&cno=${cno}";
		}
	</script>
</body>
</html>