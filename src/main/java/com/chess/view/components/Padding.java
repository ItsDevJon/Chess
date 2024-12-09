package com.chess.view.components;

import lombok.Getter;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

@Getter
public enum Padding {
    NONE(0, 0, 0, 0),
    SMALL(6, 6, 6, 6),
    MEDIUM(8, 16, 8, 16),
    LARGE(12, 24, 12, 24);

    private final int top;
    private final int left;
    private final int bottom;
    private final int right;

    Padding(int top, int left, int bottom, int right) {
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
    }

    public void applyPadding(JComponent component) {
        if (component == null) return;

        component.setBorder(
                BorderFactory.createEmptyBorder(
                        top,
                        left,
                        bottom,
                        right
                )
        );
    }

}
