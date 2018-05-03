<%--
  Created by IntelliJ IDEA.
  User: deepanker
  Date: 9/4/18
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/login" var="login" />
<head>
    <title>Login V9</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/static/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
<%--    <link rel="stylesheet" type="text/css" href="/static/css/util.css">
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">--%>
    <!--===============================================================================================-->
</head>
<body class="security-app">


<%--<div class="container-login100" style="background-image: url('/static/images/bg-01.jpg');">--%>
<div class="container-login100">
    <div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30">
        <form class="login100-form validate-form" action="/index" method="post">
				<span class="login100-form-title p-b-37">
					Sign In
				</span>

            <div class="wrap-input100 validate-input m-b-20" data-validate="Enter username or email">
                <input class="input100" type="text" name="username" placeholder="username or email">
                <span class="focus-input100"></span>
            </div>

            <div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
                <input class="input100" type="password" name="password" placeholder="password">
                <span class="focus-input100"></span>
            </div>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />

            <div class="container-login100-form-btn">
                <button type="submit" class="login100-form-btn">
                    Sign In
                </button>
            </div>

            <div class="text-center p-t-57 p-b-20">
					<span class="txt1">
						Or login with
					</span>
            </div>

            <div class="flex-c p-b-112">
                <a href="#" class="login100-social-item">
                    <i class="fa fa-facebook-f"></i>
                </a>

                <a href="#" class="login100-social-item">
                    <img src="/static/images/icons/icon-google.png" alt="GOOGLE">
                </a>
            </div>

            <div class="text-center">
                <a href="#" class="txt2 hov1">
                    Sign Up
                </a>
            </div>
        </form>


    </div>
</div>



<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="/static/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="/static/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="/static/vendor/bootstrap/js/popper.js"></script>
<script src="/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="/static/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="/static/vendor/daterangepicker/moment.min.js"></script>
<script src="/static/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="/static/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="/static/js/main.js"></script>

</body>
</html>