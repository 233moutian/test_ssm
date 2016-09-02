<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<br>
<!----------- 分页部分 ------------>
<pg:pager url="${param.url }" items="${param.count}"
          maxPageItems="20"
          maxIndexPages="10" export="currentPageNumber=pageNumber">
    <pg:first>
        <a href="${pageUrl }"><b>首页</b></a>
    </pg:first>
    <pg:prev>
        <a href="${pageUrl }"><b>前页</b></a>
    </pg:prev>
    <pg:pages>
        <c:choose>
            <c:when test="${currentPageNumber eq pageNumber}">
                <font color="red"><b>${pageNumber }</b></font>
            </c:when>
            <c:otherwise>
                <a href="${pageUrl }"><b>${pageNumber }</b></a>
            </c:otherwise>
        </c:choose>
    </pg:pages>
    <pg:next>
        <a href="${pageUrl }"><b>下页</b></a>
    </pg:next>
    <pg:last>
        <a href="${pageUrl }"><b>尾页</b></a>
    </pg:last>
</pg:pager>
</center>
<h></h>
<br>
</body>
</html>
