<%-- 
    Document   : logInProfessor
    Created on : Jul 18, 2017, 9:22:54 AM
    Author     : Stenci
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styles.css"/>
        <title>JSP Page</title>
    </head>
    <body>
       

        <div id="content">
        <h1>Unesite Vaše korisničke podatke</h1>
        <form action="logInProfessor" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td><input type="text" name="username" placeholder="Korisnicko ime"/></td>
                    </tr>
                    <tr>
                        <td><input type="password" name="pass" placeholder="Korisnicka lozinka"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Nastavi"</td>
                    </tr>
                </tbody>
            </table>
        </form>
            
            </div>
    </body>
</html>
