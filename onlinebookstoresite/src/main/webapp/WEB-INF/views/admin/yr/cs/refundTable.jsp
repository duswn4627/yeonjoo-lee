<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fluid">
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
<!-- 						환불 -->
						<c:if test="${path == 4 || path == 5 }">
							<th class="table-active"><input type = "checkbox"></th>
						</c:if>
						<th class="table-active">번호</th>
						<th class="table-active">신청날짜</th>
						<th class="table-active">회원번호</th>
						<th class="table-active">회원이름</th>
						<th class="table-active">계좌정보</th>
						<th class="table-active">환불 금액</th>
						<th class="table-active">처리상태</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="vo" items="${list}">
						<tr>
							<c:if test="${path == 4 || path == 5 }">
								<td><input type = "checkbox" id = "sechb" <c:if test = "${vo.sestatus == 1 }">disabled</c:if>></td>
							</c:if>
							<td id = "senum">${vo.senum }</td>
							<td>
								<fmt:formatDate value = "${vo.appdate}" pattern="yyyy-MM-dd"/>
							</td>
							<td id = "bpaynumId">${vo.mnum}</td>
							<td>${vo.mname }</td>
							<td>${vo.account }</td>
							<td>${vo.reqmoney }</td>
							<td>
								<c:if test="${vo.sestatus == 0 }"> 
									신청
								</c:if>
								<c:if test="${vo.sestatus == 1 }"> 
									처리 완료
								</c:if>								
							</td>
						</tr>
					</c:forEach>
						<tr>
							<c:if test="${path == 4 || path == 5 }">
								<td colspan="8">
									<input id = "refundBtn" onclick = "abcbtn(${path})" class = "btn btn-success" type = "button" value = "처리하기">
								</td>
							</c:if>
						</tr>
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

	$(function(){
		
		
		$("#refundBtn").on('click',function(){
			
			var tdArr = new Array();
	 		var mnumArr = new Array();
	 		var priceArr = new Array();
			var checkbox = $("input[type=checkbox]:checked");
			
			checkbox.each(function(i){
				// checkbox.parent() : checkbox의 부모는 <td>이다.
				// checkbox.parent().parent() : <td>의 부모이므로 <tr>이다.
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
			
				// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
				var no = td.eq(1).text();
	 			var mnum = td.eq(3).text();
	 			var price = td.eq(6).text();
				
				if(no != "번호"){
					tdArr.push(no);				
	 				mnumArr.push(mnum);
	 				priceArr.push(price);
				}
				
			});
					
			ajDeposit(tdArr, mnumArr, priceArr);
		})
		
		
	})
	
		
	function ajDeposit(tdArr, mnumArr, priceArr){
		$.ajax({
			url : "${pageContext.request.contextPath}/cs/refundMoneyGoMembers",
			dataType : "json",
			data : {"senum":tdArr, "mnum" : mnumArr , "priceArr" : priceArr},
			success : function(data){
				console.log(data);
				if(data.code == "success"){
					alert("예치금이 전송 되었습니다.")
					window.location.reload();
				}else{
					alert("예치금 전송에 실패하였습니다.")	
					window.location.reload();
				}
			}						
		})
	}

</script>