<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>
/*입금완료/배송요청중 css*/
#detail2 {
	height: 1000px;
}

.toptr {
	text-align: center;
}

#detail2 table .toptr {
	height: 30px;
	background-color: silver;
}

#searchBox2 {
	width: 1200px;
	height: 200px;
}

.borderdate2 {
	margin-left: 20px;
	margin-right: 10px;
}

#keyword_menu2{
	margin-left: 20px;
	width: 400px;
	display: inline;
}

#slaesListbt2 {
	margin-left: 10px;
	margin-right: 10px;
}

.field_menu2 {
	margin-right: 10px;
	margin-left: 20px;
}
</style>
<script type="text/javascript" src="${cp }/resources/jh/js/jquery-3.2.1.min.js"></script>
<form action="${cp }/seller/salesManagement2?tabType=2&keyword2=${map.keyword2}&startDay2=${map.startDay2}&
							endDay2=${map.endDay2}&field2=${map.field2}&bpaydate2=${map.bpaydate2}">
	<div id="detail2">
		<div id="searchBox2">
			<!-- 검색박스 -->
			<table class="table table-bordered">
				<tr>
					<th scope="col" rowspan="3" style="background-color: silver; text-align: center;padding-top: 65px;" width="250">주문조회</th>
					<td><input type="radio" name="field2" value="all" class="field_menu2"
						<c:if test="${map.field2=='all' || map.field2==null || map.field2==''}">checked</c:if>>전체
						<input type="radio" name="field2" value="obname" class="field_menu2"
						<c:if test="${map.field2=='obname'}">checked</c:if>>상품명
						<input type="radio" name="field2" value="mname" class="field_menu2"
						<c:if test="${map.field2=='mname'}">checked</c:if>>주문인
						<input type="radio" name="field2" value="receiver" class="field_menu2"
						<c:if test="${map.field2=='receiver'}">checked</c:if>>수령인
					</td>
				</tr>
				<tr>
					<td><input type="radio" name="bpaydate2" value="1" class="borderdate2"
						<c:if test="${map.bpaydate2==1 || map.bpaydate2==null || map.bpaydate2==''}">checked</c:if>>전체
						<input type="radio" name="bpaydate2" value="2" class="borderdate2"
						<c:if test="${map.bpaydate2==2}">checked</c:if>>결제일&nbsp;&nbsp;&nbsp;
						<input type="date" name="startDay2" value="${map.startDay2 }"
						<c:if test="${map.bpaydate2==1 }">disabled</c:if>><span>&nbsp;~</span>
						<input type="date" name="endDay2" value="${map.endDay2 }"
						<c:if test="${map.bpaydate2==1 }">disabled</c:if>></td>
				</tr>
				<tr>
					<td><input type="text" name="keyword2" class="form-control" id="keyword_menu2"
						placeholder="검색어를 입력하세요."
						<c:if test="${keyword2!=null || keyword2 !=''}">value="${map.keyword2}"</c:if>>
						<!-- 버튼 -->
						<input type="submit" value="검색" class="btn btn-success" id="slaesListbt2">
						<input type="button" value="검색조건 초기화" id="resetBt2" class="btn btn-secondary"></td>
				</tr>
			</table>
		</div>
		<!-- 리스트 -->
		<div class="card">
			<div class="card-header"><img src="${cp }/resources/jh/jhimages/tableicon.png" id="tableicon">판매관리 리스트</div>
			<div class="card-body">
				<table class="table table-bordered">
			<thead class="thead-dark">
				<tr class="toptr">
					<th scope="col" width="60" rowspan="2">NO</th>
					<th scope="col" width="100" rowspan="2">주문번호</th>
					<th scope="col" width="400">상품정보</th>
					<th scope="col">상품합계</th>
					<th scope="col" rowspan="2">총 합계</th>
					<th scope="col" rowspan="2" width="120">결제일</th>
					<th scope="col" rowspan="2" width="120">출고처리</th>
				</tr>
				<tr class="toptr">
					<th scope="col">출고정보</th>
					<th scope="col">배송비</th>
				</tr>
			</thead>
			<c:forEach var="vo" items="${list2 }" varStatus="status">
				<tr>
					<td scope="col" width="60" rowspan="2" style="text-align: center">
						${pu.totalRowCount - ((pu.pageNum-1) * 5 + status.index)}
					</td>
					<td scope="col" width="100" rowspan="2" style="text-align: center">${vo.bpaynum }</td>
					<td scope="col" width="400">
						<c:forEach var="book" items="${vo.sellerOldbooksVo }">
							▶상품명 : ${book.obname } | 수량 : 1개 | 상품금액 : ${book.obsaleprice }원<br>
						</c:forEach>
					</td>
					<td scope="col" style="text-align: right;" >${vo.bfinalmoney }원</td>
					<td scope="col" rowspan="2" style="text-align: right;">${vo.ordermoney } 원</td>
					<td scope="col" rowspan="2" style="text-align: center">
						<fmt:formatDate value="${vo.bpaydate }" pattern="yyyy-MM-dd"/>
					</td> 
					<td scope="col" rowspan="2" width="120" style="text-align: center;">
						<button type="button" class="btn btn-success" onclick="sendInfo(${vo.bpaynum})">출고처리</button>
					</td>
				</tr>
				<tr>
					<td scope="col">
						주문인/수령인 : ${vo.mname } / ${vo.receiver }<br>
						연락처 : ${vo.bphone } <br>
						<span class="addr">배송주소 : ${vo.baddr }</span>
					</td>
					<td scope="col" style="text-align: right;">${vo.delfee }원</td>
				</tr>
			</c:forEach>
			
		</table>
		<!-- 페이징버튼 -->
		<div>
			<ul class="pagination justify-content-center">
				<!-- 이전버튼  -->
				<c:if test="${pu.startPageNum>3 }">
					<li class="page-item"><a class="page-link"
						href="${cp}/seller/salesManagement2?
									pageNum=${pu.startPageNum-1}&tabType=2&keyword2=${map.keyword2}&startDay2=${map.startDay2}&
									endDay2=${map.endDay2}&field2=${map.field2}&bpaydate2=${map.bpaydate2}">
							이전</a></li>
				</c:if>
				<c:forEach var="i" begin="${pu.startPageNum }"
					end="${pu.endPageNum}">
					<li class="page-item"><a class="page-link"
						href="${cp}/seller/salesManagement2?pageNum=${i}&tabType=2
									&keyword2=${map.keyword2}&startDay2=${map.startDay2}&endDay2=${map.endDay2}&field2=${map.field2}&bpaydate2=${map.bpaydate2}">${i}</a></li>
				</c:forEach>
				<!-- 다음버튼 --> 
				<c:if test="${pu.totalPageCount>pu.endPageNum}">
					<li class="page-item"><a class="page-link"
						href="${cp}/seller/salesManagement2?pageNum=${pu.endPageNum+1}&tabType=2
									&keyword2=${map.keyword2}&startDay2=${map.startDay2}
									&endDay2=${map.endDay2}&field2=${map.field2}&bpaydate2=${map.bpaydate2}">
							다음</a></li>
				</c:if>
			</ul>
		</div>
				
			</div>
		</div>
	</div>
