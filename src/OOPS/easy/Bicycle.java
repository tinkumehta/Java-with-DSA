package OOPS.easy;

public class Bicycle {
    public int gear;
    public int speed;

    Bicycle(int gear, int speed){
        this.gear = gear;
        this.speed = speed;
    }
    public void applyBreak(int decerment) {
        speed -= decerment;
    }
    public void applySpeed (int increment) {
        speed += increment;
    }
    public String toString() {
        return ("No of gear " + gear + "\n" + "No of speed " + speed);
    }

}
