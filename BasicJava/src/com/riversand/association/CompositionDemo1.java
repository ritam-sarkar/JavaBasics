package com.riversand.association;

/*   https://www.upgrad.com/blog/what-is-composition-in-java-with-examples/#:~:text=A%20composition%20in%20Java%20between,object%20dies%2C%20nobody%20parts%20exist. */
public class CompositionDemo1 {

    static class Car {

        private Engine engine;
        Car(){
          this.engine = new Engine();
        }
        void drive(){
            engine.startEngine();
            System.out.println("Accelerator pressed");
        }
        void parkCar(){
            System.out.println("Press break");
            engine.stopEngine();
        }
    }
    static class Engine {

        void startEngine(){
            System.out.println("Engine starts");
        }
        void stopEngine(){
            System.out.println("Engine stops");
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println("---------drive car --------------");
        car.drive();
        System.out.println("---------park car --------------");
        car.parkCar();
    }

}
