/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.controllers;

import com.miempresa.daos.CitasDAO;
import com.miempresa.daos.DoctorDAO;
import com.miempresa.daos.HistoCitasDAO;
import com.miempresa.daos.UsuarioDAO;
import com.miempresa.dtos.Citas;
import com.miempresa.dtos.Doctor;
import com.miempresa.dtos.HistoCitas;
import com.miempresa.dtos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SANDRA
 */
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String proceso = request.getParameter("txtProceso");

        switch (proceso) {
            case "registro":
                registerUser(request, response);
                break;
            case "login":
                loginUser(request, response);
                break;
            case "recovery":
                recoveryPssw(request, response);
                break;
            case "recovery2":
                recoveryPssw2(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            case "listar":
                listar(request, response);
                break;
            case "detalle":
                detail(request, response);
                break;
            case "editar":
                editar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "registrobyAdmin":
                registrobyAdmin(request, response);
                break;
            case "actEstado":
                actEstado(request, response);
                break;
            case "listarDoc":
                listarDoc(request, response);
                break;
            case "listarDoc2":
                listarDoc2(request, response);
                break;
            case "insertDoc":
                insertDoc(request, response);
                break;
            case "deleteDoc":
                deleteDoc(request, response);
                break;
            case "listarEsp":
                listarEsp(request, response);
                break;
            case "filtrarDoc":
                filtrarDoc(request, response);
                break;
            case "datoscita":
                datoscita(request, response);
                break;
            case "registercita":
                registercita(request, response);
                break;
            case "listhistoria":
                listhistoria(request, response);
                break;

            case "resgisterHistorial":
                resgisterHistorial(request, response);
                break;
                
            case "histobyDoc":
                histobyDoc(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /* private void prueba(String variable){
        System.out.println(""+variable);
    }*/
    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int dni = Integer.parseInt(request.getParameter("txtDNI"));
        String fechanac = request.getParameter("txtFechanac");
        String sexo = request.getParameter("txtSexo");
        String correo = request.getParameter("txtCorreo");
        String clave = request.getParameter("txtClave2");
        String pregunta = request.getParameter("txtPregunta");
        String respuesta = request.getParameter("txtRespuesta");
        String perfil = request.getParameter("txtPerfil");

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDni(dni);
        usuario.setFechanac(fechanac);
        usuario.setSexo(sexo);
        usuario.setCorreo(correo);
        usuario.setClave(clave);
        usuario.setPregunta(pregunta);
        usuario.setRespuesta(respuesta);
        usuario.setPerfil(perfil);

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        if (usuarioDAO.insert(usuario)) {
            String mensaje = "Registro de usuario exitoso";
            request.getSession().setAttribute("mensaje", mensaje);
            request.getSession().setAttribute("proceso", "registro");
            request.getRequestDispatcher("exito.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("txtCorreo");
        String clave = request.getParameter("txtClave");

        HttpSession sessionOK = request.getSession();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.login(correo, clave);

        if (usuario != null) {
            sessionOK.setAttribute("perfil", usuario.getPerfil());
            sessionOK.setAttribute("estado", usuario.getEstado());
            request.getSession().setAttribute("usuario", usuario);
            request.getRequestDispatcher("bienvenido.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    private void recoveryPssw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("txtCorreo");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.recovery(correo);

        if (usuario != null) {
            String pregunta = usuario.getPregunta();

            request.getSession().setAttribute("pregunta", pregunta);
            request.getRequestDispatcher("recuperar2.jsp").forward(request, response);
        } else {
            // VAMOS A MOSTRAR UN MENSAJE
            // DE ERROR INDICANDO QUE NO EXISTE LA  CLAVE
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    private void recoveryPssw2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String respuesta = request.getParameter("txtRespuesta");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.recovery2(respuesta);

        if (usuario != null) {
            String clave = usuario.getClave();

            request.getSession().setAttribute("clave", clave);
            request.getRequestDispatcher("recuperar3.jsp").forward(request, response);
        } else {
            // VAMOS A MOSTRAR UN MENSAJE
            // DE ERROR INDICANDO QUE NO EXISTE LA  CLAVE
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessionOK = request.getSession();

        sessionOK.removeAttribute("perfil");
        sessionOK.removeAttribute("estado");
        sessionOK.invalidate();
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<Usuario> usuarios = usuarioDAO.selectAll();
        request.getSession().setAttribute("lista", usuarios);
        request.getRequestDispatcher("WEB-INF/musuario/list.jsp").forward(request, response);
        request.getRequestDispatcher("ejemplo.jsp").forward(request, response);
    }

    public void listarDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorDAO doctorDAO = new DoctorDAO();
        ArrayList<Doctor> doctores = doctorDAO.listar();
        request.getSession().setAttribute("listaDoc", doctores);
        request.getRequestDispatcher("doctores.jsp").forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("txtCorreo");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario = usuarioDAO.selectByMail(correo);
        request.getSession().setAttribute("usuario", usuario);
        request.getRequestDispatcher("WEB-INF/musuario/edit.jsp").forward(request, response);
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int dni = Integer.parseInt(request.getParameter("txtDni"));
        String fechanac = request.getParameter("txtFechanac");
        String sexo = request.getParameter("txtSexo");
        String correo = request.getParameter("txtCorreo");
        String clave = request.getParameter("txtClave");
        String pregunta = request.getParameter("txtPregunta");
        String respuesta = request.getParameter("txtRespuesta");
        String perfil = request.getParameter("txtPerfil");
        int estado = Integer.parseInt(request.getParameter("txtEstado"));

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDni(dni);
        usuario.setFechanac(fechanac);
        usuario.setSexo(sexo);
        usuario.setCorreo(correo);
        usuario.setClave(clave);
        usuario.setPregunta(pregunta);
        usuario.setRespuesta(respuesta);
        usuario.setPerfil(perfil);
        usuario.setEstado(estado);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (usuarioDAO.update(usuario)) {
            String mensaje = "Actualizacion de usuario exitoso";
            request.getSession().setAttribute("mensaje", mensaje);
            request.getSession().setAttribute("proceso", "actualizacion");
            listar(request, response);
            request.getRequestDispatcher("WEB-INF/musuario/list.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    private void registrobyAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int dni = Integer.parseInt(request.getParameter("txtDNI"));
        String fechanac = request.getParameter("txtFechanac");
        String sexo = request.getParameter("txtSexo");
        String correo = request.getParameter("txtCorreo");
        String clave = request.getParameter("txtClave2");
        String pregunta = request.getParameter("txtPregunta");
        String respuesta = request.getParameter("txtRespuesta");
        String perfil = request.getParameter("txtPerfil");

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDni(dni);
        usuario.setFechanac(fechanac);
        usuario.setSexo(sexo);
        usuario.setCorreo(correo);
        usuario.setClave(clave);
        usuario.setPregunta(pregunta);
        usuario.setRespuesta(respuesta);
        usuario.setPerfil(perfil);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (usuarioDAO.insert(usuario)) {
            listar(request, response);
            request.getRequestDispatcher("WEB-INF/musuario/list.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("txtCorreo");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario = usuarioDAO.selectByMail(correo);
        request.getSession().setAttribute("usuario", usuario);
        request.getRequestDispatcher("WEB-INF/musuario/detail.jsp").forward(request, response);
    }

    private void actEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("txtId");
            String estado = request.getParameter("txtEstado");

            UsuarioDAO usuarioDAO = new UsuarioDAO();

            Boolean resultado = usuarioDAO.actualizarEstado(Integer.parseInt(id), Integer.parseInt(estado));
            if (resultado == true) {
                out.println(1);
            } else {
                out.println(0);
            }

        }
    }

    private void listarDoc2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorDAO doctorDAO = new DoctorDAO();
        ArrayList<Doctor> doctores = doctorDAO.listar();
        request.getSession().setAttribute("listaDoc", doctores);
        request.getRequestDispatcher("WEB-INF/mdoctor/listdoc.jsp").forward(request, response);
    }

    private void insertDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("txtId"));
        request.getSession().setAttribute("iddoc", id);
        request.getRequestDispatcher("WEB-INF/mdoctor/insertdoc.jsp").forward(request, response);
    }

    private void insertDoc2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("txtId"));
        String especialidad = request.getParameter("txtEpecialidad");
        int telefono = Integer.parseInt(request.getParameter("txtTelefono"));

        Doctor doctor = new Doctor();
        doctor.setId(id);
        doctor.setEspecialidad(especialidad);
        doctor.setTelefono(telefono);

        DoctorDAO doctorDAO = new DoctorDAO();
        if (doctorDAO.insert(doctor)) {
            listarDoc2(request, response);
            request.getRequestDispatcher("WEB-INF/mdoctor/listdoc.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    private void deleteDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("txtId"));
        Doctor doctor = new Doctor();
        doctor.setId(id);
        DoctorDAO doctorDAO = new DoctorDAO();
        if (doctorDAO.delete(doctor) == 1) {
            listarDoc2(request, response);
            request.getRequestDispatcher("WEB-INF/mdoctor/listdoc.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    private void listarEsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorDAO doctorDAO = new DoctorDAO();
        ArrayList<Doctor> especialidades = doctorDAO.listarEsp();
        request.getSession().setAttribute("especialidades", especialidades);
        request.getRequestDispatcher("WEB-INF/mcitas/fase1.jsp").forward(request, response);
    }

    private void filtrarDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String especialidad = request.getParameter("txtEspecialidad");

        DoctorDAO doctorDAO = new DoctorDAO();
        ArrayList<Doctor> doctoresEsp = doctorDAO.filtrarDoc(especialidad);
        request.getSession().setAttribute("doctoresEsp", doctoresEsp);
        request.getRequestDispatcher("WEB-INF/mcitas/fase2.jsp").forward(request, response);

    }

    private void datoscita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int iddoctor = Integer.parseInt(request.getParameter("txtIdDoctor"));

        DoctorDAO doctorDAO = new DoctorDAO();
        Doctor doctor = doctorDAO.selectbyid(iddoctor);

        if (doctor != null) {

            request.getSession().setAttribute("doctor", doctor);
            request.getRequestDispatcher("WEB-INF/mcitas/fase3.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void registercita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int iduser = Integer.parseInt(request.getParameter("txtIdUser"));
        String nomuser = request.getParameter("txtNomUser");
        String apeuser = request.getParameter("txtApeUser");
        int iddoctor = Integer.parseInt(request.getParameter("txtIdDoc"));
        String nomdoc = request.getParameter("txtNomDoc");
        String apedoc = request.getParameter("txtApeDoc");
        String especialidad = request.getParameter("txtEspec");
        String fecha = request.getParameter("txtFecha");

        Citas cita = new Citas();
        cita.setIduser(iduser);
        cita.setNomuser(nomuser);
        cita.setApeuser(apeuser);
        cita.setIddoctor(iddoctor);
        cita.setNomdoctor(nomdoc);
        cita.setApedoctor(apedoc);
        cita.setEspecialidad(especialidad);
        cita.setFecha(fecha);

        CitasDAO citasDAO = new CitasDAO();
        if (citasDAO.insert(cita)) {
            //listar(request, response);
            request.getRequestDispatcher("WEB-INF/mcitas/registro.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void listhistoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int iddoctor = Integer.parseInt(request.getParameter("txtId"));

        CitasDAO citasDAO = new CitasDAO();
        ArrayList<Citas> citas = citasDAO.ListCitas(iddoctor);
        request.getSession().setAttribute("listCitas", citas);
        request.getRequestDispatcher("WEB-INF/mhistoriales/listhis.jsp").forward(request, response);

    }

    private void resgisterHistorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int codcita = Integer.parseInt(request.getParameter("txtCodCita"));
        String observaciones = request.getParameter("txtObservaciones");

        HistoCitas histocitas = new HistoCitas();
        histocitas.setCodcita(codcita);
        histocitas.setObservaciones(observaciones);

        HistoCitasDAO histocitasDAO = new HistoCitasDAO();
        if (histocitasDAO.insert(histocitas)) {
            //listar(request, response);
            request.getRequestDispatcher("WEB-INF/mhistoriales/listobserva.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    private void histobyDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int iddoctor=Integer.parseInt(request.getParameter("txtId"));
        
        HistoCitasDAO histocitasDAO = new HistoCitasDAO();
        ArrayList<HistoCitas> histocitas = histocitasDAO.historiales(iddoctor);
        request.getSession().setAttribute("histocitas", histocitas);
        request.getRequestDispatcher("WEB-INF/mhistoriales/histobyDoc.jsp").forward(request, response);
        
    }

}
