<%-- 
    Document   : novastrana
    Created on : Jul 18, 2017, 1:06:57 PM
    Author     : Stenci

    <c:out value="${sessionScope.profesor}" />
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="../styles.css"/>
        <title>Školski Web dnevnik</title>
    </head>
    <body>
        <div id="content">
        <h1>Sadržaj:</h1>
        
        <form action="ucenikocene" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td><input type="submit" value="Prikaži ocene"</td>
                    </tr>
                </tbody>
            </table>
        </form>
        
        <form action="logOut" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td><input type="submit" value="Log out"</td>
                    </tr>
                </tbody>
            </table>
        </form>
      </div>  
    </body>
</html>
