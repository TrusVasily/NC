<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 07.11.2018
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Hostel</title>
</head>
<body>
Редактировать гостиницу

<form action="/Hostel/${param.HostID}" method="post">
    <input type="hidden" name = "HostID" value="${param.HostID}">
    <input type="text" name="Name" value="${param.Name}" placeholder=${param.Name}>
    <input type="text" name="Address" value="${param.Address}" placeholder=${param.Address}>
    <input type="text" name = "Phone" value="${param.Phone}" placeholder=${param.Phone}>
    <input type="text" name="City" value="${param.City}" placeholder=${param.Address}>

    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>
</body>
</html>
