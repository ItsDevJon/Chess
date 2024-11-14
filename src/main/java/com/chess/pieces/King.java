package com.chess.pieces;

import com.chess.Board;

public class King extends Piece{

    public King(COLOR color, int y, int x) {
        super(TYPE.KING, color, y, x);
    }

    @Override
    public boolean move(Board board, int xTo, int yTo) {
        boolean returnValue = false;
        switch (getElectedCords(xTo, yTo)) {
            case SW:
                returnValue = verifyAndMovePiece(board, xTo, yTo, -1, 1, false, true);
                break;
            case S:
                returnValue = verifyAndMovePiece(board, xTo, yTo, 0, 1, false, true);
                break;
            case SE:
                returnValue = verifyAndMovePiece(board, xTo, yTo, 1, 1, false, true);
                break;
            case E:
                returnValue = verifyAndMovePiece(board, xTo, yTo, 1, 0, false, true);
                break;
            case NE:
                returnValue = verifyAndMovePiece(board, xTo, yTo, 1, -1, false, true);
                break;
            case N:
                returnValue = verifyAndMovePiece(board, xTo, yTo, 0, -1, false, true);
                break;
            case NW:
                returnValue = verifyAndMovePiece(board, xTo, yTo, -1, -1, false, true);
                break;
            case W:
                returnValue = verifyAndMovePiece(board, xTo, yTo, -1, 0, false, true);
                break;
            default:
                return returnValue;
        }

        return returnValue;
    }
}
