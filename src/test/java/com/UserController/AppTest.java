package com.UserController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.userController.User;

import org.hibernate.userModel.HibernateUtils;
import org.hibernate.userModel.dbOperations;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
       
    }


    @Test
    public void testUserConstructor(){
        User user = new User("ryan", "password");
        assertEquals("ryan", user.getUsername());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testDatabaseConnectio(){
        HibernateUtils.loadSessionFactory();
        assertNotNull(HibernateUtils.getSession());
    }

    @Test
    public void shouldCreateANewUserFieldInDB() {
        
        User user = new User("pinocio", "sossou33");
        dbOperations.CreateUser(user);

    }
}
