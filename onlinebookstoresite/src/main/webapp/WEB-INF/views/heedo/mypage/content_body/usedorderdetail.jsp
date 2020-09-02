<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<div id="content_history_detail">
	<div>
		<i class="fab fa-first-order-alt"></i><h4 style="display:inline"><span class="colorFont">상세 주문</span>내역</h4>
	</div>
	<br>
	<div id="content_initial">		
		<div class="content_core" id="listDiv">
			<h5><span class="colorFont">주문 상품</span> 정보</h5>
			<table class="table table-borderd" id="listTable">
				<thead>
					<th style='text-align: center'>상품명</th>
					<th>수량</th>
					<th>가격</th>
					<th>판매자</th>
				</thead>
				<tbody>
					<c:forEach var="bvo" items="${blist }">
						<tr>
							<td style="width:49%;text-align:center">${bvo.statusString} ${bvo.btitle }</td>
							<td style="width:7%">${bvo.bcount }</td>
							<td style="width:15%">${bvo.bprice }원</td>
							<td style="width:15%">${bvo.sid }</td>
						</tr>
					</c:forEach>
					
				</tbody>
				<tfoot>
					<tr>
						<td>합계</td>
						<td>${totalprice }원</td>
						<td>0</td>
						<c:choose>
							<c:when test="${ivo.bstatus==0 }">
							<td class="btnTd"  style="text-align: right;" data-bstatus="${ivo.bstatus }">
								<button type="button" class="btn btn-dark orderbtn" data-bstatus="${ivo.bstatus }" data-apply="cancel">전체취소</button>
							</td>		
						</c:when>
						<c:when test="${ivo.bstatus==1||ivo.bstatus==2 }">
							<td class="btnTd"  style="text-align: right;" data-bstatus="${ivo.bstatus }">
								<button type="button" class="btn btn-dark orderbtn" data-bstatus="${ivo.bstatus }" data-apply="confirm">구매확정</button>
							</td>	
						</c:when>
						<c:otherwise>
							<td class="btnTd"  style="text-align: right;" data-bstatus="${ivo.bstatus }">
							</td>
						</c:otherwise>
					
					</c:choose>
					
						
				
					</tr>
					<tr>
						<td colspan="2"></td>
						<td colspan="3">
							<table class="table table-borderd">
								<tr>
									<td>
										상품 총 금액 : ${totalprice }원<br>
										배송비     : ${ivo.delfee }원<br>
										
									</td>
									<td></td>
									<td>
										적립예정포인트 : 0
									</td>
								</tr>
								<tr>
									<td colspan="3">총 주문  금액 : ${totalprice+ivo.delfee }원</td>
									
								</tr>
							</table>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		
		<div class="content_core" id="orderinfoDiv">
			<h5><span class="colorFont">주문</span> 정보</h5>
			<table class="table table-borderd">
				<tr>
					<td class="tableloc">포인트적립일</td>
					<td colspan="3">중고제품은 적립되지않습니다.</td>
				</tr>
				<tr>
					<td class="tableloc">주문번호</td><td>${ivo.bpaynum }</td><td class="tableloc">주문일자</td><td>${ivo.borderdate }</td>
				</tr>
				<tr>
					<td class="tableloc">주문자</td><td>${ivo.mname }</td><td class="tableloc">수령인</td><td>${ivo.receiver }</td>
				</tr>
				<tr>
					<td class="tableloc">전화번호</td><td colspan="3">${ivo.bphone }</td>
				</tr>
				<tr>
					<td class="tableloc">배송주소</td>
					<td colspan="3">
						<img src="${cp }/resources/hd/image/addricon_land.gif">
						<span class="addr">${jibunaddr }</span><br>
						<img src="${cp }/resources/hd/image/addricon_road.gif">
						<span class="addr">${roadaddr }</span>
					</td>
				</tr>
			</table>
		</div>
		
		<div class="content_core" id="payinfoDiv">
			<h5><span class="colorFont">결제</span> 정보</h5>
			<table class="table table-orderd">
				<tr>
					<td class="tableloc">총주문금액</td>
					<td colspan="3" id="totalprice" data-totalvalue="${totalprice }" data-delfee=" ${ivo.delfee }">
						${totalprice+ivo.delfee }원
					</td>
				</tr>
				<tr>
					<td class="tableloc">사용포인트</td><td>${ivo.usedpoint }</td>
					<td class="tableloc">포인트적립예정액</td><td>0</td>
				</tr>
				<tr>
					<td class="tableloc">결제(할)금액</td><td>${totalprice+ivo.delfee-ivo.usedpoint }원</td>
				</tr>
				<c:choose>
				<c:when test="${ivo.methodpayment==0 }">
					<tr>
						<td class="tableloc">결제</td><td colspan="3">카드결제완료</td>
					</tr> 
				</c:when>
				<c:when test="${ivo.methodpayment==1 }">
					<tr>
						<td class="tableloc">예금주</td><td>${vbvo.vbank_holder }</td><td rowspan="2" class="tableloc">입금계좌</td><td rowspan="2">${vbvo.vbank_num }</td>
					</tr>
					<tr>
						<td class="tableloc">입금기한일</td><td>2020/00/00</td>
					</tr>
				</c:when>
				</c:choose>
			</table>
		</div>
		<div id="buttondiv">
			<a href="${cp }/mypage/orderhistory">
				<button type="button" class="btn btn-dark">목록으로</button>
			</a>
		</div>
	</div>
