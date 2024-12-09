package com.chess;

import com.chess.model.Board;
import com.chess.model.GameState;
import com.chess.viewmodel.ChessViewModel;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        board.placePieces();

        GameState gameState = new GameState(board);
        GameWindow gameWindow = new GameWindow();

        new ChessViewModel(gameState, gameWindow.getBoardView());

    }

}
