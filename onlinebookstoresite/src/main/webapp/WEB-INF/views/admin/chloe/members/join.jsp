<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style type="text/css">
#joinheader {
	text-align: center;
	padding-top: 50px;
	padding-bottom: 50px;
}

#joinwrapper {
	position: relative;
	height: 100%;
}

#joincontent {
	width: 800px;
	margin-left: 30%;
}

.joinlabel {
	margin: 19px 0 8px;
	font-size: 17px;
	font-weight: 700;
}

.box {
	display: block;
	width: 100%;
	height: 51px;
	border: solid 1px #dadada;
	padding: 10px 14px 10px 14px;
	box-sizing: border-box;
	background: #fff;
	position: relative;
}

.int {
	display: block;
	position: relative;
	width: 100%;
	height: 29px;
	border: none;
	background: #fff;
	font-size: 15px;
}

.box.int_pass {
	padding-right: 40px;
}

.box.int_pass_check {
	padding-right: 40px;
}

.pswdImg {
	width: 18px;
	height: 20px;
	display: inline-block;
	position: absolute;
	top: 50%;
	right: 16px;
	margin-top: -10px;
}

#email_wrap, #phone_wrap, #addr_wrap1, #addr_wrap2, #addr_wrap3,
	#bir_wrap {
	display: table;
	width: 100%;
}

#email_1 {
	display: table-cell;
	width: 90px;
}

#email_2 {
	display: table-cell;
	width: 100px;
}

#email_3 {
	display: table-cell;
	width: 50px;
}

#phone_1, #phone_2, #phone_3 {
	display: table-cell;
	width: 50px;
}

#addrBtn {
	display: inline-block;
	position: absolute;
	top: 50%;
	right: 16px;
	margin-top: -15px;
}

#addr_1, #addr_2, #addr_3, #addr_4, #addr_5 {
	display: table-cell;
	width: 50px;
}

#birthday-y-ko, #birthday-m-ko, #birthday-d-ko {
	display: table-cell;
	width: 147px;
}

.btn_area {
	margin: 30px 0 91px;
}

#sbm {
	width: 100%;
	padding: 21px 0 17px;
	border: 0;
	cursor: pointer;
	color: #fff;
	background-color: #4C8625;
	font-size: 20px;
	font-weight: 400;
	/* 	font-family: Dotum, '돋움', Helvetica, sans-serif; */
}
</style>

