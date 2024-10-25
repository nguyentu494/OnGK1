<%@ page import="com.example.onthigk1.entities.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: TAMTU
  Date: 25/10/2024
  Time: 12:38 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%
    Candidate c = (Candidate) request.getAttribute("candidate");
%>
<head>
    <title>Title</title>
</head>
<body>
    <p>Cach 1:</p>
    <p> <%= c.toString() + c.getExperiences().toString() %></p>
    <p>Cach 2:</p>
    <p>Id: ${candidate.id}</p>
    <p>Name: ${candidate.fullName}</p>
    <p>Phone: ${candidate.phone}</p>
    <p>Email: ${candidate.email}</p>
    <c:forEach var="exp" items="${candidate.experiences}">
        <table border="1">
            <tr>
                <th>company</th>
                <th>work</th>
                <th>from date</th>
                <th>to date</th>
            </tr>
            <tr>
                <td>${exp.companyName}</td>
                <td>${exp.workDescription}</td>
                <td>${exp.fromDate}</td>
                <td>${exp.toDate}</td>
            </tr>
        </table>
    </c:forEach>
</body>
</html>
