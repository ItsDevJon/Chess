package com.chess.pieces;

import com.chess.GamePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.chess.Board;

class QueenTest {

    private Queen queen;
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.chessInit();
        queen = new Queen(Piece.COLOR.WHITE, 3 * GamePanel.TILE_SIZE, 3 * GamePanel.TILE_SIZE);
    }

    @Test
    void move_validDiagonalMove_returnsTrue() {
        // Test moving the queen diagonally to a valid position
        assertTrue(queen.move(board, 5, 5));
        assertTrue(queen.move(board, 3, 3));
        assertFalse(queen.move(board, 3, 3));
        // Check that the queen's new position is (5, 5)
//        assertEquals(5, queen.x);
//        assertEquals(5, queen.y);
    }

    @Test
    void move_validCrossMove_returnsTrue() {
        // Test moving the queen horizontally to a valid position
        assertTrue(queen.move(board, 3, 6));
        // Check that the queen's new position is (3, 6)
//        assertEquals(3, queen.x);
//        assertEquals(6, queen.y);
    }

    @Test
    void move_invalidMove_returnsFalse() {
        // Attempt to move the queen in an invalid way, e.g., to a position not in straight or diagonal lines
        assertFalse(queen.move(board, 4, 6));
        // Ensure the queen’s position hasn't changed after an invalid move attempt
//        assertEquals(3, queen.x);
//        assertEquals(3, queen.y);
    }

    @Test
    void move_invalidCords_returnsFalse() {
        // Attempt to move the queen in an invalid way, e.g., to a position not in straight or diagonal lines
        assertFalse(queen.move(board, 3, 3));
        // Ensure the queen’s position hasn't changed after an invalid move attempt
    }
}