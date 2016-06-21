package com.scoquard.mowitnow;

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
     * returns the cardinal point on the right-hand-side of
     * the current cardinal point
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
     * returns the cardinal point on the left-hand-side of
     * the current cardinal point
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
