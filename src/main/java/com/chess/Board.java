package com.chess;

import java.awt.Graphics2D;
import java.awt.Color;

import java.util.List;

import com.chess.pieces.*;

public class Board {

    public final static int totalRow = 8;
    public final static int totalCol = 8;
    public final static int totalPiece = totalCol * totalRow;

    GamePanel gp;

    public static final int width = 8;

    public List<Piece> boardPieces;

    //TODO: GET list<Piece> chessBoard and initialize
    public Board(GamePanel gp) {
        this.gp = gp;
        System.out.println("asi da");
        chessInit();
    }

    public void chessInit() {
        //TODO: INIT list INIT
        System.out.println("init list");
    }
    public void drawBoard(Graphics2D g2){
        boolean turnTales = true;
        for (int y = 0; y < Chess.totalCol; y++) {
            for (int x = 0; x < Chess.totalRow; x++) {
                g2.setColor(turnTales ? Color.BLACK : Color.WHITE);
                g2.fillRect(x * gp.tileSize, y * gp.tileSize, gp.tileSize,
                gp.tileSize);
                turnTales = !turnTales;
            }
            turnTales = !turnTales;
        }
    }
}
