<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h2>
        <h4>Hello, ${username} <a href="ShoppingList?action=logout">Logout</a></h4>
        <br>
        <h3>List</h3>

        <form method="POST" action="ShoppingList">
            <h5>Add Item:</h5>
            <input type="text" name="abox" value="" required>
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
            <br>
        </form>
        
        <br>
        
        <form method="POST" action="ShoppingList">
            <table>
                <c:forEach var="listItem" items="${shoppingList}">
                    <tr>
                        <td><input type="radio" name="listRadios" value="${listItem}"> ${listItem}</td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>

</body>
</html>
