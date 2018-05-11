/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkyNet.controller;

import com.SkyNet.model.Seccion;
import com.SkyNet.repository.SeccionRepository;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author don_w
 */
@RestController
public class SeccionController {
    
    @Autowired
    private SeccionRepository SeccionRepository;
    
    //Petición GET (Lista secciones)
    @CrossOrigin
    @RequestMapping(value = "/skynet/seccion/", method = GET)
    public Collection<Seccion> getSeccion() {
        return SeccionRepository.findAll();
    }
    
    //Petición GET  (Una seccion)
    @CrossOrigin
    @RequestMapping(value = "/skynet/seccion/{id}", method = GET)
    public Seccion getUnaSeccion(@PathVariable Integer id) {
        return SeccionRepository.findOne(id);
    }
    
    // Petición POST (Nuevo seccion)
    @CrossOrigin
    @RequestMapping(value = "/skynet/seccion/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Seccion nuevaSeccion(@Valid @RequestBody Seccion seccion) {
        SeccionRepository.save(seccion);
        return seccion;
    }
    
    // Petición PUT (Editar seccion)
    @CrossOrigin
    @RequestMapping(value = "/skynet/seccion/{id}", method = PUT)
    public ResponseEntity<Seccion> actualziarSeccion(@Valid @PathVariable Integer id, @RequestBody Seccion actualizarSeccion) {
        Seccion seccion = SeccionRepository.findOne(id);
        if (seccion != null) {

            actualizarSeccion.setIdSeccion(id);
            SeccionRepository.save(actualizarSeccion);
            return new ResponseEntity<>(seccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Petición DELETE(Eliminar seccion)
    @CrossOrigin
    @RequestMapping(value = "/skynet/seccion/{id}", method = DELETE)
    public ResponseEntity<Seccion> eliminarSeccion(@PathVariable Integer id) {
        Seccion seccion = SeccionRepository.findOne(id);
        SeccionRepository.delete(id);
        if (seccion != null) {
            return new ResponseEntity<>(seccion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
