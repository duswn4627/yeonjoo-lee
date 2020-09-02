<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
/*이메일 인증번호 입력css*/
#injeung{
	width: 1100px;
	height: 700px;
	margin: auto;
	background-image: url("${cp}/resources/jh/jhimages/인증번호입력.png");
}
#injeungMsg{
    margin-left: 650px;
    padding-top: 180px;
}
input[name='email_injeung']{
    margin-left: 650px;
}
</style>
<div id="injeung">
	<form class="login-form" action="${cp }/seller/injeung" method="post">
		<p id="injeungMsg">인증번호를 입력해주세요.</p>
		<input type="text" placeholder="인증번호 입력" name="email_injeung">
		<input type="submit" value="입력" id="injeungBt" class="btn btn-success">
    </form>
</div>
<script type="text/javascript">
	$(function(){
		$("form").submit(function() {
			var incode=$("input[name='email_injeung']").val();
			var code='${code}';
			if(incode!=code){
				alert("인증번호가 일치하지 않습니다.");
				return false;
			}			
		});
	});
</script>