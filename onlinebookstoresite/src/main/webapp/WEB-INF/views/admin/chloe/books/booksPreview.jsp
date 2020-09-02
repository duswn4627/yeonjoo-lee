<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<link href="${pageContext.request.contextPath }/resources/yjcss/css/madeByChloe.css" rel="stylesheet" />

<div class="container-fluid">
	<br>
	<div style="font-size: 2rem; margin-left: 25px">
		<i class="fas fa-table mr-1"></i> 상세&nbsp;미리보기
	</div>
	<br>
		
	<div class="container-fluid">
		<div class="row">
			<div class="btnDiv">
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/booksUpdate?bnum=${vo.bnum }'" class="btn btn-outline-success">수정</button>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/booksDelete?bnum=${vo.bnum }'" class="btn btn-outline-danger">삭제</button>
			</div>
			
			<div id="contentWrap">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-7" id="thumbDiv">
							<img width="400px" height="600px" src="${pageContext.request.contextPath}/resources/imgUpload/${imgVO1.imgsavefilename}" />
						</div>
						<div class="col-md-5">
							<div id="titleDiv" style="font-size: 35px; font-weight: 600;">${vo.btitle }</div>
							<fmt:formatDate value="${vo.bpublishdate }" pattern="yyyy/MM/dd" var="bpublishdate" />
							<div id="wppDiv" style="font-size: 18px;">${vo.bwriter }&nbsp;지음&nbsp;&nbsp;|&nbsp;&nbsp;${vo.bpublisher }&nbsp;&nbsp;|&nbsp;&nbsp;${bpublishdate }&nbsp;출간</div>
							<div id="priceDiv" style="font-size: 30px; font-weight: 500;">${vo.bprice }원</div>
							<div id="pointDiv">(${vo.bpoint }point&nbsp;적립&nbsp;예정)</div>
						</div>
					</div>
					
					<c:if test="${!empty imgVO2 }">
						<div id="imgDiv">
							<img style="max-width: 1300px" src="${pageContext.request.contextPath}/resources/imgUpload/${imgVO2.imgsavefilename}" />
						</div>
					</c:if>
					<div class="row">
						<div class="col-md-12">
							<div id="introTextDiv" style="font-size: 30px; font-weight: 600;">[소개글]</div>
							<div id="contentTextDiv">${vo.bcontent }</div>
						</div>
					</div>
				</div>
			</div>
			<div class="btnDiv">
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/booksUpdate?bnum=${vo.bnum }'" class="btn btn-outline-success">수정</button>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/booksDelete?bnum=${vo.bnum }'" class="btn btn-outline-danger">삭제</button>
			</div>
		</div>
	</div>
</div>