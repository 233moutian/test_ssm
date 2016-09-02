<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/28
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <script language="javascript" src="${pageContext.request.contextPath}/resources/script/jquery.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/resources/lib/ckeditor/ckeditor.js"></script>
    <script type="text/javascript">
        $(function () {
            CKEDITOR.replace( 'content',{
                height :'200',
                width :' 1325',
                toolbar : [
                    [ 'Preview','Maximize','Print', 'Image'],
                    ['Cut', 'Copy', 'Paste', 'PasteText'],
                    ['Link', 'Unlink', 'Anchor'],

                    ['Bold', 'Italic', 'Underline', 'Strike', 'TextColor', 'BGColor'],

                    ['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
                    ['Styles', 'Format', 'Font', 'FontSize','LineHeight']
                ],
                filebrowserImageUploadUrl: "${pageContext.request.contextPath}/fileUpload"
            } );
        });
    </script>
</head>
<body>
<%--<c:set var="way" value="${requestScope.r_id==null?'add':'update'}"/>--%>
<!-- 数据判断:用于post的add  reply的add/update-->
<form action="${pageContext.request.contextPath}/${param.p_id != null ? 'reply/updateReply' : 'post/AddPost'}">
    <c:if test="${requestScope.p_id!=null&&requestScope.r_id!=null}">
        <input type="hidden" name="p_id" value="${param.p_id}">
        <input type="hidden" name="r_id" value="${param.r_id}">
        ${param.r_id}
        ${param.p_id}
    </c:if>
    <div style="text-align:center;">
    <textarea id="content" name="content" class="ckeditor">
        <c:if test="${param.content!=null}">
            ${param.content}
        </c:if>
    </textarea>
        </div>
    <input type="submit" value="提交">
</form>
</body>
</html>
