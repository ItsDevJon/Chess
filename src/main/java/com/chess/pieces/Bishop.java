package com.chess.pieces;

import com.chess.Board;

public class Bishop extends Piece{

    public Bishop(COLOR color, int y, int x) {
        super(TYPE.BISHOP, color, y, x);
    }

    @Override
    public boolean move(Board board, int xTo, int yTo) {
        boolean returnValue = false;
        switch (getElectedCords(xTo, yTo)) {
            case SW:
            case SE:
            case NE:
            case NW:
            returnValue=moveDiagonal(board, xTo, yTo);
                break;
            default:
                return returnValue;
        }
        return returnValue;    }
    
}
