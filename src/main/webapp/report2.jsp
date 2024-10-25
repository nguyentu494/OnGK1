<%--
  Created by IntelliJ IDEA.
  User: TAMTU
  Date: 25/10/2024
  Time: 11:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty listCan}">
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Phone</td>
            <td>Email</td>
            <td></td>

        </tr>
        <c:forEach var="can" items="${listCan}">
            <tr>
                <td>${can.id}</td>
                <td>${can.fullName}</td>
                <td>${can.phone}</td>
                <td>${can.email}</td>
                <td><a href="controller?action=candidate&id=${can.id}">Detail</a></td>
            </tr>
        </c:forEach>
    </table>

</c:if>
<c:if test="${empty listCan}">
    <p>Khong co candidate > 5 nam kinh nghiem</p>
</c:if>
</body>
</html>
