<%-- 
    Document   : unos
    Created on : Jul 18, 2017, 4:04:01 PM
    Author     : Stenci

    <input type="text" value="${o.ocnId}"/>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <title>unos ocene</title>
    </head>
    <body>
        <h1> UNOS OCENE </h1>
        
                       
                            
                        <form action="unos" method="POST">
                            
                        <p>${o.ucnId.ucnIme}<p>
                        <p>${o.ucnId.ucnPrezime}<p>
                        <p>${o.prdId.prdNaziv}<p>
                        <p>${o.prdId.proId.proPrezime}<p>
                        <p>${o.ocnOcena}<p>
                        <p>
                            <!--<select name="ocena">
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                            </select> -->
                             <input type="text" name="ocena" placeholder="Unesite ocenu"/>
                      
                            <input type="submit" value="unesi"/>
                        </form>
                        </p>
        
    </body>
</html>
