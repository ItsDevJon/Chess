package com.chess.pieces;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import com.chess.Board;
import com.chess.GamePanel;

public class Knight extends Piece {


    public Knight(COLOR color, int y, int x) {
        super(TYPE.KNIGHT, color, y, x);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean move(Board board, int xTo, int yTo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
    

    
}
