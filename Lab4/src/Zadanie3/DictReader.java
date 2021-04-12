package Zadanie3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class DictReader {
    public static void main(String[] args) {
        Properties dict = new Properties();
        try {
            FileInputStream fis = new FileInputStream("zadanie3output");
            dict.load(fis);
        } catch(FileNotFoundException f){
            System.out.println("File not found");
            System.exit(0);
        } catch(IOException i){}
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Type key you want to check \nType q to quit");
            String key = scanner.nextLine();
            if(key.equals("q")){System.exit(0);}
            else if (dict.containsKey(key)){
                System.out.println(dict.getProperty(key)+"\n");
            }
            else{
                System.out.println("There is no such key");
            }
        }

    }
}
