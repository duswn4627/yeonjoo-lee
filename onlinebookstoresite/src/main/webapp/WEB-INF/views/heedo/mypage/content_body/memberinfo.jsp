<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<div id="content_memberinfo">

	<div>
		<i class="fab fa-first-order-alt"></i><h4 style="display:inline"><span class="colorFont">회원</span>정보</h4>
	</div>
	<div>
		<table class="table">
			<tr>
				<td class="tableloc">이름</td>
				<td style="width:40%">${mname }</td>
				<td class="tableloc">가입일</td>
				<td style="width:40%">${regdate }</td>
			</tr>
			<tr>
				<td class="tableloc">아이디</td><td>${requestScope.mid }</td><td class="tableloc">비밀번호</td>
				<td>
					<input type="password" id="mypwd" readonly="readonly">
					<button type="button" class="btn btn-dark changeBtn" data-toggle="modal" data-target="#pwdchangemodal">변경</button>
				</td>
			</tr>
			<tr>
				<td class="tableloc">전화번호</td>
				<td>
					<span id="phone"></span>
					<button type="button" class="btn btn-dark changeBtn" data-toggle="modal" data-target="#phonemodal">변경</button>
				</td>
				<td class="tableloc">
					이메일
				</td>
				<td>
					<span id="email"></span>
					<button type="button" class="btn btn-dark changeBtn" data-toggle="modal" data-target="#emailchangemodal">변경</button>
				</td>
			</tr>
			<tr>
				<td class="tableloc">
					주소
				</td>
				<td colspan="3">
					<input type="text" id="addr1" class="textbox1" readonly="readonly">
					<button type="button" class="btn btn-dark" id="searchAddrBtn" data-toggle="modal" data-target="#addrmodal">주소 변경</button><br>
					<div class="addrLoc">지번 주소</div><input type="text" id="addr3" class="road_land_textbox" readonly="readonly"><br>
					<div class="addrLoc">도로명 주소</div><input type="text" id="addr2" class="road_land_textbox" readonly="readonly"><br>
					<input type="text" id="addr4" placeholder="상세주소" readonly="readonly">
					&nbsp<input type="text" id="addr5" placeholder="참고주소" readonly="readonly">
				</td>
			</tr>
		</table>
	</div>
	<div id="btndiv">
		<button type="button" class="btn btn-dark">마이페이지 메인으로</button>
	</div>
</div>
<div id="phonemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">회원정보</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody" id="phonemodal_body">
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>전화번호</strong></span>
        		<input type="text" id="modal_phone" class="loginmodal_input" readonly="readonly"><br>
        	</div>
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>변경할전화번호</strong></span>
        		<input type="text" id="modalphone1" class="modalphone" value="010">
        		<input type="text" id="modalphone2" class="modalphone">
        		<input type="text" id="modalphone3" class="modalphone">
        	</div>
      </div>
      <div class="modal-footer">
      	  	<button type="button" class="btn btn-dark" id="phoneconfirmBtn">변경</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="emailchangemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">회원정보</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody" id="emailmodal_body">
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>이메일</strong></span>
        		<input type="text" id="modal_email" class="emailmodal_input" readonly="readonly"><br>
        	</div>
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>변경할이메일</strong></span>
        		<input type="email" id="input_email" class="emailmodal_input"><br>
        	</div>
      </div>
      <div class="modal-footer">
      	  	<button type="button" class="btn btn-dark" id="emailchangeBtn">변경</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="pwdchangemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">회원정보</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody" id="pwdmodal_body">
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>비밀번호</strong></span>
        		<input type="password" id="modal_pwd" class="pwdmodal_input" readonly="readonly"><br>
        	</div>
        	<div class="phonemodal_div">
        		<span class="modalloc"><strong>변경할비밀번호</strong></span>
        		<input type="password" id="input_pwd" class="pwdmodal_input"><br>
        	</div>
      </div>
      <div class="modal-footer">
      	  	<button type="button" class="btn btn-dark" id="pwdchangeBtn">변경</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="addrmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">회원정보</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody" id="addrmodal_body">
        	주소변경을 하시겠습니까? 
      </div>
      <div class="modal-footer">
      	  	<button type="button" class="btn btn-dark" id="addrconfirmBtn">확인</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">취소</button>
      </div>
    </div>

  </div>
