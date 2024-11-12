package com.chess;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.chess.pieces.Piece;
import com.chess.pieces.Piece.COLOR;
import com.chess.pieces.Piece.TYPE;


class PieceTest {

    Piece piece;
    
    @BeforeEach
    void setUp() {
        piece = new Piece(TYPE.KNIGHT, COLOR.WHITE, 0, 0) {
            @Override
            public boolean move(Board board, int xTo, int yTo) {
                return false;
            }
        };
    }

    @AfterEach
    void tearDown() {
        piece = null;
    }

    @Test
    void move() {
        assertFalse(piece.move(null, 0, 0));
    }

    @Test
    void testConstructor() {
        assertEquals(TYPE.KNIGHT, piece.type);
        assertEquals(COLOR.WHITE, piece.color);
        assertEquals(0, piece.x);
        assertEquals(0, piece.y);
        assertNotNull(piece.img);
    }

    @Test
    void testToString() {
        String expected = "Piece [img=" + piece.img + ", y=" + piece.y + ", x=" + piece.x + ", type=" + piece.type + ", color=" + piece.color + "]";
        assertEquals(expected, piece.toString());
    }
}