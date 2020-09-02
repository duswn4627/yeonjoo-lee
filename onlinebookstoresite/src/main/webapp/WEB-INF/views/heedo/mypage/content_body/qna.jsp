<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<div id="content_history">	
		<i class="fab fa-first-order-alt"></i><h4 style="display:inline"><span id="colorfont">문의</span>내역</h4>
		<div class="date_picker shadow">
			<ul class="list-group list-group-horizontal" id="dateUl">
				<li class="list-group-item selectdate qnaselect" onclick="changeDate(7,0)">최근 일주일</li>
				<li class="list-group-item active selectdate qnaselect" onclick="changeDate(0,1)">1개월</li>
				<li class="list-group-item selectdate qnaselect" onclick="changeDate(0,3)">3개월</li>
				<li class="list-group-item selectdate qnaselect" onclick="changeDate(0,6)">6개월</li>
			</ul>
			<input type="text" id="date1" class="form-control" readonly="readonly">
			<i class="far fa-calendar-alt fa-2x calenderIcon" id="startday"></i>
			&nbsp&nbsp<span>~</span>&nbsp&nbsp
			<input type="text" id="date2" class="form-control" readonly="readonly">
			<i class="far fa-calendar-alt fa-2x calenderIcon" id="endday"></i>
			<button type="button" class='btn btn-dark' id="researchBtn">조회</button>
		</div>
		<div class="tableDiv shadow" id="tablediv">
			<div style="text-align: right" id="usedselectboxdiv">
				
					<select class="form-control" id="qnaSelect">
						<option value="all" selected="selected">전체</option>
						<option value="process">처리중</option>
						<option value="complete">완료</option>
					</select>
				</div>
			<table class="table" id="qnaTable">
				<thead class="table-dark">
					<th style="width:15%">문의번호</th>
					<th style="width:60%;text-align: center">제목</th>
					<th style="width:15%">작성일</th>
					<th style="width:10">답변상태</th>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
		<div class="pagingDiv" id="qnaPaging">
							
		</div>
		<div id="btnDiv">
			<button type="button" class="btn btn-dark" id="writeQna" 
					data-toggle="modal" data-target="#writemodal">문의하기</button>
		</div>
</div>

<!-- ==== 모달창 ======== -->
<div id="writemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529 ">
       <h4 class="modal-title" style="color:white">문의사항 작성</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body">
        	제목<br>
        	<input type="text" id="qnatitle" placeholder="제목을 작성하세요."><br>
        	문의내용
        	<textarea rows="5" cols="50" id="qnacontent"></textarea>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-dark" id="modal_confirmBtn" data-dismiss="modal" >문의하기</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="alertmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">경고</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body">
        	제목,내용을 전부 작성해주셔야합니다.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="confirmmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #b3ffb3">
       <h4 class="modal-title">알림</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body">
        	문의사항 작성완료!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="falsemmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">알림</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body">
        	문의사항 작성실패
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>



