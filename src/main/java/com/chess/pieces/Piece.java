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

    public static final String BLACK = "black.png";
    public static final String WITHE = "white.png";
    private static final Path BASE = Paths.get("src", "main", "resources");

    public BufferedImage img;
    public int y, x;

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
        SW, S, SE, E, NE, N, NW, W, SELF
    }

    public TYPE type;
    public COLOR color;

    public Piece(TYPE type, COLOR color, int y, int x) {
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
        try {
            this.img = loadImg(type, color);

        } catch (Exception e) {
            img = null;
            e.printStackTrace();
        }
    }
    
    public boolean canMove(Board board, int pieceIndex, int possibleMove) {
        
        Optional<Piece> tileToMove = Optional.ofNullable(board.getBoardPieces().get(possibleMove));
        if ((tileToMove.isPresent() && tileToMove.get().color != this.color) || tileToMove.isEmpty()) {
            movePiece(board, pieceIndex, possibleMove);
            return true;
        }   else {
            return false;
        }
    }
    
    public boolean moveDiagonal(Board board, int xTo, int yTo) {
        int xOrigin = (this.x / GamePanel.TILE_SIZE);
        int yOrigin = (this.y / GamePanel.TILE_SIZE);
        int xDirection;
        int yDirection;
        int goTo;
        if(xOrigin<xTo){
            xDirection = 1;
            goTo = xTo-xOrigin;
        }else if(xOrigin>xTo){
            xDirection = -1;
            goTo = xOrigin-xTo;
        }else return false;
        if(yOrigin<yTo){
            yDirection = 1;
        }else if(yOrigin>yTo){
            yDirection = -1;
        }else return false;
        for (int i = 1; i < goTo; i++) {
            int index2 = ((yOrigin + (i*yDirection)) * Board.WIDTH + (xOrigin + (i*xDirection)));
            boolean isTileEmpty = (verifyMovePiece(board, index2, false, false));
            if (!isTileEmpty) {
                return false;
            }
        }
        return verifyAndMovePiece(board, xTo, yTo, goTo*xDirection, goTo*yDirection, false, true);
    }

    public boolean moveCross(Board board, int xTo, int yTo) {
        int xOrigin = (this.x / GamePanel.TILE_SIZE);
        int yOrigin = (this.y / GamePanel.TILE_SIZE);
        int xDirection=0;
        int yDirection=0;
        int goTo=0;
        if(xOrigin==xTo && yOrigin!=yTo){
            xDirection = 0;
            yDirection = yOrigin>yTo?-1:1;
            goTo = yTo-yOrigin;
        }
        else if(xOrigin!=xTo &&yOrigin==yTo){
            xDirection = xOrigin>xTo?-1:1;
            yDirection = 0;
            goTo = xTo-xOrigin;
        }else return false;
        goTo = Math.abs(goTo);
        for (int i = 1; i < goTo; i++) {
            int index2 = ((yOrigin + (i*yDirection)) * Board.WIDTH + (xOrigin + (i*xDirection)));
            boolean isTileEmpty = (verifyMovePiece(board, index2, false, false));
            if (!isTileEmpty) {
                return false;
            }
        }
        return verifyAndMovePiece(board, xTo, yTo, goTo*xDirection, goTo*yDirection, false, true);
    }

    public boolean verifyAndMovePiece(Board board, int xTo, int yTo, int col, int row, boolean ocupied,
            boolean jump) {
        int pieceCol = (this.y / GamePanel.TILE_SIZE);
        int pieceRow = (this.x / GamePanel.TILE_SIZE);
        int pieceIndex = (pieceCol * Board.WIDTH + pieceRow);
        int wantedMove = (yTo * Board.WIDTH + xTo);
        int piecePossibleMove;
        piecePossibleMove = (pieceCol + row) * Board.WIDTH + (pieceRow + col);
        if (piecePossibleMove == wantedMove) {
            if (this.verifyMovePiece(board, piecePossibleMove, ocupied, jump)) {
                movePiece(board, pieceIndex, piecePossibleMove);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean verifyMovePiece(Board board, int piecePossibleMove, boolean hasToBeOcupied, boolean jump) {
        Optional<Piece> tileToMovePiece = Optional.ofNullable(board.getBoardPieces().get(piecePossibleMove));
        if ((tileToMovePiece.isPresent() && tileToMovePiece.get().color != this.color && jump)
                || (tileToMovePiece.isEmpty() && !hasToBeOcupied)) {
            return true;
        } 
        return false;
    }

    private void movePiece(Board board, int indexOfPiece, int indexOfTileToMove) {
        board.getBoardPieces().set(indexOfTileToMove, this);
        board.getBoardPieces().set(indexOfPiece, null);
        int row = indexOfTileToMove/Board.WIDTH;
        int col = indexOfTileToMove-(Board.WIDTH*row);
        this.y = row * GamePanel.TILE_SIZE;
        this.x = col * GamePanel.TILE_SIZE;
    }

    public CORDS getElectedCords(int xTo, int yTo) {
        ArrayList<CORDS> xCords = new ArrayList<CORDS>();
        ArrayList<CORDS> yCords = new ArrayList<CORDS>();
        if (yTo == (this.y / GamePanel.TILE_SIZE)) {
            yCords.add(CORDS.W);
            yCords.add(CORDS.E);
            yCords.add(CORDS.SELF);
        } else if (yTo > (this.y / GamePanel.TILE_SIZE)) {
            yCords.add(CORDS.SW);
            yCords.add(CORDS.S);
            yCords.add(CORDS.SE);
        } else {
            yCords.add(CORDS.N);
            yCords.add(CORDS.NE);
            yCords.add(CORDS.NW);
        }
        if (xTo == (this.x / GamePanel.TILE_SIZE)) {
            xCords.add(CORDS.N);
            xCords.add(CORDS.S);
            xCords.add(CORDS.SELF);
        } else if (xTo > (this.x / GamePanel.TILE_SIZE)) {
            xCords.add(CORDS.NE);
            xCords.add(CORDS.E);
            xCords.add(CORDS.SE);
        } else {
            xCords.add(CORDS.W);
            xCords.add(CORDS.SW);
            xCords.add(CORDS.NW);
        }
        return yCords.stream()
                .filter(xCords::contains)
                .collect(Collectors
                        .toList())
                .get(0);
    }

    public abstract boolean move(Board board, int xTo, int yTo);

    private BufferedImage loadImg(TYPE type, COLOR color) throws FileNotFoundException, IOException {

        BufferedImage img;
        
        img = ImageIO.read(new FileInputStream(BASE.resolve(type + "_" + color + ".png").toString().toLowerCase()));

        return img;
    }

    @Override
    public String toString() {
        return "Piece [img=" + img + ", y=" + y + ", x=" + x + ", type=" + type + ", color=" + color + "]";
    }
}
