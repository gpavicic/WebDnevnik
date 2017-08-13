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
            <h1>Nalazite se na strani za pregled ocena</h1>

            <table id="example" class="display" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>Ime</th>
                        <th>Prezime</th>
                        <th>Ucenik Id</th> 
                        <th>Predmet</th>
                        <th>Predmet Id</th>
                        <th>Ocena</th>
                        <th>Profesor</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${ocene}" var="o">
                        <tr>
                            <td>${o.ucnId.ucnIme}</td>
                            <td>${o.ucnId.ucnPrezime}</td>
                            <td>${o.ucnId.ucnId}</td>
                            <td>${o.prdId.prdNaziv}</td>
                            <td>${o.prdId.prdId}</td>
                            <td>${o.ocnOcena}</td>
                            <td>${o.prdId.proId.proPrezime}</td>
                        </tr>
                    </c:forEach>    
                </tbody>
            </table>

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
