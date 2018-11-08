<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 07.11.2018
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Hostel</title>
</head>
<body>

Вы действительно хотите удалить гостиницу ${param.HostID}?

<form action="/Hostel/${param.HostID}" method="post">
    <input type="hidden" name="HostID" value="${param.HostID}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Удалить">
</form>
</body>
</html>
