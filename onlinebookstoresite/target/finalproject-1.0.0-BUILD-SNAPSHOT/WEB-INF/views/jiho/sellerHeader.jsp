<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="sellerTop">
	<a href="${pageContext.request.contextPath}/seller"><img
		src="${pageContext.request.contextPath}/resources/jh/jhimages/gobook.png"></a>
	<a href="${pageContext.request.contextPath}/">메인화면으로</a>
	<a href="${pageContext.request.contextPath}/seller">중고관리메인</a>
	<a href="#">로그아웃</a>
	<a href="#">판매자탈퇴</a>
</div>
<div>
	<nav class="main-navbar">
			<div class="container">
				<!-- menu -->
				<ul class="main-menu">
					<li><a href="${pageContext.request.contextPath}/seller/productInput">상품등록</a></li>
					<li><a href="${pageContext.request.contextPath}/seller/prodLook">상품조회/수정</a></li>
					<li><a href="#">판매관리</a>
						<ul class="sub-menu">
							<li><a href="#">주문확인 요청</a></li>
							<li><a href="#">발송요청</a></li>
							<li><a href="#">배송/구매확정전</a></li>
							<li><a href="#">구매확정/정산대기</a></li>
						</ul>
					</li>
					<li><a href="#">정산조회</a></li>
					<li><a href="#">게시판</a>
						<ul class="sub-menu">
							<li><a href="#">QnA관리</a></li>
							<li><a href="#">구매리뷰관리</a></li>
						</ul>
					</li>
					<li><a href="#">반품관리</a></li>
				</ul>
			</div>
		</nav>
</div>