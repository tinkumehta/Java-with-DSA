package OOPS.AccessModifier;

public class defaulta {
    void display () {
        System.out.println("Hello world !");
    }
}

class access {
    public static void main(String[] args) {
        defaulta d = new defaulta();
        d.display();
    }
}
