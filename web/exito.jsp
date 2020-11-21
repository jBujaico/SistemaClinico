

<%-- 
    Document   : especialidades
    Created on : 22/01/2020, 07:15:15 PM
    Author     : JERSON BUJAICO PACHECO
--%>
<% 
String mensaje = request.getSession().getAttribute("mensaje").toString();
String proceso= request.getSession().getAttribute("proceso").toString();
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
                    <div class="col-12 col-sm-6 col-lg-6 offset-lg-3">
                        <div class="card">
                            <h5 class="card-header">Mensaje de Transacción realizada</h5>
                            <div class="card-body">
                                <h4><%=mensaje%></h4>
                                <% if (proceso.equals("registro")) {%>
                                <br>
                                <a href="login.jsp"><button type="button" class="btn btn-success">Iniciar Sesión</button></a>
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
