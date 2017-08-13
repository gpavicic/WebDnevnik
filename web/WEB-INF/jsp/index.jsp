<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Školski Web dnevnik</title>
        <link rel="stylesheet" href="../styles.css"/>
        
        <link rel="stylesheet" type="text/css" href="styles.css">

    </head>

    <body>
        <div id="content">
        <h1>Školski Web dnevnik</h1>
            
            <form action="logInProfessor" method="POST">
                <table>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Profesor"</td>
                    </tr>
                </table>
            </form>
                
            <form action="logInUser" method="POST">
                <table>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Ucenik"</td>
                    </tr>
                </table>
            </form>
            
        </div>
    
    </body>
</html>
