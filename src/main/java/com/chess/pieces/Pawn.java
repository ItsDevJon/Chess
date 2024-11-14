package com.chess.pieces;

import com.chess.Board;

public class Pawn extends Piece{
    boolean firstMove = true;

    public Pawn(COLOR color, int y, int x) {
        super(TYPE.PAWN, color, y, x);
    }
    @Override
	public boolean move(Board board, int xTo, int yTo) {
		boolean returnValue = false;
		if (this.color == COLOR.BLACK) {
			switch (getElectedCords(xTo, yTo)) {
				case NW:
				returnValue = verifyAndMovePiece(board, xTo, yTo, -1, -1, true, true);
				break;
				case N:
					returnValue = verifyAndMovePiece(board, xTo, yTo, 0, -1, false, false);
					break;
					case NE:
						returnValue = verifyAndMovePiece(board, xTo, yTo, 1, -1, true, true);
						break;
				default:
					return returnValue;
			}
		} else {
			switch (getElectedCords(xTo, yTo)) {
				case SW:
					returnValue = verifyAndMovePiece(board, xTo, yTo, -1, 1, true, true);
					break;
				case S:
					returnValue = verifyAndMovePiece(board, xTo, yTo, 0, 1, false, false);
					break;
				case SE:
					returnValue = verifyAndMovePiece(board, xTo, yTo, 1, 1, true, true);
					break;
				default:
					return returnValue;
			}
		}
		return returnValue;
	}
    
}



