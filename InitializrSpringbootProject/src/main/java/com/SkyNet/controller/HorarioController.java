/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkyNet.controller;

import com.SkyNet.model.Horario;
import com.SkyNet.repository.HorarioRepository;
import java.util.Collection;
import javax.validation.Valid;
import static jdk.nashorn.internal.runtime.Debug.id;
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
public class HorarioController {
    
    @Autowired
    private HorarioRepository HorarioRepository;
    
    //Petición GET (Lista horarios)
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/", method = GET)
    public Collection<Horario> getHorario() {
        return HorarioRepository.findAll();
    }
    
    //Petición GET  (Un horario)
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/{id}", method = GET)
    public Horario getUnHorario(@PathVariable Integer id) {
        return HorarioRepository.findOne(id);
    }
    
    // Petición POST (Nuevo horaio)
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/", method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Horario nuevoHorario(@Valid @RequestBody Horario horario) {
        HorarioRepository.save(horario);
        return horario;
    }
    
    // Petición PUT (Editar horario)
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/{id}", method = PUT)
    public ResponseEntity<Horario> actualizarHorario(@Valid @PathVariable Integer id, @RequestBody Horario actualizarHorario) {
        Horario horario = HorarioRepository.findOne(id);
        if (horario != null) {

            actualizarHorario.setIdHorario(id);
            HorarioRepository.save(actualizarHorario);
            return new ResponseEntity<>(horario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Petición DELETE(Eliminar Administrador)
    @CrossOrigin
    @RequestMapping(value = "/skynet/horario/{id}", method = DELETE)
    public ResponseEntity<Horario> eliminarHorario(@PathVariable Integer id) {
        Horario horario = HorarioRepository.findOne(id);
        HorarioRepository.delete(id);
        if (horario != null) {
            return new ResponseEntity<>(horario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
  
    
}
