<%-- 
    Document   : Registrar_usuario
    Created on : 1 mar. 2022, 13:22:17
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
        <h1>Register user</h1>
        <form name="form1" action="ControladorBug" method="get">
        <input type="hidden" name="instruccion" value="registrar_user">
        <input type="hidden" name="access_type" value="1" id="access_type">
            <table>
                <tr>
                    <td>
                        <label for="name">Name </label>
                    </td>
                    <td>
                        <input type="text" name="name" id="name" value="${usarioNoRegistrado.userName}">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password">PassWord</label>
                    </td>
                    <td>
                        <input type="text" name="password" id="password">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password2">Reenter password</label>
                    </td>
                    <td>
                        <input type="text" name="password2" id="password2" >
                    </td>
                </tr>
                <script type="text/javascript">
                    /*let x = 10;
                    x += 5;
                    document.getElementById("demo").innerHTML = x;*/
                    function passwordCheck(){
                        let ps1 = document.getElementById("password");
                        let ps2 = document.getElementById("password2");
                            if (ps1.value != ps2.value){
                                alert("Password does not match!!");
                            }
                    }
                </script>
                <button type="submit" onclick="passwordCheck()">Register</button>
            </table>
        </form>
    </body>
</html>
