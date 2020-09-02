<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- The Modal -->

<div class="modal-content">

	<!-- Modal Header -->
	<div class="modal-header">
		<h4 class="modal-title pageTitle">반품 처리 상세정보</h4>
		<button type="button" class="close" data-dismiss="modal">&times;</button>
	</div>

	<!-- Modal body -->
	<div class="modal-body">
		<div class="row">
			<div class="col-md-12">

				<table class="table">
					<thead>
						<tr>
							<th class="table-active">주문번호</th>
							<th class="table-active">주문 일자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${List}">
							<tr>
								<td id="bpaynum">${vo.bpaynum }</td>
								<td><fmt:formatDate value="${vo.borderdate }"
										pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h5>주문 상품</h5>
				<table class="table">
					<thead>
						<tr>
							<th class="table-active">책번호</th>
							<th class="table-active">책이름</th>
							<th class="table-active">수량</th>
							<th class="table-active">판매가격</th>
							<th class="table-active">총 적립 포인트</th>
							<th class="table-active">총 가격</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${List}">
							<c:set var = "totalpoint" value = "0"/>
							<c:forEach items="${vo.CSAndPaymentBook}" var="book">
								<c:set var = "totalpoint" value = "${totalpoint+book.point }"/>
								<tr>
									
									<td>${book.bnum}</td>
									<td>${book.btitle}</td>
									<td>${book.bcount}</td>
									<td>${book.bprice}</td> 
									<td></td>
									<td></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="5" align="right">
									<c:out value="${totalpoint }"/>
								</td>
								<td colspan="1" align="right">${vo.ordermoney}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<h5>반품 상품</h5>
				<table class="table">
					<thead>
						<tr>
							<th class="table-active"><input type = "checkbox" ></th>
							<th class="table-active">책번호</th>
							<th class="table-active">책이름</th>
							<th class="table-active">수량</th>
							<th class="table-active">판매가격</th>
							<th class="table-active">포인트 적립금</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="price" value="0" />
						<c:forEach var="vo" items="${List}">
							<c:set var = "returnPrice" value = "0"/>
							<c:set var="length" value="${fn:length(vo.CSAndPaymentBook) }"/>
							<c:set var="statusCount" value = "0"/>
							<c:forEach items="${vo.CSAndPaymentBook}" var="book">
								<c:if test="${book.type == 2 }">
									<tr>
										<c:set var="returnPrice" value = "${returnPrice + (book.bprice*book.count) }"/>
										<td>
											<input type="checkbox" <c:if test = "${book.status == 2 }"><c:set var = "statusCount" 
											value = "${statusCount + 1}"/>disabled</c:if>>
											<input type="hidden" name = "paymentbook_num"value="${book.paymentbook_num}">										
										</td>
										<td>${book.paymentbook_num} ${book.bnum}</td>
										<td>${book.btitle}</td>
										<td>${book.count}</td>
										<td>${book.bprice}</td>
										<td><c:out value = "${book.point/book.bcount}"/></td>
									</tr>
								</c:if>
							</c:forEach>
									<tr>
										<td colspan="6" align="right">
											<button type="button" class="btn btn-success btn-md" <c:if test = "${count == statusCount}">disabled</c:if>
												onclick = "clickPickupBtn(${length},${count })" id="pickupBtn">
												수거 완료
											</button>
										</td>
									</tr>
						</c:forEach>
					</tbody>
				</table>

			
				<h5>수거 배송 정보</h5>
				<table class="table">
					<thead>
						<tr>
							<th class="table-active">수령인</th>
							<th class="table-active">전화번호</th>
							<th class="table-active">주소</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${List}">
							<tr>
								<td>${vo.receiver }</td>
								<td>${vo.bphone }</td>
								<td class = "addr">${vo.baddr }</td>
							</tr>					
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<h5>환불 방식</h5>
		<table class="table">
			<thead>
				<tr>
					<th class="table-active">환불 예정액</th>
					<th class="table-active">회수 포인트</th>
					<th class="table-active">예치금 반환 예상액</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<c:out value="${returnPrice}"/>
					</td>
					<td>
						${Point }					
					</td>
					<td>
						<c:out value="${returnPrice}"/>
					</td>
				</tr>
				<tr>
					<td colspan="3" align="right" >
						<button type="button" class="btn btn-success btn-md"
							id="giveBtn" onclick = "clickGiveBtn(${List[0].bpaynum },${returnPrice},${Point })">예치금 전달</button>
					</td>
				</tr>

			</tbody>
		</table>
	</div>

	<!-- Modal footer -->
	<div class="modal-footer">
		<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	</div>
</div>

<script type="text/javascript">
 
	function clickPickupBtn(length, count){
		var tdArr = new Array();
		var idxArr = new Array();
		var checkbox = $("input[type=checkbox]:checked");
		
// 		alert("길이 : " + checkbox.length);
			
		if(checkbox.length == 0){
			alert("수거한 상품을 체크를 해주세요..")
			return 
		}
		
		checkbox.each(function(i){
			// checkbox.parent() : checkbox의 부모는 <td>이다.
			// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			var idx = tr.index();
		
			// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
			var no = $("input[name=paymentbook_num]").eq(idx).val();
	
			if(no != "책번호"){
				tdArr.push(no);					
				idxArr.push(i);
			}
			
		})
 		ajpickUpfunction(length,tdArr,idxArr, count);
	} 
 
	function clickGiveBtn(bpaynum, returnPrice, point){
		if($("#pickupBtn").prop("disabled")){
			ajGivefunction(bpaynum,returnPrice, point);
		}else{
			alert("먼저 수거 확인 부터 해주세요~");
		}
	}
	
	
	function ajpickUpfunction(length,paymentbookNum,idxArr,count){
		
		$.ajax({
			url : "${pageContext.request.contextPath}/cs/returnPickup",
			dataType : "json",
			data : {paymentbookNum : paymentbookNum},
			success : function(data){
				if(data.code == "success"){
					alert("처리 성공 하셨습니다.");
					
					 $("input[type=checkbox]:checked").each(function(i){
						 $(this).prop("disabled","disabled")
					 })
					 if($("input[type=checkbox]:disabled").length == count){
						 $("#pickupBtn").prop("disabled","disabled")
					 }
				}else{
					alert("처리 실패 하셨습니다.");					
				}
			}
		})		
	}
	
	function ajGivefunction(bpaynum,returnPrice, point){
		console.log(bpaynum);
		
		var paybookArr = new Array();
		$("input[name=paymentbook_num]").each(function(i){
			paybookArr.push($(this).val());
		})
		
		console.log(paybookArr);
		
		$.ajax({
			url : "${pageContext.request.contextPath}/cs/doReturn",
			dataType : "json",
			data : {bpaynum : bpaynum, paymentbookNum : paybookArr , returnPrice : returnPrice, point : point},
			success : function(data){
				if(data.code == "success"){
					alert("처리 성공 하셨습니다.");
					location.href = "${pageContext.request.contextPath}/cs/menu?PageName=2";
				}else{
					alert("처리 실패 하셨습니다.")					
				}
			}
		})	
	}
 		
	$(function(){
		$('.addr').each(function(idx,item){
			var addr = $(this).text();
			addr =  addr.replace(/\|/g, ' ');
			$(this).text(addr);			
		})
	})	

</script>

