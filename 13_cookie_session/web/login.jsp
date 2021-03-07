<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/2/13
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/cookie/login" method="get">
        用户名:<input type="text" name="username" value="${cookie.username.value}">
        密&ensp;码:<input type="password" name="password">
        <input type="submit" value="登陆">
    </form>
</body>
</html>
