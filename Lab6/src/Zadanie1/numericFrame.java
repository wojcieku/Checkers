package Zadanie1;

import javax.swing.*;
import java.awt.*;

public class numericFrame extends JFrame {
    public JTextField typeInField = new JTextField();
    public JButton Ok = new JButton();
    public JButton cancel = new JButton();
    public numericFrame(String title) throws HeadlessException {
        super(title);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocation(500,50);
        setLayout(new FlowLayout());

        JLabel info = new JLabel("Wpisz wartosc numeryczna:");
        add(info);
        add(typeInField=new JTextField(10));
        add(Ok=new JButton("Ok"));
        add(cancel=new JButton("Cancel"));

        setVisible(true);

    }
}
