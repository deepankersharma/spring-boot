<%--
  Created by IntelliJ IDEA.
  User: deepanker
  Date: 4/4/18
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <!-- Latest compiled and minified CSS -->
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>

    <!-- Optional theme -->
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>



<div class="col-md-12">
    <a href="<c:url value="/logout" />">Logout</a>
    <a href="<c:url value="/show" />">Create Records</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${persons}" var="person" >
            <tr>
                <th scope="row">${person.id}</th>
                <td>${person.fname}</td>
                <td>${person.lname}</td>
                <td>${person.address}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script
        src="https://code.jquery.com/jquery-1.7.2.min.js"
        integrity="sha256-R7aNzoy2gFrVs+pNJ6+SokH04ppcEqJ0yFLkNGoFALQ="
        crossorigin="anonymous"></script>
<script src="/static/js/jquery.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>
</body>
</html>
