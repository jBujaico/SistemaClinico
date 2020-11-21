<%-- 
    Document   : list
    Created on : 14/02/2020, 07:05:36 PM
    Author     : C19255
--%>
<%@page import="com.miempresa.dtos.Usuario"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include  file="../jspf/cmeta.jspf"%>
        <title>JSP Page</title>
        <%@include file="../jspf/cstyles.jspf"%>
    </head>
    <body>

        <%@include file="../jspf/cheader.jspf"%>
        <%@include file="../jspf/cnav.jspf"%>
        <section>
            <div class="alert alert-secondary" role="alert">
                <a href="<%=request.getContextPath()%>/bienvenido.jsp"><button type="button" class="btn btn-outline-success">Menu principal</button></a>
                <a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=logout"><button type="button" class="btn btn-outline-secondary">Cerrar sesión</button></a>                
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-10 offset-lg-1" >
                        <div class="card">
                            <h5 class="card-header">Usuarios</h5>
                            <div class="card-body">
                                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertar">
                                    Nuevo usuario
                                </button>  

                                <br>
                                <br>
                                <%@include file="../musuario/insert.jsp"%>

                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Correo</th>
                                            <th>Perfil</th>
                                            <th>Detalle</th>
                                            <th>Editar</th>
                                            <th>Eliminar</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Correo</th>
                                            <th>Perfil</th>
                                            <th>Detalle</th>
                                            <th>Editar</th>
                                            <th>Eliminar</th>
                                            <th></th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach var="usuarios" items="${sessionScope.lista}">
                                            <tr>
                                                <td>${usuarios.nombre}</td>
                                                <td>${usuarios.correo}</td>
                                                <td>${usuarios.perfil}</td>
                                                <td><a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=detalle&txtCorreo=${usuarios.correo}"><button type="button" class="btn btn-primary"><i class="fas fa-info-circle"></i>&nbsp;Detalle</button></a></td>
                                                <td><a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=editar&txtCorreo=${usuarios.correo}"><button type="button" class="btn btn-success"><i class="fas fa-user-edit"></i>&nbsp;Editar</button></a></td>
                                                <td><button type="button" class="btn btn-danger" onclick="actualizarEstado(0,${usuarios.id})"><i class="fas fa-user-minus"></i>&nbsp;Dar de baja</button></td>                                             
                                                <td><button type="button" class="btn btn-danger" onclick="actualizarEstado(1,${usuarios.id})"><i class="fas fa-user-minus"></i>&nbsp;Dar de alta</button></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </section>
        <%@include file="../jspf/caside.jspf"%>
        <%@include file="../jspf/cfooter.jspf"%>

        <%@include file="../jspf/cjs.jspf"%>
    </body>
</html>

