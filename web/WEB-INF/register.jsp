<%-- 
    Document   : register
    Created on : 13-Oct-2022, 8:01:59 PM
    Author     : levan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="Post">
              <div>
                   <label>Username:</label>
                   <input type="text" name="username" value="">
             </div>
            
             <div>
                  <input type="submit" value="Register Name">
                  <input type="hidden" name="action" value="register" >
             </div>
        </form>
        
        <c:if test="${message != null}">
                     <p>${message}</p>
        </c:if>
        <c:if test="${info != null}">
                     <p>${info}</p>
        </c:if>
        <c:if test="${logOutMessage == true}">
                     <p>You have successfully logged out!</p>
        </c:if>
                
        
    </body>
</html>
