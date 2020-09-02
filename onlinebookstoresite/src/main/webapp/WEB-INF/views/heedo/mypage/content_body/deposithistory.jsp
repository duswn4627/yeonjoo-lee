<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<div id="content_history">	
		<i class="fab fa-first-order-alt"></i><h4 style="display:inline"><span id="colorfont">예치금</span>내역</h4>
		<div class="date_picker shadow">
			<ul class="list-group list-group-horizontal" id="dateUl">
				<li class="list-group-item selectdate depositselect" onclick="changeDate(7,0)">최근 일주일</li>
				<li class="list-group-item active selectdate depositselect" onclick="changeDate(0,1)">1개월</li>
				<li class="list-group-item selectdate depositselect" onclick="changeDate(0,3)">3개월</li>
				<li class="list-group-item selectdate depositselect" onclick="changeDate(0,6)">6개월</li>
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
				
					<select class="form-control" id="depositSelect">
						<option value="all" selected="selected">전체</option>
						<option value="sellmoney">판매대금</option>
						<option value="ordercancel">주문취소</option>
						<option value="return">반품/환불처리</option>
						<option value="withdraw">인출완료</option>
						<option value="apply">인출신청</option>
					</select>
				</div>
			<table class="table" id="depositTable">
				<thead class="table-dark">
					<th style="width:25%;">처리번호</th>
					<th style="width:25%;">거래금액</th>
					<th style="width:25%;">거래날짜</th>
					<th style="width:25%;">사유</th>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
		<div class="pagingDiv" id="depositPaging">
							
		</div>
		<div id="btnDiv">
			<button type="button" class="btn btn-dark" id="withdrawApply">인출신청</button>
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
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title">알림</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body">
        	인출신청완료!!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="falsemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">알림</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body">
        	인출할 수 있는 예치금 잔액이 없습니다.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="errmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">에러</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="errmodal_body">
        	로그인에러 발생!!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="errmodal1" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">에러</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="errmodal1_body">
        	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="accounterrmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">에러</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="errmodal_body" >
        	계좌번호가 존재하지 않습니다.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark"  id="acmodalbtn">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="errmodal2" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">에러</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="errmodal_body">
        	에러발생!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>
<div id="errmodal3" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">에러</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="errmodal_body">
        	신청하신 금액이 가능한 금액보다 많습니다!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>
<div id="errmodal4" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">에러</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="errmodal_body">
        	신청액은 숫자만 입력가능합니다!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>
<div id="successmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" style="color:white">알림</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="errmodal_body">
        	계좌등록성공!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="successmodal1" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" style="color:white">알림</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="errmodal_body">
        	인출신청 완료!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="insertAccount" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ccccff">
       <h4 class="modal-title" style="color:white">계좌번호 입력</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body">
        	은행<br>
        	<select id="bankSelect">
        		<option value="우리은행">우리은행</option>
        		<option value="케이뱅크">케이뱅크</option>
        		<option value="기업은행">기업은행</option>
        		<option value="신한은행">신한은행</option>
        		<option value="국민은행">국민은행</option>
        		<option value="국민은행">국민은행</option>
        		<option value="하나은행">하나은행</option>
        		<option value="농협은행">농협은행</option>
        		<option value="대구은행">대구은행</option>
        		<option value="씨티은행">씨티은행</option>		
        		<option value="카카오뱅크">카카오뱅크</option>		
        	</select><br>
        	계좌번호<br>
        	<input type="number" id="banknum" placeholder="(-제외)계좌번호를 입력해주세요">
      </div>
      <div class="modal-footer">
       	<button type="button" class="btn btn-light" id="accountConfirmBtn">등록</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="applymodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" style="color:white">출금신청</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body">
      	은행<br><input type="text" id="bankConfirm" readonly="readonly"><br>
      	계좌번호<br><input type="text" id="banknumConfrim" readonly="readonly"><br>
      	출금신청가능액<br>
      	<input type="text" id="can_deposit" readonly="readonly"><br>
      	신청액<br>
      	<input type="number" id="apply_deposit"><br>
      </div>
      <div class="modal-footer">
       	<button type="button" class="btn btn-dark" id="applydepositBtn">신청</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>


