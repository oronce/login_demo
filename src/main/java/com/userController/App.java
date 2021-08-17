package com.userController;
import java.util.regex.*;

import com.userView.AppView;
/**
 * run appliction
 *
 */
public class App 
{
    public static void main( String[] args ){

        AppView appView = new AppView();
        
        Pattern pattern = Pattern.compile( "^.{3,}$");
        Matcher matcher = pattern.matcher("ooo;;");
        boolean matchFound = matcher.find();
        if(matchFound) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }  
    }

}
