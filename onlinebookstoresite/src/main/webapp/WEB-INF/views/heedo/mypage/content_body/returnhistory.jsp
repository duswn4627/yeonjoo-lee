<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${cp }/resources/hd/datepicker/jquery-ui.css">
<script src="${cp }/resources/hd/datepicker/jquery-ui.js"></script> 
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<%-- <script src="${cp }/resources/hd/datepicker/bootstrap-datepicker.ko.js"></script> --%>
<div id="content_history">	
	<i class="fab fa-first-order-alt"></i><h4 style="display:inline"><span class="colorfont">반품</span>/<span class="colorfont">교환</span> 신청,완료 내역</h4>
	<div class="tabs">
	  <div class="tab-2" id="new_tab-2" style="z-index:2">
	    <label for="tab2-1" style="background-color:#212529;color:white;" id="tabnew">새상품</label>
	    <input id="tab2-1" name="tabs-two" type="radio" checked="checked">
	    <div id="newtab">
			<div class="date_picker shadow">
				<ul class="list-group list-group-horizontal" id="dateUl">
					<li class="list-group-item selectdate newselect" onclick="changeDate(7,0)">최근 일주일</li>
					<li class="list-group-item active selectdate newselect" onclick="changeDate(0,1)">1개월</li>
					<li class="list-group-item selectdate newselect" onclick="changeDate(0,3)">3개월</li>
					<li class="list-group-item selectdate newselect" onclick="changeDate(0,6)">6개월</li>
				</ul>
				<input type="text" id="date1" class="form-control" readonly="readonly">
				<i class="far fa-calendar-alt fa-2x calenderIcon" id="startday"></i>
				&nbsp&nbsp<span>~</span>&nbsp&nbsp
				<input type="text" id="date2" class="form-control" readonly="readonly">
				<i class="far fa-calendar-alt fa-2x calenderIcon" id="endday"></i>
				<button type="button" class='btn btn-dark' id="researchBtn">조회</button>
			</div>
			
			<div class="tableDiv shadow" id="tablediv">
				<div style="text-align: right" id="selectboxdiv">
				
					<select class="form-control" id="statusSelect">
						<option value="returnall" selected="selected">전체</option>
						<option value="apply">신청</option>
						<option value="complete">완료</option>
						
					</select>
				</div>
				<table class="table" id="newTable">
					<thead class="table-dark">
						<th style="text-align:center;">주문번호</th>
						<th>주문내역</th>
						<th>주문금액</th>
						<th>주문일자</th>
						<th>상태</th>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
			<div class="pagingDiv" id="newPaging">
							
			</div>
		</div>
	</div>
		<div class="tab-2" id="used_tab-2">
		   	<label for="tab2-2"  style="background-color:#212529;color:white;" id="tabused">중고상품</label>
		   	<input id="tab2-2" name="tabs-two" type="radio">
		   	 <div id="newtab">
			<div class="date_picker shadow">
				<ul class="list-group list-group-horizontal" id="useddateUl">
					<li class="list-group-item selectdate usedselect" onclick="usedchangeDate(7,0)">최근 일주일</li>
					<li class="list-group-item active selectdate usedselect" onclick="usedchangeDate(0,1)">1개월</li>
					<li class="list-group-item selectdate usedselect" onclick="usedchangeDate(0,3)">3개월</li>
					<li class="list-group-item selectdate usedselect" onclick="usedchangeDate(0,6)">6개월</li>
				</ul>
				<input type="text" id="useddate1" class="form-control" readonly="readonly">
				<i class="far fa-calendar-alt fa-2x calenderIcon" id="usedstartday"></i>
				&nbsp&nbsp<span>~</span>&nbsp&nbsp
				<input type="text" id="useddate2" class="form-control" readonly="readonly">
				<i class="far fa-calendar-alt fa-2x calenderIcon" id="usedendday"></i>
				<button type="button" class='btn btn-dark' id="usedresearchBtn">조회</button>
			</div>
			
			<div class="tableDiv shadow" id="usedtablediv">
				<div style="text-align: right" id="usedselectboxdiv">
				
					<select class="form-control" id="usedstatusSelect">
						<option value="returnall" selected="selected">전체</option>
						<option value="apply">신청</option>
						<option value="complete">완료</option>
						
					</select>
				</div>
				<table class="table" id="usedTable">
					<thead class="table-dark">
						<th style="text-align:center;">주문번호</th>
						<th>주문내역</th>
						<th>주문금액</th>
						<th>주문일자</th>
						<th>상태</th>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
			<div class="pagingDiv" id="usedPaging">
							
			</div>
		</div>
		</div>
		</div>
