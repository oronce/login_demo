package org.hibernate.userModel;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 * set up database and load session via hibernate
 *
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory = null;

    static {
        try{
            System.out.println("hellon\n\n");
            loadSessionFactory();
        }catch(Exception e){
            System.err.println("Exception occur while loadSessionFactory in hibernateUtils.. ");
            e.printStackTrace();
        }
    }

    public static SessionFactory  loadSessionFactory() {
        EntityManagerFactory  entityManagerFactory  = Persistence.createEntityManagerFactory("loginApp");
        sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        return sessionFactory;
    }

    public static Session getSession() {
        Session session=null;
        try {
            session = sessionFactory.openSession();
        } catch (Exception e) {
            System.err.println("Exception  openSession within  getSession() method ");
            e.printStackTrace();
        }
        
        return session;
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory factory = null;
        try {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
         
        factory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
         
        } catch (Exception e) {
            System.err.println("error while creating sessionFactory");
            e.printStackTrace();
        }
        return factory;
    }
}
