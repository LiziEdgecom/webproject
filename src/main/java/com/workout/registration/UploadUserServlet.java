package com.workout.registration;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "uploadUser", value = "/uploadUser")
public class UploadUserServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession sessionHTTP = request.getSession();


        RequestDispatcher dispatcher = null;
        String name = request.getParameter("name");
        String email = (String) sessionHTTP.getAttribute("email");
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        if (name != null && !name.isEmpty() ) {

            try {
//


                UserController userController = new UserController();

                int rows = userController.UploadUser(name, email, weight, height);
                sessionHTTP.setAttribute("status","yes");
                sessionHTTP.setAttribute("name",name);


                if (rows > 0) {

                    response.sendRedirect("getUser");
                } else {

                    response.sendRedirect("getUser");
                }
                dispatcher.forward(request, response);
            }catch (Exception ee){
                System.out.println(ee);
            }
        }else{

            request.setAttribute("status", "failed");
            response.sendRedirect("getUser");

        }
    }


}
