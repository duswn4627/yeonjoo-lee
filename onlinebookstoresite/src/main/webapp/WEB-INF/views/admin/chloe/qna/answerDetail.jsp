<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="container-fluid">
	<br>
	<div style="font-size: 2rem; margin-left: 25px">
		<i class="fas fa-table mr-1"></i> ${vo.mid }님의&nbsp;질문&nbsp;상세내용&nbsp;및&nbsp;답변&nbsp;상세
	</div>
	<br>

	<div class="container-fluid">
		<table class="table">
			<tr>
				<th style="text-align: center;" class="table-active">문&nbsp;의&nbsp;번&nbsp;호</th>
				<td colspan="3">${vo.qnanum }</td>
			</tr>

			<tr>
				<th style="text-align: center;" class="table-active">회&nbsp;원&nbsp;번&nbsp;호</th>
				<td>${vo.mnum }</td>
				<th style="text-align: center;" class="table-active">작&nbsp;성&nbsp;자</th>
				<td>${vo.mid }</td>
			</tr>

			<tr>
				<th style="text-align: center;" class="table-active">문&nbsp;의&nbsp;제&nbsp;목</th>
				<td colspan="3">${vo.qnatitle }</td>
			</tr>

			<tr>
				<th style="text-align: center;" class="table-active">문&nbsp;의&nbsp;내&nbsp;용</th>
				<td colspan="3">
					<div style="height: 150px;">${vo.qcontent }</div>
				</td>
			</tr>

			<tr>
				<th style="text-align: center;" class="table-active">답&nbsp;변&nbsp;내&nbsp;용</th>
				<td colspan="3"><div style="height: 150px;">${vo.acontent }</div></td>
			</tr>

			<tr>
				<th style="text-align: center;" class="table-active">답&nbsp;변&nbsp;일&nbsp;자</th>
				<fmt:formatDate value="${vo.adate }" pattern="yyyy/MM/dd" var="adate" />
				<td colspan="3">${adate }</td>
			</tr>

			<tr>
				<td align="center" colspan="4">
					<button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#myModal">답변수정</button>
					<button type="button" class="btn btn-outline-danger" 
						onclick="location.href='${pageContext.request.contextPath}/qnaAnswerDelete?qnanum=${vo.qnanum}'">답변삭제</button>
				</td>
			</tr>

			<tr>
				<td align="center" colspan="4">
					<button type="button" onclick="history.back()" class="btn btn-outline-secondary">확&nbsp;인</button>
				</td>
			</tr>
		</table>
	</div>

	<!-- 답변수정모달 -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">답변수정</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<div class="modal-body">
					<form method="post" action="${pageContext.request.contextPath }/qnaAnswerUpdate" id="frm">
						<input type="hidden" name="qnanum" value="${vo.qnanum }">
						<input type="hidden" name="mnum" value="${vo.mnum }">
						<input type="hidden" name="qnatitle" value="${vo.qnatitle }">
						<input type="hidden" name="qcontent" value="${vo.qcontent }">

						<table class="table">
							<tr>
								<th style="text-align: center;" class="table-active">본&nbsp;문&nbsp;내&nbsp;용</th>
								<td colspan="3">
									<div style="height: 300px;">${vo.qcontent }</div>
								</td>
							</tr>

							<tr>
								<th style="text-align: center;" class="table-active">수정할&nbsp;답변내용</th>
								<td><textarea rows="10" cols="120" name="acontent" id="acontent">${vo.acontent }</textarea></td>
							</tr>
						</table>
					</form>
				</div>
				
				<div class="modal-footer">
					<input type="button" value="수&nbsp;정" class="btn btn-outline-success" id="submitBtn">
					<button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</div>


<style>
table th {
	width: 200px;
}
</style>

<script>
	$("#submitBtn").click(function() {
		var acontent = $("#acontent");
		if (acontent.val() == "") {
			alert("내용을 입력해 주세요");
			acontent.focus();
			return false;
		}
		$("#frm").submit();
	});
</script>