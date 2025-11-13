package OOPS.Abstract;

public class Daughter extends Parent{
    @Override
    void carrer() {
        System.out.println("I am become a doctor");
    }

    @Override
    void parten(String name, int age) {
        System.out.println(name + " This is my life parten " + age);
    }
}
