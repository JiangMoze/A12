<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/29
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%

        String username=request.getParameter("username");

        username+="wei";

        PrintWriter o=response.getWriter();

        o.println(username);
        o.flush();
        o.close();


    %>
</body>
</html>
