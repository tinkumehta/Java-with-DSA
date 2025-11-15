package Generics;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student kunal = new Student(1, 95.78f);
        Student sona = new Student(2, 92.78f);
        Student ranjit = new Student(3, 90.78f);
        Student tink = new Student(4, 89.78f);

        Student list [] = {kunal, sona, ranjit, tink};

        System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));

        if (kunal.compareTo(ranjit) < 0){
            System.out.println(kunal.compareTo(ranjit));
            System.out.println("Ranjit has more marks");
        }
    }
}
