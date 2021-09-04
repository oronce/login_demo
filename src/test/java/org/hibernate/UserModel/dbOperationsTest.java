package org.hibernate.UserModel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.SessionFactory;
import com.userController.User;

import org.hibernate.userModel.dbOperations;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class dbOperationsTest {

    static SessionFactory factory = null;

    @BeforeClass
    public static void dbSetUp() {
       factory = dbOperations.buildSessionFactory("hibernateTest.cfg.xml");
    }

    @Test
    public void createUserTest() {
        int id = 0;
        User user = new User("lode", "haha");
        id = dbOperations.CreateUser(user);
        System.out.println("id is :" + id);
        assertTrue("id must be great than 0", id > 0);
    }
    
    @Test
    public void readAllUserTest() {
        List<User> users = null;
        dbOperations.CreateUser(new User("pierre", "passpass"));
        users = dbOperations.readAllUser();
        System.out.println("all users is :");
        assertFalse(users.isEmpty());
    }

    @Test
    public void readByIdTest() {
        int id = 1;
        User user = null;
        user = dbOperations.readById(id);
        System.out.println(user);
        assertNotNull(user);
    }

    @Test
    public void readByUsernameTest() {
        List<User> users = null;
        String username = "mama";
        dbOperations.CreateUser(new User(username, "password"));
        users = dbOperations.readByUsername(username);
        assertFalse(users.isEmpty());
    }

    @Test
    public void deleteUserTest() {
        User user ;
        int id = dbOperations.CreateUser(new User("lvier", "password")); 
        dbOperations.deleteUserById(id);
        user =  dbOperations.readById(id);
        assertNull(user);
    }

    @AfterClass
    public static void dbTearingDown() {
        factory.close();
    }
}
