package Checkers;

import java.awt.event.MouseEvent;

public class Move {
    private Frame frame;
    public Move(Frame frame){
        this.frame = frame;
    }
    public boolean checkAllPiecesPossibleTakes(){
        boolean result = false;
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++){
                if(canITake(col,row)) result=true;
            }
        }
        return result;
    }
    public boolean canIMove(int column, int row){
        boolean result=false;
        int colorofpiece = frame.board.pieces[row][column];
        switch (colorofpiece){
            case Board.RED:
                if(column==7){
                    if(frame.board.pieces[row-1][column-1]==Board.EMPTY) {
                        result=true;
                    }
                }
                else if(column==0){
                    if(frame.board.pieces[row-1][column+1]==Board.EMPTY) {
                        result=true;
                    }
                }else{
                    if(frame.board.pieces[row-1][column+1]==Board.EMPTY || frame.board.pieces[row-1][column-1]==Board.EMPTY) {
                        result=true;
                    }
                }
                break;
            case Board.BLACK:
                if(column==7){
                    if(frame.board.pieces[row+1][column-1]==Board.EMPTY) {
                        result=true;
                    }
                }
                else if(column==0){
                    if(frame.board.pieces[row+1][column+1]==Board.EMPTY) {
                        result=true;
                    }
                }else{
                    if(frame.board.pieces[row+1][column+1]==Board.EMPTY || frame.board.pieces[row+1][column-1]==Board.EMPTY) {
                        result=true;
                    }
                }
        }
        return result;
    }
    public boolean canITake(int column,int row){
        boolean result=false;
        int colorofpiece = frame.board.pieces[row][column];
        switch (colorofpiece){
            case Board.RED:
                if(column==7){
                    if(frame.board.pieces[row-1][column-1]==Board.BLACK &&frame.board.pieces[row-2][column-2]==Board.EMPTY){
                        result=true;
                    }
                }
                else if(column==0){
                    if(frame.board.pieces[row-1][column+1]==Board.BLACK && frame.board.pieces[row-2][column+2]==Board.EMPTY) {
                        result=true;
                    }
                }else if((frame.board.pieces[row-1][column+1]==Board.BLACK && frame.board.pieces[row-2][column+2]==Board.EMPTY) || (frame.board.pieces[row-1][column-1]==Board.BLACK &&frame.board.pieces[row-2][column-2]==Board.EMPTY)) {
                    result=true;
                }
                break;
            case Board.BLACK:
                if(column==7){
                    if(frame.board.pieces[row+1][column-1]==Board.RED &&frame.board.pieces[row+2][column-2]==Board.EMPTY) {
                        result=true;
                    }
                }
                else if(column==0){
                    if(frame.board.pieces[row+1][column+1]==Board.RED && frame.board.pieces[row+2][column+2]==Board.EMPTY) {
                        result=true;
                    }
                }else{
                    if((frame.board.pieces[row+1][column+1]==Board.RED && frame.board.pieces[row+2][column+2]==Board.EMPTY) || (frame.board.pieces[row+1][column-1]==Board.RED &&frame.board.pieces[row+2][column-2]==Board.EMPTY)) {
                        result=true;
                    }
                }
        }

        return result;
    }
    public boolean secondClickmove(int columnsecond,int rowsecond,int columnfirst,int rowfirst,int color){
        boolean result = true;
        switch (color){
            case Board.RED:
                if(Math.abs(columnsecond-columnfirst)!=1){
                result=false;
            }
                if(rowfirst-rowsecond!=1){
                    result=false;
                }
                break;
            case Board.BLACK:
                if(Math.abs(columnsecond-columnfirst)!=1){
                    result=false;
                }
                if(rowsecond-rowfirst!=1){
                    result=false;
                }
                break;
        }

        return result;
    }
}
