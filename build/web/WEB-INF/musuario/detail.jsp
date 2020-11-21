<%-- 
    Document   : especialidades
    Created on : 22/01/2020, 07:15:15 PM
    Author     : JERSON BUJAICO PACHECO
--%>
<%@page import="com.miempresa.dtos.Usuario"%>
<%
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
%>
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
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 offset-lg-2">
                        <ul class="list-group">
                            <li class="list-group-item active">Detalles de usuario</li>
                            <li class="list-group-item">Id: <%=usuario.getId()%></li>
                            <li class="list-group-item">Nombre(s): <%=usuario.getNombre()%></li>
                            <li class="list-group-item">Apellidos: <%=usuario.getApellido()%></li>
                            <li class="list-group-item">DNI: <%=usuario.getDni()%></li>
                            <li class="list-group-item">Fecha de nacimiento: <%=usuario.getFechanac()%></li>
                            <li class="list-group-item">Id: <%=usuario.getSexo()%></li>
                            <li class="list-group-item">Apellidos: <%=usuario.getCorreo()%></li>
                            <li class="list-group-item">DNI: <%=usuario.getClave()%></li>
                            <li class="list-group-item">Pregunta secreta: <%=usuario.getPregunta()%></li>
                            <li class="list-group-item">Respuesta secreta: <%=usuario.getRespuesta()%></li>
                            <li class="list-group-item">Perfil: <%=usuario.getPerfil()%></li>
                                <%if (usuario.getEstado() == 1) {%>
                            <li class="list-group-item">Estado: Activo</li>
                                <%} else {%>
                            <li class="list-group-item">Estado: Desactivado</li>
                                <%}%>
                        </ul>
                        <div class="alert alert-secondary" role="alert">
                            <a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=listar"><button type="button" class="btn btn-outline-success">Regresar</button></a>
                            <a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=logout"><button type="button" class="btn btn-outline-secondary">Cerrar sesión</button></a>                
                        </div>
                    </div>
                </div>
                <br>
                <br>
                <%@include file="../jspf/cfooter.jspf"%>
            </div>
    </body>
    <%@include file="../jspf/cjs.jspf"%>
</html>
