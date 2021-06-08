package Checkers;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardController {

    private Frame frame;
    private Move move;
    private int currentColor = Board.RED;
    public void setCurrentColor(){
        if(currentColor==Board.RED){
            this.currentColor=Board.BLACK;
        }else{
            this.currentColor=Board.RED;
        }
    }

    public int getCurrentColor() {
        return currentColor;
    }

    public BoardController(Frame frame, Move move){
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

        }


        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(firstclick){
                columnfirst = e.getX()/50;
                rowfirst = e.getY()/50;

                if(frame.board.pieces[rowfirst][columnfirst]!=Board.EMPTY && move.canIMove(columnfirst,rowfirst)) {
                    if(frame.board.pieces[rowfirst][columnfirst]==getCurrentColor()){
                        if(!move.checkAllPiecesPossibleTakes()) {
                            frame.board.setSelectedColumn(columnfirst);
                            frame.board.setSelectedRow(rowfirst);
                            frame.board.repaint();
                            color1 = frame.board.pieces[rowfirst][columnfirst];
                            firstclick = !firstclick;
                        }else{
                            if(move.canITake(columnfirst,rowfirst)){
                                frame.board.setSelectedColumn(columnfirst);
                                frame.board.setSelectedRow(rowfirst);
                                frame.board.repaint();
                                color1 = frame.board.pieces[rowfirst][columnfirst];
                                firstclick = !firstclick;
                            }
                        }
                    }
                }
            }else{
                frame.board.setSelectedColumn(8);
                frame.board.setSelectedRow(8);
                columnsecond = e.getX()/50;
                rowsecond = e.getY()/50;
                int color2= frame.board.pieces[rowsecond][columnsecond];
                if(move.secondClickmove(columnsecond,rowsecond,columnfirst,rowfirst,color1)) {
                    if (frame.board.pieces[rowsecond][columnsecond] == Board.EMPTY) {
                        frame.board.pieces[rowfirst][columnfirst] = Board.EMPTY;
                        frame.board.pieces[rowsecond][columnsecond] = color1;
                        setCurrentColor();
                        frame.isGameFinished();
                    }
                }
                else{
                    frame.board.setSelectedColumn(8);
                    frame.board.setSelectedRow(8);
                }
                frame.board.repaint();
                firstclick = !firstclick;
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
