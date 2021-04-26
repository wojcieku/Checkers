package Zadanie2;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;

public class Comparator {
    private String dir1;
    private String dir2;
    private int diffFilesCounter;
    private ArrayList<String> filesList1 = new ArrayList<>();
    private ArrayList<String> filesList2 = new ArrayList<>();
    private ArrayList<String> matchingFiles = new ArrayList<>();


    public Comparator(String dir1, String dir2) {
        this.dir1 = dir1;
        this.dir2 = dir2;
    }


    public void setDiffFilesCounter(int diffFilesCounter) {
        this.diffFilesCounter = diffFilesCounter;
    }

    public String getDir2() {
        return dir2;
    }

    public int getDiffFilesCounter() {
        return diffFilesCounter;
    }

    public void setDir1(String dir1) {
        this.dir1 = dir1;
    }

    public void setDir2(String dir2) {
        this.dir2 = dir2;
    }

    public String getDir1() {
        return dir1;
    }

    public ArrayList<String> getFilesList1() {
        return filesList1;
    }

    public ArrayList<String> getFilesList2() {
        return filesList2;
    }

    public ArrayList<String> getMatchingFiles() {
        return matchingFiles;
    }

    private void createListOfFiles1(String path){
        File directoryPath = new File(path);
        File[] contentList = directoryPath.listFiles();
        if(contentList == null) {
            System.out.println("Wrong path name or directory is empty");
            System.exit(0);
        }
        for(var element : contentList){
            if(element.isFile()){
                filesList1.add(element.getAbsolutePath());
            } else{
                this.createListOfFiles1(element.getAbsolutePath());
            }
        }
    }
    private void createListOfFiles2(String path){
        File directoryPath = new File(path);
        File[] contentList = directoryPath.listFiles();
        if(contentList == null) {
            System.out.println("Wrong path name or directory is empty");
            System.exit(0);
        }
        for(var element : contentList){  //catch nullpointerexception
            if(element.isFile()){
                filesList2.add(element.getAbsolutePath());
            } else{
                this.createListOfFiles2(element.getAbsolutePath());
            }
        }
    }

    private void compareFiles(String path1, String path2){
        File file1 = new File(path1);
        File file2 = new File(path2);
        if(file1.getName().equals(file2.getName())){ //porownanie nazw plikow
            matchingFiles.add(path1);
            matchingFiles.add(path2);
        }
        else{this.diffFilesCounter++;}
    }


    public static void main(String[] args) {
        if(args.length <1){
            System.out.println("Wrong input data");
            return;
        }

        Comparator c1 = new Comparator(args[0], args[1]);

        c1.createListOfFiles1(c1.dir1); //analiza zawartości katalogow, utworzenie list plikow kazdego katalogu
        c1.createListOfFiles2(c1.dir2);

        if(!c1.filesList1.isEmpty() && !c1.filesList2.isEmpty()) { //porownanie plikow z obu list (warunek: katalogi nie sa puste -> listy nie sa puste)
            for (var path1 : c1.filesList1) {
                for (var path2 : c1.filesList2) {
                    c1.compareFiles(path1, path2);
                }
            }
        }else{
            System.out.println("One of the directories is empty");
            System.exit(0);
        }

        for(var path : c1.getMatchingFiles()){
            File file = new File(path); //lista z plikami zawiera jedynie sciezki, wiec potrzebne jest utworzenie obiektu do uzyskania informacji o pliku
            System.out.println("size of "+file.getName()+" is "+file.length()+" bytes");  //wypisanie rozmiaru i ostatniej daty modyfikacji dla kazdego pliku
            System.out.println(new Date(file.lastModified()));
        }
        c1.setDiffFilesCounter(c1.getFilesList1().size()+c1.getFilesList2().size()-c1.getMatchingFiles().size()); //liczba plikow bez dopasowania
        System.out.println("\nFiles without match: "+c1.diffFilesCounter);


    }
}