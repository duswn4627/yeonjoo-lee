<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid ">
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
							<th class="table-active"><input type="checkbox"></th>
							<th class="table-active">주문번호</th>
							<th class="table-active">주문일(결제일)</th>
							<th class="table-active">주문자</th>
							<th class="table-active">책 제목</th>
							<th class="table-active">배송료</th>
							<th class="table-active">총 실제 결제 금액</th>
							<th class="table-active">결제수단</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${list }">
							<tr>
								<td><input type="checkbox"  id = "chb"></td>
								<td>${vo.bpaynum}</td>
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
								<td>${vo.mname }</td>
								
								<td>
									<c:forEach items="${vo.paymentbook}" var="book">
										 <c:if test="${book.btype == 2 }">
										 	<p>[중고]</p>
										 </c:if>
										<p>${book.btitle}</p>
									</c:forEach>
								</td>
								
								<td>${vo.delfee}</td>
								<td>${vo.bfinalmoney}</td>
								<!-- 결제수단 -->
								<c:choose>
									<c:when test="${vo.methodpayment == 0 }">
										<td>카드</td>
									</c:when>
									<c:when test="${vo.methodpayment == 1 }">
										<td>무통장</td>
									</c:when>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<input class="btn btn-outline-success" id = "checkBtn" type = "button" value = "입금확인">
			</div>
			
			<div class="pagination justify-content-center">
			<!-- 페이징 -->
			<div id="listPaging">
				<c:choose>
					<c:when test="${pu.startPageNum > 1 }">
						<button onclick="location.href='${pageContext.request.contextPath }/ship/menu?PageName=${PageName }&type=${type }&pageNum=${pu.startPageNum - 1}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}'" 
							type="button" class="btn btn-outline-success">이전</button>
					</c:when>
				</c:choose>
	
				<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
					<c:choose>
						<c:when test="${i == pu.pageNum }">
								<button type="button" class="btn btn-success"
									onclick="location.href='${pageContext.request.contextPath }/ship/menu?PageName=${PageName }&type=${type }&pageNum=${pu.startPageNum}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}'">${i }</button>
							</c:when>
						<c:otherwise>
							<button type="button" class="btn btn-outline-success" 
								onclick ="location.href='${pageContext.request.contextPath }/ship/menu?PageName=${PageName }&type=${type }&pageNum=${pu.startPageNum}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}'">${i }</button>
						</c:otherwise>
					</c:choose>
				</c:forEach>
	
				<c:choose>
						<c:when test="${pu.totalPageCnt > pu.endPageNum }">
							<button
								onclick="location.href='${pageContext.request.contextPath }/ship/menu?PageName=${PageName }&type=${type }&pageNum=${pu.startPageNum + 1}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}'"
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

<script type="text/javascript">
	$(function(){
		
		$('#checkBtn').click(function(){
			var tdArr = new Array();
			var checkbox = $("input[type=checkbox]:checked");
	
			checkbox.each(function(i){
				// checkbox.parent() : checkbox의 부모는 <td>이다.
				// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
			
				// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
				var no = td.eq(1).text();
				
				console.log("ggg" + no);
				
				if(no != "주문번호"){
					tdArr.push(no);					
				}
			})
			

			$.ajax({
				url : "${pageContext.request.contextPath}/ship/checkDeposit",
				dataType : "json",
				data : {"bpaynum":tdArr},
				success : function(data){
					console.log(data.code);
					if(data.code == "success"){
						alert("입금확인 되었습니다.")
						window.location.reload();
					}else{
						alert("입금확인에 실패하였습니다.")						
					}
				}			
			
			})
		})
	
	})
</script>