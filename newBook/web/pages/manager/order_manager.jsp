<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%--静态包含--%>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
			<div>
				<a href="manager/bookServlet?action=page">图书管理</a>
				<a href="orderServlet?action=showOrderAll">订单管理</a>
				<a href="index.jsp">返回商城</a>
			</div>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
				
			</tr>
			<c:forEach items="${requestScope.allOrder}" var="order">
			<tr>
				<td>${order.create_time}</td>
				<td>${order.price}</td>
				<td><a href="orderServlet?action=more&orderId=${order.order_id}">查看详情</a></td>
				<c:if test="${order.status == 0}">
				<td><a href="orderServlet?action=ship&orderId=${order.order_id}">点击发货</a></td>
				</c:if>
				<c:if test="${order.status == 1}">
					<td>已发货</td>
				</c:if>
				<c:if test="${order.status == 2}">
					<td>已签收</td>
				</c:if>
			</tr>
			</c:forEach>
			

		</table>
	</div>

	<%--静态包含--%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>