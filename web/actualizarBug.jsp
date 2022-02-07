<%-- 
    Document   : actualizarBug
    Created on : 4 feb. 2022, 17:48:06
    Author     : kai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Update Bug</h1>
        <form name="form1" method="get" action="ControladorBug">
        <input type="hidden" name="instruccion" value="actualizarBBDD">
        <input type="hidden" name="codigo_bug" value="${bugaActualizar.bCode}">
            <table>
                <!--
                <tr>
                    <td><label for="codigo_articulo">Codigo del Aticulo</label></td>
                    <td><input type="text" name="codigo_articulo" id="codigo_articulo"></td>
                </tr>
                <tr>
                -->
                    <td><label for="bug_name">Bug name</label></td>
                    <td><input type="text" name="bug_name" id="bug_name" value="${bugaActualizar.bName}"></td>
                </tr>
                <tr>
                    <td><label for="type">Type</label></td>
                    <td><input type="text" name="type" id="type" value="${bugaActualizar.bType}"></td>
                </tr>
                <tr>
                    <td><label for="description">Description</label></td>
                    <td><input type="text" name="description" id="description" value="${bugaActualizar.bDescription}"></td>
                </tr>
                <tr>
                    <td><label for="status">Satatus</label></td>
                    <td><input type="text" name="status" id="status" value="${bugaActualizar.bStatus}"></td>
                </tr>
                <tr>
                    <td><label for="user">User</label></td>
                    <td><input type="text" name="user" id="user" value="${bugaActualizar.bUser}"></td>
                </tr>
                <tr>
                    <td><input type="submit" name="boton_enviar" value="Enviar"></td>
                    <td><input type="submit" name="boton_limpiar" value="Limpiar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
