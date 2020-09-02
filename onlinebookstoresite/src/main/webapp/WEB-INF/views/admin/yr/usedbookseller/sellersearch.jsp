<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class = "container-fluid">
<form action="${pageContext.request.contextPath }/admin/seller" method="post" id="searchform">
	<h2 class="pageTitle">판매자 정산 관리</h2>
	<table class="table searchbox">
		<tr>
			<th class="table-active">검색어</th>
			<td colspan="3">
				<div class="form-group row">
					<div class="col-xs-2 ">
					
						<select class="form-control" name = "pfield">
							<option value =''>--선택--</option>
							<option value="sellername" <c:if test="${pfield == 'sellername'}">selected</c:if>>판매자</option>
							<option value="mname"<c:if test="${pfield == 'mname'}">selected</c:if> >구매자</option>
						</select>
						
					</div>
					<div class="col-xs-3">
						<input class="form-control" type="text" name="pkeyword" value = "${pkeyword }">
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<th class="table-active">기간</th>
			<td colspan="3">
				<div class="row">
					<select name = "tfield" class = "col col form-control col-md-1">
						<option value =''>--선택--</option>
						<option value="borderdate" <c:if test="${tfield == 'borderdate'}">selected</c:if>>주문일</option>													
						<option value="bpaydate" <c:if test="${tfield == 'bpaydate'}">selected</c:if>>결제일</option>			
					</select>
					<div class='col-md-4'>
						<input class="btn btn-outline-success btn-sm dbtn" type="button"
							name="today" value="오늘"> <input
							class="btn btn-outline-success btn-sm dbtn" type="button"
							name="tomorrow" value="어제"> <input
							class="btn btn-outline-success btn-sm dbtn" type="button"
							name="seven" value="7일"> <input
							class="btn btn-outline-success btn-sm dbtn" type="button"
							name="month" value="1개월"> <input
							class="btn btn-outline-success btn-sm dbtn" type="button"
							name="sixmonth" value="6개월">
					</div>
						<div>
							<input type="date" name = "startDate" id = "startDate" value="${startDate }"> &nbsp;~ &nbsp;
							<input type="date" name = "endDate" id = "endDate" value="${endDate }">
						</div>
				</div>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="4"><input
				class="btn btn-outline-success float-right yrbtn" id = "resetBtn" type="reset"
				value="초기화"> <input class="btn btn-success float-right yrbtn"
				id = "searchSubmitBtn" type = "button" value="검색"></td>
		</tr>
	</table>
</form>
</div>