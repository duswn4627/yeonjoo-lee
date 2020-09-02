<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>
/*===============정산조회 관련메뉴 css===============*/
#settlementContent{
	width: 1300px;
	height: 1300px;
	margin: auto;
}	
/*검색박스*/
#settlementSearchBox{
	height: 230px;
	width: 1300px;
	
}
#settlementTable tr th{
	background-color: silver;
	width: 300px;	
}
.bocomstatus{
	margin-left: 10px;
	margin-right: 10px;
}
.setdate{
	margin-left: 10px;
	margin-right: 10px;
}


/*정산안내박스*/
#moneyInfoBox{
	width: 1100px;
	height: 80px;
	background-color: #CADCC6;
	margin: auto;
	padding: 15px;
	border-radius: 15px;
}
/*검색 리스트*/
#settlementList{
	width: 1250px;
	height: 800px;
}

</style>
<div id="settlementContent">
<h2><img src="${cp }/resources/jh/jhimages/정산조회_1.png"></h2>
	<form action="${cp }/seller/settlementCheck">
		<div id="settlementSearchBox">
			<table class="table table-bordered" id="settlementTable"> 
				<tr>
					<th rowspan="3" style="text-align: center;">판매 정산조회</th>
				</tr>
				<tr>
					<td>
						<input type="radio" name="bocomstatus" value="3" class="bocomstatus"
							<c:if test="${map.bocomstatus=='3' || map.bocomstatus==null || map.bocomstatus==''}">checked</c:if>>전체
						<input type="radio" name="bocomstatus" value="0" class="bocomstatus"
							<c:if test="${map.bocomstatus=='0'}">checked</c:if>>정산중
						<input type="radio" name="bocomstatus" value="1" class="bocomstatus"
							<c:if test="${map.bocomstatus=='1'}">checked</c:if>>정산완료
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="feedate" value="all" class="setdate"
							<c:if test="${map.feedate=='all' || map.feedate==null || map.feedate==''}">checked</c:if>>전체
						<input type="radio" name="feedate" value="date" class="setdate"
							<c:if test="${map.feedate=='date'}">checked</c:if>>일자별
						<input type="date" name="startDay" style="margin-left: 10px" value="${map.startDay }"
							<c:if test="${map.feedate=='all' || map.feedate==null || map.feedate==''}">disabled</c:if>><span>&nbsp;~</span>
						<input type="date" name="endDay" value="${map.endDay }"
							<c:if test="${map.feedate=='all' || map.feedate==null || map.feedate==''}">disabled</c:if>>
						<input type="submit" value="검색" class="btn btn-success"	id="settlementBt">
						<input type="button" value="검색조건 초기화" id="settlementResetBt"	class="btn btn-secondary">
					</td>
				</tr>
			</table>
			<div id="moneyInfoBox">
				<span>* 정산은 배송후 수령자가 구매확정을 한 후 정산처리가 이루어 집니다.</span><br>
				<span>* 정산 금액은 예치금으로 지급되며 지급된 예치금은 마이페이지에서 계좌로 신청 가능합니다.</span>
			</div>
		</div>
		<!-- 테이블 -->
		<div class="card">
			<div class="card-header"><img src="${cp }/resources/jh/jhimages/tableicon.png" id="tableicon">판매관리 리스트</div>
			<div class="card-body">
					<div id="settlementList">
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr style="text-align: center;">
					<th scope="col" width="60" rowspan="2">NO</th>
					<th scope="col" width="100" rowspan="2">주문번호</th>
					<th scope="col" width="380" rowspan="2">상품정보</th>
					<th scope="col" rowspan="2" width="120">구매확정일</th>
					<th scope="col" rowspan="2" width="140">처리상태</th>
					<th scope="col">판매금액</th>
					<th scope="col" rowspan="2">총 합계</th>
					<th scope="col" rowspan="2" width="120">수수료(-)</th>
					<th scope="col" rowspan="2" width="120">지급총액</th>
				</tr>
				<tr style="text-align: center;">
					<th scope="col">배송비</th>
				</tr>
			</thead>
			<c:forEach var="vo" items="${list }" varStatus="status">
				<tr>
					<td scope="col" width="60" rowspan="2" style="text-align: center;">
						${pu.totalRowCount - ((pu.pageNum-1) * 5 + status.index)}
					</td>
					<td scope="col" width="100" rowspan="2" style="text-align: center;">
						${vo.bpaynum }
					</td>
					<td scope="col" width="380" rowspan="2" style="text-align: left;">
						<c:forEach var="book" items="${vo.sellerOldbooksVo }">
							▶상품명 : ${book.obname } | 수량 : 1개 | 상품금액 : ${book.obsaleprice }원<br>
						</c:forEach>
					</td>
					<td scope="col" rowspan="2" width="120" style="text-align: center;">
						<fmt:formatDate value="${vo.feedate }" pattern="yyyy-MM-dd"/>
					</td>
					<td scope="col" rowspan="2" width="140" style="text-align: center;">
						<c:if test="${vo.bocomstatus=='0' }">
							<span class="badge badge-secondary">처리중</span>
						</c:if>
						<c:if test="${vo.bocomstatus=='1' }">
							<span class="badge badge-success">정산완료</span>
						</c:if>
					</td>
					<td scope="col" style="text-align: right;">${vo.bfinalmoney }원</td>
					<td scope="col" rowspan="2" style="text-align: right;">${vo.ordermoney }원</td>
					<td scope="col" rowspan="2" width="120" style="text-align: right;">${vo.feepay }원</td>
					<td scope="col" rowspan="2" width="120" style="text-align: right;">${vo.settlement }원</td>
				</tr>
				<tr>
					<td scope="col" style="text-align: right;">${vo.delfee }원</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 페이징버튼 -->
			<div>
				<ul class="pagination justify-content-center">
					<!-- 이전버튼  -->
					<c:if test="${pu.startPageNum>3 }">
						<li class="page-item">
							<a class="page-link" href="${cp }/seller/settlementCheck?pageNum=${pu.startPageNum-1}
							&bocomstatus=${map.bocomstatus}&feedate=${map.feedate}&startDay=${map.startDyay}
							&endDay=${map.endDay}">이전</a>
						</li>
					</c:if>
					<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum}">
						<li class="page-item">
							<a class="page-link" href="${cp }/seller/settlementCheck?pageNum=${i}&bocomstatus=${map.bocomstatus}
							&feedate=${map.feedate}&startDay=${map.startDyay}&endDay=${map.endDay}">
							${i}</a>
						</li>
					</c:forEach>
					<!-- 다음버튼 --> 
					<c:if test="${pu.totalPageCount>pu.endPageNum}">
						<li class="page-item">
							<a class="page-link" href="${cp }/seller/settlementCheck?pageNum=${pu.endPageNum+1}
							&bocomstatus=${map.bocomstatus}&feedate=${map.feedate}&startDay=${map.startDyay}
							&endDay=${map.endDay}">다음</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
		
			</div>
		</div>
		
	</form>
