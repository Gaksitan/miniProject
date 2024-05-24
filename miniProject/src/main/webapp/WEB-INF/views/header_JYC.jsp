<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <link rel="stylesheet" href="../css/header_css.css" />
 <style type="text/css">
 	html, body {
    height: 100dvh;
}
 </style>
</head>
<body>

	<c:if test="${mid == null && companyManager == null && admin == null }">
		<!-- 만약 mid가 널이면서 cno가 널이면 비회원이기 때문에 이 헤더가 나온다 -->
		<header>
			<div id="top">
				<div id="left">
					<a href="/mem/indexMem"> 
						<img id="logo" alt="로고 사진" src="/resources_JYC/images_JYC/logo.png">
					</a>
	
					<div class="search">
						<form action="/both/searchResultNoMem" method="get" id="searchForm">
							<!-- 검색 -->
							<img src="/resources_JYC/images_JYC/searchImg.png" style="width:30px; height:30px; margin:10px; transform: scaleX(-1);">
							<input type="search" placeholder="검색" name="search" id="searchBox">
							<input type="submit" value="검색" id="searchBtn">
						</form>
					</div>	
				</div>	
				
				<div id="right">
					<a href="/mem/loginForm">로그인</a>
					<!-- 로그인 링크 처음에는 개인회원 로그인폼페이지로 넘어간다 -->
					<a href="/mem/regFormMem">회원가입</a>
					<!-- 회원가입 링크 처음에는 개인회원 회원가입폼페이지로 넘어간다 -->
				</div>
			</div>
		
			<nav id="menu" class="navbar" style="padding: 15px 0;">
				<ul>
					<li><a href="/employnotice/list">채용공고</a></li>
				</ul>
			</nav>
		</header>
	</c:if>



	<c:if test="${mid != null }">
		<!-- 만약 mid가 널이 아니면 개인회원이기 때문에 이 헤더가 나온다 -->
		<header>
			<div id="top">
				<div id="left">
					<a href="/mem/indexMem">
					 <img id="logo" alt="로고 사진" src="/resources_JYC/images_JYC/logo.png">
					</a>
					<div class="search">
						<form action="/both/searchResultMem" method="get" id="searchForm">
							<!-- 검색 -->
							<img src="/resources_JYC/images_JYC/searchImg.png" style="width:30px; height:30px; margin:10px; transform: scaleX(-1);">
							<input type="search" placeholder="회사명, 직무, 테마" name="search" id="searchBox">
							<input type="submit" value="검색" id="searchBtn">
						</form>
					</div>
				</div>
				
				<div id="right">
					<img id="person" alt="익명 사진"
						src="/resources_JYC/images_JYC/person.png" style="width:70px; height:70px;">
					<div id="menuSelect">
						<select onchange="if(this.value) location.href=(this.value)" class="selectBox">
							<option class="options" value="#" disabled selected hidden>${mid }님 환영합니다!</option>
							<option class="options" value="/mem/infoMem">내 정보 관리</option>
							<option class="options" value="/member/subscribeAndScrapList">구독&amp;스크랩</option>
							<option class="options" value="/service/myQuestionMem">내 문의사항</option>
							<option class="options" value="/logout" style="color: red">로그아웃</option>
						</select>
					</div>
				</div>
			</div>
			
			<nav id="menu" class="navbar">
				<ul>
					<li><a href="/employnotice/list">채용공고</a></li>
					<li><a href="/mem/myResumeList">내 이력서 관리</a></li>
					<li><a href="/mem/myApplyList">지원현황</a></li>
				</ul>
				
				<div class="dropdown">
					<button class="dropbtn">커뮤니티
				      <i class="fa fa-caret-down"></i>
				    </button>
					<div class="dropdown-content">
					    <a href="/commu">커뮤니티 게시판</a>
					    <a href="/commu/communityMyBoards_KHJ">MY 게시판</a>
					    <a href="/commu/communityMemInsert_KHJ">게시글 작성하기</a>
					</div>
				</div>
			</nav>
			
		</header>
	</c:if>





	<c:if test="${companyManager != null }">
		<!-- 만약 cno가 널이 아니면 개인회원이기 때문에 이 헤더가 나온다 -->
		<header>
			<div id="top">
				<div id="left">
					<a href="/indexCom"> 
						<img id="logo" alt="로고 사진" src="/resources_JYC/images_JYC/logo.png">
					</a>
					<div class="search">
						<form action="/both/searchResultCom" method="get" id="searchForm">
							<!-- 검색 -->
							<img src="/resources_JYC/images_JYC/searchImg.png" style="width:30px; height:30px; margin:10px; transform: scaleX(-1);">
							<input type="search" placeholder="검색" name="search" id="searchBox">
							<input type="submit" value="검색" id="searchBtn">
						</form>
					</div>	
				</div>	
					
	
				<div id="right">
					<img id="person" alt="익명 사진"
						src="/resources_JYC/images_JYC/person.png" style="width:70px; height:70px;">
					<div id="menuSelect">
						<select class="selectBox" onchange="if(this.value) location.href=(this.value)">
							<option class="options" value="#">${companyManager.cmid }님 환영합니다!</option>
							<option class="options" value="/infoCom">기업정보 관리</option>
							<option class="options" value="/infoCM">인사담당자정보 관리</option>
							<option  class="options" value="/subscribeComList">관심 구직자</option>
							<option class="options" value="/service/myQuestionCom">내 문의사항</option>
							<option class="options" value="/logout" style="color: red">로그아웃</option>
						</select>
					</div>
				</div>	
			</div>
			
			
			<nav id="menu" class="navbar">
				<ul>
					<li><a href="/employNoticeList">채용공고 관리</a></li>
					<li><a href="/applicantList">지원받은 이력서</a></li>
				</ul>
				
				<div class="dropdown">
					<button class="dropbtn">커뮤니티
				      <i class="fa fa-caret-down"></i>
				    </button>
					<div class="dropdown-content">
					    <a href="/commu">커뮤니티 게시판</a>
					    <a href="/commu/communityMyBoards_KHJ">MY 게시판</a>
					    <a href="/commu/communityMemInsert_KHJ">게시글 작성하기</a>
					</div>
				</div>
			</nav>
		</header>
	</c:if>





	<c:if test="${admin != null }">
		<header>
			<div id="top">
				<div id="left">
					<a href="/admin/indexadmin"> 
						<img id="logo" alt="로고 사진" src="/resources_JYC/images_JYC/logo.png">
					</a>
					<div class="search">
						<form action="/both/searchResultMem" method="get" id="searchForm">
							<!-- 검색 -->
							<img src="/resources_JYC/images_JYC/searchImg.png" style="width:30px; height:30px; margin:10px; transform: scaleX(-1);">
							<input type="search" placeholder="검색" name="search" id="searchBox">
							<input type="submit" value="검색" id="searchBtn">
						</form>
					</div>
				</div>
				
				<div id="right">
					<img id="person" alt="익명 사진"
						src="/resources_JYC/images_JYC/person.png" style="width:70px; height:70px;">
					<div id="menuSelect">
						<select onchange="if(this.value) location.href=(this.value)" class="selectBox">
							<option class="options" value="#">${admin.aid }님 환영합니다!</option>
							<option class="options" value="/logout" style="color: red">로그아웃</option>
						</select>
					</div>
				</div>
			</div>
			<nav id="menu" class="navbar">
				<ul>
					<li><a href="/mem/indexMem">개인페이지</a></li>
					<li><a href="/indexCom">기업페이지</a></li>
					<li><a href="/admin/blackList">차단관리</a></li>
					<li><a href="/admin/serviceFAQ">고객센터</a></li>
					<li><a href="/admin/infoAdmin">공지사항 관리</a></li>
				</ul>
				
				<div class="dropdown">
					<button class="dropbtn">커뮤니티
				      <i class="fa fa-caret-down"></i>
				    </button>
					<div class="dropdown-content">
					    <a href="/commu">커뮤니티 게시판</a>
					    <a href="/commu/communityMyBoards_KHJ">MY 게시판</a>
					    <a href="/commu/communityMemInsert_KHJ">게시글 작성하기</a>
					</div>
				</div>
				
			</nav>
			
		</header>


	</c:if>

</body>
</html>