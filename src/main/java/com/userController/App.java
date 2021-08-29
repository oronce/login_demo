package com.userController;


import com.mysql.cj.xdevapi.SessionFactory;
import com.userView.AppView;
import com.userView.Utilities;

import org.hibernate.userModel.HibernateUtils;
import org.hibernate.userModel.dbOperations;

/**
 * run appliction
 *
 */
public class App 
{
    public static void main( String[] args ){

        //AppView appView = new AppView();
        int id = dbOperations.CreateUser(new User("livier", "password"));    
        System.out.println(id);   
    } 
}


