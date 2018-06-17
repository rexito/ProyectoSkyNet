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
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author don_w
 */

@Entity
public class Seccion {
    
    public Seccion (int idSeccion, String nombreSeccion, Jornada jornada, Carrera carrera){
        this.idSeccion = idSeccion;
        this.nombreSeccion = nombreSeccion;
        this.jornada = jornada;
        this.carrera = carrera;
    }

    public Seccion() {
    }
    
    
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idSeccion;
    
    @NotNull (message = "Campo Obligatorio")
    private String nombreSeccion;
    
    @NotNull (message = "Campo Obligatorio")
    @ManyToOne
    private Jornada jornada;
    
    @NotNull (message = "Campo Obligatorio")
    @ManyToOne
    private Carrera carrera;

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int id_Seccion) {
        this.idSeccion = idSeccion;
    }

    public String getNombreSeccion() {
        return nombreSeccion;
    }

    public void setNombreSeccion(String nombreSeccion) {
        this.nombreSeccion = nombreSeccion;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    
    
}
