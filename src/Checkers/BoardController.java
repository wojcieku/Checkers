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
            System.out.println(e.getX());
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
