package com.userController;




import org.hibernate.userModel.dbOperations;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.userView.AppView;

import org.hibernate.SessionFactory;

/**
 * run appliction
 *
 */
public class App 
{
    public static void main( String[] args ){

        SessionFactory factory = dbOperations.buildSessionFactory(null);
       
        new AppView();
        
       
    } 

    
    public static String hash(String password) {
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            String salt = "some_random_salt";
            String passWithSalt = password + salt;
            byte[] passBytes = passWithSalt.getBytes();
            byte[] passHash = sha256.digest(passBytes);   
            System.out.println("passHash: " + passHash[0]);          
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< passHash.length ;i++) {
                sb.append(Integer.toString((passHash[i] & 0xff) + 0x100, 16).substring(1));         
            }
            String generatedPassword = sb.toString();
            return generatedPassword;
        } catch (NoSuchAlgorithmException e) { e.printStackTrace(); }       
        return null;
    }
}


