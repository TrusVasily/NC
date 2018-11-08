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
    <title>Upadte Employee</title>
</head>
<body>
Редактировать сотрудника

<form action="/Employee/${param.EmployeeID}" method="post">
    <input type="hidden" name = "EmployeID" value="${param.EmployeeID}">
    <input type="text" name="FirstName" value="${param.FirstName}" placeholder=${param.FirstName}>
    <input type="text" name="LastName" value="${param.LastName}" placeholder=${param.LastName}>
    <input type="text" name="Address" value="${param.Address}" placeholder=${param.Address}>
    <input type="text" name="Phone" value="${param.Phone}" placeholder=${param.Phone}>

    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>
</body>
</html>
