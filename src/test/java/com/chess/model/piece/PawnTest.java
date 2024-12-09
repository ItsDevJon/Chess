package com.chess.model.piece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    @Test
    void testConstructor() {
        Piece piece = new Pawn(PieceColor.WHITE);
        assertEquals(PieceColor.WHITE, piece.getPieceColor());
    }

}