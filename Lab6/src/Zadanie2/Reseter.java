package Zadanie2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.PatternSyntaxException;

public class Reseter implements ActionListener {
    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel model;
    private JTable table;

    public Reseter(JTextField searchTermTextField, DefaultTableModel model, JTable table) {
        this.searchTermTextField = searchTermTextField;
        this.model = model;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        sorter.setRowFilter(null);
        table.setRowSorter(sorter);
    }
}
