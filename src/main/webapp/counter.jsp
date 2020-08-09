<html>
<h1>Hello World</h1>
<%! String COUNTER_KEY = "count"; %>

<%
    Integer attribute = (Integer) session.getAttribute(COUNTER_KEY);
    if (attribute == null) {
        session.setAttribute(COUNTER_KEY, 1);
    } else {
        session.setAttribute(COUNTER_KEY, attribute + 1);
    }
%>

<h2><% out.print("To twoja: " + session.getAttribute(COUNTER_KEY) + " wizyta "); %></h2>
</html>

