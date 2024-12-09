package com.chess.view;

import com.chess.model.Position;
import com.chess.model.piece.Piece;
import com.chess.utils.Grid;
import com.chess.view.components.ButtonVariant;
import com.chess.view.components.GameButton;
import lombok.Getter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.stream.IntStream;

import static com.chess.utils.ColorPalette.COLOR_SQUARE_WHITE;

@Getter
public class ChessBoardView extends JPanel {

    private final transient Grid<GameButton> squares = new Grid<>(8, 8, null);

    public ChessBoardView() {
        setLayout(new GridLayout(8, 8));
        setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        createBoard();
    }

    private void createBoard() {

        squares.forEach((position, btn) -> {

            ButtonVariant variant = position.getSquareColor() == COLOR_SQUARE_WHITE
                    ? ButtonVariant.SQUARE_WHITE
                    : ButtonVariant.SQUARE_BLACK;

            GameButton button = new GameButton("", variant);

            squares.set(position, button);

            add(button); // This adds the button to the panel

        });

    }

    public void updateBoard(Grid<Piece> board) {

        IntStream.range(0, 8).forEach(row -> IntStream.range(0, 8).forEach(col -> updateSquare(board, Position.of(row, col))));

    }

    private void updateSquare(Grid<Piece> board, Position pos) {

        Piece piece = board.get(pos);
        GameButton button = squares.get(pos);

        if (piece != null) {
            button.setIcon(piece.getImage());
        }
        else {
            button.setIcon(null);
        }

    }

}