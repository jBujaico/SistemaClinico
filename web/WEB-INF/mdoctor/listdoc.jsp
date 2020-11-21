<%-- 
    Document   : list
    Created on : 14/02/2020, 07:05:36 PM
    Author     : C19255
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <script>console.log("hola");</script>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-10 offset-lg-1" >
                        <div class="card">
                            <h5 class="card-header">Doctores</h5>
                            <div class="card-body">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Especialidad</th> 
                                            <th>Eliminar</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Especialidad</th>
                                            <th>Eliminar</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>

                                        <c:forEach var="doctores" items="${sessionScope.listaDoc}">
                                            <tr>
                                                <td>${doctores.id}</td>
                                                <td>${doctores.nombre}</td>
                                                <td>${doctores.apellido}</td>
                                                <td>${doctores.especialidad}</td>
                                                <td hidden=""><a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=insertDoc&txtId=${doctores.id}"><button type="button" class="btn btn-success"><i class="fas fa-user-edit"></i>&nbsp;Editar</button></a></td>
                                                <td><a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=deleteDoc&txtId=${doctores.id}"><button type="button" class="btn btn-danger"><i class="fas fa-user-minus"></i>&nbsp;Eliminar</button></a></td>
                                            </c:forEach>    
                                    </tbody>
                                </table>
                            </div>
                        </div> 
                    </div>

                </div>
            </div>
        </section>
        <%@include file="../jspf/cfooter.jspf"%>
        <%@include file="../jspf/cjs.jspf"%>
    </body>
</html>

