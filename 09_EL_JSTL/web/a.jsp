<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/1/31
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","value");
    %>

    jsp表达式<%=request.getAttribute("key")%></br>
    EL表达书${key}
    ${pageContext.request}

</body>
</html>
