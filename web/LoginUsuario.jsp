<%-- 
    Document   : LoginUsuario
    Created on : 20 feb. 2022, 13:07:07
    Author     : kai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name="form1" action="ControladorBug" method="get">
        <input type="hidden" name="instruccion" value="verificar_user">    
            <table>
                <tr>
                    <td><label for="user"><b>User</b></label></td>
                </tr>
                <tr>
                    <td><input type="text" name="user" id="user"></td>
                </tr>
                <tr>
                    <td><label for="password"><b>Password</b></label></td>
                </tr>
                <tr>
                    <td><input type="text" name="password" id="password"></td>
                </tr>
            </table>
            <button type="submit" id="button_log" value="Login">Login</button>
        </form>
    </body>
</html>
