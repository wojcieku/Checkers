package Checkers;

import java.awt.event.MouseEvent;

public class Move {
    private Frame frame;
    public Move(Frame frame){
        this.frame = frame;
    }
    public boolean checkAllPiecesPossibleTakes(int color){
        boolean result = false;
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++){
                if(canITake(col,row))if(frame.board.getValueOfPiece(row,col)==color) result=true;
            }
        }
        return result;
    }
    public boolean legalTakeMove(int columnsecond,int rowsecond,int columnfirst,int rowfirst,int color){
        boolean result = true;
        switch (color){
            case Board.RED:
                if(Math.abs(columnsecond-columnfirst)!=2){
                    result=false;
                }
                if(rowfirst-rowsecond!=2){
                    result=false;
                }
                break;
            case Board.BLACK:
                if(Math.abs(columnsecond-columnfirst)!=2){
                    result=false;
                }
                if(rowsecond-rowfirst!=2){
                    result=false;
                }
                break;
        }

        return result;
    }
    public boolean canIMove(int column, int row){
        boolean result=false;
        int colorofpiece = frame.board.getValueOfPiece(row,column);
        switch (colorofpiece){
            case Board.RED:
                if(column==7){
                    if(frame.board.getValueOfPiece(row-1,column-1)==Board.EMPTY) {
                        result=true;
                    }
                }
                else if(column==0){
                    if(frame.board.getValueOfPiece(row-1,column+1)==Board.EMPTY) {
                        result=true;
                    }
                }else{
                    if(frame.board.getValueOfPiece(row-1,column+1)==Board.EMPTY || frame.board.getValueOfPiece(row-1,column-1)==Board.EMPTY) {
                        result=true;
                    }
                }
                break;
            case Board.BLACK:
                if(column==7){
                    if(frame.board.getValueOfPiece(row+1,column-1)==Board.EMPTY) {
                        result=true;
                    }
                }
                else if(column==0){
                    if(frame.board.getValueOfPiece(row+1,column+1)==Board.EMPTY) {
                        result=true;
                    }
                }else{
                    if(frame.board.getValueOfPiece(row+1,column+1)==Board.EMPTY || frame.board.getValueOfPiece(row+1,column-1)==Board.EMPTY) {
                        result=true;
                    }
                }
        }
        return result;
    }
    public boolean canITake(int column,int row){
        boolean result=false;
        int colorofpiece = frame.board.getValueOfPiece(row,column);
        switch (colorofpiece){
            case Board.RED:
                if(row>2) {
                    if (column == 7 || column == 6) {
                        if (frame.board.getValueOfPiece(row-1,column-1) == Board.BLACK && frame.board.getValueOfPiece(row-2,column-2) == Board.EMPTY) {
                            result = true;
                        }
                    } else if (column == 0 || column == 1) {
                        if (frame.board.getValueOfPiece(row-1,column+1) == Board.BLACK && frame.board.getValueOfPiece(row-2,column+2) == Board.EMPTY) {
                            result = true;
                        }
                    } else if ((frame.board.getValueOfPiece(row-1,column+1) == Board.BLACK && frame.board.getValueOfPiece(row-2,column+2) == Board.EMPTY) || (frame.board.getValueOfPiece(row-1,column-1) == Board.BLACK && frame.board.getValueOfPiece(row-2,column-2) == Board.EMPTY)) {
                        result = true;
                    }
                }
                break;
            case Board.BLACK:
                if(row<6) {
                    if (column == 7 || column == 6) {
                        if (frame.board.getValueOfPiece(row+1,column-1) == Board.RED && frame.board.getValueOfPiece(row+2,column-2) == Board.EMPTY) {
                            result = true;
                        }
                    } else if (column == 0 || column == 1) {
                        if (frame.board.getValueOfPiece(row+1,column+1) == Board.RED && frame.board.getValueOfPiece(row+2,column+2) == Board.EMPTY) {
                            result = true;
                        }
                    } else {
                        if ((frame.board.getValueOfPiece(row+1,column+1) == Board.RED && frame.board.getValueOfPiece(row+2,column+2) == Board.EMPTY) || (frame.board.getValueOfPiece(row+1,column-1) == Board.RED && frame.board.getValueOfPiece(row+2,column-2)== Board.EMPTY)) {
                            result = true;
                        }
                    }
                }
        }

        return result;
    }
    public boolean isItLegalSecondClickMove(int columnsecond,int rowsecond,int columnfirst,int rowfirst,int color){
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
