
package com.chess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.chess.pieces.Piece;
import com.chess.pieces.Piece.COLOR;
import com.chess.pieces.Piece.TYPE;

public class Chess {
    public static final int TOTAL_COL = 8;
    public static final int TOTAL_ROW = 8;

    private GamePanel gp;
    private Board board;
    private COLOR turn;

    public Chess(GamePanel gp, MouseHandler mHandler) {
        this.gp = gp;
        turn = COLOR.WHITE;
        this.board = new Board();
    }

    private COLOR turnSwitch(boolean moved) {
        if (!moved)
            return turn;
        return turn == COLOR.BLACK ? COLOR.WHITE : COLOR.BLACK;
    }

    public boolean hasGameFinish() {
        List<Piece> kingLIst = board.getBoardPieces().stream().filter(Objects::nonNull).collect(Collectors.toList()).stream().filter(n -> n.type == TYPE.KING).collect(Collectors.toList());
        if(kingLIst.size()==1){
            System.out.println(kingLIst.get(0).color==COLOR.BLACK?"BLACK":"WITHE"+" HAS WON!!!\nClose the window to start over");
        }
        return kingLIst.size() == 2 ? false : true;
    }

    public boolean game() {
        if (gp.mHandler.clicked) {
            Piece pieceFrom = board.getBoardPieces()
                    .get(((gp.mHandler.yFrom / GamePanel.TILE_SIZE) * Board.WIDTH)
                            + (gp.mHandler.xFrom / GamePanel.TILE_SIZE));
            Piece pieceToMove = board.getBoardPieces()
                    .get(((gp.mHandler.yTo / GamePanel.TILE_SIZE) * Board.WIDTH)
                            + (gp.mHandler.xTo / GamePanel.TILE_SIZE));
            if ((pieceFrom != null && !pieceFrom.equals(pieceToMove)) && turn == pieceFrom.color) {
                boolean moved = pieceFrom.move(board, (gp.mHandler.xTo / GamePanel.TILE_SIZE),
                        (gp.mHandler.yTo / GamePanel.TILE_SIZE));
                turn = turnSwitch(moved);
            }
            gp.mHandler.clicked = false;
            System.out.println(turn);
            if(hasGameFinish()){
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics2D g2) {
        board.drawBoard(g2);
        board.drawPieces(g2);
        if (gp.mHandler.selected) {
            Stroke stroke1 = new BasicStroke(6f);
            int x = (gp.mHandler.xFrom / GamePanel.TILE_SIZE);
            int y = (gp.mHandler.yFrom / GamePanel.TILE_SIZE);
            g2.setColor(Color.GREEN);
            g2.setStroke(stroke1);
            g2.drawRect(x * GamePanel.TILE_SIZE, y * GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE);
        }
    }
}
