<%-- 
    Document   : listhis
    Created on : 04/03/2020, 02:52:10 PM
    Author     : BUJAICO PACHECO JERSON
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

        <%@include file="../jspf/cheader.jspf"%>
        <%@include file="../jspf/cnav.jspf"%>
        <div class="container-fuid">
            <c:forEach var="historiales" items="${sessionScope.listCitas}">
                <div class="row">
                    <div class="col-lg-10 offset-lg-1" >
                        <div class="card">
                            <h5 class="card-header">Cita ${historiales.codcita}</h5>
                            <div class="card-body">
                                <form action="usuarioController.do" method="POST">
                                    <div class="form-group">
                                        <input type="hidden" name="txtProceso" value="resgisterHistorial">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtCodCita">Cod cita</label>
                                        <input type="text" class="form-control" name="txtCodCita" id="txtCodCita" value="${historiales.codcita}">                            
                                    </div>
                                    <div class="form-group">
                                        <label for="txtIdUser">Id Usuario</label>
                                        <input type="text" class="form-control" name="txtIdUser" id="txtIdUser" value="${historiales.iduser}">                            
                                    </div>
                                    <div class="form-group">
                                        <label for="txtNomUser">Nombre Usuario</label>
                                        <input type="text" class="form-control" name="txtNomUser" id="txtNomUser" value="${historiales.nomuser}">                            
                                    </div>
                                    <div class="form-group">
                                        <label for="txtApeUser">Nombre Usuario</label>
                                        <input type="text" class="form-control" name="txtApeUser" id="txtApeUser" value="${historiales.apeuser}">                            
                                    </div>
                                    <div class="form-group">
                                        <label for="txtIdDoctor">ID Doctor</label>
                                        <input type="text" class="form-control" name="txtIdDoctor" id="txtIdDoctor" value="${historiales.iddoctor}">                            
                                    </div>
                                    <div class="form-group">
                                        <label for="txtNomDoctor">Nombre Doctor</label>
                                        <input type="text" class="form-control" name="txtNomDoctor" id="txtNomDoctor" value="${historiales.nomdoctor}">                            
                                    </div>
                                    <div class="form-group">
                                        <label for="txtApeDoctor">Apellido Doctor</label>
                                        <input type="text" class="form-control" name="txtApeDoctor" id="txtApeDoctor" value="${historiales.apedoctor}">                            
                                    </div>
                                    <div class="form-group">
                                        <label for="txtEspecialidad">Especialidad</label>
                                        <input type="text" class="form-control" name="txtEspecialidad" id="txtEspecialidad" value="${historiales.especialidad}">                            
                                    </div> 
                                    <div class="form-group">
                                        <label for="txtFecha">Fecha programada</label>
                                        <input type="text" class="form-control" name="txtFecha" id="txtFecha" value="${historiales.fecha}">                            
                                    </div>
                                    <div class="form-group">
                                        <label for="txtObservaciones">Agregar Observaciones</label>
                                        <textarea class="form-control" name="txtObservaciones" id="txtObservaciones"></textarea>
                                    </div>
                                    <button type="submit" class="btn btn-danger">Agregar Observaciones</button>
                                </form>
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
