<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="container-fluid">
	<br>
	<div style="font-size: 2rem; margin-left: 25px">
		<i class="fas fa-table mr-1"></i> ${vo.mid }님의&nbsp;질문&nbsp;상세내용
	</div>
	<br>

	<div class="container-fluid">
		<table class="table">
			<tr>
				<th style="text-align: center;" class="table-active">문&nbsp;의&nbsp;번&nbsp;호</th>
				<td>${vo.qnanum }</td>
			</tr>

			<tr>
				<th style="text-align: center;" class="table-active">회&nbsp;원&nbsp;번&nbsp;호</th>
				<td>${vo.mnum }</td>
			</tr>

			<tr>
				<th style="text-align: center;" class="table-active">작&nbsp;성&nbsp;자</th>
				<td>${vo.mid }</td>
			</tr>

			<tr>
				<th style="text-align: center;" class="table-active">문&nbsp;의&nbsp;제&nbsp;목</th>
				<td>${vo.qnatitle }</td>
			</tr>

			<tr>
				<th style="text-align: center;" class="table-active">문&nbsp;의&nbsp;내&nbsp;용</th>
				<td>
					<div style="height: 200px;">${vo.qnacontent }</div>
				</td>
			</tr>

			<tr>
				<td align="center" colspan="4">
					<button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#myModal">답변달기</button>
					<button type="button" onclick="history.back()" class="btn btn-outline-secondary">확&nbsp;인</button>
				</td>
			</tr>
		</table>
		<br>
	</div>
</div>

<!-- 답변모달 -->
<div class="modal fade" id="myModal">
	<div class="modal-dialog modal-xl">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">답변달기</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<div class="modal-body">
				<form method="post" action="${pageContext.request.contextPath }/qnaAnswerInsert" id="frm">
					<input type="hidden" name="qnanum" value="${vo.qnanum }"> 
					<input type="hidden" name="mnum" value="${vo.mnum }"> 
					<input type="hidden" name="qnatitle" value="${vo.qnatitle }"> 
					<input type="hidden" name="qnacontent" value="${vo.qnacontent }">

					<table class="table">
						<tr>
							<th style="text-align: center;" class="table-active">본&nbsp;문&nbsp;내&nbsp;용</th>
							<td>
								<div style="height: 300px;">${vo.qnacontent }</div>
							</td>
						</tr>
						<tr>
							<th style="text-align: center;" class="table-active">답&nbsp;변&nbsp;내&nbsp;용</th>
							<td><textarea rows="10" cols="120" name="acontent" id="acontent">${vo.mid }님&nbsp;안녕하세요.</textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="modal-footer">
				<input type="button" value="작&nbsp;성" class="btn btn-outline-success" id="submitBtn">
				<button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

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

<style>
table th {
	width: 200px;
}
</style>