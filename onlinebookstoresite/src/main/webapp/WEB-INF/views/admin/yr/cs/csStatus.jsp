<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid ">
	<h2 class="pageTitle">취소/교환/반품/환불</h2>
	
	<ul class="tab">	
		<li>
			<span class="thumb"
				<c:choose>
					<c:when test="${PageName == 1 }">style="color: red"</c:when> 
					<c:otherwise>style="color: 	#c9d5e8"</c:otherwise>
				</c:choose>><i class="fas fa-times fa-3x"></i>
				<span class = "title"><a href="${pageContext.request.contextPath}/cs/menu?PageName=1">취소
					<c:forEach items="${countList }" var="list">						
						<c:if test="${list.TYPE == '1'}">
							[${list['COUNT']}]
						</c:if>
					</c:forEach>
				</a></span>
			</span>	
		</li>
		<li>
			<span class="thumb"
				<c:choose>
					<c:when test="${PageName == 3 }">style="color: red"</c:when> 
					<c:otherwise>style="color: 	#c9d5e8"</c:otherwise>
				</c:choose>><i class="fas fa-sync fa-3x"></i>
				<span class = "title"><a href="${pageContext.request.contextPath}/cs/menu?PageName=3">교환
					<c:forEach items="${countList }" var="list">						
						<c:if test="${list.TYPE == '3'}">
							[${list['COUNT']}]
						</c:if>
					</c:forEach>
				</a></span>
			</span>
		</li>
		<li>
			<span class="thumb" 
				<c:choose>
					<c:when test="${PageName == 2 }">style="color: red"</c:when> 
					<c:otherwise>style="color: 	#c9d5e8"</c:otherwise>
				</c:choose>><i class="fas fa-undo-alt fa-3x"></i>
				<span class = "title"><a href="${pageContext.request.contextPath}/cs/menu?PageName=2">반품
					<c:forEach items="${countList }" var="list">						
						<c:if test="${list.TYPE == '2'}">
							[${list['COUNT']}]
						</c:if>
					</c:forEach>
				</a></span>
			</span>
		</li>
		<li>
			<span class="thumb" 
				<c:choose>
					<c:when test="${PageName == 4 }">style="color: red"</c:when> 
					<c:otherwise>style="color: 	#c9d5e8"</c:otherwise>
				</c:choose>><i class="fas fa-comment-dollar fa-3x"></i>
				<span class = "title"><a href="${pageContext.request.contextPath}/cs/menu?PageName=4">환불</a></span>
			</span>
		</li>
	</ul>
	
	
</div>