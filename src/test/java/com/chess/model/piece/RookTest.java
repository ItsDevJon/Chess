package com.chess.model.piece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RookTest {
  
    @Test
    void testConstructor() {
        Piece piece = new Rook(PieceColor.WHITE);
        assertEquals(PieceColor.WHITE, piece.getPieceColor());
    }

}