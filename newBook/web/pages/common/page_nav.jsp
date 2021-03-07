<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2021/2/12
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <%--        大于首页才显示--%>
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}1">首页</a>
        <a href="${requestScope.page.url}${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <c:choose>
        <%--总页数小于6的情况--%>
        <c:when test="${requestScope.page.pageTotal<=6}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
        </c:when>
        <%--总页数大于6的情况--%>
        <c:when test="${requestScope.page.pageTotal>6}">
            <c:choose>
                <%--  小情况1  1 2 3 4 5 6--%>
                <c:when test="${requestScope.page.pageNo<=3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="6"></c:set>
                </c:when>
                <%--  小情况2   9 10 max--%>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-5}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
                </c:when>
                <%--小情况3  ... 8 9 10 ... --%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageNo+3}"></c:set>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${requestScope.page.pageNo eq i}">
            <a href="${requestScope.page.url}${i}">{${i}}</a>
        </c:if>
        <c:if test="${ requestScope.page.pageNo ne  i}">
            <a href="${requestScope.page.url}${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%--    如果是最后一页则不显示 下一页 末页--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
    <input id="appoint" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            $("#appoint").click(function () {
                var numpage = $("#pn_input").val();
                var maxpage = ${requestScope.page.pageTotal};

                if (numpage > maxpage) {
                    return false;
                }
                if (numpage < 1) {
                    return false;
                }

                <%--var pageTotal = ${requestScope.page.pageTotal};--%>
                <%--alert(pageTotal);--%>
                // javaScript 语言中提供了一个 location 地址栏对象
                // 它有一个属性叫 href.它可以获取浏览器地址栏中的地址
                // href 属性可读，可写
                location.href = "${pageScope.basePath}${requestScope.page.url}" + numpage;
            });
        });
    </script>
</div>
