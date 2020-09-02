<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<!-- 추후 css파일 분리예정 -->
<style>
	#sellerProdLook{
		border: 1px solid black;
		width: 1300px;
		height: 900px;
		margin: auto;
	}
	/*검색박스*/
	#selectBox{
		width: 1300px;
		height: 300px;
		border: 1px solid red;
	}
	#selectBox table{
		border: 1px;
	}
	.tdstyle{
		background-color: silver;
		width: 300px;
		height:70px;
		text-align: center;
	}
	input[type="radio"] {
		width: 50px;
	}
	input[type="text"] {
		width: 300px;
	}
	input[type="text"] {
		width: 300px;
	}
	.form-control{
		width: 150px;
	}
	/*테이블박스*/
	#showTable{
		width: 1300px;
		height: 500px;
		border: 1px solid green;
	}
	#showTable table{
		text-align: center;
	}
	.title{
		background-color: silver;
	}
</style>
<script type="text/javascript">
	
</script>
<div id="sellerProdLook">
	<div><h2>상품조회/수정페이지</h2></div>
	<form action="">
		<div id="selectBox">
			<table class="table table-bordered">
				<tr>
					<td class="tdstyle" id="statusa">판매상태별 조회</td>			
					<td>
						<input type="radio" name="status" value="0">전체
						<input type="radio" name="status" value="sale">판매중
						<input type="radio" name="status" value="payWaiting">입금대기중
						<input type="radio" name="status" value="requestDelivery">배송요청중
						<input type="radio" name="status" value="shipping">배송중
						<input type="radio" name="status" value="salesCompleted">판매완료
					</td>
				</tr>
				<tr>
					<td class="tdstyle">등록일자별 조회</td>			
					<td>
						<input type="radio" name="regdate" value="0">전체
						<input type="radio" name="regdate" value="date" >일자별&nbsp;&nbsp;&nbsp;
						<input type="date" name="startDay"><span>&nbsp;~</span>
						<input type="date" name="endDay">
					</td>
				</tr>
				<tr>
					<td class="tdstyle">등록한 상품 검색</td>			
					<td>
						<div class="input-group mt-1 mb-1">
					    	<div class="input-group-prepend">
					        	<select name="field" class="form-control">
					        	<option value="0">전체</option>
								<option value="obname">상품명</option>
								<option value="obwriter">저자</option>
								<option value="obpublisher">출판사</option>
					          </select>
					      </div>
					      <input type="text" name="keyword" class="form-control" placeholder="검색어를 입력하세요.">
					    </div>
					</td>
				</tr>
			</table>
			<!-- 버튼 -->
			<input type="submit" value="검색" class="btn btn-success">
			<input type="button" value="초기화" class="btn btn-secondary">
		</div>
		<div id="showTable">
			<table class="table table-bordered">
				<tr class="title">
					<td width="50">NO</td>
					<td width="300">상품명</td>
					<td>출판사</td>
					<td>저자</td>
					<td width="100">판매상태</td>
					<td>품질</td>
					<td>판매가</td>
					<td>등록일</td>
					<td width="80">수정</td>
					<td width="80">삭제</td>
				</tr>
				<c:forEach var="vo" items="${list}" varStatus="status">
					<tr>
						<td><c:out value="${status.count}"/></td>
						<td>${vo.obname}</td>
						<td>${vo.obwriter}</td>
						<td>${vo.obpublisher}</td>
						<td>
							<c:if test="${vo.obsalestatus==0}">판매중</c:if>
							<c:if test="${vo.obsalestatus==1}">입금대기중</c:if>
							<c:if test="${vo.obsalestatus==2}">판매완료</c:if>
						</td>
						<td>
							<c:if test="${vo.obstatus==1}">최상</c:if>
							<c:if test="${vo.obstatus==2}">상</c:if>
							<c:if test="${vo.obstatus==3}">중</c:if>
							<c:if test="${vo.obstatus==4}">하</c:if>
						</td>
						<td>${vo.obsaleprice}원</td>
						<td><fmt:formatDate value="${vo.obregdate}" pattern="yyyy-MM-dd"/></td>
						<td>
							<c:choose>
								<c:when test="${vo.obsalestatus==0}">
									<a href="${pageContext.request.contextPath}/seller/prodUpdateView?obnum=${vo.obnum}">
									<input type="button" value="수정" class="btn btn-primary"></a>
								</c:when>
								<c:otherwise>
									<input type="button" value="수정" class="btn btn-primary" disabled="disabled">
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${vo.obsalestatus==0}">
									<a href="${vo.obnum}"><input type="button" value="삭제" class="btn btn-secondary"></a>
								</c:when>
								<c:otherwise>
									<input type="button" value="삭제" class="btn btn-secondary" disabled="disabled">
								</c:otherwise>														
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</div>