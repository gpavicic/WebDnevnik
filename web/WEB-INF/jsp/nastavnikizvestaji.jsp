<%-- 
    Document   : ocene
    Created on : Jul 18, 2017, 12:03:17 AM
    Author     : Stenci
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script src="//cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
         <link rel="stylesheet" href="../styles.css"/>

        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>

        <title>Školski Web dnevnik</title>
    </head>
    <body>
        <div id="content">
        <h1>Nalazite se na strani za pregled izveštaja</h1>
        <h3>Popunjavanjem forme ispod tabele unosite nov izveštaj u bazu</h3>
        
        <table id="example" class="display" width="100%" cellspacing="0">
            <thead>
                <tr>
                    <th>Ime</th>
                    <th>Prezime</th>
                    <th>Id</th>
                    <th>Profesor</th>
                    <th>Id</th>
                    <th>Izveštaj</th>
                    <th>Datum</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${izvestaji}" var="i">
                    <tr>
                        <td>${i.ucnId.ucnIme}</td>
                        <td>${i.ucnId.ucnPrezime}</td>
                        <td>${i.ucnId.ucnId}</td>
                        <td>${i.proId.proPrezime}</td>
                        <td>${i.proId.proId}</td>
                        <td>${i.izvTekst}</td>
                        <td>${i.izvDatum}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <form action="unosizvestaja" method="POST">
                <table>
                    <tbody>
                        <tr>
                            <td><input type="text" name="profesorId" placeholder="Profesor Id"/></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="ucenikId" placeholder="Ucenik Id"/></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="izvestaj" placeholder="Izvestaj"/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Unos izveštaja"</td>
                        </tr>
                    </tbody>
                </table> 
            </form>
        
        <form action="logOut1" method="POST">
                <table>
                    <tbody>
                        <tr>
                            <td><input type="submit" value="Prethodna strana"</td>
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
