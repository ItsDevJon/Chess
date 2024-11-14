package com.chess.pieces;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chess.Board;
import com.chess.GamePanel;
import com.chess.pieces.Piece.COLOR;

class RookTest {
    private Board board;
    private Rook rook;
    private Rook badRook;

    @BeforeEach
    void setUp() {
        // Initialize the board and place the king at position (4,4)
        board = new Board();
        rook = new Rook(COLOR.WHITE, 4 * GamePanel.TILE_SIZE, 4 * GamePanel.TILE_SIZE);
        badRook = new Rook(null, 3 * GamePanel.TILE_SIZE, 3 * GamePanel.TILE_SIZE);
        board.getBoardPieces().set(36, rook);
        board.getBoardPieces().set(27, badRook);

    }

    @Test
    void testValidWhiteRookMove() {
        assertTrue(rook.move(board, 4, 5));
        assertTrue(rook.move(board, 5, 5));
        assertTrue(rook.move(board, 4, 5));
        assertTrue(rook.move(board, 4, 4));

    }

    @Test
    void testInvalidRookMove() {
        assertFalse(rook.move(board, 5, 5));
    }
}
