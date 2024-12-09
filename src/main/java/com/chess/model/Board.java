package com.chess.model;

import com.chess.model.piece.Bishop;
import com.chess.model.piece.King;
import com.chess.model.piece.Knight;
import com.chess.model.piece.Pawn;
import com.chess.model.piece.Piece;
import com.chess.model.piece.PieceColor;
import com.chess.model.piece.PieceType;
import com.chess.model.piece.Queen;
import com.chess.model.piece.Rook;
import com.chess.utils.Grid;
import lombok.Getter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

@Getter
public class Board {

    private static final Logger LOGGER = Logger.getLogger(Board.class.getName());

    private Grid<Piece> pieceGrid;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Board() {
        pieceGrid = new Grid<>(8, 8, null);
    }

    public void placePieces(){

        for (PieceColor color : PieceColor.values()) {

            int pawnRow = color.getPawnStartingRow();
            int pieceRow = color.getPieceStartingRow();

            List<Piece> pieces = List.of(
                new Rook(color),
                new Knight(color),
                new Bishop(color),
                new King(color),
                new Queen(color),
                new Bishop(color),
                new Knight(color),
                new Rook(color)
            );

            // Place pieces
            IntStream.range(0, 8).forEach(col -> placePiece(pieceRow, 7 - col, pieces.get(col)));

            // Place pawns
            IntStream.range(0, 8).forEach(col -> placePiece(pawnRow, col, new Pawn(color)));

        }

    }

    public void placePiece(int row, int col, Piece piece) {
        Position position = Position.of(row, col);
        piece.setPosOnBoard(position);
        placePiece(position, piece);
    }

    public void placePiece(Position position, Piece piece) {
        pieceGrid.set(position, piece);
    }

    public void movePiece(Position fromPos, Position toPos) {

        Piece piece = pieceGrid.get(fromPos);

        if (piece != null && piece.isValidMove(fromPos, toPos, this)) {

            piece.setPosOnBoard(toPos);
            pieceGrid.set(toPos, piece);
            pieceGrid.set(fromPos, null);

            pcs.firePropertyChange("board", null, pieceGrid);
        }
        else {
            String message = fromPos + " -> " + toPos;
            LOGGER.log(Level.WARNING, "Invalid move! {0}", message);
        }

    }

    public boolean isPathClear(Position fromPos, Position toPos) {

        // Walk through the path step by step and check if the path is clear, i.e. no pieces are blocking the path
        Position currentPos = fromPos.step(toPos);
        while (!currentPos.equals(toPos)) {

            if (getPiece(currentPos) != null) {
                return false;
            }

            currentPos = currentPos.step(toPos);

        }

        return true;

    }

    public Piece getPiece(Position position) {
        return pieceGrid.get(position);
    }

    public Optional<Piece> findPiece(PieceType type, PieceColor color) {
        return pieceGrid.getElements().stream()
                .flatMap(List::stream)
                .filter(piece -> piece != null && piece.getPieceType() == type && piece.getPieceColor() == color)
                .findFirst();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

}