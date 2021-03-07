<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.Map" %>

<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/1/30
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
        public static final int a = 12;
        private static String b = "A";
        protected static double c;
        public static Map<String,String> map = new Hashtable<>();

    %>

    <%!
        static {
            c = 1.1;
            map.put("1","hello");
            map.put("12","hello");
            map.put("13","hello");
        }
    %>

    <%!
        class A{
//            private int a = q_jsp.this.a;
        }
    %>

    <%=1%></br>
    <%=1.1%></br>
    <%='c'%></br>
    <%="我爱"%></br>
    <%=map%></br>

    <%
        for(int i = 0; i < 10; i++){

    %>
    <table  border="1" cellspacing="0">
        <tr>
            <td><%=i+1%></td>
            <td><%=i+1%></td>
        </tr>
    </table>
    <%
        }
    %>
    </br>
    <!-- jsp hello-->
</body>
</html>
