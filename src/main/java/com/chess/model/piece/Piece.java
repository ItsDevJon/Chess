package com.chess.model.piece;

import com.chess.model.Board;
import com.chess.model.Position;
import lombok.Getter;
import lombok.Setter;

import javax.swing.ImageIcon;

@Getter
@Setter
public abstract class Piece {

    private final PieceType pieceType;
    private final PieceColor pieceColor;
    private final ImageIcon image;
    private Position posOnBoard;

    protected Piece(PieceType type, PieceColor pieceColor) {
        this.pieceType = type;
        this.pieceColor = pieceColor;
        this.image = pieceType.getImage(pieceColor);
    }

    public boolean isValidMove(Position fromPos, Position toPos, Board board){

        if(fromPos.equals(toPos)) return false;

        Piece targetPiece = board.getPiece(toPos);
        if (targetPiece != null){

            if (this.pieceType == PieceType.PAWN) return false; // A pawn cannot move if there is a piece in front of it
            if (targetPiece.getPieceColor() == this.pieceColor) return false;

        }

        return pieceType.getMovementStrategy().isValidMove(fromPos, toPos, board);

    }

}
