<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Form</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
    </head>
    <body style="padding: 20px">
        <form class="pure-form" 
              enctype="multipart/form-data"
              method="post" action="/JavaWeb0727/servlet/upload">
            <fieldset>
                <legend>Upload Form (enctype="multipart/form-data")</legend>
                <input type="file" name="myfile1" /><p>
                <input type="file" name="myfile1" /><p>
                <input type="text" name="desc1" /><p>
                <button type="submit" class="pure-button pure-button-primary">上傳</button>
            </fieldset>
        </form>
    </body>
</html>
