<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <my:pichart title="得意的一天" 
                    task="花費時數" 
                    work="8" 
                    eat="2" 
                    mobile="7" 
                    tv="1" 
                    sleep="6" />
    </body>
</html>
