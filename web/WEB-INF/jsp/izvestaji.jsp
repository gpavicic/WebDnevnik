<%-- 
    Document   : izvestaji
    Created on : Jul 18, 2017, 12:17:14 AM
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
        <link rel="stylesheet" type="text/css" href="styles.css">
        
        <script>
            $(document).ready(function(){
    $('#example').DataTable();
});
        </script>
        <title>Izvestaji</title>
    </head>
    <body>
        <h1>Hello IZVESTAJI World!</h1>
        
        <table id="example" class="display" width="100%" cellspacing="0">
            <thead>
                <tr>
                    <th>Izvestaj o uceniku</th>
                    <th>Izvestaj sastavio</th>
                    <th>Izvestaj</th>
                    <th>Datum</th>
                    
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${izvestaji}" var="i">
                    <tr>
                        <td>${i.ucnId.ucnIme}</td>
                        
                        <td>${i.proId.proPrezime}</td>
                        <td>${i.izvTekst}</td>
                        <td>${i.izvDatum}</td>
                       
                    </tr>
                </c:forEach>
                
            </tbody>
        </table>
        
    </body>
</html>
