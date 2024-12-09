package com.chess.movement;

import com.chess.model.Board;
import com.chess.model.Position;

public class QueenMovement implements MovementStrategy {

    @Override
    public boolean isValidMove(Position fromPos, Position toPos, Board board) {

        return ( fromPos.isStraightLine(toPos) || fromPos.isDiagonal(toPos) ) && board.isPathClear(fromPos, toPos); // Check if any pieces are blocking the path

    }

}
