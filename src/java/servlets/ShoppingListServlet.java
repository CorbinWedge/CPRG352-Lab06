package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //create a session
        HttpSession userSession = request.getSession();

        //gets the users input for username and assigns it an attribute
        String username = (String) userSession.getAttribute("username");
        String operation = request.getParameter("action");

        if (username == null || username.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        } else if (username != null && !username.equals("")) {
            if (operation != null && operation.equals("logout")) {
                userSession.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //create a session
        HttpSession userSession = request.getSession();

        String operation = request.getParameter("action");

        if (operation != null && operation.equals("register")) {

            //gets the users input for username and assigns it an attribute
            String username = request.getParameter("ubox");

            //creates new array list for our shopping list
            ArrayList<String> shoppingList = new ArrayList<>();

            //sets the username and list as attributes of our session
            userSession.setAttribute("shoppingList", shoppingList);
            userSession.setAttribute("username", username);

            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            return;
        } else if (operation != null && operation.equals("add")) {

            String listItem = request.getParameter("abox");
            request.setAttribute("listItem", listItem);
            ArrayList<String> shoppingList = (ArrayList<String>) userSession.getAttribute("shoppingList");

            if (shoppingList.isEmpty() == true) {
                shoppingList.add(0, listItem);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                return;
            } else {
                shoppingList.add(shoppingList.size(), listItem);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                return;
            }
        } else if (operation != null && operation.equals("delete")) {
                    
            String selectedRadio = request.getParameter("listRadios");
            
            ArrayList<String> shoppingList = (ArrayList<String>) userSession.getAttribute("shoppingList");
            shoppingList.remove(selectedRadio);
            userSession.setAttribute("shoppingList", shoppingList);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
            return;
        }

    }
}
