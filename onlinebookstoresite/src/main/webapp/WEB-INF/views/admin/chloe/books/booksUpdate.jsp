<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath }/resources/yjcss/css/madeByChloe.css" rel="stylesheet" />

<div class="container-fluid">
	<br>
	<div style="font-size: 2rem; margin-left: 25px">
		<i class="fas fa-table mr-1"></i> 상품수정
	</div>
	<br>
	<div class="container-fluid">
		<form method="post" action="${pageContext.request.contextPath }/booksUpdate" enctype="multipart/form-data">
			<input type="hidden" name="bnum" value="${bvo.bnum }">
			<table class="table">
				<tr>
					<th style="text-align: center;" class="table-active">카&nbsp;테&nbsp;고&nbsp;리</th>
					<td colspan="4">
						<select name="bctg" id="bctg">
							<c:forEach var="big" items="${getBigctg }">
								<option value="${big.bcatenum}"
									<c:if test="${big.bcatenum == bcatenum }">selected</c:if>>${big.bcataname }
								</option>
							</c:forEach>
						</select>
						
						<div id="smctgDiv" style="display: inline-block">
							<select name="smctg" id="smctg">
								<option value="">&nbsp;-&nbsp;선택&nbsp;-&nbsp;</option>
								<c:forEach var="sm" items="${getsctg }">
									<option value="${sm.scatenum}"
										<c:if test="${sm.scatenum == bvo.scatenum }">selected</c:if>>${sm.scataname }
									</option>
								</c:forEach>
							</select>
						</div>
					</td>
				</tr>
	
				<tr>
					<th style="text-align: center;" class="table-active">책&nbsp;제&nbsp;목</th>
					<td>
						<input type="text" name="btitle" size="50" value="${bvo.btitle }">
					</td>
					
					<th style="text-align: center;" class="table-active">작가&nbsp;(지은이)</th>
					<td>
						<input type="text" name="bwriter" size="50" value="${bvo.bwriter }">
					</td>
				</tr>
	
				<tr>
					<th style="text-align: center;" class="table-active">출&nbsp;간&nbsp;일</th>
					<fmt:formatDate value="${bvo.bpublishdate }" pattern="yyyy-MM-dd" var="bpublishdate" />
					<td  colspan="4">
						<input type="date" name="bpublishdate" value="${bpublishdate }">
					</td>
				</tr>
	
				<tr>
					<th style="text-align: center;" class="table-active">출&nbsp;판&nbsp;사</th>
					<td colspan="4">
						<input type="text" name="bpublisher" size="50" value="${bvo.bpublisher }">
					</td>
				</tr>
	
				<tr>
					<th style="text-align: center;" class="table-active">책&nbsp;가&nbsp;격</th>
					<td>
						<input type="text" name="bprice" value="${bvo.bprice }">&nbsp;원
					</td>
					
					<th style="text-align: center;" class="table-active">적립포인트</th>
						<td>
							<input type="text" name="bpoint" readonly="readonly" value="${bvo.bpoint }">&nbsp;point&nbsp;적립예정
						</td>
				</tr>
	
				<tr>
					<th style="text-align: center;" class="table-active">입&nbsp;고&nbsp;수&nbsp;량</th>
					<td colspan="4">
						<input type="text" name="bcount" value="${bvo.bcount }">&nbsp;개
					</td>
				</tr>
	
				<tr>
					<th style="text-align: center;" class="table-active">기존&nbsp;썸네일</th>
					<td>
						<input type="hidden" name="thumbNum" value="${thumbImg.imgnum }">
						<div id="savedThumbImg" style="text-align: center;">
							<img width="300px" height="350px" src="${pageContext.request.contextPath}/resources/imgUpload/${thumbImg.imgsavefilename }">
						</div>
					</td>
					
					<th style="text-align: center;" class="table-active">기존&nbsp;이미지</th>
					<td>
						<c:if test="${!empty img1 }">
							<input type="hidden" name="imgNum" value="${img1.imgnum }">
							<div id="savedImg" style="text-align: center;">
								<img width="300px" height="350px" src="${pageContext.request.contextPath}/resources/imgUpload/${img1.imgsavefilename }">
							</div>
						</c:if>
					</td>
				</tr>
	
				<tr>
					<th style="text-align: center;" class="table-active">썸&nbsp;네&nbsp;일&nbsp;*</th>
					<td><input type="file" name="thumbnail"></td>
					
					<th style="text-align: center;" class="table-active">이&nbsp;미&nbsp;지&nbsp;*</th>
					<td><input type="file" name="img1"></td>
				</tr>
	
				<tr>
					<th style="text-align: center;" class="table-active">책&nbsp;설&nbsp;명</th>
					<td colspan="4">
						<textarea rows="20" cols="200" name="bcontent">${bvo.bcontent }</textarea>
					</td>
				</tr>
	
				<tr>
					<td align="center" colspan="4">
						<input type="submit" value="수&nbsp;&nbsp;정" class="btn btn-outline-success">
						<input type="reset" value="초기화" class="btn btn-outline-secondary">
					</td>
				</tr>
			</table>
			<br>
		</form>
	</div>
