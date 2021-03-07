<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <%--静态包含--%>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">我的订单</span>
    <%--		静态包含--%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
        </tr>
        <%--<c:forEach items="${userOrder}" var="i">
            <tr>
                <td>${i.create_time}</td>
                <td>${i.price}</td>
                <td>${i.status}</td>
                <td><a href="orderServlet?action=more&orderId=${i.order_id}">更多信息</a></td>
            </tr>
        </c:forEach>--%>
        <c:forEach items="${orderpage.items}" var="i">
            <tr>
                <td>${i.create_time}</td>
                <td>${i.price}</td>
                <td>${i.status}</td>
                <td><a href="orderServlet?action=more&orderId=${i.order_id}">更多信息</a></td>
            </tr>
        </c:forEach>

    </table>




    <div style="margin:0 auto;width: 100px">
        <c:forEach begin="1" end="${orderpage.pageTotal}" var="i">
            <a href="${orderpage.url}${i}">${i}</a>
        </c:forEach>
    </div>

</div>

<%--静态包含--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>