<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>聊天室 (Chat)</title>
        <script>
            window.onload = function() {
                var context_path = '/JavaEE0727';
                var websocket_path = '/websocket/chat';
                var url = 'ws://' + window.location.hostname + ':' + window.location.port + context_path + websocket_path;
                var ws = new WebSocket(url);
                ws.onopen = function(evt) {
                    result.insertAdjacentHTML("beforeend", '連入到 Server<br>');
                };
                ws.onmessage = function(evt) {
                    result.insertAdjacentHTML("beforeend", evt.data() + '<br>');
                };
                ws.onclose = function(evt) {
                    result.insertAdjacentHTML("beforeend", '關閉連線, 若要重新連線請重新整理網頁 !<br>');
                    ws = null;
                };
            };
        </script>
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>聊天室 (Chat)</legend>
                <input type="text" id="message" placeholder="請輸入字串" /><p/>
                <button type="button" class="pure-button pure-button-primary">Send</button>
                <button type="button" class="pure-button pure-button-primary">Close</button>
            </fieldset>
            <div id="result"></div>
        </form>
    </body>
</html>
