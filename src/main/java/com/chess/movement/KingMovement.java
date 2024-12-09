package com.chess.movement;

import com.chess.model.Board;
import com.chess.model.Position;

public class KingMovement implements MovementStrategy {

    @Override
    public boolean isValidMove(Position fromPos, Position toPos, Board board) {
        return fromPos.isAdjacent(toPos);
    }

}
