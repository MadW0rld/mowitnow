package com.scoquard.mowitnow.farm;

import java.util.List;

/**
 * The garden to be mowed
 *
 * Created by scoquard on 17/06/2016.
 */
public class Garden {

    private Dimensions dimensions;
    private List<Mower> mowers;

    /**
     * Setting up the fences and the mowers
     * @param dimensions dimensions of the garden
     * @param mowers mowers in the garden
     */
    public Garden(Dimensions dimensions, List<Mower> mowers) {
        this.dimensions = dimensions;
        this.mowers = mowers;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    /**
     * Mow this garden
     */
    public void mow() {
        for (Mower mower : getMowers()) {
            mower.printPosition();
            mower.useThis(getDimensions());
            mower.printPosition();
        }
    }
}
