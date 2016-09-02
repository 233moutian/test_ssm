<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${requestScope.post.title}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script language="javascript" src="${pageContext.request.contextPath}/resources/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/resources/script/pageCommon.js"
            charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/resources/script/PageUtils.js"
            charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/resources/script/DemoData.js"
            charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/resources/script/DataShowManager.js"
            charset="utf-8"></script>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/style/blue/pageCommon.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/blue/forum.css"/>

    <script language="javascript" src="${pageContext.request.contextPath}/resources/script/fckeditor/fckeditor.js"
            charset="utf-8"></script>
    <script type="text/javascript">
        $(function () {
            var fck = new FCKeditor("content");
            fck.Width = "90%";
            fck.ToolbarSet = "bbs";
            fck.BasePath = "${pageContext.request.contextPath}/resources/script/fckeditor/";
            fck.ReplaceTextarea();
        });
    </script>
</head>
<body>
<!-- 测试遍历 -->
<c:forEach items="${requestScope.replyList}" var="reply" varStatus="status">
    ${reply.r_author}<br>
    ${requestScope.post.title}<br>
    ${reply.content}<br>
    ${status.index+1}<br>
    <fmt:formatDate value="${reply.last_update_time}" type="BOTH"/>
</c:forEach>

<!-- 导航栏 会导致页面图片显示bug暂时取消-->
<%--<%@ include file="../top.jsp" %>--%>
<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath}/resources/style/images/title_arrow.gif"/> 查看主题
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--内容显示-->
<div id="MainArea">
    <div id="PageHead"></div>
    <center>
        <div class="ItemBlock_Title1" style="width: 98%">
            帖子阅读
			<span style="margin-left:30px;"><a href="save.jsp?XXXX">
				<img align="absmiddle"
                     src="${pageContext.request.contextPath}/resources/style/blue/images/button/publishNewTopic.png"/></a>
			</span>
        </div>

        <div class="ForumPageTableBorder dataContainer" datakey="replyList">

            <!--显示主题标题等-->
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr valign="bottom">
                    <td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
                    <td class="ForumPageTableTitle"><b>${requestScope.post.title}</b></td>
                    <td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
                </tr>
                <tr height="1" class="ForumPageTableTitleLine">
                    <td colspan="4"></td>
                </tr>
            </table>

            <c:forEach items="${requestScope.replyList}" var="reply" varStatus="status">
                <!-- ~~~~~~~~~~~~~~~ 显示回复列表 ~~~~~~~~~~~~~~~ -->
                <div class="ListArea template">
                    <table border="0" cellpadding="0" cellspacing="1" width="100%">
                        <tr>
                            <td rowspan="3" width="130" class="PhotoArea" align="center" valign="top">
                                <!--作者头像-->
                                <div class="AuthorPhoto">
                                    <img border="0" width="110" height="110"
                                         src="${pageContext.request.contextPath}/resources/style/images/defaultAvatar.gif"
                                         onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/resources/style/images/defaultAvatar.gif';"/>
                                </div>
                                <!--作者名称-->
                                <div class="AuthorName">${reply.r_author}</div>
                            </td>
                            <td align="center">
                                <ul class="TopicFunc">
                                    <!--操作列表-->
                                    <li class="TopicFuncLi">
                                        <a class="detail"
                                           href="${pageContext.request.contextPath}/reply/getSaveJsp?p_id=${requestScope.post.p_id}&r_id=${reply.r_id}&content=${reply.content}"><img
                                                border="0"
                                                src="${pageContext.request.contextPath}/resources/style/images/edit.gif"/>编辑</a>
                                        <a class="detail"
                                           href="${pageContext.request.contextPath}/reply/deleteReply?p_id=${requestScope.post.p_id}&r_id=${reply.r_id}"
                                           onClick="return confirm('确定要删除回复吗？')"><img border="0"
                                                                                      src="${pageContext.request.contextPath}/resources/style/images/delete.gif"/>删除</a>
                                    </li>
                                    <!-- 文章表情与标题 -->
                                    <li class="TopicSubject">
                                            ${requestScope.post.title}
                                    </li>
                                </ul>
                            </td>
                        </tr>
                        <tr><!-- 文章内容 -->
                            <td valign="top" align="center">
                                <div class="Content">${reply.content}</div>
                            </td>
                        </tr>
                        <tr><!--显示楼层等信息-->
                            <td class="Footer" height="28" align="center" valign="bottom">
                                <ul style="margin: 0px; width: 98%;">
                                    <li style="float: left; line-height:18px;"><font
                                            color=#C30000>[${status.index+1}楼]</font>
                                        <fmt:formatDate value="${reply.last_update_time}" type="BOTH"/>
                                    </li>
                                    <li style="float: right;"><a href="javascript:scroll(0,0)">
                                        <img border="0"
                                             src="${pageContext.request.contextPath}/resources/style/images/top.gif"/></a>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </table>
                </div>
            </c:forEach>

            <!-- ~~~~~~~~~~~~~~~ 显示回复列表结束 ~~~~~~~~~~~~~~~ -->
        </div>

        <!-- 封装通用的分页jsp -->
        <jsp:include page="page.jsp">
            <jsp:param value="${pageContext.request.contextPath}/reply/getReply" name="url"/>
            <jsp:param value="${requestScope.count}" name="count"/>
        </jsp:include>

        <div class="ForumPageTableBorder" style="margin-top: 25px;">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr valign="bottom">
                    <td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
                    <td class="ForumPageTableTitle"><b>快速回复</b></td>
                    <td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
                </tr>
                <tr height="1" class="ForumPageTableTitleLine">
                    <td colspan="3"></td>
                </tr>
            </table>
        </div>
    </center>
    <!--快速回复-->
    <div class="QuictReply">
        <form action="${pageContext.request.contextPath}/reply/addReply">

            <input type="hidden" name="p_id" value="${requestScope.post.p_id}">

            <div style="padding-left: 3px;">
                <table border="0" cellspacing="1" width="98%" cellpadding="5" class="TableStyle">
                    <tr class="Tint" height="200">
                        <td valign="top" rowspan="2" class="Deep"><b>内容</b></td>
                        <td valign="top" class="no_color_bg">
                            <textarea name="content" style="width: 95%; height: 300px"></textarea>
                        </td>
                    </tr>
                    <tr height="30" class="Tint">
                        <td class="no_color_bg" colspan="2" align="center">
                            <input type="image"
                                   src="${pageContext.request.contextPath}/resources/style/blue/images/button/submit.PNG"
                                   style="margin-right:15px;"/>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </div>
</div>


</body>
</html>
