<%--<!DOCTYPE html>--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"--%>
<%--      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">--%>
<%--<head>--%>
<%--    <title>Disaster Relief </title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div th:if="${param.error}">--%>
<%--    Invalid username and password.--%>
<%--</div>--%>
<%--<div th:if="${param.logout}">--%>
<%--    You have been logged out.--%>
<%--</div>--%>
<%--&lt;%&ndash;<form th:action="@{/login.html}" method="post" modelattribute="login">&ndash;%&gt;--%>
<%--<form th:action="authenticate" method="post">--%>
<%--    <!--<form method="post" modelAttribute="Login">-->--%>
<%--    <label> User Name : <input type="text" name="username" value="username"/> </label></div>--%>
<%--    <label> Password: <input type="password" name="password" value="password"/> </label></div>--%>
<%--    <input type="radio" id="administrator" name="account_type" value="administrator">--%>
<%--    <label for="administrator">Administrator</label><br>--%>
<%--    <input type="radio" id="donor" name="account_type" value="donor">--%>
<%--    <label for="donor">Donor</label><br>--%>
<%--    <input type="radio" id="recipient" name="account_type" value="recipient">--%>
<%--    <label for="recipient">Recipient</label>--%>
<%--    <div><input type="submit" value="Sign In"/></div>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>

<html xmlns = "http://www.w3.org/1999/xhtml" xmlns:th = "http://www.thymeleaf.org"
      xmlns:sec = "http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
    <title>Spring Security Example </title>
</head>
<body>
<div th:if = "${param.error}">
    Invalid username and password.
</div>
<div th:if = "${param.logout}">
    You have been logged out.
</div>

<form th:action = "@{/login}" method = "post">
    <div>
        <label> User Name : <input type = "text" name = "username"/> </label>
    </div>
    <div>
        <label> Password: <input type = "password" name = "password"/> </label>
    </div>
    <div>
        <input type = "submit" value = "Sign In"/>
    </div>
</form>

</body>
</html>