<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 07.11.2018
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Booking</title>
</head>
<body>
Редактировать заказ

<form action="/Booking/${param.BookingID}" method="post">
    <input type="hidden" name = "BookingID" value="${param.BookingID}">
    <input type="hidden" name="CustomerID" value="${param.CustomerID}" >
    <input type="hidden" name="RoomID" value="${param.RoomID}" >
    <input type="hidden" name = "BookingDate" value="${param.BookingDate}">
    <input type="hidden" name = "DateIN" value="${param.DateIN}">
    <input type="hidden" name = "DateOUT" value="${param.DateOUT}">
    <input type="hidden" name = "Bill" value="${param.Bill}">

    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>
</body>
</html>
