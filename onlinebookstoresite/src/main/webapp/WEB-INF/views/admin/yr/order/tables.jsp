<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
							<th class="table-active">주문일(결제일)</th>
							<th class="table-active">주문번호</th>
							<th class="table-active">주문자</th>
							<th class="table-active">책 제목</th>
							<th class="table-active">배송료</th>
							<th class="table-active">총 실제 결제 금액</th>
							<th class="table-active">결제수단</th>
							<th class="table-active">배송상태</th>
							<th class="table-active">cs주문상태</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${list }">
							<tr>
								<td>
									<c:choose>
										<c:when test="${tfield == 'bpaydate' }">
											<fmt:formatDate value = "${vo.bpaydate}" pattern="yyyy-MM-dd"/>
										</c:when>								
										<c:otherwise>
											<fmt:formatDate value = "${vo.borderdate}" pattern="yyyy-MM-dd"/>									
										</c:otherwise>
									</c:choose>
								</td>
								<td>${vo.bpaynum}</td>
								<td>${vo.mname }</td>
								<td>
									<c:forEach items="${vo.paymentbook}" var="book">
										 <c:if test="${book.btype == 2 }">
										 	<p>[중고]</p>
										 </c:if>
										<p>${book.btitle}</p>									
									</c:forEach>
								</td>
								<td>${vo.delfee}원</td>
								<td>${vo.bfinalmoney}원</td>
<!-- 								결제수단 -->
								<c:choose>
									<c:when test="${vo.methodpayment == 0 }">
										<td>카드</td>									
									</c:when>									
									<c:when test="${vo.methodpayment == 1 }">
										<td>무통장</td>									
									</c:when>
								</c:choose>
<!-- 								배송상태 -->
								<c:choose>
									<c:when test="${vo.bstatus == 0 || vo.bstatus == 1 }">
										<td>배송전</td>									
									</c:when>									
									<c:when test="${vo.bstatus == 2 }">
										<td>배송중</td>									
									</c:when>
									<c:when test="${vo.bstatus == 3 || vo.bstatus == 4 }">
										<td>배송완료</td>									
									</c:when>
									<c:otherwise>
										<td></td>
									</c:otherwise>
								</c:choose>
<!-- 								cs type -->
								<td>
									<c:forEach items="${vo.paymentbook}" var="book">
										<c:choose>
											<c:when test="${book.type == 1}">
												<p>취소</p>									
											</c:when>									
											<c:when test="${book.type == 2 }">
												<p>반품</p>									
											</c:when>
											<c:when test="${book.type == 3 }">
												<p>교환</p>									
											</c:when>
											<c:otherwise>
												<p></p>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="pagination justify-content-center">
				<!-- 페이징 -->
				<div id="listPaging">
					<c:choose>
						<c:when test="${pu.startPageNum > 1 }">
							<button onclick="location.href='${pageContext.request.contextPath }/totalOrder?pageNum=${pu.startPageNum - 1}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&bstatus=${bstatus}&type=${type}&payType=${payType}&mType=${mType}'" 
								type="button" class="btn btn-outline-success">이전</button>
						</c:when>
					</c:choose>
		
					<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
						<c:choose>
							<c:when test="${i == pu.pageNum }">
									<button type="button" class="btn btn-success"
										onclick="location.href='${pageContext.request.contextPath }/totalOrder?pageNum=${i}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&bstatus=${bstatus}&type=${type}&payType=${payType}&mType=${mType}'">${i }</button>
								</c:when>
							<c:otherwise>
								<button type="button" class="btn btn-outline-success" 
									onclick ="location.href='${pageContext.request.contextPath }/totalOrder?pageNum=${i}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&bstatus=${bstatus}&type=${type}&payType=${payType}&mType=${mType}'">${i }</button>
							</c:otherwise>
						</c:choose>
					</c:forEach>
		
					<c:choose>
							<c:when test="${pu.totalPageCnt > pu.endPageNum }">
								<button
									onclick="location.href='${pageContext.request.contextPath }/totalOrder?pageNum=${pu.endPageNum + 1}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&bstatus=${bstatus}&type=${type}&payType=${payType}&mType=${mType}'"
									type="button" class="btn btn-outline-success">다음</button>
							</c:when>
						</c:choose>
				</div>
				<br>
				<!-- ////////////////// -->
			</div>
				
			</div>
		</div>
	</div>
</div>
