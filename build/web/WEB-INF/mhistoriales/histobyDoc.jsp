<%-- 
    Document   : histobyDoc
    Created on : 04/03/2020, 04:48:50 PM
    Author     : JERSON BUJAICO PACHECO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@include file="../jspf/cmeta.jspf"%>
        <title>JSP Page</title>

        <%@include file="../jspf/cstyles.jspf"%>

    </head>
    <body>

        <%@include file="../jspf/cheader.jspf"%>
        <%@include file="../jspf/cnav.jspf"%>
        <div class="container-fuid">
            <c:forEach var="histobydoc" items="${sessionScope.histocitas}">
                <div class="row">
                    <div class="col-lg-10 offset-lg-1" >
                        <div class="card">
                            <h5 class="card-header">Atencion Nro: ${histobydoc.codcita}</h5>
                            <div class="card-body">
                                <ul class="list-group">
                                    <li class="list-group-item">Cod cita: ${histobydoc.codcita}</li>
                                    <li class="list-group-item">Nombre(s) Paciente: ${histobydoc.nomuser}</li>
                                    <li class="list-group-item">Apellidos Paciente: ${histobydoc.apeuser}</li>
                                    <li class="list-group-item">ID Doctor: ${histobydoc.iddoctor}</li>
                                    <li class="list-group-item">Nombre Doctor: ${histobydoc.nomdoctor}</li>
                                    <li class="list-group-item">Apellido Doctor: ${histobydoc.apedoctor}</li>
                                    <li class="list-group-item">Especialidad: ${histobydoc.especialidad}</li>
                                    <li class="list-group-item">Fecha: ${histobydoc.fecha}</li>
                                    <li class="list-group-item">Observaciones: </li>
                                </ul>
                                    <p>${histobydoc.Obervaciones}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <br>
        <br>
        <%@include file="../jspf/cfooter.jspf"%>
    </body>
    <%@include file="../jspf/cjs.jspf"%>
</html>
