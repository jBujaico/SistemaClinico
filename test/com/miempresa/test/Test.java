
package com.miempresa.test;

import com.miempresa.connection.ConnectionBD;
import com.miempresa.daos.DoctorDAO;
import com.miempresa.daos.UsuarioDAO;
import com.miempresa.dtos.Doctor;
import com.miempresa.dtos.Usuario;
import java.util.ArrayList;

/**
 *
 * @author BUJAICO PACHECO JERSON KEVIN
 */
public class Test {
    public static void main(String[] args) {
        ConnectionBD.newConnection();
//        Usuario usuario=new Usuario();
//        
//        usuario.setNombre("Jerson");
//        usuario.setApellido("Pacheco");
//        usuario.setDni(7219562);
//        usuario.setFechanac("20-05-2020");
//        usuario.setSexo("Masculino");
//        usuario.setCorreo("jkbujaico1@gmail.com");
//        usuario.setClave("123");
//        usuario.setPregunta("Cual es el nombre de su perro");
//        usuario.setRespuesta("fido");
//        usuario.setPerfil("admin");
////        
//        UsuarioDAO usuarioDAO = new UsuarioDAO();
//       if (usuarioDAO.insert(usuario)) {
//           System.out.println("Se inserto");
//      } else {
//           System.out.println("No se inserto");
//       }
//           DoctorDAO doctorDAO=new DoctorDAO();
//           ArrayList<Doctor> doctores=doctorDAO.listar();
//          // System.out.println(doctores);
//           for (Doctor doctor : doctores) {
//               System.out.println(doctor.getNombre());
//               System.out.println(doctor.getApellido());
//
//        }
        
        
    }
     
}
