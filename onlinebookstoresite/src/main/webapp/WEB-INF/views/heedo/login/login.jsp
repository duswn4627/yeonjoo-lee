<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- 회원번호,중고판매자번호 보내야됨-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Gobook_Login</title>
<link
	href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="${cp }/resources/hd/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${cp }/resources/hd/loginForm/css/login.css">
</head>
<body>
	<main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
		<div class="container">
			<div class="card login-card">
				<div class="row no-gutters">
					<div class="col-md-5">
						
						<img src="${cp }/resources/hd/loginForm/images/imgtest1.jpg"
							alt="login" class="login-card-img"></a>
					</div>
					<div class="col-md-7">

						<div class="card-body">
							<div class="brand-wrapper">
								<a href="${cp }/">
								<img src="${cp }/resources/hd/img/logo2.jpg" alt="logo"
									class="logo" style="width: 200px; height: auto;"></a>
							</div>
							<ul class="nav nav-tabs">
								<li class="nav-item"><a class="nav-link active"
									data-toggle="tab" href="#home">회원</a></li>
								<li class="nav-item"><a class="nav-link" data-toggle="tab"
									href="#menu1">비회원 주문확인</a></li>
							</ul>

							<div class="tab-content">
								<div id="home" class="tab-pane active">
									<br>
									<p class="login-card-description">로그인</p>
									<form action="/loginOk" method="post">
										<div class="form-group">
											<label for="id" class="sr-only">아이디</label> <input
												type="text" name="id" id="id" class="form-control"
												placeholder="아이디를 입력하세요">
										</div>
										<div class="form-group mb-4">
											<label for="password" class="sr-only">비밀번호</label> <input
												type="password" name="password" id="pwd"
												class="form-control" placeholder="***********">
										</div>
										<input name="login" id="login"
											class="btn btn-block login-btn mb-4" type="button"
											value="로그인">
									</form>
									<a href="#!" class="forgot-password-link">비밀번호를 잊어버리셨습니까?</a>
									<p class="login-card-footer-text">
										아이디를 가지고 있지 않습니까? <a href="${cp }/join" class="text-reset">회원가입은
											여기에서!</a>
									</p>
									<nav class="login-card-footer-nav">
										<a href="#!">Terms of use.</a> <a href="#!">Privacy policy</a>
									</nav>
								</div>
								<div id="menu1" class="tab-pane fade">
									<br>
									<p class="login-card-description">주문조회</p>
									<form action="#!">
										<div class="form-group">
											<label for="ordernum" class="sr-only">주문번호</label> <input
												type="text" name="ordernum" id="ordernum" class="form-control"
												placeholder="주문번호를 입력하세요">
										</div>
										<div class="form-group mb-4">
											<label for="phone" class="sr-only">전화번호</label> <input
												type="text" name="phone" id="phone"
												class="form-control" placeholder="전화번호를 입력하세요(-포함)">
										</div>
										<input name="login" id="search_order"
											class="btn btn-block login-btn mb-4" type="button"
											value="조회">
									</form>
									<a href="#!" class="forgot-password-link">주문번호를 잊어버리셨습니까?</a>
									<p class="login-card-footer-text">
										잊어버리셨다면  <a href="#!" class="text-reset"> 주문번호 찾기!</a>
									</p>
									<nav class="login-card-footer-nav">
										<a href="#!">Terms of use.</a> <a href="#!">Privacy policy</a>
									</nav>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	
</body>
<div id="errmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">에러</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body" id="errmodal_body">
        	
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
       <h4 class="modal-title" style="color:white">알림</h4>
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


<script src="${cp }/resources/hd/js/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="${cp }/resources/hd/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$("#login").click(function(){
		var id=$("#id").val();
		var pwd=$("#pwd").val();
		if(id=='' ||pwd==''){
			$("#errmodal_body").text("아이디와 비밀번호를 적어주세요.");
			$("#errmodal").modal('show')
		}else{
			$.ajax({
				url:"/finalproject/loginCheck",
				type: "post",
				data:{id:id,pwd:pwd},
				dataType:"json",
				success:function(data){
					if(data.result=="fail"){
						$("#errmodal_body").text("입력하신 정보와 일치하는 회원이 없습니다. 아이디와 비밀번호를 확인해주세요.");
						$("#errmodal").modal('show')
					}else if(data.result=="leave"){
						$("#errmodal_body").text("탈퇴한 회원입니다.");
						$("#errmodal").modal('show')
					}else{
						window.location.href="/finalproject/";
					}
					
				}
			});
		}
		
	});
	$("#search_order").click(function(){
		var ordernum=$("#ordernum").val();
		var phone=$("#phone").val();
		if(ordernum=='' ||phone==''){
			$("#errmodal_body").text("주문번호와 전화번호를 입력해주세요.");
			$("#errmodal").modal('show')
			return;
		}
		if(!$.isNumeric(ordernum)){
			$("#errmodal_body").text("주문번호는 숫자만 입력가능합니다.");
			$("#errmodal").modal('show')
			return;
		}
		$.ajax({
			url:"${cp}/nomem/inquiryorder",
			data:{bpaynum:ordernum,phone:phone},
			dataType:"json",
			type:"post",
			success:function(data){
				if(data.result=="nothing"){
					$("#alertmodal_body").text("존재하지 않는 주문입니다. 주문번호와 전화번호를 확인해주세요.")
					$("#alertmodal").modal('show')
				}else if(data.result=="applycancel"){
					$("#alertmodal_body").text("반품/교환신청된 주문입니다")
					$("#alertmodal").modal('show')
				}else if(data.result=="confirmcancel"){
					$("#alertmodal_body").text("반품/교환완료된 주문입니다")
					$("#alertmodal").modal('show')	
				}else if(data.result=="cancelorder"){
					$("#alertmodal_body").text("취소처리된 주문입니다.")
					$("#alertmodal").modal('show')		
				}else if(data.result=="success"){
					var bpaynum1=data.bpaynum;
					var btype1=data.btype;
					var action="";
					if(btype1==1){
						action="${cp}/orderhistory/detailview1";
					}else{
						action="${cp}/orderhistory/useddetailview1";
					}
					var form=$('<form></form>');
					form.attr("action",action);
		    		form.attr('method','post');
		    		form.appendTo('body');
					var bpaynum2="<input type='hidden' name='bpaynum' value="+bpaynum1+">"
					form.append(bpaynum2);
					form.submit();
				}
			}
		});
	})
	
</script>
</html>