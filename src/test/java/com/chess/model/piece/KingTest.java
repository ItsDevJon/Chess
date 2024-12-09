package com.chess.model.piece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KingTest {

    @Test
    void testConstructor() {
        Piece piece = new King(PieceColor.WHITE);
        assertEquals(PieceColor.WHITE, piece.getPieceColor());
    }

}