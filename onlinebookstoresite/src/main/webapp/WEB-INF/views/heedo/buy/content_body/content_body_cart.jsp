<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- /// 최상단 tab 영역 시작 /// -->
<ul class="nav nav-tabs">
	<li class="nav-item">
		<a class="nav-link active" data-toggle="tab" href="#newitem">새상품</a>
	</li>
	<li class="nav-item">
		<a class="nav-link " data-toggle="tab" href="#useditem">중고상품</a>
	</li>
</ul>    
<!-- /// 최상단 tab 영역 끝 /// -->
<br>
<!-- /// 내용 div 시작 /// -->
<div class="tab-content container shadow" id="content_cart">
	<!-- /// 새상품 div 시작 /// -->
	<div id="newitem" class="tab-pane active ">
		<h4 style='display:inline'><span style='color:#f51167'>새상품</span> 장바구니</h4>
		<div id="topButton" style="height:35px; float:right">
			<span>선택한 상품  </span><button type='button' class='btn btn-outline-dark btn-sm odbtn' id='orderTopBtn'>주문하기</button>
			<button type='button' class='btn btn-outline-secondary btn-sm' id='deleteTopBtn'>삭제하기</button>
		</div>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th><input  style='zoom:1.5;' type="checkbox" id="allcheck" checked="checked"></th>
					<th colspan="2" align="center">상품명</th>
					<th>판매가</th>
					<th>적립포인트</th>
					<th>수랑</th>
					<th>합계</th>
					<th style="text-align: right;">주문</th>
				</tr>
			</thead>
			<tbody id="newtbody">
			
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8" align="right">
					상품 총 금액 : <strong><span id="total_value"></span></strong>원  
					| 포인트 총 적립액 : <strong><span id="total_point"></span></strong>원</td>
				</tr>
			</tfoot>
		</table>
		<table class='table table-bordered' style='text-align:center;'>
				<tr>
					<th class='table-info' style='width:33.3%'>상품 총 금액</th>
					<th class='table-info' style='width:33.3%'>배송비</th>
					<th bgcolor='#80d4ff' style='width:33.3%'>최종 결제금액</th>
				</tr>
				<tr>
					<td><span id='new_total_value'></span>원</td>
					<td><span id='new_total_shipfee'></span>원</td>
					<td bgcolor='#80d4ff'><span id='final_payment_newvalue' style='color:#f51167;'></span><span style='#f51167'>원</span></td>
				<tr>
		</table>
		<div id="newbottomBtn">
			<button type='button' class='btn btn-primary btn-lg' id='odbtn'>주문하기</button>
			<a href='${cp}/'><button type='button' class='btn btn-light btn-lg'>쇼핑계속하기</button></a>
		</div>
	</div>
	
	
	<!-- /// 새상품 div 끝 /// -->
	<!-- /// 중고상품 div 시작 /// -->
	<div id="useditem" class="tab-pane fade">
		
	</div>
	<!-- /// 중고상품 div 끝 /// -->
	

</div>
<br>
<!-- /// 내용 div 시작 /// -->

<!-- ///삭제 확인 Modal 시작 ///-->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">  
        <h5 class="modal-title" id="deleteModalLabel">상품 삭제</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       장바구니에서 정말 삭제하시겠습니까?
      </div>
      <div class="modal-footer">
      	<button type="button" class="btn btn-dark" id="deletebtn_modal">삭제하기</button>
       	<button type="button" class="btn btn-light" data-dismiss="modal">취소하기</button>
      </div>
    </div>
  </div>
</div>
<!-- ///삭제 확인 Modal 끝 ///-->

<!-- /// 경고알람 modal -->
<div id="alertmodal" class="modal fade" role="dialog"> 
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header" style="background-color: #ff66a3">
       <h4 class="modal-title" style="color:white">경고</h4>
        <button type="button" class="close" data-dismiss="modal">x</button>
      </div>
      <div class="modal-body">
        	선택된 상품이 없습니다.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">닫기</button>
      </div>
    </div>

  </div>
