<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户注册</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/jquery.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/script/jquary.validate/jquery.validate.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/script/jquary.validate/localization/messages_zh.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/jsAddress.js"></script>
    <script type="text/javascript">
        $(function () {
            $(":input[name='username']").change(function () {
                var val = $(this).val();
                val = $.trim(val);
                if (val != "") {
                    $.ajax({
                        url: "${pageContext.request.contextPath}/user/checkIsExist",
                        data: {"username": val},
                        type: "post",
                        cache: false,
                        dataType: "json",
                        error: function () {
                            alert("出错了！！:");
                        },
                        success: function (data) {
                            alert("success:");
                            $("#username").html(data);
                        }
                    })
                }
            });

            $("#commentForm").validate({

                rules: {
                    username: {
                        required: true,
                        minlength: 6,
                        maxlength: 10,
                        number: true
                    },
                    password: {
                        required: true,
                        minlength: 6,
                        maxlength: 10,
                        number: true
                    },
                    againPassword: {
                        required: true,
                        equalTo: "#password",
                        number: true
                    },
                    gender: "required",
                    phonenumber: {
                        required: true,
                        minlength: 11,
                        maxlength: 11,
                        number: true,
                        min: 10000000000
                    },
                    email: {
                        required: true,
                        minlength: 6,
                        maxlength: 18,
                        email: true
                    }
                },
                messages: {
                    username: {
                        required: "请填写您的用户名",
                        minlength: "请正确填写你的用户名,不能小于6位",
                        maxlength: "请正确填写你的用户名,不能大于10位",
                        number: "请填写数字"
                    },
                    password: {
                        required: "请填写你的密码",
                        minlength: "密码长度不得小于6位",
                        maxlength: "密码长度不得大于10位",
                        number: "请填写数字"
                    },
                    aginPassword: {
                        required: "请再次输入密码",
                        equalTo: "请再次输入密码",
                        number: "请填写数字"
                    },
                    gender: "请填写你的性别",
                    gender: "请填写你的性别",
                    phonenumber: {
                        required: "请填写手机号码",
                        minlength: "手机号码的长度必须为11位",
                        maxlength: "手机号码的长度必须为11位",
                        number: "请正确填写数字",
                        min: "请正确填写号码格式"
                    },
                    email: {
                        required: "请填写邮箱",
                        minlength: "邮箱长度不得小于6位",
                        maxlength: "邮箱长度不得大于18位",
                        email: "请正确输入邮箱地址"
                    }
                }
            });
        })


    </script>
</head>
<body>
<center>
    <form action="${pageContext.request.contextPath}/user/signup" id="commentForm" method="post">
        <table border="1" width="75%" height="550" bgcolor="#F9F9F9" cellspacing="0" cellpadding="0"
               bordercolor="lightgrey"
               bordercolorlight="lightgrey" bordercolordark="white" rules="none">

            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;■ 用户注册</td>
            </tr>
            <tr>
                <td align="right" width="35%">用 户 名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td colspan="3"><input type="text" id="username" name="username" size="30" value="${user.username}">
                </td>
                <td id="usernamemessage">${requestScope.message}</td>
            </tr>
            <tr>
                <td align="right">用户密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td colspan="4"><input type="password" id="password" name="password" size="30"
                                       value="${requestScopepassword}"/></td>
            </tr>
            <tr>
                <td align="right">确认密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td colspan="3"><input type="password" name="againPassword" id="againPassword" size="30"
                                       value="${user.username}"/></td>
                <td id="message"></td>
            </tr>
            <tr>
                <td align="right">用户性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>
                    <input type="radio" id="male" name="gender" value="男" <c:if test="${user.gender=='男'}">
                        checked="checked"
                    </c:if>/>男
                    <input type="radio" id="female" name="gender" value="女" <c:if test="${user.gender=='女'}">
                        checked="checked"
                    </c:if>/>女
                </td>
            </tr>
            <tr>
                <td align="right">联系电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td colspan="4"><input type="text" name="phonenumber" id="phonenumber" size="30"
                                       value="${user.phonenumber}"/></td>
            </tr>
            <tr>
                <td align="right">E-mail：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td colspan="4">
                    <input type="text" id="email" name="email" size="30"/>
                </td>
            </tr>
            <tr>
                <td align="right">&nbsp;&nbsp;省：&nbsp;&nbsp;<select id="cmbProvince" name="area"></select></td>
                <td align="center">&nbsp;&nbsp;市：&nbsp;&nbsp;<select id="cmbCity" name="area"></select></td>
                <td align="left">&nbsp;&nbsp;区：&nbsp;&nbsp;<select id="cmbArea" name="area"></select></td>
                <script type="text/javascript">
                    addressInit('cmbProvince', 'cmbCity', 'cmbArea', '广东', '佛山市', '南海区');
                </script>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td colspan="4">
                    <input type="submit" name="button" id="button" value="确定注册">
                    <input type="reset" name="reset" value="重置信息"/>
                </td>
            </tr>
        </table>
    </form>
</center>
<br>
</body>
</html>