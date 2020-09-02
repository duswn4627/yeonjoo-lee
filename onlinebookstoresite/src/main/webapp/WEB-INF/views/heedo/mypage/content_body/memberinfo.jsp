<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<div id="content_memberinfo">

	<div>
		<i class="fab fa-first-order-alt"></i><h4 style="display:inline"><span class="colorFont">ȸ��</span>����</h4>
	</div>
	<div>
		<table class="table">
			<tr>
				<td class="tableloc">�̸�</td>
				<td style="width:40%">${mname }</td>
				<td class="tableloc">������</td>
				<td style="width:40%">${regdate }</td>
			</tr>
			<tr>
				<td class="tableloc">���̵�</td><td>${requestScope.mid }</td><td class="tableloc">��й�ȣ</td>
				<td>
					<input type="password" id="mypwd" readonly="readonly">
					<button type="button" class="btn btn-dark changeBtn" data-toggle="modal" data-target="#pwdchangemodal">����</button>
				</td>
			</tr>
			<tr>
				<td class="tableloc">��ȭ��ȣ</td>
				<td>
					<span id="phone"></span>
					<button type="button" class="btn btn-dark changeBtn" data-toggle="modal" data-target="#phonemodal">����</button>
				</td>
				<td class="tableloc">
					�̸���
				</td>
				<td>
					<span id="email"></span>
					<button type="button" class="btn btn-dark changeBtn" data-toggle="modal" data-target="#emailchangemodal">����</button>
				</td>
			</tr>
			<tr>
				<td class="tableloc">
					�ּ�
				</td>
				<td colspan="3">
					<input type="text" id="addr1" class="textbox1" readonly="readonly">
					<button type="button" class="btn btn-dark" id="searchAddrBtn" data-toggle="modal" data-target="#addrmodal">�ּ� ����</button><br>
					<div class="addrLoc">���� �ּ�</div><input type="text" id="addr3" class="road_land_textbox" readonly="readonly"><br>
					<div class="addrLoc">���θ� �ּ�</div><input type="text" id="addr2" class="road_land_textbox" readonly="readonly"><br>
					<input type="text" id="addr4" placeholder="���ּ�" readonly="readonly">
					&nbsp<input type="text" id="addr5" placeholder="�����ּ�" readonly="readonly">
				</td>
			</tr>
		</table>
	</div>
	<div id="btndiv">
		<button type="button" class="btn btn-dark">���������� ��������</button>
	</div>
</div>
<div id="phonemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">ȸ������</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody" id="phonemodal_body">
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>��ȭ��ȣ</strong></span>
        		<input type="text" id="modal_phone" class="loginmodal_input" readonly="readonly"><br>
        	</div>
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>��������ȭ��ȣ</strong></span>
        		<input type="text" id="modalphone1" class="modalphone" value="010">
        		<input type="text" id="modalphone2" class="modalphone">
        		<input type="text" id="modalphone3" class="modalphone">
        	</div>
      </div>
      <div class="modal-footer">
      	  	<button type="button" class="btn btn-dark" id="phoneconfirmBtn">����</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">�ݱ�</button>
      </div>
    </div>

  </div>
</div>

<div id="emailchangemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">ȸ������</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody" id="emailmodal_body">
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>�̸���</strong></span>
        		<input type="text" id="modal_email" class="emailmodal_input" readonly="readonly"><br>
        	</div>
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>�������̸���</strong></span>
        		<input type="email" id="input_email" class="emailmodal_input"><br>
        	</div>
      </div>
      <div class="modal-footer">
      	  	<button type="button" class="btn btn-dark" id="emailchangeBtn">����</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">�ݱ�</button>
      </div>
    </div>

  </div>
</div>

<div id="pwdchangemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">ȸ������</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody" id="pwdmodal_body">
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>��й�ȣ</strong></span>
        		<input type="password" id="modal_pwd" class="pwdmodal_input" readonly="readonly"><br>
        	</div>
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>�����Һ�й�ȣ</strong></span>
        		<input type="password" id="input_pwd" class="pwdmodal_input"><br>
        	</div>
      </div>
      <div class="modal-footer">
      	  	<button type="button" class="btn btn-dark" id="pwdchangeBtn">����</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">�ݱ�</button>
      </div>
    </div>

  </div>
</div>

<div id="addrmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">ȸ������</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody" id="addrmodal_body">
        	�ּҺ����� �Ͻðڽ��ϱ�? 
      </div>
      <div class="modal-footer">
      	  	<button type="button" class="btn btn-dark" id="addrconfirmBtn">Ȯ��</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">���</button>
      </div>
    </div>

  </div>
</div>

