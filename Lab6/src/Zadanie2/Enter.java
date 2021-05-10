package Zadanie2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.PatternSyntaxException;

public class Enter implements KeyListener {
    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel model;
    private JTable table;
    private JButton filterButton;

    public Enter(JTextField searchTermTextField, DefaultTableModel model, JTable table, JButton filterButton) {
        this.searchTermTextField = searchTermTextField;
        this.model = model;
        this.table = table;
        this.filterButton = filterButton;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            filterButton.doClick();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
