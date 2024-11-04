package com.chess;

import org.easymock.EasyMock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private GamePanel mockGamePanel;
    private Board board;
    private Graphics2D mockGraphics;

    @BeforeEach
    void setUp() {
        mockGamePanel = EasyMock.createMock(GamePanel.class);

        EasyMock.replay(mockGamePanel);

        board = new Board(mockGamePanel);

        mockGraphics = EasyMock.createMock(Graphics2D.class);
    }

    @Test
    void testConstructor() {
        assertEquals(mockGamePanel, board.gp);
    }

    @Test
    void chessInit() {
        board.chessInit();
        System.out.println("Chess initialization test passed.");
    }

    @Test
    void drawBoard() {
        boolean isBlack = true;
        for (int y = 0; y < Board.totalCol; y++) {
            for (int x = 0; x < Board.totalRow; x++) {
                mockGraphics.setColor(isBlack ? Color.BLACK : Color.WHITE);
                EasyMock.expectLastCall().once();

                mockGraphics.fillRect(
                        x * mockGamePanel.tileSize,
                        y * mockGamePanel.tileSize,
                        mockGamePanel.tileSize,
                        mockGamePanel.tileSize
                );
                EasyMock.expectLastCall().once();

                isBlack = !isBlack;
            }
            isBlack = !isBlack;
        }

        EasyMock.replay(mockGraphics);

        board.drawBoard(mockGraphics);

        EasyMock.verify(mockGraphics);

    }
}