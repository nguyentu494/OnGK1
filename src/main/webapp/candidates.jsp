<%@ page import="com.example.onthigk1.entities.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: TAMTU
  Date: 25/10/2024
  Time: 12:21 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<% List<Candidate> listCan = (List<Candidate>) request.getAttribute("listNV"); %>
<head>
    <title>Title</title>
</head>
<body>
<a href="controller?action=add">Add candidate</a>
<p>Cach 1: </p>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Phone</td>
            <td>Email</td>
            <td></td>

        </tr>
        <c:forEach var="can" items="${listNV}">
            <tr>
                <td>${can.id}</td>
                <td>${can.fullName}</td>
                <td>${can.phone}</td>
                <td>${can.email}</td>
                <td><a href="controller?action=candidate&id=${can.id}">Detail</a></td>
            </tr>
        </c:forEach>
    </table>
<p>Cach 2: </p>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Phone</td>
        <td>Email</td>
        <td></td>

    </tr>
   <% for (int i = 0; i < listCan.size() ; i++) {%>
        <tr>
            <td><%=listCan.get(i).getId()%></td>
            <td><%=listCan.get(i).getFullName()%></td>
            <td><%=listCan.get(i).getPhone()%></td>
            <td><%=listCan.get(i).getEmail()%></td>
            <td><a href="controller?action=candidate&id=<%=listCan.get(i).getId()%>">Detail</a></td>
            <td><a href="controller?action=delete&id=<%=listCan.get(i).getId()%>">Delete</a></td>

        </tr>
    <%}%>
</table>
</body>
</html>
