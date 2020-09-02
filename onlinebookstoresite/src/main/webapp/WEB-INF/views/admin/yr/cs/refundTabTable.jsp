<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class = "container-fluid">
	<h2 class="mt-4 pageTitle" >주문 리스트</h2>

	<!-- 상단 탭메뉴 -->
	<div class="salesTopMenu">
	
		<input id="tab1" type="radio" name="tabs"  <c:if test="${checked == 'tab1'}"> checked </c:if>><label for="tab1">전체</label>
		<input id="tab2" type="radio" name="tabs" <c:if test="${checked == 'tab2'}"> checked </c:if>><label for="tab2">신청</label>
		<input id="tab3" type="radio" name="tabs" <c:if test="${checked == 'tab3'}"> checked </c:if>><label for="tab3">완료</label>
	
		<section id="content1" >
			<c:if test="${path == 4 }">
				<jsp:include page="refundTable.jsp" />	
			</c:if>
		</section>
		<section id="content2">
			<c:if test="${path == 5 }">
				<jsp:include page="refundTable.jsp" />	
			</c:if>
		</section>
		<section id="content3">
			<c:if test="${path == 6 }">
				<jsp:include page="refundTable.jsp" />	
			</c:if>
		</section>
	</div>	
</div>

<script type="text/javascript">
	$(function(){
		$('#tab1').click(function(){
			location.href = "${pageContext.request.contextPath}/cs/menu?PageName=4";
		})
		
		$('#tab2').click(function(){
			location.href = "${pageContext.request.contextPath}/cs/menu?PageName=5";
		})
		
		$('#tab3').click(function(){
			location.href = "${pageContext.request.contextPath}/cs/menu?PageName=6";
		})
	})
</script>