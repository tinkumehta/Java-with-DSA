package Generics;

public class ENUM {
    enum  Week{
        MON, TUE, WED, THU, FRI, SAT, SUN
        // these are enum constants
        // public , static and final
        // since its final you can create child enums
        // type is week
    }

    public static void main(String[] args) {
        Week  week;
        week = Week.MON;
        for (Week day : Week.values()){
            System.out.println(day);
        }
    }
}
