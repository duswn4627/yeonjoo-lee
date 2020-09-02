<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- stylesheet관련 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/jh/jhcss/bootstrap.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/jh/jhcss/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/jh/jhcss/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/jh/jhcss/slicknav.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/jh/jhcss/owl.carousel.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/jh/jhcss/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/jh/jhcss/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/jh/jhcss/flaticon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/jh/jhcss/jhcss.css">
<script type="text/javascript" src="${cp }/resources/jh/js/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<title>중고판매관리</title>
</head>
<body>
<div id="wrap">
	<div id="header">
		<tiles:insertAttribute name="sellerHeader"/>
	</div>
	<div id="content">
		<tiles:insertAttribute name="sellerContent"/>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="sellerFooter"/>
	</div>
</div>
</body>
</html>