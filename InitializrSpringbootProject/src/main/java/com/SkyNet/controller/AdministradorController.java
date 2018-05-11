/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkyNet.controller;

import com.SkyNet.model.Administrador;
import com.SkyNet.repository.AdministradorRepository;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author don_w
 */
@RestController
public class AdministradorController {
    
    @Autowired
    private AdministradorRepository AdministradorRepository;
    
    //Petición GET (Lista Administradores)
    @CrossOrigin
    @RequestMapping(value = "/skynet/administrador/", method = GET)
    public Collection<Administrador> getAdministrador() {
        return AdministradorRepository.findAll();
    }
    
    //Petición GET  (Un Administrador)
    @CrossOrigin
    @RequestMapping(value = "/skynet/administrador/{id}", method = GET)
    public Administrador getUnAdministrador(@PathVariable Integer id) {
        return AdministradorRepository.findOne(id);
    }
    
    // Petición POST (Nuevo Administrador)
    @CrossOrigin
    @RequestMapping(value = "/skynet/administrador/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador nuevoAdministrador(@Valid @RequestBody Administrador administrador) {
        AdministradorRepository.save(administrador);
        return administrador;
    }
    
    // Petición PUT (Editar arriendo)
    @CrossOrigin
    @RequestMapping(value = "/skynet/administrador/{id}", method = PUT)
    public ResponseEntity<Administrador> actualizarAdministrador(@Valid @PathVariable Integer id, @RequestBody Administrador actualizarAdministrador) {
        Administrador administrador = AdministradorRepository.findOne(id);
        if (administrador != null) {

            actualizarAdministrador.setIdAdministrador(id);
            AdministradorRepository.save(actualizarAdministrador);
            return new ResponseEntity<>(administrador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Petición DELETE(Eliminar Administrador)
    @CrossOrigin
    @RequestMapping(value = "/skynet/administrador/{id}", method = DELETE)
    public ResponseEntity<Administrador> eliminarAdministrador(@PathVariable Integer id) {
        Administrador administrador = AdministradorRepository.findOne(id);
        AdministradorRepository.delete(id);
        if (administrador != null) {
            return new ResponseEntity<>(administrador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
