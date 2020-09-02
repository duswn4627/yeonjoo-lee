<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="container-fluid">
	<br>
	<div style="font-size: 2rem; margin-left: 25px">
		<i class="fas fa-table mr-1"></i> ${vo.mid }(${vo.mname })님의&nbsp;상세정보
	</div>
	<br>
	
	<div class="container-fluid">
		<table class="table">
			<tr>
				<th style="text-align: center;" class="table-active">회&nbsp;원&nbsp;번&nbsp;호</th>
				<td colspan="3">${vo.mnum }</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-active">회&nbsp;원&nbsp;이&nbsp;름</th>
				<td colspan="3">${vo.mname }</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-active">아&nbsp;이&nbsp;디</th>
				<td colspan="3">${vo.mid }</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-active">이&nbsp;메&nbsp;일</th>
				<td colspan="3">${vo.email }</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-active">휴&nbsp;대&nbsp;폰&nbsp;번&nbsp;호</th>
				<td colspan="3">${vo.phone }</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-active">기&nbsp;본&nbsp;배&nbsp;송&nbsp;지</th>
				<td colspan="3">${vo.addr }</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-active">가&nbsp;입&nbsp;일&nbsp;자</th>
				<fmt:formatDate value="${vo.regdate }" pattern="yyyy/MM/dd" var="regdate" />
				<td colspan="3">${regdate }</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-active">회&nbsp;원&nbsp;등&nbsp;급</th>
				<td colspan="3">
					<c:choose>
						<c:when test="${vo.grade == 0 }">
							일반회원
						</c:when>
						<c:when test="${vo.grade == 1 }">
							실버회원
						</c:when>
						<c:when test="${vo.grade == 2 }">
							골드회원
						</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-active">회&nbsp;원&nbsp;상&nbsp;태</th>
				<td colspan="3">
					<c:choose>
						<c:when test="${vo.mstatus == 1}">
							활동 중인 회원입니다.
						</c:when>
						<c:when test="${vo.mstatus == 0}">
							탈퇴한 회원입니다.
						</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-active">생&nbsp;년&nbsp;월&nbsp;일</th>
				<fmt:formatDate value="${vo.birth}" pattern="yyyy/MM/dd" var="birth" />
				<td colspan="3">${birth }</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-active">만&nbsp;나이</th>
				<td colspan="3">${vo.age }세</td>
			</tr>
			<tr>
				<th style="text-align: center;" class="table-active">성&nbsp;별</th>
				<td colspan="3">${vo.sex }</td>
			</tr>
			
			<tr>
				<td align="center" colspan="3">
					<button type="button" onclick="history.back()" class="btn btn-outline-success">목&nbsp;록</button>
				</td>
			</tr>
		</table>
	</div>
</div>

<style>
table th {
	width: 200px;
}
</style>