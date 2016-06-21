package com.scoquard.mowitnow.farm;

import com.scoquard.mowitnow.core.IGarden;
import com.scoquard.mowitnow.core.IMower;

import java.util.List;

/**
 * The garden to be mowed
 *
 * Created by scoquard on 17/06/2016.
 */
public class Garden implements IGarden {

    private Dimensions dimensions;
    private List<IMower> mowers;

    /**
     * Setting up the fences and the mowers
     * @param dimensions dimensions of the garden
     * @param mowers mowers in the garden
     */
    public Garden(Dimensions dimensions, List<IMower> mowers) {
        this.dimensions = dimensions;
        this.mowers = mowers;
    }

    @Override
    public Dimensions getDimensions() {
        return dimensions;
    }

    @Override
    public List<IMower> getMowers() {
        return mowers;
    }

    /**
     * Mow this garden
     */
    @Override
    public void mow() {
        for (IMower mower : getMowers()) {
            mower.printPosition();
            mower.useThis(getDimensions());
            mower.printPosition();
        }
    }
}
