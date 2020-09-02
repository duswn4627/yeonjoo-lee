<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">

<div id="content_history">
	<i class="fab fa-first-order-alt"></i><h4 style="display:inline"><span id="colorfont">포인트</span>내역</h4>
	<form action="${cp }/members/point">
		<div class="date_picker shadow">
			<ul class="list-group list-group-horizontal" id="dateUl">
				<li class="list-group-item selectdate pointselect" onclick="changeDate(7,0)">최근 일주일</li>
				<li class="list-group-item active selectdate pointselect" onclick="changeDate(0,1)">1개월</li>
				<li class="list-group-item selectdate pointselect" onclick="changeDate(0,3)">3개월</li>
				<li class="list-group-item selectdate pointselect" onclick="changeDate(0,6)">6개월</li>
			</ul>
			<input type="text" id="date1" class="form-control" readonly="readonly">
			<i class="far fa-calendar-alt fa-2x calenderIcon" id="startday"></i>
			&nbsp&nbsp<span>~</span>&nbsp&nbsp
			<input type="text" id="date2" class="form-control" readonly="readonly">
			<i class="far fa-calendar-alt fa-2x calenderIcon" id="endday"></i>
			<button type="button" class='btn btn-dark' id="researchBtn">조회</button>
		</div>
		<div class="tableDiv shadow" id="tablediv">
			<table class="table" id="pointTable">
				<thead class="thead-dark">
					<tr style="text-align: center">
						<th width="80">주문번호</th>
						<th width="200">내용</th>
						<th width="120">사용금액</th>
						<th width="120">적립금액</th>
						<th width="120">거래일자</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
		<div class="pagingDiv" id="pointPaging">
							
		</div>
	</form>
</div>
<script>
		$(document).ready(function(){
			defaultDate();
			var startDay=$("#date1").val();
			var endDay=$("#date2").val();
			viewPointlist(startDay,endDay,1);	
		});
		
		var viewPointlist=function(startDay,endDay,pageNum){
			clearPointlist();
			if(pageNum==null){
				pageNum=1;
			}
			var paginationapp="<ul class='pagination pageul'>"
				+"<li class='page-item disabled'><a class='page-link' href='#'><<</a></li>"
				+"<li class='page-item disabled'><a class='page-link' href='#'>1</a></li>"
				+"<li class='page-item disabled'><a class='page-link' href='#'>>></a></li>"
				$("#pointPaging").append(paginationapp);
			$.ajax({
				url:'/finalproject/members/point',
				dataType:'json',
				type:'post',
				data:{startDay:startDay,endDay:endDay,pageNum:pageNum},
				success:function(data){
					if(data.length==1){ //값이없을때..
						var tableapp="<tr><td colspan='5'>포인트내역이 없습니다.</td></tr>";
						$("#pointTable > tbody").append(tableapp);
						return;
					}
					$(data).each(function(index,item){
						if(index==data.length-1){
							var yy=item.startDay;
							var mm=item.endDay;
							$("#pointPaging").empty();
							var paginationapp="<ul class='pagination pageul'>";
							if(item.startPageNum>=4){
								paginationapp+="<li class='page-item '>"
										+"<a class='page-link pageli' href='javascript:viewPointlist(\""+yy+"\",\""+mm+"\","+(item.pageNum-1)+")'><<"
										+"</a></li>";
							}else{
								paginationapp+="<li class='page-item disabled'><a class='page-link pageli' href='#'><<</a></li>";
							}
											
							for(let i=item.startPageNum;i<=item.endPageNum;i++){
								var yy=item.startDay;
								var mm=item.endDay;
								if(i==item.pageNum){
									paginationapp+="<li class='page-item disabled' ><a class='page-link pageli'"
										+"href='javascript:viewPointlist(\""+yy+"\",\""+mm+"\","+i+")'>"+i+"</a></li>"
								}else{
									paginationapp+="<li class='page-item'><a class='page-link pageli'"
										+"href='javascript:viewPointlist(\""+yy+"\",\""+mm+"\","+i+")'>"+i+"</a></li>"
								}
							}
							if(item.endPageNum<item.totalPageCount){
								paginationapp+="<li class='page-item'>"
									+"<a class='page-link pageli' href='javascript:viewPointlist(\""+yy+"\",\""+mm+"\","+(item.endPageNum+1)+")'>>></a></li>";
							}else{
								paginationapp+="<li class='page-item disabled'>"
										+"<a class='page-link pageli' href='#'>>></a></li>";
							}
							
							$("#pointPaging").append(paginationapp);
							return;
							
						}
						var tableapp="<tr>"
							//pu.totalRowCount - ((pu.pageNum-1) * 5 + status.index)
								    +"<td style='text-align: center'>"+item.no+"</td>"
								    +"<td style='text-align: center'>"+item.pointContent+"</td>"
								    +"<td style='text-align: right'>"+item.leftTranpoint+"</td>"
								    +"<td style='text-align: right'>"+item.rightTranpoint+"</td>"
								    +"<td style='text-align: center'>"+item.pregdate+"</td>"
								  +"</tr>"; 
						$("#pointTable > tbody").append(tableapp);
					})
					
					
				}
				
			})
			
		}
		var clearPointlist=function(){
			$("#pointTable > tbody").empty();
			$("#pointPaging").empty();
		}
		
		
		//ul 선택 이펙트
		$(".pointselect").click(function(){
			$(".pointselect").each(function(){
				$(this).removeClass('active')
			});
			$(this).addClass('active');
		});
		//데이트피커
		$("#startday").click(function(){
			$("#date1").datepicker('show')
		});
		$("#endday").click(function(){
			$("#date2").datepicker('show')
		});
		$("#date1, #date2").datepicker({
				showOn: "none",
				buttonText: "Calendar",
				dateFormat:"yy/mm/dd",
				dayNamesMin: ["일","월","화","수","목","금","토"],
				monthNames: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
				yearSuffix: "년",
				showMonthAfterYear: true,
				maxDate:0,
				
		});
		$("#date1").datepicker("option","onClose",function(d){
			$("#date2").datepicker("option","minDate",d);
		});
		$("#date2").datepicker("option","onClose",function(d){
			$("#date1").datepicker("option","maxDate",d);
		});
		var defaultDate=function(){
			var date=new Date();
			var year=date.getFullYear();
			var month1=date.getMonth();
			var month=date.getMonth()+1;
			var day=date.getDate();
			if((month+"").length<2){ 
				month="0"+month;
			}
			if((day+"").length<2){ 
				day="0"+day;
			}
			var today=year+"/"+month+"/"+day;
			$("#date2").val(today);
			
			date.setMonth(month1-1);
			var year1=date.getFullYear();
			var month2=date.getMonth()+1;
			var day1=date.getDate();
			if((month2+"").length<2){ 
				month2="0"+month2;
			}
			if((day1+"").length<2){ 
				day1="0"+day1;
			}
			var day1=year1+"/"+month2+"/"+day1;
			$("#date1").val(day1);
		}
		//li버튼 클릭시 날짜변경이벤트.
		var changeDate=function(vdate,vmonth){
			var date=new Date();
			var day=date.getDate();
			if(vdate!=null&&vdate!=0){
				date.setDate(day-7);
			}
			var month=date.getMonth();
			if(vmonth!=null&&vmonth!=0){
				date.setMonth(month-vmonth);
			}
			var year=date.getFullYear();
			var month1=date.getMonth()+1;
			var day1=date.getDate();
			if((month1+"").length<2){ 
				month1="0"+month1;
			}
			if((day1+"").length<2){ 
				day1="0"+day1;
			}
			var today=year+"/"+month1+"/"+day1;
			
			var todate=new Date();
			var toyear=todate.getFullYear();
			var tomonth=todate.getMonth()+1;
			var dayto=todate.getDate();
			if((tomonth+"").length<2){ 
				tomonth="0"+tomonth;
			}
			if((dayto+"").length<2){ 
				dayto="0"+dayto;
			}
			var today1=toyear+"/"+tomonth+"/"+dayto;
			$("#date2").val(today1);
			$("#date1").val(today);	 
		};
		$("#dateUl li").on('click',function(){
			var startDay=$("#date1").val();
			var endDay=$("#date2").val();
			clearPointlist();
			viewPointlist(startDay,endDay,1);
		});
		$("#pointSelect").change(function(){
			clearPointlist();
			var startDay=$("#date1").val();
			var endDay=$("#date2").val();
			viewPointlist(startDay,endDay,1);
		});
		$("#researchBtn").on('click',function(){
			var startDay=$("#date1").val();
			var endDay=$("#date2").val();
			clearPointlist();
			viewPointlist(startDay,endDay,1);
		});
