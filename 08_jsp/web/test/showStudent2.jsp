<%@ page import="com.qht.pojo.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/1/30
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 600px;
            border:1px yellow solid;
            border-collapse: collapse;
        }
        td,th{
            border: 1px black solid;
        }
    </style>
</head>
<body>
    <%
        List<Student> list = (List<Student>) request.getAttribute("sname");

        for(int i = 0;i < 10; i++){
            list.add(new Student(i,"linxiu"+i,5+i,"2656"+i));
        }
    %>

    <table>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>年纪</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
    <%
        for (Student student : list) {
    %>
        <tr>
            <td><%=student.getId()%></td>

            <td><%=student.getName()%></td>

            <td><%=student.getAge()%></td>

            <td><%=student.getPhone()%></td>
            <td><%="删除|修改"%></td>
        </tr>
    <%
        }
    %>
    </table>

</body>
</html>
