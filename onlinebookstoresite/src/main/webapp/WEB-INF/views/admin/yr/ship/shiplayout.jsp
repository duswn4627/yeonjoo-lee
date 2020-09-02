<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="container-fluid">
	<tiles:insertAttribute name="shipStatus" />
	<tiles:insertAttribute name="shipsearch" />
	<tiles:insertAttribute name="shiptables" />
</div>