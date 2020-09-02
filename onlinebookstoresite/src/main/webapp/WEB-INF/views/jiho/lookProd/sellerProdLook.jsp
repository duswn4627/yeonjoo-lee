<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>
/*=====================상품조회/수정관련css=====================*/
#sellerProdLook {
	width: 1300px;
	height: 900px;
	margin: auto;
}
/*검색박스*/
#selectBox {
	width: 1300px;
	height: 250px;
}

#selectBox table {
	border: 1px;
}

.tdstyle {
	background-color: silver;
	width: 300px;
	height: 70px;
	text-align: center;
}

.prodLooktdStyle input[type="radio"] {
	width: 50px;
}

.prodLooktdStyle input[type="text"] {
	width: 300px;
}

.form-control {
	width: 150px;
}
/*테이블박스*/
#showTable {
	width: 1250px;
	height: 450px;
}

#showTable table {
	text-align: center;
}

.title {
	background-color: silver;
}
</style>
<script type="text/javascript" src="${cp }/resources/jh/js/jquery-3.5.1.js"></script>
<script>

	$(function(){
		$("input:radio[name=regdate]").click(function(){
			if($("input[name=regdate]:checked").val()=='1'){
				$("input[name=startDay]").attr("disabled",false);
				$("input[name=endDay]").attr("disabled",false);
			}
			if($("input[name=regdate]:checked").val()=='0'){
				$("input[name=startDay]").attr("disabled",true);
				$("input[name=endDay]").attr("disabled",true);
			}
		});	
	});
</script>
<div id="sellerProdLook">
	<div>
		<h2><img src="${cp }/resources/jh/jhimages/상품조회_수정.png"></h2>
	</div>
	<form
		action="${cp }/seller/prodLook?keyword=${map.keyword}&field=${map.field}&obsalestatus=${map.obsalestatus}
		&regdate=${map.regdate }&startDay=${map.startDay}&endDay=${map.endDay}">
		<!-- 검색박스 -->
		<div id="selectBox">
			<table class="table table-bordered">
				<tr>
					<td class="tdstyle" id="statusa">판매상태별 조회</td>
					<td class="prodLooktdStyle">
						<input type="radio"	name="obsalestatus" value="4" 
							<c:if test="${map.obsalestatus==4 || map.obsalestatus==null || map.obsalestatus==''}">checked</c:if>>전체
						<input type="radio" name="obsalestatus" value="0"
							<c:if test="${map.obsalestatus==0 }">checked</c:if>>판매중
						<input type="radio" name="obsalestatus" value="1"
							<c:if test="${map.obsalestatus==1 }">checked</c:if>>입금대기중
						<input type="radio" name="obsalestatus" value="2"
							<c:if test="${map.obsalestatus==2 }">checked</c:if>>결제완료
						<input type="radio" name="obsalestatus" value="3"
							<c:if test="${map.obsalestatus==3 }">checked</c:if>>판매완료
					</td>
				</tr>
				<tr>
					<td class="tdstyle">등록일자별 조회</td>
					<td class="prodLooktdStyle">
						<input type="radio" name="regdate" value="0"
							<c:if test="${map.regdate==0 || map.regdate==null}">checked</c:if>>전체
						<input type="radio" name="regdate" value="1"
							<c:if test="${map.regdate==1}">checked</c:if>>일자별&nbsp;&nbsp;&nbsp;
						<input type="date" name="startDay" value="${map.startDay }"
							<c:if test="${map.regdate==0 }">disabled</c:if>><span>&nbsp;~</span>
						<input type="date" name="endDay" value="${map.endDay }"
							<c:if test="${map.regdate==0 }">disabled</c:if>>
					</td>
				</tr>
				<tr>
					<td class="tdstyle">등록한 상품 검색</td>
					<td>
						<div class="input-group mt-1 mb-1">
							<div class="input-group-prepend">
								<select name="field" class="form-control">
									<option value="all"
										<c:if test="${map.field=='all' || map.field==null || map.field==''}">selected</c:if>>전체</option>
									<option value="obname"
										<c:if test="${map.field=='obname'}">selected</c:if>>상품명</option>
									<option value="obwriter"
										<c:if test="${map.field=='obwriter'}">selected</c:if>>저자</option>
									<option value="obpublisher"
										<c:if test="${map.field=='obpublisher'}">selected</c:if>>출판사</option>
								</select>
							</div>
							<input type="text" name="keyword" class="form-control"
								placeholder="검색어를 입력하세요."
								<c:if test="${map.keyword!=null || map.keyword!=''}">value="${map.keyword }"</c:if>>
							<!-- 버튼 -->
							<input type="submit" value="검색" class="btn btn-success"
								id="list2bt"> <input type="button" value="검색조건 초기화" id="resetBt"
								class="btn btn-secondary">
						</div>
					</td>
				</tr>
			</table>
		</div>
		<!-- 상품 리트스 테이블 -->
		<div class="card">
			<div class="card-header"><img src="${cp }/resources/jh/jhimages/tableicon.png" id="tableicon">상품리스트</div>
					<div class="card-body">
						<div id="showTable">
					<table class="table table-bordered">
						<tr class="title">
							<td width="50">NO</td>
							<td width="300">상품명</td>
							<td>출판사</td>
							<td>저자</td>
							<td width="110">판매상태</td>
							<td>품질</td>
							<td>판매가</td>
							<td width="120">등록일</td>
							<td width="80">수정</td>
							<td width="80">삭제</td>
						</tr>
						<c:forEach var="vo" items="${list}" varStatus="status">
							<tr>
								<td>${pu.totalRowCount - ((pu.pageNum-1) * 5 + status.index)}</td>
								<td>${vo.obname}</td>
								<td>${vo.obpublisher}</td>
								<td>${vo.obwriter}</td>
								<td><c:if test="${vo.obsalestatus==0}">판매중</c:if> 
									<c:if test="${vo.obsalestatus==1}">입금대기중</c:if> 
									<c:if test="${vo.obsalestatus==2}">결제완료</c:if>
									<c:if test="${vo.obsalestatus==3}">판매완료</c:if>
								</td>
								<td><c:if test="${vo.obstatus==1}">최상</c:if>
									<c:if test="${vo.obstatus==2}">상</c:if>
									<c:if test="${vo.obstatus==3}">중</c:if>
									<c:if test="${vo.obstatus==4}">하</c:if>
								</td>
								<td>${vo.obsaleprice}원</td>
								<td><fmt:formatDate value="${vo.obregdate}"	pattern="yyyy-MM-dd" /></td>
								<td><c:choose>
										<c:when test="${vo.obsalestatus==0}">
											<a href="${cp}/seller/prodUpdateView?obnum=${vo.obnum}"> <input
												type="button" value="수정" class="btn btn-primary"></a>
										</c:when>
										<c:otherwise>
											<input type="button" value="수정" class="btn btn-primary"
												disabled="disabled">
										</c:otherwise>
									</c:choose></td>
								<td><c:choose>
										<c:when test="${vo.obsalestatus==0}">
											<!-- <a href="${cp }/seller/oldbookDel?obnum=${vo.obnum}"></a> -->
											<input type="button" value="삭제" class="btn btn-secondary"
												onclick="del(${vo.obnum})">
										</c:when>
										<c:otherwise>
											<input type="button" value="삭제" class="btn btn-secondary"
												disabled="disabled">
										</c:otherwise>
									</c:choose></td>
							</tr>
						</c:forEach>
					</table>
					<!-- 페이징처리 -->
					<div>
						<ul class="pagination justify-content-center">
							<!-- 이전버튼 -->
							<c:if test="${pu.startPageNum>3 }">
								<li class="page-item"><a class="page-link"
									href="${cp }/seller/prodLook?pageNum=${pu.startPageNum-1}&
								keyword=${map.keyword}&field=${map.field}&obsalestatus=${map.obsalestatus}&regdate=${map.regdate }&startDay=${map.startDay}&endDay=${map.endDay}">이전</a></li>
							</c:if>
							<c:forEach var="i" end="${pu.endPageNum}" begin="${pu.startPageNum }">
								<li class="page-item">
									<a class="page-link" href="${cp }/seller/prodLook?pageNum=${i}&
									keyword=${map.keyword}&field=${map.field}&obsalestatus=${map.obsalestatus}
									&regdate=${map.regdate }&startDay=${map.startDay}&endDay=${map.endDay}">${i}</a>
								</li>
							</c:forEach>
							<!-- 다음버튼 -->
							<c:if test="${pu.totalPageCount>pu.endPageNum}">
								<li class="page-item"><a class="page-link"
									href="${cp }/seller/prodLook?pageNum=${pu.endPageNum+1}&
								keyword=${map.keyword}&field=${map.field}&obsalestatus=${map.obsalestatus}&regdate=${map.regdate }&startDay=${map.startDay}&endDay=${map.endDay}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>

