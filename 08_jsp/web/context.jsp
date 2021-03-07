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
    context1</br>
    <%

        pageContext.setAttribute("key1","pageContext");
        request.setAttribute("key1","request");
        session.setAttribute("key1","session");
        application.setAttribute("key1","application");


//        request.getRequestDispatcher("/context2.jsp").forward(request, response);

    %>
<%--    请求转发--%>
    <jsp:forward page="/context2.jsp"></jsp:forward>

</body>
</html>
