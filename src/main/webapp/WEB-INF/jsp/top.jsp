<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<meta charset="UTF-8">
<meta name="viewport"
      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/style.css">
<script language="javascript" src="${pageContext.request.contextPath}/resources/script/jquery.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/resources/bootstrap/holder.js"></script>
<head>
    <title>导航栏</title>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="profile navbar-left">
            <ul class="nav navbar-nav">
                <c:choose>
                    <c:when test="${sessionScope.user!=null}">
                        <li class="dropdown user hidden-xs"><a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <img width="25" height="25"
                                 src="${pageContext.request.contextPath}/resources/images/admin/avatar-male.jpg"/></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/user/getUserMassage/${sessionScope.user.u_id}">
                                        <i class="icon-user"></i>修改我的资料</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/user/logout">
                                    <i class="icon-signout"></i>注销</a>
                                </li>
                            </ul>
                        </li>
                        <b class="navbar-brand"><big>${sessionScope.user.username}</big></b>
                    </c:when>
                    <c:otherwise>
                        <b class="navbar-brand">您未登录,请先</b>
                        <li><a href="${pageContext.request.contextPath}/user/save"><b><big>注册</big></b></a></li>
                        <li><a href="${pageContext.request.contextPath}/user/getLogin"><b><big>登录</big></b></a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/post/getPostList">
            <input type="text" placeholder="搜索" class="form-control" style="width: 400px" name="content">
            <button type="submit">
                <span class="glyphicon glyphicon-search"></span>
            </button>
        </form>
    </div>
</nav>

</body>
</html>
