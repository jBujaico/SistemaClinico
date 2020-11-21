package com.miempresa.daos;

import com.miempresa.connection.ConnectionBD;
import com.miempresa.dtos.Citas;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CitasDAO {

    // CONEXION A LA BASE DE DATOS GESTIONADA POR LA CLASE CONECTIONBD
    private static ConnectionBD con = ConnectionBD.newConnection();
    // REALIZAR LAS CONSULTAS A LA BASE DE DATOS CON PREPARESTATEMENT
    private static PreparedStatement pstm = null;
    private static CallableStatement cstm = null;
    // PARA ALMACENAR EL RESULTADO DE LA CONSULTA REALIZADA
    private static ResultSet res = null;
    // DEFINIR LOS QUERYS
    private static final String INSERT_CITAS = "insert into citas values(?,?,?,?,?,?,?,?)";
    private static final String SELECT_BY_ID = "select cod_cita,id_usuario,nomb_user,ape_user,d.id_doctor,nomb_doc,ape_doc,especialidad,fecha\n"
            + "from citas c, doctor d\n"
            + "where d.id_doctor=c.id_doctor\n"
            + "and d.id_doctor=?";

    public Boolean insert(Citas t) {
        Boolean result = false;
        try {
            pstm = con.getConnection().prepareStatement(INSERT_CITAS);

            pstm.setInt(1, t.getIduser());
            pstm.setString(2, t.getNomuser());
            pstm.setString(3, t.getApeuser());
            pstm.setInt(4, t.getIddoctor());
            pstm.setString(5, t.getNomdoctor());
            pstm.setString(6, t.getApedoctor());
            pstm.setString(7, t.getEspecialidad());
            pstm.setString(8, t.getFecha());
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
    
     public ArrayList<Citas> ListCitas(int iddoctor) {
        ArrayList<Citas> listcitas = new ArrayList<>();

        try {
            pstm = con.getConnection().prepareStatement(SELECT_BY_ID);
            pstm.setInt(1, iddoctor);
            res = pstm.executeQuery();
            while (res.next()) {    // lee fila por fila hasta nulo            
                Citas citas = new Citas();
                citas.setCodcita(res.getInt(1));
                citas.setIduser(res.getInt(2));
                citas.setNomuser(res.getString(3));
                citas.setApeuser(res.getString(4));
                citas.setIddoctor(res.getInt(5));
                citas.setNomdoctor(res.getString(6));
                citas.setApedoctor(res.getString(7));
                citas.setEspecialidad(res.getString(8));
                citas.setFecha(res.getString(9));
                listcitas.add(citas);

            }
        } catch (SQLException e) {
            System.out.println("Error al listar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return listcitas;
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
