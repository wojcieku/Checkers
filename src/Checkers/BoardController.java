package Checkers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardController {
    private Frame frame;
    public BoardController(Frame frame){
        this.frame = frame;
        this.frame.addBoardListener(new BoardListener());
    }
    class BoardListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            int column = e.getX()/50;
            int row = e.getY()/50;
            int colorofpiece = frame.board.board[row][column];
            switch (colorofpiece){
                case 0:

            }
            if(frame.board.board[row+1][column+1]==0 || frame.board.board[row+1][column-1]==0){
                System.out.println("droga wolna");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
