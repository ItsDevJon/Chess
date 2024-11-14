package com.chess;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;
import static org.easymock.EasyMock.*;

class MouseHandlerTest {

    private MouseHandler mouseHandler;
    private MouseEvent mockEvent;

    @BeforeEach
    void setUp() {
        mouseHandler = new MouseHandler();
        mockEvent = EasyMock.createMock(MouseEvent.class);
    }

    @Test
    void mouseClicked_firstClick_setsFromCoordinatesAndSelectedTrue() {
        // Set expectations for the first click event
        expect(mockEvent.getX()).andReturn(100);
        expect(mockEvent.getY()).andReturn(200);
        replay(mockEvent);

        // Perform the mouse click
        mouseHandler.mouseClicked(mockEvent);

        // Verify expectations and check the state
        verify(mockEvent);
        assertEquals(100, mouseHandler.xFrom);
        assertEquals(200, mouseHandler.yFrom);
        assertTrue(mouseHandler.selected);
        assertFalse(mouseHandler.clicked);
    }

    @Test
    void mouseClicked_secondClick_setsToCoordinatesAndClickedTrue() {
        // Set expectations for the first click event (sets from coordinates)
        expect(mockEvent.getX()).andReturn(100);
        expect(mockEvent.getY()).andReturn(200);
        replay(mockEvent);

        // First click to set from coordinates
        mouseHandler.mouseClicked(mockEvent);

        // Reset mock for the second click
        reset(mockEvent);

        // Set expectations for the second click event (sets to coordinates)
        expect(mockEvent.getX()).andReturn(300);
        expect(mockEvent.getY()).andReturn(400);
        replay(mockEvent);

        // Perform the second mouse click
        mouseHandler.mouseClicked(mockEvent);

        // Verify expectations and check the state
        verify(mockEvent);
        assertEquals(300, mouseHandler.xTo);
        assertEquals(400, mouseHandler.yTo);
        assertTrue(mouseHandler.clicked);
        assertFalse(mouseHandler.selected);
    }

    @Test
    void mouseClicked_alternatesFromToTurnstale() {
        // Set expectations for two clicks
        expect(mockEvent.getX()).andReturn(100).times(2);
        expect(mockEvent.getY()).andReturn(200).times(2);
        replay(mockEvent);

        // First click: toggles fromToTurnstale to false
        mouseHandler.mouseClicked(mockEvent);
        assertFalse(mouseHandler.fromToTurnstale);

        // Second click: toggles fromToTurnstale back to true
        mouseHandler.mouseClicked(mockEvent);
        assertTrue(mouseHandler.fromToTurnstale);

        // Verify expectations
        verify(mockEvent);
    }

    @Test
    void mousePressed_noAction() {
        // Call mousePressed and verify no state change occurs
        mouseHandler.mousePressed(mockEvent);
        assertFalse(mouseHandler.clicked);
        assertFalse(mouseHandler.selected);
    }

    @Test
    void mouseReleased_noAction() {
        // Call mouseReleased and verify no state change occurs
        mouseHandler.mouseReleased(mockEvent);
        assertFalse(mouseHandler.clicked);
        assertFalse(mouseHandler.selected);
    }

    @Test
    void mouseEntered_noAction() {
        // Call mouseEntered and verify no state change occurs
        mouseHandler.mouseEntered(mockEvent);
        assertFalse(mouseHandler.clicked);
        assertFalse(mouseHandler.selected);
    }

    @Test
    void mouseExited_noAction() {
        // Call mouseExited and verify no state change occurs
        mouseHandler.mouseExited(mockEvent);
        assertFalse(mouseHandler.clicked);
        assertFalse(mouseHandler.selected);
    }
}
