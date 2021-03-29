package Zad3;

import java.util.Scanner;
import java.util.TreeSet;

public class LogOperation {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input:");
        String input = scanner.nextLine();
        try {
            if (input.contains("*")) {
                String[] splitInput = input.split("\\*");

                String p1 = splitInput[0];
                p1 = p1.replaceAll("\\]", "");
                p1 = p1.replaceAll("\\[", "");
                String p2 = splitInput[1];
                p2 = p2.replaceAll("\\]", "");
                p2 = p2.replaceAll("\\[", "");

                String[] elements1 = p1.split("\\,");
                String[] elements2 = p2.split("\\,");

                TreeSet<Integer> set1 = new TreeSet<>();
                TreeSet<Integer> set2 = new TreeSet<>();

                for (var element : elements1) {
                    int i = Integer.parseInt(element);
                    Integer e = i;
                    set1.add(e);
                }
                for (var element : elements2) {
                    int i = Integer.parseInt(element);
                    Integer e = i;
                    set2.add(e);
                }


                set1.retainAll(set2);
                System.out.println("Output:");
                System.out.println(set1);
            } else if (input.contains("+")) {
                String[] splitInput = input.split("\\+");


                String p1 = splitInput[0];
                p1 = p1.replaceAll("\\]", "");
                p1 = p1.replaceAll("\\[", "");
                String p2 = splitInput[1];
                p2 = p2.replaceAll("\\]", "");
                p2 = p2.replaceAll("\\[", "");

                String[] elements1 = p1.split("\\,");
                String[] elements2 = p2.split("\\,");

                TreeSet<Integer> set1 = new TreeSet<>();
                TreeSet<Integer> set2 = new TreeSet<>();

                for (var element : elements1) {
                    int i = Integer.parseInt(element);
                    Integer e = i;
                    set1.add(e);
                }
                for (var element : elements2) {
                    int i = Integer.parseInt(element);
                    Integer e = i;
                    set2.add(e);
                }

                set1.addAll(set2);
                System.out.println("Output:");
                System.out.println(set1);
            } else if (input.contains("-")) {
                String[] splitInput = input.split("\\-");

                String p1 = splitInput[0];
                p1 = p1.replaceAll("\\]", "");
                p1 = p1.replaceAll("\\[", "");
                String p2 = splitInput[1];
                p2 = p2.replaceAll("\\]", "");
                p2 = p2.replaceAll("\\[", "");

                String[] elements1 = p1.split("\\,");
                String[] elements2 = p2.split("\\,");

                TreeSet<Integer> set1 = new TreeSet<>();
                TreeSet<Integer> set2 = new TreeSet<>();

                for (var element : elements1) {
                    int i = Integer.parseInt(element);
                    Integer e = i;
                    set1.add(e);
                }
                for (var element : elements2) {
                    int i = Integer.parseInt(element);
                    Integer e = i;
                    set2.add(e);
                }

                set1.removeAll(set2);
                System.out.println("Output:");
                System.out.println(set1);


            } else {
                System.out.println("Improper input data");
            }
        } catch (NumberFormatException e) {
            System.out.println("Improper data type");
        }

    }
}
