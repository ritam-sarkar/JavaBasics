package com.riversand.regex;

public class OtherPatterns {
    public static void main(String[] args) {
        String s1 = "paint-the-cup-cop-and-cap";
        // limit 2 means return only 2 tokens
        String [] splitArr1 = s1.split("c.p",2);
        System.out.println(splitArr1[0]+ " | "+ splitArr1[1]);
        // limit 3 means return 4 tokens
        String [] splitArr2 = s1.split("c.p",4);
        System.out.println(splitArr2[0]+ " | "+ splitArr2[1]+" | "+splitArr2[2]+ " | "+splitArr2[3]);

        // replace cop , as c.p = cup or cop but \\B means not word boundary so it will be cop only
        String str = "cat cup copp";
        String newString = str.replaceAll("c.p\\B", "()");
        System.out.println(newString);

    }
}
