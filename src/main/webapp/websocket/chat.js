window.onload = function () {
    var context_path = '/JavaEE0727';
    var websocket_path = '/websocket/chat';
    var room_no = '/A02';
    var url = 'ws://' + window.location.hostname + ':' + window.location.port + context_path + websocket_path + room_no;
    var ws = new WebSocket(url);
    ws.onopen = function (evt) { // 接收到 server 的回應
        result.insertAdjacentHTML("afterbegin", '連入到 Server<br>');
    };
    ws.onmessage = function (evt) { // 接收到 server 的回應
        result.insertAdjacentHTML("afterbegin", evt.data + '<br>');
    };
    ws.onclose = function (evt) { // 接收到 server 的回應
        result.insertAdjacentHTML("afterbegin", '關閉連線, 若要重新連線請重新整理網頁 !<br>');
        ws = null;
        sendBtn.disabled = true;
        closeBtn.disabled = true;
    };
    sendBtn.addEventListener("click", function () { // Client 觸發的事件
        ws.send(message.value); // 傳送資料
    });
    closeBtn.addEventListener("click", function () { // Client 觸發的事件
        ws.close() // 關閉資料
    });
};


