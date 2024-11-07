package com.chess.pieces;

import com.chess.Board;
import com.chess.GamePanel;

public class Knight extends Piece {

    public Knight(COLOR color, int y, int x) {
        super(TYPE.KNIGHT, color, y, x);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean move(Board board, int xTo, int yTo) {
        boolean returnValue = false;

        switch (getElectedCords(xTo, yTo)) {
            case SW:
                returnValue = verifyAndMovePiece(board, xTo, yTo, -2, 1, false, true);
                if (returnValue)
                    return true;
                returnValue = verifyAndMovePiece(board, xTo, yTo, -1, 2, false, true);
                break;
            case NE:
                returnValue = verifyAndMovePiece(board, xTo, yTo, 2, -1, false, true);
                if (returnValue)
                    return true;
                returnValue = verifyAndMovePiece(board, xTo, yTo, 1, -2, false, true);
                break;
            case SE:
                returnValue = verifyAndMovePiece(board, xTo, yTo, 2, 1, false, true);
                if (returnValue)
                    return true;
                returnValue = verifyAndMovePiece(board, xTo, yTo, 1, 2, false, true);
                break;
            case NW:
                returnValue = verifyAndMovePiece(board, xTo, yTo, -2, -1, false, true);
                if (returnValue)
                    return true;
                returnValue = verifyAndMovePiece(board, xTo, yTo, -1, -2, false, true);
                break;
            default:
                return returnValue;
        }
        return returnValue;
    }
}
