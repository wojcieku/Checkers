package Zadanie2;

import javax.swing.table.DefaultTableModel;
import Zadanie2.Constants;

import java.util.List;

public class Model extends DefaultTableModel {
    public Model() {
        super(objectArrayForConstructor(),headersForConstructor());
    }
    public static Object[][] objectArrayForConstructor(){
        Constants c1 = new Constants();
        c1.CSVtoPublications("F:\\Kuba\\Dokumenty\\studia\\PW\\semestr 2\\PRM2\\L6\\oryginal.csv");
        List<Publication> temp = c1.getRecords();
        Object[][] records = new Object[temp.size()][10];

        for(int i = 0; i<temp.size(); i++){
            Publication p = temp.get(i);
            records[i][0] = p.getKey();
            records[i][1] = p.getItemType();
            records[i][2] = p.getYear();
            records[i][3] = p.getAuthor();
            records[i][4] = p.getTitle();
            records[i][5] = p.getPublicationtitle();
            records[i][6] = p.getISBN();
            records[i][7] = p.getISSN();
            records[i][8] = p.getDOI();
            records[i][9] = p.getDate();

        }
        return records;
    };
    public static Object[] headersForConstructor(){
        Constants c1 = new Constants();
        c1.CSVtoPublications("F:\\Kuba\\Dokumenty\\studia\\PW\\semestr 2\\PRM2\\L6\\publication_list.csv");
        Object[] headers = new Object[10];
        Publication headPub = c1.getHeaders();
        headers[0] = headPub.getKey();
        headers[1] = headPub.getItemType();
        headers[2] = headPub.getYear();
        headers[3] = headPub.getAuthor();
        headers[4] = headPub.getTitle();
        headers[5] = headPub.getPublicationtitle();
        headers[6] = headPub.getISBN();
        headers[7] = headPub.getISSN();
        headers[8] = headPub.getDOI();
        headers[9] = headPub.getDate();
        return headers;
    };

}