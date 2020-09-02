<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link href="${pageContext.request.contextPath }/resources/yjcss/css/madeByChloe.css" rel="stylesheet" />

<div class="container-fluid">
	<br>
	<div style="font-size: 2rem; margin-left: 25px">
		<i class="fas fa-table mr-1"></i> Q&A관리
	</div>
	<br>

	<div class="container-fluid">
		<!-- 탭 -->
		<div class="container">
			<ul class="nav nav-pills nav-justified">
				<li class="nav-item">
					<a class="nav-link active btn btn-outline-success qnaSelector" href="${pageContext.request.contextPath}/unAnswerList">미답변&nbsp;[${pu.totalRowCnt }건]</a>
				</li>
				<li class="nav-item">
					<a class="nav-link btn btn-outline-success qnaSelector" href="${pageContext.request.contextPath}/answerList">답변완료</a>
				</li>
			</ul>
		</div>
		<br>

		<div class="container-fluid">
			<!-- 리스트 테이블 -->
			<table class="table" style="text-align: center;">
				<colgroup>
					<col width="5%">
					<col width="15%">
					<col width="">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr class="table-active">
						<th scope="col">번&nbsp;호</th>
						<th scope="col">작&nbsp;성&nbsp;자</th>
						<th scope="col" style="text-align: center;">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
						<th scope="col">질문작성일</th>
						<th scope="col">답변일자</th>
					</tr>
				</thead>
				<tfoot>
					<tr class="table-active">
						<th>번&nbsp;호</th>
						<th>작&nbsp;성&nbsp;자</th>
						<th style="text-align: center;">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
						<th>질문작성일</th>
						<th>답변일자</th>
					</tr>
				</tfoot>
				<tbody>
					<c:forEach var="vo" items="${list }">
						<tr>
							<td>${vo.qnanum }</td>
							<td>${vo.mid }</td>
							<td style="text-align: left;">${vo.qnatitle }&nbsp;&nbsp;&nbsp;
								<a class="btn-outline-success" href="${pageContext.request.contextPath}/unAnswerDetail?qnanum=${vo.qnanum}">더보기</a>
							</td>
							<fmt:formatDate value="${vo.qnadate }" pattern="yyyy/MM/dd" var="qnadate" />
							<td>${qnadate }</td>
							<td>미답변</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="container-fluid">
				<!-- 페이징 -->
				<div id="listPaging">
					<c:choose>
						<c:when test="${pu.startPageNum > 1 }">
							<button onclick="location.href='${pageContext.request.contextPath }/unAnswerList?pageNum=${pu.startPageNum - 1}'"
								type="button" class="btn btn-outline-success">이전</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-outline-success" disabled="disabled">이전</button>
						</c:otherwise>
					</c:choose>

					<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
						<c:choose>
							<c:when test="${i == pu.pageNum }">
								<button onclick="location.href='${pageContext.request.contextPath }/unAnswerList?pageNum=${i}'"
									type="button" class="btn btn-outline-success">${i }</button>
							</c:when>
							<c:otherwise>
								<button onclick="location.href='${pageContext.request.contextPath }/unAnswerList?pageNum=${i}'"
									type="button" class="btn btn-outline-success">${i }</button>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:choose>
						<c:when test="${pu.totalPageCnt > pu.endPageNum }">
							<button onclick="location.href='${pageContext.request.contextPath }/unAnswerList?pageNum=${pu.endPageNum + 1}'"
								type="button" class="btn btn-outline-success">다음</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-outline-success" disabled="disabled">다음</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<!-- ////////////////// -->
			<br>
		</div>
	</div>
</div>

<script>
	$(".qnaSelector").click(function() {
		$(".qnaSelector").each(function() {
			$(this).removeClass('active');
		});
		$(this).addClass('active');
	});
</script>