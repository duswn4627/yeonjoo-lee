<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- The Modal -->

    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title pageTitle">취소 처리 상세정보</h4>
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
						<th class="table-active">주문자 이름</th>
						<th class="table-active">주문 일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${List}">
						<input type="hidden" value = ${vo.mnum } id = "mnum">
						<tr>
							<td id="bpaynum">${vo.bpaynum }</td>							
							<td id = "mname">${vo.mname }</td>							
							<td> <fmt:formatDate value="${vo.borderdate }" pattern="yyyy-MM-dd"/> </td>							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			
			<h5>
				주문 상품
			</h5>
			<table class="table">
				<thead>
					<tr>
						<th class="table-active">책번호</th>
						<th class="table-active">책이름</th>
						<th class="table-active">수량</th>
						<th class="table-active">판매가격</th>
						<th class="table-active">배송비</th>
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
									<td></td>
								</tr>
						</c:forEach>
						<tr>
							<td colspan="5" align="right">${vo.delfee }</td>
							<td colspan="1" align="right">${vo.ordermoney}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<h5>
				취소 리스트
			</h5>
			<table class="table">
				<thead>
					<tr>
						<th class="table-active">책번호</th>
						<th class="table-active">책이름</th>
						<th class="table-active">수량</th>
						<th class="table-active">판매가격</th>
						<th class="table-active">배송비</th>
						<th class="table-active">취소 가격</th>
						<th class="table-active">총 취소 예상 가격</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${List}">
						<c:forEach items="${vo.CSAndPaymentBook}" var="book">
							<c:if test="${book.type == 1 }">
								<tr>
									<td>${book.bnum}</td>
									<td>${book.btitle}</td>
									<td>${book.count}</td>
									<td>${book.bprice}</td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</c:if>
						</c:forEach>
						
					<tr>
						<td colspan="5" align="right">${vo.delfee }</td>
						<td colspan="1" align="right" >${cancelPrice }</span></td>
						<td colspan="1" align="right" id = "cancelPrice"><span style = "color : red">${cancelPrice+vo.delfee }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="row">
			<div class="col-md-12">
			<h5>
				취소 리스트
			</h5>
			<table class="table table-bordered">
					<tr>
						<th class="table-active">회수 포인트</th>
						<td id = "cancelPoint">${cancelPoint }</td>
					</tr>
			</table>
			
			 
			<button type="button" class="btn btn-success btn-md" id = "applyBtn">승인</button>
<!-- 			<button type="button" class="btn btn-success btn-md">반려</button> -->

		</div>
	</div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
   
<script type="text/javascript">
	
	$("#applyBtn").click(function () {
		
		alert( $("#mnum").val());
		
		$.ajax({
			url : "${pageContext.request.contextPath}/cs/cancelapproval",
			dataType : "json",
			data : {mnum : $("#mnum").val(), bpaynum : $('#bpaynum').text(), cancelPrice : $('#cancelPrice').text(),
				cancelPoint :  $('#cancelPoint').text()},
			success : function(data){
				if(data.code == "success"){
					alert("처리 성공 하셨습니다.");
					location.href = "${pageContext.request.contextPath}/cs/menu?PageName=1";
				}else{
					alert("처리 실패 하셨습니다.")					
				}
			}
		})		
	})

</script>
    
    