<div id="joinheader">
	<div id="joinwrapper">
		<div id="joincontent">
			<img src="${pageContext.request.contextPath }/resources/jh/jhimages/회원가입로고_1.png" width="500px" height="225px">		
			<form action="${pageContext.request.contextPath }/join" method="post">
				<div>
						<label class="joinlabel" for="mname">이름</label>
					<span class="box int_id">
						<input type="text" id="mname" name="mname" class="int">
					</span>
					<span id="nameCheck"></span>
				</div>
				
				<div>
						<label class="joinlabel" for="mid">아이디</label>
					<span class="box int_id">
						<input type="text" id="mid" name="mid" class="int" maxlength="15">
					</span>
					<span id="idCheck"></span>
				</div>
				
				<div>
						<label class="joinlabel" for="mpwd">비밀번호</label>
					<span class="box int_pass">
						<input type="password" id="mpwd" name="mpwd" class="int">
						<img src="${pageContext.request.contextPath }/resources/img/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
					</span>
					<span id="pwdCheck1"></span>
				</div>
				
				<div>
						<label class="joinlabel" for="mpwd2">비밀번호 확인</label>
					<span class="box int_pass_check">
						<input type="password" id="mpwd2" class="int">
						<img src="${pageContext.request.contextPath }/resources/img/m_icon_check_disable.png" id="pswd2_img1" class="pswdImg">
					</span>
					<span id="pwdCheck2"></span>
				</div>
				
				<div>
						<label class="joinlabel" for="email1">이메일</label>
					<div id="email_wrap">
						<div id="email_1">
							<span class="box">
								<input type="text" name="email1" id="email1" class="int" placeholder="gobook1234"> 
							</span>
						</div>
						<div id="email_2">
							<span class="box"> 
								<input type="text" name="email2" id="email2" class="int" placeholder="@gobook.com"> 
							</span>
						</div>
						<div id="email_3">
							<span class="box"> 
								<select id="emailSelect" class="int">
									<option value="">직접입력</option>
									<option value="@naver.com">@naver.com</option>
									<option value="@hanmail.net">@hanmail.net</option>
									<option value="@gmail.com">@gmail.com</option>
									<option value="@google.com">@google.com</option>
									<option value="@yahoo.co.kr">@yahoo.co.kr</option>
									<option value="@korea.com">@korea.com</option>
									<option value="@paran.com">@paran.com</option>
							</select>
							</span>
						</div>
					</div>
					<span id="emailCheck"></span>
				</div>
				
				<div>
						<label class="joinlabel">휴대폰번호</label>
					<div id="phone_wrap">
						<div id="phone_1">
							<span class="box">
								<input type="text" name="phone1" id="phone1" size="4" maxlength="3" class="int" placeholder="010">
							</span>
						</div>
						<div id="phone_2">
							<span class="box">
								<input type="text" name="phone2" id="phone2" size="6" maxlength="4" class="int" placeholder="1234">
							</span>
						</div>
						<div id="phone_3">
							<span class="box">
								<input type="text" name="phone3" id="phone3" size="6" maxlength="4" class="int" placeholder="5678">
							</span>
						</div>
					</div>
					<span id="phoneCheck"></span>
				</div>
				
				<div>
						<label class="joinlabel">주소</label>
					<div id="addr_wrap1">
						<div id="addr_1">
							<span class="box int_addr">
								<input type="text" id="sample4_postcode" placeholder="우편번호" name="addr1" class="addr int" onclick="sample4_execDaumPostcode()" size="10px" readonly="readonly">
								<input type="button" id="addrBtn" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"> 
							</span>
						</div>
					</div>
				</div>
				<div>
					<div id="addr_wrap2">
						<div id="addr_2">
							<span class="box">
								<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="addr2" class="addr int" onclick="sample4_execDaumPostcode()" size="40px" readonly="readonly"> 
							</span>
						</div>
						<div id="addr_3">
							<span class="box">
								<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="addr3" class="addr int" size="40px"> 
							</span>
						</div>
					</div>
				</div>
				<div>
					<div id="addr_wrap3">
						<div id="addr_4">
							<span class="box">
								<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="addr4" class="addr int" size="40px">  
							</span>
						</div>
						<div id="addr_5">
							<span class="box">
								<input type="text" id="sample4_extraAddress" placeholder="참고항목" name="addr5" class="addr int" onclick="sample4_execDaumPostcode()" size="40px" readonly="readonly">
							</span>
						</div>
					</div>
					<span id="guide" style="color: #999; display: none"></span>
				</div>
				
				<div>
						<label class="joinlabel" for="birthday-y-ko">생년월일</label>
					<div id="bir_wrap">
						<div class="form-wrap ui-check-date" data-term="100">
							<span class="box int_id">
								<select id="birthday-y-ko" title="연도 선택" data-default-option="연도 선택" data-unit="y" name="yyyy" class="int"></select> 
								<select id="birthday-m-ko" title="달 선택" data-default-option="달 선택" data-unit="m" name="mm" class="int"></select> 
								<select id="birthday-d-ko" title="일 선택" data-default-option="일 선택" data-unit="d" name="dd" class="int"></select>
							</span>
						</div>
					</div>
				</div>
				
				<div>
						<label class="joinlabel">성별</label>
					<span class="box int_sex">
						<input type="radio" name="sex" value="F"> 여자 
						<input type="radio" name="sex" value="M"> 남자
					</span>
				</div>
				
				<div class="btn_area">
					<button type="submit" id="sbm"><span>가입하기</span></button>
				 </div>
			</form>
		</div>
	</div>
</div>

