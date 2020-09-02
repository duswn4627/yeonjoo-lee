<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fluid">
	<h2 class="mt-4 pageTitle" >주문 리스트</h2>
	<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table mr-1"></i>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered"  width="100%"
				cellspacing="0">
				<thead>
					<tr>
<!-- 						전체 취소 -->
						<th class="table-active">주문일(신청일)</th>
						<th class="table-active">주문번호</th>
						<th class="table-active">주문자</th>
						<th class="table-active">책 제목</th>
						<th class="table-active">수량</th>
						<th class="table-active">결제예정금액</th>
						<th class="table-active">결제 수단</th>
						<th class="table-active">처리상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td>
								<fmt:formatDate value = "${vo.borderdate}" pattern="yyyy-MM-dd"/>
							</td>
							<td id = "bpaynumId">${vo.bpaynum}</td>
							<td>${vo.mname }</td>
							<td>
								<c:forEach items="${vo.CSAndPaymentBook}" var="book">
									<p>${book.btitle}</p>
								</c:forEach>
							</td>
							<td>
								<c:forEach items="${vo.CSAndPaymentBook}" var="book">
									<p>${book.count}</p>
								</c:forEach>
							</td>
							<td>${vo.ordermoney }</td>
							<c:choose>
								<c:when test="${vo.methodpayment == 0}">
									<td>카드</td>
								</c:when>
								<c:otherwise>
									<td>무통장 입금</td>
								</c:otherwise>
							</c:choose>
							<td>
								<c:choose>
									<c:when test="${vo.bstatus == 5 || vo.bstatus == 6 }">
										<input class= "btn btn-secondary" type="button" value = "처리 완료" disabled="disabled"> 									
									</c:when>
									<c:otherwise>
										<input class= "btn btn-success" id = "openModal" type="button"  
										value = "신청 처리" onclick = "openModal1(${vo.bpaynum})">
									</c:otherwise>								
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="pagination justify-content-center">
			<!-- 페이징 -->
			<div id="listPaging">
				<c:choose>
					<c:when test="${pu.startPageNum > 1 }">
						<button onclick="location.href='${pageContext.request.contextPath }/cs/menu?PageName=${PageName }&pageNum=${pu.startPageNum - 1}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}&status=${status }'" 
							type="button" class="btn btn-outline-success">이전</button>
					</c:when>
				</c:choose>
	
				<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
					<c:choose>
						<c:when test="${i == pu.pageNum }">
								<button type="button" class="btn btn-success"
									onclick="location.href='${pageContext.request.contextPath }/cs/menu?PageName=${PageName }&pageNum=${i}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}&status=${status }'">${i }</button>
							</c:when>
						<c:otherwise>
							<button type="button" class="btn btn-outline-success" 
								onclick ="location.href='${pageContext.request.contextPath }/cs/menu?PageName=${PageName }&pageNum=${i}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}&status=${status }'">${i }</button>
						</c:otherwise>
					</c:choose>
				</c:forEach>
	
				<c:choose>
						<c:when test="${pu.totalPageCnt > pu.endPageNum }">
							<button
								onclick="location.href='${pageContext.request.contextPath }/cs/menu?PageName=${PageName }&pageNum=${pu.startPageNum + 1}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}&status=${status }'"
								type="button" class="btn btn-outline-success">다음</button>
						</c:when>
					</c:choose>
			</div>
		</div>
	</div>
</div>
</div>
<script type="text/javascript">
	function openModal1(bpaynumId){
		cancelModalPopup(bpaynumId);		
	}
	
	function cancelModalPopup(bpaynum){
	    // 팝업 호출 url
	    var url = "${pageContext.request.contextPath}/cs/cancelModal?bpaynum="+bpaynum;
	    
	    // 팝업 호출
	    $("#myModal > .modal-dialog").load(url, function() { 
	        $("#myModal").modal("show"); 
	    });
	}
</script>

<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog modal-lg">
  </div>
</div>
    