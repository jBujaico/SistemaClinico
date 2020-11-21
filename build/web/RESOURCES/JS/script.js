function validarRegister(){
    var nombre=document.getElementById("txtNombre").value;
    var apellido = document.getElementById("txtApellido").value;
    var dni =document.getElementById("txtDNI").value;
    var fechanac =document.getElementById("txtFechanac").value;
    var sexo =document.getElementById("txtSexo").value;    
    var correo=document.getElementById("txtCorreo").value;    
    var clave=document.getElementById("txtClave").value;
    var clave2= document.getElementById("txtClave2").value;
    var pregunta= document.getElementById("txtPregunta").value;
    var respuesta=document.getElementById("txtRespuesta").value;
    var chkTerminos=document.getElementById("chkTerminos").checked;
    
    if(nombre===""||nombre.lenght===0){
        alert("Deberá de completar el campo nombre(s)");
        document.getElementById("txtNombre").focus();
        return false;
    }
    else if(apellido==="" || apellido.length===0){
        alert("Deberá de completar el campo apellidos(s)");
        document.getElementById("txtApellido").value;
        return false;
    }
    
    else if(dni==="" || dni.length===0){
        alert("Deberá de completar el campo DNI");
        document.getElementById("txtDNI").value;
        return false;
    }
    
    else if(fechanac==="" || fechanac.length===0){
        alert("Deberá de completar el campo fecha de nacimiento");
        document.getElementById("txtFechanac").value;
        return false;
    }
    
    else if(sexo==="elegir"){
        alert("Deberá de completar el sexo");
        document.getElementById("txtSexo").value;
        return false;
    }
    
    else if(correo==="" || correo.length===0){
        alert("Deberá de completar el campo correo");
        document.getElementById("txtCorreo").value;
        return false;
    }
    
    else if(clave==="" || clave.length===0){
        alert("Deberá de completar el campo clave");
        document.getElementById("txtClave").value;
        return false;
    }
    
    else if(clave2==="" || clave2.length===0){
        alert("Deberá de completar el campo repetir clave");
        document.getElementById("txtClave2").value;
        return false;
    }
    
    else if(clave!==clave2){
        alert("Las contraseñas deben de ser iguales");
        document.getElementById("txtClave").value;
        return false;
    }
    
    else if(pregunta==="elegir"){
        alert("Deberá de completar el campo pregunta secreta");
        document.getElementById("txtPregunta").value;
        return false;
    }
    
    else if(respuesta==="" || respuesta.length===0){
        alert("Deberá de completar el campo respuesta secreta");
        document.getElementById("txtRespuesta").value;
        return false;
    }
    
    else if(!chkTerminos){
        alert("Deberá de aceptar los términos y condiciones");
        document.getElementById("chkTerminos").focus();
        return false;
    }
}

function validarLogin(){
    var correo=document.getElementById("txtCorreo").value;
    var clave= document.getElementById("txtClave").value;
    
    if(correo==="" || correo.length===0){
        alert("Deberá de completar el campo correo");
        document.getElementById("txtCorreo");
        return false;
    }
    
    else if(clave==="" || clave.length===0){
        alert("Deberá de completar el campo clave");
        document.getElementById("txtClave");
        return false;
    }
    
    
}

function prueba(){
    var id=$("#txtId").val();
    console.log(id);
}

function actualizarEstado(valor,numid){ 
    var estado=valor;
    var id=numid;
    var confirmar=confirm("Esta seguro de cambiar de estado");
    console.log(numid);
    if(confirmar){
       $.ajax({
        
         /*Metodo de envio, puede ser GET o POST*/
         type:'post',
         /*El destino, hacia donde voy a enviar los datos*/
         url:'usuarioController.do?txtProceso=actEstado',
         /*Datos a enviar para procesar*/
         data:{
           txtEstado:estado,
           txtId:id
         },
         beforeSend: function (xhr) {
           $("#icono").fadeIn(function(){
                $("#icono").html("<h2>Procesandose</h2>");
           }); 
         },
         /*Se ejecuta y la transaccion se ha realizado correctamente */
         success:function(valor){
             if (valor==1) {
                console.log(valor);
                alert("Se actualizaron los datos")
            } else {
               alert("No se actualizaron los datos")
                console.log(valor); 
            }
         },
         /*Se ejecuta cuando hay un error 505,404 */
         error:function(xlr,status){
            alert("No se ha realizar la transaccion"+status); 
         },
         complete:function(xlr,status){
             /*alert("Completado correctamente");*/
             $("#icono").fadeOut();
             
         }     
     });           
    }       
}