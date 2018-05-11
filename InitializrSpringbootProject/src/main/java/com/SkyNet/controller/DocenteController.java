/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkyNet.controller;

import com.SkyNet.model.Docente;
import com.SkyNet.repository.DocenteRepository;
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
public class DocenteController {
    
    @Autowired
    private DocenteRepository DocenteRepository;
    
    //Petición GET (Lista docnete)
    @CrossOrigin
    @RequestMapping(value = "/skynet/docente/", method = GET)
    public Collection<Docente> getDocente() {
        return DocenteRepository.findAll();
    }
    
    //Petición GET  (Una docente)
    @CrossOrigin
    @RequestMapping(value = "/skynet/docente/{id}", method = GET)
    public Docente getUnDocente(@PathVariable Integer id) {
        return DocenteRepository.findOne(id);
    }
    
    // Petición POST (Nuevo docente)
    @CrossOrigin
    @RequestMapping(value = "/skynet/docente/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Docente nuevoDocente(@Valid @RequestBody Docente docente) {
        DocenteRepository.save(docente);
        return docente;
    }
    
    // Petición PUT (Editar docente)
    @CrossOrigin
    @RequestMapping(value = "/skynet/docente/{id}", method = PUT)
    public ResponseEntity<Docente> actualizarDocente(@Valid @PathVariable Integer id, @RequestBody Docente actualizarDocente) {
        Docente docente = DocenteRepository.findOne(id);
        if (docente != null) {

            actualizarDocente.setIdDocente(id);
            DocenteRepository.save(actualizarDocente);
            return new ResponseEntity<>(docente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Petición DELETE(Eliminar docente)
    @CrossOrigin
    @RequestMapping(value = "/skynet/docente/{id}", method = DELETE)
    public ResponseEntity<Docente> eliminarDocente(@PathVariable Integer id) {
        Docente docente = DocenteRepository.findOne(id);
        DocenteRepository.delete(id);
        if (docente != null) {
            return new ResponseEntity<>(docente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
