<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/28
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script charset="utf-8" src="${pageContext.request.contextPath}/resources/lib/ckeditor/ckeditor.js"></script>
    <script type="text/javascript">CKEDITOR.replace('introduction')</script>
</head>
<body>
<form action="" name="">
    <textarea id="introduction" name="introduction" class="ckeditor">${}</textarea>
</form>
</body>
</html>
