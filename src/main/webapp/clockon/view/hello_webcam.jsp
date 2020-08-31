<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Webcam!</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>

    <body>
        <h1>Hello Webcam!</h1>
        <form id="signInForm">
            <input id="image" name="image" type="text">
            <button id="signInBtn" >SignIn</button>    
        </form>
        <p>
        <button id="capture">Capture</button>
        <p>
        <video id="player" width="320" height="240" controls autoplay></video>
        <canvas id="snapshot" width="320" height="240"></canvas>
        <script>
            var player = document.getElementById('player');
            var captureButton = document.getElementById('capture');
            var snapshotCanvas = document.getElementById('snapshot');
            var signInBtn = document.getElementById('signInBtn');
            var handleSuccess = function (stream) {
                // Attach the video stream to the video element and autoplay.
                player.srcObject = stream;
            };
            captureButton.addEventListener('click', function () {
                var context = snapshot.getContext('2d');
                // Draw the video frame to the canvas.
                context.drawImage(player, 0, 0, snapshotCanvas.width,
                        snapshotCanvas.height);
                var base64 = snapshotCanvas.toDataURL();
                console.log(base64);
                document.getElementById("image").value = base64;
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
            navigator.mediaDevices.getUserMedia({video: true})
                    .then(handleSuccess);

        </script>
    </body>
</html>

