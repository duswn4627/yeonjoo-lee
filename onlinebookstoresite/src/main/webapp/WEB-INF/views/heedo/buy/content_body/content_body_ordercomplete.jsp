<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${cp }/resources/hd/css_main/result.css" />
<div class="container" id="resultcontainer"> 
	<div class='contentbox'>
		<img src="${cp }/resources/hd/image/quotation_open.png" class="quotationimg">
		<h2 style='display:inline'>${vo.name }님  GoBooK을 이용해주셔서 감사합니다!</h2>
		<img src="${cp }/resources/hd/image/quotation_close.png" class="quotationimg">
		<p id="orderP">주문번호 : [<strong>${ vo.ordernum }</strong>] 결제가 안전하게 처리되었습니다.</p>
	</div>
	<div class='contentbox' id="topcontentdiv">
		<c:choose>
			<c:when test="${ method=='vbank' && separate=='new' }">
				<h4>${vo.name }님 가상계좌에 입금해주세요. 입금완료 후 배송이 시작됩니다!</h4>
				<p>입금계좌 : ${bank.vbank_name } ${bank.vbank_num }  예금주 : ${bank.vbank_holder } 입금액 : <strong>${payvalue }</strong>원</p>
			</c:when>
			<c:when test="${ method=='vbank' && separate=='used'}">
				<h4>${vo.name }님 가상계좌에 입금해주세요. 판매자 확인 후 배송이 시작됩니다!</h4>
				<p>입금계좌 : ${bank.vbank_name } ${bank.vbank_num }  예금주 : ${bank.vbank_holder } 입금액 : <strong>${payvalue }</strong>원</p>
			</c:when>
			<c:when test="${ method=='card' && separate=='new'}">
				<h4>${vo.name }님 카드결제 완료! 1-2일이내에 배송이 시작됩니다!</h4>
			</c:when>
			<c:otherwise>
				<h4>${vo.name }님 카드결제 완료! 판매자 확인 후 배송이 시작됩니다!</h4>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="shipdiv">
		<p class="titleloc"><strong><span class="colorfont">배송지</span>정보</strong></p>
		<div id="uldiv">
			<ul>
				<li>받는분 : ${vo.receiver }</li>
				<li>
					주소 :  <img src="${cp }/resources/hd/image/addricon_land.gif"><span>${vo.jibunaddr }</span><br>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<img src="${cp }/resources/hd/image/addricon_road.gif"><span>${vo.roadaddr }</span>
				</li>
			</ul>
		</div>
	</div>
	
	<div id="orderlistdiv">
		<p class="titleloc"><strong><span class="colorfont">주문</span>상품</strong></p>
		<table class="table" id="listtable">
			<!-- ======= 새상품일 경우 시작 =========== -->
			<c:choose>
			<c:when test="${separate=='new' }">
			<thead>
			<tr>
				<th colspan="2" style="text-align: center">상품명</th>
				<th style="text-align: center">판매가</th>
				<th style="text-align: center">포인트</th>
				<th style="text-align: center">수량</th>
				<th style="text-align: center">합계</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${list }">
				<tr>
					<td style='width:10%'><img src="${item.imgpath }" class="listimg"></td>
					<td style='width:53%'>${item.btitle }</td>
					<td style='width:10%;text-align: center;'>${item.bprice }</td>
					<td style='width:10%;text-align: center;'>${item.bpoint }</td>
					<td style='width:8%;text-align: center;'>${item.bcount }</td>
					<td style='width:12%;text-align: center;'><strong>${item.totalvalue }</strong>원</td>
				</tr>
			</c:forEach>
			</tbody>
			</c:when>
			<c:otherwise> 
			<thead>
				<tr>
					<th colspan="2" style="text-align: center">상품명</th>
					<th style="text-align: center">판매자</th>
					<th style="text-align: center">판매가</th>
					<th style="text-align: center">수량</th>
					<th style="text-align: center">합계</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list }">
					<tr>
						<td style='width:10%'><img src="${item.imgpath }" class="listimg"></td>
						<td style='width:53%'>${item.statusString}&nbsp${item.obname }</td>
						<td style='width:10%;text-align: center;'>${item.sid }</td>
						<td style='width:10%;text-align: center;'>${item.obsaleprice }</td>
						<td style='width:8%;text-align: center;'${item.bcount }></td>
						<td style='width:12%;text-align: center;'><strong>${item.totalvalue }</strong>원</td>
					</tr>
				</c:forEach>
			</tbody>
			</c:otherwise>
			</c:choose>
		</table>
	</div>	
	<div>
		<p class="titleloc"><strong><span class="colorfont">결제</span>정보</strong></p>
			<table class="table">
			<tr>
				<th class="table-secondary">총 상품금액</th>
				<th class="table-secondary">배송비</th>
				<th class="table-secondary">사용포인트</th>
				<td rowspan="2" class="table-danger">
					<strong>최종 결제금액</strong><br>
					<span class="final_payment_price">${vo.paymentmoney+vo.delfee}</span>원<br>
					<c:if test="${separate=='new' }">
						<strong>적립예정포인트</strong><br>
						<span id="totalpoint">${totalpoint }</span>
					</c:if>
				</td>
			</tr>	
			<tr class="table-secondary">
				<td>${totalprice }원</td>
				<td><span id="ship_charge">${vo.delfee }</span>원</td>
				<td>
					<span id="use_point">${vo.usedpoint }</span>원
				</td>
			</tr>
			</table>
	</div>
	<div id="buttondiv">
		<a href="${cp }/"><button type="button" class="btn btn-dark" >메인으로이동</button></a> 
		<a href="${cp }/mypage/main"><button type="button" class="btn btn-light">마이페이지</button></a>
	</div>
</div>