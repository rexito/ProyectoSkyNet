/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkyNet.controller;

import com.SkyNet.model.Administrador;
import com.SkyNet.model.Carrera;
import com.SkyNet.repository.CarreraRepository;
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
public class CarreraController {
    
    @Autowired
    private CarreraRepository CarreraRepository;
    
    //Petición GET (Lista carreras)
    @CrossOrigin
    @RequestMapping(value = "/skynet/carrera/", method = GET)
    public Collection<Carrera> getCarrera() {
        return CarreraRepository.findAll();
    }
    
    //Petición GET  (Una Carrera)
    @CrossOrigin
    @RequestMapping(value = "/skynet/carrera/{id}", method = GET)
    public Carrera getUnaCarrera(@PathVariable Integer id) {
        return CarreraRepository.findOne(id);
    }
    
    // Petición POST (Nuevo Carrera)
    @CrossOrigin
    @RequestMapping(value = "/skynet/carrera/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Carrera nuevaCarrera(@Valid @RequestBody Carrera carrera) {
        CarreraRepository.save(carrera);
        return carrera;
    }
    
    // Petición PUT (Editar carrera)
    @CrossOrigin
    @RequestMapping(value = "/skynet/carrera/{id}", method = PUT)
    public ResponseEntity<Carrera> actualizarCarrera(@Valid @PathVariable Integer id, @RequestBody Carrera actualizarCarrera) {
        Carrera carrera = CarreraRepository.findOne(id);
        if (carrera != null) {

            actualizarCarrera.setIdCarrera(id);
            CarreraRepository.save(actualizarCarrera);
            return new ResponseEntity<>(carrera, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Petición DELETE(Eliminar Administrador)
    @CrossOrigin
    @RequestMapping(value = "/skynet/carrera/{id}", method = DELETE)
    public ResponseEntity<Carrera> eliminarCarrera(@PathVariable Integer id) {
        Carrera carrera = CarreraRepository.findOne(id);
        CarreraRepository.delete(id);
        if (carrera != null) {
            return new ResponseEntity<>(carrera, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
