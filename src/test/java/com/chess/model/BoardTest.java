package com.chess.model;

import com.chess.model.piece.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private final Position pawnPosition = Position.of(1, 2);
    private final Position bishopPosition = Position.of(1, 6);
    private final Position queenPosition = Position.of(2, 5);
    private final Position rookPosition = Position.of(4, 2);
    private final Position noPiecePosition = Position.of(0, 0);
    private final Position whiteQueenPosition = Position.of(6, 2);

    @BeforeEach
    void setUp() {

        /*
          Chessboard used for testing:

              0   1   2   3   4   5   6   7
            +---+---+---+---+---+---+---+---+
          0 |   |   |   |   |   |   |   |   | 8     Legend:
            +---+---+---+---+---+---+---+---+          p - Pawn
          1 |   |   | p |   |   |   | b |   | 7        b - Bishop
            +---+---+---+---+---+---+---+---+          q - Queen
          2 |   |   |   |   |   | q |   |   | 6        r - Rook
            +---+---+---+---+---+---+---+---+          lowercase - Black
          3 |   |   |   |   |   |   |   |   | 5        uppercase - White
            +---+---+---+---+---+---+---+---+
          4 |   |   | r |   |   |   |   |   | 4
            +---+---+---+---+---+---+---+---+
          5 |   |   |   |   |   |   |   |   | 3
            +---+---+---+---+---+---+---+---+
          6 |   |   |   |   |   |   |   |   | 2
            +---+---+---+---+---+---+---+---+
          7 |   |   |   |   |   |   |   |   | 1
            +---+---+---+---+---+---+---+---+
              0   1   2   3   4   5   6   7

        */

        board = new Board();
        board.placePiece(pawnPosition, new Pawn(PieceColor.BLACK));
        board.placePiece(bishopPosition, new Bishop(PieceColor.BLACK));
        board.placePiece(queenPosition, new Queen(PieceColor.BLACK));
        board.placePiece(rookPosition.row(), rookPosition.col(), new Rook(PieceColor.BLACK));

        board.placePiece(whiteQueenPosition, new Queen(PieceColor.WHITE));

    }

    @Test
    void placePieces_PiecesPlaced() {

        board.placePieces();

        assertNotNull(board.getPiece(Position.of(7, 5)));

    }

    @Test
    void movePiece_ValidMove_PieceMoved() {

        Position end = Position.of(3, 2);

        board.movePiece(pawnPosition, end);

        assertNull(board.getPiece(pawnPosition));
        assertNotNull(board.getPiece(end));

    }

    @Test
    void movePiece_NoPiece_PieceNotMoved() {

        Position end = Position.of(1, 0);

        board.movePiece(noPiecePosition, end);

        assertNull(board.getPiece(noPiecePosition));
        assertNull(board.getPiece(end));

    }

    @Test
    void movePiece_PieceOnTheWay_PieceNotMoved() {

        Position end = Position.of(0, 2);

        board.movePiece(rookPosition, end);

        assertFalse(board.isPathClear(rookPosition, end));
        assertNotNull(board.getPiece(rookPosition));
        assertNull(board.getPiece(end));

    }

    @Test
    void movePiece_InvalidMove_PieceNotMoved() {

        board.movePiece(bishopPosition, queenPosition);

        assertNotNull(board.getPiece(bishopPosition));
        assertNotNull(board.getPiece(queenPosition));

    }

    @Test
    void movePiece_SamePosition_PieceNotMoved() {

        board.movePiece(pawnPosition, pawnPosition);

        assertNotNull(board.getPiece(pawnPosition));

    }

    @Test
    void movePiece_EnemyPiece_PieceMoved() {

        board.movePiece(rookPosition, whiteQueenPosition);

        assertNull(board.getPiece(rookPosition));
        assertNotNull(board.getPiece(whiteQueenPosition));

    }

    @Test
    void findPiece_RookQueen_PieceIsNull() {

        assertNull(board.findPiece(PieceType.ROOK, PieceColor.WHITE).orElse(null));

    }

    @Test
    void findPiece_BlackPawn_PieceIsNotNull() {

        assertNotNull(board.findPiece(PieceType.PAWN, PieceColor.BLACK).orElse(null));

    }

    @Test
    void addPropertyChangeListener_listener_PropertyChangeSupportIsNotNull() {
        
        PropertyChangeListener listener = evt -> {};
        board.addPropertyChangeListener(listener);

        assertNotNull(board.getPcs());

    }
    
}