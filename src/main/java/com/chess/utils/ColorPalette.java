package com.chess.utils;

import java.awt.Color;

public class ColorPalette {

    // SYSTEM
    public static final Color BLACK             = Color.BLACK;                      // A pure black
    public static final Color WHITE             = Color.WHITE;                      // A pure white
    public static final Color FOG_WHITE         = Color.decode("#F4F7FA");      // A light, neutral gray
    public static final Color PURPLE            = Color.decode("#7B61FF");      // A vibrant purple
    public static final Color PALE_PURPLE       = Color.decode("#D7D0FF");      // A soft, pastel purple
    public static final Color SOFT_BLUE         = Color.decode("#E8EDF9");      // A pale, soothing blue
    public static final Color CLOUDY_BLUE       = Color.decode("#B7C0D8");      // A light, muted blue
    public static final Color MIDNIGHT_BLUE     = Color.decode("#34364C");      // A dark, rich blue
    public static final Color LIGHT_GREY        = Color.decode("#D4D2D2");      // A light grey
    public static final Color MEDIUM_GREY       = Color.decode("#484848");      // A medium-dark grey
    public static final Color MIDNIGHT_GREY     = Color.decode("#303030");      // A dark, rich grey
    public static final Color DARK_GREY         = Color.decode("#3D3D3D");      // A dark grey

    // REFERENCE
    public static final Color COLOR_TEXT_PRIMARY           = WHITE;
    public static final Color COLOR_TEXT_SECONDARY         = LIGHT_GREY;

    public static final Color COLOR_BACKGROUND_PRIMARY     = DARK_GREY;
    public static final Color COLOR_BACKGROUND_SECONDARY   = MIDNIGHT_GREY;
    public static final Color COLOR_BACKGROUND_TERTIARY    = MEDIUM_GREY;

    public static final Color COLOR_ACCENT_PRIMARY         = PURPLE;
    public static final Color COLOR_ACCENT_SECONDARY       = PALE_PURPLE;

    // APPLICATION
    public static final Color COLOR_SQUARE_WHITE           = SOFT_BLUE;
    public static final Color COLOR_SQUARE_BLACK           = CLOUDY_BLUE;
    public static final Color COLOR_SQUARE_ACTIVE          = COLOR_ACCENT_PRIMARY;

    public static final Color COLOR_PIECE_WHITE            = FOG_WHITE;
    public static final Color COLOR_PIECE_BLACK            = MIDNIGHT_BLUE;


    private ColorPalette() {}

}
