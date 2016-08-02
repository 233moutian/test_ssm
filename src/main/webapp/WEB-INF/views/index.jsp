<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table width="80%" align="center">
    <tr>

        <td>编号</td>
        <td>姓名</td>
        <td>密码</td>

    </tr>
    <c:forEach items="${list }" var="bean">
    <tr>
        <td>${bean.id}</td>
        <td>${bean.password}</td>
        <td>${bean.username}</td>
    </tr>
    </c:forEach>


</table>


</body>
</html>
