package com.company;

public class Main {
    static int add(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        int sum = add(5,3);
        System.out.println("suma="+sum);
        String[] tablica_tekstow = new String[100];

        for (int i = 0; i< tablica_tekstow.length; i++) {
            System.out.println(" "+tablica_tekstow[i]);
        }

    }
}
