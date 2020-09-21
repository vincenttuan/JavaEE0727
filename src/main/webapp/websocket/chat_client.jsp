<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>聊天室 (Chat)</title>
        <script src="chat.js"></script>
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>聊天室 (Chat)</legend>
                <input type="text" id="message" placeholder="請輸入字串" /><p/>
                <button type="button" id="sendBtn" class="pure-button pure-button-primary">Send</button>
                <button type="button" id="closeBtn" class="pure-button pure-button-primary">Close</button>
            </fieldset>
            <div id="result"></div>
        </form>
    </body>
</html>
