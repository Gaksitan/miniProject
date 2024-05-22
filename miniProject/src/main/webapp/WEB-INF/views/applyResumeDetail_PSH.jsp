<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="./header_JYC.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>applyResumeDetail</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1>지원자 및 관심 구직자 이력서 상세보기 페이지</h1>
<hr>
<c:set var="item" value="${item}" />
<c:set var="resume" value="${resume}" />


<h2>${resume.rtitle}</h2>

<ul>
    <li>이름 : ${item.mname}</li>
    <li>메일 : ${item.memail}</li>
    <li>전화번호 : ${item.mtel2}</li>
</ul>



<h3>${resume.rintro}</h3>

<h3>스킬스텟</h3>
    <c:forEach items="${skillList}" var="skill">
            <td>${skill.skname}</td>
    </c:forEach>

<h3>경력</h3>
    <c:forEach items="${expList}" var="exp">
        <tr>
            <td>${exp.exname}</td>
            <td>${exp.exjoindate}</td>
            <td>${exp.exleavedate}</td>
            <td>${exp.exposition}</td>
            <td>${exp.exrank}</td>
        </tr>
        <br>
    </c:forEach>


<h3>학력</h3>
    <c:forEach items="${degreeList}" var="degree">
        <tr>
            <td>${degree.dename}</td>
            <td>${degree.degraddate}</td>
            <td>${degree.demajor}</td>
            <td>${degree.dehighestlevel}</td>
        </tr>
    </c:forEach>

<h3>링크</h3>
    <c:forEach items="${linkList}" var="link">
        <tr>
            <td>${link.lname}</td>
        </tr>
    </c:forEach>

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

<div id="root">
    <button type="button" id="modal_opne_btn">서류 평가</button>
</div>

<div id="modal">
    <div class="modal_content">       
        <button id="pass_btn_modal">합격</button>
        <button id="fail_btn_modal">불합격</button>
        <button type="button" id="modal_close_btn">모달 창 닫기</button>
    </div>
    <div class="modal_layer"></div>
</div>

<script>
    $(document).ready(function() {
        $("#modal_opne_btn").click(function() {
            $("#modal").show();
        });

        $("#modal_close_btn").click(function() {
            $("#modal").hide();
        });

        function updateApplicationStatus(arno, arg1) {
            $.ajax({
                url: '/updateApplicationStatus',
                type: 'GET',
                data: {
                    arno: arno,
                    status: status
                },
                success: function(response) {
                    alert(response);
                    $("#modal").hide();
                },
                error: function(error) {
                    alert('Failed to update status');
                }
            });
        }

        $("#pass_btn_modal").click(function() {
            var arno = "${resume.rno}";
            updateApplicationStatus(arno, 1);
        });

        $("#fail_btn_modal").click(function() {
            var arno = "${resume.rno}";
            updateApplicationStatus(arno, 0);
        });
    });
</script>

</body>
</html>
<%@ include file="./footer_JYC.jsp" %>
