package com.chess.viewmodel;

import com.chess.model.GameState;
import com.chess.model.Position;
import com.chess.model.piece.Piece;
import com.chess.utils.Grid;
import com.chess.view.ChessBoardView;
import com.chess.view.components.GameButton;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class ChessViewModel {

    private static final Logger LOGGER = Logger.getLogger(ChessViewModel.class.getName());

    private final GameState gameState;
    private final ChessBoardView view;

    private Position fromSquare = null;

    public ChessViewModel(GameState gameState, ChessBoardView view) {
        this.gameState = gameState;
        this.view = view;

        initListeners();

        view.updateBoard(gameState.getBoard().getPieces());
    }

    private void initListeners() {

        gameState.getBoard().addPropertyChangeListener(evt -> this.view.updateBoard((Grid<Piece>) evt.getNewValue()));

        Grid<GameButton> squares = view.getSquares();
        IntStream.range(0, 8).forEach(row -> IntStream.range(0, 8).forEach(col -> {

            final Position position = Position.of(row, col);

            squares.get(position).addActionListener(e -> handleSquareClick(position));

        }));

    }

    private void handleSquareClick(Position position) {

        if (fromSquare == null) {
            fromSquare = position;
            LOGGER.log(Level.INFO, "From\t {0}", fromSquare);
        }
        else {
            LOGGER.log(Level.INFO, "To\t {0}", position);
            gameState.makeMove(fromSquare, position);
            fromSquare = null;
        }

    }

}