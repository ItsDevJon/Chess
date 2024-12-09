package com.chess.utils;

import com.chess.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {

    private Position position;
    private Grid<String> grid;

    @BeforeEach
    void setUp() {
        position = Position.of(1, 1); // Create a position at row 1, col 1
        grid = new Grid<>(3, 3, "default"); // Create a 3x3 grid with default value "default"
    }

    @Test
    void testGridInitialization() {

        // Ensure the grid is initialized correctly with default values
        assertEquals(3, grid.getRows());
        assertEquals(3, grid.getCols());

        grid.getElements().forEach(
                row -> row.forEach(
                        value -> assertEquals("default", value)
                )
        );

    }

    @Test
    void testAccessors() {
        // Ensure we can set an element at a given position
        grid.set(position, "Updated with position");
        grid.set(0, 0, "Updated with row and col");
        assertEquals("Updated with position", grid.get(position));
        assertEquals("Updated with row and col", grid.get(0, 0));
    }

    @Test
    void testForEach() {
        // Use forEach to update values and validate
        grid.forEach((position, value) -> {
            String newValue = "value-" + position.row() + "-" + position.col();
            grid.set(position, newValue);
        });

        // Verify all values are updated as expected
        grid.forEach((position, value) ->
                assertEquals("value-" + position.row() + "-" + position.col(), value)
        );
    }

}