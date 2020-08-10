<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int x = Integer.parseInt(request.getAttribute("x")+"");
    int y = Integer.parseInt(request.getAttribute("y")+"");
    out.println(x + y);
%>
