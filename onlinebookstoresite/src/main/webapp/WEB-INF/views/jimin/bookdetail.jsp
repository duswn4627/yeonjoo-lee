<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<br>
<br>
	<div  class="container" id="detailallwrap">
		<div id="detailupper">
			<div id="detailinfo">
				<img id="detailbook_img"
				src="${cp }/resources/imgUpload/${img1.imgsavefilename}" id="thumbnail">
				
				<div id="detailbookNameTitle">
				<strong style="font-size: x-large;">${bookvo.btitle}</strong>
				</div>
				<br>
				<br>
				<div id="detailwriter">
						<span style="font-size: 15px; color: #7d7d7d;">저 자 : </span><strong>${bookvo.bwriter}</strong>
						ㅣ				
						<span style="font-size: 15px; color: #7d7d7d;">출판사 : </span><strong>${bookvo.bpublisher}</strong>
						ㅣ					
						<span style="font-size: 15px; color: #7d7d7d;">등록일 : </span><strong><fmt:formatDate value="${bookvo.bregdate}" pattern="yyyy-MM-dd"/></strong>
				</div>
				<br>
				<br>
				<div id="detailprice">
						<span style="font-size:17px;color: #7d7d7d; float:left; margin-left: 1px;">평점</span>
						<span style="font-size: 22px;font-weight: bold ;float: left;margin-left: 118px;" >
						<img src="http://image.kyobobook.co.kr/ink/images/common/ico_commt_01.gif">&nbsp
						</span>
						<c:set var="avg" value="${avg}" />
						<c:if test="${avg == null }">
						<span style="font-size: 22px;font-weight: bold ; color: black;float: left;">0.0</span>
						</c:if>
						<c:if test="${avg > 0.0 }">
						<span style="font-size: 22px;font-weight: bold ; color: black;float: left;">${avg}</span>
						</c:if>
						<br>
						<br>
						<span style="font-size:17px;color: #7d7d7d; float:left; margin-left: 1px;">판매가</span>
						<span style="font-size: 22px;font-weight: bold ; color: red;float: left;margin-left: 100px;" >
						${bookvo.bprice} </span>
						<span style="font-size: 18px;font-weight: bold ; color: red;float: left;margin-left: 10px;">원</span>
						<br>
						<br>
						<span style="font-size:17px;color: #7d7d7d; float:left; margin-left: 1px;">적립금</span>
						<span style="font-size: 20px;float: left;margin-left: 100px;" >${bookvo.bpoint} </span>
						<span style="font-size: 17px;float: left;margin-left: 20px;">point</span>
						<br>
						<br>
						<span style="font-size:17px;color: #7d7d7d; float:left; margin-left: 1px;">배송비</span>
						<span style="font-size: 20px;float: left;margin-left: 100px;" >${bookvo.bshipinfo} </span>
						<span style="font-size: 17px;float: left;margin-left: 20px;">원</span>
				</div>
				<br>

				<div class="container" id="detailcontent" style="width:850px;height: auto;">
				<br>
				<br>

					<strong style="font-size:17px;color: #2E2E2E;text-align: center;height: auto;">
					" ${bookvo.bcontent} "
					</strong>
					<br><br>
				</div>
			</div>
			<div id="detailbtn">
				<button class="btn btn-success btn-lg btn-block" id="buynow"><a href="${cp }/order/directorder?bnum=${bookvo.bnum}&bcount=1">구매하기</a></button>
				<br>
				<br>
				<button class="btn btn-success btn-lg btn-block" id="cartBtn">장바구니</button>
				<input type="hidden" id="bnum" value="${bookvo.bnum}">
				<br>
				<br>
				<span style="text-align: center;"><strong>재고수량:</strong></span>
<%-- 				<span style="color: red;" id="bcnt1" value="${bcnt }">${bcnt }</span> --%>
				<input type="text" readonly="readonly" style="width:100px; border-style: none; color: red;" id="bcnt1" value="${bcnt }">
				
				<br>
				<br>
<!-- 				<input type="text" style="width: 200px;" id="bcnt"> -->
				<form>
