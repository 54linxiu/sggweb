<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/1/30
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    context2</br>
    <%=pageContext.getAttribute("key1")%>
    <%=request.getAttribute("key1")%>
    <%=session.getAttribute("key1")%>
    <%=application.getAttribute("key1")%>

</body>
</html>
