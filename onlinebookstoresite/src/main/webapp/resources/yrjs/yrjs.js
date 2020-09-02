/**
 * 
 */
	
	var count = 0;

	$(function(){
		
		var startDate = $('#startDate').val();
		
//		if(startDate == '' || startDate == null){
//			var date = new Date();
//			var yyyy = date.getFullYear();
//			var mm = date.getMonth()+1 > 9 ? date.getMonth()+1 : '0' + (date.getMonth()+1);
//			var dd = date.getDate() > 9 ? date.getDate() : '0' + date.getDate();
//	
//			$('#startDate').val(yyyy+'-'+mm+'-'+dd);
//			$('#endDate').val(yyyy+'-'+mm+'-'+dd);
//		}
		
		//[오늘, 내일, 7일, 1개월, 6개월]버튼 클릭하면 색 바뀜, 해당 날짜로 값 입력
		$('.dbtn').on('click', function() {
			var clickbtn = $(this);

			$('.dbtn').each(function(idx, item) {
				if (clickbtn != $(this)) {
					$(this).removeClass('btn-success');
					$(this).addClass('btn-outline-success');
				}
			})
			
			var v = $(this).val() ;
			
			var startDate = new Date();
			var endDate = new Date();
			
			if(v == '어제'){
				console.log("gg"+v);
				startDate.setDate(startDate.getDate()-1);
			}else if(v == '7일'){
				startDate.setDate(startDate.getDate()-7);
			}else if(v == '1개월'){
				startDate.setMonth(startDate.getMonth()-1);
			}else if(v == '6개월'){
				startDate.setMonth(startDate.getMonth()-6);
			}
			
			
			
			var yyyy = startDate.getFullYear();
			var mm = startDate.getMonth()+1 > 9 ? startDate.getMonth()+1 : '0' + (startDate.getMonth()+1);
			var dd = startDate.getDate() > 9 ? startDate.getDate() : '0' + startDate.getDate();
			
			var yyyy2 = endDate.getFullYear();
			var mm2 = endDate.getMonth()+1 > 9 ? endDate.getMonth()+1 : '0' + (endDate.getMonth()+1);
			var dd2 = endDate.getDate() > 9 ? endDate.getDate() : '0' + endDate.getDate();
			
			
			$('#startDate').val(yyyy+"-"+mm+"-"+dd);			
			$('#endDate').val(yyyy2+"-"+mm2+"-"+dd2);
			
			$(this).removeClass('btn-outline-success');
			$(this).addClass('btn-success');
		
		})
		

		
		//input date 값 검사
		$('input[type=date]').on('change',getDate)
		
		
		function getDate(){
			console.log("count" + count);

			if(count == 0){
				count++;
				return true;
			}
			var startD = $('#startDate').val();
			var endD = $('#endDate').val();
			var startresult = startD.replace(/-/g,'');
			var endresult = endD.replace(/-/g,'');
			if(startresult - endresult > 0){
				alert('날짜를 다시선택해주세요....')
				return false;
			}else{
				return true;
			}
			
		}
		
//	 	1. 전체 누르면 전부다 클릭 되도록, 2. '전체'눌려져 있을때 다른거 누르면 전체 체크 해제
		$(".searchChb").on('click',function(){
			console.log("dddd");
			var value = $(this).val();
			if(value == '-1'){
				var c = $(this).prop('checked');
				$('input[name='+$(this).attr('name')+']').each( function(idx, item){
						$(this).prop('checked',c);
					}
				)
				return;
			}else{
				if($('input[name='+$(this).attr("name")+']').first().prop('checked')){
					$('input[name='+$(this).attr("name")+']').first().prop('checked',false);
				}
			}
		})
		
		
		//주소 | 빼고 나오게 하기
		$('.addr').each(function(idx,item){
			var addr = $(this).text();
			addr =  addr.replace(/\|/g, ' ');
			$(this).text(addr);			
		})
		
		$("#searchSubmitBtn").click(function(){
			if($("input[name=pkeyword]").val() != null && $("input[name=pkeyword]").val() != ""){
				if($("select[name=pfield]").val() == "" || $("select[name=pfield]").val() == null ){
					alert("검색어를 선택해주세요..")
					return;
				}
			}
			
			if($("#startDate").val() != null && $("#startDate").val() != ""){
				if($("select[name=tfield]").val() == "" || $("select[name=tfield]").val() == null ){
					alert("검색어를 선택해주세요..")
					return;
				}
			}
			
			if($("#endDate").val() != null && $("#endDate").val() != ""){
				if($("select[name=tfield]").val() == "" || $("select[name=tfield]").val() == null ){
					alert("검색어를 선택해주세요..")
					return;
				}
			}

			if($("input[name=bkeyword]").val() != null && $("input[name=bkeyword]").val() != ""){
				if($("select[name=bfield]").val() == "" || $("select[name=bfield]").val() == null ){
					alert("검색어를 선택해주세요..")
					return;
				}
			}
			
			if(!getDate()){
				return;
			}
			
			$("#searchform").submit();
		})
		
		$("#resetBtn").click(function(){
			$("select[name=pfield]").val('');
			$("select[name=tfield]").val('');
			$("select[name=pkeyword]").val('');
			$("select[name=bfield]").val('');
			$("select[name=bkeyword]").val('');
			$('#form1 input[name=bstatus]').removeAttr('checked');
			$('#form1 input[name=type]').removeAttr('checked');
			$('#form1 input[name=payType]').removeAttr('checked');
			$('#form1 input[name=mType]').removeAttr('checked');
		})
	})
	

