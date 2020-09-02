<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jimin/layout</title>
<script type="text/javascript" src="${cp }/resources/JIMIN/js/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="${cp}/resources/JIMIN/css/bootstrap.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous"> -->

<script type="text/javascript" src="${cp }/resources/JIMIN/js/bootstrap.js"></script>

</head>
<body>
<div class="container-fluid" id="wrap">
	<div id="header">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<br>
	<div id="content">
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>
	<br>
	<div id="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</div>
</body>
</html>