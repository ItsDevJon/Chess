package com.chess.pieces;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import com.chess.Board;

public abstract class Piece {

    public final static String black = "black.png";
    public final static String white = "white.png";
    private static final Path BASE = Paths.get("src", "main", "resources");

    public BufferedImage img;
    public int y, x;
    public int col, row;

    public enum COLOR {
        BLACK, WHITE
    }

    public enum TYPE {
        KNIGHT, PAWN, BISHOP, ROOK, QUEEN, KING
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
        System.out.println(type);
        switch (type) {
            case KNIGHT:
                if (color == COLOR.BLACK) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("knight_" + black).toString()));

                } else if (color == COLOR.WHITE) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("knight_" + white).toString()));
                } else {
                    img = null;
                }
                break;
            case PAWN:
                if (color == COLOR.BLACK) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("pawn_" + black).toString()));
                } else if (color == COLOR.WHITE) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("pawn_" + white).toString()));
                } else {
                    img = null;
                }
                break;
            case BISHOP:
                if (color == COLOR.BLACK) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("bishop_" + black).toString()));
                } else if (color == COLOR.WHITE) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("bishop_" + white).toString()));
                } else {
                    img = null;
                }
                break;
            case ROOK:
                if (color == COLOR.BLACK) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("rook_" + black).toString()));
                } else if (color == COLOR.WHITE) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("rook_" + white).toString()));
                } else {
                    img = null;
                }
                break;
            case QUEEN:
                if (color == COLOR.BLACK) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("queen_" + black).toString()));
                } else if (color == COLOR.WHITE) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("queen_" + white).toString()));
                } else {
                    img = null;
                }
                break;
            case KING:
                if (color == COLOR.BLACK) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("king_" + black).toString()));
                } else if (color == COLOR.WHITE) {
                    img = ImageIO.read(new FileInputStream(BASE.resolve("king_" + white).toString()));
                } else {
                    img = null;
                }
                break;
            default:
                img = null;
                break;
        }
        return img;
    }

    @Override
    public String toString() {
        return "Piece [img=" + img + ", y=" + y + ", x=" + x + ", type=" + type + ", color=" + color + "]";
    }
}
