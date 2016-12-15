package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

/**
 * Represents a single move on the chess board.
 *
 * @author Alex Knipfer
 *
 */
public abstract class Move {

    final Board board;
    final Piece movedPiece;
    final int destinationCoordinate;

    /**
     * Constructor
     *
     * @param board sets the current board
     * @param movedPiece the current piece to be moved
     * @param destinationCoordinate the tile (coordinate) in which the piece is moving to
     */
    private Move(final Board board, final Piece movedPiece, final int destinationCoordinate) {
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }

    /**
     * Represents a move to an unoccupied tile (square)
     */
    public static final class MajorMove extends Move {

        /**
         * Constructor
         *
         * @param board sets the current board
         * @param movedPiece the current piece to be moved
         * @param destinationCoordinate the tile (coordinate) in which the piece is moving to
         */
        public MajorMove(final Board board, final Piece movedPiece, final int destinationCoordinate) {
            super(board, movedPiece, destinationCoordinate);
        }

    }

    /**
     * Represents a move to an occupied tile (square)
     */
    public static final class AttackMove extends Move {

        final Piece attackedPiece;

        /**
         * Constructor
         *
         * @param board sets the current board
         * @param movedPiece the current piece to be moved
         * @param destinationCoordinate the tile (coordinate) in which the piece is moving to
         * @param attackedPiece the piece being attacked
         */
        public AttackMove(final Board board, final Piece movedPiece, final int destinationCoordinate, final Piece attackedPiece) {
            super(board, movedPiece, destinationCoordinate);
            this.attackedPiece = attackedPiece;
        }

    }

}
