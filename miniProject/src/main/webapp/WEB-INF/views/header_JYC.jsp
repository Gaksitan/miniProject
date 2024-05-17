<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#top {
	height: 300px;
	display: flex;
	justify-content: space-between;
	background: grey;
}


#mypage {
	display: flex;
	width: 400px;
}

div img {
	max-width: 100%;
	border-radius: 50%;
	width: 200px;
}

header a img {
	max-width: 100%;
	height: 200ppx;
	width: 200px;
	height: 200px;
}

#menu ul li a {
	text-decoration: none;
	color: black;
}

#menu ul li {
	list-style: none;
	display: inline;
}

#menu {
	backround: yellow;
	display: flex;
}

#menu select, #menu option {
	padding: 10px;
}
</style>

</head>
<body>

	<c:if test="${mid == null && cno == null }">
		<!-- 만약 mid가 널이면서 cno가 널이면 비회원이기 때문에 이 헤더가 나온다 -->
		<header id="top">
			<a href="#"> <img alt="로고 사진"
				src="/resources_JYC/images_JYC/logo.png">
			</a>
			<div>
				<input type="search" placeholder="검색" name="search"> <input
					type="submit" value="검색"> <a href="/mem/loginForm">로그인</a>
				<!-- 로그인 링크 처음에는 개인회원 로그인폼페이지로 넘어간다 -->
				<a href="/mem/registForm">회원가입</a>
				<!-- 회원가입 링크 처음에는 개인회원 회원가입폼페이지로 넘어간다 -->
			</div>
		</header>
	</c:if>
	
	<c:if test="${mid != null }"> <!-- 만약 mid가 널이 아니면 개인회원이기 때문에 이 헤더가 나온다 -->
		<header>
			<div id="top">

				<div id="left">
					<a href="#"> <img alt="로고 사진"
						src="/resources_JYC/images_JYC/logo.png">
					</a> <input type="search" placeholder="회사명, 직무, 테마" name="search">
					<input type="submit" value="검색">
				</div>
				<div id="mypage">
					<img alt="익명 사진" src="/resources_JYC/images_JYC/ano.png"> <select
						onchange="if(this.value) location.href=(this.value)">
						<option>${mid }님환영합니다</option>
						<option value="#">내 정보 관리</option>
						<option value="#">구독&amp;스크랩</option>
						<option value="#">내 문의사항</option>
						<option value="#" style="color: red">로그아웃</option>
					</select>
				</div>
			</div>
			<nav id="menu">
				<ul>
					<li><a href="#">채용공고</a></li>
					<li><a href="#">내 이력서 관리</a></li>
					<li><a href="#">지원현황</a></li>
				</ul>
				<select onchange="if(this.value) location.href=(this.value)">
					<option>-- 선택 --</option>
					<option value="#">커뮤니티</option>
					<option value="#">MY 게시판</option>
					<option value="#">게시글 작성하기</option>
				</select>
			</nav>
		</header>
	</c:if>
	
	<c:if test="${cno != null }"> <!-- 만약 cno가 널이 아니면 개인회원이기 때문에 이 헤더가 나온다 -->
		<header>
			<div id="top">

				<div id="left">
					<a href="#"> <img alt="로고 사진"
						src="/resources_JYC/images_JYC/logo.png">
					</a> <input type="search" placeholder="검색" name="search"> <input
						type="submit" value="검색">
				</div>
				<div id="mypage">
					<img alt="익명 사진" src="/resources_JYC/images_JYC/ano.png"> <select
						onchange="if(this.value) location.href=(this.value)">
						<option>${cno }님환영합니다</option>
						<option value="#">기업 정보 관리</option>
						<option value="#">인사담당자 정보 관리</option>
						<option value="#">관심 구직자</option>
						<option value="#" style="color: red">로그아웃</option>
					</select>
				</div>
			</div>
			<nav id="menu">
				<ul>
					<li><a href="#">채용공고 관리</a></li>
					<li><a href="#">지원받은 이력서</a></li>
				</ul>
				<select onchange="if(this.value) location.href=(this.value)">
					<option>-- 선택 --</option>
					<option value="#">커뮤니티</option>
					<option value="#">MY 게시판</option>
					<option value="#">게시글 작성하기</option>
				</select>
			</nav>
		</header>
	</c:if>

</body>
</html>