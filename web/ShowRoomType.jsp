<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 07.11.2018
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>Show Room Type</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<table border="2">
    <tr>
        <td>RoomType</td>
        <td>RoomName</td>
        <td>Price</td>
    </tr>
    <c:forEach items="${room}" var = "room">
        <tr>
            <td>${room.getRoomType()}</td>
            <td>${room.getRoomName()}</td>
            <td>${room.getPrice()}</td>
            <form action = "updateRoomType.jsp" method="post">
                <input type="hidden" name="RoomType" value="${room.getRoomType()}">
                <input type="hidden" name="RoomName" value="${room.getRoomName()}">
                <input type="hidden" name="Price" value="${room.getPrice()}">

                <input type="submit" value="Изменить" style="float:left">
            </form>
            <form action="deleteRoomType.jsp" method="post">
                <input type="hidden" name="RoomType" value="${room.getRoomType}">
                <input type="submit" value="Удалить" style="float:left">
            </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "addRoomType.jsp">
    <input type="submit" value="Добавить новый тип комнаты">
</form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
