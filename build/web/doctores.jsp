<%@page import="com.miempresa.dtos.Doctor"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/cmeta.jspf"%>
        <title>JSP Page</title>
        <%@include file="WEB-INF/jspf/cstyles.jspf"%>
    </head>
    <body>

        <%@include file="WEB-INF/jspf/cheader.jspf"%>
        <%@include file="WEB-INF/jspf/cnav.jspf"%>
        <div class="container-fluid">
            <section>
                <!--<div class="row">
                    <div class="col-sm-6">
                        <div class="card text-center">
                            <div class="card-body">
                                <h5 class="card-title">Special title treatment</h5>
                                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                                <a href="#" class="btn btn-primary">Go somewhere</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Special title treatment</h5>
                                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                                <a href="#" class="btn btn-primary">Go somewhere</a>
                            </div>
                        </div>
                    </div>
                </div>-->

                <c:forEach var="doctores" items="${sessionScope.listaDoc}">
                    <div class="row">
                        <div class="col-lg-8 offset-lg-2 col-sm-6">
                            <div class="card text-center">
                                <div class="card-body">
                                    <h5 class="card-title"> Nombre y Apellido: ${doctores.nombre} ${doctores.apellido} </h5>
                                    <h5 class="card-title"> Correo: ${doctores.correo}</h5>
                                    <h5 class="card-title"> Especialidad: ${doctores.especialidad}</h5>
                                    <p class="card-text">With supporting text below as a natural lead-in to additional content.
                                        With supporting text below as a natural lead-in to additional content.
                                        With supporting text below as a natural lead-in to additional content.</p>
                                    <a href="#" class="btn btn-primary">Go somewhere</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach> 

            </section>
        </div>
        <br>
        <%@include file="WEB-INF/jspf/cfooter.jspf"%>

        <%@include file="WEB-INF/jspf/cjs.jspf"%>
    </body>
</html>
