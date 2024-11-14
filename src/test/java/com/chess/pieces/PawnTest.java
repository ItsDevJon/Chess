package com.chess.pieces;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chess.Board;
import com.chess.GamePanel;
import com.chess.pieces.Piece.COLOR;

class PawnTest {
    private Board board;
    private Pawn wPawn;
    private Pawn bPawn;
    
    @BeforeEach
    void setUp() {
        // Initialize the board and place the king at position (4,4)
        board = new Board();
        wPawn = new Pawn(COLOR.WHITE, 4 * GamePanel.TILE_SIZE, 4 * GamePanel.TILE_SIZE);
        bPawn = new Pawn(COLOR.BLACK, 3 * GamePanel.TILE_SIZE, 3 * GamePanel.TILE_SIZE);
        board.getBoardPieces().set(36, wPawn); 
        board.getBoardPieces().set(27, bPawn); 

    }

    @Test
    void testValidWhitePawnMove() {
        assertTrue(wPawn.move(board, 4, 5));
    }

    @Test 
    void testInvalidWhitePawnMove() {
        assertFalse(wPawn.move(board, 4, 3));
        assertFalse(wPawn.move(board, 5, 5));
        assertFalse(wPawn.move(board, 3, 5));
    }
    @Test
    void testValidBlackPawnMove() {
        assertTrue(bPawn.move(board, 3, 2));
    }

    @Test 
    void testInvalidBlackPawnMove() {
        assertFalse(bPawn.move(board, 3, 4));
        assertFalse(bPawn.move(board, 2, 2));
        assertFalse(bPawn.move(board, 4, 2));
    }
}
