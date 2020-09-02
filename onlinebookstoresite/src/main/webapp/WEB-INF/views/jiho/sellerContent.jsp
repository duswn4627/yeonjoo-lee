<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="sellerContentMain">
	<img src="${cp }/resources/jh/jhimages/중고판매자상황판.png" style="margin-left: 150px;">
	<!-- 판매현황카드 -->
	<div id="salesStatus" class="sellerCard">
		<div class="card bg-light">
		<p style="margin-left: 20px;">* 최근1개월 현황</p>
		<br>
			<table class="table">
				<tr>
					<th><a href="${cp}/seller/prodLook"><span style="color: black;">등록상품</span></a></th>
					<td><a href="${cp }/seller/prodLook">${getOldbookCount }개</a></td>
				</tr>
				<tr>
					<th><a href="${cp}/seller/salesManagement?tabType=1"><span style="color: black;">입금대기중</span></a></th>
					<td><a href="${cp}/seller/salesManagement?tabType=1">${getOldbookSalestatusCount1}개</a></td>
				</tr>
				<tr>
					<th><a href="${cp}/seller/salesManagement2?tabType=2"><span style="color: black;">입금완료/배송요청</span></a></th>
					<td><a href="${cp}/seller/salesManagement2?tabType=2">${getOldbookSalestatusCount2}개</a></td>
				</tr>
				<tr>
					<th><a href="${cp}/seller/salesManagement3?tabType=3"><span style="color: black;">배송중/구매확정전</span></a></th>
					<td><a href="${cp}/seller/salesManagement3?tabType=3">${getOldbookSalestatusCount3}개</a></td>
				</tr>
				<tr>
					<th><a href="${cp}/seller/salesManagement4?tabType=4"><span style="color: black;">구매확정/정산대기</span></a></th>
					<td><a href="${cp}/seller/salesManagement4?tabType=4">${getObcompleteCount1}개</a></td>
				</tr>
				<tr>
					<th><a href="${cp }/seller/settlementCheck"><span style="color: black;">구매확정</span></a></th>
					<td><a href="${cp }/seller/settlementCheck">${getOldbookSalestatusCount4}개</a></td>
				</tr>
				<tr>
					<th><a href="${cp }/seller/settlementCheck"><span style="color: black;">정산완료</span></a></th>
					<td><a href="${cp }/seller/settlementCheck">${getObcompleteCount2}개</a></td>
				</tr>
				<tr>
					<th><a href="${cp }/seller/qnalist"><span style="color: black;">미답변 Q&A</span></a></th>
					<td><a href="${cp }/seller/qnalist">${getMainQnaCount }개</a></td>
				</tr>
				<tr>
					<th><a href="${cp }/seller/review"><span style="color: black;"></span></a>판매평가/리뷰</th>
					<td><a href="${cp }/seller/review">${getSellerReviewCount }개</a></td>
				</tr>
			</table>
		</div>
	</div>
</div>
