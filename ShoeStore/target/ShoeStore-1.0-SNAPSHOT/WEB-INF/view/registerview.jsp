<%-- 
    Document   : registerview
    Created on : Jul 1, 2021, 6:48:58 PM
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
    <body class="bg-register">
        <div class="center">
            <h1>Login</h1>
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
                <div class="txt_field">
                    <input type="confirmpassword" required>
                    <span></span>
                    <label>Confirm Password</label>
                </div>
                <input type="submit" value="Login">
                <div class="signup_link">
                    Have an account? <a href="/ShoeStore/login.html">Sign In</a>
                </div>
                <div class="signup_link">
                    <a href="/ShoeStore/product/list.html">Visit shop</a>
                </div>
            </form>
        </div>
    </body>
</html>
