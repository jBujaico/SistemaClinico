<!-- Modal insertar -->
<div class="modal fade" id="insertar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Registrar persona</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- cuerpo del modal (form)-->
                <form action="usuarioController.do" method="POST" onsubmit="return validarRegister();">
                    <div class="form-group">
                        <input type="hidden" name="txtProceso" value="registrobyAdmin">
                    </div>
                    <div class="form-group">
                        <label for="txtNombre">Nombre(s)</label>
                        <input type="text" class="form-control" name="txtNombre" id="txtNombre" placeholder="Ingrese su nombre(s)">                            
                    </div>
                    <div class="form-group">
                        <label for="txtApellido">Apellidos</label>
                        <input type="text" class="form-control" name="txtApellido" id="txtApellido" placeholder="Ingrese sus apellidos">                            
                    </div> 
                    <div class="form-group">
                        <label for="txtDNI">DNI</label>
                        <input type="text" class="form-control" name="txtDNI" id="txtDNI" placeholder="Ingrese su DNI">                            
                    </div>
                    <div class="form-group">
                        <label for="txtFechanac">Fecha de nacimiento</label>
                        <input type="date" class="form-control" name="txtFechanac" id="txtFechanac">                            
                    </div>
                    <div class="form-group">
                        <label for="txtSexo">Sexo</label>
                        <select class="form-control" id="txtSexo" name="txtSexo">
                            <option value="elegir" selected="">Elegir</option>
                            <option value="masculino">Masculino</option>
                            <option value="femenino">Femenino</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="txtCorreo">Correo</label>
                        <input type="email" class="form-control" name="txtCorreo" id="txtCorreo" placeholder="Ingrese su correo">
                    </div>
                    <div class="form-group">
                        <label for="txtClave">Clave</label>
                        <input type="password" class="form-control" name="txtClave" id="txtClave" placeholder="Ingrese su clave">
                    </div>
                    <div class="form-group">
                        <label for="txtClave2">Repetir Clave</label>
                        <input type="password" class="form-control" name="txtClave2" id="txtClave2" placeholder="Repita su clave">
                    </div> 
                    <div class="form-group">
                        <label for="txtPregunta">Pregunta secreta</label>
                        <select id="txtPregunta" name="txtPregunta" class="form-control">
                            <option value="elegir" selected="">Elija una de las opciones</option>
                            <option value="cual es el nombre de su mascota">¿Cúal es el nombre de su mascota?</option>
                            <option value="cual es el nombre de su padre">¿Cúal es el nombre de su padre?</option>
                            <option value="cual es el nombre de su madre">¿Cúal es el nombre de su madre?</option>
                            <option value="cuando es su cumpleaños">¿Cúando es su cumpleaños?</option>
                        </select>                       
                    </div>
                    <div class="form-group">
                        <label for="txtRespuesta">Respuesta secreta</label>
                        <input type="text" class="form-control" id="txtRespuesta" name="txtRespuesta" placeholder="Ingresar respuesta">
                    </div>   
                    <div class="form-group">
                        <label for="txtPerfil">Seleccione perfil</label>
                        <select id="txtPerfil" name="txtPerfil" class="form-control">
                            <option value="elegir" selected="">Elija una de las opciones</option>
                            <option value="admin">admin</option>
                            <option value="doctor">doctor</option>
                            <option value="admin">usuario</option>
                        </select>
                    </div>
                    <div class="modal-footer">                        
                        <button type="submit" class="btn btn-primary">Registrar usuario</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
