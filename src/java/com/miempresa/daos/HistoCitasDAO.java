package com.miempresa.daos;

import com.miempresa.connection.ConnectionBD;
import com.miempresa.dtos.HistoCitas;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JERSON BUJAICO PACHECO
 */
public class HistoCitasDAO {

    // CONEXION A LA BASE DE DATOS GESTIONADA POR LA CLASE CONECTIONBD
    private static ConnectionBD con = ConnectionBD.newConnection();
    // REALIZAR LAS CONSULTAS A LA BASE DE DATOS CON PREPARESTATEMENT
    private static PreparedStatement pstm = null;
    private static CallableStatement cstm = null;
    // PARA ALMACENAR EL RESULTADO DE LA CONSULTA REALIZADA
    private static ResultSet res = null;
    // DEFINIR LOS QUERYS
    private static final String INSERT_HISTCITAS = "insert into histcitas values(?,?)";
    private static final String LIST_HISTCITAS_BYDOC = "select cod_cita,nomb_user,ape_user,id_doctor,nomb_doc,ape_doc,especialidad,fecha,observaciones\n"
            + "from citas c, histcitas h\n"
            + "where c.cod_cita=h.cod_hcita\n"
            + "and id_doctor=?";

    public Boolean insert(HistoCitas t) {
        Boolean result = false;
        try {
            pstm = con.getConnection().prepareStatement(INSERT_HISTCITAS);

            pstm.setInt(1, t.getCodcita());
            pstm.setString(2, t.getObservaciones());
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
    
    public ArrayList<HistoCitas> historiales(int iddoctor) {
        ArrayList<HistoCitas> historiales = new ArrayList<>();

        try {
            pstm = con.getConnection().prepareStatement(LIST_HISTCITAS_BYDOC);
            pstm.setInt(1, iddoctor);
            res = pstm.executeQuery();
            while (res.next()) {    // lee fila por fila hasta nulo            
                HistoCitas histoCitas = new HistoCitas();
                histoCitas.setCodcita(res.getInt(1));
                histoCitas.setNomuser(res.getString(2));
                histoCitas.setApeuser(res.getString(3));
                histoCitas.setIddoctor(res.getInt(4));
                histoCitas.setNomdoctor(res.getString(5));
                histoCitas.setApedoctor(res.getString(6));
                histoCitas.setEspecialidad(res.getString(7));
                histoCitas.setFecha(res.getString(8));
                histoCitas.setObservaciones(res.getString(9));
                historiales.add(histoCitas);

            }
        } catch (SQLException e) {
            System.out.println("Error al listar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return historiales;
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
