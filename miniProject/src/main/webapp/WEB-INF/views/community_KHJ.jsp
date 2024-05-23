<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
img {
	width: 15px;
	height: 15px;
}

button {
	height: 50px;
	width: 150px;
}

select {

	margin-left : 1500px;

}

</style>
<link rel="stylesheet" href="../css/main.css" />
</head>
<body>
	<%@ include file="./header_JYC.jsp"%>
	<main>
		<h1>community 게시판</h1>
		<hr>


		<!-- 세션ID가 블랙리스트에 있는 ID라면 게시글 작성하기 버튼을 누르면 알림창이 뜨면서 작성페이지로 이동못하게 함 -->
		<c:if test="${not empty errorMessage}">
			<script>
            alert('${errorMessage}');
        </script>
		</c:if>



		<button type="button"
			onclick="location.href='/commu/communityMemInsert_KHJ'">게시글
			작성하기</button>
		<!-- 	<input placeholder="작성자, 게시물 제목"></input>
		<button type="submit" class="s1" value="찾기"></button> -->


		<!-- 공지사항 테이블 추가 -->

		<table border="1" width="500" cellpadding="0" cellspacing="0"
			style="text-align: center;">
			<thead>
				<tr>
					<th>공지번호</th>
					<th>공지제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>좋아요</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="notice" items="${noticeList }" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td><a href="/commu/communityNotice_MSI?nno=${notice.nno}">${notice.ntitle}</a></td>
						<td>${notice.ano}</td>
						<td>${notice.nregdate}</td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- 커뮤니티 테이블 -->
			<select id="sortOptions">
				<!--<option value="">추천순</option> 클릭 많은 순 -->
				<option value="reply">댓글순</option>
				<option value="likes">인기순</option>
				<!-- 좋아요 많은 순 -->
				<option value="date">최신순</option>
			</select>
			<c:if test="${mid != null and !paging.isEmpty()}">
				<table border="1" id="myTable">
					<thead>
						<tr>
							<th>번호</th>
							<th>게시물 제목</th>
							<th>작성자</th>
							<th>작성일자</th>
							<th>좋아요</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${commuList }" varStatus="status">
							<tr>
								<td>${status.count }</td>
								<td><a href="/commu/communityDetail_KHJ?bno=${board.bno}">${board.btitle}
										<c:forEach var="replyDetail" items="${replyDetails }">
											<c:if test="${replyDetail.bno == board.bno}">(${replyDetail.replycount})
										</c:if>
										</c:forEach>
								</a></td>
								<c:choose>
									<c:when test="${board.mid != null}">
										<td>${board.mid}</td>
									</c:when>
									<c:when test="${board.cmid != null}">
										<td>${board.cmid}</td>
									</c:when>
									<c:otherwise>
										<td>No ID available</td>
									</c:otherwise>
								</c:choose>
								<td>${board.bregdate }</td>
								<td>${board.blike }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		<c:if test="${!paging.isEmpty()}">
			<ul class="pagination justify-content-center">
				<c:if test="${hasPrevious == true }">
					<li class="page-item"><a class="page-link"
						href="/commu?page=${currentPage -1}"><span>이전</span> </a></li>
				</c:if>
				<c:forEach begin="1" end="${totalPages }" varStatus="status">
					<li class="page-item"><a href="/commu?page=${status.count }">${status.count }</a>
					</li>
				</c:forEach>
				<c:if test="${hasNext == true }">
					<li class="page-item"><a class="page-link"
						href="/commu?page=${currentPage+1}"><span>다음</span></a></li>
				</c:if>
			</ul>
		</c:if>
		</c:if>
			<c:if test="${companyManager != null and !paging.isEmpty()}">
				<table border="1" id="myTable">
					<thead>
						<tr>
							<th>번호</th>
							<th>게시물 제목</th>
							<th>작성자</th>
							<th>작성일자</th>
							<th>좋아요</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="board" items="${commuList }" varStatus="status">
							<tr>
								<td>${status.count }</td>
								<td><a href="/commu/communityDetail_KHJ?bno=${board.bno}">${board.btitle}
										<c:forEach var="replyDetail" items="${replyDetails }">
											<c:if test="${replyDetail.bno == board.bno}">(${replyDetail.replycount})
										</c:if>
										</c:forEach>
								</a></td>
								<c:choose>
									<c:when test="${board.mid != null}">
										<td>${board.mid}</td>
									</c:when>
									<c:when test="${board.cmid != null}">
										<td>${board.cmid}</td>
									</c:when>
									<c:otherwise>
										<td>No ID available</td>
									</c:otherwise>
								</c:choose>
								<td>${board.bregdate }</td>
								<td>${board.blike }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		<c:if test="${!paging.isEmpty()}">
			<ul class="pagination justify-content-center">
				<c:if test="${hasPrevious == true }">
					<li class="page-item"><a class="page-link"
						href="/commu?page=${currentPage -1}"><span>이전</span> </a></li>
				</c:if>
				<c:forEach begin="1" end="${totalPages }" varStatus="status">
					<li class="page-item"><a href="/commu?page=${status.count }">${status.count }</a>
					</li>
				</c:forEach>
				<c:if test="${hasNext == true }">
					<li class="page-item"><a class="page-link"
						href="/commu?page=${currentPage+1}"><span>다음</span></a></li>
				</c:if>
			</ul>
		</c:if>
		</c:if>









		<!-- 
	<c:if test="${companyManager != null and !paging.isEmpty()}">
		<c:forEach var="board" items="${commuList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="/commu/communityDetail_KHJ?bno=${board.bno}">${board.btitle}</a></td>
				<c:choose>
					<c:when test="${board.mid != null}">
						<td>${board.mid}</td>
					</c:when>
					<c:when test="${board.cmid != null}">
						<td>${board.cmid}</td>
					</c:when>
					<c:otherwise>
						<td>No ID available</td>
					</c:otherwise>
				</c:choose>
				<td>${board.bregdate }</td>
				<td>${board.blike }</td>
			</tr>
		</c:forEach>
	</c:if>
	</tbody>
	</table>
 -->

		<!-- 	<c:if test="${companyManager != null and !paing.isEmpty()}">
		<ul class="pagination justify-content-center">
			<c:if test="${hasPrevious == true }">
				<li class="page-item"><a class="page-link"
					href="/commu?page=${currentPage -1}"><span>이전</span> </a></li>
			</c:if>
			<c:forEach begin="1" end="${totalPages }" varStatus="status">
				<li class="page-item"><a href="/commu?page=${status.count }">${status.count }</a>
				</li>
			</c:forEach>
			<c:if test="${hasNext == true }">
				<li class="page-item"><a class="page-link"
					href="/commu?page=${currentPage+1}"><span>다음</span></a></li>
			</c:if>
		</ul>
	</c:if>
 -->
	</main>
	<%@ include file="./footer_JYC.jsp"%>
	<script>
	
	// replyDetails 배열을 JSON 형식으로 변환하여 JavaScript 변수에 할당
    const replyDetails = JSON.parse('${replyDetailsJson}');
		
		document.getElementById('sortOptions').addEventListener('change', function(){
			let table = document.getElementById('myTable').getElementsByTagName('tbody')[0];
			let rows = Array.from(table.rows); // tbody의 모든 행을 배열로 변환한다.
			let sortBy = this.value; // 선택된 정렬 옵션을 가져온다.

			rows.sort((a, b) => {
				let valA, valB;

				if (sortBy === 'likes') {
					valA = parseInt(a.cells[4].textContent); // 'Likes' 컬럼의 값을 가져온다.
					valB = parseInt(b.cells[4].textContent); // 'Likes' 컬럼의 값을 가져온다.
				} else if (sortBy == "date"){
					
					valA = new Date(a.cells[3].textContent);
					valB = new Date(b.cells[3].textContent);
				}else if(sortBy == "reply"){
					
					valA = findReplyCount(a.cells[0].textContent);
					valB = findReplyCount(b.cells[0].textContent);

				}

				if (valA < valB) return -1;
				if (valA > valB) return 1;
				return 0;
			});

			if (sortBy === 'likes' || sortBy === 'date' || sortBy === 'reply') {
				rows.reverse(); // 'Likes'의 경우 내림차순 정렬을 위해 배열을 역순으로 뒤집는다.
			}

			// 정렬된 행을 테이블에 다시 추가
			while (table.firstChild) {
				table.removeChild(table.firstChild);
			}
			rows.forEach(row => table.appendChild(row));
		});
		
		function findReplyCount(bno){
	
			for(let i = 0; i < replyDetails.length; i++){
				console.log("이건 무슨 숫자일까 ---> " + replyDetails[i].bno) // 모르겠다.
				if(replyDetails[i].bno == bno){
					
					return replyDetails[i].replycount;
				}
				
				
			}
			return 0;
			
		}
	</script>
</body>
</html>