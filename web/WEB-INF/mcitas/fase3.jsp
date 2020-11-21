<%-- 
    Document   : fase3
    Created on : 04/03/2020, 06:57:06 AM
    Author     : Jerson
--%>
<%@page import="com.miempresa.dtos.Doctor"%>
<%
    Doctor doctor = (Doctor) request.getSession().getAttribute("doctor");
    String nomuser = request.getSession().getAttribute("nombreuser").toString();
    int iduser = Integer.parseInt(request.getSession().getAttribute("iduser").toString());
    String apeuser = request.getSession().getAttribute("apeuser").toString();

%>
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
                        <h5 class="card-header">Paso 3</h5>
                        <div class="card-body">
                            <form method="POST" action="usuarioController.do">
                                <div class="form-group">
                                    <input type="hidden" value="registercita" name="txtProceso">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" value="<%=iduser%>" name="txtIdUser">
                                </div> 
                                <div class="form-group">
                                    <input type="text" class="form-control" value="<%=nomuser%>" name="txtNomUser">
                                </div>     
                                <div class="form-group">
                                    <input type="text" class="form-control" value="<%=apeuser%>" name="txtApeUser">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" value="<%=doctor.getId()%>" name="txtIdDoc">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" value="<%=doctor.getNombre()%>" name="txtNomDoc">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" value="<%=doctor.getApellido()%>" name="txtApeDoc">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" value="<%=doctor.getEspecialidad()%>" name="txtEspec">
                                </div>
                                <div class="form-group">
                                    <input type="date" class="form-control" name="txtFecha">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-danger">Registrar cita</button>
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
