package com.chess.view.components;

import lombok.Getter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import static com.chess.utils.ColorPalette.*;

@Getter
public enum ButtonVariant {
    PRIMARY_TEXT    (BLACK, WHITE, 0, Padding.MEDIUM, null),
    SQUARE_WHITE    (COLOR_SQUARE_WHITE, COLOR_SQUARE_BLACK, 0, Padding.NONE, null),
    SQUARE_BLACK    (COLOR_SQUARE_BLACK, COLOR_SQUARE_WHITE, 0, Padding.NONE, null);

    private final int borderRadius;
    private final Font font;
    private final Padding padding;
    private final Color backgroundColor;
    private final Color foregroundColor;

    ButtonVariant(Color backgroundColor, Color foregroundColor, int borderRadius, Padding padding, Font font) {
        this.font = font;
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        this.padding = padding;
        this.borderRadius = borderRadius;
    }

    public void applyStyle(GameButton button) {

        button.setFont(font);
        button.setOpaque(true);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBackground(backgroundColor);
        button.setForeground(foregroundColor);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        padding.applyPadding(button);

    }

}
