package escape.board.coordinates;

import escape.required.Coordinate;

import java.util.Objects;

/**
 * CoordinateImpl used with BFS
 */
public class CoordinateImpl implements Coordinate {
    private int x;
    private int y;
    private int hashCode;
    private int depth;

    /**
     * Constructor for CoordinateImpl, sets the x and y values
     *
     * @param row
     * @param column
     */
    public CoordinateImpl(int row, int column) {
        this.x = row;
        this.y = column;
        this.hashCode = Objects.hash(x, y);

    }
    public CoordinateImpl(int row, int column, int depth) {
        this.x = row;
        this.y = column;
        this.hashCode = Objects.hash(x, y);
        this.depth = depth;

    }
    @Override
    public int hashCode() {
        return this.hashCode;
    }

    /*
     * IMPORTANT: Override the equals(Coordinate other) method in your implementation so that two
     * Coordinates with the same row and column are equal.
     */
    @Override public boolean equals(Coordinate other) {
        if (this == other) return true;
        return this.x == other.getRow() && this.y == other.getColumn();
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate that)) return false;
        return getRow() == that.getRow() && getColumn() == that.getColumn() ;

    }
    /**
     * @return the row component of the Coordinate
     */
    public int getRow() {
        return x;
    }

    /**
     * @return the column component of the Coordinate
     */
    public int getColumn() {
        return y;
    }
    public int getDepth() {
        return this.depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }

}
