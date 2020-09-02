<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>GB Admin Page</title>

<link
	href="${pageContext.request.contextPath}/resources/yjcss/css/styles.css"
	rel="stylesheet" />


<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>	

<script
	src="${pageContext.request.contextPath}/resources/yjcss/js/scripts.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script
	src="${pageContext.request.contextPath}/resources/yjcss/js/scripts.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
	crossorigin="anonymous"></script>
<link
	href="${pageContext.request.contextPath}/resources/yrcss/yrcss.css"
	rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/resources/yrjs/yrjs.js"></script>

</head>

<body class="sb-nav-fixed">
	<!-- tiles 헤더 설정 -->
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>

	<div id="layoutSidenav">
		<!-- sidemanu tiles -->
		<div id="sidemanu">
			<tiles:insertAttribute name="sidemanu" />
		</div>

		<div id="layoutSidenav_content">
			<!-- content tiles -->
			<div id="content">
				<main><tiles:insertAttribute name="content" /></main>
			</div>

			<!-- footer tiles -->
			<div id="footer">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
		<!-- layoutSidenav_content -->
	</div>
	<!-- layoutSidenav -->
</body>
</html>