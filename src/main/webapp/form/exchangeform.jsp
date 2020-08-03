<%-- 
    Document   : exchangeform
    Created on : 2020/8/3, 下午 08:42:40
    Author     : teacher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exchange Form</title>
    </head>
    <body style="padding: 15px">
        <form class="pure-form" method="post" action="/JavaWeb0727/servlet/exchange">
            <fieldset>
                <legend>Exchange Form</legend>
                <input type="number" name="money" placeholder="請輸入金額(台幣)" />
                <p />
                <label for="default-remember">
                    <input type="checkbox" id="default-remember" name="currency" value="USD" />USD
                    <input type="checkbox" id="default-remember" name="currency" value="JPY" />JPY
                    <input type="checkbox" id="default-remember" name="currency" value="EUR" />EUR
                    <input type="checkbox" id="default-remember" name="currency" value="CNY" />CNY
                </label>
                <p />
                <button type="submit" class="pure-button pure-button-primary">Sign in</button>
            </fieldset>
        </form>
    </body>
</html>
