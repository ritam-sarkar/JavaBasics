package com.riversand.packagedemo.skies;

/**Take any one of the Sun so if I open this commented
 * line, then I can face issue in next line as it is already defined **/
//import com.ibm.packagedemo.solarfamily.Sun;
import com.riversand.packagedemo.stars.Sun; // line1
class Sky {
    public static void main(String[] args) {
        Sun sun = new Sun(); // line 3

    }
}
