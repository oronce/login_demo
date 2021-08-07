package com.rocee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * run appliction
 *
 */
public class App 
{
    public static void main( String[] args ){
        User user = new User("ryan", "passpass");
        LogIn.checkCredentialsMatching(user.getUsername(), user.getPassword());
    }
}
