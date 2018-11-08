<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 07.11.2018
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Hostel</title>
</head>
<body>
<form action = "/Hostel" method="post">
    <input required type="text" name="Name" placeholder="Название гостиницы">
    <input required type="text" name="Address" placeholder="Адрес">
    <input required type="text" name="Phone" placeholder="Телефон">
    <input required type="text" name="City" placeholder="Город">
    <input required type="hidden" name="EmployeeID" placeholder="ID Гостиницы">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
