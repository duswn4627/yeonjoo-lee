<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${cp }/resources/hd/css_main/result.css" />
<div class="container" id="resultcontainer"> 
	<div class='contentbox'>
		<img src="${cp }/resources/hd/image/quotation_open.png" class="quotationimg">
		<h2 style='display:inline'>${vo.name }��  GoBooK�� �̿����ּż� �����մϴ�!</h2>
		<img src="${cp }/resources/hd/image/quotation_close.png" class="quotationimg">
		<p id="orderP">�ֹ���ȣ : [<strong>${ vo.ordernum }</strong>] ������ �����ϰ� ó���Ǿ����ϴ�.</p>
	</div>
	<div class='contentbox' id="topcontentdiv">
		<c:choose>
			<c:when test="${ method=='vbank' && separate=='new' }">
				<h4>${vo.name }�� ������¿� �Ա����ּ���. �ԱݿϷ� �� ����� ���۵˴ϴ�!</h4>
				<p>�Աݰ��� : ${bank.vbank_name } ${bank.vbank_num }  ������ : ${bank.vbank_holder } �Աݾ� : <strong>${payvalue }</strong>��</p>
			</c:when>
			<c:when test="${ method=='vbank' && separate=='used'}">
				<h4>${vo.name }�� ������¿� �Ա����ּ���. �Ǹ��� Ȯ�� �� ����� ���۵˴ϴ�!</h4>
				<p>�Աݰ��� : ${bank.vbank_name } ${bank.vbank_num }  ������ : ${bank.vbank_holder } �Աݾ� : <strong>${payvalue }</strong>��</p>
			</c:when>
			<c:when test="${ method=='card' && separate=='new'}">
				<h4>${vo.name }�� ī����� �Ϸ�! 1-2���̳��� ����� ���۵˴ϴ�!</h4>
			</c:when>
			<c:otherwise>
				<h4>${vo.name }�� ī����� �Ϸ�! �Ǹ��� Ȯ�� �� ����� ���۵˴ϴ�!</h4>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="shipdiv">
		<p class="titleloc"><strong><span class="colorfont">�����</span>����</strong></p>
		<div id="uldiv">
			<ul>
				<li>�޴º� : ${vo.receiver }</li>
				<li>
					�ּ� :  <img src="${cp }/resources/hd/image/addricon_land.gif"><span>${vo.jibunaddr }</span><br>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<img src="${cp }/resources/hd/image/addricon_road.gif"><span>${vo.roadaddr }</span>
				</li>
			</ul>
		</div>
	</div>
	
	<div id="orderlistdiv">
		<p class="titleloc"><strong><span class="colorfont">�ֹ�</span>��ǰ</strong></p>
		<table class="table" id="listtable">
			<!-- ======= ����ǰ�� ��� ���� =========== -->
			<c:choose>
			<c:when test="${separate=='new' }">
			<thead>
			<tr>
				<th colspan="2" style="text-align: center">��ǰ��</th>
				<th style="text-align: center">�ǸŰ�</th>
				<th style="text-align: center">����Ʈ</th>
				<th style="text-align: center">����</th>
				<th style="text-align: center">�հ�</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${list }">
				<tr>
					<td style='width:10%'><img src="${item.imgpath }" class="listimg"></td>
					<td style='width:53%'>${item.btitle }</td>
					<td style='width:10%;text-align: center;'>${item.bprice }</td>
					<td style='width:10%;text-align: center;'>${item.bpoint }</td>
					<td style='width:8%;text-align: center;'>${item.bcount }</td>
					<td style='width:12%;text-align: center;'><strong>${item.totalvalue }</strong>��</td>
				</tr>
			</c:forEach>
			</tbody>
			</c:when>
			<c:otherwise> 
			<thead>
				<tr>
					<th colspan="2" style="text-align: center">��ǰ��</th>
					<th style="text-align: center">�Ǹ���</th>
					<th style="text-align: center">�ǸŰ�</th>
					<th style="text-align: center">����</th>
					<th style="text-align: center">�հ�</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${list }">
					<tr>
						<td style='width:10%'><img src="${item.imgpath }" class="listimg"></td>
						<td style='width:53%'>${item.statusString}&nbsp${item.obname }</td>
						<td style='width:10%;text-align: center;'>${item.sid }</td>
						<td style='width:10%;text-align: center;'>${item.obsaleprice }</td>
						<td style='width:8%;text-align: center;'${item.bcount }></td>
						<td style='width:12%;text-align: center;'><strong>${item.totalvalue }</strong>��</td>
					</tr>
				</c:forEach>
			</tbody>
			</c:otherwise>
			</c:choose>
		</table>
	</div>	
	<div>
		<p class="titleloc"><strong><span class="colorfont">����</span>����</strong></p>
			<table class="table">
			<tr>
				<th class="table-secondary">�� ��ǰ�ݾ�</th>
				<th class="table-secondary">��ۺ�</th>
				<th class="table-secondary">�������Ʈ</th>
				<td rowspan="2" class="table-danger">
					<strong>���� �����ݾ�</strong><br>
					<span class="final_payment_price">${vo.paymentmoney+vo.delfee}</span>��<br>
					<c:if test="${separate=='new' }">
						<strong>������������Ʈ</strong><br>
						<span id="totalpoint">${totalpoint }</span>
					</c:if>
				</td>
			</tr>	
			<tr class="table-secondary">
				<td>${totalprice }��</td>
				<td><span id="ship_charge">${vo.delfee }</span>��</td>
				<td>
					<span id="use_point">${vo.usedpoint }</span>��
				</td>
			</tr>
			</table>
	</div>
	<div id="buttondiv">
		<a href="${cp }/"><button type="button" class="btn btn-dark" >���������̵�</button></a> 
		<a href="${cp }/mypage/main"><button type="button" class="btn btn-light">����������</button></a>
	</div>
</div>