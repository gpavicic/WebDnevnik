<%-- 
    Document   : predmet
    Created on : Jul 17, 2017, 11:01:52 PM
    Author     : Stenci
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <title>Predmeti</title>
    </head>
    <body>
        <h1>Hello PREDMETI World! +  ${profesor.proIme}</h1>
        
        <table>
            <thead>
                <tr>
                    <th>Predmet</th>
                    <th>Tip predmeta</th>
                    <th>Profesor</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${predmeti}" var="p">
                    <tr>
                        <td>${p.prdNaziv}</td>
                        <td>${p.tipId.tipNaziv}</td>
                        <td>${p.proId.proPrezime}</td>
                    </tr>
                </c:forEach>
                
            </tbody>
        </table>
        
    </body>
</html>
