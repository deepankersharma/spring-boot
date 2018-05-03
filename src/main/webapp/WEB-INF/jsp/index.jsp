<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="description" content="Free Web tutorials">
    <meta name="keywords" content="HTML,CSS,XML,JavaScript">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container" style="margin-top: 100px;">
<p>The meta elements of this document describe the document and its keywords.</p>

<form:form action="/savePerson" method="post" modelAttribute="person">
    <div class="form-group">
        <label for="fname">First Name:</label>
        <form:input type="text" path="fname" name="fname" class="form-control" id="fname"/>
    </div>
    <div class="form-group">
        <label for="lanme">Last Name:</label>
        <form:input type="text" path="lname" class="form-control" name="lname" id="lanme"/>
    </div>
    <div class="form-group">
        <label for="address">Address:</label>
        <form:input type="address" path="address" class="form-control" name="address" id="address"/>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form:form>
    <a href="/getAll">Get All list</a>
    <a href="#" onclick="callAjax()">Get All list ajax</a>



    <div id="addressMank">

    </div>

    <a href="<c:url value="/logout" />">Logout</a>


</div>




<script src="/static/js/jquery.js"></script>
<script src="/static/js/bootstrap.min.js"></script>

<script type="text/javascript">
    function callAjax() {
        $.ajax({
            url:  '/getResult',
            type: 'GET',
            data: {id: "10"},
            success: function(html){
                $("#addressMank").html(html);
            },
            error: function(){
                alert("error");
            }
        });
    }

</script>

</body>
</html>
