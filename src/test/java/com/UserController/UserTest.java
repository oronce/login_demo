package com.UserController;

import static org.junit.Assert.assertEquals;

import com.userController.User;

import org.junit.BeforeClass;
import org.junit.Test;

public  class UserTest {

    private User user = new User();

   
    @Test
    public void ConstructorTest(){
        user = new User("username", "password");
        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void setUsernameTest(){
        user.setUsername("ryan");
        assertEquals("ryan", user.getUsername());
    }
    
    @Test
    public void setPasswordTest() {
        user.setPassword("myNewPass");
        assertEquals("myNewPass", user.getPassword());
    }

}
