package org.hibernate.UserModel;

import static org.junit.Assert.assertTrue;

import com.userController.User;

import org.hibernate.userModel.dbOperations;
import org.junit.Test;


public class dbOperationsTest {

    @Test
    public void createUserTest() {
        int id = 0;
        User user = new User("lol", "haha");
        id = dbOperations.CreateUser(user);
        assertTrue("id must be great than 0", id > 0);
    }

    
}
