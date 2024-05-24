<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="../css/main.css" />
<style>
    #modal {
        display: none;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        z-index: 1;
    }

    #modal h2 {
        margin: 0;
    }
    #modal button {
        display: inline-block;
        width: 100px;
        margin-left: calc(100% - 100px - 10px);
    }

    #modal .modal_content {    
        width: 600px;
        margin: 100px auto;
        padding: 20px 10px;
        background: #fff;
        border: 2px solid #666;
    }

    #modal .modal_layer {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.5);
        z-index: -1;
    }
</style>

<body>
<%@ include file="./header_JYC.jsp"%>
<main>
<hr>
<h2>지원 현황 목록</h2>
<table border="1">
	<c:forEach var="applyResume" items="${myApplyList }" varStatus="status">
		<tr>
			<td>${applyResume.cname }</td>
			<td>${applyResume.entitle }</td>
			<td>${applyResume.applydate }</td>
	

			 <c:set var="isScrap" value="false"/>
	        <c:forEach var="scrap" items="${scrapList}">
	            <c:if test="${scrap.enno == applyResume.enno}">
	                <c:set var="isScrap" value="true"/>
	            </c:if>
	        </c:forEach>

	        <td id="scrap-link-${applyResume.enno}">
	            <c:choose>
	                <c:when test="${isScrap}">
	                    <a href="javascript:void(0);" onclick="deleteScrap(${applyResume.enno})">스크랩취소</a>
	                </c:when>
	                <c:otherwise>
	                    <a href="javascript:void(0);" onclick="scrap(${applyResume.enno})">스크랩</a>
	                </c:otherwise>
	            </c:choose>
	        </td>
			
			
	
			<td><c:if test="${applyResume.arpass == 0}">불합격</c:if>
				<c:if test="${applyResume.arpass == 1}">합격</c:if>
				<c:if test="${applyResume.arpass == 2}">심사중</c:if></td>
			<td>${applyResume.ipass }</td>
			<td>
			     <button type="button" id="modal_opne_btn">평점</button>
			</td>
		</tr>
	</c:forEach>
</table>
	<div id="modal">
        <div class="modal_content">       
            <input type='radio' name='num' value='1'/>
            <input type='radio' name='num' value='2'/>
            <input type='radio' name='num' value='3'/>
            <input type='radio' name='num' value='4'/>
            <input type='radio' name='num' value='5'/>
            <div id='result'></div>
            <textarea id="review" placeholder="리뷰를 입력하세요"></textarea>
            <button type="button" id="modal_close_btn">모달 창 닫기</button>
            <button type="button" id="submit_score_btn">평점 제출</button>
        </div>
        <div class="modal_layer"></div>
    </div>





</main>


<%@ include file="./footer_JYC.jsp"%>



<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function scrap(enno) {
    $.ajax({
        url: '/mem/scrap',
        type: 'POST',
        data: { enno: enno },
        success: function(response) {
            if (response.scrapResult) {
                // 스크랩 성공 시 스크랩취소로 표시
                document.getElementById('scrap-link-' + enno).innerHTML = '<a href="javascript:void(0);" onclick="deleteScrap(' + enno + ')">스크랩취소</a>';
            }
        },
        error: function() {
            alert('스크랩에 실패했습니다. 다시 시도해주세요.');
        }
    });
}

function deleteScrap(enno) {
    $.ajax({
        url: '/mem/deleteScrap',
        type: 'POST',
        data: { enno: enno },
        success: function(response) {
            if (response.deleteScrapResult) {
                // 스크랩 취소 성공 시 스크랩으로 표시
                document.getElementById('scrap-link-' + enno).innerHTML = '<a href="javascript:void(0);" onclick="scrap(' + enno + ')">스크랩</a>';
            }
        },
        error: function() {
            alert('스크랩 취소에 실패했습니다. 다시 시도해주세요.');
        }
    });
}



$(document).ready(function() {
    /* $("#modal_opne_btn").on("click", function() {
        $("#modal").show();
    });
	 */
	/*  $("#modal_opne_btn").on("click", function() {
        var enno = $(this).data("enno");
        $("#modal").show().data("enno", enno);
    }); */
	 $("#modal_opne_btn").on("click", function() {
		    var enno = $(this).closest("tr").find("[id^='scrap-link-']").attr("id").split("-")[2];
		    $("#modal").show().data("enno", enno);
		});
    
    $("#modal_close_btn").on("click", function() {
        $("#modal").hide();
    });

    $("input[name='num']").on("click", function(event) {
        $('#result').text(event.target.value);
    });

    $("#submit_score_btn").on("click", function() {
        var score = $("input[name='num']:checked").val();
        var review = $("#review").val();
        var enno = $("#modal").data("enno");

        $.post("/mem/submitScore", { enno: enno, score: score, review: review }, function(response) {
            if (response === "success") {
                alert("평점이 성공적으로 제출되었습니다.");
                $("#modal").hide();
            } else {
                alert("평점 제출 중 오류가 발생했습니다.");
            }
        });
    });

    
});



function updateAverageScore(mid) {
    $.post("/getAverageScore", { mid: mid }, function(response) {
        $("#average_score").text(response.toFixed(2));
    });
}

// 초기 로드 시 평균 평점 업데이트
var mid = "${item.mid}";
updateAverageScore(mid);

</script>




</body>
</html>