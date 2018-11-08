<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 07.11.2018
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Room Type</title>
</head>
<body>
<form action = "/RoomType" method="post">
    <input required type="text" name="RoomType" placeholder="Тип комнаты">
    <input required type="text" name="RoomName" placeholder="Имя Команты">
    <input required type="hidden" name="Price" placeholder="Цена">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
