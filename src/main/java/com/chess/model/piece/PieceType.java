package com.chess.model.piece;

import com.chess.movement.*;
import lombok.Getter;

import javax.swing.ImageIcon;

import static com.chess.utils.ImageManager.*;

@Getter
public enum PieceType {
    ROOK    ("Rook",    IMG_WHITE_ROOK,     IMG_BLACK_ROOK,      new RookMovement()     ),
    BISHOP  ("Bishop",  IMG_WHITE_BISHOP,   IMG_BLACK_BISHOP,    new BishopMovement()   ),
    KNIGHT  ("Knight",  IMG_WHITE_KNIGHT,   IMG_BLACK_KNIGHT,    new KnightMovement()   ),
    QUEEN   ("Queen",   IMG_WHITE_QUEEN,    IMG_BLACK_QUEEN,     new QueenMovement()    ),
    KING    ("King",    IMG_WHITE_KING,     IMG_BLACK_KING,      new KingMovement()     ),
    PAWN    ("Pawn",    IMG_WHITE_PAWN,     IMG_BLACK_PAWN,      new PawnMovement()     );

    private final String name;
    private final ImageIcon whiteImage;
    private final ImageIcon blackImage;
    private final MovementStrategy movementStrategy;

    PieceType(String name, ImageIcon whiteImage, ImageIcon blackImage, MovementStrategy movementStrategy) {
        this.name = name;
        this.whiteImage = whiteImage;
        this.blackImage = blackImage;
        this.movementStrategy = movementStrategy;
    }

    public ImageIcon getImage(PieceColor color) {
        return (color == PieceColor.WHITE) ? whiteImage : blackImage;
    }

}