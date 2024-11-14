package com.chess.pieces;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chess.Board;
import com.chess.GamePanel;

public class BishopTest {
    
    private Board board;
    private Bishop whiteBishop;

    @BeforeEach
    public void setUp() {
        board = new Board();
        board.chessInit();
        whiteBishop = new Bishop(Piece.COLOR.WHITE, 4 * GamePanel.TILE_SIZE, 4 * GamePanel.TILE_SIZE);
        board.getBoardPieces().set(36, whiteBishop);
    }

    @Test
    public void testValidMoveSW1() {
        assertTrue(whiteBishop.move(board, 3, 3));
        assertTrue(whiteBishop.move(board, 4, 2));
    }

    @Test
    public void testInvalidMove() {
        assertFalse(whiteBishop.move(board, 4, 3));
    }
}
