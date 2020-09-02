<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="infomation" style="background-image: url('${cp}/resources/jh/jhimages/마이페이지내정보상단.png')">
	<span style="position: absolute;font-size: 17px;margin-left: 55px;margin-top: 7px;max-width: 100px;">
		<span style="color: #f51167;"><%=session.getAttribute("mid") %></span>님 <br>환영합니다.
	</span>
	<span style="position: absolute;font-size: 17px;margin-left: 10px;margin-top: 70px;">
		내 포인트 : <%=session.getAttribute("point") %>원
	</span>
	<span style="position: absolute;font-size: 17px;margin-left: 10px;margin-top: 105px;">
		내 등급 : <%=session.getAttribute("grade") %>
	</span>
</div>

<table class="table table-striped" id="menubar">
	<tr>
		<th scope="col">주문내역</th>
	</tr>
	<tr>
		<td>
			<a class="menuAtag" href="${cp }/mypage/orderhistory">- 주문내역</a><br>
			<a class="menuAtag" href="${cp }/mypage/returnpage">- 반품/교환 신청,완료 내역</a><br>
			<a class="menuAtag" href="${cp }/mypage/cancelhistorypage">- 취소 주문내역</a><br>
		</td>
	</tr>
	<tr>
		<th>나의정보</th>
	</tr>
	<tr>
		<td>
			<a class="menuAtag" href="javascript:memberpage('info')">- 회원정보</a><br>
			<a class="menuAtag" href="javascript:memberpage('leave')">- 회원탈퇴</a>
		</td>
	</tr>
	<tr>
		<th>나의계좌</th>
	</tr>
	<tr>
		<td>
			<a class="menuAtag" href="${cp }/members/pointList">- 포인트내역</a><br>
			<a class="menuAtag" href="${cp }/mypage/depositpage">- 예치금내역/신청</a><br>
			<a class="menuAtag" href="javascript:accountpage()">- 계좌내역</a>
		</td>
	</tr>
	<tr>
		<th>중고관리</th>
	</tr>
	<tr>
		<td><a class="menuAtag" href="${cp }/seller">-중고판매자매니저</a></td>
	</tr>
	<tr>
		<th>고객센터</th>
	</tr>
	<tr>
		<td><a class="menuAtag" href="${cp }/mypage/qnapage">-문의내역/문의하기</a>
		</td>
	</tr>
</table>
<div id="err_modal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">에러</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="err_modal_body">
        	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>
<div id="alertmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ccccff">
       <h4 class="modal-title">알림</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="alertmodal_body">
        	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="alertmodal1" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ccccff">
       <h4 class="modal-title">알림</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="alertmodal_body1">
        	
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
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" style="color:white">계좌번호 입력</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body">
        	은행<br>
        	<select id="bankSelect" class="modal_input">
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
        	<input type="number" id="banknum" placeholder="(-제외)계좌번호를 입력해주세요" class="modal_input">
      </div>
      <div class="modal-footer">
       	<button type="button" class="btn btn-light" id="accountConfirmBtn">등록</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="loginmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">본인확인</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="loginmodal_body">
        	<img src="${cp }/resources/hd/img/logo2.jpg" id="loginmodal_img"><br>
        	<div class="loginmodal_div">
        		<span class="modalloc"><strong>아이디</strong></span>
        		<input type="text" id="modalid" class="loginmodal_input" readonly="readonly" value="${mid }"><br>
        	</div>
        	<div class="loginmodal_div">
        		<span class="modalloc"><strong>비밀번호</strong></span>
        		<input type="password" id="modalpwd" class="loginmodal_input">
        	</div>
      </div>
      <div class="modal-footer">
      	  	<button type="button" class="btn btn-dark" id="loginconfirmBtn">확인</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>
<script>
	var memberpage=function(value){
		$("#loginmodal_body").data('value',value);
		$("#loginmodal").modal('show');
	}
	$("#loginconfirmBtn").click(function(){
		$("#loginmodal").modal('hide');
		var id=$("#modalid").val();
		var pwd=$("#modalpwd").val();
		var value=$("#loginmodal_body").data('value');
		if(pwd==''){
			$("#err_modal_body").text("비밀번호를 입력해주세요.");
			$("#err_modal").modal('show')
			return;
		}
		$.ajax({
			url:"/finalproject/loginCheck",
			dataType: "json",
			data:{id:id,pwd:pwd},
			type:"post",
			success:function(data){
				if(data.result=="fail"){
					$("#err_modal_body").text('비밀번호를 확인해주세요.')
					$("#err_modal").modal('show');
					return;
				}
				if(value=="info"){
					window.location.href="${cp}/member/memberinfopage";
				}else{
					window.location.href="${cp}/member/memberleavepage";
				}
				
				
				
			}
		});
		
		
	});


	// 계좌내역 이동함수.
	var accountpage=function(){
		$.ajax({
			url:"/finalproject/mypage/confirmaccount",
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.result=="loginerr"){
					$("#err_modal_body").text('로그인 에러 발생!');
					$("#err_modal").modal('show');
					return
				}else if(data.result=="accounterr"){ //계좌없을떄 
					$("#alertmodal_body").text('등록된 계좌가 존재하지 않습니다. 계좌를 등록해주세요.')
					$("#alertmodal").modal('show');
					return;
				}else if(data.result=="confirm"){ //계좌있을때 
					window.location.href="${cp}/mypage/accountpage"
				}else{
					$("#err_modal_body").text('에러 발생!');
					$("#err_modal").modal('show');

				}
			}
		})
		
	}
	//계좌없을때 알람창 종료시. 계좌등록모달 띄움
	 $('#alertmodal').on('hidden.bs.modal', function (e) {
			$("#insertAccount").modal('show');
		});
	
	//계좌등록모달 등록버튼클릭시 
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
			url:"/finalproject/mypage/insertAccount",
			type:"post",
			dataType:"json",
			data:{bank:bank,banknum:banknum},
			success:function(data){
				if(data.result){
					$("#alertmodal_body1").text('계좌등록완료!')
					$("#alertmodal1").modal('show');
				}else{
					$("#err_modal_body1").text('에러 발생!');
					$("#err_modal1").modal('show');
				}
			}
		})
	});

	
	
</script>
<style>
	.modal_input{
		border-radius: 4px; 
    	width:300px;
    }
    #loginmodal_h4{
		color:white;    
    }
    #loginmodal_img{
		width:300px    
    }
    #loginmodal{
    	text-align: center;
    }
    .loginmodal_input{
    	border-radius: 4px; 
    }
    
    
    .modalloc{
    	display:inline-block;
    	width:150px;
    }
    .loginmodal_div{
    	margin-bottom: 10px
    }
</style>
