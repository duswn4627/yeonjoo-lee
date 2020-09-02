<%@page import="com.jhta.finalproject.jh.vo.SellerOldbooksVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- 다음주소api -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<!-- 에디터api -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<!-- css적용 추후 파일에 따로 분리 예정임 -->

<script>
	//에디터api적용
	$(document).ready(function() {
	  $('#summernote').summernote({
		  height:400
	  });
	});

	//주소api적용
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
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

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
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
<form method="post" action="${cp }/seller/updateOldbook" enctype="multipart/form-data">
	<!-- 상품 수정 할 상품번호 -->
	<input type="hidden" name="obnum" value="${obnum}">
	<!-- 기존 등록된이미지 -->
	<input type="hidden" name="beforeImgnum1" value="${imgList[0].imgnum}">
	<input type="hidden" name="beforeImgsavename1" value="${imgList[0].imgsavefilename }">
	<input type="hidden" name="beforeImgnum2" value="${imgList[1].imgnum}">
	<input type="hidden" name="beforeImgsavename2" value="${imgList[1].imgsavefilename }">
	<input type="hidden" name="beforeImgnum3" value="${imgList[2].imgnum}">
	<input type="hidden" name="beforeImgsavename3" value="${imgList[2].imgsavefilename }">
	<input type="hidden" name="beforeImgnum4" value="${imgList[3].imgnum}">
	<input type="hidden" name="beforeImgsavename4" value="${imgList[3].imgsavefilename }">
	
	
	<div id="prodInputForm">
		<i><img src="${cp }/resources/jh/jhimages/상품수정_1.png"></i>
		<!-- 카테고리등록 -->
		<div id="cate">
			<p>[카테고리확인]&emsp;</p>
			<!-- <input type="button" class="btn btn-primary" value="분류추가" id="catebt"><br><br> -->
			<table id="infotable" class="table table-bordered">
				<tr>
					<td class="bgtd">카테고리</td>
					<td><select name="bcataname" onchange="getsubcate(this.value)" class="selectbox">
						<option value="0">---선택---</option>
						<c:forEach var="vo" items="${list}">
							<option value="${vo.bcatenum}"<c:if test="${vo.bcatenum==bbcatenum}">
							selected</c:if>>${vo.bcataname}</option>
						</c:forEach>
						</select>
						<select name="scatename" class="selectbox">
							<c:forEach var="svo" items="${slist}">
								<option value="${svo.scatenum }" <c:if test="${svo.scatenum==sscatenum}">
								selected</c:if>>${svo.scataname }</option>
							</c:forEach>
						</select>
					</td>
				</tr>		
			</table>
		</div>
		<!-- 상품기본정보등록 -->
		<div id="basic">
			<p>[상품기본정보]</p>
			<table id="infotable1" class="table table-bordered">
				<tr>
					<td class="bgtd">도서명</td>
					<td><input type="text" name="obname" value="${getObname}"><span>&emsp;※필수입력</span></td>
				</tr>
				<tr>
					<td class="bgtd">저자</td>
					<td><input type="text" name="obwriter" value="${getObwriter }"><span>&emsp;※필수입력</span></td>
				</tr>
				<tr>
					<td class="bgtd">출판사</td>
					<td><input type="text" name="obpublisher" value="${getObpublisher }"><span>&emsp;※필수입력</span></td>
				</tr>
				<tr>
					<td class="bgtd">출간일</td>
					<td><input type="date" name="obpdate" value="${getObpdate}"><span>&emsp;※필수입력</span></td>
				</tr>
			</table>
		</div>
		<!-- 상품가격정보등록 -->
		<div id="price">
			<p>[상품가격정보]</p>
			<table id="infotable2" class="table table-bordered">
				<tr>
					<td class="bgtd">정가</td>
					<td><input type="text" name="oborgprice" class="infotd2"
						onkeyup="numberComma(this.value)" value="${getOborgprice }"><span>&emsp;원</span></td>
				</tr>
				<tr>
					<td class="bgtd">품질체크</td>
					<td>
					<input type="radio" name="obstatus" value="1" <c:if test="${getObstatus==1 }">checked</c:if>>최상
					<input type="radio" name="obstatus" value="2" <c:if test="${getObstatus==2 }">checked</c:if>>상
					<input type="radio" name="obstatus" value="3" <c:if test="${getObstatus==3 }">checked</c:if>>중
					<input type="radio" name="obstatus" value="4" <c:if test="${getObstatus==4 }">checked</c:if>>하
					</td>
				</tr>
				<tr>
					<td class="bgtd">판매가</td>
					<td><input type="text" name="obsaleprice" class="infotd2" value="${getObsaleprice }"><span>&emsp;원</span></td>
				</tr>
			</table>
		</div>
		<!-- 배송정보등록 -->
		<div id="ship">
			<p>[배송정보]</p>
			<table id="infotable3" class="table table-bordered">
				<tr>
					<td class="bgtd">택배비</td>
					<td>
						<input type="radio" name="obdelfee" value="0" id="free" <c:if test="${getObdelfee==0 }">checked</c:if>>무료
						<input type="radio" name="obdelfee" value="2500" id="fee" 
						<c:if test="${getObdelfee==2500 }">checked</c:if>>기본(2,500원)
					</td>
				</tr>
				<tr>
					<td class="bgtd">출고주소</td>
					<td><input type="text" id="sample4_postcode" placeholder="우편번호" name="addr1" class="addr"
							onclick="sample4_execDaumPostcode()" readonly="readonly" value="${addr1}">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
						<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="addr2" class="addr"
							onclick="sample4_execDaumPostcode()" readonly="readonly" value="${addr2 }">
						<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="addr3" class="addr" value="${addr3 }">
						<span id="guide" style="color:#999;display:none"></span><br>
						<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="addr4" class="addr" value=${addr4 }>
						<input type="text" id="sample4_extraAddress" placeholder="참고항목" name="addr5" class="addr"
							onclick="sample4_execDaumPostcode()" readonly="readonly" value="${addr5 }">
					</td>
				</tr>
			</table>
		</div>
		<!-- 상품이미지등록 -->
		<div id="imginfo">
			<p>[상품이미지등록]</p>
			<table id="infotable4" class="table table-bordered">
				<tr id="selectimg1">
					<td class="bgtd">대표(기본이미지)-필수</td>
					<td id="img1td">
						<span><c:if test="${imgList[0].thumbnail==1 }">${imgList[0].imgorgfilename }</c:if>&nbsp</span>
						<input type="button" value="삭제" style="width: 80px;" onclick="imgdel(1,${imgList[0].imgnum})"
						id="imgdelbt1">
					</td>
				</tr>
				<tr id="selectimg2">
					<td class="bgtd">실물이미지-선택</td>
					<td id="img2td">
						<c:choose>
							<c:when test="${imgList[1]==null  }">
								<input type="file" name="img2">
							</c:when>
							<c:otherwise>
								<span>${imgList[1].imgorgfilename }&nbsp</span>
								<input type="button" value="삭제" style="width: 80px;" onclick="imgdel(2,${imgList[1].imgnum})"
								id="imgdelbt2">
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr id="selectimg3">
					<td class="bgtd">실물이미지-선택</td>
					<td id="img3td">
						<c:choose>
							<c:when test="${imgList[2]==null  }">
								<input type="file" name="img3">
							</c:when>
							<c:otherwise>
								<span class="test">${imgList[2].imgorgfilename }&nbsp</span>
								<input type="button" value="삭제" style="width: 80px;" onclick="imgdel(3,${imgList[2].imgnum})"
								id="imgdelbt3">
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr id="selectimg4">
					<td class="bgtd">실물이미지-선택</td>
					<td id="img4td">
						<c:choose>
							<c:when test="${imgList[3]==null  }">
								<input type="file" name="img4">
							</c:when>
							<c:otherwise>
								<span>${imgList[3].imgorgfilename }&nbsp</span>
								<input type="button" value="삭제" style="width: 80px;" onclick="imgdel(4,${imgList[3].imgnum})"
								id="imgdelbt4">
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
		</div>
		<!-- 상품설명 등록 -->
		<div id="info">
			<p>[상품설명]</p>
			<table id="infotable5" class="table table-bordered">
				<tr>
					<td class="bgtd">상품설명</td>
					<td><textarea id="summernote" name="obdetail">${getObdetail}</textarea></td>
				</tr>
			</table>
		</div>
	<button type="submit" class="btn btn-success btn-lg" id="updatebt">수정하기</button>
	</div>
