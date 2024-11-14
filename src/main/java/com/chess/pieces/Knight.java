package com.chess.pieces;

import com.chess.Board;

public class Knight extends Piece {

    public Knight(COLOR color, int y, int x) {
        super(TYPE.KNIGHT, color, y, x);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean move(Board board, int xTo, int yTo) {
        // Define possible knight moves: (xOffset, yOffset)
        int[][] knightMoves = {
            {-2, 1}, {-1, 2},  // SW
            {2, -1}, {1, -2},  // NE
            {2, 1}, {1, 2},    // SE
            {-2, -1}, {-1, -2} // NW
        };

        // Iterate over all possible knight moves
        for (int[] move : knightMoves) {
            if (verifyAndMovePiece(board, xTo, yTo, move[0], move[1], false, true)) {
                return true; // Valid move found
            }
        }
        
        // No valid move found
        return false;
    }
}
