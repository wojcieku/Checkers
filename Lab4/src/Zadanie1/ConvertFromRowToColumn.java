package Zadanie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ConvertFromRowToColumn {
    private String[] numbers;

    @Override
    public String toString() {
        return "ConvertFromRowToColumn{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConvertFromRowToColumn that = (ConvertFromRowToColumn) o;
        return Arrays.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }

    public String getValue(int index){
        return numbers[index];
    }
    private File read(String fileName){
        return new File(fileName);
    }

    public void read(File file) {
        try {
            Scanner scanner = new Scanner(file);
            String signs = scanner.nextLine();  //z tresci zadania: plik ma jeden wiersz
            numbers = signs.split(" ");
        }
        catch (FileNotFoundException f){
            System.out.println("File not found");
        }
    }

    public File write(String fileName){
        return new File(fileName);
    }

    public void write(File file){
        try {
            FileWriter fw = new FileWriter(file);
            for (var number : numbers) {
                fw.write(number + "\n");
            }
            fw.close();
        }
        catch (IOException i){
            System.out.println("File is a directory / file does not exist and cannot be created / file cannot be opened");
        }
    }


    public static void main(String[] args) {
        ConvertFromRowToColumn c1 = new ConvertFromRowToColumn();
        ConvertFromRowToColumn c2 = new ConvertFromRowToColumn();

        c1.read(c1.read(args[0])); // odczyt i zapis danych do wskazanego pliku
        c1.write(c1.write(args[1]));

        System.out.println(c1); //test pozostalych metod
        System.out.println("get value with index 2: "+c1.getValue(2));
        System.out.println("c1 equals c2: "+c1.equals(c2));
        System.out.println("c1 hashCode: "+c1.hashCode());
    }
}
