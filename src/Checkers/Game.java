package Checkers;

public class Game {
    public static void main(String[] args) {
        Frame frame = new Frame();
        BoardController controller = new BoardController(frame);
        frame.setVisible(true);
    }
}
