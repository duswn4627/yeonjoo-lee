<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
#emailContent{
	width: 1100px;
	height: 700px;
	margin: auto;
	background-image: url("${cp}/resources/jh/jhimages/중고이메일인증폼.png");
}
input[name='email1']{
	width: 300px;
	margin-left: 400px;
}
#emailBt{
	margin-left: 500px;
	margin-top: 20px;
}
</style>
<div id="emailContent">
	<p style="text-align: center;padding-top: 260px;">@를 포함한 이메일 주소를 정확하게 입력해 주세요.</p>
	<form action="${cp }/seller/mail" method="post">
		<input type="email" name="email1" placeholder="email@email.com" class="form-control">
		<input type="submit" value="이메일발송" class="btn btn-outline-success" id="emailBt">
	</form>
</div>
<script>
	$(function(){
		$("form").submit(function() {
			var email=$("input[name='email1']").val();
			if(email==''){
				alert("이메일을 입력해주세요.");
				return false;
			}
		});
	});
</script>