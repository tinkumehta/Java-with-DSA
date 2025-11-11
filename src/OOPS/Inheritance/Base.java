package OOPS.Inheritance;

public class Base {
    double l=1;
    double b=2;
    double h =3;
    Base(){
        System.out.println(l+ " "   + b +" " + h + " ");
    }
    Base(Base other){

    }
    Base (double l, double r){
        this.l =l;
        this.h = r;
        System.out.println(l + " " + r);
    }
}
