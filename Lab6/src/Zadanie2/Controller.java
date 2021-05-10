package Zadanie2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.regex.PatternSyntaxException;

import Zadanie2.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class Controller implements ActionListener {


    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel model;
    private JTable table;

    public Controller(JTextField searchTermTextField, DefaultTableModel model, JTable table) {
        this.searchTermTextField = searchTermTextField;
        this.model = model;
        this.table = table;
    }



    @Override
    public void actionPerformed(ActionEvent e) {


        String searchTerm = searchTermTextField.getText();

        final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);

        if (searchTerm.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm));

            } catch (PatternSyntaxException pse) {
                System.out.println("Bad regex pattern");
            }
        }
        table.setRowSorter(sorter);
    }
}


