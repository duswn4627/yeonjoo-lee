<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	select {
		float: left;
/* 		display : inline-block;	 */
	}
	

	
</style>

<div class="container-fluid" >
	<h2 class="mt-4 pageTitle">매출 차트</h2>
	
	<div>
		<ul class="tab">
			<li style="font-size: 20px; padding-top: 35px; margin-right: 10px;"><a
				href="${pageContext.request.contextPath }/sales?menu=1">일별 매출</a></li>
			<li style="font-size: 20px; padding-top: 35px; margin-right: 10px;"><a
				href="${pageContext.request.contextPath }/sales?menu=2">주별 매출</a></li>
			<li style="font-size: 20px; padding-top: 35px; margin-right: 10px;"><a
				href="${pageContext.request.contextPath }/sales?menu=3">월별 매출</a></li>
		</ul>
	</div>
	
		<input type="hidden" value = "${menu}" id = "menu">
		<table class="table searchbox" style="margin-top: 50px;">
<!-- 			일별 검색 -->
			<c:if test="${menu == 1 }">
				<tr>
					<th class="table-active">기간</th>
					<td colspan="3">
						<div class = "row">
							<div class='col-md-3'> 
								<input class="btn btn-outline-success btn-sm dbtn" type="button" name="today" value = "오늘">
								<input class="btn btn-outline-success btn-sm dbtn" type="button" name="yesterday" value = "어제">
								<input class="btn btn-outline-success btn-sm dbtn" type="button" name="seven" value = "7일">
								<input class="btn btn-outline-success btn-sm dbtn" type="button" name="month" value = "1개월">
								<input class="btn btn-outline-success btn-sm dbtn" type="button" name="sixmonth" value = "6개월">
							</div>
							<div>
								<input type="date" name = "startDate" id = "startDate" value="${startDate }"> &nbsp;~ &nbsp;
								<input type="date" name = "endDate" id = "endDate" value="${endDate }">
							</div>
						</div>
					</td>
				</tr>
			</c:if>
<!-- 			주별 검색 -->
			<c:if test="${menu == 2 }">
			<tr>
				<th class="table-active">기간</th>
				<td>
					<div class="row">
						<span>최근&nbsp;</span>
						<input type = "text" id = "week" name = "week" class="form-control col-md-1"> 
						<span>&nbsp;주</span>
					</div>
				</td>
			</tr>
			</c:if>
			<c:if test="${menu == 3 }">
				<th class="table-active mm">기간</th>
				<td>
				<div class="row">
						<select id = "startYear" name = "startYear" class="form-control col-md-1">
							<option value="2020">2020</option>
							<option value = "2019">2019</option>
							<option value = "2018">2018</option>
							<option value = "2017">2017</option>
						</select>
						<span>&nbsp;년 &nbsp;</span>
						<select id = "startMonth" name = "startMonth" class="form-control col-md-1">
							<option value = "01">1</option>
							<option value = "02">2</option>
							<option value = "03">3</option>
							<option value = "04">4</option>
							<option value = "05">5</option>
							<option value = "06">6</option>
							<option value = "07">7</option>
							<option value = "08">8</option>
							<option value = "09">9</option>
							<option value = "10">10</option>
							<option value = "11">11</option>
							<option value = "12">12</option>
						</select>
						<span>&nbsp;월&nbsp;</span>
						&nbsp;~&nbsp;
						<select name = "endYear" id = "endYear" class="form-control col-md-1">
							<option value="2020">2020</option>
							<option value = "2019">2019</option>
							<option value = "2018">2018</option>
							<option value = "2017">2017</option>
						</select>
						<span>&nbsp;년&nbsp;</span>
						<select name = "endMonth" id ="endMonth" class="form-control col-md-1">
							<option value = "01">1</option>
							<option value = "02">2</option>
							<option value = "03">3</option>
							<option value = "04">4</option>
							<option value = "05">5</option>
							<option value = "06">6</option>
							<option value = "07">7</option>
							<option value = "08">8</option>
							<option value = "09">9</option>
							<option value = "10">10</option>
							<option value = "11">11</option>
							<option value = "12">12</option>
						</select>
						<span>&nbsp;월&nbsp;</span>
				</div>
				</td>			
			</c:if>
			<tr>
				<td align="center" colspan="4">
					<input id="searchBtn" class="btn btn-success float-center yrbtn" type = "submit" value = "검색" >
				</td>		
			</tr>
		</table>
</div>



<div class="container-fluid">

	<ol class="breadcrumb mb-4">
		<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
		<li class="breadcrumb-item active">Charts</li>
	</ol>
	<div class="card mb-4">
		<div class="card-header">
			<i class="fas fa-chart-area mr-1"></i> Area Chart Example
		</div>
		<div class="card-body">
			<canvas id="myAreaChart" width="100%" height="50"></canvas>
		</div>
		<div class="card-footer small text-muted">Updated yesterday at
			11:59 PM</div>
	</div>
</div>

<script type="text/javascript">

	$(function(){
		var menu = $("#menu").val();
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		var week = $("#week").val();
		var startYear = $("#startYear").val();
		var startMonth = $("#startMonth").val();
		var endYear = $("#endYear").val();
		var endMonth = $("#endMonth").val();
			
		ajdraw(menu,startDate, endDate, week, startYear, startMonth, endYear, endMonth);
		
	})
	
	$('#searchBtn').click(function(){
		var menu= $("#menu").val();
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		var week = $("#week").val();
		var startYear = $("#startYear").val();
		var startMonth = $("#startMonth").val();
		var endYear = $("#endYear").val();
		var endMonth = $("#endMonth").val();
		
// 		console.log(" sd : " +startDate + " ed : " + endDate + " w : " + week + " sy : " +  startYear + " sm : " + startMonth 
// 				+ " ey : " + endYear + " em : " + endMonth);
	
		
		ajdraw(menu,startDate, endDate, week, startYear, startMonth, endYear, endMonth);		
	})
	
	
	function ajdraw(menu,startDate, endDate, week, startYear, startMonth, endYear, endMonth){
		$.ajax({
			url: "${pageContext.request.contextPath}/sales/getInfo",
			dataType : "json",
			data : {menu:menu, startDate : startDate , endDate : endDate,  week:week , startYear:startYear, 
				startMonth:startMonth, endYear:endYear, endMonth:endMonth},
			success : function(data){
				if(data[0].code == "success"){
					draw(data[0].label,data[0].data);
				}else{
					alert("error")
				}
			}
		})
	}
	
	function draw(label,data){
		var ctx = document.getElementById("myAreaChart");

		var mychart = new Chart (ctx, {
			  type: 'line',
	 		  data: {
		        labels: label,
		        datasets: [{
		            label: '# of Votes',
		            data: data,
		            borderWidth: 1
		        }]
		    },
			  options : {
	 		        scales: {
	 		            yAxes: [{
	 		                ticks: {
	 		                    beginAtZero: true
	 		                }
	 		            }]
	 		        }
	 		    }
		})
	}
	
	
	
</script>

