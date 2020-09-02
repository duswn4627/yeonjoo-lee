<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>
/*=========중고판매자 Qna관련 css==========*/
#sellerQnaContent{
	width: 1300px;
	height: 950px;
	margin: auto;
}
/*중고판매자 QnA검색박스css*/
#sellerQnaSearchBox{
	width: 1300px;
	height: 330px;
}
input[name='obqstatus']{
    margin-left: 10px;
    margin-right: 10px;
}
input[name='obqdate']{
	margin-left: 10px;
    margin-right: 10px;
}
.daptdstyle{
	background-color: silver;
}
/*중고판매자 Qna 리스트 css*/
#sellerQnaList{
	width: 1250px;
	height: 450px;
}
/*답변css*/
.sellerDap{
    padding-left: 70px;
    padding-right: 70px;
}

</style>
<div id="sellerQnaContent">
	<!-- 검색박스 -->
	<div id="sellerQnaSearchBox">
	<form action="${cp }/seller/qnalist">
		<h2><img src="${cp }/resources/jh/jhimages/qna리스트_1.png"></h2>
			<table class="table table-bordered">
				<tr>
					<td class="daptdstyle" id="statusa">답변 상태별 조회</td>
					<td class="prodLooktdStyle">
						<input type="radio" name="obqstatus" value="2" 
							<c:if test="${map.obqstatus==2 || map.obqstatus==null || map.obqstatus=='' }">checked</c:if>>전체
						<input type="radio" name="obqstatus" value="0"
							<c:if test="${map.obqstatus==0 }">checked</c:if>>미답변
						<input type="radio" name="obqstatus" value="1"
							<c:if test="${map.obqstatus==1 }">checked</c:if>>답변완료
					</td>
				</tr>
				<tr>
					<td class="daptdstyle">등록일자별 조회</td>
					<td class="prodLooktdStyle">
						<input type="radio" name="obqdate" value="all"
							<c:if test="${map.obqdate=='all' || map.obqdate==null}">checked</c:if>>전체
						<input type="radio" name="obqdate" value="date"
							<c:if test="${map.obqdate=='date'}">checked</c:if>>일자별&nbsp;&nbsp;&nbsp;
						<input type="date" name="startDay" value="${map.startDay }"
							<c:if test="${map.obqdate=='all'|| map.obqdate==null}">disabled</c:if>><span>&nbsp;~</span>
						<input type="date" name="endDay" value="${map.endDay }"
							<c:if test="${map.obqdate=='all'|| map.obqdate==null}">disabled</c:if>>
					</td>
				</tr>
				<tr>
					<td class="daptdstyle">키워드로 검색</td>
					<td>
						<div class="input-group mt-1 mb-1">
							<div class="input-group-prepend">
								<select name="field" class="form-control">
									<option value="all" 
										<c:if test="${map.field=='all' || map.field==null || map.field=='' }">selected</c:if>>전체</option>
									<option value="obqtitle"
										<c:if test="${map.field=='obqtitle'}">selected</c:if>>문의제목</option>
									<option value="mid"
										<c:if test="${map.field=='mid'}">selected</c:if>>작성자</option>
								</select>
							</div>
							<input type="text" name="keyword" class="form-control" placeholder="검색어를 입력하세요."
								value="${map.keyword}">
							<!-- 버튼 -->
							<input type="submit" value="검색" class="btn btn-success" id="list2bt">
							<input type="button" value="검색조건 초기화" id="resetBt" class="btn btn-secondary">
						</div>
					</td>
				</tr>
			</table>
	</div>
	<!-- QnA리스트 -->
	<div class="card">
			<div class="card-header"><img src="${cp }/resources/jh/jhimages/tableicon.png" id="tableicon">Q&A리스트</div>
			<div class="card-body">
				<div id="sellerQnaList">
			<div class="layer1">
				<table class="table table-bordered">
					<thead class="thead-dark">
						<tr style="text-align: center">
							<th width="80">NO</th>
							<th>문의제목</th>
							<th width="200">작성자</th>
							<th width="120">답변상태</th>
							<th width="120">게시물관리</th>
							<th width="120">작성일</th>
						</tr>
					</thead>
					<c:forEach var="vo" items="${list }" varStatus="status">
							<tr>
								<td style="text-align: center;">${pu.totalRowCount - ((pu.pageNum-1) * 5 + status.index)}</td>					
								<td><a href="${cp }/seller/qnadetail?obqnum=${vo.obqnum}"><span style="color: black;">${vo.obqtitle }</span></a></td>					
								<td style="text-align: center;">${vo.mid }</td>					
								<td style="text-align: center;">
									<c:if test="${vo.obqstatus==0 }">
										<span class="badge badge-primary">미답변</span>
									</c:if>
									<c:if test="${vo.obqstatus==1 }">
										<span class="badge badge-secondary">답변완료</span>
									</c:if>
								</td>				
								<td style="text-align: center;">
									<c:if test="${vo.obqstatus==0 }">
										<a href="${cp }/seller/qnadetail?obqnum=${vo.obqnum}">
											<button type="button" class="btn btn-primary btn-sm" >답변하기</button>
										</a>
									</c:if>
									<c:if test="${vo.obqstatus==1 }">
										<a href="${cp }/seller/qnaupdate?obqnum=${vo.obqnum}">
											<button type="button" class="btn btn-secondary btn-sm">수정하기</button>
										</a>
									</c:if>
								</td>	
								<td style="text-align: center;"><fmt:formatDate value="${vo.obqdate }" pattern="yyyy-MM-dd"/></td>					
							</tr>
					</c:forEach>
				</table>
			</div>
			<!-- 페이징처리 -->
			<div>
				<ul class="pagination justify-content-center">
					<!-- 이전버튼 -->
					<c:if test="${pu.startPageNum>3 }">
						<li class="page-item">
							<a class="page-link" href="${cp }/seller/qnalist?pageNum=${pu.startPageNum-1}&
							keyword=${map.keyword}&field=${map.field}&obqstatus=${map.obqstatus}
							&obqdate=${map.obqdate}&startDay=${map.startDay}&endDay=${map.endDay}">이전</a></li>
					</c:if>
					<c:forEach var="i" end="${pu.endPageNum}" begin="${pu.startPageNum }">
						<li class="page-item">
							<a class="page-link" href="${cp }/seller/qnalist?pageNum=${i}&
							keyword=${map.keyword}&field=${map.field}&obqstatus=${map.obqstatus}
							&obqdate=${map.obqdate}&startDay=${map.startDay}&endDay=${map.endDay}">${i}</a></li>
					</c:forEach>
					<!-- 다음버튼 -->
					<c:if test="${pu.totalPageCount>pu.endPageNum}">
						<li class="page-item"><a class="page-link"
							href="${cp }/seller/qnalist?pageNum=${pu.endPageNum+1}&
							keyword=${map.keyword}&field=${map.field}&obqstatus=${map.obqstatus}
							&obqdate=${map.obqdate}&startDay=${map.startDay}&endDay=${map.endDay}">다음</a></li>
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
	$("input:radio[name=obqdate]").click(function(){
		if($("input[name=obqdate]:checked").val()=='date'){
			$("input[name=startDay]").attr("disabled",false);
			$("input[name=endDay]").attr("disabled",false);
		}
		if($("input[name=obqdate]:checked").val()=='all'){
			$("input[name=startDay]").attr("disabled",true);
			$("input[name=endDay]").attr("disabled",true);
		}
	});	
	//초기화버튼
	$("#resetBt").click(function() {
		$("input[name=obqstatus]")[0].checked=true;
		$("input[name=obqdate]")[0].checked=true;
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
		if($("input[name=obqdate]:checked").val()=='date'){
			if($("input[name=startDay]").val()==''){
				alert('시작 날짜를 입력해주세요.');
				return false;
			}
		}
		if($("input[name=obqdate]:checked").val()=='date'){
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
</script>