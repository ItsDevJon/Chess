package com.chess.model.piece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueenTest {

    @Test
    void testConstructor() {
        Piece piece = new Queen(PieceColor.WHITE);
        assertEquals(PieceColor.WHITE, piece.getPieceColor());
    }

}