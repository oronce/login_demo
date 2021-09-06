package com.userController;

import org.hibernate.userModel.dbOperations;
import com.userView.AppView;
import org.hibernate.SessionFactory;

/**
 * run appliction
 *
 */
public class App 
{
    public static void main( String[] args ){
        

        dbsetUp();
        new AppView();
        
        
    } 

    public static void dbsetUp() {
        SessionFactory factory = dbOperations.buildSessionFactory(null);
    }
    
}


