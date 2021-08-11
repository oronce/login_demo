package com.userController;

import org.hibernate.userModel.dbOperations;

public class SignUp {


    public static void registeredUser(User user) {
        
        if (isUsernameExist(user)) {
            System.out.println("username already used\n type another one");
        }else{
            //data checkin
             dbOperations.CreateUser(user);
        }
        
        
    }

    public static  boolean isUsernameExist(User user) {
        if ( dbOperations.readByUsername(user.getUsername()).isEmpty() ) {
            return false;
        }else{
            return true;
        }
    }
}
