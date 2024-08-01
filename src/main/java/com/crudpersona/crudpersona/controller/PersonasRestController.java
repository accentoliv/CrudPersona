package com.crudpersona.crudpersona.controller;


import com.crudpersona.crudpersona.entity.Persona;
import com.crudpersona.crudpersona.errores.PersonaNotFoundException;
import com.crudpersona.crudpersona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PersonasRestController {

    private PersonaService personaService;

    @Autowired
    public PersonasRestController(PersonaService personaService) {
        this.personaService = personaService;

    }

    @GetMapping("/personas")
    public List<Persona> findAll() {

        return  personaService.getAllPersona();

    }


    @PostMapping("/personas")
    public Persona addPersona(@RequestBody Persona  persona) {
        persona.setId(0);
        personaService.savePersona(persona);

        return persona;
    }

    @GetMapping("/personas/{personaId}")
    public Persona getPersona(@PathVariable int personaId){
       Persona persona = personaService.getPersona(personaId);

        if (persona == null) {
            throw new PersonaNotFoundException("Persona con el id :" + personaId+" no encontrado");
        }

       return persona;
    }

    @DeleteMapping("/personas/{personaId}")
    public ResponseEntity<Object> deletePersona(@PathVariable int personaId) {

        Persona tempPersona = personaService.getPersona(personaId);

        // throw exception if null

        if (tempPersona == null) {
            throw new PersonaNotFoundException("Persona con el id :" + personaId+" no encontrado");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "Persona eliminado con el id - " + personaId );
        map.put("status", HttpStatus.OK);
        map.put("data", null);

        personaService.deletePersona(personaId);
        return new ResponseEntity<>(
                map,
                HttpStatus.OK);


    }

    @PutMapping("/personas")
    public Persona updatePersona(@RequestBody Persona persona) {

        Persona personaExist = personaService.getPersona(persona.getId());

        if (personaExist == null) {
            throw new PersonaNotFoundException("Persona con el id :" + persona.getId()+" no encontrado");
        }
        personaExist.setNombres(persona.getNombres());
        personaExist.setApellidos(persona.getApellidos());
        personaExist.setDireccion(persona.getDireccion());
        personaExist.setNumero(persona.getNumero());
        personaService.savePersona(personaExist);

        return persona;
    }
}
