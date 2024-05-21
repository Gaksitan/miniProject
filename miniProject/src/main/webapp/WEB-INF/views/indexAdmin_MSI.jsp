<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script
src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
</script>
<style>



section{
	width : 1500px;
	margin: auto;
	margin-top : 50px;
	margin-bottom : 50px;
	
	display:grid;
	grid-template-columns: 1fr 1fr;
	grid-row: auto auto;
	grid-column-gap: 30px;
	grid-row-gap: 80px;
	justify-content:center;
	align-items:center;
}



.div4{
	display:flex;
	flex-direction:column;
	justify-content:center;
	align-items:center;

}


#circle{
	background-color : darkgrey;
	border-radius : 50%;
	width:200px;
	height:200px;
	
	display:flex;
	justify-content:center;
	align-items:center;
	color: #ffffff;
	font-weight : bold;
	font-size:1.5em;
}





</style>
<body>
<%@ include file="./header_JYC.jsp"%>

<h1>Admin IndexPage</h1>

<section>
	<div class="div1">
	<canvas id="myChart1" style="width:100%; max-width:600px; height:400px"></canvas>
	</div>
	
	<div class="div2">
	<canvas id="myChart2" style="width:100%; max-width:600px; height:400px"></canvas>
	</div>
	
	<div class="div3">
	<canvas id="myChart3" style="width:100%; max-width:600px; height:400px"></canvas>
	</div>
	
	<div class="div4">
		<h3>답변 안한 질문 수</h3>
		<div id="circle">
			<a href="/admin/serviceQuestionNoAnswer" id="circletext"><span>${count}건</span></a>
		</div>
	</div>
</section>


<script>
	const xValues1 = ["05.19", "05.20", "05.21", "05.22", "05.23"];
	const yValues1 = [48, 71, 60, 51, 56];
	const barColors1 = ["#A9E2F3", "#A9E2F3","#A9E2F3","#A9E2F3","#A9E2F3"];
	
	new Chart("myChart1", {
	  type: "bar",
	  data: {
	    labels: xValues1,
	    datasets: [{
	      backgroundColor: barColors1,
	      data: yValues1
	    }]
	  },
	  options: {
		responsive: false,
	    legend: {display: false},
	    title: {
	      display: true,
	      text: "하루 총 사용자수"
	    }
	  }
	});
	
	
	
	const xValues2 = ["23년12월","1월","2월","3월","4월","5월"];
	const yValues2 = [315,356,411,591,688,721];

	new Chart("myChart2", {
	  type: "line",
	  data: {
	    labels: xValues2,
	    datasets: [{
	      fill: false,
	      backgroundColor: "rgba(0,0,255,1.0)",
	      borderColor: "rgba(0,0,255,0.1)",
	      data: yValues2
	    }]
	  },
	  options: {
		  responsive: false,
		  legend: {display: false},
		  title: {
		      display: true,
		      text: "월별 사용자수"
		    }
	  }
	});
	
	
	
	const xValues3 = ["구직자", "재직자", "기업회원", "구직미희망"];
	const yValues3 = [3422, 1854, 511, 1211];
	const barColors3 = [
	  "#b91d47",
	  "#00aba9",
	  "#2b5797",
	  "#1e7145"
	];

	new Chart("myChart3", {
	  type: "pie",
	  data: {
	    labels: xValues3,
	    datasets: [{
	      backgroundColor: barColors3,
	      data: yValues3
	    }]
	  },
	  options: {
		responsive: false,
	    title: {
	      display: true,
	      text: "이용자별 분류"
	    }
	  }
	});
</script>

<%@ include file="./footer_JYC.jsp"%>

</body>
</html>