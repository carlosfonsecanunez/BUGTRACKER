<%-- 
    Document   : ListaBugs
    Created on : 30 nov. 2021, 14:46:53
    Author     : kai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <style type="text/css">
            .cabecera{
                font-size: 1.2em;
                font-weight: bold;
                color: #ffffff;
                background-color: #003366;
            }
            .filas{
                text-align: center;
                background-color: #3399ff;
            }
            table{
                float: left;
            }
            #contenedorBoton{
                margin-left: 600px;
            }
        </style>
    </head>
    <body>
        <table>
            <tr>
                <td class="cabecera">ID</td>
                <td class="cabecera">NAME</td><!-- comment -->
                <td class="cabecera">TYPE</td>
                <td class="cabecera">DESCRIPTION</td>
                <td class="cabecera">STATUS</td>
                <td class="cabecera">USER</td>
                <td class="cabecera">INITIAL DATE</td>
                <td class="cabecera">FINAL DATE</td>
                <td class="cabecera">ACTION</td>
            </tr>
            <c:forEach var="temBug" items="${MISBUGS}">
                <c:url var="linktemp" value="ControladorBug">
                    <c:param name="instruccion" value="cargar"></c:param>
                    <c:param name="codigo_bug" value="${temBug.bCode}"></c:param>
                </c:url>   
                <tr>
                    <td class="filas">${temBug.bCode}</td>
                    <td class="filas">${temBug.bName}</td>
                    <td class="filas">${temBug.bType}</td>
                    <td class="filas">${temBug.bDescription}</td>
                    <td class="filas">${temBug.bStatus}</td>
                    <td class="filas">${temBug.bUser}</td>
                    <td class="filas">${temBug.binitial_Date}</td>
                    <td class="filas">${temBug.bfinal_Date}</td>    
                    <td class="filas"><a href="${linktemp}">Update</a></td> 
                </tr>
            </c:forEach>
        </table>
        <div id="contenedorBoton">
            <input type="submit" name="insertar_Bug" value="Add a new Bug" onclick="window.location.href='Insertar_bug.jsp'" />
        </div>
    </body>
</html>
