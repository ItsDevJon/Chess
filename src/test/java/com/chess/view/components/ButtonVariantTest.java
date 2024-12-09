package com.chess.view.components;

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static com.chess.utils.ColorPalette.*;
import static org.junit.jupiter.api.Assertions.*;

class ButtonVariantTest {

    @Test
    void enumConstants_InitializedWithCorrectValues() {
        // Assert: Validate PRIMARY_TEXT
        assertAll(
                () -> assertEquals(Color.BLACK, ButtonVariant.PRIMARY_TEXT.getBackgroundColor(), "Incorrect background color for PRIMARY_TEXT"),
                () -> assertEquals(Color.WHITE, ButtonVariant.PRIMARY_TEXT.getForegroundColor(), "Incorrect foreground color for PRIMARY_TEXT"),
                () -> assertEquals(0, ButtonVariant.PRIMARY_TEXT.getBorderRadius(), "Incorrect border radius for PRIMARY_TEXT"),
                () -> assertEquals(Padding.MEDIUM, ButtonVariant.PRIMARY_TEXT.getPadding(), "Incorrect padding for PRIMARY_TEXT"),
                () -> assertNull(ButtonVariant.PRIMARY_TEXT.getFont(), "Font should be null for PRIMARY_TEXT")
        );

        // Assert: Validate SQUARE_WHITE
        assertAll(
                () -> assertEquals(COLOR_SQUARE_WHITE, ButtonVariant.SQUARE_WHITE.getBackgroundColor(), "Incorrect background color for SQUARE_WHITE"),
                () -> assertEquals(COLOR_SQUARE_BLACK, ButtonVariant.SQUARE_WHITE.getForegroundColor(), "Incorrect foreground color for SQUARE_WHITE"),
                () -> assertEquals(0, ButtonVariant.SQUARE_WHITE.getBorderRadius(), "Incorrect border radius for SQUARE_WHITE"),
                () -> assertEquals(Padding.NONE, ButtonVariant.SQUARE_WHITE.getPadding(), "Padding should be null for SQUARE_WHITE"),
                () -> assertNull(ButtonVariant.SQUARE_WHITE.getFont(), "Font should be null for SQUARE_WHITE")
        );

        // Assert: Validate SQUARE_BLACK
        assertAll(
                () -> assertEquals(COLOR_SQUARE_BLACK, ButtonVariant.SQUARE_BLACK.getBackgroundColor(), "Incorrect background color for SQUARE_BLACK"),
                () -> assertEquals(COLOR_SQUARE_WHITE, ButtonVariant.SQUARE_BLACK.getForegroundColor(), "Incorrect foreground color for SQUARE_BLACK"),
                () -> assertEquals(0, ButtonVariant.SQUARE_BLACK.getBorderRadius(), "Incorrect border radius for SQUARE_BLACK"),
                () -> assertEquals(Padding.NONE, ButtonVariant.SQUARE_BLACK.getPadding(), "Padding should be null for SQUARE_WHITE"),
                () -> assertNull(ButtonVariant.SQUARE_BLACK.getFont(), "Font should be null for SQUARE_BLACK")
        );
    }

}