</div>
<script>
	$(function(){
		$("input:radio[name=feedate]").click(function(){
			if($("input[name=feedate]:checked").val()=='date'){
				$("input[name=startDay]").attr("disabled",false);
				$("input[name=endDay]").attr("disabled",false);
			}
			if($("input[name=feedate]:checked").val()=='all'){
				$("input[name=startDay]").attr("disabled",true);
				$("input[name=endDay]").attr("disabled",true);
			}
		});
		//초기화버튼
		$("#settlementResetBt").click(function() {
			$("input[name=feedate]")[0].checked=true;
			$("input[name=startDay]").attr("disabled",true);
			$("input[name=startDay]").val("");
			$("input[name=endDay]").attr("disabled",true);
			$("input[name=endDay]").val("");
			$("input[name=bocomstatus]")[0].checked=true;
		});
		$("form").submit(function() {
			//일자별 검색 유효성검사1
			if($("input[name=feedate]:checked").val()=='date'){
				if($("input[name=startDay]").val()==''){
					alert('시작 날짜를 입력해주세요.');
					return false;
				}
			}
			if($("input[name=feedate]:checked").val()=='date'){
				if($("input[name=endDay]").val()==''){
					alert('종료 날짜를 입력해주세요.');
					return false;
				}
			}
					
			//날짜 검색시 유효성검사2
			var startDay=$("input[name=startDay]").val();
			var endDay=$("input[name=endDay]").val();
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