</div>
<!-- /// 확인 Modal 시작 ///-->
<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header" style="background-color: red">  
        <h5 class="modal-title" id="confirmModalLabel">
       	<c:choose>
        	<c:when test="${ivo.bstatus==0 }">
     			전체취소 
     		</c:when>
     		<c:otherwise>
     			구매확정
     		</c:otherwise>
  
     	</c:choose>
        </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="confirm_modal_body">
     	<c:choose>
     		<c:when test="${ivo.bstatus==0 }">
     			전체취소 하시겠습니까?
     		</c:when>
     		<c:otherwise>
     			구매확정하시겠습니까?
     		</c:otherwise>
     	</c:choose>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-dark" id="confirmbtn_modal" data-bstatus="${ivo.bstatus }" data-bpaynum="${ivo.bpaynum }">확인</button>
       	<button type="button" class="btn btn-light" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>
<!-- /// 확인 Modal 끝 ///-->
<!-- /// 확인 Modal 시작 ///-->
<div class="modal fade" id="resultModal" tabindex="-1" role="dialog" aria-labelledby="resultModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header" style="background-color: green">  
        <h5 class="modal-title" id="resultModalLabel">
        	알림
        </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="result_modal_body">
     	<c:choose>
     		<c:when test="${ivo.bstatus==0 }">
     			전체취소가 완료되었습니다.
     		</c:when>
     		<c:otherwise>
     			구매확정이 완료되었습니다.
     		</c:otherwise>
     	</c:choose>
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-dark"  data-dismiss="modal" id="confirmBtn">확인</button>
       	
      </div>
    </div>
  </div>
</div>
<!-- /// 확인 Modal 끝 ///-->

<script>
	$(document).ready(function(){
		defaultSetting();
	});
	//테이블행 (상품갯수) 늘어날때마다 큰 div height 늘림. // 주문상태일땐 선택박스 disabled
	var defaultSetting=function(){
		var tr=0;
		$("#listTable > tbody tr").each(function(){
			tr+=1;
		});
		var allHeight=parseInt($("#content_all").css("height"));
		var detailHeight=parseInt($("#content_history_detail").css("height"));
		allHeight+=50*(tr-1);
		detailHeight+=50*(tr-1);
		$("#content_all").css("height",allHeight);
		$("#detailHeight").css("height",detailHeight)
		/////////////////////////////////////////////
		
		var bstatus=$(".btnTd").data('bstatus');
		if(bstatus==0){
			$("#allcheck, .checkTd").attr("disabled","true");
		}
		
	}
	//주문리스트 버튼 클릭시.
	$(".orderbtn").click(function(){
		var apply=$(this).data('apply');
		$("#confirmbtn_modal").data('apply',apply)
		var bstatus=$(this).data('bstatus');
		$("#confirmModal").modal('show');
	});
	
	//모달창에서 확인버튼 클릭시.
	$("#confirmbtn_modal").click(function(){
		$("#confirmModal").modal('hide');
		var bstatus=$(this).data('bstatus');
		var bpaynum=$(this).data('bpaynum');
		var apply=$(this).data('apply');
		var totalvalue=Number($("#totalprice").data("totalvalue"));
		var delfee=Number($("#totalprice").data("delfee"));
		var totalprice=totalvalue+delfee;
		$.ajax({
			url:"/finalproject/order/usedmanage",
			data:{bstatus:bstatus,
				  bpaynum:bpaynum,
				  apply:apply,
				  totalprice:totalprice,
				  totalvalue:totalvalue,
				  delfee:delfee
				  },
			type:"post",
			dataType: "json",
			success:function(data){
				if(data.result){	
					$("#resultModal").modal('show');
				}
			}
		})
	});
	$("#confirmBtn").click(function(){
		var form=$("<form></form>")
		form.attr('method','post');
		form.attr('action','${cp}/mypage/orderhistory');
		form.appendTo('body');
		form.submit();
	});
	
	
</script>
<style>
	#content_all{
		height:1280px;
	}
	#content_history_detail{
		height:1200px;
		width:920px;
		border-top:1px solid #dee2e6;
	}
	.colorFont{
		color:#e83e8c;
	}
	#content_history_detail{
		padding:5px;
	}
	.content_core{
		padding:10px;
		 border-radius: 8px;
		 box-shadow: 0px 0px 4px grey;
	}
	#listDiv{
		border:2px solid grey;
	}
	#listTable > thead{
		background-color: #e6f7ff;
	}
	.tableloc{
		background-color: #e6f7ff;
	}

	#btnCancel,#btnReturn{
		padding:2px;
		font-size:12px;
		width:80px;
		height:20px;
	}
	#orderinfoDiv{
		border:2px solid grey;
		margin-top: 25px;
	}
	#payinfoDiv{
		border:2px solid grey;
		margin-top: 25px;
	}
	#buttondiv{
		margin-top:30px;
		text-align: center;
	}

</style>