package com.userController;

import org.hibernate.userModel.dbOperations;
import com.userView.AppView;
import org.hibernate.SessionFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;


/**
 * run appliction
 *
 */
public class App 
{
    public static void main( String[] args ) {
        
        //dbsetUp();
        lunchGUi();
        
    } 

    public static void dbsetUp() {
        SessionFactory factory = dbOperations.buildSessionFactory(null);
    }

    public static void lunchGUi() {
        new AppView();
    }
    
}


