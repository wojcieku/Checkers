package Checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class Frame extends JFrame {
    Board board = new Board();
    public void addBoardListener(MouseListener listenForClick){board.addMouseListener(listenForClick);}
    public Frame(){
        this.setSize(416,436);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(board);
    }

}
