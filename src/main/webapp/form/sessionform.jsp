<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Session Form</title>
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <a href="/JavaWeb0727/servlet/session/getauth" target="myframe">授權</a>
                <a href="/JavaWeb0727/servlet/session/getreport" target="myframe">報告</a>
                <a href="/JavaWeb0727/servlet/session/cancel" target="myframe">取消</a>
            </fieldset>
        </form>
        <iframe id="myframe" name="myframe" width="500" height="300"></iframe>
    </body>
</html>
