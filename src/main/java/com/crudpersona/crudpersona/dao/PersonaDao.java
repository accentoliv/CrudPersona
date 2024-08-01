package com.crudpersona.crudpersona.dao;

import com.crudpersona.crudpersona.entity.Persona;

import java.util.List;

public interface PersonaDao {

    public List<Persona> getAllPersona();

    public void savePersona(Persona persona);

    public Persona getPersona(int Id);

    public void deletePersona(int Id);

}