<div id="alertchangemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" style="color:white">�˸�</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="alertchangemodal_body">
        	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">�ݱ�</button>
      </div>
    </div>

  </div>
</div>

<div id="successchangemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">ȸ������</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody">
        	<strong>����Ϸ�</strong>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">Ȯ��</button>
      </div>
    </div>

  </div>
</div>

<div id="errchangemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">����</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="errmodal_body">
        	�����߻����� �������
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">�ݱ�</button>
      </div>
    </div>

  </div>
</div>

<div id="addrinputmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">ȸ������</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody" id="addrinputmodal_body">
        	<div class="addrLoc">�����ȣ</div> <input type="text" id="modaladdr1" class="textbox1" readonly="readonly"><br>
				<div class="addrLoc">���� �ּ�</div><input type="text" id="modaladdr3" class="road_land_textbox" readonly="readonly"><br>
				<div class="addrLoc">���θ� �ּ�</div><input type="text" id="modaladdr2" class="road_land_textbox" readonly="readonly"><br>
				<input type="text" id="modaladdr4" placeholder="���ּ�">
				&nbsp<input type="text" id="modaladdr5" placeholder="�����ּ�">
      </div>
      <div class="modal-footer">
      	  	<button type="button" class="btn btn-dark" id="addrinputBtn">Ȯ��</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">���</button>
      </div>
    </div>

  </div>
</div>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(document).ready(function(){
		memberinfo();
	});
	var count = 0; // ����� ���� �� ���� count �ؼ�  z-index���� ������

	$(document).on('show.bs.modal', '.modal', function () {

	    var zIndex = 1040 + (10 * count);

	    $(this).css('z-index', zIndex);

	    setTimeout(function() {

	        $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');

	    }, 0);

	    count = count + 1

	});
	
	$("#addrinputBtn").click(function(){
		var addr1=$("#modaladdr1").val();
		var addr2=$("#modaladdr2").val();
		var addr3=$("#modaladdr3").val();
		var addr4=$("#modaladdr4").val();
		var addr5=$("#modaladdr5").val();
		if(addr1==""||addr2==""||addr3==""||addr4==""||addr5==""){
			$("#alertchangemodal_body").text('�ּ��Է�ĭ�� ��ĭ�� �� �� �����ϴ�. ���� �ۼ����ּ���.');
			$("#alertchangemodal").modal('show')
			return	
		}
		$("#addrinputmodal").modal('hide');
		var addr=addr1+"|"+addr2+"|"+addr3+"|"+addr4+"|"+addr5
		$.ajax({
			url:"${cp}/member/updateaddr",
			data:{addr:addr},
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.result=="success"){
					$("#successchangemodal").modal('show');
					memberinfo();
				}else if(data.result=="fail"){
					$("#errchangemodal").modal('show');
				}
			}
		})
		
	});
	
	
	//�̸��Ϻ���
	$("#emailchangeBtn").click(function(){
		$("#emailchangemodal").modal('hide')
		var changeemail=$("#input_email").val();
		
		if(changeemail==""){
			$("#alertchangemodal_body").text('������ �̸����� �����ּ���.')
			$("#alertchangemodal").modal('show')
			return
		}
		
		$.ajax({
			url:"${cp}/member/updateEmail",
			data:{email:changeemail},
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.result=="success"){
					$("#successchangemodal").modal('show');
					memberinfo();
				}else if(data.result=="fail"){
					$("#errchangemodal").modal('show');
				}
			}
		})
	});
	
	
	//��й�ȣ����
	$("#pwdchangeBtn").click(function(){
		$("#pwdchangemodal").modal('hide')
		var changepwd=$("#input_pwd").val();
		
		if(changepwd==""){
			$("#alertchangemodal_body").text('������ ��й�ȣ�� �����ּ���.')
			$("#alertchangemodal").modal('show')
			return
		}
		
		$.ajax({
			url:"${cp}/member/updatepwd",
			data:{pwd:changepwd},
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.result=="success"){
					$("#successchangemodal").modal('show');
					memberinfo();
				}else if(data.result=="fail"){
					$("#errchangemodal").modal('show');
				}
			}
		})
	});
	
	
	
	
	//��ȭ��ȣ����
	$("#phoneconfirmBtn").click(function(){
		$("#phonemodal").modal('hide')
		var phone1=$("#modalphone1").val();
		var phone2=$("#modalphone2").val();
		var phone3=$("#modalphone3").val();
		
		if(phone1==""||phone3==""||phone2==""){
			$("#alertchangemodal_body").text('������ ��ȭ��ȣ�� �����ּ���.')
			$("#alertchangemodal").modal('show')
			return
		}
		
		var changephone=phone1+"-"+phone2+"-"+phone3;
		
		$.ajax({
			url:"${cp}/member/updatephone",
			data:{phone:changephone},
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.result=="success"){
					$("#successchangemodal").modal('show');
					memberinfo();
				}else if(data.result=="fail"){
					$("#errchangemodal").modal('show');
				}
			}
		})
	});
	
	var memberinfo=function(){
		$.ajax({
			url:"${cp}/member/memberinfo",
			dataType:"json",
			type:"post",
			success:function(data){
				$("#mypwd").val(data.mpwd)
				$("#modal_pwd").val(data.mpwd);
				$("#email").text(data.email);
				$("#modal_email").val(data.email);
				$("#phone").text(data.phone);
				$("#modal_phone").val(data.phone);
				$("#addr1").val(data.addr1);
				$("#addr2").val(data.addr2);
				$("#addr3").val(data.addr3);
				$("#addr4").val(data.addr4);
				$("#addr5").val(data.addr5);
			}
		})
	}
	
	$("#addrconfirmBtn").click(function(){
		$("#addrmodal").modal('hide')
		searchShipAddr();
	});

