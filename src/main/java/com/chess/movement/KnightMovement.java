package com.chess.movement;

import com.chess.model.Board;
import com.chess.model.Position;

public class KnightMovement implements MovementStrategy {

    @Override
    public boolean isValidMove(Position fromPos, Position toPos, Board board) {
        return isLShaped(fromPos, toPos);
    }

    public boolean isLShaped(Position fromPos, Position toPos) {
        // Using the Pythagorean theorem to check if the knight is moving in an L shape
        return fromPos.euclideanDistanceTo(toPos) == Math.sqrt(5);
    }

}