<script>
	$(document).ready(function(){
		defaultDate();
		var startDay=$("#date1").val();
		var endDay=$("#date2").val();
		var value=$("#depositSelect").val();
		viewDepositlist(startDay,endDay,1,value);	
	});
	 $('#successmodal1').on('hidden.bs.modal', function (e) {
		var startDay=$("#date1").val();
		var endDay=$("#date2").val();
		var value=$("#depositSelect").val();
		viewDepositlist(startDay,endDay,1,value);
	});
	$("#withdrawApply").click(function(){
		var total_deposit=$(this).data('total_deposit');
		if(total_deposit<=0){
			$("#falsemodal").modal('show')
			return;
		}
		$.ajax({
			url:"${cp}/mypage/confirmaccount",
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.result=="loginerr"){
					$("#errmodal").modal('show');
					return
				}else if(data.result=="accounterr"){
					$("#accounterrmodal").modal('show');
					return;
				}else if(data.result=="confirm"){
					$("#bankConfirm").val(data.bank);
					$("#banknumConfrim").val(data.banknum);
					var deposit=$("#withdrawApply").data('total_deposit')
					$("#can_deposit").val(deposit);
					$("#apply_deposit").prop('max',deposit);
					$("#applymodal").modal('show');
				}else{
					$("#errmodal2").modal('show');
				}
				
			}
		})
	});
	
	$("#acmodalbtn").click(function(){
		$("#accounterrmodal").modal('hide');
		$("#insertAccount").modal('show');
	})
	$("#accountConfirmBtn").click(function(){
		$("#insertAccount").modal('hide');
		var banknum=$("#banknum").val();
		var bank=$("#bankSelect").val();
		if(banknum==""||banknum==null){
			$("#erromodal1_body").text('계좌번호를 입력해주세요.')
			$("#errmodal1").modal('show');
			return;
		}
		if(!$.isNumeric(banknum)){
			$("#erromodal1_body").text('계좌번호는 숫자만 입력가능합니다..')
			$("#errmodal1").modal('show');
			return;
		}
		$.ajax({
			url:"${cp}/mypage/insertAccount",
			type:"post",
			dataType:"json",
			data:{bank:bank,banknum:banknum},
			success:function(data){
				if(data.result){
					$("#successmodal").modal('show');
				}else{
					$("#errmodal2").modal('show');
				}
			}
		})
	});
	$("#applydepositBtn").click(function(){
		$("#applymodal").modal('hide');
		var can_deposit=$("#can_deposit").val()
		var apply_deposit=$("#apply_deposit").val();
		if(!$.isNumeric(apply_deposit)){
			$("#errmodal4").modal('show');
			return
		}
		if(Number(apply_deposit)>=Number(can_deposit)){
			$("#errmodal3").modal('show');
			return;
		}
		$.ajax({
			url:"${cp}/mypage/applydeposit",
			dataType: "json",
			data:{deposit:apply_deposit},
			type:"post",
			success:function(data){
				if(data.result){
					$("#successmodal1").modal('show')
				}else{
					$("#errmodal2").modal('show')
				}
				
			}
		})
	});
	
	var viewDepositlist=function(startDay,endDay,pageNum,value){
		clearDepositlist();
		if(pageNum==null){
			pageNum=1;
		}
		var paginationapp="<ul class='pagination pageul'>"
			+"<li class='page-item disabled'><a class='page-link' href='#'><<</a></li>"
			+"<li class='page-item disabled'><a class='page-link' href='#'>1</a></li>"
			+"<li class='page-item disabled'><a class='page-link' href='#'>>></a></li>"
			$("#depositPaging").append(paginationapp);
			$("#withdrawApply").data('total_deposit',0);
		$.ajax({
			url:'${cp}/mypage/deposithistory',
			dataType:'json',
			type:'post',
			data:{startDay:startDay,endDay:endDay,pageNum:pageNum,value:value},
			success:function(data){
				if(data.length==1){ //값이없을때..
					var tableapp="<tr><td colspan='4'>예치금내역이 없습니다.</td></tr>";
					$("#depositTable > tbody").append(tableapp);
					return;
				}
				
				$(data).each(function(index,item){
					if(index==data.length-1){
						$("#withdrawApply").data('total_deposit',item.total_deposit);
						var yy=item.startDay;
						var mm=item.endDay;
						$("#depositPaging").empty();
						var paginationapp="<ul class='pagination pageul'>";
						if(item.startPageNum>=6){
							paginationapp+="<li class='page-item '>"
									+"<a class='page-link pageli' href='javascript:viewDepositlist(\""+yy+"\",\""+mm+"\","+(item.startpageNum-1)+",\""+item.value+"\")'><<"
									+"</a></li>";
						}else{
							paginationapp+="<li class='page-item disabled'><a class='page-link pageli' href='#'><<</a></li>";
						}
										
						for(let i=item.startPageNum;i<=item.endPageNum;i++){
							var yy=item.startDay;
							var mm=item.endDay;
							if(i==item.pageNum){
								paginationapp+="<li class='page-item disabled' ><a class='page-link pageli'"
									+"href='javascript:viewDepositlist(\""+yy+"\",\""+mm+"\","+i+",\""+item.value+"\")'>"+i+"</a></li>"
							}else{
								paginationapp+="<li class='page-item'><a class='page-link pageli'"
									+"href='javascript:viewDepositlist(\""+yy+"\",\""+mm+"\","+i+",\""+item.value+"\")'>"+i+"</a></li>"
							}
							
							
						}
						if(item.endPageNum<item.totalPageCount){
							paginationapp+="<li class='page-item'>"
								+"<a class='page-link pageli' href='javascript:viewDepositlist(\""+yy+"\",\""+mm+"\","+(item.endPageNum+1)+",\""+item.value+"\")'>>></a></li>";
						}else{
							paginationapp+="<li class='page-item disabled'>"
									+"<a class='page-link pageli' href='#'>>></a></li>";
						}
						
						$("#depositPaging").append(paginationapp);
						
						return;
						
					}
					var tableapp="<tr>"
							    +"<td>"+item.dnum+"</td>"
							    +"<td>"+item.dtran+"</td>"
							    +"<td>"+item.trandate+"</td>"
							    +"<td>"+item.status+"</td>"
							  +"</tr>"; 
					$("#depositTable > tbody").append(tableapp);
				})
				
				
			}
			
		})
		
	}
	var clearDepositlist=function(){
		$("#depositTable > tbody").empty();
		$("#depositPaging").empty();
	}
	
	
	//ul 선택 이펙트
	$(".depositselect").click(function(){
		$(".depositselect").each(function(){
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
		var value=$("#depositSelect").val()
		clearDepositlist();
		viewDepositlist(startDay,endDay,1,value);
	});
	$("#depositSelect").change(function(){
		var value=$(this).val();
		clearDepositlist();
		var startDay=$("#date1").val();
		var endDay=$("#date2").val();
		viewDepositlist(startDay,endDay,1,value);
	});
	$("#researchBtn").on('click',function(){
		var startDay=$("#date1").val();
		var endDay=$("#date2").val();
		var value=$("#depositSelect").val()
		clearDepositlist();
		viewDepositlist(startDay,endDay,1,value);
	});
</script>
<style>
	#colorfont{
		color:#f51167;
	}
	#bankSelect{
		font-size:12px;
		width:100px;
		height:30px;
	}
	#banknum{
		width:250px;
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
		height: 455px;
		padding:5px;
	}
	#btnDiv{
		text-align: right;
	}
	#depositPaging{
		text-align: center;
		position:absolute;
		top:620px;
		left:370px;
	}
	.pageli{
		width:34px;
	}
	.list-group-item.active{
		background-color:#f51167;
		border-color:#f51167;
	}
	#depositSelect{
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