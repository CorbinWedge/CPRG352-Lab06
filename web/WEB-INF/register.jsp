<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
    <h1>Shopping List</h1>
    <form method="POST" action="ShoppingList">
        <h4>Username:</h4>
        <input type="text" name="ubox" value="" required>
        <input type="submit" value="Register Name">
        <input type="hidden" name="action" value="register">
    </form>
    </body>
</html>