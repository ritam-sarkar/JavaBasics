package com.riversand.solid;

public class OpenClosedPrincipal {

    // in future I can add one more class Triangle , for that I do not need to modify the codebase
    // so its open for extension , and closed for modification
    interface Shape {
        double area();
    }

    class Circle implements Shape {
        double radius;
        public double area() { return Math.PI * radius * radius; }
    }

    class Rectangle implements Shape {
        double width, height;
        public double area() { return width * height; }
    }

}
