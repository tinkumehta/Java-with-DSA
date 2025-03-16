package OOPS.easy;

public class MountineBike  extends  Bicycle{
    public int seatHeight;
    public MountineBike(int gear, int speed, int startHeight) {
        super(gear, speed);
        seatHeight = startHeight;
    }
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    @Override
    public String toString() {
        return (super.toString() + "\n No of Height" + seatHeight);
    }

    public static void main(String[] args) {
        MountineBike mountineBike = new MountineBike(3, 100, 50);
        System.out.println(mountineBike.toString());
    }
}
