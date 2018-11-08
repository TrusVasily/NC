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
    <title>Add Booking</title>
</head>
<body>
<form action = "/Booking" method="post">
    <input required type="hidden" name="CustomerID" placeholder="ID Покупателя">
    <input required type="hidden" name="RoomID" placeholder="ID Комнаты">
    <input required type="hidden" name="BookingDate" placeholder="Дата регистрации">
    <input required type="hidden" name="DateIN" placeholder="Дата заселения">
    <input required type="hidden" name="DateOUT" placeholder="Дата выезда">
    <input required type="hidden" name="Bill" placeholder="Счет">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
