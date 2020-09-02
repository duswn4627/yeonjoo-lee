<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">

<div id="content_memberleave">
	<div>
		<i class="fab fa-first-order-alt"></i><h4 style="display:inline"><span class="colorFont">ȸ��</span> Ż��</h4>
	</div>
	<div>
		<div id="content_div">
			<div id="attention_div">
			<ul>
				<li>�ֹ��� / �����Ϸ� ������ �ֹ������� ���� ��� Ż�� ���ѵ˴ϴ�.</li>
				<li>�����û���� ��ġ�� / ��ġ�� �ܾ��� ���� ��� Ż�� ���ѵ˴ϴ�.</li>
				<li>���� �Ǹ����� �߰��ǰ�� ���� ��� Ż�� ���ѵ˴ϴ�.</li>
				<li>Ż�� �� ����/ȯ�ҵ� GoBook ����Ʈ�̿��� ���ѵ� �� ������ <strong>��� å���� Ż�� ȸ��</strong>���� �ֽ��ϴ� </li>
			</ul>
			</div>
		</div>
		<div id="attention_check_div">
			<input type="checkbox" id="attention_check"><label for="attention_check">�� ������ �����մϴ�.</label>
		</div>
		<div id="leave_btn_div">
			<button type="button" class="btn btn-danger" disabled="disabled" id="leaveBtn">Ż��</button>
		</div>
	</div>
</div>
<div id="leaveErrModal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">���</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="leaveErr_body">
        	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">�ݱ�</button>
      </div>
    </div>

  </div>
</div>
<div id="confirmmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title confirmmodal_h4">�˶�</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="confirmmodal_body">
        	������ Ż���Ͻðڽ��ϱ�?
      </div>
      <div class="modal-footer">
      	  <button type="button" class="btn btn-dark" id="leaveconfirmBtn">Ȯ��</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">���</button>
      </div>
    </div>

  </div>
</div>

<div id="confirmmodal1" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title confirmmodal_h4">�˶�</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="confirmmodal1_body">
        	Ż��ó���� �Ϸ�Ǿ����ϴ�!
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">Ȯ��</button>
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
					$("#leaveErr_body").text('�ֹ�/���� ������ �ֹ������� �����մϴ�. �ֹ������� Ȯ�����ּ���.')
					$("#leaveErrModal").modal('show');
					return
				}else if(result=="depositapplyfail"){
					$("#leaveErr_body").text('�����û���� ��ġ���� �����մϴ�.')
					$("#leaveErrModal").modal('show');
					return
				}else if(result=="depositfail"){
					$("#leaveErr_body").text('���� ����������� ��ġ���� �����ֽ��ϴ�.')
					$("#leaveErrModal").modal('show');
					return
				}else if(result=="obfail"){
					$("#leaveErr_body").text('�Ǹ����� �߰��ǰ�� �ֽ��ϴ�.')
					$("#leaveErrModal").modal('show');
					return
				}else if(result=="success"){
					$("#confirmmodal").modal('show');
					return;
				}else{
					$("#leaveErr_body").text('�����߻�!')
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
					$("#leaveErr_body").text('�����߻����� Ż��ó���� �����Ǿ����ϴ�. ��� �� �ٽ� �õ����ּ���.')
					$("#leaveErrModal").modal('show');
					return
				}else if(result=="success"){
					$("#confirmmodal1").modal('show');
					return
				}else{
					$("#leaveErr_body").text('�����߻�!!')
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