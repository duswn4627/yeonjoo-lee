<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- The Modal -->

<div class="modal-content">

	<!-- Modal Header -->
	<div class="modal-header">
		<h4 class="modal-title pageTitle">교환 처리 상세정보</h4>
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
							<th class="table-active">총 가격</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${List}">
							<c:forEach items="${vo.CSAndPaymentBook}" var="book">
								<tr>
									<td>${book.bnum}</td>
									<td>${book.btitle}</td>
									<td>${book.bcount}</td>
									<td>${book.bprice}</td>
									<td></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="5" align="right">${vo.ordermoney}</td>
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

		<h5>교환 상품</h5>
		<table class="table">
			<thead>
				<tr>
					<th class="table-active">책번호</th>
					<th class="table-active">책이름</th>
					<th class="table-active">수량</th>
					<th class="table-active">판매가격</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="price" value="0" />
				<c:forEach var="vo" items="${List}">
					<c:forEach items="${vo.CSAndPaymentBook}" var="book">
						<c:if test="${book.type == 3 }">
							<tr>
								<td class = "paymentbook_num" style = "display: none;">${book.paymentbook_num}</td>
								<td>${book.bnum}</td>
								<td>${book.btitle}</td>
								<td>${book.count}</td>
								<td>${book.bprice}</td>
							</tr>
						</c:if>
						<tr>
						<c:choose>
							<c:when test="${book.status == 1}">
								<td colspan="5" align="right">
									<button type="button" class="btn btn-success btn-md" id="okBtn" 
									onclick = "changeStatusClick(2,${book.paymentbook_num})">교환 처리</button>
								</td>
							</c:when>
							<c:when test="${book.status == 2}">			
								<td colspan="5" align="right">
									<button type="button" class="btn btn-success btn-md" id="pickUpBtn" 
									onclick = "changeStatusClick(3,${book.paymentbook_num})">수거 완료</button>
								</td>
							</c:when>
						</c:choose>
						</tr>		`		
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Modal footer -->
	<div class="modal-footer">
		<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	</div>
</div>

<script type="text/javascript">
	
	function changeStatusClick(level, paymentBookNum){
		doAjax(level, paymentBookNum);
	}

	function doAjax(level, paymentBookNum){
		
		var paymentBookNumArr = new Array();
		paymentBookNumArr.push(paymentBookNum);
		
		$.ajax({
			url : "${pageContext.request.contextPath}/cs/doExchange",
			dataType : "json",
			data : {paymentbookNum : paymentBookNumArr, level : level},
			success : function(data){
				if(data.code == "success"){
					alert("처리 성공 하셨습니다.");
					location.href = "${pageContext.request.contextPath}/cs/menu?PageName=3";
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

