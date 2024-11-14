package com.chess.pieces;

import com.chess.Board;

public class Rook extends Piece{

    public Rook(COLOR color, int y, int x) {
        super(TYPE.ROOK, color, y, x);
    }

    @Override
    public boolean move(Board board, int xTo, int yTo) {
        boolean returnValue = false;
        switch (getElectedCords(xTo, yTo)) {
            case S:
            case E:
            case N:
            case W:
            returnValue=moveCross(board, xTo, yTo);
                break;
            default:
                return returnValue;
        }
        return returnValue;
    }

    
}