<script>
	//모든 공백 체크 정규식
	var empj = /\s/g;
	// 이름 정규식
	var namej = /^[가-힣]{2,6}$/;
	//아이디 정규식
	var idj = /^[a-z0-9]{5,14}$/;
	// 비밀번호 정규식
	var pwdj = /^[A-Za-z0-9]{4,10}$/;
	// 이메일 검사 정규식
	var emailj1 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*$/i;
	var emailj2 = /^@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 휴대폰번호 정규식
	var phonej1 = /^01[0|1|6|7|8|9]$/;
	var phonej2 = /^[0-9]{3,4}$/;
	var phonej3 = /^[0-9]{4}$/;

	// 이름 유효성 검사
	$("#mname").blur(function() {
		if (namej.test($(this).val())) {
			$("#nameCheck").text("");
		} else {
			$("#nameCheck").text("이름을 확인해 주세요.");
			$("#nameCheck").css("color", "red");
		}
	});

	// 아이디 중복체크 및 유효성 검사
	$("input[name='mid']").blur(function() {
		var mid = $("input[name='mid']").val();
		console.log("mid:"+mid);
		$.ajax({
			url : "${pageContext.request.contextPath}/joinIdCheck?mid=" + mid,
			type : "get",
			dataType : "json",
			success : function(data) {
				// 1 - 중복 / 0 - 사용가능
				if (data.result == 1) {
					$("#idCheck").text("이미 사용 중인 아이디입니다.");
					$("#idCheck").css("color", "red");
					$("#sbm").attr("disabled", true);
				} else if (mid.length == 0) {
					$("#idCheck").text("아이디를 입력해 주세요");
					$("#idCheck").css("color", "red");
					$("#sbm").attr("disabled", true);
				} else if (mid.length <= 5) {
					$("#idCheck").text("5자 이상으로 입력해 주세요");
					$("#idCheck").css("color", "red");
					$("#sbm").attr("disabled", true);
				} else if (mid.length > 14) {
					$("#idCheck").text("14자 이하로 입력해 주세요");
					$("#idCheck").css("color", "red");
					$("#sbm").attr("disabled", true);
				} else if (!(idj.test(mid))) {
					$("#idCheck").text("영문과 숫자만 사용해 주세요");
					$("#idCheck").css("color", "red");
					$("#sbm").attr("disabled", true);
				} else {
					$("#idCheck").text("사용 가능한 아이디입니다.");
					$("#idCheck").css("color", "green");
					$("#sbm").attr("disabled", false);
				}
			}
		});
	});

	// 이메일 셀렉트 선택 시 value값에 넣기
	$("#emailSelect").change(function() {
		var emailval = $(this).val();
		$("#email2").val(emailval);
	});

	// 이메일 중복체크 및 유효성 검사
	$("#email1").change(function() {
		emailAjax();
	});
	$("#email2").change(function() {
		emailAjax();
	});
	$("#emailSelect").change(function() {
		emailAjax();
	});

	function emailAjax() {
		var email1 = $("#email1").val();
		var email2 = $("#email2").val();
		var email = email1 + email2;

		$.ajax({
			url : "${pageContext.request.contextPath}/joinEmailCheck?email=" + email,
			type : "get",
			dataType : "json",
			success : function(data) {
				// 1 - 중복 / 0 - 사용가능
				if (data.result == 1) {
					$("#emailCheck").text("이미 사용 중인 이메일입니다.");
					$("#emailCheck").css("color", "red");
					$("#sbm").attr("disabled", true);
				} else if (!(emailj1.test(email1))) {
					$("#emailCheck").text("이메일 형식이 잘못되었습니다.");
					$("#emailCheck").css("color", "red");
					$("#sbm").attr("disabled", true);
				} else if (!(emailj2.test(email2))) {
					$("#emailCheck").text("이메일 형식이 잘못되었습니다.");
					$("#emailCheck").css("color", "red");
					$("#sbm").attr("disabled", true);
				} else if (email.length > 30) {
					$("#emailCheck").text("이메일 형식이 잘못되었습니다.");
					$("#emailCheck").css("color", "red");
					$("#sbm").attr("disabled", true);
				} else {
					$("#emailCheck").text("사용 가능한 이메일입니다.");
					$("#emailCheck").css("color", "green");
					$("#sbm").attr("disabled", false);
				}
			}
		});
	}

	// 비밀번호 유효성 검사
	$("#mpwd").blur(function() {
		if (pwdj.test($("#mpwd").val())) {
			$("#pwdCheck1").text("");
		} else {
			$("#pwdCheck1").text("숫자 또는 문자로만 5~10자리 입력해 주세요.");
			$("#pwdCheck1").css("color", "red");
		}
	});
	$("#mpwd2").blur(function() {
		if ($("#mpwd").val() != $(this).val()) {
			$("#pwdCheck2").text("비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
			$("#pwdCheck2").css("color", "red");
		} else {
			$("#pwdCheck2").text("");
		}
	});
	
	//휴대폰번호
	$("#phone1").blur(function() {
		if (phonej1.test($(this).val())) {
			$("#phoneCheck").text("");
		} else {
			$("#phoneCheck").text("번호 형식이 잘못되었습니다.");
			$("#phoneCheck").css("color", "red");
		}
	});
	$("#phone2").blur(function() {
		if (phonej2.test($(this).val())) {
			$("#phoneCheck").text("");
		} else {
			$("#phoneCheck").text("번호 형식이 잘못되었습니다.");
			$("#phoneCheck").css("color", "red");
		}
	});
	$("#phone3").blur(function() {
		if (phonej3.test($(this).val())) {
			$("#phoneCheck").text("");
		} else {
			$("#phoneCheck").text("번호 형식이 잘못되었습니다.");
			$("#phoneCheck").css("color", "red");
		}
	});

	// submit 버튼 눌렀을 때 한 번 더 유효성 체크
	var invalArr = new Array(4).fill(false);
	$("form").submit(function() {
		
		var email1 = $("#email1").val();
		var email2 = $("#email2").val();
		var email = email1 + email2;
		
		// 이름
		if (namej.test($("#mname").val())) {
			invalArr[0] = true;
		} else {
			invalArr[0] = false;
		}

		//비밀번호
		if (pwdj.test($("#mpwd").val()) && ($("#mpwd").val() == $("#mpwd2").val())) {
			invalArr[1] = true;
		} else {
			invalArr[1] = false;
		}

		// 주소
		var addr1 = $("input[name='addr1']").val();
		var addr2 = $("input[name='addr2']").val();
		var addr3 = $("input[name='addr3']").val();
		var addr4 = $("input[name='addr4']").val();
		var addr5 = $("input[name='addr5']").val();
		if (addr1 != "" && addr2 != "" && addr3 != "" && addr4 != "" && addr5 != "") {
			invalArr[2] = true;
		} else {
			invalArr[2] = false;
		}

		// 휴대폰번호
		if (phonej1.test($("#phone1").val()) && phonej2.test($("#phone2").val()) && phonej3.test($("#phone3").val())) {
			invalArr[3] = true;
		} else {
			invalArr[3] = false;
		}

		var All = true;
		for (var i = 0; i < invalArr.length; i++) {
			if (invalArr[i] == false) {
				All = false;
			}
		}

		// 생년월일

		//성별

		if (All) { // 유효성 모두 통과하면
			alert("고북 회원가입을 축하합니다! 로그인 후 이용해 주세요 :)");
			return true;
		} else {
			alert("제대로 입력이 되었는지 다시 한 번 확인해 주세요.");
			return false;
		}
	});

	///////////////////////////////////////////////
	// 년월일 selectbox 윤달 처리
	function selectDateCheck() {
		// 현재 년월일 지정, 년월일 select 지정
		var nowDate = new Date(), 
			nowYear = nowDate.getFullYear(), 
			nowMonth = nowDate.getMonth() + 1, 
			nowDay = nowDate.getDay(), 
			_wrap = document.querySelectorAll('.ui-check-date'), 
			_select = document.querySelectorAll('.ui-check-date select'), 
			_year = document.querySelectorAll('.ui-check-date select[data-unit=y]'), 
			_month = document.querySelectorAll('.ui-check-date select[data-unit=m]'), 
			_day = document.querySelectorAll('.ui-check-date select[data-unit=d]'), 
			yearTerm = 100; // default 년도 기간 설정

		// 초기 년도 설정
		// (1) data-tearm : 년도 기간 설정
		// (2) data-point : 년도 시점 설정
		for (var i = 0; i < _wrap.length; i++) {
			var startYear, endYear, 
				setTerm = _wrap[i].getAttribute('data-term') * 1, 
				setPoint = _wrap[i].getAttribute('data-point'), 
				num = 0;

			_year[i].options[0] = new Option(_year[i].getAttribute('data-default-option'), 'default'); // 'default' || ''

			// data-term 속성값이 있을 경우 기간 적용
			if (setTerm != null && setTerm != '') {
				yearTerm = setTerm;
			}

			// 년도 option 설정
			if (setPoint == 'up') {
				// 미래~현재
				startYear = nowYear + yearTerm;
				endYear = nowYear;
			} else if (setPoint == 'down' || setPoint == '' || setPoint == null) {
				// 현재~과거
				startYear = nowYear;
				endYear = nowYear - yearTerm;
			} else {
				// up, down, null 이외의 값 지정
			}

			for (var j = startYear; j >= endYear; j--) {
				num++;
				_year[i].options[num] = new Option(j, j);
			}
		}

		// 초기 월 설정
		for (var i = 0; i < _wrap.length; i++) {
			_month[i].options[0] = new Option(_month[i].getAttribute('data-default-option'), 'default');
			for (var j = 1; j <= 12; j++) {
				_month[i].options[j] = new Option(j, j);
			}
		}

		// 초기 일 절정
		for (var i = 0; i < _wrap.length; i++) {
			_day[i].options[0] = new Option(_day[i].getAttribute('data-default-option'), 'default');
			for (var j = 1; j <= 31; j++) {
				_day[i].options[j] = new Option(j, j);
			}
		}

		// 년 선택 시, 일 설정 함수 실행
		for (var i = 0; i < _wrap.length; i++) {
			_year[i].addEventListener('change', selectSetDay, false);
		}

		// 월 선택 시, 일 설정 함수 실행
		for (var i = 0; i < _wrap.length; i++) {
			_month[i].addEventListener('change', selectSetDay, false);
		}

		// 일 설정 함수
		function selectSetDay() {
			// 평년 각 달의 일수 배열
			// 선택한 select 그룹의 년월일 option value
			var arrDay = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 ], 
				lastDay, wrap = this.parentNode, 
				yearVal = wrap.querySelector('select[data-unit=y]').value, 
				monthVal = wrap.querySelector('select[data-unit=m]').value, 
				selectedDay = wrap.querySelector('select[data-unit=d]'), 
				dayVal = selectedDay.value, 
				defaultTxt = selectedDay.getAttribute('data-default-option'), 
				defaultVal = 'default'; // 'default' || ''

			// 윤달체크 (true : 2월 마지막날 29일)
			if (yearVal % 4 == 0 && yearVal % 100 != 0 || yearVal % 400 == 0) {
				arrDay[1] = 29;
			}
			// 선택한 달의 일수 설정
			lastDay = (monthVal != defaultVal) ? arrDay[monthVal - 1] : 31;

			// 일 option 재설정
			selectedDay.options.length = 0; // option 목록 초기화
			selectedDay.options[0] = new Option(defaultTxt, defaultVal);
			for (var i = 1; i <= lastDay; i++) {
				selectedDay.options[i] = new Option(i, i);
			}

			// 선택한 날과 그 달의 마지막 날 비교
			// 선택한 날이 default가 아니고 마지막 날 보다 크면 : 마지막 날짜로 선택 일 변경
			// 아니면 : 선택한 날 그대로 가져감
			selectedDay.value = (dayVal != defaultVal && dayVal > lastDay) ? lastDay : dayVal;
		}
	}

	// 윤달 스크립트 실행
	window.onload = function() {
		selectDateCheck();
	}

	////////////////////////////////////////
	//주소api적용
	function sample4_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var roadAddr = data.roadAddress; // 도로명 주소 변수
				var extraRoadAddr = ''; // 참고 항목 변수

				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraRoadAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraRoadAddr !== '') {
					extraRoadAddr = ' (' + extraRoadAddr + ')';
				}
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('sample4_postcode').value = data.zonecode;
				document.getElementById("sample4_roadAddress").value = roadAddr;
				document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
				// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
				if (roadAddr !== '') {
					document.getElementById("sample4_extraAddress").value = extraRoadAddr;
				} else {
					document.getElementById("sample4_extraAddress").value = '';
				}

				var guideTextBox = document.getElementById("guide");
				// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
				if (data.autoRoadAddress) {
					var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
					guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
					guideTextBox.style.display = 'block';
				} else if (data.autoJibunAddress) {
					var expJibunAddr = data.autoJibunAddress;
					guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
					guideTextBox.style.display = 'block';
				} else {
					guideTextBox.innerHTML = '';
					guideTextBox.style.display = 'none';
				}
			}
		}).open();
	}
</script>