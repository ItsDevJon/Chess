package com.chess.movement;

import com.chess.model.Board;
import com.chess.model.Position;
import com.chess.model.piece.Piece;
import com.chess.model.piece.PieceColor;

public class PawnMovement implements MovementStrategy{

    @Override
    public boolean isValidMove(Position fromPos, Position toPos, Board board) {

        Piece fromPiece = board.getPiece(fromPos);
        PieceColor pieceColor = fromPiece.getPieceColor();
        int direction = pieceColor.getDirection(); // White moves up, Black moves down

        Position oneStep = fromPos.add(direction, 0);
        Position twoSteps = fromPos.add(2 * direction, 0);

        return oneStep.equals(toPos) || isFirstMove(fromPos, pieceColor) && twoSteps.equals(toPos) && board.isPathClear(fromPos, toPos);

    }

    public boolean isFirstMove(Position fromPos, PieceColor pieceColor) {
        return fromPos.row() == pieceColor.getPawnStartingRow(); // White starts at row 6, Black starts at row 1
    }

}
