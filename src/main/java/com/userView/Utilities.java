package com.userView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
    public static boolean isRegExPatternMatching(String regExPattern, String stringToMatch) {
        Pattern pattern = Pattern.compile( regExPattern);
        Matcher matcher = pattern.matcher(stringToMatch);
        boolean matchFound = matcher.find();
        if(matchFound) {
            return true;
        } else {
           return false;
        }  
    }
    
    /**
    *convert an array of char to String
    *@param charArray array of char
    *@return string from char array
    */
    public static String arrayToString(char[] charArray){
        String str = "";
        for(int i=0; i<charArray.length;  ++i ){
            str +=charArray[i];
        }
        return str;
    }

    /**
    *convert an array of char to String
    *@param password array of char
    *@return string of password hashed
    */
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
