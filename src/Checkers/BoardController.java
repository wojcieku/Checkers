package Checkers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardController {

    private Frame frame;
    private Move move;
    private Bot bot;
    private int currentColor = Board.RED;
    private int currentColorKing = Board.REDKING;

    public void setCurrentColorKing(){
        if(this.currentColorKing==Board.REDKING){
            this.currentColorKing=Board.BLACKKING;
        }else{
            this.currentColorKing=Board.REDKING;
        }
    }
    public int getCurrentColorKing() {
        return currentColorKing;
    }

    public void clearChosenTile(){
        frame.board.setSelectedColumn(8);
        frame.board.setSelectedRow(8);
        frame.repaint();
    }
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
        int rowBetween = (firstRow+secondRow)/2;
        int colBetween = (firstColumn+secondColumn)/2;
        frame.board.pieces[rowBetween][colBetween] = Board.EMPTY;
    }
    class BoardListener implements MouseListener{
        public boolean firstclick = true;
        int firstClickColumnNumber = 8;
        int firstClickRowNumber = 8;
        int columnsecond;
        int rowsecond;
        int colorOfFirstClick;

        @Override
        public void mouseClicked(MouseEvent e) {

        }


        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(firstclick){
                firstClickColumnNumber = e.getX()/50;
                firstClickRowNumber = e.getY()/50;
                if(move.canIMove(firstClickColumnNumber, firstClickRowNumber) || move.canITake(firstClickColumnNumber,firstClickRowNumber)) {
                    if(frame.board.getValueOfPiece(firstClickRowNumber,firstClickColumnNumber)==getCurrentColor() ||
                            frame.board.getValueOfPiece(firstClickRowNumber,firstClickColumnNumber)==getCurrentColorKing()){
                            frame.board.setSelectedColumn(firstClickColumnNumber);
                            frame.board.setSelectedRow(firstClickRowNumber);
                            frame.board.repaint();
                            colorOfFirstClick = frame.board.getValueOfPiece(firstClickRowNumber,firstClickColumnNumber);
                            firstclick = !firstclick;
                    }
                }
            }else {
                clearChosenTile();
                columnsecond = e.getX() / 50;
                rowsecond = e.getY() / 50;
                if (!move.checkAllPiecesPossibleTakes(getCurrentColor())) {
                    if (move.isItLegalSecondClickMove(columnsecond, rowsecond, firstClickColumnNumber, firstClickRowNumber, colorOfFirstClick)) {
                        if (frame.board.getValueOfPiece(rowsecond,columnsecond) == Board.EMPTY) {
                            frame.board.setValueOfPiece(firstClickRowNumber,firstClickColumnNumber,Board.EMPTY);
                            frame.board.setValueOfPiece(rowsecond,columnsecond,colorOfFirstClick);
                            if(colorOfFirstClick==Board.RED && rowsecond==0){
                                frame.board.setValueOfPiece(rowsecond,columnsecond,Board.REDKING);
                            }
                            if(colorOfFirstClick==Board.BLACK && rowsecond==7){
                                frame.board.setValueOfPiece(rowsecond,columnsecond,Board.BLACKKING);
                            }
                            setCurrentColor();
                            setCurrentColorKing();
                        }
                    }
                }else{
                    if(move.legalTakeMove(columnsecond, rowsecond, firstClickColumnNumber, firstClickRowNumber, colorOfFirstClick)){
                        take(firstClickRowNumber,firstClickColumnNumber,rowsecond,columnsecond,getCurrentColor());
                        if(!move.checkAllPiecesPossibleTakes(getCurrentColor())) {
                            setCurrentColor();
                            setCurrentColorKing();
                        }
                        if(colorOfFirstClick==Board.RED && rowsecond==0){
                            frame.board.setValueOfPiece(rowsecond,columnsecond,Board.REDKING);
                        }
                        if(colorOfFirstClick==Board.BLACK && rowsecond==7){
                            frame.board.setValueOfPiece(rowsecond,columnsecond,Board.BLACKKING);
                        }
                    }

                }
                frame.isGameFinished();
                firstclick = !firstclick;
                frame.board.repaint();
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
