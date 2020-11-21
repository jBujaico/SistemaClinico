<%-- 
    Document   : fase2
    Created on : 04/03/2020, 05:50:22 AM
    Author     : Jerson
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
                        <h5 class="card-header">Paso 2</h5>
                        <div class="card-body">
                            <form method="POST" action="usuarioController.do">
                                <input type="hidden" value="datoscita" name="txtProceso">
                                <div class="form-group">
                                    <select class="form-control" name="txtIdDoctor">
                                        <c:forEach var="doctores" items="${sessionScope.doctoresEsp}">
                                            <option value="${doctores.id}">${doctores.nombre} ${doctores.apellido}</option>
                                        </c:forEach> 
                                    </select>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-danger">Elegir Doctor</button>
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

