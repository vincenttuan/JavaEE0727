<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stream Form</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
    </head>
    <body style="padding: 20px">
        <form class="pure-form" 
              enctype="application/x-www-form-urlencoded"
              method="post" action="/JavaWeb0727/servlet/stream">
            <fieldset>
                <legend>Stream Form (enctype="application/x-www-form-urlencoded")</legend>
                <input type="text" placeholder="請輸入姓名" name="name" />
                <input type="number" placeholder="請輸入年齡" name="age" />
                <button type="submit" class="pure-button pure-button-primary">傳送</button>
            </fieldset>
        </form>
        <form class="pure-form" 
              enctype="multipart/form-data"
              method="post" action="/JavaWeb0727/servlet/stream">
            <fieldset>
                <legend>Stream Form (enctype="multipart/form-data")</legend>
                <input type="text" placeholder="請輸入姓名" name="name" />
                <input type="number" placeholder="請輸入年齡" name="age" />
                <button type="submit" class="pure-button pure-button-primary">傳送</button>
            </fieldset>
        </form>
        <form class="pure-form" 
              enctype="text/plain"
              method="post" action="/JavaWeb0727/servlet/stream">
            <fieldset>
                <legend>Stream Form (enctype="text/plain")</legend>
                <input type="text" placeholder="請輸入姓名" name="name" />
                <input type="number" placeholder="請輸入年齡" name="age" />
                <button type="submit" class="pure-button pure-button-primary">傳送</button>
            </fieldset>
        </form>
        <form class="pure-form" 
              enctype="multipart/form-data"
              method="post" action="/JavaWeb0727/servlet/stream">
            <fieldset>
                <legend>Upload Form (enctype="multipart/form-data")</legend>
                <input type="file" name="myfile" />
                <button type="submit" class="pure-button pure-button-primary">上傳</button>
            </fieldset>
        </form>
    </body>
</html>