</div>

<!-- 스크립트 -->
<script>
	// 카테고리 불러오기
	$("#bctg").change(function() {
		var big = $(this).val();
		//alert("big:" + big);
		$.ajax({
			url : "/finalproject/booksctg",
			data : {
				bcatenum : big
				},
			success : function(data) {
				// $("#smctgDiv").css("display", "inline-block");
				$("#smctg").empty();
				$("#smctg").append("<option value=''>&nbsp;-&nbsp;선택&nbsp;-&nbsp;</option>");
				$(data).each(function(i, sm) {
					$("#smctg").append("<option value='" + sm.scatenum + "'>" + sm.scataname + "</option>");
				});
			}
		});
	});
	
	// 포인트 = 가격 * (5 / 100)
	$("#bprice").change(function() {
		var price = $(this).val();
		$("#bpoint").val(Math.round(price * 0.05));
	});

	// 유효성검사
	$("form").submit(function() {
		var bctg = $("#bctg").val();
		if (bctg == "") {
			alert("카테고리를 선택해 주세요.");
			$("#bctg")[0].focus();
			return false;
		}

		var smctg = $("#smctg").val();
		if (smctg == "") {
			alert("카테고리를 선택해 주세요.");
			$("#smctg")[0].focus();
			return false;
		}

		var btitle = $("input[name='btitle']");
		if (btitle.val() == "") {
			alert("책 제목을 입력해 주세요.");
			btitle.focus();
			return false;
		}

		var bwriter = $("input[name='bwriter']");
		if (bwriter.val() == "") {
			alert("지은이를 입력해 주세요.");
			bwriter.focus();
			return false;
		}

		var bpublishdate = $("input[name='bpublishdate']");
		if (bpublishdate.val() == "") {
			alert("출간일을 선택해 주세요.");
			bpublishdate.focus();
			return false;
		}

		var bpublisher = $("input[name='bpublisher']");
		if (bpublisher.val() == "") {
			alert("출판사를 입력해 주세요.");
			bpublisher.focus();
			return false;
		}

		var bprice = $("input[name='bprice']");
		if (bprice.val() == "") {
			alert("가격을 입력해 주세요.");
			bprice.focus();
			return false;
		}
		
		if (isNaN(bprice.val())) {
			alert("가격을 숫자로만 입력해 주세요");
			bprice.focus();
			return false;
		}

		var bcount = $("input[name='bcount']");
		if (bcount.val() == "") {
			alert("수량을 입력해 주세요.");
			bcount.focus();
			return false;
		}
		
		if (isNaN(bcount.val())) {
			alert("수량을 숫자로만 입력해 주세요");
			bcount.focus();
			return false;
		}

		var thumbnail = $("input[name='thumbnail']");
		if (thumbnail.val() == "") {
			alert("썸네일 등록은 필수사항입니다.");
			thumbnail.focus();
			return false;
		}
		
		var img1 = $("input[name='img1']");
		if (img1.val() == "") {
			alert("이미지 등록은 필수사항입니다.");
			img1.focus();
			return false;
		}

		var bcontent = $("textarea");
		if (bcontent.val() == "") {
			alert("책 설명을 입력해 주세요.");
			bcontent.focus();
			return false;
		}
		return true;
	});
</script>