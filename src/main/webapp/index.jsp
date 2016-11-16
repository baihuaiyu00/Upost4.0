<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Test page</title>
</head>
<body>
    <form method="post" action="user/login">
        stu_num:<input type="text" name="stu_num"><br/>
        <%--sex:<input type="text" name="sex"><br/>--%>
        <%--stu_phone:<input type="text" name="stu_phone"><br/>--%>
        <%--email:<input type="text" name="email"><br/>--%>
        stu_passwd:<input type="password" name="stu_passwd"><br/>
        <%--stu_name:<input type="text" name="stu_name"><br/>--%>
        <%--school_id:<input type="text" name="school_id"><br/>--%>
        <input type="submit" value="login"><br/>
    </form>
</body>
</html>
