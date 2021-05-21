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
        boolean result=false;  //musi byc jeszcze dla kolumn od prawej i od lewej oddzielny przypadek bo wychodzi poza plansze
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
            case BLACK:
                if(column==7){
                    if(frame.board.pieces[row+1][column-1]==RED &&frame.board.pieces[row+2][column-2]==EMPTY) {
                        result=true;
                    }
                }
                else if(column==0){
                    if(frame.board.pieces[row+1][column+1]==RED && frame.board.pieces[row+2][column+2]==EMPTY) {
                        result=true;
                    }
                }else{
                    if((frame.board.pieces[row+1][column+1]==RED && frame.board.pieces[row+2][column+2]==EMPTY) || (frame.board.pieces[row+1][column-1]==RED &&frame.board.pieces[row+2][column-2]==EMPTY)) {
                        result=true;
                    }
                }
        }

        return result;
    }

    static final int EMPTY = 0,RED = 1,BLACK = 2,REDKING = 3,BLACKKING=4;
    private Frame frame;
    private Move move;
    public BoardController(Frame frame,Move move){
        this.frame = frame;
        this.move = move;
        this.frame.addBoardListener(new BoardListener());
    }
    class BoardListener implements MouseListener{
        public boolean firstclick = true;
        int columnfirst=8;
        int rowfirst=8;
        int columnsecond;
        int rowsecond;
        int color1;

        @Override
        public void mouseClicked(MouseEvent e) {
            boolean decision;
            boolean takeMust;
            if(firstclick){
//                decision = canIMove(e);
//                takeMust = canITake(e);
//                System.out.println("Can I move: " + decision);
//                System.out.println("Can I take: " + takeMust);
                columnfirst = e.getX()/50;
                rowfirst = e.getY()/50;
                if(frame.board.pieces[rowfirst][columnfirst]!=EMPTY && move.canIMove(columnfirst,rowfirst)) {
                    color1 = frame.board.pieces[rowfirst][columnfirst];
                    firstclick = !firstclick;
                }
            }else{

                columnsecond = e.getX()/50;
                rowsecond = e.getY()/50;
                int color2= frame.board.pieces[rowsecond][columnsecond];
                if(move.secondClickmove(columnsecond,rowsecond,columnfirst,rowfirst,color1)) {
                    if (frame.board.pieces[rowsecond][columnsecond] == EMPTY) {
                        frame.board.pieces[rowfirst][columnfirst] = EMPTY;
                        frame.board.pieces[rowsecond][columnsecond] = color1;
                        frame.board.repaint();
                        frame.isGameFinished();
                        firstclick = !firstclick;
                    }
                }
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
