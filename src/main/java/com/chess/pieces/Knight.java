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
        // TODO Auto-generated method stub
        boolean returnValue = false;

        switch (getElectedCords(xTo, yTo)) {
            case A:
                returnValue = verifyMove(board, xTo, yTo, 2, 1, 1, 2);
                break;
            case B:
                returnValue = verifyMove(board, xTo, yTo, 2, -1, 1, -2);
                break;
            case C:
                returnValue = verifyMove(board, xTo, yTo, -2, 1, -1, 2);
                break;
            case D:
                returnValue = verifyMove(board, xTo, yTo, -2, -1, -1, -2);
                break;
            default:
                break;                
        }
        return returnValue;

    }

    private boolean verifyMove(Board board, int xTo, int yTo, int col1, int row1, int col2, int row2) {
        
        int knightCol = (this.y / GamePanel.tileSize);
        int knightRow = (this.x / GamePanel.tileSize);
        int knightIndex = (knightCol * Board.width + knightRow);
        int wantedMove = (yTo * Board.width + xTo);
        int knightPossibleMove1;
        int knightPossibleMove2;
        knightPossibleMove1 = (knightCol + col1) * Board.width + (knightRow + row1);
        knightPossibleMove2 = (knightCol + col2) * Board.width + (knightRow + row2);
        if (knightPossibleMove1 == wantedMove) {
            return canMove(board, knightIndex, knightPossibleMove1);
        } else if (knightPossibleMove2 == wantedMove) {
            return canMove(board, knightIndex, knightPossibleMove2);
        }
        
        return false;
    }
    
}
