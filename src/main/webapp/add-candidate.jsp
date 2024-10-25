<%@ page import="com.example.onthigk1.enums.Roles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TAMTU
  Date: 25/10/2024
  Time: 12:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
    <form action="controller?action=add" method="post">
        <p>Email: <input name="txtEmail" type="email" value="maomao@gmail.com"></p>
        <p>Phone: <input name="txtPhone" value="0522206965"></p>
        <p>Name: <input name="txtName" value="wjbu prime"></p>
        <p>Experience: </p>
        <p>From date: <input name="txtFrom" type="date"></p>
        <p>To date: <input name="txtTo" type="date"></p>
        <p>Work description: <input name="txtDes" value="an o khong"></p>
        <p>Company name: <input name="txtCompany" value="family"></p>
        <p>roles: <select name="inputRole">
                        <c:forEach var="role" items="${roles}">
                            <option value="${role.key}">${role.value}</option>
                        </c:forEach>
                    </select>
        </p>
        <input type="submit" value="Add">
    </form>
</body>
</html>
