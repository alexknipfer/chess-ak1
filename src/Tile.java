/**
 * Created by alex on 12/8/16.
 */
public abstract class Tile {

    int tileCoordinate;

        //give the tile an initial coordinate
    Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

        //represents a tile without a piece
    public static final class EmptyTile extends Tile{

        EmptyTile(int coordinate) {
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


}
