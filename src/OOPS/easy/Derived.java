package OOPS.easy;

public class Derived extends  Base{
    Derived () {
        System.out.println("N0 aggrument construction");
    }
    Derived (String name) {
        super(name);
        System.out.println("passing the construction");
    }

    public static void main(String[] args) {
        Derived derived = new Derived("mushu");

    }
}
