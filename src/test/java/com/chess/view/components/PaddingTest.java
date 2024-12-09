package com.chess.view.components;

import org.junit.jupiter.api.Test;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Insets;

import static org.junit.jupiter.api.Assertions.*;

class PaddingTest {

    @Test
    void applyPadding_SMALL_ApplyCorrectPadding() {

        // Arrange
        Padding padding = Padding.SMALL;
        JComponent component = new JPanel();

        // Act
        padding.applyPadding(component);

        // Assert
        Insets actualInsets = component.getInsets();
        Insets expectedInsets = new Insets(
                padding.getTop(),
                padding.getLeft(),
                padding.getBottom(),
                padding.getRight()
        );

        assertEquals(expectedInsets.top, actualInsets.top, "Top padding mismatch");

    }

    @Test
    void applyPadding_nullComponent_DoesNotThrowException() {
        // Arrange
        Padding padding = Padding.SMALL;

        // Act
        padding.applyPadding(null);

        // Assert
        assertTrue(true, "No exception should be thrown");
    }

    @Test
    void enumConstants_InitializedWithCorrectValues() {
        // Assert
        assertAll(
                () -> assertEquals(6, Padding.SMALL.getTop(), "SMALL top value mismatch"),
                () -> assertEquals(6, Padding.SMALL.getLeft(), "SMALL left value mismatch"),
                () -> assertEquals(6, Padding.SMALL.getBottom(), "SMALL bottom value mismatch"),
                () -> assertEquals(6, Padding.SMALL.getRight(), "SMALL right value mismatch"),

                () -> assertEquals(8, Padding.MEDIUM.getTop(), "MEDIUM top value mismatch"),
                () -> assertEquals(16, Padding.MEDIUM.getLeft(), "MEDIUM left value mismatch"),
                () -> assertEquals(8, Padding.MEDIUM.getBottom(), "MEDIUM bottom value mismatch"),
                () -> assertEquals(16, Padding.MEDIUM.getRight(), "MEDIUM right value mismatch"),

                () -> assertEquals(12, Padding.LARGE.getTop(), "LARGE top value mismatch"),
                () -> assertEquals(24, Padding.LARGE.getLeft(), "LARGE left value mismatch"),
                () -> assertEquals(12, Padding.LARGE.getBottom(), "LARGE bottom value mismatch"),
                () -> assertEquals(24, Padding.LARGE.getRight(), "LARGE right value mismatch")
        );
    }

}