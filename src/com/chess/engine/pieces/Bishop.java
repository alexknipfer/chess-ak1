package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class represents a single Bishop on the chess board.
 *
 * @author Alex Knipfer
 *
 */


public class Bishop extends Piece {

    private final static int[] CANDIDATE_MOVE_VECTOR_COORDINATES = { -9, -7, 7, 9 };


    Bishop(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }


    /**
     * This method calculates the legal moves of any given bishop
     *
     * @param board the current chess board
     * @return collection of legal moves for the Bishop
     */

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {

        final List<Move> legalMoves = new ArrayList<>();

            //loop through vectors of possible valid moves of a bishop
        for(final int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDINATES) {

            int candidateDestinationCoordinate = this.piecePosition;

            while(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {

                    //check to see if bishop is in the first or eighth column
                if(isFirstColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset) ||
                        isEightColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset)) {
                    break;
                }

                    //apply offset
                candidateDestinationCoordinate += candidateCoordinateOffset;

                    //check if the tile "moving too" is a valid coordinate
                if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {

                    final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                        //check to see if destination tile does not have a piece on it
                    if(!candidateDestinationTile.isTileOccupied()) {
                        legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
                    }

                        //destination tile HAS a piece on it (occupied)
                    else {
                        final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                        final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

                        //check to see if occupied piece is of opposite color
                        if(this.pieceAlliance != pieceAlliance) {
                            legalMoves.add(new Move.AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                        }
                        break;
                    }
                }
            }
        }

        return ImmutableList.copyOf(legalMoves);
    }

    /**
     * This method checks to see if the current bishop is in the first column.
     * If so, check to see if the offset is legal (i.e within the board bounds).
     *
     * @param currentPosition current position of bishop
     * @param candidateOffset the offset in which the piece is moving to
     * @return true if move is illegal due to exclusion
     */

    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -9 || candidateOffset == 7);
    }

    /**
     * This method checks to see if the current bishop is in the eighth column.
     * If so, check to see if the offset is legal (i.e within the board bounds).
     *
     * @param currentPosition current position of bishop
     * @param candidateOffset the offset in which the piece is moving to
     * @return true if the move is illegal due to exclusion
     */
    private static boolean isEightColumnExclusion(final int currentPosition, final int candidateOffset) {
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidateOffset == -7 || candidateOffset == 9);
    }

}
