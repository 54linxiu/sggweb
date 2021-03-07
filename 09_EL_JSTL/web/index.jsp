<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="com.qht.bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>$Title$</title>
  </head>
  <body>
  <c:set scope="session" var="aa" value="caaasdfaaac"/>
  <c:set scope="session" var="c" value="caaasdfaaac"/>
  ${aa}

  <hr>
  <c:if test="${12==12}">
    <p>a</p>
  </c:if>
  <hr>
  <c:choose>
    <c:when test="${sessionScope.aa == 'caaasdfaaac'}">yes</c:when>
    <c:when test="${sessionScope.aa == 'caafdac'}">df</c:when>
    <c:otherwise>other</c:otherwise>
  </c:choose>
  <hr>
  <c:forEach begin="1" end="10" var="c">
    <h3>${c}</h3>
  </c:forEach>

  <hr>
  <%
    String[] str = new String[]{"dfafd","dfiajodf","sdfa"};
    pageContext.setAttribute("a",str);
  %>
  <c:forEach items="${pageScope.a}" var="i">
    ${i}<br>
  </c:forEach>
  <h3>${c}</h3>

  <hr>
  <%
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
// for ( Map.Entry<String,Object> entry : map.entrySet()) {
// }
    request.setAttribute("map", map);
  %>
  <c:forEach items="${ requestScope.map }" var="entry">
    <h1>${entry.key} = ${entry.value}</h1>
  </c:forEach>

  <%
    List<Student> list = new ArrayList<>();

    for (int i = 1; i < 11; i++) {
      list.add(new Student(i,"username"+i,"password"+i,"phone"+i));
    }
    pageContext.setAttribute("stu",list);
  %>
  <table border="red 1px" cellpadding="0">
    <tr>
      <th>编号</th>
      <th>用户名</th>
      <th>密码</th>
      <th>手机号</th>
    </tr>
  <c:forEach items="${pageScope.stu}" var="stu">
    <tr>
      <td>${stu.id}</td>
      <td>${stu.username}</td>
      <td>${stu.password}</td>
      <td>${stu.phone}</td>
    </tr>
  </c:forEach>

  </table>
  </body>
</html>
