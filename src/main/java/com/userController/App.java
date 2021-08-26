package com.userController;


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

        //open a pool connection with database
        //HibernateUtils.loadSessionFactory();
        AppView appView = new AppView();
        

    } 

}


