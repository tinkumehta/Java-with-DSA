package OOPS.easy;

public class Base {
    String name ;
    Base () {
        this(" ");
        System.out.println("No aggrument of base class");
    }
    Base (String name) {
        this.name = name;
        System.out.println("calling the parmeterized function of the base class");
    }

}
