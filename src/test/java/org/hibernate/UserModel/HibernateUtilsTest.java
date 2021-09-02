package org.hibernate.UserModel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.userController.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.userModel.HibernateUtils;
import org.hibernate.userModel.dbOperations;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public  class HibernateUtilsTest {
    private static SessionFactory sessionFactory =null;
     
    @BeforeClass
    public static void setUp() {
        sessionFactory = HibernateUtils.getSessionFactory("hibernateTest.cfg.xml");
        dbOperations.hibernateConfigFile = "hibernateTest.cfg.xml";
    }

   @Test
   public void testCreateUser() {
        int id = 0;
        id =  dbOperations.CreateUser(new User("sossou", "jooaoa"));
        assertTrue(id > 0);
   }

   @Test
   public void testReadAllUser() {
        List<User> users = null;
        dbOperations.CreateUser(new User("jaguar", "holulu"));
        System.out.println("users: " + users);
   }
   
    @AfterClass
    public static void tearinDown() {
    sessionFactory.close();
    System.out.println("session closed");
   }

}
