package Zadanie3;

import javax.swing.*;
import java.awt.*;

public class View {
    public int direction = 0;
    public View() {
        JTextField inputField = new JTextField(10);
        JTextField outputField = new JTextField(20);
        JLabel inputLabel = new JLabel("Meter");
        JLabel outputLabel = new JLabel("Inch");
        JButton reverseButton = new JButton("Reverse");

        JButton convertButton = new JButton("Convert");
        String[] direction = {"Meters - inches", "Celsius - Fahrenheit", "Kilograms - Pounds"};
        JComboBox cb = new JComboBox(direction);

        DirectionController dc = new DirectionController(inputLabel, outputLabel);
        reverseButton.addActionListener(dc); //kierunek: 0 - tak jak napisy, 1 - odwrotnie

        UnitController uc = new UnitController(inputLabel, outputLabel, cb, dc); //bierze wybrane jednostki, kierunek z directionControllera i zmienia labele
        cb.addItemListener(uc);

        ConvertController cc = new ConvertController(outputField, inputField, inputLabel, outputLabel);
        convertButton.addActionListener(cc);



        JFrame frame = new JFrame("Converter");
        frame.add(inputField);
        frame.add(inputLabel);
        frame.add(outputField);
        frame.add(outputLabel);
        frame.add(reverseButton);
        frame.add(convertButton);

        frame.add(cb);



        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(200,50);
        frame.setVisible(true);
    }
}