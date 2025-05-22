package com.riversand.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

    public static Matcher getMatcher(String text, String regex){
        Pattern pattern1 = Pattern.compile(regex);
        return pattern1.matcher(text);
    }
    public static boolean isMatch(String text, String regex){
        Pattern pattern1 = Pattern.compile(regex);
        return pattern1.matcher(text).matches();
    }
}