<!-- 					<input style="width: 30px; height:30px;text-align: center;" type="button" value="-" onClick="javascript:this.form.amount.value--;"> -->
<!-- 					<input style="width: 30px;height:30px;text-align: center;" type="button" value="+" onClick="javascript:this.form.amount.value++;"> -->
					<input style="width: 100px;height:30px;text-align: center;" type="text" name="amount" id="bcnt2" value="1">
					<input style="width: 30px; height:30px;text-align: center;" type="button" value="-" onClick="return cntm()">
					<input style="width: 30px;height:30px;text-align: center;" type="button" value="+" onClick="return cntplus()">
				</form>
			</div>
		</div>
		
		<div id="detaillower">
		
				<nav style="height: auto;">
				  <div class="nav nav-tabs" id="nav-tab" role="tablist">
				    <a class="nav-item nav-link active" id="nav-detail-tab" data-toggle="tab" href="#nav-detail" role="tab" aria-controls="nav-detail" aria-selected="true" style="color: black;border: 1px solid #7d7d7d;"><strong>상세정보</strong></a>
				    <a class="nav-item nav-link" id="nav-qna-tab" data-toggle="tab" href="#nav-qna" role="tab" aria-controls="nav-qna" aria-selected="false" style="color: black;border: 1px solid #7d7d7d;"><strong>교환 및 환불 정보</strong></a>
				    <a class="nav-item nav-link" id="nav-review-tab" data-toggle="tab" href="#nav-review" role="tab" aria-controls="nav-review" aria-selected="false" style="color: black;border: 1px solid #7d7d7d;"><strong>리뷰</strong></a>
				  </div>
				</nav>
				<div class="tab-content" id="nav-tabContent">
				  <div class="tab-pane fade show active" id="nav-detail" role="tabpanel" aria-labelledby="nav-detail-tab">
					<br>
					<br>
					<h3 style="text-align: center;">상세정보
					<br><br>
					<img src="${cp }/resources/imgUpload/${img2.imgsavefilename}" id="detailimg"/>
					</h3>
				  </div>
				  <div class="tab-pane fade" id="nav-qna" role="tabpanel" aria-labelledby="nav-qna-tab">
					<div class="box_detail_content">
						<br>
							<h2>교환/반품/품절안내</h2><br>
							<p>※ 상품 설명에 반품/교환 관련한 안내가 있는 경우 그 내용을 우선으로 합니다. (업체 사정에 따라 달라질 수 있습니다.)</p>
							<table >
							<caption class="caption_hidden">교환/반품/품절안내</caption>
							<colgroup>
								<col width="22%">
								<col width="*">
							</colgroup>
							<tbody>
								<tr>
									<th scope="row">반품/교환방법</th>
									<td><strong>마이룸 &gt; 주문관리 &gt; 주문/배송내역 &gt; 주문조회 &gt; <a href="http://www.kyobobook.co.kr/myroom/orderList.laf">반품/교환신청</a> , <br>
										<a href="http://www.kyobobook.co.kr/cscenter/qnaForm.laf?questionType=003">[1:1상담&gt;반품/교환/환불]</a> 또는 고객센터 (1544-1900)</strong><br>
										※ 오픈마켓, 해외배송주문, 기프트 주문시 <a href="http://www.kyobobook.co.kr/cscenter/qnaForm.laf?questionType=003">[1:1상담&gt;반품/교환/환불]</a><br>
										&nbsp; &nbsp; 또는 고객센터 (1544-1900)</td>
								</tr>
								<tr>
									<th scope="row">반품/교환가능 기간</th>
									<td>변심반품의 경우 수령 후 7일 이내,<br> 상품의 결함 및 계약내용과 다를 경우 문제점 발견 후 30일 이내</td>
								</tr>
								<tr>
									<th scope="row">반품/교환비용</th>
									<td>변심 혹은 구매착오로 인한 반품/교환은 반송료 고객 부담</td>
								</tr>
								<tr>
									<th scope="row">반품/교환 불가 사유</th>
									<td>
										<ul class="list_normal">
											<li>소비자의 책임 있는 사유로 상품 등이 손실 또는 훼손된 경우<br> (단지 확인을 위한 포장 훼손은 제외)</li>
											<li>소비자의 사용, 포장 개봉에 의해 상품 등의 가치가 현저히 감소한 경우<br> 예) 화장품, 식품, 가전제품(악세서리 포함) 등</li>
											<li>복제가 가능한 상품 등의 포장을 훼손한 경우<br> 예) 음반/DVD/비디오, 소프트웨어, 만화책, 잡지, 영상 화보집</li>
											<li>소비자의 요청에 따라 개별적으로 주문 제작되는 상품의 경우 ((1)해외주문도서)</li>
											<li>디지털 컨텐츠인 eBook, 오디오북 등을 1회 이상 다운로드를 받았을 경우</li>
											<li>시간의 경과에 의해 재판매가 곤란한 정도로 가치가 현저히 감소한 경우</li>
											<li>전자상거래 등에서의 소비자보호에 관한 법률이 정하는 소비자 청약철회 제한 내용에<br> 해당되는 경우</li>
										</ul>
										(1) 해외주문도서 : 이용자의 요청에 의한 개인주문상품으로 단순변심 및 착오로 인한 취소/교환/반품 시 ‘해외주문 반품/취소 수수료’ 고객 부담 (해외주문 반품/취소 수수료 : ①양서-판매정가의 12%, ②일서-판매정가의 7%를 적용)
										
									</td>
								</tr>
								<tr>
									<th scope="row">상품 품절</th>
									<td>공급사(출판사) 재고 사정에 의해 품절/지연될 수 있으며, 품절 시 관련 사항에 대해서는<br> 이메일과 문자로 안내드리겠습니다.</td>
								</tr>
								<tr>
									<th scope="row">소비자 피해보상<br>
									  환불지연에 따른 배상</th>
									<td>
										<ul class="list_normal">
											<li>상품의 불량에    의한 교환, A/S, 환불, 품질보증 및 피해보상 등에 관한 사항은<br> 소비자분쟁해결 기준 (공정거래위원회 고시)에 준하여 처리됨</li>
											<li>대금 환불 및 환불지연에 따른 배상금 지급 조건, 절차 등은 전자상거래 등에서의<br> 소비자 보호에 관한 법률에 따라 처리함</li>
										</ul>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				  </div>
				  <div class="tab-pane fade" id="nav-review" role="tabpanel" aria-labelledby="nav-review-tab">
							
					<div class="tabWrite">	
					<!-- <form name="form" method="post" action="/ypbooks/book/pop_review_proc.jsp" target="ifrmProc"> -->
					<form id="insertform" method="GET" action="${cp }/enrllReview">
					
						<input type="hidden" name="bnum" value="${bnum}">
