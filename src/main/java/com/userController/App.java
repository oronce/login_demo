package com.userController;



import com.userView.AppView;
import com.userView.Utilities;

import org.hibernate.userModel.HibernateUtils;
import org.hibernate.userModel.dbOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * run appliction
 *
 */
public class App 
{
    public static void main( String[] args ){

        //SessionFactory factory = getSessionFactory();
       
        dbOperations.CreateUser(new User("username", "password"));
        System.out.println("users: " +  dbOperations.readAllUser());
        
    

    } 

    
}


