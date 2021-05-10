package Zadanie1;

import javax.swing.*;
import java.awt.*;

public class InitialFrame extends JFrame {
    public JButton wpiszButton;
    public JTextField textField = new JTextField();

    public InitialFrame(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocation(50,50);
        setLayout(new FlowLayout());
        textField = new JTextField("");
        textField.setColumns(6);
        textField.setEditable(false);
        add(wpiszButton=new JButton("Wpisz"));
        add(textField);


        setVisible(true);

    }
}
