package com.sda.servlety;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("")
public class CounterServlet extends HttpServlet {

    private static final String COUNTER_KEY = "count";
    private int totalVisits;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer attribute = (Integer) session.getAttribute(COUNTER_KEY);
        if (attribute == null) {
            session.setAttribute(COUNTER_KEY, 1);
        } else {
            session.setAttribute(COUNTER_KEY, attribute + 1);
        }
        totalVisits++;


        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<h1>Hello World</h1>");
        out.println("<h2>To twoja: " + session.getAttribute(COUNTER_KEY) + " wizyta </h1>");
        out.println("<h2>Wszystkich wizyt na stronie: " + totalVisits);
        out.println("</html>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        totalVisits = 0;
    }
}