<!-- 						<input type="hidden" name="mnum" value="4"> -->
						
						<div style=" width: 1110px;background-color:#f9f9f9 ;padding: 12px 20px 19px 20px; overflow: hidden; border: 2px solid #f9f9f9">
							<span style="font-size: 20px;"><strong>독자서평 쓰기</strong></span>
							 <span style="font-size: 12px;">로그인을 하시면 독자서평을 쓰실 수 있습니다.</span> 
							<dl>
								<input type="hidden" name="review_name" id="review_name" value="지쳤거나 좋아하는 게 없거나">
								<br>
								<div>
								<strong>도서평점</strong>&nbsp&nbsp&nbsp
									<input type="radio" value="1" name="bscore" class="writeRadio"><span style="color: red;">&nbsp ★</span>
									&nbsp
									<input type="radio" value="2" name="bscore" class="writeRadio"><span style="color: red;">&nbsp ★★</span>
									&nbsp
									<input type="radio" value="3" name="bscore" class="writeRadio" checked="checked"><span style="color: red;">&nbsp ★★★</span>
									&nbsp
									<input type="radio" value="4" name="bscore" class="writeRadio"><span style="color: red;">&nbsp ★★★★</span>
									&nbsp
									<input type="radio" value="5" name="bscore" class="writeRadio"><span style="color: red;">&nbsp ★★★★★</span>
									&nbsp
								</div>
								<br>
								<strong>내용</strong>
								<br><br>
								<span>
									<textarea name="reviewcontent" style="width:900px;height:100px;"></textarea>
<!-- 									<a style="display:inline-block  ;float:right ;margin-bottom: 18px; " class="btn btn-success" id="enrollBtn">등록하기</a> -->
									
									<input type="submit" style="display:inline-block  ;float:right ;margin-bottom: 18px; " class="btn btn-success" id="enrollBtn" value="등록하기"> 
								</span>
							</dl>
						</div>
					</form>
					<!-- <iframe src="/blank.html" name="ifrmProc" id="ifrmProc" width="0" height="0"></iframe> -->
					<table style="width:1110px;" class="writeList1">
						<c:forEach var ="rvo" items="${reviewvo }">
						<tbody style="width:1110px;border: 1px solid #7d7d7d;">
						<tr>
							<td style=" width:13%;" id="mid" >${rvo.mname }</td>
							<td style="width:19%;" id="mscore">		
							
							<c:set var="score" value="${rvo.bscore }" />

								<c:if test="${score eq 5 }">
									<span style="color: red;">★★★★★</span>
								</c:if>
								<c:if test="${score eq 4 }">
									<span style="color: red;">★★★★</span>
								</c:if>
								<c:if test="${score eq 3 }">
									<span style="color: red;">★★★</span>
								</c:if>
								<c:if test="${score eq 2 }">
									<span style="color: red;">★★</span>
								</c:if>
								<c:if test="${score eq 1 }">
									<span style="color: red;">★</span>
								</c:if>
