<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>applicantDetail</title>
<style>
        #modal {
          display: none;
          position:relative;
          width:100%;
          height:100%;
          z-index:1;
        }
        
        #modal h2 {
          margin:0;
        }
        #modal button {
          display:inline-block;
          width:100px;
          margin-left:calc(100% - 100px - 10px);
        }
        
        #modal .modal_content {
          width:300px;
          margin:100px auto;
          padding:20px 10px;
          background:#fff;
          border:2px solid #666;
        }
        
        #modal .modal_layer {
          position:fixed;
          top:0;
          left:0;
          width:100%;
          height:100%;
          background:rgba(0, 0, 0, 0.5);
          z-index:-1;
        }   
</style> 

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function toggleInterest(mid) {
            $.post("/toggleInterest", { mid: mid }, function(response) {
                if (response === "added") {
                    alert("관심 목록에 추가되었습니다.");
                } else if (response === "removed") {
                    alert("관심 목록에서 제거되었습니다.");
                } else {
                    alert("처리 중 오류가 발생했습니다.");
                }
            });
        }
        
        function getNum(event) {
      	  document.getElementById('result').innerText = 
      	    event.target.value;
      	}
        
        document.getElementById("modal_opne_btn").onclick = function() {
            document.getElementById("modal").style.display="block";
        }
       
        document.getElementById("modal_close_btn").onclick = function() {
            document.getElementById("modal").style.display="none";
        }
        
    </script>
</head>
<body>
<h1>지원자 및 관심 구직자 정보 상세보기 페이지</h1>
<hr>
<c:set var="item" value="${item}" />
<button onclick="toggleInterest('${item.mid}')">관심</button>
<div id="root">
   
    <button type="button" id="modal_opne_btn">평점</button>
       
</div>
<br>
이름 : ${item.mname} <br>
나이 : ${age}<br>
전화번호 : ${item.mtel1}, ${item.mtel2}  <br>
이메일 : ${item.memail} <br>
거주지 : ${item.maddr1} <br>

이력서 목록
<table border="1">
  <thead>
      <tr>
          <td>이력서 제목</td>
          <td>작성일자</td>
      </tr>
  </thead>
  <tbody>
    <c:forEach items="${resumeList}" var="resume">
	    <tr>
	        <td><a href="applyResumeDetail?rno=${resume.rno }&mid=${item.mid}">${resume.rtitle}</a></td>
	        <td>${resume.rregdate}</td>
	    </tr>
	</c:forEach>


  </tbody>
</table>

평점 :


<div id="modal">
   
    <div class="modal_content">       
        <input type='radio' name='num' value='1' onclick='getNum(event)'/>
		<input type='radio' name='num' value='2' onclick='getNum(event)'/>
		<input type='radio' name='num' value='3' onclick='getNum(event)'/>
		<input type='radio' name='num' value='4' onclick='getNum(event)'/>
		<input type='radio' name='num' value='5' onclick='getNum(event)'/>
		<div id='result'></div>
        
       
        <button type="button" id="modal_close_btn">모달 창 닫기</button>
       
    </div>
   
    <div class="modal_layer"></div>
</div>


</body>
</html>
<%@ include file="./footer_JYC.jsp" %>
