<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User CRUD Page</title>
        <script>
            function queryUsers() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("result").innerHTML = this.responseText;
                    }
                };
                xhttp.open("GET", "/JavaEE0727/rest/user/all", true);
                xhttp.send();
            }
        </script>
    </head>
    <body style="padding: 20px">

        <form id="user_form" class="pure-form">
            <fieldset>
                <legend>User CRUD</legend>
                ID : <input type="text" id="id" name="id" placeholder="請輸入ID" /><p/>
                Name : <input type="text" id="name" name="name" placeholder="請輸入名字" /><p/>
                Age : <input type="number" id="age" name="age" placeholder="請輸入年齡" /><p/>
                <button type="button" id="add_button" class="pure-button pure-button-primary">新增</button>
                <button type="button" id="update_button" class="pure-button pure-button-primary">修改</button>
                <button type="button" id="query_button" onclick="queryUsers()" class="pure-button pure-button-primary">查詢</button>
                <button type="reset" class="pure-button pure-button-primary">清除</button>
            </fieldset>
        </form>

        <div id="result"></div>

    </body>
</html>
