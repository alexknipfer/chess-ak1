package com.chess.engine.board;

/**
 * This class contains board utilities for individual pieces. For many pieces
 * it necessary to check the columns for any exclusions the piece may have when
 * moving.
 *
 * @author Alex Knipfer
 *
 */

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = initColumn(0);
    public static final boolean[] SECOND_COLUMN = initColumn(1);
    public static final boolean[] SEVENTH_COLUMN = initColumn(6);
    public static final boolean[] EIGHTH_COLUMN = initColumn(7);

    public static final int NUM_TILES = 64;
    public static final int NUM_TILES_PER_ROW = 8;

    /**
     * Constructor
     *
     * @throws Runtime Exception
     *
     */
    private BoardUtils() {
        throw new RuntimeException("You cannot instantiate me!");
    }

    /**
     * Initializes the current column of piece. "Turns on" all the values
     * of the current column in the chess board.
     *
     * @param columnNumber the current column number of the piece
     * @return column array of
     *
     */
    private static boolean[] initColumn(int columnNumber) {

        final boolean[] column = new boolean[NUM_TILES];

        do {
            column[columnNumber] = true;
            columnNumber += NUM_TILES_PER_ROW;
        } while(columnNumber < NUM_TILES); {
            return column;
        }

    }

    /**
     * Ensures the piece is attempting to move to valid coordinate
     * within a chess board.
     *
     * @param coordinate current coordinate of the piece
     * @return true if the piece lies within the chess board
     */
    public static boolean isValidTileCoordinate(final int coordinate) {
        return coordinate >= 0 && coordinate < NUM_TILES_PER_ROW;
    }
}
