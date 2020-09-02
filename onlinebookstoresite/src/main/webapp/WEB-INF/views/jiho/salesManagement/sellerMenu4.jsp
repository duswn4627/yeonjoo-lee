<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>
/*배송중/구매확정전 css*/
#detail4 {
	height: 1000px;
}

.toptr {
	text-align: center;
}

#detail4 table .toptr {
	height: 30px;
	background-color: silver;
}

#searchBox4 {
	width: 1200px;
	height: 200px;
}

.borderdate4 {
	margin-left: 20px;
	margin-right: 10px;
}

#keyword_menu4{
	margin-left: 20px;
	width: 400px;
	display: inline;
}

#slaesListbt4 {
	margin-left: 10px;
	margin-right: 10px;
}

.field_menu4 {
	margin-right: 10px;
	margin-left: 20px;
}
</style>
<form action="${cp }/seller/salesManagement4?tabType=4&keyword4=${map.keyword4}&startDay4=${map.startDay4}&
							endDay4=${map.endDay4}&field4=${map.field4}&bpaydate4=${map.bpaydate4}">
	<div id="detail4">
		<div id="searchBox4">
			<!-- 검색박스 -->
			<table class="table table-bordered">
				<tr>
					<th scope="col" rowspan="3" style="background-color: silver;text-align: center;padding-top: 65px;" width="250">주문조회</th>
					<td><input type="radio" name="field4" value="all" class="field_menu4"
						<c:if test="${map.field4=='all' || map.field4==null || map.field4==''}">checked</c:if>>전체
						<input type="radio" name="field4" value="obname" class="field_menu4"
						<c:if test="${map.field4=='obname'}">checked</c:if>>상품명
						<input type="radio" name="field4" value="mname" class="field_menu4"
						<c:if test="${map.field4=='mname'}">checked</c:if>>주문인
						<input type="radio" name="field4" value="receiver" class="field_menu4"
						<c:if test="${map.field4=='receiver'}">checked</c:if>>수령인
					</td>
				</tr>
				<tr>
					<td><input type="radio" name="bpaydate4" value="1" class="borderdate4"
							<c:if test="${map.bpaydate4==1 || map.bpaydate4==null || map.bpaydate4==''}">checked</c:if>>전체
						<input type="radio" name="bpaydate4" value="2" class="borderdate4"
							<c:if test="${map.bpaydate4==2}">checked</c:if>>결제일&nbsp;&nbsp;&nbsp;
						<input type="date" name="startDay4" value="${map.startDay4 }"
							<c:if test="${map.bpaydate4==1 }">disabled</c:if>><span>&nbsp;~</span>
						<input type="date" name="endDay4" value="${map.endDay4 }"
							<c:if test="${map.bpaydate4==1 }">disabled</c:if>></td>
				</tr>
				<tr>
					<td><input type="text" name="keyword4" class="form-control" id="keyword_menu4"
						placeholder="검색어를 입력하세요."
						<c:if test="${keyword4!=null || keyword4 !=''}">value="${map.keyword4}"</c:if>>
						<!-- 버튼 -->
						<input type="submit" value="검색" class="btn btn-success" id="slaesListbt4">
						<input type="button" value="검색조건 초기화" id="resetBt4" class="btn btn-secondary"></td>
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
							<th scope="col" width="50" rowspan="2">NO</th>
							<th scope="col" width="100" rowspan="2">주문번호</th>
							<th scope="col" width="400" rowspan="2">상품정보</th>
							<th scope="col" rowspan="2" width="120">결제일</th>
							<th scope="col">상품합계</th>
							<th scope="col" rowspan="2">총 합계</th>
							<th scope="col" rowspan="2" width="120">수수료</th>
							<th scope="col" rowspan="2" width="120">지급<br>예정금액</th>
						</tr>
						<tr class="toptr">
							
							<th scope="col">배송비</th>
						</tr>
					</thead>
					 
					<c:forEach var="vo" items="${list4 }" varStatus="status">
						<tr>
							<td scope="col" width="60" rowspan="2" style="text-align: center">
								${pu.totalRowCount - ((pu.pageNum-1) * 5 + status.index)}
							</td>
							<td scope="col" width="100" rowspan="2" style="text-align: center">${vo.bpaynum }</td>
							<td scope="col" width="400" rowspan="2" style="text-align: left;">
								<c:forEach var="book" items="${vo.sellerOldbooksVo }">
									▶상품명 : ${book.obname } | 수량 : 1개 | 상품금액 : ${book.obsaleprice }원<br>
								</c:forEach>
							</td>
							<td scope="col" rowspan="2" width="120" style="text-align: center">
								<fmt:formatDate value="${vo.bpaydate }" pattern="yyyy-MM-dd"/>
							</td>
							<td scope="col" style="text-align: right;">${vo.bfinalmoney}원</td>
							<td scope="col" rowspan="2" style="text-align: right;">${vo.ordermoney}원</td>
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
							<li class="page-item"><a class="page-link"
								href="${cp}/seller/salesManagement4?
											pageNum=${pu.startPageNum-1}&tabType=4&keyword4=${map.keyword4}&startDay4=${map.startDay4}&
											endDay4=${map.endDay4}&field4=${map.field4}&bpaydate4=${map.bpaydate4}">
									이전</a></li>
						</c:if>
						<c:forEach var="i" begin="${pu.startPageNum }"
							end="${pu.endPageNum}">
							<li class="page-item"><a class="page-link"
								href="${cp}/seller/salesManagement4?pageNum=${i}&tabType=4
											&keyword4=${map.keyword4}&startDay4=${map.startDay4}&endDay4=${map.endDay4}&field4=${map.field4}&bpaydate4=${map.bpaydate4}">${i}</a></li>
						</c:forEach>
						<!-- 다음버튼 --> 
						<c:if test="${pu.totalPageCount>pu.endPageNum}">
							<li class="page-item"><a class="page-link"
								href="${cp}/seller/salesManagement4?pageNum=${pu.endPageNum+1}&tabType=4
											&keyword4=${map.keyword4}&startDay4=${map.startDay4}
											&endDay4=${map.endDay4}&field4=${map.field4}&bpaydate4=${map.bpaydate4}">
									다음</a></li>
						</c:if>
					</ul>
				</div>
				</div>
		</div>
	</div>
