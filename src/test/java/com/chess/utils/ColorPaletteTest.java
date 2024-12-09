package com.chess.utils;

import org.junit.jupiter.api.Test;

import java.awt.Color;
import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

class ColorPaletteTest {

    @Test
    void testColorConstants() {
        // SYSTEM
        assertEquals(Color.BLACK, ColorPalette.BLACK);
        assertEquals(Color.WHITE, ColorPalette.WHITE);
        assertEquals(ColorPalette.FOG_WHITE,        Color.decode("#F4F7FA"));
        assertEquals(ColorPalette.PURPLE,           Color.decode("#7B61FF"));
        assertEquals(ColorPalette.PALE_PURPLE,      Color.decode("#D7D0FF"));
        assertEquals(ColorPalette.SOFT_BLUE,        Color.decode("#E8EDF9"));
        assertEquals(ColorPalette.CLOUDY_BLUE,      Color.decode("#B7C0D8"));
        assertEquals(ColorPalette.MIDNIGHT_BLUE,    Color.decode("#34364C"));
        assertEquals(ColorPalette.LIGHT_GREY,       Color.decode("#D4D2D2"));
        assertEquals(ColorPalette.MEDIUM_GREY,      Color.decode("#484848"));
        assertEquals(ColorPalette.MIDNIGHT_GREY,    Color.decode("#303030"));
        assertEquals(ColorPalette.DARK_GREY,        Color.decode("#3D3D3D"));

        // REFERENCE
        assertEquals(ColorPalette.WHITE, ColorPalette.COLOR_TEXT_PRIMARY);
        assertEquals(ColorPalette.LIGHT_GREY, ColorPalette.COLOR_TEXT_SECONDARY);

        assertEquals(ColorPalette.DARK_GREY, ColorPalette.COLOR_BACKGROUND_PRIMARY);
        assertEquals(ColorPalette.MIDNIGHT_GREY, ColorPalette.COLOR_BACKGROUND_SECONDARY);
        assertEquals(ColorPalette.MEDIUM_GREY, ColorPalette.COLOR_BACKGROUND_TERTIARY);

        assertEquals(ColorPalette.PURPLE, ColorPalette.COLOR_ACCENT_PRIMARY);
        assertEquals(ColorPalette.PALE_PURPLE, ColorPalette.COLOR_ACCENT_SECONDARY);

        // APPLICATION
        assertEquals(ColorPalette.SOFT_BLUE, ColorPalette.COLOR_SQUARE_WHITE);
        assertEquals(ColorPalette.CLOUDY_BLUE, ColorPalette.COLOR_SQUARE_BLACK);
        assertEquals(ColorPalette.COLOR_ACCENT_PRIMARY, ColorPalette.COLOR_SQUARE_ACTIVE);

        assertEquals(ColorPalette.FOG_WHITE, ColorPalette.COLOR_PIECE_WHITE);
        assertEquals(ColorPalette.MIDNIGHT_BLUE, ColorPalette.COLOR_PIECE_BLACK);
    }

    @Test
    void testPrivateConstructor() throws Exception {
        Constructor<ColorPalette> constructor = ColorPalette.class.getDeclaredConstructor();
        assertFalse(constructor.canAccess(null)); // Verify it's not accessible by default

        constructor.setAccessible(true); // Make it accessible for the test

        // Invoke the constructor to check if it creates an instance
        ColorPalette instance = constructor.newInstance();
        assertNotNull(instance); // Ensure an instance is created

        // Verify that the instance is not publicly accessible (e.g., by enforcing private instantiation logic)
        assertEquals(ColorPalette.class, instance.getClass()); // Ensure it's of the right type
    }

}