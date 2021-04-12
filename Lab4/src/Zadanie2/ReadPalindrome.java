package Zadanie2;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ReadPalindrome {
    private Set<Palindrome> palindromeSet;

    public Set<Palindrome> getPalindromeSet() {
        return palindromeSet;
    }

    public void readOne(String fileName) {

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                Object p = ois.readObject();
                System.out.println(p);
            } catch(FileNotFoundException f){
                System.out.println("File not found");
            } catch(java.io.EOFException eofException){
                System.out.println("");
            }
            catch(StreamCorruptedException s){
                System.out.println("Incorrect stream header");
            } catch(IOException i){
                System.out.println("Error while reading the stream");
            } catch(ClassNotFoundException c){
                System.out.println("Class not found");
            }
    }
    public void read(String fileName){
        Set<Object> palindroms = new HashSet<Object>();
        try{
            FileInputStream fis = new FileInputStream(fileName);
            boolean cont = true;
            while(cont){
                ObjectInputStream ois = new ObjectInputStream(fis);
                Object p = ois.readObject();
                if(p != null) {
                    palindroms.add(p);
                }
                else{cont = false;}
            }
            System.out.println(palindroms);


        } catch(java.io.EOFException e){}
        catch(IOException i){
            System.out.println("Error while reading the stream");
        } catch(ClassNotFoundException c){
            System.out.println("Class not found");
        }
        System.out.println(palindroms);

    }

    public static void main(String[] args) {
        ReadPalindrome palindromeReader = new ReadPalindrome();
        palindromeReader.readOne("palindrome.plr");
        palindromeReader.read("F:\\PRM2T\\Lab4\\test");
    }
}



