<!DOCTYPE html>

<html lang="en" xmlns:th="https://www.thymeleaf.org">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <title>Disaster relief </title>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Varela+Round&display=swap">
</head>
<style>
    body{
        background-color: lightslategray;
        font-family: 'Varela', sans-serif;
        font-size: 40px;
    }
    form{
        font-family: 'Varela', sans-serif;
        font-size: 30px;
        width: 100px;
        height: 100px;
    }
    div {
        width: 100px;
        height: 50px;
        transition: width 0.5s;
    }
    div:hover{
        border-radius: 10px;
        width: 320px;
        background-color: darkgray;
        transition-timing-function: ease-out;
    }
    .container {
        width: 300px;
        clear: both;
    }

    .container input {
        width: 25%;
        clear: both;
    }

    div1 {
        font-size: 30px;
        width: 400px;
        height: 50px;
        transition: width 0.5s;
    }
    div1:hover{
        width: 420px;
        background-color: darkgray;
        transition-timing-function: ease-out;
        border-radius: 10px;
    }
    /*.button_container {*/
    /*    width: 300px;*/
    /*    clear: both;*/
    /*}*/
    /*.button_container1 input {*/
    /*    width: 25%;*/
    /*    clear: both;*/
    /*}*/
</style>
<body>
Please login with your username, password, and account tier:
<div th:if="${param.error}">
    Invalid username and password.
</div>
<div th:if="${param.logout}">
    You have been logged out.
</div>
<form:form modelattribute="login" method="post">
    <div class="container"><label> User name: <form:input type="text" name="username" path="user"/> </label></div>
    <div class="container"><label> Password: <form:input type="password" name="password" path="pass"/> </label></div>
    <div1><label><input type="radio" id="administrator" name="account_type" value="administrator">Administrator</label></div1>
    <div1><label><input type="radio" id="donor" name="account_type" value="donor"> Donor</label></div1>
    <div1><label><input type="radio" id="recipient" name="account_type" value="recipient"> Recipient</label></div1>
    <input type="submit" value="Sign In"/>
</form:form>
</body>
</html>