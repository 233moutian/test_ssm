<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <script language="javascript" src="${pageContext.request.contextPath}/resources/script/jquery.js"></script>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/style/blue/pageCommon.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/blue/forum.css"/>
</head>
<!-- 导航栏 -->
<%@ include file="../top.jsp" %>
<br>
<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13"
                 src="${pageContext.request.contextPath}/resources/style/images/title_arrow.gif"/> BBS论坛系统
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<div id="MainArea" align="center">
    <div id="PageHead"></div>
    <div class="ForumPageTableBorder">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <!--表头-->
            <tr align="center" valign="middle">
                <td width="3" class="ForumPageTableTitleLeft">
                    <img border="0" width="1" height="1"
                         src="${pageContext.request.contextPath}/resources/style/images/blank.gif"/>
                </td>
                <td width="80" class="ForumPageTableTitle"><!--状态/图标-->&nbsp;</td>
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
            <c:forEach items="${requestScope.postList}" var="post">
            <tr height="40" id="d0" class="template">
                <td></td>
                <td class="ForumTopicPageDataLine" align="center"><img
                        src="${pageContext.request.contextPath}/resources/style/images/topicType_0.gif"/></td>
                <td class="Topic">
                    <div style="text-align:center;">
                        <a cssClass="Default"
                           href="${pageContext.request.contextPath}/reply/getReply?p_id=${post.p_id}"><b>${post.title}</b></a>
                    </div>
                </td>
                <td class="ForumTopicPageDataLine">
                    <ul class="ForumPageTopicUl">
                        <li class="Author"><b>${post.p_author}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></li>
                        <li class="CreateTime"><fmt:formatDate value="${post.post_time}" type="both"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    </ul>
                </td>
                <td class="ForumTopicPageDataLine Reply" align="center"><b>${fn:length(post.replies)}</b></td>
                <td class="ForumTopicPageDataLine">
                    <ul class="ForumPageTopicUl">
                        <c:if test="${fn:length(post.replies) < 1}">
                            <li class="Author">
                                暂无回复&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </li>
                        </c:if>
                        <c:forEach items="${post.replies}" var="reply" varStatus="status">
                            <c:if test="${status.last}">
                                <li class="Author">
                                        ${reply.r_author}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </li>
                                <li class="CreateTime">
                                    <c:if test="${status.last}">
                                        <fmt:formatDate value="${reply.last_update_time}" type="time"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </c:if>
                                </li>
                            </c:if>
                        </c:forEach>
                        </c:forEach>
                    </ul>
                </td>
                <td></td>
            </tr>
            </tbody>
            <!--主题列表结束-->
            <tr height="3">
                <td colspan="9"></td>
            </tr>
        </table>
    </div>
</div>
<!-- 封装通用的分页jsp -->
<jsp:include page="page.jsp">
    <jsp:param value="${pageContext.request.contextPath}/post/getAllPost" name="url"/>
    <jsp:param value="${requestScope.count}" name="count"/>
</jsp:include>

<%@ include file="save.jsp" %>
</body>
</html>
