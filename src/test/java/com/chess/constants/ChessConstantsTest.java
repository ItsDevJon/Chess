package com.chess.constants;

import com.chess.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessConstantsTest {

    @Test
    void testChessConstants() {
        assertEquals(ChessConstants.A8, Position.of(0, 0));
    } 

}