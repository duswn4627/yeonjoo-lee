<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>


</style>
<script type="text/javascript"
	src="${cp }/resources/jh/js/jquery-3.2.1.min.js"></script>
<form
	action="${cp }/seller/salesManagement?tabType=1&keyword1=${map.keyword1}&startDay=${map.startDay}&
							endDay=${map.endDay}&field1=${map.field1}&borderdate1=${map.borderdate1}">
	<div id="detail1">
		<div id="searchBox1">
			<!-- 검색박스 -->
			<table class="table table-bordered">
				<tr>
					<th scope="col" rowspan="3" style="background-color: silver; text-align: center;padding-top: 65px;"
						width="250">주문조회</th>
					<td><input type="radio" name="field1" value="all"
						<c:if test="${map.field1=='all' || map.field1==null || map.field1==''}">checked</c:if>>전체
						<input type="radio" name="field1" value="obname"
						<c:if test="${map.field1=='obname'}">checked</c:if>>상품명 <input
						type="radio" name="field1" value="mname"
						<c:if test="${map.field1=='mname'}">checked</c:if>>주문인 <input
						type="radio" name="field1" value="receiver"
						<c:if test="${map.field1=='receiver'}">checked</c:if>>수령인
					</td>
				</tr>
				<tr>
					<td><input type="radio" name="borderdate1" value="1"
						<c:if test="${map.borderdate1==1 || map.borderdate1==null || map.borderdate1==''}">checked</c:if>>전체
						<input type="radio" name="borderdate1" value="2"
						<c:if test="${map.borderdate1==2}">checked</c:if>>주문일&nbsp;&nbsp;&nbsp;
						<input type="date" name="startDay" value="${map.startDay }"
						<c:if test="${map.borderdate1==1 }">disabled</c:if>><span>&nbsp;~</span>
						<input type="date" name="endDay" value="${map.endDay }"
						<c:if test="${map.borderdate1==1 }">disabled</c:if>></td>
				</tr>
				<tr>
					<td><input type="text" name="keyword1" class="form-control"
						placeholder="검색어를 입력하세요."
						<c:if test="${keyword1!=null || keyword1 !=''}">value="${map.keyword1}"</c:if>>
						<!-- 버튼 --> <input type="submit" value="검색"
						class="btn btn-success" id="slaesListbt1"> <input
						type="button" value="검색조건 초기화" id="resetBt1"
						class="btn btn-secondary"></td>
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
							<th scope="col" rowspan="2" width="400">상품정보</th>
							<th scope="col">주문인</th>
							<th scope="col">총 주문금액</th>
							<th scope="col" rowspan="2">총 합계</th>
							<th scope="col" rowspan="2">주문일</th>
						</tr>
						<tr class="toptr">
							<th scope="col">수령인</th>
							<th scope="col">배송비</th>
						</tr>
					</thead>
					<c:forEach var="vo" items="${list1 }" varStatus="status">
						<tr>
							<th scope="col" width="60" rowspan="2"
								style="text-align: center;">${pu.totalRowCount - ((pu.pageNum-1) * 5 + status.index)}</th>
							<th scope="col" width="100" rowspan="2"
								style="text-align: center;">${vo.bpaynum }</th>
							<th scope="col" rowspan="2" width="400"><c:forEach
									var="oldbook" items="${vo.sellerOldbooksVo }">
								▶ 상품명 : ${oldbook.obname } | 수량 : 1개 | 판매가 : ${oldbook.obsaleprice }원 <br>
								</c:forEach></th>
							<th scope="col" style="text-align: center; margin: auto;">${vo.mname }</th>
							<th scope="col" style="text-align: right;">${vo.bfinalmoney }원</th>
							<th scope="col" rowspan="2"
								style="text-align: right; margin: auto;">${vo.ordermoney }원</th>
							<th scope="col" rowspan="2" style="text-align: center;"><fmt:formatDate
									value="${vo.borderdate }" pattern="yyyy-MM-dd" /></th>
						</tr>
						<tr>
							<th scope="col" style="text-align: center;">${vo.receiver }</th>
							<th scope="col" style="text-align: right;">${vo.delfee }원</th>
						</tr>
					</c:forEach>
				</table>
				<!-- 페이징버튼 -->
				<div>
					<ul class="pagination justify-content-center">
						<!-- 이전버튼 -->
						<c:if test="${pu.startPageNum>3 }">
							<li class="page-item"><a class="page-link"
								href="${cp}/seller/salesManagement?
										pageNum=${pu.startPageNum-1}&tabType=1&keyword1=${map.keyword1}&startDay=${map.startDay}&
										endDay=${map.endDay}&field1=${map.field1}&borderdate1=${map.borderdate1}">
									이전</a></li>
						</c:if>
						<c:forEach var="i" begin="${pu.startPageNum }"
							end="${pu.endPageNum}">
							<li class="page-item"><a class="page-link"
								href="${cp}/seller/salesManagement?pageNum=${i}&tabType=1
										&keyword1=${map.keyword1}&startDay=${map.startDay}&endDay=${map.endDay}&field1=${map.field1}&borderdate1=${map.borderdate1}">${i}</a></li>
						</c:forEach>
						<!-- 다음버튼 -->
						<c:if test="${pu.totalPageCount>pu.endPageNum}">
							<li class="page-item"><a class="page-link"
								href="${cp}/seller/salesManagement?pageNum=${pu.endPageNum+1}&tabType=1
										&keyword1=${map.keyword1}&startDay=${map.startDay}
										&endDay=${map.endDay}&field1=${map.field1}&borderdate1=${map.borderdate1}">
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
		$("input:radio[name=borderdate1]").click(function(){
			if($("input[name=borderdate1]:checked").val()=='2'){
				$("input[name=startDay]").attr("disabled",false);
				$("input[name=endDay]").attr("disabled",false);
			}
			if($("input[name=borderdate1]:checked").val()=='1'){
				$("input[name=startDay]").attr("disabled",true);
				$("input[name=endDay]").attr("disabled",true);
			}
		});
		//초기화버튼
		$("#resetBt1").click(function() {
			$("input[name=field1]")[0].checked=true;
			$("input[name=borderdate1]")[0].checked=true;
			$("input[name=startDay]").attr("disabled",true);
			$("input[name=startDay]").val("");
			$("input[name=endDay]").attr("disabled",true);
			$("input[name=endDay]").val("");
			$("input[name=keyword1]").val("");
		});
		$("form").submit(function() {
			//일자별 검색 유효성검사1
			if($("input[name=borderdate1]:checked").val()=='2'){
				if($("input[name=startDay]").val()==''){
					alert('시작 날짜를 입력해주세요.');
					return false;
				}
			}
			if($("input[name=borderdate1]:checked").val()=='2'){
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