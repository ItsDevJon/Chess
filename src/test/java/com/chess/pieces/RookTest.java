package com.chess.pieces;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chess.Board;
import com.chess.GamePanel;
import com.chess.pieces.Piece.COLOR;

public class RookTest {
    private Board board;
    private Rook rook;

    @BeforeEach
    void setUp() {
        // Initialize the board and place the king at position (4,4)
        board = new Board();
        rook = new Rook(COLOR.WHITE, 4 * GamePanel.TILE_SIZE, 4 * GamePanel.TILE_SIZE);
        board.getBoardPieces().set(36, rook); 
    }

    @Test
    void testValidWhiteRookMove() {
        assertTrue(rook.move(board, 4, 5));
        assertTrue(rook.move(board, 5, 5));
    }

    @Test
    void testInvalidRookMove() {
        assertFalse(rook.move(board, 5, 5));
    }
}
