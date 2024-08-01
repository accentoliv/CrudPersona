package com.crudpersona.crudpersona.dao;

import com.crudpersona.crudpersona.entity.Persona;
import jakarta.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaDaoImpl implements PersonaDao{

    private EntityManager entityManager;

    @Autowired
    public PersonaDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Persona> getAllPersona(){
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Persona> theQuery =
                currentSession.createQuery("from Persona", Persona.class);


        List<Persona> personas = theQuery.getResultList();

        return personas;
    }


    @Override
    public void savePersona(Persona persona){
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(persona);
    }
    @Override
    public Persona getPersona(int Id){

        Session currentSession = entityManager.unwrap(Session.class);

        Persona persona = currentSession.get(Persona.class,Id);

        return persona;
    }

    @Override
    public void deletePersona(int Id){

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery =
                currentSession.createQuery(
                        "delete from Persona where id=:personaId");
        theQuery.setParameter("personaId", Id);

        theQuery.executeUpdate();
    }


}
