package OOPS.Access;

public class display {
    public static void main(String[] args) {
        A a = new A(3, "Tinku");
        System.out.println(a.name);
        System.out.println(a.getNum());
        a.setNum(9);
        System.out.println(a.getNum());
    }
}
