<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Page Preloder-->
<!--  
<div id="preloder">
	<div class="loader"></div>
</div>-->
<!-- Header section -->
<header class="header-section">
	<div class="header-top">
		<div class="container">
			<div class="row">
				<div class="text-center text-lg-left">
					<!-- logo -->
					<a href="${cp }/" class="site-logo"> <img
						src="${cp }/resources/hd/img/logo2.jpg" id="logoImg" alt="">
					</a>
				</div>
				<div class="col-xl-6 col-lg-5">
					<form class="header-search-form">
						<input type="text" placeholder="Search">
						<button>
							<i class="flaticon-search"></i>
						</button>
					</form>
				</div>
				<div class="col-xl-4 col-lg-5">
					<div class="user-panel">
						<div class="up-item">
							<i class="flaticon-profile"></i><a href="#">로그인</a> / <a
								href="#">회원가입</a>
						</div>
						<div class="up-item">
							<div class="shopping-card">
								<i class="flaticon-bag"></i><span>0<!-- 장바구니select행수 받기 --></span>
							</div>
							<a href="${cp }/pay/cart">장바구니</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<nav class="main-navbar">
		<div class="container">
			<!-- menu -->
			<ul class="main-menu">
				<li><a href="${cp}/list1">카테고리</a>
					<ul class="sub-menu">
						<li><a href="#">소설</a></li>
						<li><a href="#">시/에세이</a></li>
						<li><a href="#">인문</a></li>
						<li><a href="#">경제/경영</a></li>
						<li><a href="#">자기계발</a></li>
						<li><a href="#">역사/문화</a></li>
						<li><a href="#">취업/수험서</a></li>
						<li><a href="#">여행/지도</a></li>
						<li><a href="#">컴퓨터/IT</a></li>
						<li><a href="#">만화</a></li>
						<li><a href="#">기타</a></li>
					</ul></li>
				<li><a href="${cp }/list2">베스트</a></li>
				<li><a href="#">신간 <span class="new">New</span>
				</a></li>
				<li><a href="#">중고</a></li>
				<li><a href="${cp }/mypage/main">마이페이지</a>
					<ul class="sub-menu">
						<li><a href="#">주문내역</a></li>
						<li><a href="#">반품/취소/환불</a></li>
						<li><a href="#">나의계좌</a></li>
						<li><a href="#">나의정보</a></li>
						<li><a href="${cp }/seller">중고판매관리</a></li>
						<li><a href="#">모임관리</a></li>
					</ul></li>
					<li><a href="#">고객센터</a></li>
			</ul>
		</div>
	</nav>
</header>
<!-- Header section end -->