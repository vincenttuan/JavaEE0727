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
                var room_no = '/A01';
                var url = 'ws://' + window.location.hostname + ':' + window.location.port + context_path + websocket_path + room_no;
                var ws = new WebSocket(url);
                ws.onopen = function(evt) { // 接收到 server 的回應
                    result.insertAdjacentHTML("afterbegin", '連入到 Server<br>');
                };
                ws.onmessage = function(evt) { // 接收到 server 的回應
                    result.insertAdjacentHTML("afterbegin", evt.data + '<br>');
                };
                ws.onclose = function(evt) { // 接收到 server 的回應
                    result.insertAdjacentHTML("afterbegin", '關閉連線, 若要重新連線請重新整理網頁 !<br>');
                    ws = null;
                    sendBtn.disabled = true;
                    closeBtn.disabled = true;
                };
                sendBtn.addEventListener("click", function() { // Client 觸發的事件
                    ws.send(message.value); // 傳送資料
                });
                closeBtn.addEventListener("click", function() { // Client 觸發的事件
                    ws.close() // 關閉資料
                });
            };
        </script>
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
