package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 12/10/16.
 */
public class Knight extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 15, 17};

    Knight(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {

        int candidateDestinationCoordinate;
        final List<Move> legalMoves = new ArrayList<>();        //list to obtain all legal move of current knight

            //go through all possible candidate moves of a knight
        for(final int currentCandidate : CANDIDATE_MOVE_COORDINATES) {

                //get the current candidate destination current
            candidateDestinationCoordinate = this.piecePosition + currentCandidate;

                //check to see if tile is valid (i.e inside the board coordinates)
            if(true /* isValidTileCoordinate */) {

                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                    //check to see if destination tile does not have a piece on it
                if(!candidateDestinationTile.isTileOccupied()) {
                    legalMoves.add(new Move());
                }

                    //destination tile HAS a piece on it (occupied)
                else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

                        //check to see if occupied piece is of opposite color
                    if(this.pieceAlliance != pieceAlliance) {
                        legalMoves.add(new Move());
                    }
                }
            }

        }

            //return the list of all legal moves for current knight
        return ImmutableList.copyOf(legalMoves);
    }

}
