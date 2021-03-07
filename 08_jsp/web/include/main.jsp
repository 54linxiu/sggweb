<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/1/30
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    页眉</br>
    内容</br>
<%--    <%@include file="/include/footer.jsp"%> 静态包含--%>
        <jsp:include page="/include/footer.jsp">
            <jsp:param name="username" value="1433"/>
        </jsp:include>
</body>
</html>
