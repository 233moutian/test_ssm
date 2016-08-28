<%@ page contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
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
</head>
<body bgcolor="#afeeee">

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath}/resources/style/images/title_arrow.gif"/> @@@@@@
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <div id="PageHead"></div>
    <center>
        <%--<div class="ItemBlock_Title1" style="width: 98%;">--%>
        <%--<font class="MenuPoint"> &gt; </font>--%>
        <%--<a href="forumList.html">论坛</a>--%>
        <%--<font class="MenuPoint"> &gt; </font>--%>
        <%--销售常见问题--%>
        <%--<span style="margin-left:30px;"><a href="${pageContext.request.contextPath}/resources/BBS_Topic/saveUI.html">--%>
        <%--<img align="absmiddle" src="${pageContext.request.contextPath}/resources/style/blue/images/button/publishNewTopic.png"/></a>--%>
        <%--</span>--%>
        <%--</div>--%>

        <div class="ForumPageTableBorder">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <!--表头-->
                <tr align="center" valign="middle">
                    <td width="3" class="ForumPageTableTitleLeft">
                        <img border="0" width="1" height="1"
                             src="${pageContext.request.contextPath}/resources/style/images/blank.gif"/>
                    </td>
                    <td width="50" class="ForumPageTableTitle"><!--状态/图标-->&nbsp;</td>
                    <td class="ForumPageTableTitle">主题</td>
                    <td width="130" class="ForumPageTableTitle">作者</td>
                    <td width="100" class="ForumPageTableTitle">回复数</td>
                    <td width="130" class="ForumPageTableTitle">最后回复</td>
                    <td width="3" class="ForumPageTableTitleRight">
                        <img border="0" width="1" height="1"
                             src="${pageContext.request.contextPath}/resources/style/images/blank.gif"/>
                    </td>
                </tr>
                <tr height="1" class="ForumPageTableTitleLine">
                    <td colspan="8"></td>
                </tr>
                <tr height=3>
                    <td colspan=8></td>
                </tr>

                <!--主题列表-->
                <tbody class="dataContainer" datakey="topicList">

                <s: value="requestScope.postLiiteratorst" var="post">
                    <tr height="35" id="d0" class="template">
                        <td></td>
                        <td class="ForumTopicPageDataLine" align="center"><img
                                src="${pageContext.request.contextPath}/style/images/topicType_${0}.gif"/></td>
                        <td class="Topic">
                            <s:a cssClass="Default" action="topic_show?id=%{id}">${post.title}</s:a>
                        </td>
                        <td class="ForumTopicPageDataLine">
                            <ul class="ForumPageTopicUl">
                                <li class="Author">${post.p_author}</li>
                                    <%--<li class="CreateTime"><s:property value="post.postTime"/></li>--%>
                                <li class="CreateTime">${post.postTime}</li>
                            </ul>
                        </td><!-- fn取list的size()-->
                        <td class="ForumTopicPageDataLine Reply" align="center"><b>${fn:length(post.replies)}</b></td>
                        <td class="ForumTopicPageDataLine">
                            <ul class="ForumPageTopicUl">
                                <li class="Author">${post.lastReply.r_author}</li>
                                <li class="CreateTime">${post.lastReply.lastUpdateTime}</li>
                            </ul>
                        </td>
                        <td></td>
                    </tr>
                </s:iterator>

                </tbody>
                <!--主题列表结束-->

                <tr height="3">
                    <td colspan="9"></td>
                </tr>

            </table>

        </div>


        <pg:pager url="${pageContext.request.contextPath}/post/getAllPost" items="${fn:length(postList)}"
                  maxPageItems="20"
                  maxIndexPages="10" export="currentPageNumber=pageNumber">
            <pg:first>
                <a href="${pageUrl }">首页</a>
            </pg:first>
            <pg:prev>
                <a href="${pageUrl }">前页</a>
            </pg:prev>
            <pg:pages>
                <c:choose>
                    <c:when test="${currentPageNumber eq pageNumber}">
                        <font color="red">${pageNumber }</font>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageUrl }">${pageNumber }</a>
                    </c:otherwise>
                </c:choose>
            </pg:pages>
            <pg:next>
                <a href="${pageUrl }">下页</a>
            </pg:next>
            <pg:last>
                <a href="${pageUrl }">尾页</a>
            </pg:last>
        </pg:pager>


    </center>
</div>


</body>
</html>
