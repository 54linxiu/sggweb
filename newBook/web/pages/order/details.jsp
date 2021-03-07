<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/2/17
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <%--静态包含--%>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
<h3>订单号:${param.orderId}</h3>
<div id="main">
        <table>
            <tr>
                <td>名称</td>
                <td>数量</td>
                <td>价格</td>
                <td>总价</td>
            </tr>
            <c:forEach items="${orderItmelist}" var="itme">
                <tr>
                    <td>${itme.name}</td>
                    <td>${itme.count}</td>
                    <td>${itme.price}</td>
                    <td>${itme.total_price}</td>
                </tr>
            </c:forEach>
        </table>
</div>

<%--静态包含--%>
<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
