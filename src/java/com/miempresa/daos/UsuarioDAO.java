package com.miempresa.daos;

import com.miempresa.connection.ConnectionBD;
import com.miempresa.dtos.Usuario;
import com.miempresa.interfaces.OperacionesBD;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JERSON KEVIN BUJAICO PACHECO
 */
public class UsuarioDAO implements OperacionesBD<Usuario> {

    // CONEXION A LA BASE DE DATOS GESTIONADA POR LA CLASE CONECTIONBD
    private static ConnectionBD con = ConnectionBD.newConnection();
    // REALIZAR LAS CONSULTAS A LA BASE DE DATOS CON PREPARESTATEMENT
    private static PreparedStatement pstm = null;
    private static CallableStatement cstm = null;
    // PARA ALMACENAR EL RESULTADO DE LA CONSULTA REALIZADA
    private static ResultSet res = null;
    // DEFINIR LOS QUERYS
    private static final String INSERT = "insert into usuario (nombre,apellido,dni,fechanac,sexo,correo,clave,pregunta,respuesta,perfil) values(?,?,?,?,?,?,?,?,?,?)";
    private static final String LOGIN = "select id,nombre,apellido,perfil,estado from usuario where correo=? and clave=?";
    private static final String RECOVERY = "select pregunta from usuario where correo =?";
    private static final String RECOVERY2 = "select clave from usuario where respuesta =?";
    private static final String LIST = "select id,nombre,correo,perfil from usuario";
    private static final String LIST_DOCTOR = "select id,nombre,apellido,correo from usuario where perfil='doctor'";
    private static final String SP_UPDATE = "update usuario set nombre=?,apellido=?,dni=?,fechanac=?,sexo=?,correo=?,clave=?,pregunta=?,respuesta=?,perfil=?,estado=? where id=? ";
    private static final String SQL_LISTBYMAIL = "select * from usuario where correo=?";
    private static final String SP_UPDATEESTATE = "{call pa_actualizarestado(?,?)}";
    
    public Usuario login(String correo, String clave) {
        Usuario usuario = null;
        try {
            pstm = con.getConnection().prepareStatement(LOGIN);
            pstm.setString(1, correo);
            pstm.setString(2, clave);

            res = pstm.executeQuery();

            while (res.next()) {
                usuario = new Usuario();
                usuario.setId(res.getInt(1));
                usuario.setNombre(res.getString(2));
                usuario.setApellido(res.getString(3));
                usuario.setPerfil(res.getString(4));
                usuario.setEstado(res.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("Error login :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return usuario;
    }

    public Usuario recovery(String correo) {
        Usuario usuario = null;
        try {
            pstm = con.getConnection().prepareStatement(RECOVERY);
            pstm.setString(1, correo);

            res = pstm.executeQuery();

            while (res.next()) {
                usuario = new Usuario();
                usuario.setPregunta(res.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Error login :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return usuario;
    }

    public Usuario recovery2(String respuesta) {
        Usuario usuario = null;
        try {
            pstm = con.getConnection().prepareStatement(RECOVERY2);
            pstm.setString(1, respuesta);

            res = pstm.executeQuery();

            while (res.next()) {
                usuario = new Usuario();
                usuario.setClave(res.getString(1));
            }
        } catch (Exception e) {
            System.out.println("Error login :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return usuario;
    }

    public Boolean actualizarEstado(int id, int estado) {
        Boolean result = false;
        try {
            cstm = con.getConnection().prepareCall(SP_UPDATEESTATE);
            cstm.setInt(1, id);
            cstm.setInt(2, estado);
            int operacion = cstm.executeUpdate();
            if (operacion > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar estado:" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
    
    @Override
    public Boolean insert(Usuario t) {
        Boolean result = false;
        try {
            pstm = con.getConnection().prepareStatement(INSERT);
            pstm.setString(1, t.getNombre());
            pstm.setString(2, t.getApellido());
            pstm.setInt(3, t.getDni());
            pstm.setString(4, t.getFechanac());
            pstm.setString(5, t.getSexo());
            pstm.setString(6, t.getCorreo());
            pstm.setString(7, t.getClave());
            pstm.setString(8, t.getPregunta());
            pstm.setString(9, t.getRespuesta());
            pstm.setString(10, t.getPerfil());
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

    @Override
    public Boolean update(Usuario t) {
        Boolean result = false;
        try {
            pstm = con.getConnection().prepareStatement(SP_UPDATE);
            pstm.setString(1, t.getNombre());
            pstm.setString(2, t.getApellido());
            pstm.setInt(3, t.getDni());
            pstm.setString(4, t.getFechanac());
            pstm.setString(5, t.getSexo());
            pstm.setString(6, t.getCorreo());
            pstm.setString(7, t.getClave());
            pstm.setString(8, t.getPregunta());
            pstm.setString(9, t.getRespuesta());
            pstm.setString(10, t.getPerfil());
            pstm.setInt(11, t.getEstado());
            pstm.setInt(12, t.getId());
            if (pstm.executeUpdate() > 0) {
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Errror al insertar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    @Override
    public Boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> selectAll() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            pstm = con.getConnection().prepareStatement(LIST);
            res = pstm.executeQuery();

            while (res.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(res.getInt("id"));
                usuario.setNombre(res.getString("nombre"));
                usuario.setCorreo(res.getString("correo"));
                usuario.setPerfil(res.getString("perfil"));
                usuarios.add(usuario);
            }

        } catch (Exception e) {
            System.out.println("Error al listar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return usuarios;
    }
    
     public ArrayList<Usuario> selectDoc() {
        ArrayList<Usuario> doctores = new ArrayList<>();
        try {
            pstm = con.getConnection().prepareStatement(LIST_DOCTOR);
            res = pstm.executeQuery();

            while (res.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(res.getInt("id"));
                usuario.setNombre(res.getString("nombre"));
                usuario.setApellido(res.getString("apellido"));
                usuario.setCorreo(res.getString("correo"));
                doctores.add(usuario);
            }

        } catch (Exception e) {
            System.out.println("Error al listar :" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return doctores;
    }

    public Usuario selectByMail(String correo) {
        Usuario usuario = new Usuario();
        try {
            pstm = con.getConnection().prepareStatement(SQL_LISTBYMAIL);
            pstm.setString(1, correo);
            res = pstm.executeQuery();
            while (res.next()) {
                usuario.setId(res.getInt(1));
                usuario.setNombre(res.getString(2));
                usuario.setApellido(res.getString(3));
                usuario.setDni(res.getInt(4));
                usuario.setFechanac(res.getString(5));
                usuario.setSexo(res.getString(6));
                usuario.setCorreo(res.getString(7));
                usuario.setClave(res.getString(8));
                usuario.setPregunta(res.getString(9));
                usuario.setRespuesta(res.getString(10));
                usuario.setPerfil(res.getString(11));
                usuario.setEstado(res.getInt(12));
            }

        } catch (Exception e) {
            System.out.println("Error al recuperar  por correo" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return usuario;

    }

    @Override
    public Usuario selectById(Object idd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
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
