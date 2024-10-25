<%@ page import="java.util.List" %>
<%@ page import="com.example.onthigk1.entities.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: TAMTU
  Date: 25/10/2024
  Time: 10:14 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    List<Candidate> candidates = (List<Candidate>) request.getAttribute("listCan");
    System.out.println(candidates


    );
%>
<body>
<form action="controller?action=search" method="post">
    <input name="txtNV" type="text" >
    <input name="btnSearch" type="submit">
</form>
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

<% if(candidates != null){%>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Phone</td>
        <td>Email</td>
        <td></td>

    </tr>
    <% for (int i = 0; i < candidates.size() ; i++) {%>
    <tr>
        <td><%=candidates.get(i).getId()%></td>
        <td><%=candidates.get(i).getFullName()%></td>
        <td><%=candidates.get(i).getPhone()%></td>
        <td><%=candidates.get(i).getEmail()%></td>
        <td><a href="controller?action=candidate&id=<%=candidates.get(i).getId()%>">Detail</a></td>
    </tr>
    <%}%>
</table>
<% }%>
</body>
</html>
