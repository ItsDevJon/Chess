
package com.chess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import com.chess.pieces.Piece;
import com.chess.pieces.Piece.COLOR;
import java.awt.Stroke;


public class Chess {
    public static final int totalCol = 8;
    public static final int totalRow = 8;

    GamePanel gp;
    Board board;
    private COLOR turn;
    public Chess(GamePanel gp, MouseHandler mHandler){
        this.gp = gp;
        turn = COLOR.WHITE;
        this.board = new Board();
    }
    private COLOR turnSwitch(boolean moved) {
        if(!moved)return turn;
        return turn == COLOR.BLACK ? COLOR.WHITE : COLOR.BLACK;
    }
    public void game(){
        if (gp.mHandler.clicked) {
            Piece pieceFrom = board.boardPieces
                    .get(((gp.mHandler.yFrom / GamePanel.tileSize) * Board.width) + (gp.mHandler.xFrom / GamePanel.tileSize));
            Piece pieceToMove = board.boardPieces
                    .get(((gp.mHandler.yTo / GamePanel.tileSize) * Board.width) + (gp.mHandler.xTo / GamePanel.tileSize));
            if ((pieceFrom != null && !pieceFrom.equals(pieceToMove)) && turn == pieceFrom.color) {
                boolean moved = pieceFrom.move(board, (gp.mHandler.xTo / GamePanel.tileSize), (gp.mHandler.yTo / GamePanel.tileSize));
                turn = turnSwitch(moved);
            }
            gp.mHandler.clicked = false;
            System.out.println(turn);
        }
    }
    public void draw(Graphics2D g2) {
        board.drawBoard(g2);
        board.drawPieces(g2);
        if (gp.mHandler.selected) {
            Stroke stroke1 = new BasicStroke(6f);
            int x = (gp.mHandler.xFrom/ GamePanel.tileSize);
            int y = (gp.mHandler.yFrom / GamePanel.tileSize);
            g2.setColor(Color.GREEN);
            g2.setStroke(stroke1);
            g2.drawRect(x * GamePanel.tileSize, y * GamePanel.tileSize, GamePanel.tileSize, GamePanel.tileSize);
        }
    }
}
