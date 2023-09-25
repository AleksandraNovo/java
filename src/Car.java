package src;

public class Car {
    private String colour;
    private int fuel;
    private final int maxFuel;
    private final String model;
    private final Engine engine;
    private int mileage;

    public Car(String colour, int maxFuel, String model, int using) {
        this.mileage = 0;
        this.colour = colour;
        this.maxFuel = maxFuel;
        this.fuel = maxFuel;
        this.model = model;
        this.engine = new Engine(using);
    }

    private class Engine {
        private boolean RunOrNot;
        private final int consumption;

        public Engine(int consumption) {
            this.RunOrNot = false;
            this.consumption = consumption;
        }
        public void refuel() {
            fuel = maxFuel;
            System.out.println("Refueled maximum");
        }
        public void stop() {
            RunOrNot = false;
            System.out.println("Stop");
        }

        public void start() {
            if (fuel <= 0) {
                System.out.println("Can't run");
            } else {
                RunOrNot = true;
                System.out.println("Is running");
            }
        }

        public boolean move() {
            if (RunOrNot) {
                if (fuel >= consumption) {
                    fuel -= consumption;
                    mileage += 100;
                    return true;
                } else {
                    stop();
                    System.out.println("Fuel is out");
                    return false;
                }
            }
            return false;
        }
    }

    public void refuel(int liters) {
        fuel = fuel + liters;
        System.out.println("Added to car " + liters + " liters fuel");
    }

    public void info() {
        System.out.println("Model " + model);
        System.out.println("Colour " + colour);
        System.out.println("Fuel left " + fuel);
        System.out.println("Mileage " + mileage);
        if (engine.RunOrNot){
            System.out.println("Engine is running");
        }else{
            System.out.println("Engine is stopped");
        }

    }
    public void startEngine() {
        engine.start();
    }

    public void stopEngine() {
        engine.stop();
    }

}
