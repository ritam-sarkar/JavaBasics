package com.riversand.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicPatterns {
    public static void main(String[] args) {
        // [] means match exactly one character and it denotes OR operation
        Matcher matcher = RegexUtil.getMatcher("I am fine to dine at nine","[fdn]ine");
        groupWisePrint(matcher);
        matcher = RegexUtil.getMatcher("sun soon son","s.n");
        groupWisePrint(matcher);
        matcher = RegexUtil.getMatcher("I am 17","[a-f0-7]");
        groupWisePrint(matcher);
        // /d is digit , digit and ( 2 or 3)
        matcher = RegexUtil.getMatcher("AB $23_","\\d[23]");
        groupWisePrint(matcher);
        // not word which is space and $ , [$] denotes only $
        matcher = RegexUtil.getMatcher("AB $23_","\\W[$]");
        groupWisePrint(matcher);
        System.out.println("-------Boundaries------");
        // /B for nonword and /b for word boundaries
        matcher = RegexUtil.getMatcher("the leather in their coat made her seethe ","\\bthe");
        groupWisePrint(matcher);
        matcher = RegexUtil.getMatcher("the leather in their coat made her seethe ","\\Bthe");
        groupWisePrint(matcher);
        // the starts either beginning of the word or end of the word
        matcher = RegexUtil.getMatcher("the leather in their coat made her seethe ","\\bthe|the\\b");
        groupWisePrint(matcher);
        // the starts either begining of the line or end of the line
        // ^ for start line boundary $ for line end boundary
        matcher = RegexUtil.getMatcher("the sun rises in the east \n Look the beauty of the sunthe","^the|the$");
        groupWisePrint(matcher);

        /**
         * x? 0<= x <= 1
         * x* x >= 0
         * x+ x >= 1
         */
        matcher = RegexUtil.getMatcher("This is food for fod","fo?d");
        groupWisePrint(matcher);
        matcher = RegexUtil.getMatcher("This is food for fod","fo+d");
        groupWisePrint(matcher);


    }
    private static void groupWisePrint(Matcher matcher){
        while (matcher.find()){
            System.out.println(matcher.group()+" starts at "+matcher.start()+" ends at "+matcher.end());
        }
        System.out.println("-----------------------------------");
    }
}
