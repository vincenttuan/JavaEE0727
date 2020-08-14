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
                            <input type="text" id="no" name="no" placeholder="請輸入員工編號" />
                            <input type="text" id="image" name="image" />
                            <p />
                            <button type="submit" class="pure-button pure-button-primary">打卡</button>
                            <button type="button" class="pure-button pure-button-primary">查詢</button>
                        </fieldset>
                    </form>
                </td> 
            </tr>
        </table>
    </ceter>
</body>
</html>
