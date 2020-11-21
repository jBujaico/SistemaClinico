

<%@page import="com.miempresa.dtos.Usuario"%>
<%

    Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../jspf/cmeta.jspf"%>
        <title>JSP Page</title>
        <%@include file="../jspf/cstyles.jspf"%>
    </head>
    <body>

        <%@include file="../jspf/cheader.jspf"%>
        <%@include file="../jspf/cnav.jspf"%>
        <section>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-4 offset-lg-4">
                        <div class="card">
                            <h5 class="card-header">Actualizar usuario</h5>
                            <div class="card-body">
                                <form action="usuarioController.do" method="POST" onsubmit="return validarFormularioLogin();" >
                                    <div class="form-group">
                                        <input type="hidden" name="txtProceso" value="actualizar">
                                    </div>
                                    <div class="form-group">
                                        <input type="hidden" name="txtId" value="<%=usuario.getId()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtNombre">Nombre</label>
                                        <input type="text" class="form-control" value="<%=usuario.getNombre()%>" name="txtNombre" id="txtNombre" placeholder="Ingresar Nombre">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtApellido">Apellido</label>
                                        <input type="text" class="form-control" value="<%=usuario.getApellido()%>" name="txtApellido" id="txtApellido" placeholder="Ingresar Apellido">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtDni">DNI</label>
                                        <input type="text" class="form-control" value="<%=usuario.getDni()%>" name="txtDni" id="txtDni" placeholder="Ingresar DNI">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtFechanac">Fecha de nacimiento</label>
                                        <input type="text" class="form-control" value="<%=usuario.getFechanac()%>" name="txtFechanac" id="txtFechanac" placeholder="Ingresar Fecha de nacimiento">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtSexo">Sexo</label>
                                        <input type="text" class="form-control" value="<%=usuario.getSexo()%>" name="txtSexo" id="txtSexo" placeholder="Ingresar Sexo">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtCorreo">Correo</label>
                                        <input type="email" class="form-control" name="txtCorreo" value="<%=usuario.getCorreo()%>" id="txtCorreo" placeholder="Ingresar correo">
                                    </div>
                                    <div class="form-group">
                                        <label for="txtClave">Clave</label>
                                        <input type="password" onkeyup="ocultar()" class="form-control" value="<%=usuario.getClave()%>" name="txtClave" id="txtClave" placeholder="Ingresar clave">
                                        <div id="mensaje"></div>
                                    </div>
                                     <div class="form-group">
                                        <label for="txtPreguntaOld">Pregunta Anterior</label>
                                        <input type="text" class="form-control" name="txtPreguntaOld" value="<%=usuario.getPregunta()%>" id="txtPreguntaOld" placeholder="Pregunta Anterior">
                                    </div>   
                                    <div class="form-group">
                                        <label for="txtPregunta">Seleccione nueva pregunta</label>
                                        <select name="txtPregunta" id="txtPregunta" class="form-control">
                                            <option value="Nombre de Mascota">Nombre de Mascota</option>
                                            <option value="Pelicula favorita">Pelicula favorita</option>
                                            <option value="Serie favorita">Serie favorita</option>
                                            <option value="Equipo de Futbol" selected="">Equipo de Futbol</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="txtRespuesta">Respuesta</label>
                                        <input type="text" class="form-control" name="txtRespuesta" value="<%=usuario.getRespuesta()%>" id="txtRespuesta" placeholder="Ingresar respuesta">
                                    </div>
                                    <div class="form-group">
                                        <input type="hidden" class="form-control" id="txtPerfil" name="txtPerfil" value="<%=usuario.getPerfil()%>" >
                                    </div>
                                    <div class="form-group">
                                        <input type="hidden" class="form-control" id="txtEstado" name="txtEstado" value="<%=usuario.getEstado()%>" >
                                    </div>
                                    <button type="submit" class="btn btn-primary">Actualizar</button>
                                    <button type="reset" class="btn btn-success">Restablecer</button>
                                    <a href="<%=request.getContextPath()%>/usuarioController.do?txtProceso=listar"><button type="button" class="btn btn-danger">Cancelar</button></a>
                                </form>
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

