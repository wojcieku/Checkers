package Zadanie2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Constants {

    List<Publication> records = new ArrayList<>();
    Publication headers;

    public Publication getHeaders() {
        return headers;
    }

    public List<Publication> getRecords() {
        return records;
    }


    public List<Publication> CSVtoPublications(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<Publication> data = new ArrayList<>();
            String line;
            String headerLine;
            headerLine = br.readLine();
            String[] headerArray = headerLine.split(";");
            headers = new Publication(headerArray[0],
                    headerArray[1],
                    headerArray[2],
                    headerArray[3],
                    headerArray[4],
                    headerArray[5],
                    headerArray[6],
                    headerArray[7],
                    headerArray[8],
                    headerArray[9]);
            while ((line = br.readLine()) != null) {
                if (line.contains("\"")) {
                    int firstApp = line.indexOf("\"");
                    int lastApp = line.indexOf("\"", firstApp + 1);
                    char[] authors = new char[lastApp - firstApp+1];
                    line.getChars(firstApp, lastApp+1, authors, 0);
                    String temp = String.valueOf(authors);

                    String[] values = line.replace(temp, "").split(";");
                    Publication p = new Publication(
                            values[0],
                            values[1],
                            values[2],
                            temp,
                            values[4],
                            values[5],
                            values[6],
                            values[7],
                            values[8],
                            values[9]);
                    this.records.add(p);



                }else{
                String[] values = line.split(";");
                Publication p = new Publication(
                        values[0],
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        values[5],
                        values[6],
                        values[7],
                        values[8],
                        values[9]);
                this.records.add(p);
            }
            }
            return data;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return CSVtoPublications(fileName);

    }

}
