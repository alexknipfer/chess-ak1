package com.chess.engine.board;

/**
 * Created by alex on 12/8/16.
 */

import com.chess.engine.pieces.Piece;

public abstract class Tile {

        //only allow tile coordinate to be set in constructor
    protected final int tileCoordinate;

        //give the tile an initial coordinate
    Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

        //represents a tile without a piece
    public static final class EmptyTile extends Tile {

        EmptyTile(final int coordinate) {
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }

    }

        //represents a tile with a piece placed
    public static final class OccupiedTile extends Tile {

            //only allow piece to be set in constructor
        private final Piece pieceOnTile;

            //place the coordinate and the piece on the tile
        OccupiedTile(int tileCoordinate, Piece pieceOnTile) {
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }

    }

}
