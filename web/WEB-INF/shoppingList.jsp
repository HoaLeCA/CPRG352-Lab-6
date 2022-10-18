<%-- 
    Document   : shoppingList
    Created on : 13-Oct-2022, 8:02:51 PM
    Author     : levan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
    </head>
    <body>
        <h1>Shopping List</h1>
        
        
        
            <p>Hello, <c:out value="${username}"/>   <a href="ShoppingList?action=logout">Logout</a></p>
        
        <h2>List</h2>
        
        <form action="ShoppingList" method="post" >
            <div>
                <lable>Add item:</lable>
                <input type="text" name="item" value="">
                <input type="hidden" name="action" value="add">
            </div>
            <div>
                <input type="submit" value="Add">
            </div>
        </form>

        <form action="ShoppingList" method="post" >
            <div>
                <input type="hidden" name="action" value="delete">
                <ul>
                    <c:forEach items="${items}" var="item" >
                    <li>
                    <lable>
                        <input type="radio" name="item" value="<c:out value="${item}"/>" >
                        <c:out value="${item}" />
                         
                    </lable>
                    </li>
                   </c:forEach> 
                </ul>
                
            </div>
            <c:if test="${items.size() > 0}">
                  <div>
                      <input type="submit" value="Delete">
                 </div>
            </c:if>
          
        </form>
   
     
             <c:if test="${message != null}">
                     <p>${message}</p>
             </c:if>
              <c:if test="${info != null}">
                     <p>${info}</p>
             </c:if>        
        
        
    </body>
</html>