</div>
<script>
	$(document).ready(function(){
		defaultDate();
		var startDay=$("#date1").val();
		var endDay=$("#date2").val();
		var value=$("#statusSelect").val();
		viewNewReturnlist(startDay,endDay,1,value);	
		var usedstartDay=$("#useddate1").val();
		var usedendDay=$("#useddate2").val();
		var usedvalue=$("#usedstatusSelect").val();
		viewUsedReturnlist(usedstartDay,usedendDay,1,usedvalue);
	});
	// 상단 중고상품, 새상품 탭클릭시마다. div z-index 조정....
	$("#tabnew").click(function(){
		$("#new_tab-2").css('z-index','2')
		$("#newtab").css('z-index','2');
		$("#used_tab-2").css('z-index','1')
	});
	$("#tabused").click(function(){
		$("#used_tab-2").css('z-index','2')
		$("#newtab").css('z-index','1');
		$("#new_tab-2").css('z-index','1');
	});
	var viewUsedReturnlist=function(startDay,endDay,pageNum,value){
		clearUsedlist();
		if(pageNum==null){
			pageNum=1;
		}
	
		var paginationapp="<ul class='pagination pageul'>"
			+"<li class='page-item disabled'><a class='page-link' href='#'><<</a></li>"
			+"<li class='page-item disabled'><a class='page-link' href='#'>1</a></li>"
			+"<li class='page-item disabled'><a class='page-link' href='#'>>></a></li>"
			$("#usedPaging").append(paginationapp);
		$.ajax({
			url:'/finalproject/mypage/usedReturnhistory',
			dataType:'json',
			type:'post',
			data:{startDay:startDay,endDay:endDay,pageNum:pageNum,value:value},
			success:function(data){
				if(data.length==1){ //값이없을때..
					var tableapp="<tr><td colspan='5' style='text-align:center;'>신청내역이 없습니다.</td></tr>";
					$("#usedTable > tbody").append(tableapp);
					
					return;
				}
				
				$(data).each(function(index,item){
					if(index==data.length-1){
						var yy=item.startDay;
						var mm=item.endDay;
						$("#usedPaging").empty();
						var paginationapp="<ul class='pagination pageul'>";
						if(item.startPageNum>=6){
							paginationapp+="<li class='page-item '>"
									+"<a class='page-link pageli' href='javascript:viewUsedOrderlist(\""+yy+"\",\""+mm+"\","+(item.startpageNum-1)+"."+item.value+")'><<"
									+"</a></li>";
						}else{
							paginationapp+="<li class='page-item disabled'><a class='page-link pageli' href='#'><<</a></li>";
						}
										
						for(let i=item.startPageNum;i<=item.endPageNum;i++){
							var yy=item.startDay;
							var mm=item.endDay;
							if(i==item.pageNum){
								paginationapp+="<li class='page-item disabled' ><a class='page-link pageli'"
									+"href='javascript:viewUsedOrderlist(\""+yy+"\",\""+mm+"\","+i+"."+item.value+")'>"+i+"</a></li>"
							}else{
								paginationapp+="<li class='page-item'><a class='page-link pageli'"
									+"href='javascript:viewUsedOrderlist(\""+yy+"\",\""+mm+"\","+i+"."+item.value+")'>"+i+"</a></li>"
							}
							
							
						}
						if(item.endPageNum<item.totalPageCount){
							paginationapp+="<li class='page-item'>"
								+"<a class='page-link pageli' href='javascript:viewUsedOrderlist(\""+yy+"\",\""+mm+"\","+(item.endPageNum+1)+"."+item.value+")'>>></a></li>";
						}else{
							paginationapp+="<li class='page-item disabled'>"
									+"<a class='page-link pageli' href='#'>>></a></li>";
						}
						
						$("#usedPaging").append(paginationapp);
						return;
						
					}
					var date=new Date(Date.parse(item.borderdate));
					var tableapp="<tr>"
							    +"<td style='text-align:center;'>"+item.ordernum+"</td>"
							    +"<td>"+item.ordername+"</td>"
							    +"<td>"+item.ordermoney+"</td>"
							    +"<td>"+item.borderdate+"</td>"
							    +"<td>"+item.status+"</td>"
							  +"</tr>"; 
					$("#usedTable > tbody").append(tableapp);
				})
				
				
			}
			
		})
		
	}
	var viewNewReturnlist=function(startDay,endDay,pageNum,value){
		clearNewlist();
		if(pageNum==null){
			pageNum=1;
		}
	
		var paginationapp="<ul class='pagination pageul'>"
			+"<li class='page-item disabled'><a class='page-link' href='#'><<</a></li>"
			+"<li class='page-item disabled'><a class='page-link' href='#'>1</a></li>"
			+"<li class='page-item disabled'><a class='page-link' href='#'>>></a></li>"
			$("#newPaging").append(paginationapp);
		$.ajax({
			url:'/finalproject/mypage/newReturnhistory',
			dataType:'json',
			type:'post',
			data:{startDay:startDay,endDay:endDay,pageNum:pageNum,value:value},
			success:function(data){
				if(data.length==1){ //값이없을때..
					var tableapp="<tr><td colspan='5' style='text-align:center;'>신청내역이 없습니다.</td></tr>";
					$("#newTable > tbody").append(tableapp);
						return;
				}
				
				$(data).each(function(index,item){
					if(index==data.length-1){
						var yy=item.startDay;
						var mm=item.endDay;
						$("#newPaging").empty();
						var paginationapp="<ul class='pagination pageul'>";
						if(item.startPageNum>=6){
							paginationapp+="<li class='page-item '>"
									+"<a class='page-link pageli' href='javascript:viewNewOrderlist(\""+yy+"\",\""+mm+"\","+(item.startpageNum-1)+"."+item.value+")'><<"
									+"</a></li>";
						}else{
							paginationapp+="<li class='page-item disabled'><a class='page-link pageli' href='#'><<</a></li>";
						}
										
						for(let i=item.startPageNum;i<=item.endPageNum;i++){
							var yy=item.startDay;
							var mm=item.endDay;
							if(i==item.pageNum){
								paginationapp+="<li class='page-item disabled' ><a class='page-link pageli'"
									+"href='javascript:viewNewOrderlist(\""+yy+"\",\""+mm+"\","+i+"."+item.value+")'>"+i+"</a></li>"
							}else{
								paginationapp+="<li class='page-item'><a class='page-link pageli'"
									+"href='javascript:viewNewOrderlist(\""+yy+"\",\""+mm+"\","+i+"."+item.value+")'>"+i+"</a></li>"
							}
							
							
						}
						if(item.endPageNum<item.totalPageCount){
							paginationapp+="<li class='page-item'>"
								+"<a class='page-link pageli' href='javascript:viewNewOrderlist(\""+yy+"\",\""+mm+"\","+(item.endPageNum+1)+"."+item.value+")'>>></a></li>";
						}else{
							paginationapp+="<li class='page-item disabled'>"
									+"<a class='page-link pageli' href='#'>>></a></li>";
						}
						
						$("#newPaging").append(paginationapp);
						return;
						
					}
					var date=new Date(Date.parse(item.borderdate));
					var tableapp="<tr>"
							    +"<td style='text-align:center;'><a class='movedetail' href='${cp}/orderhistory/detailview?bpaynum="+item.ordernum+"'>"+item.ordernum+"</a></td>"
							    +"<td>"+item.ordername+"</td>"
							    +"<td>"+item.ordermoney+"</td>"
							    +"<td>"+item.borderdate+"</td>"
							    +"<td>"+item.status+"</td>"
							  +"</tr>"; 
					$("#newTable > tbody").append(tableapp);
				})
				
				
			}
			
		})
		
	}
	var clearNewlist=function(){
		$("#newTable > tbody").empty();
		$("#newPaging").empty();
	}
	var clearUsedlist=function(){
		$("#usedTable > tbody").empty();
		$("#usedPaging").empty();
	}
	$("#statusSelect").change(function(){
		var value=$(this).val();
		clearNewlist();
		var startDay=$("#date1").val();
		var endDay=$("#date2").val();
		viewNewReturnlist(startDay,endDay,1,value);
	});
	$("#usedstatusSelect").change(function(){
		var value=$(this).val();
		clearUsedlist();
		var startDay=$("#useddate1").val();
		var endDay=$("#useddate2").val();
		viewUsedReturnlist(startDay,endDay,1,value);
	});
	
	//ul 선택 이펙트
	$(".newselect").click(function(){
		$(".newselect").each(function(){
			$(this).removeClass('active')
		});
		$(this).addClass('active');
	});
	$(".usedselect").click(function(){
		$(".usedselect").each(function(){
			$(this).removeClass('active')
		});
		$(this).addClass('active');
	});
	//============ 데이트 피커 설정 시작 ==================//
	$("#startday").click(function(){
		$("#date1").datepicker('show')
	})
	$("#endday").click(function(){
		$("#date2").datepicker('show')
	})
	$("#usedstartday").click(function(){
		$("#useddate1").datepicker('show')
	})
	$("#usedendday").click(function(){
		$("#useddate2").datepicker('show')
	})
	$("#date1, #date2,#useddate1,#useddate2").datepicker({
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
	$("#useddate1").datepicker("option","onClose",function(d){
		$("#useddate2").datepicker("option","minDate",d);
	});
	$("#useddate2").datepicker("option","onClose",function(d){
		$("#useddate1").datepicker("option","maxDate",d);
	});
	//처음 날짜 지정.
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
		$("#date2,#useddate2").val(today);
		
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
		$("#date1,#useddate1").val(day1);
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
	var usedchangeDate=function(vdate,vmonth){
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
		$("#useddate2").val(today1);
		$("#useddate1").val(today);	 
	};
	
	//============ 데이트 피커 설정 끝 ==================//
	$("#dateUl li").on('click',function(){
		var startDay=$("#date1").val();
		var endDay=$("#date2").val();
		var value=$("#statusSelect").val()
		clearNewlist();
		viewNewReturnlist(startDay,endDay,1,value);
	});
	
	$("#useddateUl li").on('click',function(){
		var startDay=$("#useddate1").val();
		var endDay=$("#useddate2").val();
		var value=$("#usedstatusSelect").val()
		clearUsedlist();
		viewUsedReturnlist(startDay,endDay,1,value);
	});
	$("#researchBtn").on('click',function(){
		var startDay=$("#date1").val();
		var endDay=$("#date2").val();
		var value=$("#statusSelect").val()
		clearNewlist();
		viewNewReturnlist(startDay,endDay,1,value);
	});
	$("#usedresearchBtn").on('click',function(){
		var startDay=$("#useddate1").val();
		var endDay=$("#useddate2").val();
		var value=$("#usedstatusSelect").val()
	
		clearUsedlist();
		viewUsedReturnlist(startDay,endDay,1,value);
	});
	

	
	
	
   
  
</script>
<style>
	#content_history{
	position: absolute;
    display: inline-block;
    border-top:1px solid #dee2e6;
    width: 927px;
    height: 720px;
    padding:10px
	}
	.calenderIcon{
		position:relative;
		top:8px;
	}
	.colorfont{
		color:#f51167;
	}
	.list-group{
		display:inline-flex;
	}
	.date_picker{
		 
		margin-top: 15px;
		padding:15px;
		border-radius: 8px;
		border:2px solid grey;
	}
	.selectdate{
		text-align:center;
		font-size:12px;
		width:100px;
		height:35px;
		padding:0px;
		padding-top:7px;
	}
	#dateUl,#useddateUl{
		list-style-type: none;
	}
	#date1,#date2,#useddate1,#useddate2{
		width:110px;
		font-size:12px;
		display:inline-block;
	}
	.movedetail:link{
		color:black;text-decoration: none;
	}
	.movedetail:visited{color:black;text-decoration:none;}
	.movedetail:hover{color:#f51167;}
	#tablediv,#usedtablediv{
	 border-radius: 8px;
		margin-top: 20px;
		font-size:14px;
		border:2px solid grey;
		width:907px;
		height:435px;
		padding:5px;
	}
	#newPaging,#usedPaging{
		text-align: center;
		position:absolute;
		top: 650px;
  		left: 400px;
	}
	.pageli{
		width:34px;
	}
	#newtab{
		padding:0px;
	}
	.pageli{
		padding:8px;
	}
	.list-group-item.active{
		background-color:#f51167;
		border-color:#f51167;
	}
	.ui-datepicker{ z-index: 9999 !important;}

	

	
	
