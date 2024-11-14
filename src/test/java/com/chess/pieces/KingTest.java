package com.chess.pieces;

import com.chess.Board;
import com.chess.GamePanel;
import com.chess.pieces.Piece.COLOR;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    private Board board;
    private King king;

    @BeforeEach
    void setUp() {
        // Initialize the board and place the king at position (4,4)
        board = new Board();
        king = new King(COLOR.WHITE, 4 * GamePanel.TILE_SIZE, 4 * GamePanel.TILE_SIZE);
        board.getBoardPieces().set(36, king); // Assume this method places the king on the board at (4,4)
    }

    @Test
    void testValidKingMove() {
        assertFalse(king.move(board, 4, 4)); // Self
        assertTrue(king.move(board, 3, 3)); // North-West
        assertTrue(king.move(board, 4, 4)); // South-East
        assertTrue(king.move(board, 5, 4)); // East
        assertTrue(king.move(board, 4, 4)); // West
        assertTrue(king.move(board, 5, 3)); // North-East
        assertTrue(king.move(board, 4, 4)); // South-West
        assertTrue(king.move(board, 4, 3)); // North
        assertTrue(king.move(board, 4, 4)); // South
    }
    @Test
    void testInvalidMoveTooFar() {
        assertFalse(king.move(board, 6, 4), "King should not be able to move more than one square in any direction");
    }

    @Test
    void testInvalidMoveNonAdjacent() {
        assertFalse(king.move(board, 2, 2), "King should not be able to move to a non-adjacent square");
    }

}
