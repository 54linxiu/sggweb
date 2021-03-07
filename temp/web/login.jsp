<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/2/14
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="http://localhost:8080/temp/login" method="get">
      用户名:<input type="text" name="username"></br>
      <input style="width: 100px; height: 50px;" type="text" name="code"><img style="width: 100px; height: 50px; vertical-align:middle;" src="http://localhost:8080/temp/kaptchaServlet">
      </br><input type="submit" value="登陆">
  </form>
  </body>
</html>
