package com.chess.pieces;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import com.chess.Board;
import com.chess.GamePanel;

public abstract class Piece {

    public static final String black = "black.png";
    public static final String white = "white.png";
    private static final Path BASE = Paths.get("src", "main", "resources");

    public BufferedImage img;
    public int y, x;
    public int col, row;

    public enum COLOR {
        BLACK, WHITE
    }

    public enum TYPE {

        KNIGHT("knight"), 
        PAWN("pawn"), 
        BISHOP("bishop"), 
        ROOK("rook"), 
        QUEEN("queen"), 
        KING("king");

        private final String name;

        TYPE(String name) {
            this.name = name.toLowerCase();
        }
    }

    public enum CORDS {
        A, B, C, D
    }

    public TYPE type;
    public COLOR color;

    public Piece(TYPE type, COLOR color, int y, int x) {
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
        try {
            this.img = getImg(type, color);

        } catch (Exception e) {
            img = null;
            e.printStackTrace();
        }
    }

    public abstract boolean move(Board board, int xTo, int yTo);

    private BufferedImage getImg(TYPE type, COLOR color) throws FileNotFoundException, IOException {

        BufferedImage img;
        
        img = ImageIO.read(new FileInputStream(BASE.resolve(type + "_" + color + ".png").toString().toLowerCase()));

        return img;
    }

    public CORDS getElectedCords(int xTo, int yTo) {
        ArrayList<CORDS> xCords = new ArrayList<>();
        ArrayList<CORDS> yCords = new ArrayList<>();
        if (yTo > (this.y / GamePanel.tileSize)) {
            yCords.add(CORDS.A);
            yCords.add(CORDS.B);
        } else {
            yCords.add(CORDS.C);
            yCords.add(CORDS.D);
        }
        if (xTo > (this.y / GamePanel.tileSize)) {
            xCords.add(CORDS.A);
            xCords.add(CORDS.B);
        } else {
            xCords.add(CORDS.C);
            xCords.add(CORDS.D);
        }
        return yCords.stream()
                        .filter(xCords::contains)
                        .collect(Collectors.toList())
                        .get(0);
    }

    public boolean canMove(Board board, int pieceIndex, int possibleMove) {

        Optional<Piece> tileToMove = Optional.ofNullable(board.boardPieces.get(possibleMove));
            if ((tileToMove.isPresent() && tileToMove.get().color != this.color) || tileToMove.isEmpty()) {
                movePiece(board, pieceIndex, possibleMove);
                return true;
            }   else {
                return false;
            }
    }

    private void movePiece(Board board, int indexOfPiece, int indexOfTileToMove) {
        board.boardPieces.set(indexOfTileToMove, this);
        board.boardPieces.set(indexOfPiece, null);
        row = indexOfTileToMove/Board.width;
        col = indexOfTileToMove-(Board.width*row);
        this.y = row * GamePanel.tileSize;
        this.x = col * GamePanel.tileSize;
    }



    @Override
    public String toString() {
        return "Piece [img=" + img + ", y=" + y + ", x=" + x + ", type=" + type + ", color=" + color + "]";
    }
}
