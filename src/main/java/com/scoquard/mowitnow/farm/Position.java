package com.scoquard.mowitnow.farm;

/**
 * Position of the mower in the garden
 *
 * Created by scoquard on 19/06/2016.
 */
public class Position {

    private int x;
    private int y;
    private Cardinal orientation;

    /**
     * Creates a new position with coordinates and orientation
     *
     * @param x horizontal position
     * @param y vertical position
     * @param orientation according to cardinal direction
     */
    public Position(final int x, final int y, final Cardinal orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cardinal getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + ", " + orientation.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position position = (Position) o;

        return x == position.x && y == position.y && orientation == position.orientation;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (orientation != null ? orientation.hashCode() : 0);
        return result;
    }
}
