<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 07.11.2018
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Room</title>
</head>
<body>

Вы действительно хотите удалить комнату ${param.RoomID}?

<form action="/Room/${param.RoomID}" method="post">
<input type="hidden" name="RoomID" value="${param.RoomID}">
<input type="hidden" name="_method" value="delete">
<input type="submit" value="Удалить">
</form>
</body>
</html>
