<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- header.jsp -->
<!-- 여기부터 -->
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
	<a class="navbar-brand" href="${pageContext.request.contextPath}/adminmain">GOBOOK ADMIN</a>
	<button class="btn btn-link btn-sm order-1 order-lg-0"
		id="sidebarToggle" href="#">
		<i class="fas fa-bars"></i>
	</button>
</nav>
<!-- 여기까지 -->
<script type="text/javascript">
    // Toggle the side navigation
    $("#sidebarToggle").on("click", function(e) {
        e.preventDefault();
        $("body").toggleClass("sb-sidenav-toggled");
    });
</script>