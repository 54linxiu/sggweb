<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/1/30
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .w{
        width: 800px;
    }
</style>
<body>
    <h1 align="center">九九乘法表</h1>
    <table class="w" align="center" >
        <%
            for (int i = 1; i < 10; i++) {
        %>
        <tr>
        <%
                for (int j = 1; j < i; j++) {
        %>

            <td>
                <%=j + " * " + i + " = " + i * j%>
            </td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>

    </table>


</body>
</html>
