<html>
<h1>Hello World</h1>
<%! final String COUNTER_KEY = "count";
    int totalVisits; %>

<%!
    /*odpowiednik metody init() z servletu*/
    @Override
    public void jspInit() {
        totalVisits = 0;
    }
%>
<%
    Integer attribute = (Integer) session.getAttribute(COUNTER_KEY);
    if (attribute == null) {
        session.setAttribute(COUNTER_KEY, 1);
    } else {
        session.setAttribute(COUNTER_KEY, attribute + 1);
    }
    totalVisits++;
%>
<h2>To twoja: <%= session.getAttribute(COUNTER_KEY) %> wizyta</h2>
<h2>Wszystkich wizyt na stronie: <% out.print(totalVisits); %></h2>
</html>