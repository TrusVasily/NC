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
    <title>Add Customer</title>
</head>
<body>
<form action = "/Customer" method="post">

    <input required type="text" name="FirstName" placeholder="Имя">
    <input required type="text" name="LastName" placeholder="Фамилия">
    <input required type="text" name="Address" placeholder="Адрес">
    <input required type="text" name="Phone" placeholder="Телефон">
    <input required type="text" name="Passport" placeholder="Паспорт">

    <input type="submit" value="Сохранить">
</form>
</body>
</html>
