package OOPS.Abstract;

public class Son extends  Parent{
    @Override
    void carrer() {
        System.out.println("I am a Engineer");
    }

    @Override
    void parten(String name, int age) {
        System.out.println("I LOVE you " + name + " she is " + age);
    }
}
