package Checkers;

public class Game {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Move move = new Move(frame);
        BoardController controller = new BoardController(frame,move);
        frame.setVisible(true);
    }
}
