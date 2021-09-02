package org.hibernate.UserModel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.userController.User;

import org.hibernate.userModel.dbOperations;
import org.junit.Test;


public class dbOperationsTest {

    @Test
    public void createUserTest() {
        int id = 0;
        User user = new User("lode", "haha");
        id = dbOperations.CreateUser(user);
        assertTrue("id must be great than 0", id > 0);
    }
    
    @Test
    public void readAllUserTest() {
        List<User> users = null;
        users = dbOperations.readAllUser();
        assertFalse(users.isEmpty());
    }

    @Test
    public void readByIdTest() {
        int id = 1;
        User user = null;
        dbOperations.readById(id);
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
}
