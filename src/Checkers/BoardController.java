package Checkers;

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
    public void take(int firstRow, int firstColumn, int secondRow, int secondColumn, int currentColor){
        frame.board.pieces[firstRow][firstColumn] = Board.EMPTY;
        frame.board.pieces[secondRow][secondColumn] = currentColor;
        int rowBetween = (firstRow+secondRow) / 2;
        int colBetween = (firstColumn+secondColumn) / 2;
        frame.board.pieces[rowBetween][colBetween] = Board.EMPTY;
    }
    class BoardListener implements MouseListener{
        public boolean firstClick = true;
        int columnFirst =8;
        int rowFirst =8;
        int columnSecond;
        int rowSecond;
        int color1;

        @Override
        public void mouseClicked(MouseEvent e) {

        }


        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(firstClick){
                columnFirst = e.getX()/50;
                rowFirst = e.getY()/50;

                if(frame.board.pieces[rowFirst][columnFirst] != Board.EMPTY && move.canIMove(columnFirst, rowFirst)) {
                    if(frame.board.pieces[rowFirst][columnFirst] == getCurrentColor()){
                        if(!move.checkAllPiecesPossibleTakes()) {
                            frame.board.setSelectedColumn(columnFirst);
                            frame.board.setSelectedRow(rowFirst);
                            frame.board.repaint();
                            color1 = frame.board.pieces[rowFirst][columnFirst];
                            firstClick =! firstClick;
                        }else{
                            if(move.canITake(columnFirst, rowFirst)){
                                frame.board.setSelectedColumn(columnFirst);
                                frame.board.setSelectedRow(rowFirst);
                                frame.board.repaint();
                                color1 = frame.board.pieces[rowFirst][columnFirst];
                                firstClick =! firstClick;
                            }
                        }
                    }
                }
            }else{
                frame.board.setSelectedColumn(8);
                frame.board.setSelectedRow(8);
                columnSecond = e.getX()/50;
                rowSecond = e.getY()/50;
                int color2= frame.board.pieces[rowSecond][columnSecond];
                if(move.secondClickmove(columnSecond, rowSecond, columnFirst, rowFirst,color1)) {
                    if (frame.board.pieces[rowSecond][columnSecond] == Board.EMPTY) {
                        frame.board.pieces[rowFirst][columnFirst] = Board.EMPTY;
                        frame.board.pieces[rowSecond][columnSecond] = color1;
                        setCurrentColor();
                        frame.isGameFinished();
                    }
                }
                else{
                    frame.board.setSelectedColumn(8);
                    frame.board.setSelectedRow(8);
                }
                frame.board.repaint();
                firstClick =! firstClick;
            }
            frame.makeAQueen(rowFirst, columnFirst, rowSecond, columnSecond);
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