</script>
<style>
		/*회원포인트 css*/
		#colorfont {
			color: #f51167;
		}
		
		#content_history {
			position: absolute;
			display: inline-block;
			border-top: 1px solid #dee2e6;
			width: 927px;
			height: 670px;
			padding: 10px
		}
		
		.calenderIcon {
			position: relative;
			top: 8px;
		}
		
		.list-group {
			display: inline-flex;
		}
		
		.date_picker {
			margin-top: 15px;
			padding: 15px;
			border-radius: 8px;
			border: 2px solid grey;
		}
		
		#dateUl {
			list-style-type: none;
		}
		
		.selectdate {
			text-align: center;
			font-size: 12px;
			width: 100px;
			height: 35px;
			padding: 0px;
			padding-top: 7px;
		}
		
		#date1, #date2 {
			width: 110px;
			font-size: 12px;
			display: inline-block;
		}
		
		.movedetail:link {
			color: black;
			text-decoration: none;
		}
		
		.movedetail:visited {
			color: black;
			text-decoration: none;
		}
		
		.movedetail:hover {
			color: #f51167;
		}
		
		#tablediv {
			border-radius: 8px;
			margin-top: 20px;
			font-size: 14px;
			border: 2px solid grey;
			width: 907px;
			height: 435px;
			padding: 5px;
		}
		
		#btnDiv {
			text-align: right;
		}
		
		#pointPaging {
			text-align: center;
			position: absolute;
			top: 620px;
			left: 370px;
		}
		
		.pageli {
			width: 34px;
		}
		
		.list-group-item.active {
			background-color: #f51167;
			border-color: #f51167;
		}
		
		#pointSelect {
			outline: gray;
			height: 25px;
			width: 130px;
			display: inline-block;
			font-size: 11.5px;
			padding-left: 15px;
			padding-top: 0px;
			padding-bottom: 2px;
		}
</style>