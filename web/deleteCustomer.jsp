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
    <title>Delete Customer</title>
</head>
<body>

Вы действительно хотите удалить наниматель ${param.CustomerID}?

<form action="/Customer/${param.CustomerID}" method="post">
    <input type="hidden" name="CustomerID" value="${param.CustomerID}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Удалить">
</form>
</body>
</html>
