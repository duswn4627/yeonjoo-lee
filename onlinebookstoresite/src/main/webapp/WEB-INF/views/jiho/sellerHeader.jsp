<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
#sellerhomeIcon{
	margin-left: 500px;
}
.jhmaintop{
	margin-top: 80px;
	
}

</style>
<div id="sellerTop">
	<div style="width: 1500px;">
		<a href="${cp}/seller"><img	src="${cp}/resources/jh/jhimages/중고판매로고.png" id="sellerhomeIcon"></a>
		<a href="${cp}/" style="margin-left: 200px;">
			<img src="${cp }/resources/jh/jhimages/홈으로_1.png" class="jhmaintop">
		</a>
		<a href="${cp}/seller">
			<img src="${cp }/resources/jh/jhimages/중고관리메인_1.png" class="jhmaintop">
		</a>
		<a href="${cp }/logout">
			<img src="${cp }/resources/jh/jhimages/로그아웃_1.png" class="jhmaintop">
		</a>
	</div>
</div>
<div>
	<nav class="main-navbar">
			<div class="container">
				<!-- menu -->
				<ul class="main-menu">
					<li><a href="${cp}/seller/productInput">상품등록</a></li>
					<li><a href="${cp}/seller/prodLook">상품조회/수정</a></li>
					<li><a href="${cp}/seller/salesManagement">판매관리</a>
						<ul class="sub-menu">
							<li><a href="${cp}/seller/salesManagement?tabType=1">입금대기중</a></li>
							<li><a href="${cp}/seller/salesManagement2?tabType=2">입금완료/배송요청</a></li>
							<li><a href="${cp}/seller/salesManagement3?tabType=3">배송중/구매확정전</a></li>
							<li><a href="${cp}/seller/salesManagement4?tabType=4">구매확정/정산대기</a></li>
						</ul>
					</li>
					<li><a href="${cp }/seller/settlementCheck">정산조회</a></li>
					<li><a href="${cp }/seller/qnalist">게시판</a>
						<ul class="sub-menu">
							<li><a href="${cp }/seller/qnalist">QnA관리</a></li>
							<li><a href="${cp }/seller/review">구매리뷰관리</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>
</div>