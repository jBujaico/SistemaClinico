package com.miempresa.daos;

import com.miempresa.connection.ConnectionBD;
import com.miempresa.dtos.Doctor;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorDAO {

    // CONEXION A LA BASE DE DATOS GESTIONADA POR LA CLASE CONECTIONBD
    private static ConnectionBD con = ConnectionBD.newConnection();
    // REALIZAR LAS CONSULTAS A LA BASE DE DATOS CON PREPARESTATEMENT
    private static PreparedStatement pstm = null;
    // PARA ALMACENAR EL RESULTADO DE LA CONSULTA REALIZADA
    private static ResultSet res = null;
    // DEFINIR LOS QUERYS
    private static final String SQL_SELECT = "select u.id,nombre,apellido,correo,nombesp,telefono\n"
            + "from usuario u, doctor d\n"
            + "where u.id=d.id_doctor";
    private static final String SQL_SELECT_DOCTOR = "select u.id,nombre,apellido,nombesp  from usuario u, doctor d\n"
            + "where perfil ='doctor'";
    private static final String SQL_INSERT = "insert into doctor values(?,?,?)";
    private static final String SQL_UPDATE = "update doctor set nombre_dc=?,apellido_dc=?,correo_dc=?,telefono_dc=?,\n"
            + "saldo=? where id_doctor=?";
    private static final String SQL_DELETE = "delete from doctor where id_doctor=?";
    private static final String SELECT_ESP = "select distinct nombesp from doctor ";
    private static final String FILTRAR_DOC = "select d.id_doctor,nombre,apellido from usuario u,doctor d\n"
            + "where u.id=d.id_doctor\n"
            + "and nombesp =?";
    private static final String SELECT_BY_ID = "select d.id_doctor,nombre,apellido,nombesp from usuario u,doctor d\n"
            + "where u.id=d.id_doctor\n"
            + "and d.id_doctor=?";

    public ArrayList<Doctor> listar() {
        //Doctor doctor = null;
        ArrayList<Doctor> doctores = new ArrayList<>();

        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT);
            res = pstm.executeQuery();
            while (res.next()) {    // lee fila por fila hasta nulo            
                /*int iddoctor=res.getInt("id_doctor");
                String nombre=res.getString("nombre_dc");
                String apellido=res.getString("apellido_dc");
                String correo=res.getString("correo_dc");
                int telefono=res.getInt("telefono_dc");
                double saldo=res.getDouble("saldo");*/
                Doctor doctor = new Doctor();
                doctor.setId(res.getInt(1));
                doctor.setNombre(res.getString(2));
                doctor.setApellido(res.getString(3));
                doctor.setCorreo(res.getString(4));
                doctor.setEspecialidad(res.getString(5));
                doctor.setTelefono(res.getInt(6));
                doctores.add(doctor);

            }
        } catch (SQLException e) {
            System.out.println("Error al listar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return doctores;
    }

    public ArrayList<Doctor> listarDoc() {
        //Doctor doctor = null;
        ArrayList<Doctor> doctores = new ArrayList<>();

        try {
            pstm = con.getConnection().prepareStatement(SQL_SELECT_DOCTOR);
            res = pstm.executeQuery();
            while (res.next()) {    // lee fila por fila hasta nulo            
                Doctor doctor = new Doctor();
                doctor.setId(res.getInt(1));
                doctor.setNombre(res.getString(2));
                doctor.setApellido(res.getString(3));
                doctor.setEspecialidad(res.getString(4));
                doctores.add(doctor);

            }
        } catch (SQLException e) {
            System.out.println("Error al listar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return doctores;
    }

    public ArrayList<Doctor> listarEsp() {
        //Doctor doctor = null;
        ArrayList<Doctor> especialidades = new ArrayList<>();

        try {
            pstm = con.getConnection().prepareStatement(SELECT_ESP);
            res = pstm.executeQuery();
            while (res.next()) {    // lee fila por fila hasta nulo            
                Doctor doctor = new Doctor();
                doctor.setEspecialidad(res.getString(1));
                especialidades.add(doctor);

            }
        } catch (SQLException e) {
            System.out.println("Error al listar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return especialidades;
    }

    public ArrayList<Doctor> filtrarDoc(String especialidad) {
        ArrayList<Doctor> doctores = new ArrayList<>();

        try {
            pstm = con.getConnection().prepareStatement(FILTRAR_DOC);
            pstm.setString(1, especialidad);
            res = pstm.executeQuery();
            while (res.next()) {    // lee fila por fila hasta nulo            
                Doctor doctor = new Doctor();
                doctor.setId(res.getInt(1));
                doctor.setNombre(res.getString(2));
                doctor.setApellido(res.getString(3));
                doctores.add(doctor);

            }
        } catch (SQLException e) {
            System.out.println("Error al listar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return doctores;
    }

   public Doctor selectbyid(int id) {
        Doctor doctor = null;
        try {
            pstm = con.getConnection().prepareStatement(SELECT_BY_ID);
            pstm.setInt(1, id);

            res = pstm.executeQuery();

            while (res.next()) {
                doctor = new Doctor();
                doctor.setId(res.getInt(1));
                doctor.setNombre(res.getString(2));
                doctor.setApellido(res.getString(3));
                doctor.setEspecialidad(res.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Error login :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return doctor;
    }

    public Boolean insert(Doctor t) {
        Boolean result = false;
        try {
            pstm = con.getConnection().prepareStatement(SQL_INSERT);

            pstm.setInt(1, t.getId());
            pstm.setString(2, t.getEspecialidad());
            pstm.setInt(3, t.getTelefono());

            if (pstm.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al insertar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

//    public Doctor encontrar(Doctor doctor) {
//
//        try {
//            pstm = con.getConnection().prepareStatement(SQL_SELECT_BY_ID);
//            pstm.setInt(1, doctor.getIddoctor());
//            res = pstm.executeQuery();
//            if (res.next()) {// lee fila por fila hasta nulo
//                doctor = new Doctor();
//                doctor.setNombre(res.getString(1));
//                doctor.setApellido(res.getString(2));
//                doctor.setCorreo(res.getString(3));
//                doctor.setTelefono(res.getInt(4));
//                doctor.setSaldo(res.getDouble(5));
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//        return doctor;
//    }
//
//    public int insert(Doctor doctor) {
//        int rows = 0;
//        try {
//            pstm = con.getConnection().prepareStatement(SQL_INSERT);
//
//            pstm.setString(1, doctor.getNombre());
//            pstm.setString(2, doctor.getApellido());
//            pstm.setString(3, doctor.getCorreo());
//            pstm.setInt(4, doctor.getTelefono());
//            pstm.setDouble(5, doctor.getSaldo());
//            rows = pstm.executeUpdate();// ejecuta la sentencia respuesta 1 o 0
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//        return rows;
//    }
//
//    public int update(Doctor doctor) {
//        int rows = 0;
//        try {
//            pstm = con.getConnection().prepareStatement(SQL_UPDATE);
//
//            pstm.setString(1, doctor.getNombre());
//            pstm.setString(2, doctor.getApellido());
//            pstm.setString(3, doctor.getCorreo());
//            pstm.setInt(4, doctor.getTelefono());
//            pstm.setDouble(5, doctor.getSaldo());
//            pstm.setInt(6, doctor.getIddoctor());
//            rows = pstm.executeUpdate();// ejecuta la sentencia respuesta 1 o 0
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//        return rows;
//    }
//
    public int delete(Doctor doctor) {
        int rows = 0;
        try {
            pstm = con.getConnection().prepareStatement(SQL_DELETE);

            pstm.setInt(1, doctor.getId());

            rows = pstm.executeUpdate();// ejecuta la sentencia respuesta 1 o 0

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return rows;
    }

    public void closeConnection() {
        try {
            if (res != null) {
                res.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.closeConnection();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar :" + e.getMessage());
        }
    }

}
