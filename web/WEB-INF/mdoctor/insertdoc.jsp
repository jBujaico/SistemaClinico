<%
    String id = request.getSession().getAttribute("iddoc").toString();
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

        <%@include file="../jspf/cheader.jspf"%>
        <%@include file="../jspf/cnav.jspf"%>
        <div class="container-fuid">
            <div class="row">
                <div class="col-lg-10 offset-lg-1" >
                    <div class="card">
                        <h5 class="card-header">Doctores</h5>
                        <div class="card-body">
                            <form action="usuarioController.do" method="POST" onsubmit="return validarRegister();">
                                <div class="form-group">
                                    <input type="hidden" name="txtProceso" value="insertDoc2">
                                </div>
                                <div class="form-group">
                                    <label for="txtId">Id</label>
                                    <input type="text" class="form-control" name="txtId" id="txtId" value="<%=id%>">                            
                                </div>
                                <div class="form-group">
                                    <label for="txtEspecialidad">Especialidad</label>
                                    <input type="text" class="form-control" name="txtEspecialidad" id="txtEspecialidad" placeholder="Ingrese Especialidad">                            
                                </div> 
                                <div class="form-group">
                                    <label for="txtTelefono">Telefono</label>
                                    <input type="text" class="form-control" name="txtTelefono" id="txtTelefono" placeholder="Ingrese su Telefono">                            
                                </div>
                                <button type="submit" class="btn btn-danger">Agregar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
        <%@include file="../jspf/cfooter.jspf"%>
    </body>
    <%@include file="../jspf/cjs.jspf"%>
</html>

