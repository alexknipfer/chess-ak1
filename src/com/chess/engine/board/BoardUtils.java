package com.chess.engine.board;

/**
 * Created by alex on 12/11/16.
 */
public class BoardUtils {

    private BoardUtils() {
        throw new RuntimeException("You cannot instantiate me!");
    }

        //check to see if move is valid (i.e is within board bounds)
    public static boolean isValidTileCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < 64;
    }
}