<%-- 								<span>${rvo.bscore }</span> --%>
							</td>
							<td class="tdCen" id="mdate"><fmt:formatDate value="${rvo.breviewregdate }"></fmt:formatDate></td>
						</tr>
						<tr class="writeCon02">
							<td colspan="4" id="mwrite">
								<span>${rvo.reviewcontent }</span>
							</td>
						</tr>
						</tbody>
						</c:forEach>
					</table>
					<br>
						<div>
<%-- 						   <c:choose> --%>
<%-- 				               <c:when test="${pu.startPageNum>1 }"> --%>
<!-- 				                  <button style="width: 50px; border-radius: 5px / 5px;"> -->
<%-- 				                  	<a style="color: black;" href="bdetail?pageNum=${pu.startPageNum-1 }&field=${field}&keyword=${keyword}&bnum=${bnum}"> --%>
<!-- 				                  	<strong style="color: black;">이전글</strong> -->
<!-- 				                  	</a> -->
<!-- 				                  </button> -->
<%-- 				               </c:when> --%>
<%-- 				               <c:otherwise> --%>
<!-- 				                  <button disabled="disabled"> -->
<!-- 				                  	<a href="#">이전글</a> -->
<!-- 				                  </button> -->
<%-- 				               </c:otherwise> --%>
<%-- 				            </c:choose> --%>
								<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
								<c:choose>
									<c:when test="${i==pu.pageNum }">
										<button style="border-style: none;border-style: ridge; width: 30px; border-radius: 5px / 5px;">
									 	<a href="bdetail?pageNum=${i }&field=${field}&keyword=${keyword}&bnum=${bnum}">
						<%-- 			 	<span style="color:red">${i }</span> --%>
									 	<strong style="color:red">${i }</strong>
									 	</a>
									 	</button>
								 	</c:when>
								 	<c:otherwise>
								 		<button style="border-style: none;width: 30px;border-radius: 5px / 5px;">
									 	<a href="bdetail?pageNum=${i }&field=${field}&keyword=${keyword}&bnum=${bnum}">
						<%-- 			 	<span style="color: black">${i }</span> --%>
									 	<strong style="color:black">${i }</strong>
									 	</a>
									 	</button>
								 	</c:otherwise>
							 	</c:choose>
								</c:forEach>
							</div>
<!-- 					<table width="100%" border="0" cellspacing="0" cellpadding="0"> -->
<!-- 						<tbodㅡy><tr> -->
<!-- 							<td align="center"> -->
<!-- 								페이징 S (출력 코드에 <form> 태그가 있으므로 <form></form> 사이에 아래 페이징 함수를 포함시키면 안됨) -->
<!-- 											<script language="javascript"> -->									
<!-- 											</script> -->
<!-- 											<div style="margin:0 auto; width:100%; text-align:center; "> -->
<!-- 												<div class="paging"> -->
<!-- 													<a href="javascript:goPage(1)" class="recent"> -->
<!-- 														<img src="/ypbooks/images/btnRecentList.gif" alt=""> -->
<!-- 													</a> -->
<!-- 													<a href="javascript:goPage(1)" class="current"> -->
<!-- 													1 -->
<!-- 													</a> -->
<!-- 													<a href="javascript:goPage(1)" class="last"> -->
<!-- 													<img src="/ypbooks/images/btnLastList.gif" alt=""> -->
<!-- 													</a> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 											<form name="FrmPaging" method="post" action="http://www.ypbooks.co.kr/book.yp?bookcd=100979414"> -->
<!-- 												<input type="hidden" name="ReqPageNo" value="">	 -->
<!-- 												<input type="hidden" name="UserCode" value=""> -->
<!-- 											</form> -->
<!-- 								페이징 E (출력 코드에 <form> 태그가 있으므로 <form></form> 사이에 아래 페이징 함수를 포함시키면 안됨) -->
<!-- 							</td> -->
<!-- 						</tr> -->
<!-- 						</tbody> -->
<!-- 						</table>		 -->
					</div>
				  </div>
				</div>
	</div>
