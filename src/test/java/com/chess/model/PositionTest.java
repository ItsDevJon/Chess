package com.chess.model;

import com.chess.utils.ColorPalette;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    private Position pos1;
    private Position pos2;

    @BeforeEach
    void setup() {
        pos1 = Position.of(3, 3);
        pos2 = Position.of(5, 5);
    }

    @Test
    void of_validRowAndCol_createsPosition() {
        Position pos = Position.of(3, 5);
        assertEquals(3, pos.row());
        assertEquals(5, pos.col());
    }

    @Test
    void of_outOfBoundsRowOrCol_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Position.of(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> Position.of(8, 0));
        assertThrows(IllegalArgumentException.class, () -> Position.of(0, -1));
        assertThrows(IllegalArgumentException.class, () -> Position.of(0, 8));
    }

    @Test
    void add_positionInstance_addsCorrectly() {
        Position result = pos1.add(Position.of(1, 1));
        assertEquals(Position.of(4, 4), result);
    }

    @Test
    void add_rowAndCol_addsCorrectly() {
        Position result = pos1.add(2, -3);
        assertEquals(Position.of(5, 0), result);
    }

    @Test
    void step_targetPosition_returnsNextStep() {
        Position step = pos1.step(pos2);
        assertEquals(Position.of(4, 4), step);
    }

    @Test
    void distance_targetPosition_returnsCorrectDistance() {
        assertEquals(2, pos1.distance(Position.of(3, 5))); // Max absolute difference (row: 3 -> 3, col: 3 -> 5)
    }

    @Test
    void euclideanDistanceTo_targetPosition_returnsCorrectDistance() {
        double expected = Math.sqrt(4 + 4); // √(2^2 + 2^2)
        assertEquals(expected, pos1.euclideanDistanceTo(pos2));
    }

    @Test
    void isAdjacent_adjacentPosition_returnsTrue() {
        Position adjacent = Position.of(3, 4);
        assertTrue(pos1.isAdjacent(adjacent));
    }

    @Test
    void isAdjacent_nonAdjacentPosition_returnsFalse() {
        assertFalse(pos1.isAdjacent(pos2));
    }

    @Test
    void isSameRow_sameRowPosition_returnsTrue() {
        Position sameRow = Position.of(3, 6);
        assertTrue(pos1.isSameRow(sameRow));
    }

    @Test
    void isSameRow_differentRowPosition_returnsFalse() {
        assertFalse(pos1.isSameRow(pos2));
    }

    @Test
    void isSameColumn_sameColumnPosition_returnsTrue() {
        Position sameCol = Position.of(6, 3);
        assertTrue(pos1.isSameColumn(sameCol));
    }

    @Test
    void isSameColumn_differentColumnPosition_returnsFalse() {
        assertFalse(pos1.isSameColumn(pos2));
    }

    @Test
    void isStraightLine_rowOrColumn_returnsTrue() {
        assertTrue(pos1.isStraightLine(Position.of(3, 7))); // Same row
        assertTrue(pos1.isStraightLine(Position.of(6, 3))); // Same column
    }

    @Test
    void isStraightLine_nonRowOrColumn_returnsFalse() {
        assertFalse(pos1.isStraightLine(Position.of(4, 5)));
    }

    @Test
    void isDiagonal_diagonalPosition_returnsTrue() {
        assertTrue(pos1.isDiagonal(pos2)); // Diagonal (x + 2, y + 2)
        assertTrue(pos1.isDiagonal(Position.of(1, 1))); // Diagonal (x - 2, y - 2)
    }

    @Test
    void isDiagonal_nonDiagonalPosition_returnsFalse() {
        assertFalse(pos1.isDiagonal(Position.of(3, 6)));
    }

    @Test
    void isWhiteSquare_whiteSquare_returnsTrue() {
        assertTrue(Position.of(0, 0).isWhiteSquare());
        assertTrue(Position.of(7, 7).isWhiteSquare());
    }

    @Test
    void isWhiteSquare_blackSquare_returnsFalse() {
        assertFalse(Position.of(0, 1).isWhiteSquare());
        assertFalse(Position.of(7, 6).isWhiteSquare());
    }

    @Test
    void getSquareColor_whiteSquare_returnsWhiteColor() {
        assertEquals(ColorPalette.COLOR_SQUARE_WHITE, Position.of(0, 0).getSquareColor());
    }

    @Test
    void getSquareColor_blackSquare_returnsBlackColor() {
        assertEquals(ColorPalette.COLOR_SQUARE_BLACK, Position.of(0, 1).getSquareColor());
    }
}
