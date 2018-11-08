<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 07.11.2018
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Booking</title>
</head>
<body>

Вы действительно хотите удалить запись ${param.BookingID}?

<form action="/Booking/${param.BookingID}" method="post">
    <input type="hidden" name="BookingiD" value="${param.BookingID}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Удалить">
</form>
</body>
</html>