<script>
	$(document).ready(function(){
		defaultDate();
		var startDay=$("#date1").val();
		var endDay=$("#date2").val();
		var value=$("#qnaSelect").val();
		viewQnalist(startDay,endDay,1,value);	
	});
	$("#modal_confirmBtn").click(function(){
		var qnatitle=$("#qnatitle").val();
		var qnacontent=$("#qnacontent").val();
		if(qnatitle=="" || qnacontent==""){
			$("#alertmodal").modal('show')
			return;
		}
		$.ajax({
			url:"/finalproject/mypage/writeqna",
			type:"post",
			data:{qnatitle:qnatitle,qnacontent:qnacontent},
			success:function(data){
				if(data.result){
					var startDay=$("#date1").val();
					var endDay=$("#date2").val();
					var value=$("#qnaSelect").val();
					viewQnalist(startDay,endDay,1,value);
					$("#confirmmodal").modal('show')
					
				}else{
					$("#falsemodal").modal('show')
				}
			}
		})
	
	});
	
	var viewQnalist=function(startDay,endDay,pageNum,value){
		clearQnalist();
		if(pageNum==null){
			pageNum=1;
		}
		var paginationapp="<ul class='pagination pageul'>"
			+"<li class='page-item disabled'><a class='page-link' href='#'><<</a></li>"
			+"<li class='page-item disabled'><a class='page-link' href='#'>1</a></li>"
			+"<li class='page-item disabled'><a class='page-link' href='#'>>></a></li>"
			$("#qnaPaging").append(paginationapp);
		$.ajax({
			url:'/finalproject/mypage/qnahistory',
			dataType:'json',
			type:'post',
			data:{startDay:startDay,endDay:endDay,pageNum:pageNum,value:value},
			success:function(data){
				if(data.length==1){ //값이없을때..
					var tableapp="<tr><td colspan='4'>문의내역이 없습니다.</td></tr>";
					$("#qnaTable > tbody").append(tableapp);
					
					return;
				}
				
				$(data).each(function(index,item){
					if(index==data.length-1){
						var yy=item.startDay;
						var mm=item.endDay;
						$("#qnaPaging").empty();
						var paginationapp="<ul class='pagination pageul'>";
						if(item.startPageNum>=6){
							paginationapp+="<li class='page-item '>"
									+"<a class='page-link pageli' href='javascript:viewQnalist(\""+yy+"\",\""+mm+"\","+(item.startpageNum-1)+"."+item.value+")'><<"
									+"</a></li>";
						}else{
							paginationapp+="<li class='page-item disabled'><a class='page-link pageli' href='#'><<</a></li>";
						}
										
						for(let i=item.startPageNum;i<=item.endPageNum;i++){
							var yy=item.startDay;
							var mm=item.endDay;
							if(i==item.pageNum){
								paginationapp+="<li class='page-item disabled' ><a class='page-link pageli'"
									+"href='javascript:viewQnalist(\""+yy+"\",\""+mm+"\","+i+"."+item.value+")'>"+i+"</a></li>"
							}else{
								paginationapp+="<li class='page-item'><a class='page-link pageli'"
									+"href='javascript:viewQnalist(\""+yy+"\",\""+mm+"\","+i+"."+item.value+")'>"+i+"</a></li>"
							}
							
							
						}
						if(item.endPageNum<item.totalPageCount){
							paginationapp+="<li class='page-item'>"
								+"<a class='page-link pageli' href='javascript:viewQnalist(\""+yy+"\",\""+mm+"\","+(item.endPageNum+1)+"."+item.value+")'>>></a></li>";
						}else{
							paginationapp+="<li class='page-item disabled'>"
									+"<a class='page-link pageli' href='#'>>></a></li>";
						}
						
						$("#qnaPaging").append(paginationapp);
						return;
						
					}
					var tableapp="<tr>"
							    +"<td>"+item.qnanum+"</td>"
							    +"<td><a class='movedetail' href='${cp}/mypage/qnadetail?qnanum="+item.qnanum+"'>"+item.qnatitle+"</a></td>"
							    +"<td>"+item.qnadate+"</td>"
							    +"<td>"+item.status+"</td>"
							  +"</tr>"; 
					$("#qnaTable > tbody").append(tableapp);
				})
				
				
			}
			
		})
		
	}
	var clearQnalist=function(){
		$("#qnaTable > tbody").empty();
		$("#qnaPaging").empty();
	}
	
	
	//ul 선택 이펙트
	$(".qnaselect").click(function(){
		$(".qnaselect").each(function(){
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
		var value=$("#qnaSelect").val()
		clearQnalist();
		viewQnalist(startDay,endDay,1,value);
	});
	$("#qnaSelect").change(function(){
		var value=$(this).val();
		clearQnalist();
		var startDay=$("#date1").val();
		var endDay=$("#date2").val();
		viewQnalist(startDay,endDay,1,value);
	});
	$("#researchBtn").on('click',function(){
		var startDay=$("#date1").val();
		var endDay=$("#date2").val();
		var value=$("#qnaSelect").val()
		clearQnalist();
		viewQnalist(startDay,endDay,1,value);
	});
</script>
<style>
	#colorfont{
		color:#f51167;
	}
	#qnatitle{
		width:473px;
	}
	#content_history{
	position: absolute;
    display: inline-block;
   border-top:1px solid #dee2e6;
    width: 927px;
    height: 670px;
    padding:10px
	}
	.calenderIcon{
		position:relative;
		top:8px;
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
	#dateUl{
		list-style-type: none;
	}
	.selectdate{
		text-align:center;
		font-size:12px;
		width:100px;
		height:35px;
		padding:0px;
		padding-top:7px;
	}
	#date1,#date2{
		width:110px;
		font-size:12px;
		display:inline-block;
	}
	.movedetail:link{
		color:black;text-decoration: none;
	}
	.movedetail:visited{color:black;text-decoration:none;}
	.movedetail:hover{color:#f51167;}
	#tablediv{
	 border-radius: 8px;
		margin-top: 20px;
		font-size:14px;
		border:2px solid grey;
		width:907px;
		height:435px;
		padding:5px;
	}
	#btnDiv{
		text-align: right;
	}
	#qnaPaging{
		text-align: center;
		position:absolute;
		top: 650px;
    	left: 400px;
	}
	.pageli{
		width:34px;
	}
	.list-group-item.active{
		background-color:#f51167;
		border-color:#f51167;
	}
	#qnaSelect{
  		outline:gray;
		height: 25px;
	    width: 130px;
	    display: inline-block;
	    font-size: 11.5px;
	    padding-left: 15px;
	    padding-top: 0px;
	    padding-bottom: 2px;
	}
</style>