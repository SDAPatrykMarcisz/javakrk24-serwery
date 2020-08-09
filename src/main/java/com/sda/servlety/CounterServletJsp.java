package com.sda.servlety;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet("/counter-action")
public class CounterServletJsp extends HttpServlet {


    private static final String COUNTER_KEY = "count";
    private int totalVisits;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer attribute = (Integer) session.getAttribute(COUNTER_KEY);
        if (attribute == null) {
            session.setAttribute(COUNTER_KEY, 1);
        } else {
            session.setAttribute(COUNTER_KEY, attribute + 1);
        }
        totalVisits++;

        request.setAttribute("total", totalVisits);
        request.getRequestDispatcher("/counter-action.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        totalVisits = 0;
    }
}
