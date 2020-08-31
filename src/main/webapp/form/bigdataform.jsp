<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bigdata</title>
    </head>
    <body style="padding: 20px">
        <form class="pure-form" method="post" action="/JavaWeb0727/servlet/bigdata">
            <fieldset>
                <legend>BigData Sales</legend>
                <input type="text" name="country" placeholder="請輸入 country 名稱" />
                <button type="submit" class="pure-button pure-button-primary">查詢</button>
            </fieldset>
        </form>
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>region</th>
                    <th>country</th>
                    <th>totalprofit</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sales" items="${saleses}">
                <tr>
                    <td>${sales.region}</td>
                    <td>${sales.country}</td>
                    <td align="right">
                        <fmt:formatNumber pattern="###,###" value="${sales.totalprofit}"></fmt:formatNumber>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
