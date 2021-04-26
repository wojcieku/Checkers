package Zadanie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class LineCounter {
    private String catalogName;
    private ArrayList<String> extList;
    private int lines;
    private int filesChecked;
    private ArrayList<String> filesToCheck = new ArrayList<>();


    public LineCounter(String catalogName, ArrayList<String> extList) {
        this.catalogName = catalogName;
        this.extList = extList;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public ArrayList<String> getExtList() {
        return extList;
    }

    public int getLines() {
        return lines;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setWholeExtList(ArrayList<String> extList) {
        this.extList = extList;
    }
    public void addOneExtToExtList(String ext){
        extList.add(ext);
    }

    @Override
    public String toString() {
        return "LineCounter{" +
                "lines=" + lines +
                ", filesChecked=" + filesChecked +
                '}';
    }
    private void createListsOfFilesAndDirsToCheck(String path){
        File directoryPath = new File(path);
        File[] contentList = directoryPath.listFiles(); //uzyskanie zawartosci katalogu w postaci listy obiektow File
        if(contentList == null) {
            System.out.println("Wrong path name or directory is empty");
            System.exit(0);
        }
        for(var element : contentList){
            if(element.isFile()){
                if(extList.stream().anyMatch(e -> element.getName().endsWith(e))) { //sprawdzenie czy plik ma poszukiwane rozszerzenie
                    filesToCheck.add(element.getAbsolutePath());
                }
            } else{
                this.createListsOfFilesAndDirsToCheck(element.getAbsolutePath());  //w przypadku gdy obiekt jest katalogiem,
                                                                                  // funkcja wywolywana jest ponownie dla tego katalogu
            }
        }
    }

    private int countLinesInFile(String fileName){
        File file = new File(fileName);
        int linesInFile = 0;
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                linesInFile++;
                scanner.nextLine();
            }
        } catch(FileNotFoundException f){
            System.out.println("File not found");
        }
        return linesInFile;
    }

    public static void main(String[] args) {
        if(args.length<2){
            System.out.println("Wrong input data");
            return;
        }
        ArrayList<String> ext = new ArrayList<String>(Arrays.asList(args));
        ext.remove(0);
        var path = args[0];
        try {
            path = new File(path).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }


        LineCounter l1 = new LineCounter(path, ext);
        l1.createListsOfFilesAndDirsToCheck(l1.catalogName);
        if(l1.filesToCheck.isEmpty()){
            System.out.println("No files of given extension");
        }
        for(var element : l1.filesToCheck){
            l1.lines += l1.countLinesInFile(element);
            l1.filesChecked++;
        }
        System.out.println(l1);
    }
}
