/**
 *
 */
package com.riversand.structural.decorator;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author ritsarka
 *
 *Also called wrapper
 *Add behavior without affecting others
 *Example {@link OutputStream}  {@link InputStream}
 *Example Collections.synchronizedList is another example of decorator pattern
 *
 */
public class DecoratorPatternDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Sandwich simpleSandwich = new Simplesandwich();
        Sandwich breadTypeDecorator = new BreadTypeDecorator(simpleSandwich, "brown");
        Sandwich meatDecorator = new MeatDecorator(breadTypeDecorator, "Chicken");
        Sandwich fillingDecorator = new FillingDecorator(meatDecorator, "Mayonize");
        System.out.println(fillingDecorator.make());
    }
}

interface Sandwich {
    String make();
}

class Simplesandwich implements Sandwich {
    @Override
    public String make() {
        return "Bread";
    }
}

abstract class SandwichDecorator implements Sandwich {

    protected Sandwich customsandwich;

    public SandwichDecorator(Sandwich customsandwich) {
        super();
        this.customsandwich = customsandwich;
    }

    public SandwichDecorator() {
        super();
    }

    public String make() {
        return this.customsandwich.make();
    }

}

class BreadTypeDecorator extends SandwichDecorator {

    private String breadType;

    public BreadTypeDecorator(Sandwich customsandwich, String breadType) {
        super(customsandwich);
        this.breadType = breadType;
    }

    public String make() {
        return super.make() + " + " + addBreadType();
    }

    private String addBreadType() {
        return this.breadType;
    }

}

class MeatDecorator extends SandwichDecorator {

    private String meat;

    public MeatDecorator() {
        super();
    }

    public MeatDecorator(Sandwich customsandwich, String meat) {
        super(customsandwich);
        this.meat = meat;
    }

    private String addMeat() {
        return this.meat;
    }

    public String make() {
        return super.make() + " + " + addMeat();
    }

}

class FillingDecorator extends SandwichDecorator {
    private String fillingType;

    public FillingDecorator(Sandwich customsandwich, String fillingType) {
        super(customsandwich);
        this.fillingType = fillingType;
    }

    ;

    private String addFilling() {
        return this.fillingType;
    }

    public String make() {
        return super.make() + " + " + addFilling();
    }

}


