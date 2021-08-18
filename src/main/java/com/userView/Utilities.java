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
}
