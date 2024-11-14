package com.chess;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.chess.pieces.Bishop;
import com.chess.pieces.King;
import com.chess.pieces.Knight;
import com.chess.pieces.Pawn;
import com.chess.pieces.Piece;
import com.chess.pieces.Piece.COLOR;
import com.chess.pieces.Queen;
import com.chess.pieces.Rook;

public class Board {

    public static final int TOTAL_ROW = 8;
    public static final int TOTAL_COL = 8;
    public static final int TOTAL_PIECE = TOTAL_COL * TOTAL_ROW;

    public static final int WIDTH = 8;

    private List<Piece> boardPieces;

    public Board() {
        boardPieces = new ArrayList<>(TOTAL_PIECE);
        chessInit();
    }

    public void chessInit() {
        for (int y = 0; y < TOTAL_COL; y++) {
            switch (y) {
                case 0:
                    boardPieces.add(new Rook(COLOR.WHITE, y * GamePanel.TILE_SIZE, 0 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Knight(COLOR.WHITE, y * GamePanel.TILE_SIZE, 1 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Bishop(COLOR.WHITE, y * GamePanel.TILE_SIZE, 2 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Queen(COLOR.WHITE, y * GamePanel.TILE_SIZE, 3 * GamePanel.TILE_SIZE));
                    boardPieces.add(new King(COLOR.WHITE, y * GamePanel.TILE_SIZE, 4 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Bishop(COLOR.WHITE, y * GamePanel.TILE_SIZE, 5 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Knight(COLOR.WHITE, y * GamePanel.TILE_SIZE, 6 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Rook(COLOR.WHITE, y * GamePanel.TILE_SIZE, 7 * GamePanel.TILE_SIZE));
                    break;
                case 1:
                    for (int i = 0; i < TOTAL_ROW; i++) {
                        boardPieces.add(new Pawn(COLOR.WHITE, y * GamePanel.TILE_SIZE, i * GamePanel.TILE_SIZE));
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    for (int i = 0; i < TOTAL_ROW; i++) {
                        boardPieces.add(null);
                    }
                    break;
                case 6:
                    for (int i = 0; i < TOTAL_ROW; i++) {
                        boardPieces.add(new Pawn(COLOR.BLACK, y * GamePanel.TILE_SIZE, i * GamePanel.TILE_SIZE));
                    }
                    break;
                case 7:
                    boardPieces.add(new Rook(COLOR.BLACK, y * GamePanel.TILE_SIZE, 0 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Knight(COLOR.BLACK, y * GamePanel.TILE_SIZE, 1 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Bishop(COLOR.BLACK, y * GamePanel.TILE_SIZE, 2 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Queen(COLOR.BLACK, y * GamePanel.TILE_SIZE, 3 * GamePanel.TILE_SIZE));
                    boardPieces.add(new King(COLOR.BLACK, y * GamePanel.TILE_SIZE, 4 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Bishop(COLOR.BLACK, y * GamePanel.TILE_SIZE, 5 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Knight(COLOR.BLACK, y * GamePanel.TILE_SIZE, 6 * GamePanel.TILE_SIZE));
                    boardPieces.add(new Rook(COLOR.BLACK, y * GamePanel.TILE_SIZE, 7 * GamePanel.TILE_SIZE));
                    break;
                default:
                    break;
            }
        }
        // boardPieces.forEach(n -> System.out.println(n != null ? n.toString() :
        // "null"));
    }

    public void drawPieces(Graphics2D g2) {
        boardPieces.stream().filter(x -> x != null)
                .forEach(n -> g2.drawImage(n.img, n.x, n.y, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, null));

    }

    public void drawBoard(Graphics2D g2) {
        boolean turnTales = true;
        for (int y = 0; y < TOTAL_COL; y++) {
            for (int x = 0; x < TOTAL_ROW; x++) {
                g2.setColor(turnTales ? Color.BLACK : Color.WHITE);
                g2.fillRect(x * GamePanel.TILE_SIZE, y * GamePanel.TILE_SIZE, GamePanel.TILE_SIZE,
                        GamePanel.TILE_SIZE);
                turnTales = !turnTales;
            }
            turnTales = !turnTales;
        }
    }

    public static int getTotalRow() {
        return TOTAL_ROW;
    }

    public static int getTotalCol() {
        return TOTAL_COL;
    }

    public static int getTotalPiece() {
        return TOTAL_PIECE;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public List<Piece> getBoardPieces() {
        return boardPieces;
    }

    public void setBoardPieces(List<Piece> boardPieces) {
        this.boardPieces = boardPieces;
    }
}
