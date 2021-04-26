package Zadanie3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Window {
    int filesCounter;
    int subdirCounter;

    public void count(String path) {
        filesCounter = 0;
        subdirCounter = 0;
        createListOfFiles(path);
    }

    private void createListOfFiles(String path) {
        File directoryPath = new File(path);
        File[] contentList = directoryPath.listFiles();
        if (contentList == null) {
            System.out.println("Wrong path name or directory is empty");
            return;
        }
        for (var element : contentList) {
            if (element.isFile()) {
                filesCounter++;
            } else {
                subdirCounter++;
                this.createListOfFiles(element.getAbsolutePath());
            }
        }
    }

    public static void main(String args[]) {
        Window w1 = new Window();
        JFrame frame = new JFrame("Analizator Folderów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JLabel path = new JLabel("");
        JLabel result = new JLabel("");

        JPanel buttonsPanel = new JPanel();

        JButton choose = new JButton("Wybierz");
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int returnVal = fileChooser.showOpenDialog(buttonsPanel);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    String absolutePath = file.getAbsolutePath();
                    path.setText(absolutePath);
                }
            }
        });

        JButton count = new JButton("Oblicz");
        count.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                w1.count(path.getText());
                result.setText("Liczba folderów wewnętrznych: " + w1.subdirCounter + " Liczba plików: " + w1.filesCounter);
            }
        });

        JButton end = new JButton("Koniec");
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonsPanel.add(choose);
        buttonsPanel.add(count);
        buttonsPanel.add(end);

        Border border = result.getBorder();
        Border margin = new EmptyBorder(0,0,40,0);
        result.setBorder(new CompoundBorder(border, margin));
        result.setHorizontalAlignment(SwingConstants.CENTER);

        Border border2 = path.getBorder();
        Border margin2 = new EmptyBorder(50,0,0,0);
        path.setBorder(new CompoundBorder(border2, margin2));
        path.setHorizontalAlignment(SwingConstants.CENTER);

        BorderLayout borderLayout = new BorderLayout(1000, 100);
        frame.setLayout(borderLayout);

        frame.getContentPane().add(path, BorderLayout.NORTH);
        frame.getContentPane().add(buttonsPanel, BorderLayout.CENTER);
        frame.getContentPane().add(result, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}

