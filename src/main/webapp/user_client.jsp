<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User CRUD Page</title>
        <script>
            function queryUsers() {
                alert('queryUsers');
                console.log('queryUsers');
            }
        </script>
    </head>
    <body style="padding: 20px">
        
        <form id="user_form" class="pure-form">
            <fieldset>
                <legend>User CRUD</legend>
                ID : <input type="text" readonly /><p/>
                Name : <input type="text" id="name" name="name" placeholder="請輸入名字" /><p/>
                Age : <input type="number" id="age" name="age" placeholder="請輸入年齡" /><p/>
                <button type="button" id="add_button" class="pure-button pure-button-primary">新增</button>
                <button type="button" id="update_button" class="pure-button pure-button-primary">修改</button>
                <button type="button" id="query_button" onclick="queryUsers()" class="pure-button pure-button-primary">查詢</button>
                <button type="reset" class="pure-button pure-button-primary">清除</button>
            </fieldset>
        </form>


    </body>
</html>
