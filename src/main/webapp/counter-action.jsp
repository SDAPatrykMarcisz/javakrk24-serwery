<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09.08.2020
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h2>To twoja:  ${sessionScope.count}</h2>
<h2>Wszystkich wizyt na stronie: ${requestScope.total}</h2>


</body>
</html>
