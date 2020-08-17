<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    <body style="padding: 20px">
        <form class="pure-form" method="post" action="/JavaWeb0727/servlet/result">
            <fieldset>
                <legend>Login Form</legend>
                <input type="email" placeholder="Email" /><p />
                <input type="password" placeholder="Password" /><p />
                <label for="default-remember">
                <input type="checkbox" id="default-remember" />&nbsp;Remember me</label><p />
                <button type="submit" class="pure-button pure-button-primary">Sign in</button>
            </fieldset>
        </form>
    </body>
</html>
