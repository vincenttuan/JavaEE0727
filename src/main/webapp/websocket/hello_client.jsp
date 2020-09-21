<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello Client</title>
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>Hello Client</legend>
                <input type="text" placeholder="請輸入字串" /><p/>
                <button type="button" class="pure-button pure-button-primary">Open</button>
                <button type="button" class="pure-button pure-button-primary">Send</button>
                <button type="button" class="pure-button pure-button-primary">Close</button>
            </fieldset>
            <div id="result"></div>
        </form>
    </body>
</html>
