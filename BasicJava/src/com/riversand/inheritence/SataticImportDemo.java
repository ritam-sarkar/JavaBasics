package com.riversand.inheritence;

//Rule : Only public members are allowed for static import
//import static com.riversand.inheritence.level2.MyParent1.dispaly;
import com.riversand.inheritence.level2.MyParent1;

/**
 * When a parent class in inherited all its static and non static memers are inherited
 * But new MyParent().member is not accessible(protedted or default) , its considered as new instance
 * Exception : static protected members are accesible using Parent class or its object , because at the time of class load the child class has the all static parent and its own members installed in it
 */
public class SataticImportDemo extends MyParent1 {

    public static void main(String[] args) {
        // Rule : any protected members are accisible as they are inherited
        display(); // display parent's method
        // Rule : only static protected members are accesible
        System.out.println(new MyParent1().id);
        new MyParent1().display();
        //Rule : But non static protected members are not accesible
        //System.out.println(new MyParent1().name);
    }
    // Rule : static methods does not perticipate in overriding , so this display method is just another non static method
    void dispaly(){
        // Rule : Both static and non static is inherited
        System.out.println("Child display"+name+ " id"+ id);

    }


}