</form>
<script>
	//출고처리버튼
	function sendInfo(bpaynum) {
		var result=confirm('출고처리 하시겠습니까?');
		if(result==true){
			location.href="${cp }/seller/salesManagement2/shipping?bpaynum="+bpaynum;
		}else{
			return;
		}
	}


	$(function(){
		//주소
		$(".addr").each(function(i, e) {
			var str=$(this).text();
			str=str.replace(/\|/gi,' ');
			$(this).text(str);
		});
		
		$("input:radio[name=bpaydate2]").click(function(){
			if($("input[name=bpaydate2]:checked").val()=='2'){
				$("input[name=startDay2]").attr("disabled",false);
				$("input[name=endDay2]").attr("disabled",false);
			}
			if($("input[name=bpaydate2]:checked").val()=='1'){
				$("input[name=startDay2]").attr("disabled",true);
				$("input[name=endDay2]").attr("disabled",true);
			}
		});
		//초기화버튼
		$("#resetBt2").click(function() {
			$("input[name=field2]")[0].checked=true;
			$("input[name=bpaydate2]")[0].checked=true;
			$("input[name=startDay2]").attr("disabled",true);
			$("input[name=startDay2]").val("");
			$("input[name=endDay2]").attr("disabled",true);
			$("input[name=endDay2]").val("");
			$("input[name=keyword2]").val("");
		});
		$("form").submit(function() {
			//일자별 검색 유효성검사1
			if($("input[name=bpaydate2]:checked").val()=='2'){
				if($("input[name=startDay2]").val()==''){
					alert('시작 날짜를 입력해주세요.');
					return false;
				}
			}
			if($("input[name=bpaydate2]:checked").val()=='2'){
				if($("input[name=endDay2]").val()==''){
					alert('종료 날짜를 입력해주세요.');
					return false;
				}
			}
					
			//날짜 검색시 유효성검사2
			var startDay=$("input[name=startDay2]").val();
			var endDay=$("input[name=endDay2]").val();
			var startArr=startDay.split('-');
			var endArr=endDay.split('-');
			var start=startArr[0]+startArr[1]+startArr[2];
			var end=endArr[0]+endArr[1]+endArr[2];
			if(start>end){
				alert('검색 날짜를 올바르게 입력해주세요.');
				return false;
			}
		});
	});
		
</script>