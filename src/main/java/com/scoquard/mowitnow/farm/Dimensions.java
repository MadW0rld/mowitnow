package com.scoquard.mowitnow.farm;

/**
 * Dimensions of the garden
 *
 * Created by scoquard on 17/06/2016.
 */
public class Dimensions {

    private int x;
    private int y;

    /**
     * Constructs the dimensions of the garden
     * @param x width
     * @param y height
     */
    public Dimensions(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Checks whether two dimensions objects have equal values.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dimensions) {
            Dimensions d = (Dimensions) obj;
            return (x == d.x) && (y == d.y);
        }
        return false;
    }

    /**
     * Returns the hash code for this Dimensions.
     *
     * @return a hash code for this Dimensions
     */
    @Override
    public int hashCode() {
        int sum = x + y;
        return sum * (sum + 1)/2 + x;
    }
}
