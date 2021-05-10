package Zadanie3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DirectionController implements ActionListener {
    public int direction = 0;
    private JLabel inputLabel;
    private JLabel outputLabel;

    public int getDirection() {
        return direction;
    }

    public DirectionController(JLabel inputLabel, JLabel outputLabel) {
        this.inputLabel = inputLabel;
        this.outputLabel = outputLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String inputNow = inputLabel.getText();
        String outputNow = outputLabel.getText();
        inputLabel.setText(outputNow);
        outputLabel.setText(inputNow);

    }
}
