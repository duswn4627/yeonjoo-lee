<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<link href="${pageContext.request.contextPath }/resources/yjcss/css/madeByChloe.css" rel="stylesheet" />

<div class="container-fluid">
	<br>
	<div style="font-size: 2rem; margin-left: 25px">
		<i class="fas fa-table mr-1"></i> 탈퇴회원검색
	</div>
	<br>

	<div class="container-fluid">
		<form action="${pageContext.request.contextPath }/ghostList" method="post">
			<table class="table">
				<tr>
					<th class="table-active">검색어</th>
					<td>
						<select name="infoField">
							<option value="mname"
								<c:if test="${infoField == 'mname' }">selected</c:if>>이름</option>
							<option value="mid"
								<c:if test="${infoField == 'mid' }">selected</c:if>>아이디</option>
							<option value="email"
								<c:if test="${infoField == 'email' }">selected</c:if>>이메일</option>
							<option value="phone"
								<c:if test="${infoField == 'phone' }">selected</c:if>>휴대폰번호</option>
						</select>
						<input type="text" name="infoKeyword" value="${infoKeyword }" size="35">
					</td>
				</tr>

				<tr>
					<th class="table-active">나이</th>
					<td>
						<input type="text" name="ageKeyword1" value="${ageKeyword1 }" size="3">&nbsp;세&nbsp;~
						<input type="text" name="ageKeyword2" value="${ageKeyword2 }" size="3" disabled="disabled">&nbsp;세
					</td>
				</tr>
				
				<tr>
					<th class="table-active">가입일</th>
					<td>
						<input type="date" name="dateKeyword1" value="${dateKeyword1 }">&nbsp;~ 
						<input type="date" name="dateKeyword2" value="${dateKeyword2 }">
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

	<!-- 리스트 -->
	<div style="font-size: 2rem; margin-left: 25px">
		<i class="fas fa-table mr-1"></i> 회원&nbsp;목록
		<span style="font-size: 15px;">검색결과&nbsp;:&nbsp;${pu.totalRowCnt }명</span>
				<span style="margin-left: 1150px;"> <button onclick="location.href='${pageContext.request.contextPath}/excelGhostList'" type="button" class="btn btn-outline-success">엑셀 다운로드</button></span>
		
	</div>
	<br>
	
	<div class="container-fluid">
		<table class="table">
			<thead>
				<tr class="table-active">
					<th>이름</th>
					<th>아이디</th>
					<th>휴대전화</th>
					<th>이메일</th>
					<th>생년월일</th>
					<th>만&nbsp;나이</th>
					<th>가입일</th>
					<th>상세</th>
				</tr>
			</thead>
			<tfoot>
				<tr class="table-active">
					<th>이름</th>
					<th>아이디</th>
					<th>휴대전화</th>
					<th>이메일</th>
					<th>생년월일</th>
					<th>만&nbsp;나이</th>
					<th>가입일</th>
					<th>상세</th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td>${vo.mname}</td>
						<td>${vo.mid}</td>
						<td>${vo.phone}</td>
						<td>${vo.email}</td>
						<fmt:formatDate value="${vo.birth}" pattern="yy/MM/dd" var="birth" />
						<td>${birth}</td>
						<td>${vo.age}</td>
						<fmt:formatDate value="${vo.regdate}" pattern="yy/MM/dd" var="regdate" />
						<td>${regdate}</td>
						<td><a class="btn-outline-success" href="${pageContext.request.contextPath}/ghostInfo?mnum=${vo.mnum}">상세</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- 페이징 -->
	<div class="container-fluid">
		<div id="listPaging">
			<c:choose>
				<c:when test="${pu.startPageNum > 1 }">
					<button onclick="location.href='${pageContext.request.contextPath }/ghostList?pageNum=${pu.startPageNum - 1}'" 
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
							onclick="location.href='${pageContext.request.contextPath }/ghostList?pageNum=${i}&infoField=${infoField}&infoKeyword=${infoKeyword}&ageKeyword1=${ageKeyword1}&ageKeyword2=${ageKeyword2}&dateKeyword1=${dateKeyword1}&dateKeyword2=${dateKeyword2}'">${i }</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-outline-success" 
							onclick="location.href='${pageContext.request.contextPath }/ghostList?pageNum=${i}&infoField=${infoField}&infoKeyword=${infoKeyword}&ageKeyword1=${ageKeyword1}&ageKeyword2=${ageKeyword2}&dateKeyword1=${dateKeyword1}&dateKeyword2=${dateKeyword2}'">${i }</button>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:choose>
				<c:when test="${pu.totalPageCnt > pu.endPageNum }">
					<button onclick="location.href='${pageContext.request.contextPath }/ghostList?pageNum=${pu.endPageNum + 1}'" 
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
	$("input[name='ageKeyword1']").change(function() {
		$("input[name='ageKeyword2']").prop('disabled', false);
	});

	$("input[name='ageKeyword2']").change(function() {
		var ageKeyword1 = parseInt($("input[name='ageKeyword1']").val());
		var ageKeyword2 = parseInt($("input[name='ageKeyword2']").val());
		if (ageKeyword1 > ageKeyword2) {
			$("input[name='ageKeyword1']").val('');
			$("input[name='ageKeyword1']").focus();
			$("input[name='ageKeyword2']").val('');
			alert("숫자 범위를 정확히 입력해주세요");
		}
	});

	$("form").submit(function() {
		var ageKeyword1 = $("input[name='ageKeyword1']");
		var ageKeyword2 = $("input[name='ageKeyword2']");

		if (isNaN(ageKeyword1.val())) {
			alert("가격을 숫자로만 입력해 주세요");
			ageKeyword1.focus();
			return false;
		}
		if (isNaN(ageKeyword2.val())) {
			alert("가격을 숫자로만 입력해 주세요");
			ageKeyword2.focus();
			return false;
		}
		return true;
	});
</script>