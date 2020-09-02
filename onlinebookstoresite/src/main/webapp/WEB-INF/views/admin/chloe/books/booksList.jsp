<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<link href="${pageContext.request.contextPath }/resources/yjcss/css/madeByChloe.css" rel="stylesheet" />

<div class="container-fluid">
	<br>
	<div style="font-size: 2rem; margin-left: 25px">
		<i class="fas fa-table mr-1"></i> 책검색
	</div>
	<br>
	
	<div class="container-fluid">
		<form action="${pageContext.request.contextPath }/booksList" method="post">
			<table class="table">
				<tr>
					<th style="text-align: center;" class="table-active">검색어</th>
					<td>
						<select name="infoField">
							<option value="btitle"
								<c:if test="${infoField == 'btitle' }">selected</c:if>>제목</option>
							<option value="bwriter"
								<c:if test="${infoField == 'bwriter' }">selected</c:if>>작가(지은이)</option>
							<option value="bpublisher"
								<c:if test="${infoField == 'bpublisher' }">selected</c:if>>출판사</option>
						</select>
						<input type="text" name="infoKeyword" value="${infoKeyword }" size="30">
					</td>

					<th style="text-align: center;" class="table-active">가격</th>
					<td>
						<input type="text" name="priceKeyword1" value="${priceKeyword1 }" size="10">&nbsp;원&nbsp;~
						<input type="text" name="priceKeyword2" value="${priceKeyword2 }" size="10" disabled="disabled">&nbsp;원
					</td>
				</tr>

				<tr>
					<th style="text-align: center;" class="table-active">재고수량</th>
					<td>
						<input type="text" name="countKeyword1" value="${countKeyword1 }" size="6">&nbsp;개&nbsp;~
						<input type="text" name="countKeyword2" value="${countKeyword2 }" size="6" disabled="disabled">&nbsp;개
					</td>

					<th style="text-align: center;" class="table-active">등록일</th>
					<td>
						<input type="date" name="dateKeyword1" value="${dateKeyword1 }">&nbsp;~&nbsp;
						<input type="date" name="dateKeyword2" value="${dateKeyword2 }" disabled="disabled">
					</td>
				</tr>

				<tr>
					<td align="center" colspan="4">
						<input type="submit" value="검&nbsp;&nbsp;색" class="btn btn-outline-success">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
	
	<div style="font-size: 2rem; margin-left: 25px">
		<i class="fas fa-table mr-1"></i> 등록상품조회
		<span style="font-size: 15px;">검색결과&nbsp;:&nbsp;${pu.totalRowCnt }개</span>
		<span style="margin-left: 1080px;">
			<button onclick="location.href='${pageContext.request.contextPath}/booksExcelDownload'" 
						type="button" class="btn btn-outline-success">엑셀 다운로드</button>
		</span>
	</div>
	<br>
	<div class="container-fluid">
		<table class="table">
			<thead>
				<tr class="table-active">
					<th align="center">책제목</th>
					<th>미리보기</th>
					<th>작가(지은이)</th>
					<th>출판사</th>
					<th>가격&nbsp;(원)</th>
					<th>재고&nbsp;(개)</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tfoot>
				<tr class="table-active">
					<th align="center">책제목</th>
					<th>미리보기</th>
					<th>작가(지은이)</th>
					<th>출판사</th>
					<th>가격&nbsp;(원)</th>
					<th>재고&nbsp;(개)</th>
					<th>등록일</th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${vo.btitle }</td>
						<td><a href="${pageContext.request.contextPath}/preview?bnum=${vo.bnum}" class="btn-outline-success">미리보기</a></td>
						<td>${vo.bwriter }</td>
						<td>${vo.bpublisher }</td>
						<td>${vo.bprice }</td>
						<td>${vo.bcount }</td>
						<fmt:formatDate value="${vo.bregdate }" pattern="yy/MM/dd" var="bregdate" />
						<td>${bregdate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container-fluid">
		<!-- 페이징 -->
		<div id="listPaging">
			<c:choose>
				<c:when test="${pu.startPageNum > 1 }">
					<button onclick="location.href='${pageContext.request.contextPath }/booksList?pageNum=${pu.startPageNum - 1}'" 
						type="button" class="btn btn-outline-success">이전</button>
				</c:when>
				<c:otherwise>
					<button class="btn btn-outline-success" disabled="disabled">이전</button>
				</c:otherwise>
			</c:choose>

			<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
				<c:choose>
					<c:when test="${i == pu.pageNum }">
						<button type="button" class="btn btn-outline-success" 
							onclick="location.href='${pageContext.request.contextPath }/booksList?pageNum=${i}&infoField=${infoField}&infoKeyword=${infoKeyword}&priceKeyword1=${priceKeyword1}&priceKeyword2=${priceKeyword2}&countKeyword1=${countKeyword1}&countKeyword2=${countKeyword2}&dateKeyword1=${dateKeyword1}&dateKeyword2=${dateKeyword2}'">${i }</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-outline-success" 
							onclick="location.href='${pageContext.request.contextPath }/booksList?pageNum=${i}&infoField=${infoField}&infoKeyword=${infoKeyword}&priceKeyword1=${priceKeyword1}&priceKeyword2=${priceKeyword2}&countKeyword1=${countKeyword1}&countKeyword2=${countKeyword2}&dateKeyword1=${dateKeyword1}&dateKeyword2=${dateKeyword2}'">${i }</button>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:choose>
				<c:when test="${pu.totalPageCnt > pu.endPageNum }">
					<button onclick="location.href='${pageContext.request.contextPath }/booksList?pageNum=${pu.endPageNum + 1}'" 
						type="button" class="btn btn-outline-success">다음</button>
				</c:when>
				<c:otherwise>
					<button class="btn btn-outline-success" disabled="disabled">다음</button>
				</c:otherwise>
			</c:choose>
		</div>
		<br>
		<!-- ////////////////// -->
	</div>
</div>

<script>
	//가격
	$("input[name='priceKeyword1']").change(function() {
		$("input[name='priceKeyword2']").prop('disabled', false);
	});

	$("input[name='priceKeyword2']").change(function() {
		var priceKeyword1 = parseInt($("input[name='priceKeyword1']").val());
		var priceKeyword2 = parseInt($("input[name='priceKeyword2']").val());
		if (priceKeyword1 > priceKeyword2) {
			$("input[name='priceKeyword1']").val('');
			$("input[name='priceKeyword1']").focus();
			$("input[name='priceKeyword2']").val('');
			alert("숫자 범위를 정확히 입력해주세요");
		}
	});

	//재고수량
	$("input[name='countKeyword1']").change(function() {
		$("input[name='countKeyword2']").prop('disabled', false);
	});

	$("input[name='countKeyword2']").change(function() {
		var priceKeyword1 = parseInt($("input[name='countKeyword1']").val());
		var priceKeyword2 = parseInt($("input[name='countKeyword2']").val());
		if (priceKeyword1 > priceKeyword2) {
			$("input[name='countKeyword1']").val('');
			$("input[name='countKeyword1']").focus();
			$("input[name='countKeyword2']").val('');
			alert("숫자 범위를 정확히 입력해주세요");
		}
	});

	//등록일
	$("input[name='dateKeyword1']").change(function() {
		$("input[name='dateKeyword2']").prop('disabled', false);
	});

	$("form").submit(function() {
		var priceKeyword1 = $("input[name='priceKeyword1']");
		var priceKeyword2 = $("input[name='priceKeyword2']");

		if (isNaN(priceKeyword1.val())) {
			alert("가격을 숫자로만 입력해 주세요");
			priceKeyword1.focus();
			return false;
		}
		if (isNaN(priceKeyword2.val())) {
			alert("가격을 숫자로만 입력해 주세요");
			priceKeyword2.focus();
			return false;
		}

		var countKeyword1 = $("input[name='countKeyword1']");
		var countKeyword2 = $("input[name='countKeyword2']");

		if (isNaN(countKeyword1.val())) {
			alert("재고수량을 숫자로만 입력해 주세요");
			countKeyword1.focus();
			return false;
		}
		if (isNaN(countKeyword2.val())) {
			alert("재고수량을 숫자로만 입력해 주세요");
			countKeyword2.focus();
			return false;
		}
		return true;
	});
</script>