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
                ws.onopen = function(evt) { // Server 端的回應
                    result.insertAdjacentHTML("beforeend", '連入到 Server<br>');
                };
                ws.onclose = function(evt) { // Server 端的回應
                    result.insertAdjacentHTML("beforeend", '關閉連線<br>');
                    ws = null;
                };
                ws.onmessage = function(evt) { // Server 端的回應
                    result.insertAdjacentHTML("beforeend", evt.data + '<br>');
                };
            }
            function onClose() {
                if(ws == null) {
                    alert('請按下 Open 鍵');
                    return;
                }
                ws.close();
            }
            
            function send() {
                ws.send(message.value);
            }
        </script>
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>Hello Client</legend>
                <input type="text" id="message" placeholder="請輸入字串" /><p/>
                <button type="button" class="pure-button pure-button-primary" onclick="onOpen()">Open</button>
                <button type="button" class="pure-button pure-button-primary" onclick="send()">Send</button>
                <button type="button" class="pure-button pure-button-primary" onclick="onClose()">Close</button>
            </fieldset>
            <div id="result"></div>
        </form>
    </body>
</html>
