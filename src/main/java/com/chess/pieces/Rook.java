package com.chess.pieces;

import com.chess.Board;

public class Rook extends Piece{

    public Rook(COLOR color, int y, int x) {
        super(TYPE.ROOK, color, y, x);
    }

    @Override
    public boolean move(Board board, int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    
}
