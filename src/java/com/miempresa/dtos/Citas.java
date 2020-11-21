package com.miempresa.dtos;

/**
 *
 * @author JERSON BUJAICO
 */
public class Citas {
    //ATRIBUTOS
    private int codcita;
    private int iduser;
    private String nomuser;
    private String apeuser;
    private int iddoctor;
    private String nomdoctor;
    private String apedoctor;
    private String especialidad;
    private String fecha;
    
    
    //GET Y SET
    
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNomuser() {
        return nomuser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public String getApeuser() {
        return apeuser;
    }

    public void setApeuser(String apeuser) {
        this.apeuser = apeuser;
    }

    public int getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getNomdoctor() {
        return nomdoctor;
    }

    public void setNomdoctor(String nomdoctor) {
        this.nomdoctor = nomdoctor;
    }

    public String getApedoctor() {
        return apedoctor;
    }

    public void setApedoctor(String apedoctor) {
        this.apedoctor = apedoctor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCodcita() {
        return codcita;
    }

    public void setCodcita(int codcita) {
        this.codcita = codcita;
    }

    
    
    
    
    
    
}
