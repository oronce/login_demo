package com.userController;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.userModel.dbOperations;

public class LogIn {

    public static void checkCredentialsMatching(String username, String password) {
        User user = null;
        List<User> users = null;
        users = dbOperations.readByUsername(username);

        if (users.isEmpty()) {
            System.out.println("username is incorrect or doesn't exit ");
        }else{
            user = users.get(0);
            if ( user.getPassword().compareTo(password)==0 ) {
                System.out.println("Welcome " + user.getUsername());
            }else{
                System.out.println("wrong password try again");
            }
        }
    }

}
