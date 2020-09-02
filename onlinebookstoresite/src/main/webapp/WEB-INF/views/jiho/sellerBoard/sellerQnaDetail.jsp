<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<style>

/*=========================문의사항 상세페이지css========================*/ 
#obQnaDetail{
	width: 1300px;
	height: 850px;
	margin: auto;
}
#sellerMoon{
	width: 1000px;
	height: 650px;
	margin: auto;
}
#sellerQnatable tr,td{
	border: 1px solid black;
	border-collapse: collapse;
	width: 1000px;
	
}
#sellerQnatable tr,td{
	border: 1px solid #B4B7B7;
}
.moondetail{
	text-align: center;
	background-color: #EDEDED;
	width: 200px;
}
.moondetailText{
	text-align: center;
	width: 400px;
}
#thumb{
	border: 1px solid #eaeaea;
	width: 120px;
	height: 180px;
    margin-top: 10px;
    margin-bottom: 10px;
}
/*답변css*/
#dapTable{
    margin-top: 30px;
   
}
#dapTextarea{
    margin-left: 50px;
    margin-top: 30px;
    border: 2px solid black;
    border-radius: 10px 10px 10px 10px;
    padding-left: 10px;
    margin-right: 10px;
    display: inline;
}
#sellerdap{
	height: 180px;
}
#dapimg{
	float:left;
	margin-left:10px;
	width: 160px;
	margin: 0px;
	padding: 0px;
}
/*답글있을 때 css*/
#sellerdapOk{
	height: 180px;
}
#sellerAnswer{
	width: 800px;
	height: 150px;
	border: 1px solid green;
	margin-left: 180px;
	margin-top: 13px;
	border: 2px solid #6E6E6E;
    border-radius: 10px 10px 10px 10px;
    background-color: #EDEDED;
}
#dapimgok{
	width: 120px;
	height: 120px;
	margin-top:10px;
	margin-left: 10px; 
	float:left;
}
#answerContent{
	width: 630px;
	height: 120px;
	float:left;
	margin-top: 10px;
	margin-left: 10px;
	padding-left: 5px;
	padding-top: 5px;
}
#dapinsertbt{
	margin-left: 380px;
}
#dapupdatebt{
	margin-left: 380px;
}
</style>
<div id="obQnaDetail">
	<h1><img src="${cp }/resources/jh/jhimages/문의사항상세_1.png" style="margin-left: 125px;"></h1>
	<div id="sellerMoon">
		<table id="sellerQnatable">
			<tr height="70">
				<td class="moondetail">작성자</td>
				<td class="moondetailText">${qnaList.mid }</td>
				<td class="moondetail">등록일자</td>
				<td class="moondetailText"><fmt:formatDate value="${qnaList.obqdate }" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td colspan="1" class="moondetail">문의한 상품</td>
				<td colspan="3" style="padding-left: 10px">
					<img src="${cp }/resources/jh/jhobupload/${img.imgsavefilename}" id="thumb">
					[중고] ${qnaList.obname }</td>
			</tr>
			<tr height="100">
				<td colspan="1" class="moondetail">문의내용</td>
				<td colspan="3" style="padding-left: 10px">${qnaList.obqcontent }</td>
			</tr>
		</table>
		
		<%--답변이 없을 경우 --%>
		<c:if test="${answerList==null }">
			<form action="${cp }/seller/insertAnswer" method="post">
				<div id="sellerdap">
					<input type="hidden" value="${qnaList.obqnum }" name="obqnum">
					<img id="dapimg" src="${cp}/resources/jh/jhimages/문의답글이미지.jpg" >
						<textarea rows="5" cols="90" id="dapTextarea" name="obqacontent"></textarea>
				</div>
				<button type="submit" class="btn btn-primary" id="dapinsertbt">답변등록하기</button>
				<a href="${cp }/seller/qnalist"><button type="button" class="btn btn-secondary">리스트보기</button></a>
			</form>
		</c:if>
		
		<%--답변이 있을 경우 --%>
		<c:if test="${answerList !=null }">
			<div id="sellerdapOk">
				<input type="hidden" value="${qnaList.obqnum }" name="obqnum">
				<img id="dapimg" src="${cp}/resources/jh/jhimages/문의답글이미지.jpg" >
					<div id="sellerAnswer">
						<img id="dapimgok" src="${cp }/resources/jh/jhimages/프로필사진.jpg">
						<div id="answerContent">${answerList.obqacontent }</div>
					</div>
			</div>
				<a href="${cp }/seller/qnaupdate?obqnum=${qnaList.obqnum}">
					<button type="button" class="btn btn-primary" id="dapupdatebt">답변수정하기</button>
				</a>
				<a href="${cp }/seller/qnalist"><button type="button" class="btn btn-secondary">리스트보기</button></a>
		</c:if>
	</div>
</div>
<script>
	$(function(){
		$("form").submit(function(){
			var obqacontent=$("#dapTextarea").val();
			if(obqacontent==""){
				alert("내용을 입력해주세요.");
				return false;
			}
		});
	});
</script>