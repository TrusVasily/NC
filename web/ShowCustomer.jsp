<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NotePad.by
  Date: 07.11.2018
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Show Customer</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<table border="2">
    <tr>
        <td>CustomerID</td>
        <td>FirstName</td>
        <td>LastName</td>
        <td>Address</td>
        <td>Phone</td>
        <td>Passport</td>

    </tr>
    <c:forEach items="${list}" var = "list">
        <tr>
            <td>${list.getCustomerID()}</td>
            <td>${list.getFirstName()}</td>
            <td>${list.getLastName()}</td>
            <td>${list.getAddress()}</td>
            <td>${list.getPhone()}</td>
            <td>${list.getPassport()}</td>


            <form action = "updateCustomer.jsp" method="post">
                <input type="hidden" name="CustomerID" value="${list.getCustomerID()}">
                <input type="hidden" name="FirstName" value="${list.getFirstName()}">
                <input type="hidden" name="LastName" value="${list.getLastName()}">
                <input type="hidden" name="Address" value="${list.getAddress()}">
                <input type="hidden" name="Phone" value="${list.getPhone()}">
                <input type="hidden" name="Passport" value="${list.getPassport()}">


                <input type="submit" value="Изменить" style="float:left">
            </form>
            <form action="deleteCustomer.jsp" method="post">
                <input type="hidden" name="CustomerID" value="${list.getCustomerID}">
                <input type="submit" value="Удалить" style="float:left">
            </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "addEmployee.jsp">
    <input type="submit" value="Добавить нового нанимателя">
</form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
