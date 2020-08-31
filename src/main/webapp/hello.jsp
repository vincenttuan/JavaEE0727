<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    double getBMI(double h, double w) {
        double bmi = w / Math.pow(h/100, 2);
        return bmi;
    }
%>
<html>
    <head>
        <link rel="SHORTCUT ICON" href="favicon.ico"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>我的第一支JSP</title>
    </head>
    <body>
        <h1>
            <%
                double h = 170.0;
                double w = 60.0;
                double bmi = getBMI(h, w);
                out.println(bmi);
            %>
        </h1>
    </body>
</html>