</div>
<script>
	$(document).ready(function() {
		viewCart();
		viewusedcart();
		
		$("#order_container").css({
			width:"1140",
		})
	})
	//=====================중고 관린 스크립트 시작 ===========================//
	var viewusedcart=function(){
		
		$.ajax({
			url:"/finalproject/pay/usedlist",
			dataType:"json",
			success:function(data){
				
				// 장바구니에 데이터 없을경우.
				if(data.length==0){
					var c=$("<div class='container tableDiv'></div>").appendTo("#useditem");
					var htitle="<h4 style='display:inline'><span style='color:#f51167'>중고 판매자별</span> 장바구니  : 없음 </h4>"
					c.append(htitle);
					var tableapp=
							"<table class='table'>"
								+"<thead class='thead-dark'>"
									+"<tr>"
										+"<th colspan='2' align='center'>상품명</th>"
										+"<th>정가</th>"
										+"<th>판매가</th>"
										+"<th>수랑</th>"
										+"<th>합계</th>"
										+"<th>주문</th>"
										+"<th><input  style='zoom:1.5;' type='checkbox' checked='checked'></th>"
									+"</tr>"
								+"</thead>"
								+"<tr>"
								+"<td colspan='8' align='center'><strong><span>장바구니에 담긴 상품이 없습니다.</span></strong></td>"
								+"</tr></table>";
					 c.append(tableapp);
					 var c=$("<div class='container tableDiv'></div>").appendTo("#useditem");
						var htitle="<h5 style='display:inline'><span style='color:#f51167'>결제</span>정보</h5>"
						c.append(htitle);
						var chargeApp="<table class='table table-bordered' style='text-align:center;'>"
										 +"<tr>"
										 	+"<th class='table-info' style='width:33.3%'>총 상품 총 금액</th>"
										 	+"<th class='table-info' style='width:33.3%'>총 배송비</th>"
										 	+"<th bgcolor='#80d4ff' style='width:33.3%'>최종 결제금액</th>"
										 +"</tr>"
										 +"<tr>"
										 	+"<td><span id='all_total_value'>0</span>원</td>"
										 	+"<td><span id='all_total_shipfee'>0</span>원</td>"
										 	+"<td bgcolor='#80d4ff'><span id='final_payment_value' style='color:#f51167;'>0</span><span style='#f51167'>원</span></td>"
										 +"<tr>"
										+"</table>";
						c.append(chargeApp); 
						// 하단 결제정보 테이블 끝 //	
						var bottomBtnGroup="<div style='text-align:center;''>"
							  	+"<a href='${cp}/'><button type='button' class='btn btn-light btn-lg'>쇼핑계속하기</button></a>"
							  	+"</div>"
						c.append(bottomBtnGroup);
					 return;
				}
				var lastindex=data.length;
				var sidlist=data[lastindex-1].sidlist
				// 각 중고판매자 테이블부터 생성. 
				for(var i=0;i<sidlist.length;i++){
					var c=$("<div class='container tableDiv'></div>").appendTo("#useditem");
					var htitle="<h4 style='display:inline'><span style='color:#f51167'>중고판매자별</span> 장바구니  : "+ sidlist[i]+"</h4>"
					c.append(htitle);
					var topbutton="<div id='topButton' style='height:35px;display:inline-block;float:right'>"
								 +"<span>해당 판매자 선택한 상품  </span><button type='button' class='btn btn-outline-dark btn-sm usedorderTopBtn' data-sid="+sidlist[i]+">주문하기</button>"
								 +"<button type='button' class='btn btn-outline-secondary btn-sm' id='deleteTopBtn'>삭제하기</button>";
								 +"</div><br>";	
					c.append(topbutton);
				    var tableapp=
						"<table class='table'>"
							+"<thead class='thead-dark'>"
								+"<tr>"
									+"<th colspan='2' align='center'>상품명</th>"
									+"<th>정가</th>"
									+"<th>판매가</th>"
									+"<th>수랑</th>"
									+"<th>합계</th>"
									+"<th>주문</th>"
									+"<th><input class='usedTopCheckbox' style='zoom:1.5;' type='checkbox' checked='checked' data-sid="+sidlist[i]+"></th>"
								+"</tr>"
							+"</thead>"
							+"<tbody id="+sidlist[i]+"_tbody class='usedtbody'>"	
							+"</tbody>"
							+"<tfoot>"
								+"<tr>"
									+"<td colspan='8' align='right'>"
									+"상품 총 금액 : <strong><span id='"+sidlist[i]+"_total_value' class='used_total_value'>0</span></strong>원"
									+"( + 배송비 <strong><span id='"+sidlist[i]+"_total_shipfee' class='used_total_shipfee'>0</span></strong>원)"
								+"</tr>"
							+"</tfoot>"
						+"</table>";
					c.append(tableapp);
				}
				// 중고판매자 테이블에 tbdoy 내용 추가///
				$(data).each(function(index,item){
					//마지막 인덱스에는 판매자 아이디만 들어있음.
					if(index==lastindex-1){ 
						return;
					}
					//=== 책 품질 판단 ====///
					var status="";
					if(item.obstatus==1){
						status="최상";
					}else if(item.obstatus==2){
						status="상";
					}else if(item.obstatus==3){
						status="중";
					}else if(item.obstatus==4){
						status="하";
					}
					//=== 책 품질판단 끝 ====////
					//=== 각 중고 판매자 테이블마다 장바구니에 들어있는 책 내용 추가 시작===///
					var tbodyapp=
						"<tr>"
							+"<td><img src="+item.imgsrc+" class='cartlistimg'></td>"
							+"<td><span class='obstatus'>[중고-"+status+"]</span>&nbsp<a href='#'>"+item.btitle+"</a></td>"
							+"<td>"+item.oborgprice+"</td>"
							+"<td>"+item.obsaleprice+"</td>"
							+"<td>"+item.bcount+"</td>"
							+"<td><strong>"+item.totalvalue+"</strong></td>"
							+"<td><button type='button' class='btn btn-dark usedorderbtn' data-id="+item.obnum+" data-cartnum="+item.cartnum+">주문하기</button><br>"
							+"<button type='button' class='btn btn-light deletebtn' data-id="+item.cartnum
							+" data-toggle='modal'>삭제하기</button></td>"
							+"<td><input style='zoom:1.5;' type='checkbox' checked='checked' data-sid="+item.sid
								+" data-value="+item.totalvalue+" data-ship="+item.shipmentfee+"  data-cartnum="+item.cartnum+" class='"+item.sid+"_checkTd usedCheckTd'></td>"
						+"</tr>";
					$("tbody[id='"+item.sid+"_tbody']").append(tbodyapp);
					//=== 각 중고 판매자 테이블마다 장바구니에 들어있는 책 내용 추가 끝===///
					// 각테이블 상품총금액 계산 //
					var value=$("#"+item.sid+"_total_value").text();
					var newvalue=Number(value)+Number(item.totalvalue);
					$("#"+item.sid+"_total_value").text(newvalue);
					 
					//각 테이블 배송비 계산 //
					var feevalue=Number($("#"+item.sid+"_total_shipfee").text());
					if(item.shipmentfee>feevalue){
						$("#"+item.sid+"_total_shipfee").text(item.shipmentfee)
					}
					
				})
				// 하단 결재정보 테이블 값 계산 //
				var allvalue=0;
				var allshipfee=0;
				for(var i=0;i<sidlist.length;i++){
					allvalue+=Number($("#"+sidlist[i]+"_total_value").text())
					allshipfee+=Number($("#"+sidlist[i]+"_total_shipfee").text())
				}
				var finalvalue=allvalue+allshipfee;
				// 하단 결제정보 테이블 시작 //
				
				var c=$("<div class='container tableDiv'></div>").appendTo("#useditem");
				var htitle="<h5 style='display:inline'><span style='color:#f51167'>결제</span>정보</h5>"
				c.append(htitle);
				var chargeApp="<table class='table table-bordered' style='text-align:center;'>"
								 +"<tr>"
								 	+"<th class='table-info' style='width:33.3%'>총 상품 총 금액</th>"
								 	+"<th class='table-info' style='width:33.3%'>총 배송비</th>"
								 	+"<th bgcolor='#80d4ff' style='width:33.3%'>최종 결제금액</th>"
								 +"</tr>"
								 +"<tr>"
								 	+"<td><span id='all_total_value'>"+allvalue+"</span>원</td>"
								 	+"<td><span id='all_total_shipfee'>"+allshipfee+"</span>원</td>"
								 	+"<td bgcolor='#80d4ff'><span id='final_payment_value' style='color:#f51167;'>"+finalvalue+"</span><span style='#f51167'>원</span></td>"
								 +"<tr>"
								+"</table>";
				c.append(chargeApp); 
				// 하단 결제정보 테이블 끝 //	
				var bottomBtnGroup="<div style='text-align:center;''>"
						+"<button type='button' class='btn btn-primary btn-lg' id='usedallorder'>주문하기</button>"
					  	+"<a href='${cp}/'><button type='button' class='btn btn-light btn-lg'>쇼핑계속하기</button></a>"
					  	+"</div>"
				c.append(bottomBtnGroup);
			}
		});	
	}
	//각 중고판매자테이블 주문버튼 클릭시
	$(document).on('click','.usedorderTopBtn',function(){
		var form=$('<form></form>');
		form.attr('action','${cp}/order/usedorder');
		form.attr('method','post');
		form.appendTo('body');
		var sid=$(this).data('sid');
		$("."+sid+"_checkTd").each(function(){
			if($(this).is(':checked')){
				var cartNumValue=$(this).data('cartnum');
				var cartNum=$("<input type='hidden' value="
						+cartNumValue+" name='cartNum'>");
				form.append(cartNum);
			}
		});
		form.submit();
	})
	
	//맨아래 주문하기 버튼 클릭시.
	$(document).on('click','#usedallorder',function(){
		var form=$('<form></form>');
		form.attr('action','${cp}/order/usedorder');
		form.attr('method','post');
		form.appendTo('body');
		$(".usedCheckTd").each(function(){
			if($(this).is(":checked")){
				var cartNumValue=$(this).data('cartnum');
				var cartNum=$("<input type='hidden' value="
						+cartNumValue+" name='cartNum'>");
				form.append(cartNum);
			}
		});
		form.submit();
	})
	//중고 각상품마다 주문하기버튼 클릭시. 
	$(document).on('click','.usedorderbtn',function(){
		var cartNumValue=$(this).data('cartnum');
		var form=$('<form></form>');
		form.attr('action','${cp}/order/usedorder');
		form.attr('method','post');
		form.appendTo('body');
		var cartNum=$("<input type='hidden' value="
				+cartNumValue+" name='cartNum'>");
		form.append(cartNum);
		form.submit();
	});
	
	//맨아래 결제정보 테이블 정보 변경 함수
	var renewchargetable=function(){
		var allvalue=0;
		var allshipfee=0;
		$(".used_total_value").each(function(){
			allvalue+=Number($(this).text());
		});
		$(".used_total_shipfee").each(function(){
			allshipfee+=Number($(this).text());
		});
		var finalvalue=allvalue+allshipfee;
		$("#all_total_vale").text(allvalue);
		$("#all_total_shipfee").text(allshipfee);
		$("#final_payment_value").text(finalvalue);
	}
	//중고테이블 체크 바뀔때마다 배송비계산
	var checkshipfee=function(sid){
		var fee=0;
		$("."+sid+"_checkTd").each(function(){
			if($(this).is(":checked")){
				if(Number($(this).data('ship'))>fee){
					fee=$(this).data('ship');
				}
			}
		});
		$("#"+sid+"_total_shipfee").text(fee);
		renewchargetable();
	}
		
	
	//중고 테이블마다 맨위의 체크박스 변경시..
	$(document).on('change','.usedTopCheckbox',function(){
		var sid=$(this).data('sid');
		if($(this).is(":checked")){
			$("."+sid+"_checkTd").each(function(){
				if(!$(this).is(":checked")){
					$(this).prop("checked",true)
					$(this).change();
				}
			})
		}else{
			$("."+sid+"_checkTd").each(function(){
				if($(this).is(":checked")){
					$(this).prop("checked",false)
					$(this).change();
				}
			});
		}	
	})
	// 중고상품 테이블  행 체크박스 클릭시 이벤트 
	$(document).on('change','.usedCheckTd',function(){
		var sid=$(this).data('sid');
		if($(this).is(":checked")){
			var value=$(this).data('value');
			var orgtotal_value=$("#"+sid+"_total_value").text();
			var total_value=Number(orgtotal_value)+Number(value);
			$("#"+sid+"_total_value").text(total_value);
		}else{
			var value=$(this).data('value');
			var orgtotal_value=$("#"+sid+"_total_value").text();
			var total_value=Number(orgtotal_value)-Number(value);
			$("#"+sid+"_total_value").text(total_value);
		}	
		checkshipfee(sid);
	})

	
	//=====================중고 관린 스크립트 끝 ===========================//
	
	//각행의 삭제버튼 클릭시.
	$(document).on('click','.deletebtn',function(){
		$("#deletebtn_modal").val($(this).data('id'));
		$("#deleteModal").modal('show');
	});
	//맨위 삭제버튼클릭시...
	$("#deleteTopBtn").click(function(){
		var cartNum=[];
		$('.checkTd').each(function(){
			if($(this).is(":checked")){
				var num=$(this).data('id')
				cartNum.push(num);
			}
		})

		$.ajax({
			url:'/finalproject/pay/deleteSelectCart',
			data:{cartNumlist:cartNum},
			dataType:'json',
			type:'post',
			success:function(data){
				if(data.result=='success'){
					clearCart();
					viewCart();
				}
			}
		});
	});
	//하나삭제 모달에서 삭제하기 버튼 눌렀을때
	$("#deletebtn_modal").click(function(){
		var cartNum=$(this).val();
		$.ajax({
			url:"/finalproject/pay/deleteOneCart",
			data:{cartNum:cartNum},
			dataType:"json",
			success:function(data){
				if(data.result=='success'){
					clearCart();
					viewCart();
					viewusedcart();
				}
			}
		});
		$("#deleteModal").modal('hide');
	});
	
	//=====================새제품 관린 스크립트 시작 ===========================//
	
	//장바구니 클리어 
	var clearCart=function(){
		$("#newtbody").empty();
		$("#useditem").empty();
	}
	//장바구니 리스트 
	var viewCart=function(){
		$("#allcheck").prop("checked",true);
		$.ajax({
			url:"/finalproject/pay/cartlist",
			dataType:"json",
			success:function(data){
				var total_value="0";
				var total_point="0";
				var datalength=$(data).length
				if(datalength==0){ 
					var tableapp="<tr>"
								+"<td colspan='8' align='center'><strong><span>장바구니에 담긴 상품이 없습니다.</span></strong></td>"
					$("#newtbody").append(tableapp);
					$("#total_value,#new_total_value,#new_total_shipfee,#final_payment_newvalue").text(total_value);
					$("#total_point").text(total_point);
				}else{
					$(data).each(function(index,item){
						var tableapp="<tr>"
									+"<td><input class='checkTd' style='zoom:1.5;' type='checkbox' checked='checked' data-id="+item.cartnum+" data-totalpoint="+item.totalpoint+"></td>"
									+"<td><img src="+item.imgsrc+" class='cartlistimg'></td>"
									+"<td>"+item.btitle+"</td>"
									+"<td>"+item.bprice+"</td>"
									+"<td>"+item.bpoint+"</td>"
									+"<td><input type='text' value="+item.bcount+" style='width:25px'><br><button type='button' class='btn btn-dark countbtn'"
									+" data-id="+item.cartnum+">변경</button></td>"
									+"<td><strong>"+item.totalvalue+"</strong></td>"
									+"<td align='right'><button type='button' class='btn btn-dark orderbtn' data-cartnum="+item.cartnum+" data-id="+item.bnum+">주문하기</button><br>"
									+"<button type='button' class='btn btn-light deletebtn' data-id="+item.cartnum+
									" data-toggle='modal'>삭제하기</button></td></tr>";
						total_value=Number(total_value)+Number(item.totalvalue);
						total_point=Number(total_point)+Number(item.totalpoint);	
						$("#newtbody").append(tableapp);
					});	
					//리스트 불러온후 총액/포인트값  맨하단에 넣기.
					$("#total_value,#new_total_value").text(total_value);
					var shipfee=0;
					$("#total_point").text(total_point);
					if(total_value>=50000){
						$("#new_total_shipfee").text(shipfee);
					}else{
						shipfee=2500;
						$("#new_total_shipfee").text(shipfee);
					}
					
					
					var final_value=total_value+shipfee;
					$("#final_payment_newvalue").text(final_value)
					
					//각행의 주문버튼 클릭시.
					$(".orderbtn").click(function(){
						var cartNumValue=$(this).data('cartnum');
						var form=$('<form></form>');
						form.attr('action','${cp}/order/order');
						form.attr('method','post');
						form.appendTo('body');
						var cartNum=$("<input type='hidden' value="
								+cartNumValue+" name='cartNum'>");
						form.append(cartNum);
						form.submit();
					});
				
					//수량 변경버튼 클릭시.
					$(".countbtn").click(function(){
						var tr=$(this).parent().parent()
						var td=tr.children();
						var newCount=td.eq(5).children().val();
						var cartNum=$(this).data('id');
						$.ajax({
							url:"/finalproject/pay/changeCount",
							data:{cartNum:cartNum,newCount:newCount},
							dataType:"json",
							success:function(data){
								if(data.result=='success'){
									clearCart();
									viewCart();
								}
							}
						});
					});
					//맨위 주문버튼 클릭시.
					$("#orderTopBtn,#odbtn").click(function(){
						var form=$('<form></form>');
						form.attr('action','${cp}/order/order');
						form.attr('method','post');
						form.appendTo('body');
						var i=0;
						$('.checkTd').each(function(){
							if($(this).is(":checked")){
								i++;
								var cartNumValue=$(this).data('id')
								var cartNum=$("<input type='hidden' value="
										+cartNumValue+" name='cartNum'>");
								form.append(cartNum);
							}
						});
						if(i==0){
							$("#alertmodal").modal('show')
							return;
						}
						
						form.submit();
					});
					
					
				}
			
			}
		})
	}
	//각행 체크버튼 체크/비체크시.
	$(document).on('change','.checkTd',function(){ 
		var shipfee=0;
		if($(this).is(":checked")){		
			var checkTd=$(this)
			var tr=checkTd.parent().parent();
			var td=tr.children();
			var value=td.eq(6).text();
			var point=checkTd.data("totalpoint");
			var orgtotal_value=$("#total_value").text();
			var orgtotal_point=$("#total_point").text();
			var total_value=Number(orgtotal_value)+Number(value);
			var total_point=Number(orgtotal_point)+Number(point);
			$("#total_value,#new_total_value").text(total_value);
			$("#total_point").text(total_point);
			
			if(total_value>=50000){
				shipfee=0;
				$("#new_total_shipfee").text(shipfee);
			}else{
				shipfee=2500;
				$("#new_total_shipfee").text(shipfee);
			}
			var final_value=total_value+shipfee;
			$("#final_payment_newvalue").text(final_value)
		}else{
			var checkTd=$(this)
			var tr=checkTd.parent().parent();
			var td=tr.children();
			var value=td.eq(6).text();
			var point=checkTd.data("totalpoint");
			var orgtotal_value=$("#total_value").text();
			var orgtotal_point=$("#total_point").text();
			var total_value=Number(orgtotal_value)-Number(value);
			var total_point=Number(orgtotal_point)-Number(point);
			$("#total_value,#new_total_value").text(total_value);
			$("#total_point").text(total_point);
			if(total_value>=50000){
				shipfee=0;
				$("#new_total_shipfee").text(shipfee);
			}else{
				shipfee=2500;
				$("#new_total_shipfee").text(shipfee);
			}
			var final_value=total_value+shipfee;
			$("#final_payment_newvalue").text(final_value)
		}	
		checkValue();
	});
	var checkValue=function(){
		var i=0;
		$('.checkTd').each(function(){
			if($(this).is(":checked")){
				i++;
			}
		});
		if(i==0){
			$("#new_total_shipfee").text(0);
			$("#final_payment_newvalue").text(0);
		}
	}
	//전체체크 버튼.
	$("#allcheck").change(function(){
			if($("#allcheck").is(":checked")){
				$(".checkTd").each(function(){
					if(!$(this).is(":checked")){
						$(this).prop("checked",true)
						$(this).change();
					}
				})
			}else{
				$(".checkTd").each(function(){
					if($(this).is(":checked")){
						$(this).prop("checked",false)
						$(this).change();
					}
				});
			}	
	});
	
	//=====================새제품 관린 스크립트 끝 ===========================//
	
	
</script>

