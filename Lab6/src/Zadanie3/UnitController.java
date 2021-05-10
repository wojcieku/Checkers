package Zadanie3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UnitController implements ItemListener {
    private JLabel inputLabel;
    private JLabel outputLabel;
    private JComboBox comboBox;
    private DirectionController directionController;


    public UnitController(JLabel inputLabel, JLabel outputLabel, JComboBox comboBox, DirectionController directionController) {
        this.inputLabel = inputLabel;
        this.outputLabel = outputLabel;

        this.comboBox = comboBox;
        this.directionController = directionController;
    }

    public void itemStateChanged(ItemEvent e) {
        int indexSelected = comboBox.getSelectedIndex();


        if (indexSelected == 0) {

            inputLabel.setText("Meter");
            outputLabel.setText("Inch");


        }
        if (indexSelected == 1) {

            inputLabel.setText("Celsius");
            outputLabel.setText("Fahrenheit");

        }
        if (indexSelected == 2) {

            this.inputLabel.setText("Kilogram");
            this.outputLabel.setText("Pound");

        }
    }
}
