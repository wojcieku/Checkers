package Zadanie1;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static final String INVALID_NUMBER_ERROR_MESSAGE = "Wpisana wartosc nie jest numeryczna,\nprosze sprobowac ponownie.";

    public static void main(String[] args) {
        InitialFrame initF = new InitialFrame("Testowanie danych wejsciowych");


        initF.wpiszButton.addActionListener(e -> {
            numericFrame numF = new numericFrame("Input");
            numF.cancel.addActionListener(e1 -> {
                numF.dispose();
            });
            numF.Ok.addActionListener(e2 -> {
                try {
                    String input = numF.typeInField.getText();
                    Float.parseFloat(input);

                    initF.textField.setText(input);
                    numF.dispose();

                } catch (NumberFormatException n) {
                    JOptionPane.showMessageDialog(initF, INVALID_NUMBER_ERROR_MESSAGE, "Błąd", JOptionPane.ERROR_MESSAGE);
                    numF.typeInField.setText("");


                }
            });
        });


    }
}
