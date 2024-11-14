package com.chess.pieces;

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
        queen = new Queen(Piece.COLOR.WHITE, 3, 3);
    }

    @Test
    void move_SW_ReturnsTrue() {
        // Test move Southwest
        assertTrue(queen.move(board, 2, 2));
    }

    @Test
    void move_SE_ReturnsTrue() {
        // Test move Southeast
        assertTrue(queen.move(board, 4, 2));
    }

    @Test
    void move_NE_ReturnsTrue() {
        // Test move Northeast
        assertTrue(queen.move(board, 4, 4));
    }

    @Test
    void move_NW_ReturnsTrue() {
        // Test move Northwest
        assertTrue(queen.move(board, 2, 4));
    }

    @Test
    void move_North_ReturnsTrue() {
        // Test move North
        assertTrue(queen.move(board, 3, 4));
    }

    @Test
    void move_South_ReturnsTrue() {
        // Test move South
        assertTrue(queen.move(board, 3, 2));
    }

    @Test
    void move_East_ReturnsTrue() {
        // Test move East
        assertTrue(queen.move(board, 4, 3));
    }

    @Test
    void move_West_ReturnsTrue() {
        // Test move West
        assertTrue(queen.move(board, 2, 3));
    }

    @Test
    void move_Invalid_ReturnsFalse() {
        // Test an invalid move
        assertFalse(queen.move(board, 5, 5)); // Assuming (5,5) is neither diagonal nor straight.
    }

}
