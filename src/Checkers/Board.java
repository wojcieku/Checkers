package Checkers;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    static final int EMPTY = 0,RED = 1,BLACK = 2,REDKING = 3,BLACKKING=4;
    int[][] board = new int[8][8];
    public void setUpPawns(){
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++){
                if(row%2!=col%2){
                    if(row<3) board[row][col] = BLACK;
                    else if(row>4)board[row][col]= RED;
                    else board[row][col] = EMPTY;
                }else
                    board[row][col]=EMPTY;
            }
        }
    }
    int returnValurOfPiece(int row,int col){
        return board[row][col];
    }
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++){
                if(row%2==col%2) g.setColor(Color.LIGHT_GRAY);
                else g.setColor(Color.GRAY);
                g.fillRect(col*50,row*50,50,50);
                switch(returnValurOfPiece(row,col)) {
                    case RED:
                        g.setColor(Color.RED);
                        g.fillOval(5 + col * 50, 5 + row * 50, 40, 40);
                        break;
                    case BLACK:
                        g.setColor(Color.BLACK);
                        g.fillOval(5 + col * 50, 5 + row * 50, 40, 40);
                        break;

                }
            }
        }

    }

    public Board(){
        setUpPawns();
    }
}
