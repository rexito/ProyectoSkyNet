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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author don_w
 */
@Entity
public class Horario {
    public Horario (int idHorario,Asignatura asignatura,Sala sala){
        this.idHorario = idHorario;
        this.asignatura = asignatura;
        this.sala = sala;
    }
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idHorario;
    

    
    @NotNull (message = "Campo Obligatorio")
    @ManyToOne
    @JoinColumn(name = "idAsignatura")
    private Asignatura asignatura;
    
    @NotNull (message = "Campo Obligatorio")
    @OneToOne
    private Sala sala;
    
 
    

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    
    
}
