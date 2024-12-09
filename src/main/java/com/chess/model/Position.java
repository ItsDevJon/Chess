package com.chess.model;

import com.chess.utils.ColorPalette;

import java.awt.Color;

public record Position(int row, int col) {

    public Position {
        if (!isWithinBounds(row, col)) {
            throw new IllegalArgumentException("Position is out of bounds");
        }
    }

    private static boolean isWithinBounds(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public static Position of(int row, int col) {
        return new Position(row, col);
    }

    public Position add(int row, int col) {
        return Position.of(this.row + row, this.col + col);
    }

    public Position add(Position other) {
        return add(other.row, other.col);
    }

    public Position step(Position other) {
        int rowStep = Integer.compare(other.row, this.row);
        int colStep = Integer.compare(other.col, this.col);

        return Position.of(this.row + rowStep, this.col + colStep);
    }

    public int distance(Position other) {
        return Math.max(Math.abs(this.row - other.row), Math.abs(this.col - other.col));
    }

    public double euclideanDistanceTo(Position other) {
        double a = (double)this.row - other.row;
        double b = (double)this.col - other.col;

        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public boolean isAdjacent(Position other) {
        return distance(other) == 1;
    }

    public boolean isSameRow(Position other) {
        return this.row == other.row;
    }

    public boolean isSameColumn(Position other) {
        return this.col == other.col;
    }

    public boolean isStraightLine(Position other) {
        return isSameRow(other) || isSameColumn(other);
    }

    public boolean isDiagonal(Position other) {
        return Math.abs(this.row - other.row) == Math.abs(this.col - other.col);
    }

    public boolean isWhiteSquare() {
        return (row + col) % 2 == 0;
    }

    public Color getSquareColor() {
        return isWhiteSquare() ? ColorPalette.COLOR_SQUARE_WHITE : ColorPalette.COLOR_SQUARE_BLACK;
    }

}