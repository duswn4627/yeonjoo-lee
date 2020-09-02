<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
 <div id="content_qna_detail">
 	<div>
		<i class="fab fa-first-order-alt"></i><h4 style="display:inline"><span class="colorFont">문의 상세</span> 내역</h4>
	</div>
 	<div class="qnadiv shadow" id="myqna">
 		<i class="fab fa-first-order-alt"></i><h5 style="display:inline"><span class="colorFont">나의</span> 문의글</h5>
 		<table class="table">
 			<tr>
 				<td style="width:25%;" class="qnaloc">제목</td><td colspan="3">${qvo.qnatitle }</td>
 			</tr>
 			<tr>
 				<td id="qnacontent" class="qnaloc">내용</td><td coslpan="3">${qvo.qnacontent }</td>
 			</tr>
 			<tr id="subinfo">
 				<td class="qnaloc">작성일</td><td>${qvo.qnadate }</td><td class="qnaloc">상태</td><td>${qvo.statusStr }</td>
 			</tr>
 		</table>
 	</div>
 	<div class="qnadiv shadow" id="qnaanswer">
 		<i class="fab fa-first-order-alt"></i><h5 style="display:inline"><span class="colorFont">관리자</span> 답변 </h5>
 		<table class="table">
 			<c:choose>
	 			<c:when test="${qvo.qnastatus==1 }">
		 			<tr>
		 				<td style="width:25%;" class="qnaloc">아이디</td><td colspan="3">${avo.maid }</td>
		 			</tr>
		 			<tr>
		 				<td class="replycontent qnaloc">내용</td><td coslpan="3">${avo.qnacontent }</td>
		 			</tr>
		 			<tr id="subinfo">
		 				<td class="qnaloc">작성일</td><td colspan="3">${avo.qnaregdate }</td>
		 			</tr>
	 			</c:when>
 				<c:otherwise>
 					<tr>
		 				<td style="width:25%;" class="qnaloc">아이디</td><td colspan="3"></td>
		 			</tr>
		 			<tr>
		 				<td class="replycontent qnaloc">내용</td><td coslpan="3">처리중....</td>
		 			</tr>
		 			<tr id="subinfo">
		 				<td class="qnaloc">작성일</td><td colspan="3"></td>
		 			</tr>
 				
 				</c:otherwise>
 			</c:choose>
 		</table>
 	
 	</div>
 	<div id="buttondiv">
			<a href="${cp }/mypage/qnapage">
				<button type="button" class="btn btn-dark">목록으로</button>
			</a>
		</div>

 </div>
 
 <style>
 	#content_all{
		height:800px;
	}
	#content_qna_detail{
		padding:10px;
		height:740px;
		width:920px;
		border-top:1px solid #dee2e6;
	}
	.qnadiv{
		width:900px;
		height:300px;
		border:2px solid grey;
		border-radius: 8px;
		padding:10px;
	}
	.qnaloc{
		background-color: #e6f7ff;
	}
	#qnacontent,.replycontent{
		height:150px;
	}
	#myqna{
		margin-top:10px;
		margin-bottom:25px;
	}
	#buttondiv{
		margin-top:10px;
		text-align: center;
	}
	.colorFont{
		color:#e83e8c;
	}
 
 </style>