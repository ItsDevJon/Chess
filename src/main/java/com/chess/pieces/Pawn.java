package com.chess.pieces;

import com.chess.Board;
import com.chess.GamePanel;

public class Pawn extends Piece{
    boolean firstMove = true;

    public Pawn(COLOR color, int x, int y) {
        super(TYPE.PAWN, color, y, x);
    }

    
    @Override
    public boolean move(Board board, int xTo, int yTo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

    private void calculateColAndRow(int direction) {

        col = ((this.y / GamePanel.tileSize) + direction);
        row = (this.x / GamePanel.tileSize);
    }

    private boolean movePawnForward(Board board, int xTo, int yTo, int direction){
        return true;
    }
    
}



