package com.chess.model;

import com.chess.model.piece.Piece;
import com.chess.model.piece.PieceColor;
import com.chess.model.piece.PieceType;
import lombok.Getter;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Getter
public class GameState {

    private static final Logger LOGGER = Logger.getLogger(GameState.class.getName());

    private final Board board;
    private PieceColor currentTurn;
    private boolean isCheck;
    private boolean isGameOver;

    public GameState(Board board) {
        this.board = board;
        this.currentTurn = PieceColor.WHITE;
        this.isCheck = false;
        this.isGameOver = false;
    }

    /**
     * Handles a move and updates the game state.
     *
     * @param from The starting position.
     * @param to   The target position.
     * @return true if the move was successful; false otherwise.
     */
    public boolean makeMove(Position from, Position to) {

        Piece movingPiece = board.getPiece(from);

        // Check if it's the player's turn
        if (movingPiece == null || movingPiece.getPieceColor() != currentTurn) return false;

        board.movePiece(from, to);

        updateGameStatus();

        switchTurn();

        return true;
    }

    /**
     * Updates the state of the game (check, checkmate, etc.).
     */
    private void updateGameStatus() {
        // Placeholder for logic to determine check, checkmate, or stalemate
        isCheck = isKingInCheck(currentTurn.getOpposite());
        isGameOver = isCheckmate(currentTurn.getOpposite()) || isStalemate();

        if (isCheck) {
            LOGGER.info("Check!");
        }

    }

    /**
     * Switches the current turn to the opposite player.
     */
    private void switchTurn() {
        currentTurn = currentTurn.getOpposite();
    }

    public boolean isCheck() {
        return isCheck;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    /**
     * Determines if the king of the specified color is in check.
     *
     * @param kingColor The color to check.
     * @return true if the king is in check; false otherwise.
     */
    private boolean isKingInCheck(PieceColor kingColor) {

        // Find the king of the specified kingColor
        Optional<Piece> optionalKing = board.findPiece(PieceType.KING, kingColor);

        if (optionalKing.orElse(null) instanceof Piece king) {

            return board.getPieceGrid().getElements().stream().flatMap(List::stream).anyMatch(piece -> {

                if (piece != null && piece.getPieceColor() != kingColor) {
                    return piece.isValidMove(piece.getPosOnBoard(), king.getPosOnBoard(), board);
                }

                return false;

            });

        }

        return false;

    }

    /**
     * Determines if the specified color is in checkmate.
     *
     * @param color The color to check.
     * @return true if the color is in checkmate; false otherwise.
     */
    private boolean isCheckmate(PieceColor color) {
        // Placeholder: Logic to determine checkmate
        return false;
    }

    /**
     * Determines if the game is in a stalemate state.
     *
     * @return true if the game is a stalemate; false otherwise.
     */
    private boolean isStalemate() {
        // Placeholder: Logic to determine stalemate
        return false;
    }

}
