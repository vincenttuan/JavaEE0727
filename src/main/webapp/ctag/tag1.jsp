<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://my.scwcd" prefix="my"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><my:greet user="Vincent" /></h1>
        <h1><my:greet user="<%=String.valueOf(1+2) %>" /></h1>
        <h1><my:greet user="${param.name}" /></h1>
        <h1>
            <my:if condition="true">
               if 標籤成立
            </my:if>
        </h1>
        <h1>
            <my:loop count="5">
                Java
            </my:loop>
        </h1>
        <my:mark search="s">
            she sell sea shell on the sea shore
        </my:mark>
        <hr>
        <h1>
            <my:switch conditionValue="1">
                <my:case caseValue="1">男生</my:case>
                <my:case caseValue="2">女生</my:case>
            </my:switch>
        </h1>
        身分證字號 : <input type="text" name="id"> <my:required /> <p />
        年齡 : <input type="text" name="age"> <p />
    </body>
</html>