</div>
<br>
<br>
<script>
//JSon 방식 
// 	$("#enrollBtn").click(function(){
// 		var reviewcontent=$("#review_content").val();
// 		var bscore=$("input[name=radio_revRate]:checked").val();
// 		var bnum = $("input[name=bnum]").val();
// 		$.getJSON('${cp}/enrllReview',{"reviewcontent":reviewcontent,"bscore":bscore,"bnum":bnum},function(data){
// 			alert(data);
// 		});
// 	});

//    $("#bcnt2").on("change", function() {

//        var buycnt =parseInt( $(this).val());
//        var remaincnt=$("#bcnt1").val();
//        console.log(remaincnt );
//        console.log(buycnt );
//        if(buycnt>remaincnt){
    	   
//           alert("재고수량 보다 작은 수량만 구매 가능합니다!");
//           $("#bcnt2").val('1');
//           $("#bcnt2").focus();
          
//        }else if(buycnt==null && buycnt==""){          
//           alert("수량을 반드시 입력해주세요!");
//           $("#bcnt2").val('1');
//           $("#bcnt2").focus();
          
//        }else if(buycnt.keyCode<48 || buycnt.keyCode>57){
//           alert("숫자만 입력해주세요!");
//           $("#bcnt2").val('1');
//           $("#bcnt2").focus();
//        }
//    });
   var buycnt =$("#bcnt2").val();
   function cntplus(){
	   
       var remaincnt=$("#bcnt1").val();
       console.log(remaincnt );
       buycnt++;
       console.log(buycnt );
	   $("#bcnt2").val(buycnt);
       if(buycnt>remaincnt){
    	   
           alert("재고수량 보다 작은 수량만 구매 가능합니다!");
           $("#bcnt2").val(remaincnt);
           $("#bcnt2").focus();
           
        }else if(buycnt==null && buycnt==""){          
           alert("수량을 반드시 입력해주세요!");
           $("#bcnt2").val('1');
           $("#bcnt2").focus();
           
        }else if(buycnt.keyCode<48 || buycnt.keyCode>57){
           alert("숫자만 입력해주세요!");
           $("#bcnt2").val('1');
           $("#bcnt2").focus();
        }
      return true;
   };
   function cntm(){
	   
       var remaincnt=$("#bcnt1").val();
       console.log(remaincnt );
       buycnt--;
       console.log(buycnt );
	   $("#bcnt2").val(buycnt);
       if(buycnt<0){
    	   
           alert("1개이상부터 구매 가능합니다!");
           $("#bcnt2").val(remaincnt);
           $("#bcnt2").focus();
           
        }else if(buycnt==null && buycnt==""){          
           alert("수량을 반드시 입력해주세요!");
           $("#bcnt2").val('1');
           $("#bcnt2").focus();
        }else if(buycnt<1){
            alert("수량을 1개 이상 입력해주세요!");
            $("#bcnt2").val('1');
            $("#bcnt2").focus();
        	 
        }else if(buycnt.keyCode<48 || buycnt.keyCode>57){
           alert("숫자만 입력해주세요!");
           $("#bcnt2").val('1');
           $("#bcnt2").focus();
        }
      return true;
   };
   
//    $(document).on('click','#gocart',function(){
// 		var form=$('<form></form>');
// 		form.attr('action','${cp}/order/usedorder');
// 		form.attr('method','post');
// 		form.appendTo('body');
// 		var sid=$(this).data('sid');
// 		$("."+sid+"_checkTd").each(function(){
// 			if($(this).is(':checked')){
// 				var cartNumValue=$(this).data('cartnum');
// 				var cartNum=$("<input type='hidden' value="
// 						+cartNumValue+" name='cartNum'>");
// 				form.append(cartNum);
// 			}
// 		});
// 		form.submit();
// 	})
   
	$("#cartBtn").click(function(){
		var bnum=$("#bnum").val();
		var bcount=$("#bcnt2").val();
		$.get("${cp }/cart/insert?bnum="+bnum+"&bcount="+bcount, function(data){
			console.log("callback");
			if(data=="already"){
				alert("이미 장바구니에 담긴 상품입니다.");
				location.href = "${cp }/pay/cart";
			}else if(data=="success"){
				alert("장바구니에 담았습니다.");
			}else if(data=="fail"){
			alert("로그인을 해주세요.");
			location.href = "${cp }/login";
			}
		});
	});

</script>