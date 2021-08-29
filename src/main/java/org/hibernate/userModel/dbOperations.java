package org.hibernate.userModel;

import java.util.List;
import com.userController.User;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * CRUD operations on database
 *
 */
public class dbOperations {

    public static int CreateUser(User user) {
        Session session = null;
        Transaction transaction = null;
        int ID=0;
        try {
             
            session = HibernateUtils.getSession();
            //getting transaction object from session object
            transaction = session.beginTransaction();
          
            ID = (Integer)session.save(user);
        
            transaction.commit();
            session.close();

        } catch (Exception e) {
            System.err.println("Exeption occur While Create User");
        }
        return ID;
    }
    

    public static List<User> readAllUser() {
        Session session = null;
        List<User> users = null;
        try {
            session = HibernateUtils.getSession();
            String queryStr = "FROM User";
            Query query = session.createQuery(queryStr);
            users = query.list();

            session.close();
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        return users;
    }

    public static User readById(int userId) {

        Session session = null;
        Transaction transaction = null;
        User user = null;
        try {
            session = HibernateUtils.getSession();
            //getting transaction object from session object
            transaction = session.beginTransaction();
            user = session.find(User.class, userId);
            transaction.commit();
            session.close();
            
        } catch (Exception e) {
            //TODO: handle exception
        }

        return user;
    }

    public static List<User> readByUsername (String username) {
        Session session = null;
        List<User> users = null;
        try {
            session = HibernateUtils.getSession();
            String queryStr = "FROM User  where username=:param1";
            Query query = session.createQuery(queryStr);
            query.setParameter("param1", username);
            users = query.list();
            session.close();
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        return users;
    }

    public static int readByUsernameAndGetId (String username) {
        Session session = null;
        List<User> users = null;
        int ID=0;
        try {
            session = HibernateUtils.getSession();
            String queryStr = "FROM User  where username=:param1";
            Query query = session.createQuery(queryStr);
            query.setParameter("param1", username);

            users = query.list();
            if (users.isEmpty()) {
                session.close();
                return 0;
            }

            ID = users.get(0).getId();

        } catch (Exception e) {
           System.err.println("Exeption occur in readByUsernameAndGetId()");
           e.printStackTrace();
        }
        return ID;
    }
    

    public static void UpdateUserById(User user) {
        Session session = null;
        Transaction transaction = null;

        try {
             
            session = HibernateUtils.getSession();
            //getting transaction object from session object
            transaction = session.beginTransaction();
            session.merge(user);
            

            transaction.commit();
            session.close();

        } catch (Exception e) {
            
        }
    }

    public void deleteUserById(int userId) {
        Session session = null;
        Transaction transaction = null;
        User user;
        try {
            session = HibernateUtils.getSession();
            //getting transaction object from session object
            transaction = session.beginTransaction();
            user = session.find(User.class, userId);
            session.delete(user);

            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    
}
