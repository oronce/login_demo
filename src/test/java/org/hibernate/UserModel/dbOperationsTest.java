package org.hibernate.UserModel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.userController.User;

import org.hibernate.userModel.dbOperations;
import org.junit.Test;


public class dbOperationsTest {

    @Test
    public void createUserTest() {
        int id = 0;
        User user = new User("lo", "haha");
        id = dbOperations.CreateUser(user);
        assertTrue("id must be great than 0", id > 0);
    }
    
    @Test
    public void readAllUser() {
        List<User> users = null;
        users = dbOperations.readAllUser();
        assertFalse(users.isEmpty());
    }
    
}