<script>
$(function(){
	//날짜 검색 disabled처리
	$("input:radio[name=regdate]").click(function(){
		if($("input[name=regdate]:checked").val()=='1'){
			$("input[name=startDay]").attr("disabled",false);
			$("input[name=endDay]").attr("disabled",false);
		}
		if($("input[name=regdate]:checked").val()=='0'){
			$("input[name=startDay]").attr("disabled",true);
			$("input[name=endDay]").attr("disabled",true);
		}
	});	
	//초기화버튼
	$("#resetBt").click(function() {
		$("input[name=obsalestatus]")[0].checked=true;
		$("input[name=regdate]")[0].checked=true;
		$("input[name=startDay]").attr("disabled",true);
		$("input[name=startDay]").val("");
		$("input[name=endDay]").attr("disabled",true);
		$("input[name=endDay]").val("");
		$("select[name=field]").val('all').attr("selected","selected");
		$("input[name=keyword]").val("");
	});
	
	//입력 유효성검사
	$("form").submit(function() {
		//일자별 검색 유효성검사1
		if($("input[name=regdate]:checked").val()=='1'){
			if($("input[name=startDay]").val()==''){
				alert('시작 날짜를 입력해주세요.');
				return false;
			}
		}
		if($("input[name=regdate]:checked").val()=='1'){
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
	//상품삭제
	function del(obnum){
		var result=confirm('상품을 삭제하시겠습니까?');
		if(result==true){
			location.href="${cp }/seller/oldbookDel?obnum="+obnum;
		}else{
			return;
		}
	}
</script>