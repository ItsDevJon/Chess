package com.chess.movement;

import com.chess.model.Board;
import com.chess.model.Position;

public interface MovementStrategy {

    /**
     * Checks if the move is valid based on the movement rules.
     *
     * @param fromPos    The starting position.
     * @param toPos      The target position.
     * @param board   The chess board.
     * @return true if the move is valid, false otherwise.
     */

    boolean isValidMove(Position fromPos, Position toPos, Board board);

}
