package Zadanie2;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;


import static Zadanie2.Palindrome.isPalindrome;

public class WritePalindrome {
    /**
     * Writes the given palindrome into the given file.
     */
    public WritePalindrome(Palindrome p, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName, true))) {
            oos.writeObject(p);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }




    /**
     * Tests the class.
     * @param args not used.
     */
    public static void main(String[] args) {
        new WritePalindrome(
                new Palindrome("Kobyła ma mały bok."),
                "palindrome");


        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        System.out.println("Type your palindromes:");
        while(counter<3) {   //zapis trzech palindromow podanych przez uzytkownika
            String palindromeCandidate = scanner.nextLine();
            if(isPalindrome(palindromeCandidate)){
                new WritePalindrome(
                        new Palindrome(palindromeCandidate),
                        "test");
            }
            counter++;
        }

    }
}

