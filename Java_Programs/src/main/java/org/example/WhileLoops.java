package org.example;

public class WhileLoops {
    public static void main(String[] args) {

        int i = 1;
        while (i <= 10) {
            System.out.println("7 X " + i + " = " + (7 * i));
            i++;
        }

        System.out.println("--------");

        int j = 0;
        do {
            System.out.println("7 X " + j + " = " + (7 * j));
            j++;
        }while (j > 0 && j <= 10);
    }
}
