package Zadanie2;



import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class View {

    public View() {

        JTextField searchTermTextField = new JTextField(26);
        JTextField displayFullText = new JTextField(70);
        JButton filterButton = new JButton("Filter");
        JButton resetButton = new JButton("Reset");
        JTable table = new JTable();
        JLabel contentLabel = new JLabel("Cell's content");



        Model model = new Model();
        table.setModel(model);



        Controller controller = new Controller(searchTermTextField, model, table);
        Reseter reseter = new Reseter(searchTermTextField, model, table);
        CellClicker cellClicker = new CellClicker(displayFullText, table);
        filterButton.addActionListener(controller);
        resetButton.addActionListener(reseter);
        table.addMouseListener(cellClicker);
        Enter enterListner = new Enter(searchTermTextField, model, table,filterButton);
        searchTermTextField.addKeyListener(enterListner);


        JPanel ctrlPane = new JPanel();
        JPanel displayPanel = new JPanel();


        ctrlPane.add(searchTermTextField);
        ctrlPane.add(filterButton);
        ctrlPane.add(resetButton);
        displayPanel.add(contentLabel);
        displayPanel.add(displayFullText);



        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setPreferredSize(new Dimension(1000, 500));
        tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Publications",
                TitledBorder.CENTER, TitledBorder.TOP));
        JSplitPane spl1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, displayPanel);
        spl1.setDividerLocation(40);
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spl1, tableScrollPane);
        splitPane.setDividerLocation(80);
        splitPane.setEnabled(false);



        JFrame frame = new JFrame("PRM2T - Swing MVC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(splitPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
