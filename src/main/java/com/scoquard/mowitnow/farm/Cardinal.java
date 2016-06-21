package com.scoquard.mowitnow.farm;

import java.util.Arrays;
import java.util.List;

/**
 * Cardinal points
 */
public enum Cardinal {
    N, /**NORTH*/
    E, /**EAST*/
    S, /**SOUTH*/
    W; /**WEST*/

    /**
     * rotates the mower to the right
     * @return new orientation
     */
    public Cardinal rotateRight() {
        List<Cardinal> values = Arrays.asList(Cardinal.values());
        int currentIndex = values.indexOf(this);
        if (currentIndex < values.size() - 1) {
            return values.get(currentIndex + 1);
        } else {
            return values.get(0);
        }
    }

    /**
     * rotates the mower to the light
     * @return new orientation
     */
    public Cardinal rotateLeft() {
        List<Cardinal> values = Arrays.asList(Cardinal.values());
        int currentIndex = values.indexOf(this);
        if (currentIndex > 0) {
            return values.get(currentIndex - 1);
        } else {
            return values.get(values.size() - 1);
        }
    }
}
