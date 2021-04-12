package Zadanie3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Properties dict = new Properties();
        System.out.println("Type your key, type (String, int, double or boolean) and value, each data must be seperated with space \nType q to quit from saving data");
        while(true){
            String order = scanner.nextLine();
            String[] orderList = order.split(" "); //dane musza byc rozdzielone tylko spacja
            if(order.equals("q")){
                break;
            }
            else if(orderList.length != 3){
                System.out.println("Wrong input data");
                continue;
            }
            if(orderList[1].equals("String")){
                dict.put(orderList[0],orderList[2]);
            }
            else if(orderList[1].equals("int")){
                try{
                    Integer.parseInt(orderList[2]);
                    dict.put(orderList[0],orderList[2]);
                }catch(NumberFormatException n){
                    System.out.println("Different value type than declared");
                }
            }
            else if(orderList[1].equals("double")){
                try{
                    Double.parseDouble(orderList[2]);
                    dict.put(orderList[0],orderList[2]);
                }catch(NumberFormatException n){
                    System.out.println("Different value type than declared");
                }
            }
            else if(orderList[1].equals("boolean")){
                if(orderList[2].toLowerCase(Locale.ROOT).equals("true") || orderList[2].toLowerCase(Locale.ROOT).equals("false")){
                    dict.put(orderList[0],orderList[2]);
                } else{
                    System.out.println("Different value type than declared");
                }
            }else{
                System.out.println("Please try again");
            }
        }
        System.out.println(dict);
        System.out.println("Do you want to save to a file? [y/n]");
        String input = scanner.nextLine();
        if(input.equals("y")){
            System.out.println("Type the file's name");
            String fileName = scanner.nextLine();
            try {
                FileOutputStream outputStream = new FileOutputStream(fileName);
                dict.store(outputStream, "Sample file");
            } catch(FileNotFoundException f){}
            catch (IOException i){
                System.out.println("IOException");
            }
        }

    }
}
