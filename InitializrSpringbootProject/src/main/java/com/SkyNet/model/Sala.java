/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkyNet.model;

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
public class Sala {
    
    public Sala (int idSala, String nombreSala, int numeroSala, String piso){
        this.idSala = idSala;
        this.nombreSala = nombreSala;
        this.numeroSala = numeroSala;
        this.piso = piso;
    }
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idSala;
    
    @NotNull
    private String nombreSala;
   
    private int numeroSala;
    
    private String piso;

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
    
    
    
}