sans-serif;
  font-size: 16px;
  font-weight: 300;
  letter-spacing: 0.01em;
  line-height: 1.6em;
  margin: 0;
  padding: 100px; }

}
button:focus,
input:focus,
textarea:focus,
select:focus {
  outline: none; }

.tabs {
  display: block;
  display: -webkit-flex;
  display: -moz-flex;
  display: flex;
  -webkit-flex-wrap: wrap;
  -moz-flex-wrap: wrap;
  flex-wrap: wrap;
  margin: 0;
  overflow: hidden; }
  .tabs [class^="tab"] label,
  .tabs [class*=" tab"] label {
    cursor: pointer;
    display: block;
    font-size: 1.1em;
    font-weight: 300;
    line-height: 1em;
    padding: 1rem 0;
    text-align: center; }
  .tabs [class^="tab"] [type="radio"],
  .tabs [class*=" tab"] [type="radio"] {
    border-bottom: 1px solid rgba(239, 237, 239, 0.5);
    cursor: pointer;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    display: block;
    width: 100%;
    -webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out; }
    .tabs [class^="tab"] [type="radio"]:hover, .tabs [class^="tab"] [type="radio"]:focus,
    .tabs [class*=" tab"] [type="radio"]:hover,
    .tabs [class*=" tab"] [type="radio"]:focus {
      border-bottom: 1px solid #f51167; }
    .tabs [class^="tab"] [type="radio"]:checked,
    .tabs [class*=" tab"] [type="radio"]:checked {
      border-bottom: 2px solid #f51167; }
    .tabs [class^="tab"] [type="radio"]:checked + div,
    .tabs [class*=" tab"] [type="radio"]:checked + div {
      opacity: 1; }
    .tabs [class^="tab"] [type="radio"] + div,
    .tabs [class*=" tab"] [type="radio"] + div {
      display: block;
      opacity: 0;
      padding: 2rem 0;
      width: 90%;
      -webkit-transition: all 0.3s ease-in-out;
      -moz-transition: all 0.3s ease-in-out;
      -o-transition: all 0.3s ease-in-out;
      transition: all 0.3s ease-in-out; }
  .tabs .tab-2 {
    width: 50%; }
    .tabs .tab-2 [type="radio"] + div {
      width: 200%;
      margin-left: 200%; }
    .tabs .tab-2 [type="radio"]:checked + div {
      margin-left: 0; }
    .tabs .tab-2:last-child [type="radio"] + div {
      margin-left: 100%; }
    .tabs .tab-2:last-child [type="radio"]:checked + div {
      margin-left: -100%; }
	 #statusSelect,#usedstatusSelect{
  		outline:gray;
		height: 25px;
	    width: 130px;
	    display: inline-block;
	    font-size: 11.5px;
	    padding-left: 15px;
	    padding-top: 0px;
	    padding-bottom: 2px;
	}
	#statusSelect:focus,#usedstatusSelect:focus{
		outline: navy;
	}
		#selectboxdiv{
		width:890px;
	}
	
	
</style>

