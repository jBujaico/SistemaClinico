<%-- 
    Document   : especialidades
    Created on : 22/01/2020, 07:15:15 PM
    Author     : JERSON BUJAICO PACHECO
--%>
<%
    String clave = request.getSession().getAttribute("clave").toString();
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
            <div class="registro-fondo">
                <div class="row">
                    <div class="col-lg-4 offset-lg-4">
                        <div class="card">
                            <h5 class="card-header"><%=clave%></h5>                            
                        </div>
                        <a href="login.jsp"><button type="button" class="btn btn-success">Iniciar Sesión</button></a>
                    </div>
                </div>
            </div>
            <%@include file="WEB-INF/jspf/caside.jspf"%>
            <%@include file="WEB-INF/jspf/cfooter.jspf"%>
        </div>
    </body>
    <%@include file="WEB-INF/jspf/cjs.jspf"%>
</html>
