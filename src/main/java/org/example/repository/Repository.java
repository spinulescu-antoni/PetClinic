package org.example.repository;

import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Repository<T> {
    protected SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    public void save(T someObject){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(someObject);
        transaction.commit();
        session.close();
    }
}
