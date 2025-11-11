package OOPS.Polymorphism;

public class print {
    public static void main(String[] args) {
        shape shape = new shape();
        circle circle = new circle();
        square square =new square();
        circle.area();
        square.area();
    }
}
