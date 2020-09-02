<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	$('.carousel').carousel({
		interval : 500
	})
	$(document).ready(function() {
		viewBest();
		viewnew();
	});
	var bestpageNum = 1;
	var newpageNum = 1;
	var viewBest = function() {
		$.ajax({
				url : "${cp}/home/bestlist",
				dataType : "json",
				data : {pageNum : bestpageNum},
				success : function(data) {
						var b = $(
								"<div id='bestprev'>"
										+ "<img src='${cp }/resources/hd/image/prevButton.png' id='bestprevimg'>"
										+ "</div>").appendTo("#content-best-card");
						$(data).each(function(index, item) {
								$("<div class='card'><div id='imgwrap'>"
									+"<img class='card-img-top' src="+item.imgsrc+
									" alt='Card image cap'></div>"
									+ "<div class='card-body'><h5 class='card-title'>"
									+item.viewtitle
									+ "</h5>"
									+ "<p class='card-text'>"
									+ item.viewWriter
									+ "<br><strong>"
									+ item.bprice
									+ "</strong></p></div></div>")
									.appendTo(
											"#content-best-card");
						});
						var a = $("<div id='bestnext'>"
								+ "<img src='${cp }/resources/hd/image/nextButton.png' id='bestnextimg'>"
								+ "</div>").appendTo("#content-best-card");
						a.click(function() {
							if (bestpageNum >= 2) {
								bestpageNum = 1;
							} else {
								bestpageNum = bestpageNum + 1;
							}
							removeBest();
							viewBest();
						});
						b.click(function() {
							if (bestpageNum <= 1) {
								bestpageNum = 2;
							} else {
								bestpageNum = bestpageNum - 1;
							}
							removeBest();
							viewBest();
						});

					}
				});
	}
	var removeBest = function() {
		$("#content-best-card").empty();
	}

	var viewnew = function() {
		$
				.ajax({
					url : "${cp}/home/newlist",
					dataType : "json",
					data : {
						pageNum : newpageNum
					},
					success : function(data) {
						var b = $(
								"<div id='newprev'>"
										+ "<img src='${cp }/resources/hd/image/prevButton.png' id='newprevimg'>"
										+ "</div>").appendTo(
								"#content-new-card");
						$(data)
								.each(
										function(index, item) {
											$(
													"<div class='card'><div id='imgwrap'><img class='card-img-top' src="+item.imgsrc+
								" alt='Card image cap'></div>"
															+ "<div class='card-body'><h5 class='card-title'>"
															+ item.viewtitle
															+ "</h5>"
															+ "<p class='card-text'>"
															+ item.viewWriter
															+ "<br><strong>"
															+ item.bprice
															+ "</strong></p></div></div>")
													.appendTo(
															"#content-new-card");

										});
						var a = $(
								"<div id='newnext'>"
										+ "<img src='${cp }/resources/hd/image/nextButton.png' id='newnextimg'>"
										+ "</div>").appendTo(
								"#content-new-card");
						a.click(function() {
							if (newpageNum >= 2) {
								newpageNum = 1;
							} else {
								newpageNum = newpageNum + 1;
							}
							removenew();
							viewnew();
						});
						b.click(function() {
							if (newpageNum <= 1) {
								newpageNum = 2;
							} else {
								newpageNum = newpageNum - 1;
							}
							removenew();
							viewnew();
						});

					}
				});
	}
	var removenew = function() {
		$("#content-new-card").empty();
	}
</script>
<div class="container" id="main_container">
	<div id="carosel_wrap">
		<div class="center-block">
			<div id="imgslide" class="carousel slide" data-ride="carousel">
				<!-- 인디케이터 -->
				<ol class="carousel-indicators">
					<li data-target="#imgslide" data-slide-to="0" class="active"></li>
					<!--0번부터시작-->
					<li data-target="#imgslide" data-slide-to="1"></li>
					<li data-target="#imgslide" data-slide-to="2"></li>
				</ol>
				<!-- 인디케이터 끝 -->
				<div class="carousel-inner">
					<!-- 슬라이드 쇼 -->
					<div class="carousel-item active" id="slideForm">
						<!--가로-->
						<img class="d-block w-100"
							src="${cp }/resources/hd/img/slide/slide1.png" alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100"
							src="${cp }/resources/hd/img/slide/slide2.png" alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block w-100"
							src="${cp }/resources/hd/img/slide/slide3.png" alt="Third slide">
					</div>
					<!-- / 슬라이드 쇼 끝 -->
					<!-- 왼쪽 오른쪽 화살표 버튼 -->
					<a class="carousel-control-prev" href="#imgslide" role="button"
						data-slide="prev"> <span class="carousel-control-prev-icon"
						aria-hidden="true"></span>

					</a> <a class="carousel-control-next" href="#imgslide" role="button"
						data-slide="next"> <span class="carousel-control-next-icon"
						aria-hidden="true"></span>

					</a>
					<!-- / 화살표 버튼 끝 -->

				</div>
			</div>
		</div>
	</div>
	<div id="content-mid-best" class="shadow">
		<h3><span class="colorfont">베스트</span> 셀러</h3>
		<div id="content-best-card"></div>
	</div>
	<br>
	<div id="content-mid-new" class="shadow">
		<h3><span class="colorfont">신</span>간</h3>
		<div id="content-new-card"></div>
	</div>
	<br> <br>
</div>
