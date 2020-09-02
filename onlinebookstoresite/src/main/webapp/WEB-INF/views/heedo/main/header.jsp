<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<a href="${cp }/" class="site-logo"> <img src="${cp }/resources/hd/img/logo2.jpg" id="logoImg" alt="">
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
							<i class="flaticon-profile"></i>
							<c:if test="${ empty sessionScope.mid }">
								<a href="${cp }/login">로그인</a> / <a href="${cp }/join">회원가입</a>
							</c:if>
							<c:if test="${not empty sessionScope.mid }">
								<a href="${cp }/logout">로그아웃</a>
							</c:if>
							
						</div>
						<div class="up-item">
							<div class="shopping-card">
								<i class="flaticon-bag"></i>
								<span id="cartcount">
								</span>
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
						<li><a href="${cp }/cnovel">소설</a></li>
						<li><a href="${cp }/cpoetry">시/에세이</a></li>
						<li><a href="${cp }/chuman">인문</a></li>
						<li><a href="${cp }/ceconomy">경제/경영</a></li>
						<li><a href="${cp }/cselfdev">자기계발</a></li>
						<li><a href="${cp }/chistory">역사/문화</a></li>
						<li><a href="${cp }/cjob">취업/수험서</a></li>
						<li><a href="${cp }/ctravel">여행/지도</a></li>
						<li><a href="${cp }/cit">컴퓨터/IT</a></li>
						<li><a href="${cp }/ccartoon">만화</a></li>
						<li><a href="${cp }/cguitar">기타</a></li>
					</ul></li>
				<li><a href="${cp }/list2">베스트</a></li>
				<li><a href="${cp }/newlist">신간 <span class="new">New</span>
				</a></li>
				<li><a href="${cp }/oldallbook">중고</a></li>
				<li><a href="${cp }/mypage/main">마이페이지</a>
					<ul class="sub-menu">
						<li><a href="${cp }/mypage/orderhistory">주문내역</a></li>
						<li><a href="#">반품/교환내역</a></li>
						<li><a href="#">예치금내역</a></li>
						<li><a href="#">계좌내역</a></li>
						<li><a href="${cp }/seller">중고판매관리</a></li>
						<li><a href="${cp }/mypage/qnapage">문의게시판</a></li>
					</ul></li>
					
					<c:if test="${sessionScope.mid eq 'admin'}">
						<li><a href="${cp }/adminmain">관리자 페이지</a></li>
					</c:if>
			</ul>
		</div>
	</nav>
</header>
<!-- Header section end -->
<script>
	$(document).ready(function(){
		$.ajax({
			url:"/finalproject/mypage/countcart",
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.result){				
					var count=data.count;
					$("#cartcount").text(count);
				}else{
					$("#cartcount").text(0);
				}
				
			}
			
		})
		
	})
</script>