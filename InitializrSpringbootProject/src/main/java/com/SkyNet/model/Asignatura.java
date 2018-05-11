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
public class Asignatura {
    
    public Asignatura (int idAsignatura,String nombreAsignatura,Seccion seccion,Docente docente){
        this.idAsignatura = idAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.seccion = seccion;
        this.docente = docente;        
    }
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idAsignatura;
    
    @NotNull
    private String nombreAsignatura;
    
    @NotNull (message = "Campo Obligatorio")
  
    @JoinColumn(name = "id_seccion")
    @OneToOne
    private Seccion seccion;
    
    @NotNull
    @JoinColumn(name = "id_docente")
    @OneToOne
    private Docente docente;

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    
    
}
