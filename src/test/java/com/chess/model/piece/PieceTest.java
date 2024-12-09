package com.chess.model.piece;

import com.chess.model.Board;
import com.chess.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PieceTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void isValidMove_SamePosition_ReturnsFalse() {

        Position whitePawnPos = Position.of(6, 1);
        Pawn whitePawn = new Pawn(PieceColor.WHITE);

        assertFalse(whitePawn.isValidMove(whitePawnPos, whitePawnPos, board));

    }

    @Test
    void isValidMove_SamePieceColor_ReturnsFalse() {

        Position rook1Pos = Position.of(6, 0);
        Position rook2Pos = Position.of(4, 0);

        Rook rook1 = new Rook(PieceColor.WHITE);
        Rook rook2 = new Rook(PieceColor.WHITE);

        board.placePiece(rook1Pos, rook1);
        board.placePiece(rook2Pos, rook2);

        assertFalse(rook1.isValidMove(rook1Pos, rook2Pos, board));

    }

    @Test
    void isValidMove_OppositePieceColor_ReturnsTrue() {

        Position rook1Pos = Position.of(6, 0);
        Position rook2Pos = Position.of(4, 0);

        Rook rook1 = new Rook(PieceColor.WHITE);
        Rook rook2 = new Rook(PieceColor.BLACK);

        board.placePiece(rook1Pos, rook1);
        board.placePiece(rook2Pos, rook2);

        assertTrue(rook1.isValidMove(rook1Pos, rook2Pos, board));

    }

    // This is related to the previous 2 tests
    // A pawn should not be able to move if there is a piece of any color in front of it
    @Test
    void isValidMove_InvalidPawnMove_ReturnsFalse() {

        Position toPos = Position.of(5, 1);
        Position whitePawnPos = Position.of(6, 1);

        Pawn whitePawn = new Pawn(PieceColor.WHITE);

        board.placePiece(whitePawnPos, whitePawn);
        board.placePiece(toPos, new Pawn(PieceColor.WHITE));

        assertFalse(whitePawn.isValidMove(whitePawnPos, toPos, board));

    }

    @Test
    void isValidMove_EmptyDestination_ReturnsTrue() {

        Piece whitePawn = new Pawn(PieceColor.WHITE);
        Position whitePawnPos = Position.of(6, 1);
        Position emptyPos = Position.of(5, 1);

        board.placePiece(whitePawnPos, whitePawn);

        assertTrue(whitePawn.isValidMove(whitePawnPos, emptyPos, board));

    }

}