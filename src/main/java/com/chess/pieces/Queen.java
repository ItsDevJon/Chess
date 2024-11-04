package com.chess.pieces;

import com.chess.Board;

public class Queen extends Piece{

    public Queen(COLOR color, int y, int x) {
        super(TYPE.QUEEN, color, y, x);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean move(Board board, int x, int y){
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }


    
}
