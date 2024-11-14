package com.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.chess.Board;
import com.chess.GamePanel;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testInvalidMove() {
        assertFalse(whiteKnight.move(board, 3, 3));
    }

    @Test
    public void testNotPermitedMove(){
        assertFalse(whiteKnight.verifyAndMovePiece(board, 2, 2, 2, 2, false, true));
    }
}