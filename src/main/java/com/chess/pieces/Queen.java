package com.chess.pieces;

import com.chess.Board;

public class Queen extends Piece{

    public Queen(COLOR color, int y, int x) {
        super(TYPE.QUEEN, color, y, x);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean move(Board board, int xTo, int yTo){
        // TODO Auto-generated method stub
        boolean returnValue = false;
        switch (getElectedCords(xTo, yTo)) {
            case SW, SE, NE, NW:
            returnValue=moveDiagonal(board, xTo, yTo);
                break;
            case S, E, N, W:
            returnValue=moveCross(board, xTo, yTo);
                break;
            default:
                return returnValue;
        }
        return returnValue;
    }
    }


    
}
