<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/1/30
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    页脚ssdsfa </br>
    <%
        response.getWriter().write(request.getParameter("username"));
    %>
</body>
</html>
