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
import com.chess.pieces.Queen;
import com.chess.pieces.Rook;
import com.chess.pieces.Piece.COLOR;

public class Board {

    public final static int totalRow = 8;
    public final static int totalCol = 8;
    public final static int totalPiece = totalCol * totalRow;

    public static final int width = 8;

    public List<Piece> boardPieces;

    public Board() {
        boardPieces = new ArrayList<>(totalPiece);
        //System.out.println("asi da");
        chessInit();
    }

    public void chessInit() {
        for (int y = 0; y < totalCol; y++) {
            switch (y) {
                case 0:
                    boardPieces.add(new Rook(COLOR.WHITE, y * GamePanel.tileSize, 0 * GamePanel.tileSize));
                    boardPieces.add(new Knight(COLOR.WHITE, y * GamePanel.tileSize, 1 * GamePanel.tileSize));
                    boardPieces.add(new Bishop(COLOR.WHITE, y * GamePanel.tileSize, 2 * GamePanel.tileSize));
                    boardPieces.add(new Queen(COLOR.WHITE, y * GamePanel.tileSize, 3 * GamePanel.tileSize));
                    boardPieces.add(new King(COLOR.WHITE, y * GamePanel.tileSize, 4 * GamePanel.tileSize));
                    boardPieces.add(new Bishop(COLOR.WHITE, y * GamePanel.tileSize, 5 * GamePanel.tileSize));
                    boardPieces.add(new Knight(COLOR.WHITE, y * GamePanel.tileSize, 6 * GamePanel.tileSize));
                    boardPieces.add(new Rook(COLOR.WHITE, y * GamePanel.tileSize, 7 * GamePanel.tileSize));
                    break;
                case 1:
                    for (int i = 0; i < totalRow; i++) {
                        boardPieces.add(new Pawn(COLOR.WHITE, y * GamePanel.tileSize, i * GamePanel.tileSize));
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    for (int i = 0; i < totalRow; i++) {
                        boardPieces.add(null);
                    }
                    break;
                case 6:
                    for (int i = 0; i < totalRow; i++) {
                        boardPieces.add(new Pawn(COLOR.BLACK, y * GamePanel.tileSize, i * GamePanel.tileSize));
                    }
                    break;
                case 7:
                    boardPieces.add(new Rook(COLOR.BLACK, y * GamePanel.tileSize, 0 * GamePanel.tileSize));
                    boardPieces.add(new Knight(COLOR.BLACK, y * GamePanel.tileSize, 1 * GamePanel.tileSize));
                    boardPieces.add(new Bishop(COLOR.BLACK, y * GamePanel.tileSize, 2 * GamePanel.tileSize));
                    boardPieces.add(new Queen(COLOR.BLACK, y * GamePanel.tileSize, 3 * GamePanel.tileSize));
                    boardPieces.add(new King(COLOR.BLACK, y * GamePanel.tileSize, 4 * GamePanel.tileSize));
                    boardPieces.add(new Bishop(COLOR.BLACK, y * GamePanel.tileSize, 5 * GamePanel.tileSize));
                    boardPieces.add(new Knight(COLOR.BLACK, y * GamePanel.tileSize, 6 * GamePanel.tileSize));
                    boardPieces.add(new Rook(COLOR.BLACK, y * GamePanel.tileSize, 7 * GamePanel.tileSize));
                    break;

                default:
                    break;
            }
        }
        //boardPieces.forEach(n -> System.out.println(n != null ? n.toString() : "null"));
    }
    public void drawPieces(Graphics2D g2){
        boardPieces.stream().filter(x -> x != null)
                .forEach((n) ->g2.drawImage(n.img, n.x, n.y, GamePanel.tileSize, GamePanel.tileSize, null));
        
    }
    public void drawBoard(Graphics2D g2){
        boolean turnTales = true;
        for (int y = 0; y < Chess.totalCol; y++) {
            for (int x = 0; x < Chess.totalRow; x++) {
                g2.setColor(turnTales ? Color.BLACK : Color.WHITE);
                g2.fillRect(x * GamePanel.tileSize, y * GamePanel.tileSize, GamePanel.tileSize,
                GamePanel.tileSize);
                turnTales = !turnTales;
            }
            turnTales = !turnTales;
        }
    }
}
