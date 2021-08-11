package org.hibernate.userModel;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtils {

    private static SessionFactory sessionFactory = null;

    static {
        try{
            loadSessionFactory();
        }catch(Exception e){
            System.err.println("Exception while initializing hibernate util.. ");
            e.printStackTrace();
        }
    }

    public static void  loadSessionFactory() {
        EntityManagerFactory  entityManagerFactory  = Persistence.createEntityManagerFactory("loginApp");
        sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    public static Session getSession() {
        Session session = sessionFactory.openSession();
        return session;
    }
}
