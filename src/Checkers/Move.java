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
                if(frame.board.getValueOfPiece((rowfirst + rowsecond)/2,Math.abs(columnsecond + columnfirst)/2)==Board.BLACK && frame.board.getValueOfPiece(rowsecond,columnsecond)==Board.EMPTY) {
                    if (Math.abs(columnsecond - columnfirst) != 2) {
                        System.out.println("kolumny sie nie zgadzaja");
                        result = false;
                    }
                    if (Math.abs(rowfirst - rowsecond) != 2) {
                        System.out.println("Rzedy sie nie zgadzaja");
                        result = false;
                    }
                }else{
                    System.out.println("pomiedzy nie ma czarnego lub docelowe nie jest puste");
                    result=false;
                }
                break;
            case Board.BLACK:
                if(frame.board.getValueOfPiece((rowsecond+rowfirst)/2,(columnsecond + columnfirst)/2)==Board.RED && frame.board.getValueOfPiece(rowsecond,columnsecond)==Board.EMPTY) {
                    if (Math.abs(columnsecond - columnfirst) != 2) {
                        result = false;
                    }
                    if (rowsecond - rowfirst != 2) {
                        result = false;
                    }
                }else{
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
            case Board.BLACKKING:
            case Board.REDKING:
                result=true;
                break;
        }
        System.out.println(result);
        return result;
    }
    public boolean canITake(int column,int row){
        boolean result=false;
        int colorofpiece = frame.board.getValueOfPiece(row,column);
        switch (colorofpiece){
            case Board.RED:
                if(row>=2) {
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
                if(row<=5) {
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
        System.out.println(result);
        return result;
    }
    public boolean isItLegalSecondClickMove(int columnsecond,int rowsecond,int columnfirst,int rowfirst,int color){
        boolean result = true;
        switch (color){
            case Board.REDKING:
            case Board.BLACKKING:
                if(Math.abs(rowfirst-columnfirst)!=Math.abs(rowsecond-columnsecond) && rowfirst+columnfirst!=rowsecond+columnsecond){
                    result =false;
                }
                break;
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
