package com.chess.pieces;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.chess.Board;
import com.chess.GamePanel;

public class KnightTest {

    private Board board;
    private Knight whiteKnight;

    @BeforeEach
    public void setUp() {
        board = new Board();
        board.chessInit();
        whiteKnight = new Knight(Piece.COLOR.WHITE, 4 * GamePanel.tileSize, 3 * GamePanel.tileSize);
    }

    @Test
    public void testValidMoveSW1() {
        assertTrue(whiteKnight.move(board, 2, 2));
    }

    @Test
    public void testValidMoveSW2() {
        assertTrue(whiteKnight.move(board, 3, 1));
    }

    @Test
    public void testValidMoveSE1() {
        assertTrue(whiteKnight.move(board, 5, 1));
    }

    @Test
    public void testValidMoveSE2() {
        assertTrue(whiteKnight.move(board, 6, 2));
    }

    @Test
    public void testValidMoveNW1() {
        assertTrue(whiteKnight.move(board, 2, 4));
    }

    @Test
    public void testValidMoveNW2() {
        assertTrue(whiteKnight.move(board, 3, 5));
    }

    @Test
    public void testValidMoveNE1() {
        assertTrue(whiteKnight.move(board, 5, 5));
    }

    @Test
    public void testValidMoveNE2() {
        assertTrue(whiteKnight.move(board, 6, 4));
    }

    @Test
    public void testInvalidMove() {
        assertFalse(whiteKnight.move(board, 3, 3));
    }
}