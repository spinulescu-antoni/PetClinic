package org.example.repository;

import org.example.entities.Pet;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PetRepository extends Repository<Pet> {

    public List<Pet> getAllPet(){
        Session session = sessionFactory.openSession();
        Query<Pet> query = session.createQuery("select p from Pet p");
        return query.list();
    }
    public List<Pet> findByOwnerPhoneNumber(String phoneNumber){
        Session session = sessionFactory.openSession();
        Query<Pet> query = session.createQuery("select p from Pet p where p.petOwner.phoneNumber = : phoneNumber");
        query.setParameter("phoneNumber", phoneNumber);
        return query.list();
    }
}
