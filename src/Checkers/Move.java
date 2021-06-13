package Checkers;

import java.awt.event.MouseEvent;

public class Move {
    private Frame frame;
    public Move(Frame frame){
        this.frame = frame;
    }
    public boolean checkAllPiecesPossibleTakes(int color,int colorQueen){
        boolean result = false;
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++){
                if(canITake(col,row)) {
                    if (frame.board.getValueOfPiece(row, col) == color || frame.board.getValueOfPiece(row, col) == colorQueen)
                        result = true;
                }
                }
        }
        return result;
    }
    public boolean legalTakeMove(int columnsecond,int rowsecond,int columnfirst,int rowfirst,int color){
        boolean result = true;
        int i,j;
        switch (color){
            case Board.RED:
                if((frame.board.getValueOfPiece((rowfirst + rowsecond)/2,Math.abs(columnsecond + columnfirst)/2)==Board.BLACK || frame.board.getValueOfPiece((rowfirst + rowsecond)/2,Math.abs(columnsecond + columnfirst)/2)==Board.BLACKKING) && frame.board.getValueOfPiece(rowsecond,columnsecond)==Board.EMPTY) {
                    if (Math.abs(columnsecond - columnfirst) != 2) {
                        result = false;
                    }
                    if (Math.abs(rowfirst - rowsecond) != 2) {
                        result = false;
                    }
                }else{
                    result=false;
                }
                break;
            case Board.BLACK:
                if((frame.board.getValueOfPiece((rowsecond+rowfirst)/2,(columnsecond + columnfirst)/2)==Board.RED || frame.board.getValueOfPiece((rowsecond+rowfirst)/2,(columnsecond + columnfirst)/2)==Board.REDKING) && frame.board.getValueOfPiece(rowsecond,columnsecond)==Board.EMPTY) {
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
            case Board.BLACKKING:
                if(Math.abs(rowsecond-columnsecond)==Math.abs(rowfirst-columnfirst) || rowfirst+columnfirst == columnsecond+rowsecond) {
                    if(frame.board.getValueOfPiece(rowsecond,columnsecond)==Board.EMPTY) {
                        if (rowsecond < rowfirst && columnsecond < columnfirst) {
                            for (i = rowfirst - 1, j = columnfirst - 1; i > rowsecond + 1 && j > columnsecond + 1; i--, j--) {
                                if (frame.board.getValueOfPiece(i, j) != Board.EMPTY) result = false;
                            }
                            if (!(frame.board.getValueOfPiece(rowsecond + 1, columnsecond + 1) == Board.RED ||
                                    frame.board.getValueOfPiece(rowsecond + 1, columnsecond + 1) == Board.REDKING))
                                result = false;
                        }
                        if (rowsecond > rowfirst && columnsecond < columnfirst) {
                            for (i = rowfirst + 1, j = columnfirst - 1; i < rowsecond - 1 && j > columnsecond + 1; i++, j--) {
                                System.out.println("nic tu nie powinno byc");
                                if (frame.board.getValueOfPiece(i, j) != Board.EMPTY) result = false;
                            }
                            if (!(frame.board.getValueOfPiece(rowsecond - 1, columnsecond + 1) == Board.RED ||
                                    frame.board.getValueOfPiece(rowsecond - 1, columnsecond + 1) == Board.REDKING))
                                result = false;
                        }
                        if (rowsecond < rowfirst && columnsecond > columnfirst) {
                            for (i = rowfirst - 1, j = columnfirst + 1; i > rowsecond + 1 && j < columnsecond - 1; i--, j++) {
                                if (frame.board.getValueOfPiece(i, j) != Board.EMPTY) result = false;
                            }
                            if (!(frame.board.getValueOfPiece(rowsecond + 1, columnsecond - 1) == Board.RED ||
                                    frame.board.getValueOfPiece(rowsecond + 1, columnsecond - 1) == Board.REDKING))
                                result = false;
                        }
                        if (rowsecond > rowfirst && columnsecond > columnfirst) {
                            for (i = rowfirst + 1, j = columnfirst + 1; i < rowsecond - 1 && j < columnsecond - 1; i++, j++) {
                                if (frame.board.getValueOfPiece(i, j) != Board.EMPTY) result = false;
                            }
                            if (!(frame.board.getValueOfPiece(rowsecond - 1, columnsecond - 1) == Board.RED ||
                                    frame.board.getValueOfPiece(rowsecond - 1, columnsecond - 1) == Board.REDKING))
                                result = false;
                        }
                    }
                    else{
                        result=false;
                    }
                }else{
                    result=false;
                }
                break;
            case Board.REDKING:
                if(Math.abs(rowsecond-columnsecond)==Math.abs(rowfirst-columnfirst) || rowfirst+columnfirst == columnsecond+rowsecond) {
                    if(frame.board.getValueOfPiece(rowsecond,columnsecond)==Board.EMPTY) {
                        if (rowsecond < rowfirst && columnsecond < columnfirst) {
                            for (i = rowfirst - 1, j = columnfirst - 1; i > rowsecond + 1 && j > columnsecond + 1; i--, j--) {
                                if (frame.board.getValueOfPiece(i, j) != Board.EMPTY) result = false;
                            }
                            if (!(frame.board.getValueOfPiece(rowsecond + 1, columnsecond + 1) == Board.BLACK ||
                                    frame.board.getValueOfPiece(rowsecond + 1, columnsecond + 1) == Board.BLACKKING))
                                result = false;
                        }
                        if (rowsecond > rowfirst && columnsecond < columnfirst) {
                            for (i = rowfirst + 1, j = columnfirst - 1; i < rowsecond - 1 && j > columnsecond + 1; i++, j--) {
                                if (frame.board.getValueOfPiece(i, j) != Board.EMPTY){
                                    result = false;
                                }
                            }
                            if (!(frame.board.getValueOfPiece(rowsecond - 1, columnsecond + 1) == Board.BLACK ||
                                    frame.board.getValueOfPiece(rowsecond - 1, columnsecond + 1) == Board.BLACKKING)) {
                                result = false;
                            }
                            System.out.println(result);
                        }
                        if (rowsecond < rowfirst && columnsecond > columnfirst) {
                            for (i = rowfirst - 1, j = columnfirst + 1; i > rowsecond + 1 && j < columnsecond - 1; i--, j++) {
                                if (frame.board.getValueOfPiece(i, j) != Board.EMPTY) result = false;
                            }
                            if (!(frame.board.getValueOfPiece(rowsecond + 1, columnsecond - 1) == Board.BLACK ||
                                    frame.board.getValueOfPiece(rowsecond + 1, columnsecond - 1) == Board.BLACKKING))
                                result = false;
                        }
                        if (rowsecond > rowfirst && columnsecond > columnfirst) {
                            for (i = rowfirst + 1, j = columnfirst + 1; i < rowsecond - 1 && j < columnsecond - 1; i++, j++) {
                                if (frame.board.getValueOfPiece(i, j) != Board.EMPTY) result = false;
                            }
                            if (!(frame.board.getValueOfPiece(rowsecond - 1, columnsecond - 1) == Board.BLACK ||
                                    frame.board.getValueOfPiece(rowsecond - 1, columnsecond - 1) == Board.BLACKKING))
                                result = false;
                        }
                    }else{
                        result=false;
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
                break;
            case Board.BLACKKING:
            case Board.REDKING:
                result=true;
        }
        return result;
    }
    public boolean canITake(int column,int row){
        boolean result=false;
        int i,j;
        int colorofpiece = frame.board.getValueOfPiece(row,column);
        switch (colorofpiece){
            case Board.RED:
                if(row>=2) {
                    if (column == 7 || column == 6) {
                        if ((frame.board.getValueOfPiece(row-1,column-1) == Board.BLACK || frame.board.getValueOfPiece(row-1,column-1) == Board.BLACKKING) && frame.board.getValueOfPiece(row-2,column-2) == Board.EMPTY) {

                            result = true;
                        }
                    } else if (column == 0 || column == 1) {
                        if ((frame.board.getValueOfPiece(row-1,column+1) == Board.BLACK || frame.board.getValueOfPiece(row-1,column+1) == Board.BLACKKING)
                            && frame.board.getValueOfPiece(row-2,column+2) == Board.EMPTY) {
                            result = true;
                        }
                    } else if (((frame.board.getValueOfPiece(row-1,column+1) == Board.BLACK || frame.board.getValueOfPiece(row-1,column+1) == Board.BLACKKING) && frame.board.getValueOfPiece(row-2,column+2) == Board.EMPTY) || ((frame.board.getValueOfPiece(row-1,column-1) == Board.BLACK || frame.board.getValueOfPiece(row-1,column-1) == Board.BLACKKING) && frame.board.getValueOfPiece(row-2,column-2) == Board.EMPTY)) {
                        result = true;
                    }
                }
                break;
            case Board.BLACK:
                if(row<=5) {
                    if (column == 7 || column == 6) {
                        if ((frame.board.getValueOfPiece(row+1,column-1) == Board.RED || frame.board.getValueOfPiece(row+1,column-1) == Board.REDKING) && frame.board.getValueOfPiece(row+2,column-2) == Board.EMPTY) {
                            result = true;
                        }
                    } else if (column == 0 || column == 1) {
                        if ((frame.board.getValueOfPiece(row+1,column+1) == Board.RED || frame.board.getValueOfPiece(row+1,column+1) == Board.REDKING) && frame.board.getValueOfPiece(row+2,column+2) == Board.EMPTY) {
                            result = true;
                        }
                    } else {
                        if (((frame.board.getValueOfPiece(row+1,column+1) == Board.RED || frame.board.getValueOfPiece(row+1,column+1) == Board.REDKING) && frame.board.getValueOfPiece(row+2,column+2) == Board.EMPTY) || ((frame.board.getValueOfPiece(row+1,column-1) == Board.RED || frame.board.getValueOfPiece(row+1,column-1) == Board.REDKING) && frame.board.getValueOfPiece(row+2,column-2)== Board.EMPTY)) {
                            result = true;
                        }
                    }
                }
                break;
            case Board.BLACKKING:
                for(i=row-1,j=column-1;i>0 && j>0;i--,j--){
                    if(frame.board.getValueOfPiece(i,j)==Board.REDKING || frame.board.getValueOfPiece(i,j)==Board.RED){
                        if(frame.board.getValueOfPiece(i-1,j-1)==Board.EMPTY){
                            result=true;
                        }
                    }
                }
                for(i=row+1,j=column-1;i<7 && j>0;i++,j--){
                    if(frame.board.getValueOfPiece(i,j)==Board.REDKING || frame.board.getValueOfPiece(i,j)==Board.RED){
                        if(frame.board.getValueOfPiece(i+1,j-1)==Board.EMPTY){
                            result=true;
                        }
                    }
                }
                for(i=row-1,j=column+1;i>0 && j<7;i--,j++){
                    if(frame.board.getValueOfPiece(i,j)==Board.REDKING || frame.board.getValueOfPiece(i,j)==Board.RED){
                        if(frame.board.getValueOfPiece(i-1,j+1)==Board.EMPTY){
                            result=true;
                        }
                    }
                }
                for(i=row+1,j=column+1;i<7 && j<7;i++,j++){
                    if(frame.board.getValueOfPiece(i,j)==Board.REDKING || frame.board.getValueOfPiece(i,j)==Board.RED){
                        if(frame.board.getValueOfPiece(i+1,j+1)==Board.EMPTY){
                            result=true;
                        }
                    }
                }
                break;
            case Board.REDKING:
                for(i=row-1,j=column-1;i>0 && j>0;i--,j--){
                    if(frame.board.getValueOfPiece(i,j)==Board.BLACKKING || frame.board.getValueOfPiece(i,j)==Board.BLACK){
                        if(frame.board.getValueOfPiece(i-1,j-1)==Board.EMPTY){
                            result=true;
                        }
                    }
                }
                for(i=row+1,j=column-1;i<7 && j>0;i++,j--){
                    if(frame.board.getValueOfPiece(i,j)==Board.BLACKKING || frame.board.getValueOfPiece(i,j)==Board.BLACK){
                        if(frame.board.getValueOfPiece(i+1,j-1)==Board.EMPTY){
                            result=true;
                        }
                    }
                }
                for(i=row-1,j=column+1;i>0 && j<7;i--,j++){
                    if(frame.board.getValueOfPiece(i,j)==Board.BLACKKING || frame.board.getValueOfPiece(i,j)==Board.BLACK){
                        if(frame.board.getValueOfPiece(i-1,j+1)==Board.EMPTY){
                            result=true;
                        }
                    }
                }
                for(i=row+1,j=column+1;i<7 && j<7;i++,j++){
                    if(frame.board.getValueOfPiece(i,j)==Board.BLACKKING || frame.board.getValueOfPiece(i,j)==Board.BLACK){
                        if(frame.board.getValueOfPiece(i+1,j+1)==Board.EMPTY){
                            result=true;
                        }
                    }
                }
                break;
        }
        return result;
    }
    public boolean isItLegalSecondClickMove(int columnsecond,int rowsecond,int columnfirst,int rowfirst,int color){
        boolean result = true;

        switch (color){
            case Board.REDKING:
            case Board.BLACKKING:
                int i,j;
                if(Math.abs(rowsecond-columnsecond)==Math.abs(rowfirst-columnfirst) || rowfirst+columnfirst == columnsecond+rowsecond) {
                    if (rowsecond < rowfirst && columnsecond < columnfirst)
                        for (i = rowfirst - 1, j = columnfirst - 1; i >= rowsecond && j >= columnsecond; i--, j--) {
                            if (frame.board.getValueOfPiece(i, j) != Board.EMPTY) result = false;
                        }
                    if (rowsecond > rowfirst && columnsecond < columnfirst)
                        for (i = rowfirst + 1, j = columnfirst - 1; i <= rowsecond && j >= columnsecond; i++, j--) {
                            if (frame.board.getValueOfPiece(i, j) != Board.EMPTY) result = false;
                        }
                    if (rowsecond < rowfirst && columnsecond > columnfirst)
                        for (i = rowfirst - 1, j = columnfirst + 1; i >= rowsecond && j <= columnsecond; i--, j++) {
                            if (frame.board.getValueOfPiece(i, j) != Board.EMPTY) result = false;
                        }
                    if (rowsecond > rowfirst && columnsecond > columnfirst)
                        for (i = rowfirst + 1, j = columnfirst + 1; i <= rowsecond && j <= columnsecond; i++, j++) {
                            if (frame.board.getValueOfPiece(i, j) != Board.EMPTY) result = false;
                        }
                    if (rowsecond == rowfirst || columnsecond == columnfirst) {
                        result = false;
                    }
                }else{
                    result=false;
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
        if(frame.board.pieces[rowsecond][columnsecond]!=Board.EMPTY){result=false;}
        return result;
    }
}
