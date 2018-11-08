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
    <title>Update Room Type</title>
</head>
<body>
Редактировать тип комнаты

<form action="/RoomType/${param.RoomID}" method="post">
    <input type="text" name = "RoomType" value="${param.RoomType}" placeholder=${param.RoomType}>
    <input type="text" name="RoomName" value="${param.RoomName}" placeholder=${param.RoomName}>
    <input type="hidden" name="Price" value="${param.Price}" >
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>
</body>
</html>
