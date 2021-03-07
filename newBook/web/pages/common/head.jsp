<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/2/6
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            +request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()
            +"/"
            ;
    pageContext.setAttribute("basePath",basePath);
%>
<%--<%=basePath%>--%>
<!--		永远固定相对路径-->
<base href="<%=basePath%>">

<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script src="static/script/static/script/jquery-3.3.1.js"></script>