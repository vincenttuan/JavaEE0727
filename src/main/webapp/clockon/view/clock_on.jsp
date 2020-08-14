<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>打卡系統</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
    </head>
    <body style="padding: 20px">
    <ceter>
        <table>
            <tr>
                <td>
                    <form class="pure-form" method="post" action="/JavaWeb0727/controller/clockon">
                        <fieldset>
                            <legend>打卡系統 Clock on</legend>
                            <video id="player" width="320" height="240" controls autoplay></video>
                            <p />
                            <input type="text" id="no" name="no" placeholder="請輸入員工編號" />
                            <input type="hidden" id="image" name="image" />
                            <p />
                            <button id="signInBtn" type="submit" class="pure-button pure-button-primary">打卡</button>
                            <button id="queryBtn" type="button" class="pure-button pure-button-primary">查詢</button>
                        </fieldset>
                    </form>
                </td> 
            </tr>
            <tr>
                <td>
                    <table class="pure-table pure-table-bordered">
                        <thead>
                            <tr>
                                <th>no</th>
                                <th>image</th>
                                <th>time</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                Object obj = request.getAttribute("logs");
                                if (obj != null) {
                                    List<Map<String, String>> list = (List<Map<String, String>>) obj;
                                    for (Map<String, String> map : list) {
                                        out.print("<tr>");
                                        out.print("<td>" + map.get("no") + "</td>");
                                        out.print("<td><img src='" + map.get("image") + "' width='100'></td>");
                                        out.print("<td>" + map.get("time") + "</td>");
                                        out.print("</tr>");
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </td>
            </tr>
        </table>
    </ceter>
    <canvas id="snapshot" width="320" height="240" style="visibility: hidden"></canvas>
    <script>
        var player = document.getElementById('player');
        var snapshotCanvas = document.getElementById('snapshot');
        
        queryBtn.addEventListener('click', function () {
            var no = document.getElementById("no").value;
            window.location.href = '/JavaWeb0727/controller/clockonreport?no=' + no;
        });
        
        signInBtn.addEventListener('click', function () {
            var context = snapshot.getContext('2d');
            // Draw the video frame to the canvas.
            context.drawImage(player, 0, 0, snapshotCanvas.width,
                    snapshotCanvas.height);
            var base64 = snapshotCanvas.toDataURL();
            console.log(base64);
            document.getElementById("image").value = base64;
            //document.getElementById("signInForm").submit();
        });
        var handleSuccess = function (stream) {
            player.srcObject = stream;
        };
        navigator.mediaDevices.getUserMedia({video: true})
                .then(handleSuccess);
    </script>                        
</body>
</html>
