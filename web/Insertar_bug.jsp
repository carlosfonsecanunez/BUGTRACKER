<%-- 
    Document   : Insertar_bug
    Created on : 5 dic. 2021, 18:56:43
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
        <form name="form1" method="get" action="ControladorBug">
        <input type="hidden" name="instruccion" value="insertar_BBDD">
           <table>
               <tr>
                   <td><label for="bug_name">Bug name </label></td>  
                   <td><input type="text" name="bug_name" id="bug_name"></td>
               </tr>
               <tr>
                   <td><label for="type">Type </label></td>  
                   <td><input type="text" name="type" id="type"></td>
               </tr><!-- comment -->
               <tr>
                   <td><label for="description">Description </label></td>  
                   <td><input type="text" name="description" id="description"></td>
               </tr>
               <tr>
                   <td><label for="status">Status </label></td>  
                   <td><input type="text" name="status" id="status"></td>
               </tr>
               <tr>
                   <td><label for="user">User</label></td>  
                   <td><input type="text" name="user" id="user"></td>
               </tr>
               <tr>
                   <td><label for="init_date">Post date </label></td>  
                   <td><input type="text" name="init_date" id="init_date"></td>
               </tr>
               <tr>
                   <td><input type="submit" name="add" value="Add"></td>
                   <td><input type="reset" name="reset" value="Clean"></td>
               </tr>
             
           </table>
        </form>
    </body>
</html>
