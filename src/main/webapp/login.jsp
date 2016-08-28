<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
<HEAD>
	<TITLE>请先登录</TITLE>
	<LINK HREF="${pageContext.request.contextPath}/resources/style/blue/login.css" type=text/css rel=stylesheet />
</HEAD>

<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
<FORM METHOD="post" NAME="actForm" ACTION="${pageContext.request.contextPath}/user/login">
    <DIV ID="CenterAreaBg">
        <DIV ID="CenterArea">
            <DIV ID="LogoImg">BBS</DIV>
            <DIV ID="LoginInfo">
                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                    <TR>
                        <TD width=45 CLASS="Subject"><IMG BORDER="0" SRC="${pageContext.request.contextPath}/resources/style/blue/images/login/userId.gif" /></TD>
                        <TD><INPUT SIZE="20" CLASS="TextField" TYPE="text" NAME="username" placeholder="请输入帐号"/></TD>
                        <TD STYLE="padding-left:10px;"><INPUT TYPE="image" SRC="${pageContext.request.contextPath}/resources/style/blue/images/login/siagup.png"/></TD>

                    </TR>
                    <TR>
                        <TD CLASS="Subject"><IMG BORDER="0" SRC="${pageContext.request.contextPath}/resources/style/blue/images/login/password.gif" /></TD>
                        <TD><INPUT SIZE="20" CLASS="TextField" TYPE="password" NAME="password" placeholder="请输入密码"/></TD>
                    </TR>
                </TABLE>
            </DIV>
        </DIV>
    </DIV>
</FORM>
</BODY>

</HTML>

