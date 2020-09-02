<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<style>
#sellerReviewMain{
	width: 1300px;
	height: 700px;
	margin:auto;
}
/*리뷰 헤더css*/
#reviewHeader{
	width: 1100px;
	height: 200px;
	margin:auto;
	margin-top:30px;
    padding-top: 65px;
	background-image: url("${cp}/resources/jh/jhimages/판매자리뷰베너.png");
}
#jumsu{
	font-size: 40px;
	color: #FE2E64;
	margin-left: 810px;
	font-weight: bold;
}
/*리뷰테이블 css*/
#reviewTable{
	width: 1100px;
	height: 400px;
	margin: auto;
	margin-top: 20px;
}
.reviewOrder{
	color: black;
}
#reviewTable table{
	text-align: center;
}
</style>
<div id="sellerReviewMain">
	<div id="reviewHeader">
		<span id="jumsu">${reviewAvg}점</span>
	</div>
	<div id="reviewTable">
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th style="width: 70px">NO</th>
					<th style="">상품명</th>
					<th style="width: 180px">작성자</th>
					<th style="width: 200px;">평점</th>
					<th width="150px">작성일자</th>
				</tr>
			</thead>
			<c:forEach var="vo" items="${list }" varStatus="status">
				<tr>
					<td>${pu.totalRowCount - ((pu.pageNum-1) * 5 + status.index)}</td>				
					<td style="text-align: left;" onclick="show('${vo.sreviewcontent}')">${vo.obname }</td>				
					<td onclick="show('${vo.sreviewcontent}')">${vo.mid}</td>				
					<td onclick="show('${vo.sreviewcontent}')">
						<c:if test="${vo.sscore==1 }">★</c:if>
						<c:if test="${vo.sscore==2 }">★★</c:if>
						<c:if test="${vo.sscore==3 }">★★★</c:if>
						<c:if test="${vo.sscore==4 }">★★★★</c:if>
						<c:if test="${vo.sscore==5 }">★★★★★</c:if>
					</td>				
					<td onclick="show('${vo.sreviewcontent}')">
						<fmt:formatDate value="${vo.sreviewregdate }" pattern="yyyy-MM-dd"/>
					</td>				
				</tr>
			</c:forEach>
		</table>
		<div>
			<ul class="pagination justify-content-center">
				<!-- 이전버튼 -->
				<c:if test="${pu.startPageNum>3 }">
					<li class="page-item">
						<a class="page-link" href="${cp }/seller/review?pageNum=${pu.startPageNum-1}">
						이전</a>
					</li>
				</c:if>
				<c:forEach var="i" end="${pu.endPageNum}" begin="${pu.startPageNum }">
					<li class="page-item">
						<a class="page-link" href="${cp }/seller/review?pageNum=${i}">${i}</a>
					</li>
				</c:forEach>
				<!-- 다음버튼 -->
				<c:if test="${pu.totalPageCount>pu.endPageNum}">
					<li class="page-item"><a class="page-link"
						href="${cp }/seller/review?pageNum=${pu.endPageNum+1}">다음</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
<!-- 모달 -->
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">[중고판매 코멘트]</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          <span>코멘트 : ${vo.sreviewcontent }</span><br>
          <span id="reviewcontent"></span>
        </div>
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
        </div>
        
      </div>
    </div>
  </div>
<script>
	function show(str){
		$("#reviewcontent").html(str);
		$('#myModal').modal('show');
	}


</script>