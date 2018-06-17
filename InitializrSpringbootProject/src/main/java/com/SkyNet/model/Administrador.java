/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkyNet.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author don_w
 */
@Entity
public class Administrador implements Serializable {
    
    public Administrador (int idAdministrador, String nombreAdministrador, String apellidoAdministrador){
        this.idAdministrador = idAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.apellidoAdministrador = apellidoAdministrador;
    }

    public Administrador() {
    }
    
    
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idAdministrador;
    
    @NotNull
    private String nombreAdministrador;
    
    @NotNull
    private String apellidoAdministrador;

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getApellidoAdministrador() {
        return apellidoAdministrador;
    }

    public void setApellidoAdministrador(String apellidoAdministrador) {
        this.apellidoAdministrador = apellidoAdministrador;
    }
    
    
}
