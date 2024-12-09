package com.chess.model.piece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BishopTest {

    @Test
    void testConstructor() {
        Piece piece = new Bishop(PieceColor.BLACK);
        assertEquals(PieceColor.BLACK, piece.getPieceColor());
        assertEquals(PieceType.BISHOP, piece.getPieceType());
        assertEquals(PieceType.BISHOP.getImage(PieceColor.BLACK), piece.getImage());
        assertEquals("Bishop", piece.getPieceType().getName());
    }

}