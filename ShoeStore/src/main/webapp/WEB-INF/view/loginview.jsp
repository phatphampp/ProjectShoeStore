<%-- 
    Document   : loginview
    Created on : Jun 26, 2021, 6:52:25 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="/ShoeStore/css/style.css">
    </head>
    <body class="bg-login">
        <div class="center" class="backgroughLogin">
            <h1>Sign Up</h1>
            <form method="post">
                <div class="txt_field">
                    <input type="text" required>
                    <span></span>
                    <label>Username</label>
                </div>
                <div class="txt_field">
                    <input type="password" required>
                    <span></span>
                    <label>Password</label>
                </div>
                <input type="submit" value="Login">
                <div class="signup_link">
                    Not a member? <a href="/ShoeStore/register.html">Sign Up</a>
                </div>
                <div class="signup_link">
                    <a href="/ShoeStore/product/list.html">Visit shop</a>
                </div>
            </form>
        </div>
    </body>
</html>
