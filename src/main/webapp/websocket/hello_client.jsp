<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello Client</title>
        <script>
            var url = 'ws://localhost:8080/JavaEE0727/websocket/hello';
            var ws = null;
            function onOpen() {
                ws = new WebSocket(url);
                ws.onopen = function(evt) {
                    result.insertAdjacentHTML("beforeend", '連入到 Server<br>');
                };
            }
            function onClose() {
                if(ws == null) {
                    alert('請按下 Open 鍵');
                    return;
                }
                ws.onclose = function(evt) {
                    result.insertAdjacentHTML("beforeend", '關閉連線<br>');
                    ws = null;
                };
            }
        </script>
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
