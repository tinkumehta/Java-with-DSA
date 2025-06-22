package OOPS.Overrinding;

public class Animal {
    public void eating() {
        System.out.println("Animal is eating");
    }
    public void move () {
        System.out.println("Animal is moving");
    }
}

 class Dog extends Animal {
    @Override
     public void move() {
        System.out.println("Dog is running");
    }

     public static void main(String[] args) {
         Dog dog  = new Dog();
         dog.move();
         dog.eating();

     }
 }
