<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class = "container-fluid">
	<h2 class="mt-4 pageTitle" >주문 리스트</h2>
	<!-- 상단 탭메뉴 -->
	<div class="salesTopMenu">
		
		<input id="tab1" type="radio" name="tabs"  <c:if test="${type == '1'}"> checked </c:if>><label for="tab1">책</label>
		<input id="tab2" type="radio" name="tabs" <c:if test="${type == '2'}"> checked </c:if>><label for="tab2">중고 책</label>
			
		<!-- 새책 입금전 리스트 -->
		<section id="content1" >
			<c:if test="${type == 1 }">
				<jsp:include page="${jsp}.jsp" />	
			</c:if>		
		</section>
		<!-- 중고책 입금전 취소-->
		<section id="content2">
			<c:if test="${type == 2 }">
				<jsp:include page="${jsp}.jsp" />	
			</c:if>	
		</section>
	</div>
</div>

<script type="text/javascript">
	$(function(){
		$('#tab1').click(function(){
			location.href = "${pageContext.request.contextPath}/ship/menu?PageName=${path}&type=1";
		})
		$('#tab2').click(function(){
			location.href = "${pageContext.request.contextPath}/ship/menu?PageName=${path}&type=2";
		})
	})
</script>