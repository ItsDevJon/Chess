package com.chess;

import com.chess.utils.ColorPalette;
import org.junit.jupiter.api.Test;

import javax.swing.WindowConstants;

import static org.junit.jupiter.api.Assertions.*;

class GameWindowTest {

    @Test
    void constructor_InitializesComponentsCorrectly() {

        // ACT
        GameWindow gameWindow = new GameWindow();


        // ASSERT
        String expectedTitle = "Simple Chess Game";
        int expectedWidth = 800;
        int expectedHeight = 800;
        int expectedCloseOperation = WindowConstants.EXIT_ON_CLOSE;

        String actualTitle = gameWindow.getTitle();
        int actualWidth = gameWindow.getWidth();
        int actualHeight = gameWindow.getHeight();
        int actualCloseOperation = gameWindow.getDefaultCloseOperation();

        // Verify JFrame properties
        assertEquals(expectedTitle, actualTitle, "Title should be set correctly");
        assertEquals(expectedWidth, actualWidth, "Width should be set to 800");
        assertEquals(expectedHeight, actualHeight, "Height should be set to 800");
        assertEquals(expectedCloseOperation, actualCloseOperation, "Default close operation should be EXIT_ON_CLOSE");

        assertFalse(gameWindow.isResizable(), "Game window should not be resizable");
        assertTrue(gameWindow.isVisible(), "Game window should be visible");

        // Verify content pane is set to boardView
        assertNotNull(gameWindow.getBoardView(), "ChessBoardView should be initialized");
        assertSame(gameWindow.getBoardView(), gameWindow.getContentPane(), "Content pane should be set to ChessBoardView");

        // Verify ChessBoardView properties
        assertEquals(ColorPalette.DARK_GREY, gameWindow.getBoardView().getBackground(), "Background color of ChessBoardView should be DARK_GREY");

    }

}