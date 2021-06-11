package Checkers;

import java.util.ArrayList;

public class Bot {
    private Board board;
    private Move move;
    private BoardController boardController; //stad ktory kolor ma ruch
    private ArrayList<Integer> coordinates = new ArrayList<Integer>();

    //    int[][] coordinates = new int[48];
    public boolean checkAllPiecesPossibleTakes(int color, int[][] board) {
        boolean result = false;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
           //     if (canITake(col, row)) if (board[row][col] == color) //nowe canITake dla dowolnej planszy
                    result = true;
            }
        }
        return result;
    }

    public void analyze() {
        // przejscie przez plansze, dodanie mozliwych wspolrzednych
        if (move.checkAllPiecesPossibleTakes(boardController.botsColor)) { //jesli trzeba zbic -> canITake dla kazdego pola && color
            //dodawanie do coordinates
        }
        else{} //dodawanaie do coordinates canIMove dla każdego pola && color
    }

    public void symuluj() {
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
    public boolean szansaNaDame(int colorToCheck){
        boolean check = false;
        //sprawdzenie czy jest ryzyko/szansa zdobycia damy
        return check;
    }
    public void ruszsie() {
        //ruch
        coordinates.clear(); //reset listy mozliwych ruchow
    }
}
