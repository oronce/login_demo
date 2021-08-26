package com.userView;

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
    
    public static String arrayToString(char[] charArray){
        String str = "";
        for(int i=0; i<charArray.length;  ++i ){
            str +=charArray[i];
        }
        return str;
    }
}
