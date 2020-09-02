<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container-fluid">
	<h2 class="mt-4 pageTitle" >주문 리스트</h2>
	<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table mr-1"></i>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" width="100%"
				cellspacing="0">
				<thead>
					<tr>
<!-- 						교환 -->
						<th class="table-active">주문일(신청일)</th>
						<th class="table-active">주문번호</th>
						<th class="table-active">주문자</th>
						<th class="table-active">책 제목</th>
						<th class="table-active">수량</th>
						<th class="table-active">결제예정금액</th>
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
							<td>
								<c:set var="b1count" value="0"/>
								<c:set var="b2count" value="0"/>
								<c:set var="b3count" value="0"/>
								<c:set var="length" value="${fn:length(vo.CSAndPaymentBook) }"/>
								<c:forEach items="${vo.CSAndPaymentBook}" var="book">
									<c:if test = "${book.status == 1 }">
										<c:set var="b1count" value = "${b1count+1 }"/>
									</c:if>
									<c:if test = "${book.status == 2 }">
										<c:set var="b2count" value = "${b2count+1 }"/>
									</c:if>
									<c:if test = "${book.status == 3 }">
										<c:set var="b3count" value = "${b3count+1 }"/>
									</c:if>
								</c:forEach>
								<c:choose>
									<c:when test="${b1count == length }"> <input class= "btn btn-success" id = "openModal2" type="button"  
									value = "신청 처리"  onclick = "openModal(${vo.bpaynum})"></c:when>
									<c:when test="${b2count >= 1 }"> <input class= "btn btn-success" id = "openModal2" type="button"  
									value = "처리 중"  onclick = "openModal(${vo.bpaynum})"></c:when>
									<c:when test="${b3count == length }"><input class= "btn btn-secondary" type="button" 
									value = "처리 완료" disabled="disabled"></c:when>							
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
	
	function openModal(bpaynumId){
		exchangeModalPopup(bpaynumId);		
	}
	
    function exchangeModalPopup(bpaynum){
        // 팝업 호출 url
        var url = "${pageContext.request.contextPath}/cs/exchangeModal?bpaynum="+bpaynum;
        
        // 팝업 호출
        $("#exchangeModal > .modal-dialog").load(url, function() { 
            $("#exchangeModal").modal("show"); 
        });
    }
</script>

<!-- The Modal -->
<div class="modal" id="exchangeModal">
  <div class="modal-dialog modal-lg">  
  </div>
</div>
    