///////////// �ּ� API ���� ///////////////////////////////////////////////////////
	function searchShipAddr() {
        new daum.Postcode({
            oncomplete: function(data) {
            	console.log('111')
                // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ�.

                // ���θ� �ּ��� ���� ��Ģ�� ���� �ּҸ� ǥ���Ѵ�.
                // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
                var roadAddr = data.roadAddress; // ���θ� �ּ� ����
                var extraRoadAddr = ''; // ���� �׸� ����

                // ���������� ���� ��� �߰��Ѵ�. (�������� ����)
                // �������� ��� ������ ���ڰ� "��/��/��"�� ������.
                if(data.bname !== '' && /[��|��|��]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // �ǹ����� �ְ�, ���������� ��� �߰��Ѵ�.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // ǥ���� �����׸��� ���� ���, ��ȣ���� �߰��� ���� ���ڿ��� �����.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
				var postnum=data.zonecode;
                // �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ִ´�.
                $("#modaladdr1").val(postnum);
                $("#modaladdr2").val(roadAddr);
                $("#modaladdr3").val(data.jibunAddress);
                
                var toproadAddr="("+postnum+")"+" "+roadAddr;
                var topjibunAddr="("+postnum+")"+" "+data.jibunAddress
                // �����׸� ���ڿ��� ���� ��� �ش� �ʵ忡 �ִ´�.
                if(roadAddr !== ''){
                   $("#modaladdr5").val(extraRoadAddr);
                    toproadAddr+=" "+extraRoadAddr+" ";
                    topjibunAddr+=" "+extraRoadAddr+" ";
                } else {
                    
                }
                //var guideTextBox = document.getElementById("guide");
                // ����ڰ� '���� ����'�� Ŭ���� ���, ���� �ּҶ�� ǥ�ø� ���ش�.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    //guideTextBox.innerHTML = '(���� ���θ� �ּ� : ' + expRoadAddr + ')';
                   // guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                   // guideTextBox.innerHTML = '(���� ���� �ּ� : ' + expJibunAddr + ')';
                  //  guideTextBox.style.display = 'block';
                } else {
                    //guideTextBox.innerHTML = '';
                   // guideTextBox.style.display = 'none';
                }
                $("#addrinputmodal").modal('show');
                $("#alertchangemodal_body").text("�ּ� ����Ϸ�.")
                
            }
        }).open();
    }
	///////////// �ּ� API �� ///////////////////////////////////////////////////////
	
	
	
</script>

<style>
	.colorFont{
		color:#e83e8c;
	}
    
	#content_memberinfo{
		padding:10px;
		height:740px;
		width:920px;
		border:1px solid #dee2e6;
	}
	.addrLoc{
		font-size:13px;
		width:87px;
		height:20px;
		display:inline-block;
	}
	#addr4, #addr5,#modaladdr4, #modaladdr5{
		font-size:13px;
		height:20px;
	}
	.textbox1{
		font-size:13px;
		height:20px;
		width:100px;
	}
	.road_land_textbox{
		font-size:13px;
		height:20px;
		width:248.5px;
	}
	#mypwd{
		border:none;
	}
	#searchAddrBtn{
		padding:1.5px 1.5px;
		font-size:13px;
		width:80px;
		height:20px;
	}
	.tableloc{
		background-color: #e6f7ff;
		text-align: center;
		font-weight: bold;
		width:10%;
	}
	.changeBtn{
		padding:1.5px 1.5px;
		font-size:13px;
		width:50px;
		height:30px;
	}
	#btndiv{
		text-align: center;
	}
	.modalbody{
		text-align: center;
	}
	.modalphone{
		width: 64px;
	}
</style>