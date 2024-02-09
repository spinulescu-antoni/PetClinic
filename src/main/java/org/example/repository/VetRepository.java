package org.example.repository;

import org.example.entities.Vet;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class VetRepository extends Repository<Vet> {



    public List<Vet> getAllVets(){
        Session session = sessionFactory.openSession();
        Query<Vet> query = session.createQuery("select v from Vet v");
        return query.list();
    }
}
