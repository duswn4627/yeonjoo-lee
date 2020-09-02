<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="topButton" style="height:35px;">
	<span>선택한 상품  </span><button type='button' class='btn btn-outline-dark btn-sm'>주문하기</button>
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
	<tbody>
	
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8" align="right">
			상품 총 금액 : <strong><span id="total_value"></span></strong>원  
			| 포인트 총 적립액 : <strong><span id="total_point"></span></strong>원</td>
		</tr>
	</tfoot>
</table>
<!-- ////////////////////////Modal ///////////////////////////-->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="deleteModalLabel">물품 삭제</h5>
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
<!-- /////////////////////////////////// -->
<script>
	$(document).ready(function() {
		viewCart();
	})
	var clearCart=function(){
		$("tbody").empty();
	}
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
					$("tbody").append(tableapp);
					$("#total_value").text(total_value);
					$("#total_point").text(total_point);
				}else{
					$(data).each(function(index,item){
						var tableapp="<tr>"
									+"<td><input class='checkTd' style='zoom:1.5;' type='checkbox' checked='checked' data-id="+item.cartnum+"></td>"
									+"<td><img src="+item.imgsrc+" class='cartlistimg'></td>"
									+"<td>"+item.btitle+"</td>"
									+"<td>"+item.bprice+"</td>"
									+"<td>"+item.bpoint+"</td>"
									+"<td><input type='text' value="+item.bcount+" style='width:25px'><br><button type='button' class='btn btn-dark countbtn'"
									+" data-id="+item.cartnum+">변경</button><input type='hidden' value="+item.bnum+"></td>"
									+"<td><strong>"+item.totalvalue+"</strong></td>"
									+"<td align='right'><button type='button' class='btn btn-dark'>주문하기</button><br>"
									+"<button type='button' class='btn btn-light deletebtn' data-id="+item.cartnum+
									" data-toggle='modal'>삭제하기</button></td></tr>";
						total_value=Number(total_value)+Number(item.totalvalue);
						total_point=Number(total_point)+Number(item.bpoint);	
						$("tbody").append(tableapp);
					});	
					//리스트 불러온후 총액/포인트값  맨하단에 넣기.
					$("#total_value").text(total_value);
					$("#total_point").text(total_point);
					
					//각행 체크버튼 체크/비체크시.
					$(".checkTd").change(function(){ 
					
						if($(this).is(":checked")){
							var checkTd=$(this)
							var tr=checkTd.parent().parent();
							var td=tr.children();
							var value=td.eq(6).text();
						
							var point=td.eq(4).text();
							var orgtotal_value=$("#total_value").text();
							var orgtotal_point=$("#total_point").text();
							var total_value=Number(orgtotal_value)+Number(value);
							var total_point=Number(orgtotal_point)+Number(point);
							$("#total_value").text(total_value);
							$("#total_point").text(total_point);
						}else{
							var checkTd=$(this)
							var tr=checkTd.parent().parent();
							var td=tr.children();
							var value=td.eq(6).text();
							var point=td.eq(4).text();
							var orgtotal_value=$("#total_value").text();
							var orgtotal_point=$("#total_point").text();
							var total_value=Number(orgtotal_value)-Number(value);
							var total_point=Number(orgtotal_point)-Number(point);
							$("#total_value").text(total_value);
							$("#total_point").text(total_point);
						}	
					});
					//각행의 삭제버튼 클릭시.
					$(".deletebtn").click(function(){
						$("#deletebtn_modal").val($(this).data('id'));
						$("#deleteModal").modal('show');
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
				}
			
			}
		})
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
				}
			}
		});
		$("#deleteModal").modal('hide');
	});
	
	
</script>

