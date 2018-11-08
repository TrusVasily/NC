<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 07.11.2018
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upadate Room</title>
</head>
<body>
Редактировать комнату

<form action="/Room/${param.RoomID}" method="post">
    <input type="hidden" name = "RoomID" value="${param.RoomID}">
    <input type="text" name="RoomType" value="${param.RoomType}" placeholder=${param.RoomType}>
    <input type="text" name="RoomDescription" value="${param.RoomDescription}" placeholder=${param.RoomDescription}>
    <input type="hidden" name = "HotelID" value="${param.HotelID}">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>
</body>
</html>