</form>

<script type="text/javascript">
	//대분류 카테고리 선택시 소분류 가져오기
	function getsubcate(bcate) {
		$.ajax({
			url:"${pageContext.request.contextPath}/seller/getSmallcate?bcatenum="+bcate,
			dataType:"json",
			success:function(data){
				$(data).each(function(i,mem){
					$("select[name=scatename]").append("<option value="+data[i].scatenum+">"+data[i].scataname+"</option>");
				});
			}
		});
		selectdel();
	}
	//소분류 카테고리 기존option리스트 지우기
	function selectdel() {
		$("select[name=scatename] option").remove();
	}
	//이미지삭제버튼
	function imgdel(num,imgnum) {
		var imgresult=confirm('이미지를 삭제하시겠습니까?');
		if(imgresult){
			$.ajax({
				url:"${cp}/seller/delimg?imgnum="+imgnum,
				dataType:"json",
				success:function(data){
				//	alert(data+'이미지가 삭제되었습니다!');
				}
			});
			var text="<td><input type='file' name='updateImg"+num+"'></td>";
			$("#selectimg"+num).append(text);
			$("#imgdelbt"+num).remove();
			$("#img"+num+"td").remove();
		}else{
			return;
		}
	}
	
	//입력폼 유효성검사
	$("form").submit(function() {
		var number= /[^0-9]/g //정규식(숫자만)
		
		/*대분류카테고리*/
		if($("select[name=bcataname]").val()==="0"){
			alert("대분류 카테고리를 선택해주세요");
			return false;
		}
		/*소분류카테고리*/
		if($("select[name=scataname]").val()==="0"){
			alert("소분류 카테고리를 선택해주세요");
			return false;
		}
		/*도서명*/
		if($("input[name=obname]").val()===""){
			alert("도서명을 입력해주세요");
			$("input[name=obname]").focus();
			return false;
		}
		/*저자*/
		if($("input[name=obwriter]").val()===""){
			alert("저자를 입력해주세요");
			$("input[name=obwriter]").focus();
			return false;
		}
		/*출판사*/
		if($("input[name=obpublisher]").val()===""){
			alert("출판사를 입력해주세요");
			$("input[name=obpublisher]").focus();
			return false;
		}
		/*출간일*/
		if($("input[name=obpdate]").val()===""){
			alert("출간일을 입력해주세요");
			$("input[name=obpdate]").focus();
			return false;
		}
		//오늘 날짜 구하기
		var date=new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		if(month.toString().length<2){
			month="0"+month;
		}
		var day = date.getDate();
		if(day.toString().length<2){
			day="0"+day;
		}
		var today=year+month+day
		//입력받은 날짜 쪼개기
		var inputdate=$("input[name=obpdate]").val();
		var str=inputdate.split('-');
		var strArr=str[0]+str[1]+str[2];
		if(strArr>=today){
			alert("출간일은 현재 날짜를 넘을 수 없습니다.");
			return false;
		}
		/*상품정가*/
		if($("input[name=oborgprice]").val()===""){
			alert("상품 정가를 입력해주세요");
			$("input[name=oborgprice]").focus();
			return false;
		}
		if(number.test($("input[name=oborgprice]").val())){
			alert("가격은 숫자만 입력해주세요");
			$("input[name=oborgprice]").focus();
			return false;
		}
		/*상품품질*/
		if($('input:radio[name=obstatus]').is(':checked')==false){
			alert("상품 품질 상태를 선택해 주세요");
			$("input[name=obstatus]").focus();
			return false;
		}
		/*상품판매가*/
		if($("input[name=obsaleprice]").val()===""){
			alert("상품 판매가를 입력해주세요");
			$("input[name=obsaleprice]").focus();
			return false;
		}
		if(number.test($("input[name=obsaleprice]").val())){
			alert("가격은 숫자만 입력해주세요");
			$("input[name=obsaleprice]").focus();
			return false;
		}
		/*택배비*/
		if($('input:radio[name=obdelfee]').is(':checked')==false){
			alert("택배비를 선택해 주세요");
			$("input[name=obdelfee]").focus();
			return false;
		}
		/*출고주소*/
		if($("input[name=addr1]").val()===""){
			alert("우편번호를 입력해주세요.");
			$("input[name=addr1]").focus();
			return false;
		}
		if($("input[name=addr3]").val()===""){
			alert("지번 주소를 입력해주세요.");
			$("input[name=addr3]").focus();
			return false;
		}
		if($("input[name=addr4]").val()===""){
			alert("상세주소를 입력해주세요.");
			$("input[name=addr4]").focus();
			return false;
		}
		/*썸네일 이미지*/
		if($("input[name=updateImg1]").val()===""){
			alert("기본 이미지를 등록해주세요.");
			$("input[name=img1]").focus();
			return false;
		}
		/*상품설명*/
		if($("textarea[name=obdetail]").val()===""){
			alert("상품설명을 입력해주세요.");
			$("textarea[name=obdetail]").focus();
			return false;
		}
	});
</script>