package org.hibernate.UserModel;

import static org.junit.Assert.assertNotNull;

import com.userController.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.userModel.HibernateUtils;
import org.hibernate.userModel.dbOperations;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public  class HibernateUtilsTest {
    private static SessionFactory sessionFactory;
    private Session session;
     
    @BeforeClass
    public static void setup() {
        
        sessionFactory =  HibernateUtils.loadSessionFactory();
        System.out.println("SessionFactory created");
    }
    
}
