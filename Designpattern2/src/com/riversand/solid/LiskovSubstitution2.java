package com.riversand.solid;

public class LiskovSubstitution2 {
    public static void main(String[] args) {
        Rectangle rect = new Square(); // LSP violated here
        rect.setWidth(5);
        rect.setHeight(10);  // Expect area = 5 × 10 = 50
        System.out.println("Area = " + rect.getArea()); // Output: 100 (unexpected)


        Shape r = new Rectangle2(5, 10);
        Shape s = new Square2(7);

        System.out.println("Rectangle area: " + r.getArea()); // 50
        System.out.println("Square area: " + s.getArea());     // 49
    }

    static class Rectangle {
        protected int width;
        protected int height;

        public void setWidth(int w) { width = w; }
        public void setHeight(int h) { height = h; }

        public int getArea() {
            return width * height;
        }
    }
    static class Square extends Rectangle {
        @Override
        public void setWidth(int w) {
            width = height = w; // forces height = width
        }

        @Override
        public void setHeight(int h) {
            width = height = h; // forces width = height
        }
    }
    interface Shape {
        int getArea();
    }

    static class Rectangle2 implements Shape {
        private int width;
        private int height;

        public Rectangle2(int w, int h) {
            this.width = w;
            this.height = h;
        }

        public int getArea() {
            return width * height;
        }
    }

    static class Square2 implements Shape {
        private int side;

        public Square2(int side) {
            this.side = side;
        }

        public int getArea() {
            return side * side;
        }
    }




}
