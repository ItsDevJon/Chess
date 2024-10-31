package com.chess;

import java.awt.Graphics2D;

public class Chess {
    public static final int totalCol = 8;
    public static final int totalRow = 8;

    GamePanel gp;
    Board board;
    public Chess(GamePanel gp){
        this.gp = gp;
        this.board = new Board(gp);

    }
    public void game(){
        
    }
    public void draw(Graphics2D g2) {
        board.drawBoard(g2);
    }
}
