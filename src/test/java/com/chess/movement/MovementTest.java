package com.chess.movement;

import com.chess.model.Board;
import com.chess.model.Position;
import com.chess.model.piece.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class MovementTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testBishopMovement() {

        Piece piece = new Bishop(PieceColor.WHITE);

        Position fromPos            = Position.of(3, 3);
        Position toValidPos         = Position.of(6, 6);
        Position toInvalidPos       = Position.of(3, 6);
        Position toOccupiedPos      = Position.of(2, 2);
        Position toBlockedPathPos   = Position.of(1, 1);

        board.placePiece(fromPos, piece);
        board.placePiece(toOccupiedPos, new Knight(PieceColor.WHITE));

        assertTrue(piece.isValidMove(fromPos, toValidPos, board));
        assertFalse(piece.isValidMove(fromPos, toInvalidPos, board));
        assertFalse(piece.isValidMove(fromPos, toOccupiedPos, board));
        assertFalse(piece.isValidMove(fromPos, toBlockedPathPos, board));

    }

    @Test
    void testKingMovement() {

        Piece piece = new King(PieceColor.WHITE);

        Position fromPos        = Position.of(3, 3);
        Position toValidPos     = Position.of(3, 4);
        Position toInvalidPos   = Position.of(3, 6);

        board.placePiece(fromPos, piece);

        assertTrue(piece.isValidMove(fromPos, toValidPos, board));
        assertFalse(piece.isValidMove(fromPos, toInvalidPos, board));

    }

    @Test
    void testKnightMovement() {

        Piece piece = new Knight(PieceColor.WHITE);

        Position fromPos = new Position(3, 3);
        Position toValidPos = new Position(5, 4);
        Position toInvalidPos = new Position(3, 6);

        board.placePiece(fromPos, piece);

        assertTrue(piece.isValidMove(fromPos, toValidPos, board));
        assertFalse(piece.isValidMove(fromPos, toInvalidPos, board));

    }

    @Test
    void testQueenMovement() {

        Piece piece = new Queen(PieceColor.WHITE);

        Position fromPos = new Position(3, 3);
        Position occupiedPos = new Position(2, 2);
        Position toValidPos = new Position(3, 6);
        Position toValidDiagonalPos = new Position(6, 6);
        Position toInvalidPos = new Position(4, 7);
        Position toBlockedPathPos = new Position(1, 1);

        board.placePiece(fromPos, piece);
        board.placePiece(occupiedPos, new Bishop(PieceColor.WHITE));

        // Test straight line movement
        assertTrue(piece.isValidMove(fromPos, toValidPos, board));
        assertFalse(piece.isValidMove(fromPos, toInvalidPos, board));

        // Test diagonal movement
        assertTrue(piece.isValidMove(fromPos, toValidDiagonalPos, board));

        // Test blocked path
        assertFalse(piece.isValidMove(fromPos, toBlockedPathPos, board));

    }

    @Test
    void testRookMovement() {

        Piece piece = new Rook(PieceColor.WHITE);

        Position fromPos = new Position(3, 3);
        Position toValidPos = new Position(3, 6);
        Position toInvalidPos = new Position(4, 7);

        board.placePiece(fromPos, piece);

        assertTrue(piece.isValidMove(fromPos, toValidPos, board));
        assertFalse(piece.isValidMove(fromPos, toInvalidPos, board));

    }

    @ParameterizedTest
    @EnumSource(PieceColor.class)
    void testPawnMovement(PieceColor color) {

        Piece piece = new Pawn(color);

        // Pawn movement variables
        int startCol = 4;
        int startRow = color.getPawnStartingRow();  // White's startRow is 6, Black's startRow is 1
        int direction = color.getDirection();       // White moves up (-1), Black moves down (+1)

        // Piece positions                                                                  White  | Black
        Position initialPos     = Position.of(startRow, startCol);                       // (6, 4) | (1, 4)
        Position oneStepPos     = initialPos.add(direction, 0);                      // (5, 4) | (2, 4)
        Position twoStepsPos    = initialPos.add(2 * direction, 0);             // (4, 4) | (3, 4)
        Position invalidPos     = Position.of(6, 5);                            // (6, 5) | (6, 5)
        Position otherPiecePos  = oneStepPos;

        // Place pieces on the board
        board.placePiece(initialPos, piece);
        board.placePiece(otherPiecePos, new Pawn(color.getOpposite()));


        // INVALID CASES

        // Attempting to move to an invalid position
        assertFalse(piece.isValidMove(initialPos, invalidPos, board));

        // Attempting to move one square forward but a piece blocks the way
        assertFalse(piece.isValidMove(initialPos, otherPiecePos, board));

        // Attempting to move two squares forward but the path is not clear
        assertFalse(piece.isValidMove(initialPos, twoStepsPos, board));

        // Attempting to move two squares when it's not the first move
        board.movePiece(initialPos, oneStepPos);
        assertFalse(piece.isValidMove(oneStepPos, twoStepsPos, board));

        // Reset piece position
        resetPiecePos(piece, oneStepPos, initialPos);

        // Remove piece at otherPiecePos
        board.placePiece(otherPiecePos, null);


        // VALID CASES

        // Moving one square forward to an empty square
        assertTrue(piece.isValidMove(initialPos, oneStepPos, board));

        // Moving two squares forward from the initial position
        assertTrue(piece.isValidMove(initialPos, twoStepsPos, board));

    }

    void resetPiecePos(Piece piece, Position currentPos, Position newPos) {
        board.placePiece(currentPos, null);
        board.placePiece(newPos, piece);
    }

}