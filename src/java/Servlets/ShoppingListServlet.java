/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author levan
 */
public class ShoppingListServlet extends HttpServlet {
    
    // set constant variable
    private final String USERNAME ="username";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get session object
        HttpSession  session = request.getSession();
         String action = request.getParameter("action");
         if(action != null && action.equals("logout")){
            session.invalidate();
            session = request.getSession();
             boolean logOutMessage = true;
            request.setAttribute("logOutMessage", logOutMessage);
            
         }
         
         String username = (String) session.getAttribute(USERNAME);
         System.out.print(username);
         if(username != null){
             getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
         }else{
             getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
         }
         return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //HttpSession session = request.getSession();
        String action = request.getParameter("action");
          // check action
        if(action == null || action.isEmpty()){
            request.setAttribute("message", "Missing action atribute");
            doGet(request,response);
            return;
        }
        if(request.getSession().getAttribute(USERNAME) == null && !action.equals("register")){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        int length = 0;
        // create ArrayList to store items
        ArrayList<String> items = ( ArrayList<String>)request.getSession().getAttribute("items");
        // create new ArrayList if don't have any items 
        if(items == null) items = new ArrayList<>();
        
        //using swich
        switch(action) {
            case "register":{
                String name = request.getParameter(USERNAME);
                if(name == null || name.equals("")){                
                   request.setAttribute("message", "Please input username before register");

                }else {
                    request.getSession().setAttribute(USERNAME, request.getParameter(USERNAME));
                }  
                break;
            }
            case "add":{
                String item = request.getParameter("item");
                if(item == null || item.trim().isEmpty()){
                    request.setAttribute("message", "Add item is not empty");
                }else{
                    items.add(item);
                    request.setAttribute("info", "Added item to list successfully");
                }
                break;
            }
  
            case "delete":{
                String deleteItem = request.getParameter("item");
                if(deleteItem == null || deleteItem.equals(" ")){
                    request.setAttribute("message", "Item need to be selected before delete");
                }else{
                    int deleted = 0;
                    for(int i = 0; i < items.size(); i++){
                    String item = items.get(i);
                    if(item.equals(deleteItem)){
                        items.remove(i);
                        //length = items.size();
                        request.setAttribute("items", items);
                        deleted++;
                        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                        return;
                        
                    }
                }
                    if(deleted>0){
                        request.setAttribute("info", "Deleted " + deleted+ " items in the list");
                    }else if(deleted == 0){
                        request.setAttribute("info", "No items are deleted");
                    }
                }
                break;
                
                
            }
                
        }
        
      

        request.getSession().setAttribute("items", items);
        request.setAttribute("items", items);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        

    }



}
