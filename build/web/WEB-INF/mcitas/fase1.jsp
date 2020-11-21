<%-- 
    Document   : fase1
    Created on : 04/03/2020, 04:47:38 AM
    Author     : Jerson
--%>
<%@page import="com.miempresa.dtos.Usuario"%>

<%-- 
    Document   : especialidades
    Created on : 22/01/2020, 07:15:15 PM
    Author     : JERSON BUJAICO PACHECO
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@include file="../jspf/cmeta.jspf"%>
        <title>JSP Page</title>

        <%@include file="../jspf/cstyles.jspf"%>

    </head>
    <body>
        <div class="container-fuid">
            <%@include file="../jspf/cheader.jspf"%>
            <%@include file="../jspf/cnav.jspf"%>  
            <div class="row">
                <div class="col-lg-4 offset-lg-4">
                    <div class="card">
                        <h5 class="card-header">Paso 1</h5>
                        <div class="card-body">
                            <form method="POST" action="usuarioController.do">
                                <div class="form-group">
                                    <input type="hidden" class="form-control" value="filtrarDoc" name="txtProceso">
                                </div>
                                <div class="form-group">
                                    <select class="form-control" name="txtEspecialidad">
                                        <c:forEach var="especialidades" items="${sessionScope.especialidades}">
                                            <option value="${especialidades.especialidad}">${especialidades.especialidad}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-danger">Filtrar por especialidad</button>                                          
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <%@include file="../jspf/cfooter.jspf"%>
    </body>
    <%@include file="../jspf/cjs.jspf"%>
</html>
