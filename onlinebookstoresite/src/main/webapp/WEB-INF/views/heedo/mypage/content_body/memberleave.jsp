<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">

<div id="content_memberleave">
	<div>
		<i class="fab fa-first-order-alt"></i><h4 style="display:inline"><span class="colorFont">회원</span> 탈퇴</h4>
	</div>
	<div>
		<div id="content_div">
			<div id="attention_div">
			<ul>
				<li>주문중 / 결제완료 상태인 주문내역이 있을 경우 탈퇴가 제한됩니다.</li>
				<li>인출신청중인 예치금 / 예치금 잔액이 있을 경우 탈퇴가 제한됩니다.</li>
				<li>현재 판매중인 중고상품이 있을 경우 탈퇴가 제한됩니다.</li>
				<li>탈퇴 후 문의/환불등 GoBook 사이트이용이 제한될 수 있으며 <strong>모든 책임은 탈퇴 회원</strong>에게 있습니다 </li>
			</ul>
			</div>
		</div>
		<div id="attention_check_div">
			<input type="checkbox" id="attention_check"><label for="attention_check">위 사항을 동의합니다.</label>
		</div>
		<div id="leave_btn_div">
			<button type="button" class="btn btn-danger" disabled="disabled" id="leaveBtn">탈퇴</button>
		</div>
	</div>
</div>
<div id="leaveErrModal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">경고</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="leaveErr_body">
        	
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
       <h4 class="modal-title confirmmodal_h4">알람</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="confirmmodal_body">
        	정말로 탈퇴하시겠습니까?
      </div>
      <div class="modal-footer">
      	  <button type="button" class="btn btn-dark" id="leaveconfirmBtn">확인</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">취소</button>
      </div>
    </div>

  </div>
</div>

<div id="confirmmodal1" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title confirmmodal_h4">알람</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="confirmmodal1_body">
        	탈퇴처리가 완료되었습니다!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">확인</button>
      </div>
    </div>

  </div>
</div>
<script>

	$("#confirmmodal1").on('hidden.bs.modal', function () {
		window.location.href="${cp }/logout";
	})
	
	$("#attention_check").click(function(){
		if($(this).is(":checked")){
			$("#leaveBtn").attr('disabled',false);
		}else{
			$("#leaveBtn").attr('disabled',true);
		}
	});
	
	$("#leaveBtn").click(function(){
		$.ajax({
			url:"/finalproject/member/leavecheck",
			dataType:"json",
			type:"post",
			success:function(data){
				var result=data.result;
				if(result=="orderfail"){
					$("#leaveErr_body").text('주문/결제 상태의 주문내역이 존재합니다. 주문내역을 확인해주세요.')
					$("#leaveErrModal").modal('show');
					return
				}else if(result=="depositapplyfail"){
					$("#leaveErr_body").text('인출신청중인 예치금이 존재합니다.')
					$("#leaveErrModal").modal('show');
					return
				}else if(result=="depositfail"){
					$("#leaveErr_body").text('아직 인출되지않은 예치금이 남아있습니다.')
					$("#leaveErrModal").modal('show');
					return
				}else if(result=="obfail"){
					$("#leaveErr_body").text('판매중인 중고상품이 있습니다.')
					$("#leaveErrModal").modal('show');
					return
				}else if(result=="success"){
					$("#confirmmodal").modal('show');
					return;
				}else{
					$("#leaveErr_body").text('에러발생!')
					$("#leaveErrModal").modal('show');
					return
				}
				
			}
		})
	})
	$("#leaveconfirmBtn").click(function(){
		$("#confirmmodal").modal('hide');
		$.ajax({
			url:"/finalproject/member/leavemember",
			dataType:"json",
			type:"post",
			success:function(data){
				var result=data.result;
				if(result=="fail"){
					$("#leaveErr_body").text('에러발생으로 탈퇴처리가 중지되었습니다. 잠시 뒤 다시 시도해주세요.')
					$("#leaveErrModal").modal('show');
					return
				}else if(result=="success"){
					$("#confirmmodal1").modal('show');
					return
				}else{
					$("#leaveErr_body").text('에러발생!!')
					$("#leaveErrModal").modal('show');
					return
				}
			}
		})
	});
</script>

<style>
	.colorFont{
		color:#e83e8c;
	}
	#content_memberleave{
		padding:10px;
		height:740px;
		width:920px;
		border:1px solid #dee2e6;
	}
	#content_div{
		background-color:#f5c6cb;
		border-radius:4px;
		border:2px solid #ed969e;
	}
	#attention_div{
		margin: 30px 0px;
   		padding-left: 20px;
   		font-size: 18px;
   		color: #721c24;
	}
	#attention_check_div{
		margin-top:10px;
		text-align: right;
		color:#b3b3b3;
		font-size:13px;
	}
	#leave_btn_div{
		text-align: center;
	}
	 .confirmmodal_h4{
		color:white;    
    }
</style>