<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
							<th class="table-active">주문번호</th>
							<th class="table-active">주문일(결제일)</th>
							<th class="table-active">주문자</th>
							<c:if test="${path == 2}">
								<th class="table-active"><input type="checkbox"></th>
							</c:if>
							<th class="table-active">책 제목</th>
							<th class="table-active">수량</th>
							<th class="table-active">판매가</th>
							<th class="table-active">배송료</th>
							<th class="table-active">총 실제 결제 금액</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach var="vo" items="${list }">
							<tr>
								<td class="bpaynum" rowspan="2">${vo.bpaynum}</td>
								<td rowspan="2">
								<c:choose>
									<c:when test="${tfield == 'bpaydate' }">
										<fmt:formatDate value = "${vo.bpaydate}" pattern="yyyy-MM-dd"/>
									</c:when>
									<c:otherwise>
										<fmt:formatDate value = "${vo.borderdate}" pattern="yyyy-MM-dd"/>									
									</c:otherwise>
								</c:choose>						
								</td>
								<td rowspan="2">${vo.mname }</td>
								<c:if test="${path == 2}">
									<td  rowspan="2"><input type="checkbox"></td>
								</c:if>
								
								<td rowspan="1"><c:forEach items="${vo.paymentbook}"
										var="book">
										<p>${book.btitle}</p>
									</c:forEach></td>
								<td rowspan="1"><c:forEach items="${vo.paymentbook}"
										var="book">
										<p>${book.bcount}</p>
									</c:forEach></td>
								<td rowspan="1"><c:forEach items="${vo.paymentbook}"
										var="book">
										<p>${book.bprice}</p>
									</c:forEach></td>

								<td rowspan="2">${vo.delfee}</td>
								<td rowspan="2">${vo.bfinalmoney}</td>
							</tr>
							<tr>
								<td colspan="3">수령인 : ${vo.receiver}<br> 전화번호 :
									${vo.bphone }<br> <p class = "addr"> 주소 : ${vo.baddr} </p>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
<!-- 				배송중일때 -->
				<c:if test="${path == 2}">
					<input class = "btn btn-outline-success" type="button" id = "shipCancelBtn" value = "배송준비중 처리">
					<input class = "btn btn-success" type="button" id= "shipCompleteBtn" value = "배송완료 처리">
				</c:if>
			</div>
			<div class="pagination justify-content-center">
			<!-- 페이징 -->
			<div id="listPaging">
				<c:choose>
					<c:when test="${pu.startPageNum > 1 }">
						<button onclick="location.href='${pageContext.request.contextPath }/ship/menu?PageName=${PageName}&type=${type }&pageNum=${pu.startPageNum - 1}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}'" 
							type="button" class="btn btn-outline-success">이전</button>
					</c:when>
				</c:choose>
	
				<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
					<c:choose>
						<c:when test="${i == pu.pageNum }">
								<button type="button" class="btn btn-success"
									onclick="location.href='${pageContext.request.contextPath }/ship/menu?PageName=${PageName}&type=${type }&pageNum=${pu.startPageNum}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}'">${i }</button>
							</c:when>
						<c:otherwise>
							<button type="button" class="btn btn-outline-success" 
								onclick ="location.href='${pageContext.request.contextPath }/ship/menu?PageName=${PageName}&type=${type }&pageNum=${pu.startPageNum}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}'">${i }</button>
						</c:otherwise>
					</c:choose>
				</c:forEach>
	
				<c:choose>
						<c:when test="${pu.totalPageCnt > pu.endPageNum }">
							<button
								onclick="location.href='${pageContext.request.contextPath }/ship/menu?PageName=${PageName}&type=${type }&pageNum=${pu.startPageNum + 1}&pfield=${pfield}&pkeyword=${pkeyword}&tfield=${tfield}&startDate=${startDate}&endDate=${endDate}&bfield=${bfield}&bkeyword=${bkeyword}&mType=${mType}'"
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
	$("#shipCompleteBtn").click(function(){
		changeBstatusAja("3","배송완료상태로 처리되었습니다.")
	})
	$("#shipCancelBtn").click(function(){
		changeBstatusAja("1","배송준비중으로 처리되었습니다.")
	})
	
	function changeBstatusAja(bstatus,msg){
		var tdArr = new Array();
		var checkbox = $("input[type=checkbox]:checked");
		

		checkbox.each(function(i){
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
		
			var no = td.eq(0).text();
			
			if(no != "주문번호"){
				tdArr.push(no);					
			}
		})
		

		$.ajax({
			url :'${pageContext.request.contextPath}/ship/changeToShipping',
			dataType : "json",
			data : {"bpaynum" : tdArr, "bstatus" : bstatus},
			success : function(data){
				console.log(data.code);
				if(data.code == "success"){
					alert(msg)
					window.location.reload();
				}else{
					alert("실패하였습니다.")						
				}
			}			
		})
	}
</script>
