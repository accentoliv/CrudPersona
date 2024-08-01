package com.crudpersona.crudpersona.service;


import com.crudpersona.crudpersona.dao.PersonaDao;
import com.crudpersona.crudpersona.entity.Persona;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{

    private PersonaDao personaDao;

    @Autowired
    public PersonaServiceImpl(PersonaDao personaDao){

        this.personaDao = personaDao;

    }
    @Override
    @Transactional
    public List<Persona> getAllPersona(){
        return personaDao.getAllPersona();
    }


    @Override
    @Transactional
    public void savePersona(Persona persona){

        personaDao.savePersona(persona);

    }

    @Override
    @Transactional
    public Persona getPersona(int Id){

        return personaDao.getPersona(Id);

    }

    @Override
    @Transactional
    public void deletePersona(int Id){

        personaDao.deletePersona(Id);

    }

}