</div>

<div id="alertchangemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" style="color:white">알림</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="alertchangemodal_body">
        	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="successchangemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">회원정보</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody">
        	<strong>변경완료</strong>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">확인</button>
      </div>
    </div>

  </div>
</div>

<div id="errchangemodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">에러</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="errmodal_body">
        	에러발생으로 변경실패
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>

<div id="addrinputmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #212529">
       <h4 class="modal-title" id="loginmodal_h4">회원정보</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body modalbody" id="addrinputmodal_body">
        	<div class="addrLoc">우편번호</div> <input type="text" id="modaladdr1" class="textbox1" readonly="readonly"><br>
				<div class="addrLoc">지번 주소</div><input type="text" id="modaladdr3" class="road_land_textbox" readonly="readonly"><br>
				<div class="addrLoc">도로명 주소</div><input type="text" id="modaladdr2" class="road_land_textbox" readonly="readonly"><br>
				<input type="text" id="modaladdr4" placeholder="상세주소">
				&nbsp<input type="text" id="modaladdr5" placeholder="참고주소">
      </div>
      <div class="modal-footer">
      	  	<button type="button" class="btn btn-dark" id="addrinputBtn">확인</button>
        <button type="button" class="btn btn-light" data-dismiss="modal">취소</button>
      </div>
    </div>

  </div>
</div>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(document).ready(function(){
		memberinfo();
	});
	var count = 0; // 모달이 열릴 때 마다 count 해서  z-index값을 높여줌

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
			$("#alertchangemodal_body").text('주소입력칸은 빈칸이 될 수 없습니다. 전부 작성해주세요.');
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
	
	
	//이메일변경
	$("#emailchangeBtn").click(function(){
		$("#emailchangemodal").modal('hide')
		var changeemail=$("#input_email").val();
		
		if(changeemail==""){
			$("#alertchangemodal_body").text('변경할 이메일을 적어주세요.')
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
	
	
	//비밀번호변경
	$("#pwdchangeBtn").click(function(){
		$("#pwdchangemodal").modal('hide')
		var changepwd=$("#input_pwd").val();
		
		if(changepwd==""){
			$("#alertchangemodal_body").text('변경할 비밀번호를 적어주세요.')
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
	
	
	
	
	//전화번호변경
	$("#phoneconfirmBtn").click(function(){
		$("#phonemodal").modal('hide')
		var phone1=$("#modalphone1").val();
		var phone2=$("#modalphone2").val();
		var phone3=$("#modalphone3").val();
		
		if(phone1==""||phone3==""||phone2==""){
			$("#alertchangemodal_body").text('변경할 전화번호를 적어주세요.')
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

///////////// 주소 API 시작 ///////////////////////////////////////////////////////
	function searchShipAddr() {
        new daum.Postcode({
            oncomplete: function(data) {
            	console.log('111')
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
				var postnum=data.zonecode;
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                $("#modaladdr1").val(postnum);
                $("#modaladdr2").val(roadAddr);
                $("#modaladdr3").val(data.jibunAddress);
                
                var toproadAddr="("+postnum+")"+" "+roadAddr;
                var topjibunAddr="("+postnum+")"+" "+data.jibunAddress
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                   $("#modaladdr5").val(extraRoadAddr);
                    toproadAddr+=" "+extraRoadAddr+" ";
                    topjibunAddr+=" "+extraRoadAddr+" ";
                } else {
                    
                }
                //var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    //guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                   // guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                   // guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                  //  guideTextBox.style.display = 'block';
                } else {
                    //guideTextBox.innerHTML = '';
                   // guideTextBox.style.display = 'none';
                }
                $("#addrinputmodal").modal('show');
                $("#alertchangemodal_body").text("주소 변경완료.")
                
            }
        }).open();
    }
	///////////// 주소 API 끝 ///////////////////////////////////////////////////////
	
	
	
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