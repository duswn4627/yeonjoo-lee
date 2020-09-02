<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="mt-4 mainTitle pageTitle">전체주문관리</h2>
<div class="container-fluid ">
	<form action="${pageContext.request.contextPath }/totalOrder" method = "post" id="searchform">
		<table class="table searchbox">
			<tr>
				<th class="table-active">검색어</th>
				<td colspan="3">
					<div class="form-group row">
						<div class = "col-xs-2 ">
							<select class="form-control" name = "pfield">
								<option value=''>--선택--</option>
								<option value="bpaynum"<c:if test="${pfield == 'bpaynum'}">selected</c:if>>주문번호</option>
								<option value="mname" <c:if test="${pfield == 'mname'}">selected</c:if>>주문자명</option>
							</select>
						</div>
						<div class = "col-xs-3">
							<input class="form-control" type="text" name="pkeyword" value="${pkeyword }">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<th class="table-active">기간</th>
				<td colspan="3">
					<div class = "row">
						<select name = "tfield" class = "col form-control col-md-1">	
							<option value=''>--선택--</option>
							<option value="borderdate" <c:if test="${tfield == 'borderdate'}">selected</c:if>>주문일</option>
							<option value="bpaydate" <c:if test="${tfield == 'bpaydate'}">selected</c:if>>결제일</option>
						</select>
						<div class='col-md-3'> 
							<input class="btn btn-outline-success btn-sm dbtn" type="button" name="today" value = "오늘">
							<input class="btn btn-outline-success btn-sm dbtn" type="button" name="yesterday" value = "어제">
							<input class="btn btn-outline-success btn-sm dbtn" type="button" name="seven" value = "7일">
							<input class="btn btn-outline-success btn-sm dbtn" type="button" name="month" value = "1개월">
							<input class="btn btn-outline-success btn-sm dbtn" type="button" name="sixmonth" value = "6개월">
						</div>
						<div>
							<input type="date" name = "startDate" id = "startDate" value="${startDate }"> &nbsp;~ &nbsp;
							<input type="date" name = "endDate" id = "endDate" value="${endDate }">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<th class="table-active">상품</th>
				<td colspan="3">
					
					<div class="form-group row">
						<div class = "col-xs-2 ">
							<select class="form-control" name = "bfield">
								<option selected="selected" value=''>--선택--</option>
								<option value="btitle" <c:if test="${bfield == 'btitle'}">selected</c:if>>책 제목</option>
								<option value="bnum" <c:if test="${bfield == 'bnum'}">selected</c:if>>책 번호</option>
							</select>
						</div>
						<div class = "col-xs-3">
							<input class="form-control" type="text" name="bkeyword" value="${bkeyword }">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<th class="table-active">주문상태</th>
				<td colspan="3">
					
						<input class = "searchChb" type="checkbox" name= "bstatus" value="-1" id = "pstotal"<c:forEach var="bstatus" items="${bstatus }"> <c:if test="${bstatus == '-1'}">checked</c:if></c:forEach>><label for="pstotal"> &nbsp;전체 &nbsp;&nbsp;</label>
						<input class = "searchChb"type="checkbox" name= "bstatus" value="0,1" id = "beforeShip"<c:forEach var="bstatus" items="${bstatus }"> <c:if test="${bstatus == '0' || bstatus == '1' }">checked</c:if></c:forEach>><label for="beforeShip"> &nbsp;배송전&nbsp;&nbsp;</label>
						<input class = "searchChb"type="checkbox" name= "bstatus" value="2" id = "shipping" <c:forEach var="bstatus" items="${bstatus }"><c:if test="${bstatus == '2'}">checked</c:if></c:forEach>><label for="shipping"> &nbsp;배송중&nbsp;&nbsp;</label>
						<input class = "searchChb" type="checkbox" name= "bstatus" value="3" id = "completeShip" <c:forEach var="bstatus" items="${bstatus }"><c:if test="${bstatus == '3'}">checked</c:if></c:forEach>><label for="completeShip"> &nbsp;배송 완료&nbsp;&nbsp;</label>
					
				</td>
			</tr>
			<tr>
				<th class="table-active">cs주문상태</th>
				<td colspan="3">
					
						<input class = "searchChb"type="checkbox" name= "type" value="-1" id = "cpstotal" <c:forEach var="type" items="${type}"><c:if test="${type == '-1'}">checked</c:if></c:forEach>><label for="cpstotal"> &nbsp;전체 &nbsp;&nbsp;</label>
						<input class = "searchChb"type="checkbox" name= "type" value="1" id = "cancle" <c:forEach var="type" items="${type}"><c:if test="${type == '1'}">checked</c:if></c:forEach>><label for="cancle"> &nbsp;취소 &nbsp;&nbsp;</label>
						<input class = "searchChb"type="checkbox" name= "type" value="2" id = "return" <c:forEach var="type" items="${type}"><c:if test="${type == '2'}">checked</c:if></c:forEach>><label for="return"> &nbsp;반품 &nbsp;&nbsp;</label>
						<input class = "searchChb"type="checkbox" name= "type" value="3" id = "exchange" <c:forEach var="type" items="${type}"><c:if test="${type == '3'}">checked</c:if></c:forEach>><label for="exchange"> &nbsp;교환 &nbsp;&nbsp;</label>
				</td>
			</tr>
			<tr>
				<th class="table-active">입금 / 결제 상태</th>
				<td><input type="radio" name="payType" value="-1" id="ptotal"
					<c:if test="${payType == '-1'}">checked</c:if>><label
					for="ptotal"> &nbsp;전체 &nbsp;&nbsp;</label> <input type="radio"
					name="payType" value="0" id="pbefore"
					<c:if test="${payType == '0'}">checked</c:if>><label
					for="pbefore"> &nbsp;입금 전 &nbsp;&nbsp;</label> <input type="radio"
					name="payType" value="1" id="pafter"
					<c:if test="${payType == '1'}">checked</c:if>><label
					for="pafter"> &nbsp;입금 완료 &nbsp;&nbsp;</label></td>
				<th class="table-active">회원 / 비회원</th>
				<td>
					<input type="radio" name="mType" value="-1" id = "mtotal" <c:if test="${mType == '-1'}">checked</c:if>><label for="mtotal"> &nbsp;전체 &nbsp;&nbsp;</label>
					<input type="radio" name="mType" value="1" id = "member"<c:if test="${mType == '1'}">checked</c:if>><label for ="member"> &nbsp;회원 &nbsp;&nbsp;</label>
					<input type="radio" name="mType" value="2" id = "nonemember"<c:if test="${mType == '2'}">checked</c:if>><label for="nonemember"> &nbsp;비회원 &nbsp;&nbsp;</label>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="4">
					<input  class="btn btn-outline-success float-right yrbtn" id = "resetBtn" type = "reset" value = "초기화">
					<input class="btn btn-success float-right yrbtn" id = "searchSubmitBtn" type = "button" value = "검색" >
				</td>		
			</tr>
		</table>
	</form>
</div>
