<%-- 
    Document   : especialidades
    Created on : 22/01/2020, 07:15:15 PM
    Author     : JERSON BUJAICO PACHECO
--%>

<%@page import="com.miempresa.dtos.Usuario"%>
<%@page session="true"%>
<%
    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    HttpSession sessionOK = request.getSession();
    request.getSession().setAttribute("iduser", usuario.getId());
    request.getSession().setAttribute("nombreuser", usuario.getNombre());
    request.getSession().setAttribute("apeuser", usuario.getApellido());
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@include file="WEB-INF/jspf/cmeta.jspf"%>
        <title>JSP Page</title>

        <%@include file="WEB-INF/jspf/cstyles.jspf"%>

    </head>
    <body>
        <div class="container-fuid">
            <%@include file="WEB-INF/jspf/cheader.jspf"%>
            <%@include file="WEB-INF/jspf/cnav.jspf"%>
            <section>

                <div class="row">
                    <div class="col-12 col-lg-10 offset-lg-1">
                        <div class="card">
                            <h1>BIENVENIDO AL SISTEMA <%=usuario.getNombre()%></h1>
                            <div class="card-body">

                                <% if (sessionOK.getAttribute("estado") != null && Integer.parseInt(sessionOK.getAttribute("estado").toString()) != 0) {%>
                                <div class="boton"><a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=logout">Cerrar Sesión</a> </div>
                                <% if (sessionOK.getAttribute("perfil").toString().equals("doctor") || sessionOK.getAttribute("perfil").toString().equals("admin")) {%>
                                <a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=listhistoria&txtId=<%=usuario.getId()%>"><h3>Citas Programadas</h3></a>
                                <a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=histobyDoc&txtId=<%=usuario.getId()%>"><h3>Ver Atenciones Realizadas</h3></a>
                                <%}%>
                                <% if (sessionOK.getAttribute("perfil").toString().equals("usuario") || sessionOK.getAttribute("perfil").toString().equals("admin")) {%>
                                <a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=listarEsp"><h3>Modulo de registro de citas</h3></a>
                                <a href=""><h3>Modulo Usuario 2</h3></a>
                                <%}%>
                                <% if (sessionOK.getAttribute("perfil").toString().equals("admin")) {%>
                                <a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=listar"><h3>Mantenimiento de datos Usuarios</h3></a>
                                <a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=listarDoc2"><h3>Gestionar datos de doctores</h3></a>
                                <%}%>
                                <% } else {%>
                                <h3>El usuario se encuentra desactivado, comuniquese con el administrador</h3>
                                <div class="boton"><a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=logout">Cerrar Sesión</a></div>
                                <%}%>   


                            </div>
                        </div>
                    </div>
                </div>

            </section>
            <%@include file="WEB-INF/jspf/caside.jspf"%>
            <%@include file="WEB-INF/jspf/cfooter.jspf"%>
        </div>
    </body>
    <%@include file="WEB-INF/jspf/cjs.jspf"%>
</html>
