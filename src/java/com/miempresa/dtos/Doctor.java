package com.miempresa.dtos;

public class Doctor extends Usuario{
   
    
   
    private String especialidad;
    private int telefono;

    //SOBRECARGA DE CONSTRUCTORES
    public Doctor() {
        
    }
    
    //get y set

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    

}
