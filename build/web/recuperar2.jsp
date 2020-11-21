<%-- 
    Document   : especialidades
    Created on : 22/01/2020, 07:15:15 PM
    Author     : JERSON BUJAICO PACHECO
--%>
<% 
String pregunta= request.getSession().getAttribute("pregunta").toString();
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
                            <h5 class="card-header"><%=pregunta%></h5>
                            <div class="card-body">
                                <form action="usuarioController.do" method="POST" onsubmit="" >
                                    <div class="form-group">
                                        <input type="hidden" name="txtProceso" value="recovery2">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtRespuesta">Respuesta</label>
                                        <input type="text" class="form-control" id="txtRespuesta" name="txtRespuesta" placeholder="Ingresar su respuesta">
                                    </div>

                                    <button type="submit" class="btn btn-primary">Recuperar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="WEB-INF/jspf/caside.jspf"%>
            <%@include file="WEB-INF/jspf/cfooter.jspf"%>
        </div>
    </body>
    <%@include file="WEB-INF/jspf/cjs.jspf"%>
</html>