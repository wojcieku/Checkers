package Zadanie3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConvertController implements ActionListener {
    private JTextField outputField;
    private JTextField inputField;
    private JLabel inputLabel;
    private JLabel outputLabel;

    public ConvertController(JTextField outputField, JTextField inputField, JLabel inputLabel, JLabel outputLabel) {
        this.outputField = outputField;
        this.inputField = inputField;
        this.inputLabel = inputLabel;
        this.outputLabel = outputLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inputField.getText()!=null){
            String input = inputField.getText();
            double doubleInput = Double.parseDouble(input);
            if(inputLabel.getText().equals("Meter")){
                double output = Constants.getMeterInch()*doubleInput;
                outputField.setText(Double.toString(output));
            }
            if(inputLabel.getText().equals("Inch")){
                double output = Constants.getInchMeter()*doubleInput;
                outputField.setText(Double.toString(output));
            }
            if(inputLabel.getText().equals("Celsius")){
                double output = doubleInput*9/5 + 32;
                outputField.setText(Double.toString(output));
            }
            if(inputLabel.getText().equals("Fahrenheit")){
                double output =(doubleInput-32)*5/9;
                outputField.setText(Double.toString(output));
            }
            if(inputLabel.getText().equals("Kilogram")){
                double output = Constants.getKgPounds()*doubleInput;
                outputField.setText(Double.toString(output));
            }
            if(inputLabel.getText().equals("Pound")){
                double output = Constants.getPoundsKg()*doubleInput;
                outputField.setText(Double.toString(output));
            }
        }
    }
}
