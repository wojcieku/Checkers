package Checkers;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardController {

    private boolean canIMove(MouseEvent e){
        boolean result=false;
        int column = e.getX()/50;
        int row = e.getY()/50;
        int colorofpiece = frame.board.pieces[row][column];
        switch (colorofpiece){
            case RED:
                if(column==7){
                    if(frame.board.pieces[row-1][column-1]==0) {
                        result=true;
                    }
                }
                else if(column==0){
                    if(frame.board.pieces[row-1][column+1]==0) {
                        result=true;
                    }
                }else{
                    if(frame.board.pieces[row-1][column+1]==0 || frame.board.pieces[row-1][column-1]==0) {
                        result=true;
                    }
                }
                break;
            case BLACK:
                if(column==7){
                    if(frame.board.pieces[row+1][column-1]==0) {
                        result=true;
                    }
                }
                else if(column==0){
                    if(frame.board.pieces[row+1][column+1]==0) {
                        result=true;
                    }
                }else{
                    if(frame.board.pieces[row+1][column+1]==0 || frame.board.pieces[row+1][column-1]==0) {
                        result=true;
                    }
                }
        }
        return result;
    }
    private boolean canITake(MouseEvent e){
        boolean result=false;
        int column = e.getX()/50;
        int row = e.getY()/50;
        int colorofpiece = frame.board.pieces[row][column];
        switch (colorofpiece){
            case RED:
                if(column==7){
                    if(frame.board.pieces[row-1][column-1]==BLACK &&frame.board.pieces[row-2][column-2]==EMPTY){
                        result=true;
                    }
                }
                else if(column==0){
                    if(frame.board.pieces[row-1][column+1]==BLACK && frame.board.pieces[row-2][column+2]==EMPTY) {
                        result=true;
                    }
                }else if((frame.board.pieces[row-1][column+1]==BLACK && frame.board.pieces[row-2][column+2]==EMPTY) || (frame.board.pieces[row-1][column-1]==BLACK &&frame.board.pieces[row-2][column-2]==EMPTY)) {
                    result=true;
                }
                break;
        }

        return result;
    }

    static final int EMPTY = 0,RED = 1,BLACK = 2,REDKING = 3,BLACKKING=4;
    private Frame frame;
    public BoardController(Frame frame){
        this.frame = frame;
        this.frame.addBoardListener(new BoardListener());
    }
    class BoardListener implements MouseListener{
        public boolean firstclick = true;
        int columnfirst=8;
        int rowfirst=8;
        int columnsecond;
        int rowsecond;
        int color;
        @Override
        public void mouseClicked(MouseEvent e) {
            boolean decision;
            boolean takeMust;
            if(firstclick){
                decision = canIMove(e);
                takeMust = canITake(e);
                System.out.println(decision);
                System.out.println(takeMust);
                columnfirst = e.getX()/50;
                rowfirst = e.getY()/50;
                color = frame.board.pieces[rowfirst][columnfirst];
                firstclick=!firstclick;
            }else{
                firstclick=!firstclick;
                columnsecond = e.getX()/50;
                rowsecond = e.getY()/50;
                frame.board.pieces[rowsecond][columnsecond] = color;
                frame.board.pieces[rowfirst][columnfirst]=EMPTY;
                frame.board.repaint();
                frame.isGameFinished();
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
