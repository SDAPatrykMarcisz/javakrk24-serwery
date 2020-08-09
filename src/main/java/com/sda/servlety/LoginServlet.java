package com.sda.servlety;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        //jezeli sie udalo, przekieruj na login-success, jezeli nie, przekieruj na strone do logowania
        //(opcjonalnie z informacja ze nie udalo sie zalogowac)
        boolean loginResult = service.verifyUser(login, password);
        if(loginResult){
            resp.sendRedirect("login-success.jsp");
        } else {
            resp.sendRedirect("login-page.jsp");
        }

    }

    @Override
    public void init() throws ServletException {
        super.init();
        service = LoginService.getInstance();
    }
}
