<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 07.11.2018
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Room</title>
</head>
<body>
<form action = "/Room" method="post">
    <input required type="text" name="RoomType" placeholder="Тип комнаты">
    <input required type="text" name="RoomDescription" placeholder="Описание">
    <input required type="hidden" name="HotelID" placeholder="ID Гостиницы">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
