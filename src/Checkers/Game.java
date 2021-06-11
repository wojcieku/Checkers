package Checkers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    public static void main(String[] args) {
        int playersColor;
        //int botsColor;
        Frame frame = new Frame();
        Move move = new Move(frame);
        BoardController controller = new BoardController(frame,move);
        frame.setVisible(true);
        JButton red = new JButton("Czerwony");
        JButton black = new JButton("Czarny");
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.botsColor= Board.BLACK;
                controller.botsKingColor= Board.BLACKKING;

            }
        });
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
//        Bot bot = new Bot(controller.botsColor);
    }
}