</form>
<script>
	$(function(){
		//주소
		$(".addr").each(function(i, e) {
			var str=$(this).text();
			str=str.replace(/\|/gi,' ');
			$(this).text(str);
		});
		
		$("input:radio[name=bpaydate4]").click(function(){
			if($("input[name=bpaydate4]:checked").val()=='2'){
				$("input[name=startDay4]").attr("disabled",false);
				$("input[name=endDay4]").attr("disabled",false);
			}
			if($("input[name=bpaydate4]:checked").val()=='1'){
				$("input[name=startDay4]").attr("disabled",true);
				$("input[name=endDay4]").attr("disabled",true);
			}
		});
		//초기화버튼
		$("#resetBt4").click(function() {
			$("input[name=field4]")[0].checked=true;
			$("input[name=bpaydate4]")[0].checked=true;
			$("input[name=startDay4]").attr("disabled",true);
			$("input[name=startDay4]").val("");
			$("input[name=endDay4]").attr("disabled",true);
			$("input[name=endDay4]").val("");
			$("input[name=keyword4]").val("");
		});
		$("form").submit(function() {
			//일자별 검색 유효성검사1
			if($("input[name=bpaydate4]:checked").val()=='2'){
				if($("input[name=startDay4]").val()==''){
					alert('시작 날짜를 입력해주세요.');
					return false;
				}
			}
			if($("input[name=bpaydate4]:checked").val()=='2'){
				if($("input[name=endDay4]").val()==''){
					alert('종료 날짜를 입력해주세요.');
					return false;
				}
			}
					
			//날짜 검색시 유효성검사2
			var startDay=$("input[name=startDay4]").val();
			var endDay=$("input[name=endDay4]").val();
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