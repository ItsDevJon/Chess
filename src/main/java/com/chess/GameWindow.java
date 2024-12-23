package com.chess;

import com.chess.utils.ColorPalette;
import com.chess.view.ChessBoardView;
import lombok.Getter;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@Getter
public class GameWindow extends JFrame {

    private ChessBoardView boardView;

    public GameWindow() {

        boardView = new ChessBoardView();
        boardView.setBackground(ColorPalette.DARK_GREY);

        setTitle("Simple Chess Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(boardView);
        setVisible(true);

    }

}