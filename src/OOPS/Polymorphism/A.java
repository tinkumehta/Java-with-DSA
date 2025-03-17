package OOPS.Polymorphism;

public class A {
    void m1() {
        System.out.println("Print m1");
    }
}
class B extends A{
    @Override
    void m1() {
        System.out.println("Print B");
    }
}
 class C extends A {
    @Override
     void m1 () {
        System.out.println("Print C");
    }
 }

 class display {
     public static void main(String[] args) {
         A a = new A();
         B b = new B();
         C c = new C();
         A ref;
         ref = a;
         ref.m1();
         b.m1();
         ref = c;
         ref.m1();
     }
 }
