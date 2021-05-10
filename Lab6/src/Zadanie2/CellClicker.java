package Zadanie2;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CellClicker implements MouseListener {
    private JTextField displayFullText = new JTextField(15);
    private JTable table = new JTable();

    public CellClicker(JTextField displayFullText, JTable table) {
        this.displayFullText = displayFullText;
        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        int row = target.getSelectedRow();
        int column = target.getSelectedColumn();
        Object value = table.getValueAt(row, column);
        String text = value.toString();
        displayFullText.setText(text);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
