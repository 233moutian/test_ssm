<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<form action="${pageContext.request.contextPath}/fileUpload" method="post" enctype="multipart/form-data">
    <input name="userid" type="hidden" value="${sessionScope.user.username}">
    <input type="file" name="upload">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" name="button" id="button" value="确定" >
</form>
${result.msg}



</body>
</html>