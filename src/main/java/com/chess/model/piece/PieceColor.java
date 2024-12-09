package com.chess.model.piece;

import lombok.Getter;

@Getter
public enum PieceColor {
    WHITE(-1, 6, 7),
    BLACK(1, 1, 0);

    private final int direction;
    private final int pawnStartingRow;
    private final int pieceStartingRow;

    PieceColor(int direction, int pawnStartingRow, int pieceStartingRow) {
        this.direction = direction;
        this.pawnStartingRow = pawnStartingRow;
        this.pieceStartingRow = pieceStartingRow;
    }

    public PieceColor getOpposite() {
        return (this == WHITE) ? BLACK : WHITE;
    }

}
