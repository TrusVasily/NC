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
    <title>Delete Employee</title>
</head>
<body>

Вы действительно хотите удалить сотрудника ${param.Employee}?

<form action="/Employee/${param.EmployeeID}" method="post">
    <input type="hidden" name="EmployeeID" value="${param.EmployeeID}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Удалить">
</form>
</body>
</html>
