package org.example.repository;

import org.example.entities.PetOwner;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class PetOwnerRepository extends Repository<PetOwner> {


    public Optional<PetOwner> findByPhoneNumber(String phoneNumber){
        Session session = sessionFactory.openSession();
        Query<PetOwner> query = session.createQuery("select p from PetOwner p where p.phoneNumber = :phoneNumber");
        query.setParameter("phoneNumber", phoneNumber);
        return query.uniqueResultOptional();
    }

    public List<PetOwner> getAllPetOwners(){
        Session session = sessionFactory.openSession();
        Query<PetOwner> query = session.createQuery("select p from PetOwner p");
        return query.list();
    }
}
//  clase abstracta cu generic (save, update ssi delete);