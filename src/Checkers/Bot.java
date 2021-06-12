package Checkers;

import java.util.ArrayList;

public class Bot {
    private Board board;
    private Move move;
    private BoardController boardController; //stad ktory kolor ma ruch
    private ArrayList<Integer> coordinates = new ArrayList<Integer>(); // zapis jednego ruchu: [wiersz1, kolumna1, wiersz2, kolumna2]

    //    int[][] coordinates = new int[48];
    public boolean checkAllPiecesPossibleTakes(int color, int colorQueen, int[][] board) {
        boolean result = false;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (canITake(col, row, board)) {
                    if (board[row][col] == color || board[row][col] == colorQueen)
                        result = true;
                }
            }
        }
        return result;
    }

    public void analyze() {
        // przejscie przez plansze, dodanie mozliwych wspolrzednych
        //dodawanie do coordinates
        if (checkAllPiecesPossibleTakes(boardController.botsColor, boardController.botsKingColor, board.pieces)) { //jesli trzeba zbic -> znalezienie wszystkich mozliwosci bicia
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (board.getValueOfPiece(row, col) == boardController.botsColor || board.getValueOfPiece(row, col) == boardController.botsKingColor) { //jezeli to jest pionek bota
                        if (move.canITake(col, row)) { //na razie tylko dla zwyklych pionkow
                            switch (board.getValueOfPiece(row, col)) {
                                case Board.RED:
                                    if (row >= 2) {
                                        if (col == 7 || col == 6) {
                                            if (move.legalTakeMove(col - 2, row - 2, col, row, Board.RED)) {
                                                coordinates.add(row);
                                                coordinates.add(col);
                                                coordinates.add(row - 2);
                                                coordinates.add(col - 2);
                                            }
                                        } else if (col == 0 || col == 1) {
                                            if (move.legalTakeMove(col + 2, row - 2, col, row, Board.RED)) {
                                                coordinates.add(row);
                                                coordinates.add(col);
                                                coordinates.add(col + 2);
                                                coordinates.add(row - 2);
                                            } //nizej: bicie w lewo, potem w prawo
                                        } else if (((board.getValueOfPiece(row - 1, col - 1) == Board.BLACK) || (board.getValueOfPiece(row - 1, col - 1) == Board.BLACKKING)) && board.getValueOfPiece(row - 2, col - 2) == Board.EMPTY) {
                                            coordinates.add(row);
                                            coordinates.add(col);
                                            coordinates.add(row - 2);
                                            coordinates.add(col - 2);
                                        } else if (move.legalTakeMove(col + 2, row - 2, col, row, Board.RED)) {
                                            coordinates.add(row);
                                            coordinates.add(col);
                                            coordinates.add(col + 2);
                                            coordinates.add(row - 2);
                                        }
                                    }
                                    break;
                                case Board.BLACK:
                                    if (row <= 5) {
                                        if (col == 7 || col == 6) {
                                            if (move.legalTakeMove(col - 2, row + 2, col, row, Board.BLACK)) {
                                                coordinates.add(row);
                                                coordinates.add(col);
                                                coordinates.add(row + 2);
                                                coordinates.add(col - 2);
                                            }
                                        } else if (col == 0 || col == 1) {
                                            if (move.legalTakeMove(col + 2, row + 2, col, row, Board.BLACK)) {
                                                coordinates.add(row);
                                                coordinates.add(col);
                                                coordinates.add(row + 2);
                                                coordinates.add(col + 2);
                                            }
                                        } else if (move.legalTakeMove(col - 2, row + 2, col, row, Board.BLACK)) {
                                            coordinates.add(row);
                                            coordinates.add(col);
                                            coordinates.add(row + 2);
                                            coordinates.add(col - 2);
                                        } else if (move.legalTakeMove(col + 2, row + 2, col, row, Board.BLACK)) {
                                            coordinates.add(row);
                                            coordinates.add(col);
                                            coordinates.add(row + 2);
                                            coordinates.add(col + 2);
                                        }
                                    }
                                    break;
                                case Board.REDKING:
                                    break;
                                case Board.BLACKKING:
                                    break;
                            }
                        }
                    }
                }
            }
        } else { //znalezienie wszystkich mozliwosci zwyklego ruchu
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (board.getValueOfPiece(row, col) == boardController.botsColor || board.getValueOfPiece(row, col) == boardController.botsKingColor) { //jezeli to jest pionek bota
                        if (move.canIMove(col, row)) {
                            switch (board.getValueOfPiece(row, col)){
                                case Board.RED:
                                    if(row>=1){
                                        if(col==7){
                                            if(move.isItLegalSecondClickMove(col-1, row-1, col, row, Board.RED)){
                                                coordinates.add(row);
                                                coordinates.add(col);
                                                coordinates.add(row-1);
                                                coordinates.add(col-1);
                                            }
                                        }
                                        else if (col==0){
                                            if(move.isItLegalSecondClickMove(col+1, row-1, col, row, Board.RED)){
                                                coordinates.add(row);
                                                coordinates.add(col);
                                                coordinates.add(row-1);
                                                coordinates.add(col+1);
                                            }
                                        }
                                        else if (move.isItLegalSecondClickMove(col-1, row-1, col, row, Board.RED)){
                                            coordinates.add(row);
                                            coordinates.add(col);
                                            coordinates.add(row-1);
                                            coordinates.add(col-1);
                                        }
                                        else if (move.isItLegalSecondClickMove(col+1, row-1, col, row, Board.RED)){
                                            coordinates.add(row);
                                            coordinates.add(col);
                                            coordinates.add(row-1);
                                            coordinates.add(col+1);
                                        }
                                    }
                                    break;
                                case Board.BLACK:
                                    if(row<=6){
                                        if(col==7){
                                            if(move.isItLegalSecondClickMove(col-1, row+1, col, row, Board.RED)){
                                                coordinates.add(row);
                                                coordinates.add(col);
                                                coordinates.add(row+1);
                                                coordinates.add(col-1);
                                            }
                                        }
                                        else if (col==0){
                                            if(move.isItLegalSecondClickMove(col+1, row+1, col, row, Board.RED)){
                                                coordinates.add(row);
                                                coordinates.add(col);
                                                coordinates.add(row+1);
                                                coordinates.add(col+1);
                                            }
                                        }
                                        else if (move.isItLegalSecondClickMove(col-1, row+1, col, row, Board.RED)){
                                            coordinates.add(row);
                                            coordinates.add(col);
                                            coordinates.add(row+1);
                                            coordinates.add(col-1);
                                        }
                                        else if (move.isItLegalSecondClickMove(col+1, row+1, col, row, Board.RED)){
                                            coordinates.add(row);
                                            coordinates.add(col);
                                            coordinates.add(row+1);
                                            coordinates.add(col+1);
                                        }
                                    }
                                    break;
                                case Board.REDKING:
                                    break;
                                case Board.BLACKKING:
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void simulate() {
        int[][] localpieces = board.pieces;
        int sum = 0;
        ArrayList<Integer> bestMoves = new ArrayList<Integer>(); //lista z najlepszymi ruchami
        for (int i = 0; i < (coordinates.size() - 3); i += 4) {
            localpieces[coordinates.get(i)][coordinates.get(i + 1)] = Board.EMPTY;
            localpieces[coordinates.get(i + 2)][coordinates.get(i + 3)] = boardController.botsColor;
            //metody sprawdzajace czy przeciwnik bota ma mozliwosc bicia albo bot - jesli tak to suma - albo + 1 [najplytsza mozliwosc]
            //

        }
    }

    public boolean isChanceForQueen(int colorToCheck) {
        boolean check = false;
        //sprawdzenie czy jest ryzyko/szansa zdobycia damy
        return check;
    }

    public void move() {
        //ruch
        coordinates.clear(); //reset listy mozliwych ruchow
    }

    public boolean canIMove(int column, int row, int[][] board) {
        boolean result = false;
        int colorofpiece = board[row][column];
        switch (colorofpiece) {
            case Board.RED:
                if (column == 7) {
                    if (board[row - 1][column - 1] == Board.EMPTY) {
                        result = true;
                    }
                } else if (column == 0) {
                    if (board[row - 1][column + 1] == Board.EMPTY) {
                        result = true;
                    }
                } else {
                    if (board[row - 1][column + 1] == Board.EMPTY || board[row - 1][column - 1] == Board.EMPTY) {
                        result = true;
                    }
                }
                break;
            case Board.BLACK:
                if (column == 7) {
                    if (board[row + 1][column - 1] == Board.EMPTY) {
                        result = true;
                    }
                } else if (column == 0) {
                    if (board[row + 1][column + 1] == Board.EMPTY) {
                        result = true;
                    }
                } else {
                    if (board[row + 1][column + 1] == Board.EMPTY || board[row + 1][column - 1] == Board.EMPTY) {
                        result = true;
                    }
                }
                break;
            case Board.BLACKKING:
            case Board.REDKING:
                result = true;
        }
        return result;
    }

    public boolean canITake(int column, int row, int[][] board) {
        boolean result = false;
        int i, j;
        int colorofpiece = board[row][column];
        switch (colorofpiece) {
            case Board.RED:
                if (row >= 2) {
                    if (column == 7 || column == 6) {
                        if ((board[row - 1][column - 1] == Board.BLACK || board[row - 1][column - 1] == Board.BLACKKING) && board[row - 2][column - 2] == Board.EMPTY) {
                            result = true;
                        }
                    } else if (column == 0 || column == 1) {
                        if ((board[row - 1][column + 1] == Board.BLACK || board[row - 1][column + 1] == Board.BLACKKING)
                                && board[row - 2][column + 2] == Board.EMPTY) {
                            result = true;
                        }
                    } else if (((board[row - 1][column + 1] == Board.BLACK || board[row - 1][column + 1] == Board.BLACKKING) && board[row - 2][column + 2] == Board.EMPTY) || ((board[row - 1][column - 1] == Board.BLACK || board[row - 1][column - 1] == Board.BLACKKING) && board[row - 2][column - 2] == Board.EMPTY)) {
                        result = true;
                    }
                }
                break;
            case Board.BLACK:
                if (row <= 5) {
                    if (column == 7 || column == 6) {
                        if ((board[row + 1][column - 1] == Board.RED || board[row + 1][column - 1] == Board.REDKING) && board[row + 2][column - 2] == Board.EMPTY) {
                            result = true;
                        }
                    } else if (column == 0 || column == 1) {
                        if ((board[row + 1][column + 1] == Board.RED || board[row + 1][column + 1] == Board.REDKING) && board[row + 2][column + 2] == Board.EMPTY) {
                            result = true;
                        }
                    } else {
                        if (((board[row + 1][column + 1] == Board.RED || board[row + 1][column + 1] == Board.REDKING) && board[row + 2][column + 2] == Board.EMPTY) || ((board[row + 1][column - 1] == Board.RED || board[row + 1][column - 1] == Board.REDKING) && board[row + 2][column - 2] == Board.EMPTY)) {
                            result = true;
                        }
                    }
                }
                break;
            case Board.BLACKKING:
                for (i = row - 1, j = column - 1; i > 0 && j > 0; i--, j--) {
                    if (board[i][j] == Board.REDKING || board[i][j] == Board.RED) {
                        if (board[i - 1][j - 1] == Board.EMPTY) {
                            result = true;
                        }
                    }
                }
                for (i = row + 1, j = column - 1; i < 7 && j > 0; i++, j--) {
                    if (board[i][j] == Board.REDKING || board[i][j] == Board.RED) {
                        if (board[i + 1][j - 1] == Board.EMPTY) {
                            result = true;
                        }
                    }
                }
                for (i = row - 1, j = column + 1; i > 0 && j < 7; i--, j++) {
                    if (board[i][j] == Board.REDKING || board[i][j] == Board.RED) {
                        if (board[i - 1][j + 1] == Board.EMPTY) {
                            result = true;
                        }
                    }
                }
                for (i = row + 1, j = column + 1; i < 7 && j < 7; i++, j++) {
                    if (board[i][j] == Board.REDKING || board[i][j] == Board.RED) {
                        if (board[i + 1][j + 1] == Board.EMPTY) {
                            result = true;
                        }
                    }
                }
                break;
            case Board.REDKING:
                for (i = row - 1, j = column - 1; i > 0 && j > 0; i--, j--) {
                    if (board[i][j] == Board.BLACKKING || board[i][j] == Board.BLACK) {
                        if (board[i - 1][j - 1] == Board.EMPTY) {
                            result = true;
                        }
                    }
                }
                for (i = row + 1, j = column - 1; i < 7 && j > 0; i++, j--) {
                    if (board[i][j] == Board.BLACKKING || board[i][j] == Board.BLACK) {
                        if (board[i + 1][j - 1] == Board.EMPTY) {
                            result = true;
                        }
                    }
                }
                for (i = row - 1, j = column + 1; i > 0 && j < 7; i--, j++) {
                    if (board[i][j] == Board.BLACKKING || board[i][j] == Board.BLACK) {
                        if (board[i - 1][j + 1] == Board.EMPTY) {
                            result = true;
                        }
                    }
                }
                for (i = row + 1, j = column + 1; i < 7 && j < 7; i++, j++) {
                    if (board[i][j] == Board.BLACKKING || board[i][j] == Board.BLACK) {
                        if (board[i + 1][j + 1] == Board.EMPTY) {
                            result = true;
                        }
                    }
                }
                break;
        }
        return result;
    }
}
