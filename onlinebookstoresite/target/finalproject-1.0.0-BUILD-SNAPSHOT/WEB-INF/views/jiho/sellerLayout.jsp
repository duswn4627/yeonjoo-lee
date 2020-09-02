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