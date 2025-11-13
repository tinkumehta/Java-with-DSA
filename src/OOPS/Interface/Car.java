package OOPS.Interface;

public class Car implements Engine, Break{
    @Override
    public void acc() {
        System.out.println("Car is accelarte now");
    }

    @Override
    public void start() {
        System.out.println("Car is start ..");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }

    @Override
    public void brake() {
        System.out.println("Car brake is dis avalible");
    }
}
