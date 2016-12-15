package com.chess.engine.board;

/**
 * A representation of a single tile on a chess board.
 *
 * @author Alex Knipfer
 */

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

        //only allow tile coordinate to be set in constructor
    protected final int tileCoordinate;

    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

        //give the tile an initial coordinate
    private Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    /**
     * Creates a tile if valid.
     *
     * @param tileCoordinate location of tile on chess board
     * @param piece piece on the tile
     * @return the current tile
     */
    public static Tile createTile(final int tileCoordinate, final Piece piece) {
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

    /**
     * Creates a map of tiles representing the chess board.
     *
     * @return an immutable copy of the tile map (representing the chess board)
     */
    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {

        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

            //place empty tiles
        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }

            //return a immutable copy so tiles can't be changed
        return ImmutableMap.copyOf(emptyTileMap);

    }

    /**
     * A class representing a tile with no piece.
     */
    public static final class EmptyTile extends Tile {

        /**
         * Constructor
         *
         * @param coordinate single coordinate representing tile location
         */
        private EmptyTile(final int coordinate) {
            super(coordinate);
        }

        /**
         * Tile is not occupied by a piece.
         *
         * @return false
         */
        @Override
        public boolean isTileOccupied() {
            return false;
        }

        /**
         * Tile currently has no piece.
         *
         * @return null
         */
        @Override
        public Piece getPiece() {
            return null;
        }

    }

    /**
     * A class representing a tile with a piece.
     */
    public static final class OccupiedTile extends Tile {

            //only allow piece to be set in constructor
        private final Piece pieceOnTile;

        /**
         * Constructor
         *
         * @param tileCoordinate single coordinate representing tile location
         * @param pieceOnTile the piece to be placed on the tile
         */
        private OccupiedTile(int tileCoordinate, Piece pieceOnTile) {
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        /**
         * The tile is currently occupied by a piece.
         *
         * @return true
         */
        @Override
        public boolean isTileOccupied() {
            return true;
        }

        /**
         * Gets the piece on the current tile.
         *
         * @return the piece on the tile
         */
        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }

    }

}
