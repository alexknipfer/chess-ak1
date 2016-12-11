package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.List;

/**
 * Created by alex on 12/8/16.
 */
public abstract class Piece {

    protected final int piecePosition;
    protected final Alliance pieceAlliance;

        //set the piece position and color (alliance)
    Piece(final int piecePosition, final Alliance pieceAlliance) {
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
    }

        //create a lsit of all legal moves for any given piece
    public abstract List<Move> calculateLegalMoves(final Board board);

}
