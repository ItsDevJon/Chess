package com.chess.pieces;

import com.chess.Board;

public class Bishop extends Piece{

    public Bishop(COLOR color, int y, int x) {
        super(TYPE.BISHOP, color, y, x);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean move(Board board, int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    
}
